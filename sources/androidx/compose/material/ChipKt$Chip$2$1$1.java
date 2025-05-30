package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ChipKt$Chip$2$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ ChipColors $colors;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ChipKt$Chip$2$1$1(Function2<? super Composer, ? super Integer, Unit> function2, ChipColors chipColors, boolean z, int i, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$leadingIcon = function2;
        this.$colors = chipColors;
        this.$enabled = z;
        this.$$dirty = i;
        this.$content = function3;
    }

    /* renamed from: invoke$lambda-1$lambda-0, reason: not valid java name */
    private static final long m559invoke$lambda1$lambda0(State<Color> state) {
        return ((Color) state.getValue()).m1060unboximpl();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        float f;
        float f2;
        float f3;
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1131213696, i, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:112)");
        }
        Modifier.Companion companion = Modifier.Companion;
        Modifier modifier = SizeKt.defaultMinSize-VpY3zN4$default(companion, 0.0f, ChipDefaults.INSTANCE.m552getMinHeightD9Ej5fM(), 1, (Object) null);
        float m2142constructorimpl = this.$leadingIcon == null ? ChipKt.HorizontalPadding : Dp.m2142constructorimpl(0);
        f = ChipKt.HorizontalPadding;
        Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(modifier, m2142constructorimpl, 0.0f, f, 0.0f, 10, (Object) null);
        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
        Alignment$Vertical centerVertically = Alignment.Companion.getCenterVertically();
        Function2<Composer, Integer, Unit> function2 = this.$leadingIcon;
        ChipColors chipColors = this.$colors;
        boolean z = this.$enabled;
        int i2 = this.$$dirty;
        Function3<RowScope, Composer, Integer, Unit> function3 = this.$content;
        composer.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer, 54);
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode$Companion composeUiNode$Companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = composeUiNode$Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier2);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer m747constructorimpl = Updater.m747constructorimpl(composer);
        Updater.m754setimpl(m747constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) composeUiNode$Companion.getSetMeasurePolicy());
        Updater.m754setimpl(m747constructorimpl, density, (Function2<? super T, ? super Density, Unit>) composeUiNode$Companion.getSetDensity());
        Updater.m754setimpl(m747constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) composeUiNode$Companion.getSetLayoutDirection());
        Updater.m754setimpl(m747constructorimpl, viewConfiguration, (Function2<? super T, ? super ViewConfiguration, Unit>) composeUiNode$Companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-678309503);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        composer.startReplaceableGroup(951468004);
        composer.startReplaceableGroup(2084788874);
        if (function2 != null) {
            f2 = ChipKt.LeadingIconStartSpacing;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(companion, f2), composer, 6);
            State leadingIconContentColor = chipColors.leadingIconContentColor(z, composer, ((i2 >> 6) & 14) | ((i2 >> 15) & 112));
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1040boximpl(m559invoke$lambda1$lambda0(leadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1052getAlphaimpl(m559invoke$lambda1$lambda0(leadingIconContentColor))))}, function2, composer, ((i2 >> 18) & 112) | 8);
            f3 = ChipKt.LeadingIconEndSpacing;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(companion, f3), composer, 6);
        }
        composer.endReplaceableGroup();
        function3.invoke(rowScopeInstance, composer, Integer.valueOf(((i2 >> 21) & 112) | 6));
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
