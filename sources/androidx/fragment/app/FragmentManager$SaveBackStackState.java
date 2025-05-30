package androidx.fragment.app;

import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class FragmentManager$SaveBackStackState implements FragmentManager$OpGenerator {
    private final String mName;
    final /* synthetic */ FragmentManager this$0;

    FragmentManager$SaveBackStackState(@NonNull FragmentManager fragmentManager, String str) {
        this.this$0 = fragmentManager;
        this.mName = str;
    }

    @Override // androidx.fragment.app.FragmentManager$OpGenerator
    public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        return this.this$0.saveBackStackState(arrayList, arrayList2, this.mName);
    }
}
