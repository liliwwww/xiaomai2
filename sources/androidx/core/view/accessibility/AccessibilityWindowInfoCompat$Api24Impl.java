package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class AccessibilityWindowInfoCompat$Api24Impl {
    private AccessibilityWindowInfoCompat$Api24Impl() {
    }

    @DoNotInline
    static AccessibilityNodeInfo getAnchor(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getAnchor();
    }

    @DoNotInline
    static CharSequence getTitle(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getTitle();
    }
}
