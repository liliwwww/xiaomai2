package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewCompat$Api19Impl {
    private ViewCompat$Api19Impl() {
    }

    @DoNotInline
    static int getAccessibilityLiveRegion(View view) {
        return view.getAccessibilityLiveRegion();
    }

    @DoNotInline
    static boolean isAttachedToWindow(@NonNull View view) {
        return view.isAttachedToWindow();
    }

    @DoNotInline
    static boolean isLaidOut(@NonNull View view) {
        return view.isLaidOut();
    }

    @DoNotInline
    static boolean isLayoutDirectionResolved(@NonNull View view) {
        return view.isLayoutDirectionResolved();
    }

    @DoNotInline
    static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i);
    }

    @DoNotInline
    static void setAccessibilityLiveRegion(View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }

    @DoNotInline
    static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i) {
        accessibilityEvent.setContentChangeTypes(i);
    }
}
