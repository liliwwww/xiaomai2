package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewParentCompat$Api19Impl {
    private ViewParentCompat$Api19Impl() {
    }

    @DoNotInline
    static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i);
    }
}
