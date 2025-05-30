package androidx.compose.ui.platform;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

    AndroidComposeViewAccessibilityDelegateCompat$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        this.this$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.this$0.getAccessibilityManager$ui_release().addAccessibilityStateChangeListener(this.this$0.getEnabledStateListener$ui_release());
        this.this$0.getAccessibilityManager$ui_release().addTouchExplorationStateChangeListener(this.this$0.getTouchExplorationStateListener$ui_release());
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AndroidComposeViewAccessibilityDelegateCompat.access$getHandler$p(this.this$0).removeCallbacks(AndroidComposeViewAccessibilityDelegateCompat.access$getSemanticsChangeChecker$p(this.this$0));
        this.this$0.getAccessibilityManager$ui_release().removeAccessibilityStateChangeListener(this.this$0.getEnabledStateListener$ui_release());
        this.this$0.getAccessibilityManager$ui_release().removeTouchExplorationStateChangeListener(this.this$0.getTouchExplorationStateListener$ui_release());
    }
}
