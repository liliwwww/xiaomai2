package androidx.compose.ui.platform;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidComposeView$focusOwner$1 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {
    final /* synthetic */ AndroidComposeView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidComposeView$focusOwner$1(AndroidComposeView androidComposeView) {
        super(1);
        this.this$0 = androidComposeView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Function0<Unit>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "it");
        this.this$0.registerOnEndApplyChangesListener(function0);
    }
}
