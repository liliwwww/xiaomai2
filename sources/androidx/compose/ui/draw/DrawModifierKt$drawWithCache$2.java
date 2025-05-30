package androidx.compose.ui.draw;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DrawModifierKt$drawWithCache$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function1<CacheDrawScope, DrawResult> $onBuildDrawCache;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawModifierKt$drawWithCache$2(Function1<? super CacheDrawScope, DrawResult> function1) {
        super(3);
        this.$onBuildDrawCache = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(-1689569019);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1689569019, i, -1, "androidx.compose.ui.draw.drawWithCache.<anonymous> (DrawModifier.kt:141)");
        }
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new CacheDrawScope();
            composer.updateRememberedValue(rememberedValue);
        }
        Modifier then = modifier.then(new DrawContentCacheModifier((CacheDrawScope) rememberedValue, this.$onBuildDrawCache));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
