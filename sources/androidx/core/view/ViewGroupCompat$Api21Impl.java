package androidx.core.view;

import android.view.ViewGroup;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewGroupCompat$Api21Impl {
    private ViewGroupCompat$Api21Impl() {
    }

    @DoNotInline
    static int getNestedScrollAxes(ViewGroup viewGroup) {
        return viewGroup.getNestedScrollAxes();
    }

    @DoNotInline
    static boolean isTransitionGroup(ViewGroup viewGroup) {
        return viewGroup.isTransitionGroup();
    }

    @DoNotInline
    static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
        viewGroup.setTransitionGroup(z);
    }
}
