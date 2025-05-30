package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FragmentManager$10 implements ActivityResultCallback<Map<String, Boolean>> {
    final /* synthetic */ FragmentManager this$0;

    FragmentManager$10(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    @SuppressLint({"SyntheticAccessor"})
    public void onActivityResult(Map<String, Boolean> map) {
        String[] strArr = (String[]) map.keySet().toArray(new String[0]);
        ArrayList arrayList = new ArrayList(map.values());
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
        }
        FragmentManager.LaunchedFragmentInfo launchedFragmentInfo = (FragmentManager.LaunchedFragmentInfo) this.this$0.mLaunchedFragments.pollFirst();
        if (launchedFragmentInfo == null) {
            Log.w("FragmentManager", "No permissions were requested for " + this);
            return;
        }
        String str = launchedFragmentInfo.mWho;
        int i2 = launchedFragmentInfo.mRequestCode;
        Fragment findFragmentByWho = FragmentManager.access$200(this.this$0).findFragmentByWho(str);
        if (findFragmentByWho != null) {
            findFragmentByWho.onRequestPermissionsResult(i2, strArr, iArr);
            return;
        }
        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
    }
}
