package androidx.drawerlayout.widget;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DrawerLayout$ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
    DrawerLayout$ChildAccessibilityDelegate() {
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if (DrawerLayout.includeChildForAccessibility(view)) {
            return;
        }
        accessibilityNodeInfoCompat.setParent(null);
    }
}
