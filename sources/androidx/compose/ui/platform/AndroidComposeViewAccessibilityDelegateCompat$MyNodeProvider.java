package androidx.compose.ui.platform;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat$MyNodeProvider extends AccessibilityNodeProvider {
    final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

    public AndroidComposeViewAccessibilityDelegateCompat$MyNodeProvider(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        this.this$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public void addExtraDataToAccessibilityNodeInfo(int i, @NotNull AccessibilityNodeInfo accessibilityNodeInfo, @NotNull String str, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(accessibilityNodeInfo, "info");
        Intrinsics.checkNotNullParameter(str, "extraDataKey");
        AndroidComposeViewAccessibilityDelegateCompat.access$addExtraDataToAccessibilityNodeInfoHelper(this.this$0, i, accessibilityNodeInfo, str, bundle);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    @Nullable
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        return AndroidComposeViewAccessibilityDelegateCompat.access$createNodeInfo(this.this$0, i);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i, int i2, @Nullable Bundle bundle) {
        return AndroidComposeViewAccessibilityDelegateCompat.access$performActionHelper(this.this$0, i, i2, bundle);
    }
}
