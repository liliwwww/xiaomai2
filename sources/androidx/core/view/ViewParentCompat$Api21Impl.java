package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewParentCompat$Api21Impl {
    private ViewParentCompat$Api21Impl() {
    }

    @DoNotInline
    static boolean onNestedFling(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return viewParent.onNestedFling(view, f, f2, z);
    }

    @DoNotInline
    static boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f2) {
        return viewParent.onNestedPreFling(view, f, f2);
    }

    @DoNotInline
    static void onNestedPreScroll(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        viewParent.onNestedPreScroll(view, i, i2, iArr);
    }

    @DoNotInline
    static void onNestedScroll(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        viewParent.onNestedScroll(view, i, i2, i3, i4);
    }

    @DoNotInline
    static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i) {
        viewParent.onNestedScrollAccepted(view, view2, i);
    }

    @DoNotInline
    static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i) {
        return viewParent.onStartNestedScroll(view, view2, i);
    }

    @DoNotInline
    static void onStopNestedScroll(ViewParent viewParent, View view) {
        viewParent.onStopNestedScroll(view);
    }
}
