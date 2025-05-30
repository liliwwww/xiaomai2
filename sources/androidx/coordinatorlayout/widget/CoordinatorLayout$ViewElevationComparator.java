package androidx.coordinatorlayout.widget;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class CoordinatorLayout$ViewElevationComparator implements Comparator<View> {
    CoordinatorLayout$ViewElevationComparator() {
    }

    @Override // java.util.Comparator
    public int compare(View view, View view2) {
        float z = ViewCompat.getZ(view);
        float z2 = ViewCompat.getZ(view2);
        if (z > z2) {
            return -1;
        }
        return z < z2 ? 1 : 0;
    }
}
