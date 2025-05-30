package androidx.core.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.RequiresApi;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AccessibilityDelegateCompat$AccessibilityDelegateAdapter extends View.AccessibilityDelegate {
    final AccessibilityDelegateCompat mCompat;

    AccessibilityDelegateCompat$AccessibilityDelegateAdapter(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        this.mCompat = accessibilityDelegateCompat;
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mCompat.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    @RequiresApi(16)
    public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProviderCompat accessibilityNodeProvider = this.mCompat.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return (AccessibilityNodeProvider) accessibilityNodeProvider.getProvider();
        }
        return null;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mCompat.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setScreenReaderFocusable(ViewCompat.isScreenReaderFocusable(view));
        wrap.setHeading(ViewCompat.isAccessibilityHeading(view));
        wrap.setPaneTitle(ViewCompat.getAccessibilityPaneTitle(view));
        wrap.setStateDescription(ViewCompat.getStateDescription(view));
        this.mCompat.onInitializeAccessibilityNodeInfo(view, wrap);
        wrap.addSpansToExtras(accessibilityNodeInfo.getText(), view);
        List actionList = AccessibilityDelegateCompat.getActionList(view);
        for (int i = 0; i < actionList.size(); i++) {
            wrap.addAction((AccessibilityNodeInfoCompat$AccessibilityActionCompat) actionList.get(i));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mCompat.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mCompat.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return this.mCompat.performAccessibilityAction(view, i, bundle);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i) {
        this.mCompat.sendAccessibilityEvent(view, i);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mCompat.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
