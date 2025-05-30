package androidx.compose.foundation.relocation;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class BringIntoViewResponderKt$bringIntoViewResponder$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ BringIntoViewResponder $responder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BringIntoViewResponderKt$bringIntoViewResponder$2(BringIntoViewResponder bringIntoViewResponder) {
        super(3);
        this.$responder = bringIntoViewResponder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-852052847);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-852052847, i, -1, "androidx.compose.foundation.relocation.bringIntoViewResponder.<anonymous> (BringIntoViewResponder.kt:104)");
        }
        BringIntoViewParent rememberDefaultBringIntoViewParent = BringIntoViewResponder_androidKt.rememberDefaultBringIntoViewParent(composer, 0);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(rememberDefaultBringIntoViewParent);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new BringIntoViewResponderModifier(rememberDefaultBringIntoViewParent);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        BringIntoViewResponderModifier bringIntoViewResponderModifier = (BringIntoViewResponderModifier) rememberedValue;
        bringIntoViewResponderModifier.setResponder(this.$responder);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bringIntoViewResponderModifier;
    }
}
