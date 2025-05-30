package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class FragmentManager$PopBackStackState implements FragmentManager$OpGenerator {
    final int mFlags;
    final int mId;
    final String mName;
    final /* synthetic */ FragmentManager this$0;

    FragmentManager$PopBackStackState(@Nullable FragmentManager fragmentManager, String str, int i, int i2) {
        this.this$0 = fragmentManager;
        this.mName = str;
        this.mId = i;
        this.mFlags = i2;
    }

    @Override // androidx.fragment.app.FragmentManager$OpGenerator
    public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        Fragment fragment = this.this$0.mPrimaryNav;
        if (fragment == null || this.mId >= 0 || this.mName != null || !fragment.getChildFragmentManager().popBackStackImmediate()) {
            return this.this$0.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
        }
        return false;
    }
}
