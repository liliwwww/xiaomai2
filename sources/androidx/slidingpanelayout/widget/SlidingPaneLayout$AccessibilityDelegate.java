package androidx.slidingpanelayout.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class SlidingPaneLayout$AccessibilityDelegate extends AccessibilityDelegateCompat {
    private final Rect mTmpRect = new Rect();
    final /* synthetic */ SlidingPaneLayout this$0;

    SlidingPaneLayout$AccessibilityDelegate(SlidingPaneLayout slidingPaneLayout) {
        this.this$0 = slidingPaneLayout;
    }

    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
        Rect rect = this.mTmpRect;
        accessibilityNodeInfoCompat2.getBoundsInParent(rect);
        accessibilityNodeInfoCompat.setBoundsInParent(rect);
        accessibilityNodeInfoCompat2.getBoundsInScreen(rect);
        accessibilityNodeInfoCompat.setBoundsInScreen(rect);
        accessibilityNodeInfoCompat.setVisibleToUser(accessibilityNodeInfoCompat2.isVisibleToUser());
        accessibilityNodeInfoCompat.setPackageName(accessibilityNodeInfoCompat2.getPackageName());
        accessibilityNodeInfoCompat.setClassName(accessibilityNodeInfoCompat2.getClassName());
        accessibilityNodeInfoCompat.setContentDescription(accessibilityNodeInfoCompat2.getContentDescription());
        accessibilityNodeInfoCompat.setEnabled(accessibilityNodeInfoCompat2.isEnabled());
        accessibilityNodeInfoCompat.setClickable(accessibilityNodeInfoCompat2.isClickable());
        accessibilityNodeInfoCompat.setFocusable(accessibilityNodeInfoCompat2.isFocusable());
        accessibilityNodeInfoCompat.setFocused(accessibilityNodeInfoCompat2.isFocused());
        accessibilityNodeInfoCompat.setAccessibilityFocused(accessibilityNodeInfoCompat2.isAccessibilityFocused());
        accessibilityNodeInfoCompat.setSelected(accessibilityNodeInfoCompat2.isSelected());
        accessibilityNodeInfoCompat.setLongClickable(accessibilityNodeInfoCompat2.isLongClickable());
        accessibilityNodeInfoCompat.addAction(accessibilityNodeInfoCompat2.getActions());
        accessibilityNodeInfoCompat.setMovementGranularities(accessibilityNodeInfoCompat2.getMovementGranularities());
    }

    public boolean filter(View view) {
        return this.this$0.isDimmed(view);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(accessibilityNodeInfoCompat);
        super.onInitializeAccessibilityNodeInfo(view, obtain);
        copyNodeInfoNoChildren(accessibilityNodeInfoCompat, obtain);
        obtain.recycle();
        accessibilityNodeInfoCompat.setClassName(SlidingPaneLayout.class.getName());
        accessibilityNodeInfoCompat.setSource(view);
        Object parentForAccessibility = ViewCompat.getParentForAccessibility(view);
        if (parentForAccessibility instanceof View) {
            accessibilityNodeInfoCompat.setParent((View) parentForAccessibility);
        }
        int childCount = this.this$0.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.this$0.getChildAt(i);
            if (!filter(childAt) && childAt.getVisibility() == 0) {
                ViewCompat.setImportantForAccessibility(childAt, 1);
                accessibilityNodeInfoCompat.addChild(childAt);
            }
        }
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        if (filter(view)) {
            return false;
        }
        return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }
}
