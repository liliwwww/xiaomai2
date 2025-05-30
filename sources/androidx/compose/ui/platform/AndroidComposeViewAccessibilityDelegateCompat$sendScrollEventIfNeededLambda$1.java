package androidx.compose.ui.platform;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1 extends Lambda implements Function1<ScrollObservationScope, Unit> {
    final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        super(1);
        this.this$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ScrollObservationScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ScrollObservationScope scrollObservationScope) {
        Intrinsics.checkNotNullParameter(scrollObservationScope, "it");
        AndroidComposeViewAccessibilityDelegateCompat.access$sendScrollEventIfNeeded(this.this$0, scrollObservationScope);
    }
}
