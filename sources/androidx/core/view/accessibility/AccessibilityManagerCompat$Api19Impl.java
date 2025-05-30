package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityManagerCompat;

/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class AccessibilityManagerCompat$Api19Impl {
    private AccessibilityManagerCompat$Api19Impl() {
    }

    @DoNotInline
    static boolean addTouchExplorationStateChangeListenerWrapper(AccessibilityManager accessibilityManager, AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return accessibilityManager.addTouchExplorationStateChangeListener(new AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper(touchExplorationStateChangeListener));
    }

    @DoNotInline
    static boolean removeTouchExplorationStateChangeListenerWrapper(AccessibilityManager accessibilityManager, AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        return accessibilityManager.removeTouchExplorationStateChangeListener(new AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper(touchExplorationStateChangeListener));
    }
}
