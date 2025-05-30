package androidx.compose.ui.platform;

import android.R;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat$Api24Impl {

    @NotNull
    public static final AndroidComposeViewAccessibilityDelegateCompat$Api24Impl INSTANCE = new AndroidComposeViewAccessibilityDelegateCompat$Api24Impl();

    private AndroidComposeViewAccessibilityDelegateCompat$Api24Impl() {
    }

    @JvmStatic
    @DoNotInline
    public static final void addSetProgressAction(@NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @NotNull SemanticsNode semanticsNode) {
        AccessibilityAction accessibilityAction;
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
        if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode) || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetProgress())) == null) {
            return;
        }
        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat$AccessibilityActionCompat(R.id.accessibilityActionSetProgress, accessibilityAction.getLabel()));
    }
}
