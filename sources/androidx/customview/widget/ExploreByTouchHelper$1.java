package androidx.customview.widget;

import android.graphics.Rect;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.FocusStrategy;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ExploreByTouchHelper$1 implements FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> {
    ExploreByTouchHelper$1() {
    }

    @Override // androidx.customview.widget.FocusStrategy.BoundsAdapter
    public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
        accessibilityNodeInfoCompat.getBoundsInParent(rect);
    }
}
