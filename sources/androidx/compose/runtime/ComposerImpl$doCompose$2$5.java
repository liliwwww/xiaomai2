package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ComposerImpl$doCompose$2$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ Object $savedContent;
    final /* synthetic */ ComposerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposerImpl$doCompose$2$5(Function2<? super Composer, ? super Integer, Unit> function2, ComposerImpl composerImpl, Object obj) {
        super(0);
        this.$content = function2;
        this.this$0 = composerImpl;
        this.$savedContent = obj;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m901invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m901invoke() {
        Object obj;
        if (this.$content != null) {
            ComposerImpl.access$startGroup(this.this$0, 200, ComposerKt.getInvocation());
            ActualJvm_jvmKt.invokeComposable(this.this$0, this.$content);
            ComposerImpl.access$endGroup(this.this$0);
        } else {
            if ((!ComposerImpl.access$getForciblyRecompose$p(this.this$0) && !ComposerImpl.access$getProvidersInvalid$p(this.this$0)) || (obj = this.$savedContent) == null || Intrinsics.areEqual(obj, Composer.Companion.getEmpty())) {
                this.this$0.skipCurrentGroup();
                return;
            }
            ComposerImpl.access$startGroup(this.this$0, 200, ComposerKt.getInvocation());
            ComposerImpl composerImpl = this.this$0;
            Object obj2 = this.$savedContent;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Function2<androidx.compose.runtime.Composer, kotlin.Int, kotlin.Unit>");
            ActualJvm_jvmKt.invokeComposable(composerImpl, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj2, 2));
            ComposerImpl.access$endGroup(this.this$0);
        }
    }
}
