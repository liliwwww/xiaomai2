package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityManagerCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
    final AccessibilityManagerCompat.TouchExplorationStateChangeListener mListener;

    AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper(@NonNull AccessibilityManagerCompat.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        this.mListener = touchExplorationStateChangeListener;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper) {
            return this.mListener.equals(((AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper) obj).mListener);
        }
        return false;
    }

    public int hashCode() {
        return this.mListener.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public void onTouchExplorationStateChanged(boolean z) {
        this.mListener.onTouchExplorationStateChanged(z);
    }
}
