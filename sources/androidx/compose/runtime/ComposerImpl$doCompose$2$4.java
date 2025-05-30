package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposerImpl$doCompose$2$4 extends Lambda implements Function1<State<?>, Unit> {
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$doCompose$2$4(ComposerImpl composerImpl) {
        super(1);
        this.this$0 = composerImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((State<?>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull State<?> state) {
        Intrinsics.checkNotNullParameter(state, "it");
        ComposerImpl.access$setChildrenComposing$p(this.this$0, ComposerImpl.access$getChildrenComposing$p(r2) - 1);
    }
}
