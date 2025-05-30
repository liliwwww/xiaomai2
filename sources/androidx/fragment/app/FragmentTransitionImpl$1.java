package androidx.fragment.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FragmentTransitionImpl$1 implements Runnable {
    final /* synthetic */ FragmentTransitionImpl this$0;
    final /* synthetic */ ArrayList val$inNames;
    final /* synthetic */ int val$numSharedElements;
    final /* synthetic */ ArrayList val$outNames;
    final /* synthetic */ ArrayList val$sharedElementsIn;
    final /* synthetic */ ArrayList val$sharedElementsOut;

    FragmentTransitionImpl$1(FragmentTransitionImpl fragmentTransitionImpl, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.this$0 = fragmentTransitionImpl;
        this.val$numSharedElements = i;
        this.val$sharedElementsIn = arrayList;
        this.val$inNames = arrayList2;
        this.val$sharedElementsOut = arrayList3;
        this.val$outNames = arrayList4;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.val$numSharedElements; i++) {
            ViewCompat.setTransitionName((View) this.val$sharedElementsIn.get(i), (String) this.val$inNames.get(i));
            ViewCompat.setTransitionName((View) this.val$sharedElementsOut.get(i), (String) this.val$outNames.get(i));
        }
    }
}
