package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ChipKt$Chip$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ ChipColors $colors;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ State<Color> $contentColor$delegate;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ChipKt$Chip$2(State<Color> state, Function2<? super Composer, ? super Integer, Unit> function2, ChipColors chipColors, boolean z, int i, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$contentColor$delegate = state;
        this.$leadingIcon = function2;
        this.$colors = chipColors;
        this.$enabled = z;
        this.$$dirty = i;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(139076687, i, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:108)");
        }
        ProvidedValue[] providedValueArr = {ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.getAlpha-impl(ChipKt.access$Chip$lambda-1(this.$contentColor$delegate))))};
        final Function2<Composer, Integer, Unit> function2 = this.$leadingIcon;
        final ChipColors chipColors = this.$colors;
        final boolean z = this.$enabled;
        final int i2 = this.$$dirty;
        final Function3<RowScope, Composer, Integer, Unit> function3 = this.$content;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$2.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i3) {
                if ((i3 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(667535631, i3, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:109)");
                }
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer2, 6).getBody2(), ComposableLambdaKt.composableLambda(composer2, -1131213696, true, new 1(function2, chipColors, z, i2, function3)), composer2, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
