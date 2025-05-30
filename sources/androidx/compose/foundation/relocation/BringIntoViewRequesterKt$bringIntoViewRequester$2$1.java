package androidx.compose.foundation.relocation;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BringIntoViewRequesterKt$bringIntoViewRequester$2$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ BringIntoViewRequesterModifier $modifier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BringIntoViewRequesterKt$bringIntoViewRequester$2$1(BringIntoViewRequester bringIntoViewRequester, BringIntoViewRequesterModifier bringIntoViewRequesterModifier) {
        super(1);
        this.$bringIntoViewRequester = bringIntoViewRequester;
        this.$modifier = bringIntoViewRequesterModifier;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        this.$bringIntoViewRequester.getModifiers().add(this.$modifier);
        final BringIntoViewRequester bringIntoViewRequester = this.$bringIntoViewRequester;
        final BringIntoViewRequesterModifier bringIntoViewRequesterModifier = this.$modifier;
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2$1$invoke$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                bringIntoViewRequester.getModifiers().remove(bringIntoViewRequesterModifier);
            }
        };
    }
}
