package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment$Companion;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextStyle;
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
final class ChipKt$FilterChip$3$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $$dirty1;
    final /* synthetic */ SelectableChipColors $colors;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $content;
    final /* synthetic */ State<Color> $contentColor;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ Function2<Composer, Integer, Unit> $selectedIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ChipKt$FilterChip$3$1(Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, int i, SelectableChipColors selectableChipColors, boolean z2, int i2, State<Color> state) {
        super(2);
        this.$leadingIcon = function2;
        this.$selected = z;
        this.$selectedIcon = function22;
        this.$trailingIcon = function23;
        this.$content = function3;
        this.$$dirty1 = i;
        this.$colors = selectableChipColors;
        this.$enabled = z2;
        this.$$dirty = i2;
        this.$contentColor = state;
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
            ComposerKt.traceEventStart(1582291359, i, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:209)");
        }
        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2();
        final Function2<Composer, Integer, Unit> function2 = this.$leadingIcon;
        final boolean z = this.$selected;
        final Function2<Composer, Integer, Unit> function22 = this.$selectedIcon;
        final Function2<Composer, Integer, Unit> function23 = this.$trailingIcon;
        final Function3<RowScope, Composer, Integer, Unit> function3 = this.$content;
        final int i2 = this.$$dirty1;
        final SelectableChipColors selectableChipColors = this.$colors;
        final boolean z2 = this.$enabled;
        final int i3 = this.$$dirty;
        final State<Color> state = this.$contentColor;
        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer, -1543702066, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @Composable
            public final void invoke(@Nullable Composer composer2, int i4) {
                float f;
                RowScopeInstance rowScopeInstance;
                float f2;
                int i5;
                Modifier modifier;
                float f3;
                float f4;
                float f5;
                if ((i4 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1543702066, i4, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:212)");
                }
                Modifier modifier2 = Modifier.Companion;
                Modifier modifier3 = PaddingKt.padding-qDBjuR0$default(SizeKt.defaultMinSize-VpY3zN4$default(modifier2, 0.0f, ChipDefaults.INSTANCE.m552getMinHeightD9Ej5fM(), 1, (Object) null), (function2 != null || (z && function22 != null)) ? Dp.m2142constructorimpl(0) : ChipKt.HorizontalPadding, 0.0f, function23 == null ? ChipKt.HorizontalPadding : Dp.m2142constructorimpl(0), 0.0f, 10, (Object) null);
                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                Alignment$Companion alignment$Companion = Alignment.Companion;
                Alignment$Vertical centerVertically = alignment$Companion.getCenterVertically();
                Function2<Composer, Integer, Unit> function24 = function2;
                boolean z3 = z;
                Function2<Composer, Integer, Unit> function25 = function22;
                Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                int i6 = i2;
                Function2<Composer, Integer, Unit> function26 = function23;
                SelectableChipColors selectableChipColors2 = selectableChipColors;
                boolean z4 = z2;
                int i7 = i3;
                State<Color> state2 = state;
                composer2.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                composer2.startReplaceableGroup(-1323940314);
                Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                ComposeUiNode$Companion composeUiNode$Companion = ComposeUiNode.Companion;
                Function0<ComposeUiNode> constructor = composeUiNode$Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier3);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                composer2.disableReusing();
                Composer m747constructorimpl = Updater.m747constructorimpl(composer2);
                Updater.m754setimpl(m747constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) composeUiNode$Companion.getSetMeasurePolicy());
                Updater.m754setimpl(m747constructorimpl, density, (Function2<? super T, ? super Density, Unit>) composeUiNode$Companion.getSetDensity());
                Updater.m754setimpl(m747constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) composeUiNode$Companion.getSetLayoutDirection());
                Updater.m754setimpl(m747constructorimpl, viewConfiguration, (Function2<? super T, ? super ViewConfiguration, Unit>) composeUiNode$Companion.getSetViewConfiguration());
                composer2.enableReusing();
                materializerOf.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(composer2)), composer2, 0);
                composer2.startReplaceableGroup(2058660585);
                composer2.startReplaceableGroup(-678309503);
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                composer2.startReplaceableGroup(1218705642);
                composer2.startReplaceableGroup(-1943412137);
                if (function24 != null || (z3 && function25 != null)) {
                    f = ChipKt.LeadingIconStartSpacing;
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(modifier2, f), composer2, 6);
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(alignment$Companion.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    Density density2 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection2 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor2 = composeUiNode$Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(modifier2);
                    rowScopeInstance = rowScopeInstance2;
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    composer2.disableReusing();
                    Composer m747constructorimpl2 = Updater.m747constructorimpl(composer2);
                    Updater.m754setimpl(m747constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) composeUiNode$Companion.getSetMeasurePolicy());
                    Updater.m754setimpl(m747constructorimpl2, density2, (Function2<? super T, ? super Density, Unit>) composeUiNode$Companion.getSetDensity());
                    Updater.m754setimpl(m747constructorimpl2, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) composeUiNode$Companion.getSetLayoutDirection());
                    Updater.m754setimpl(m747constructorimpl2, viewConfiguration2, (Function2<? super T, ? super ViewConfiguration, Unit>) composeUiNode$Companion.getSetViewConfiguration());
                    composer2.enableReusing();
                    materializerOf2.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    composer2.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    composer2.startReplaceableGroup(-626917591);
                    composer2.startReplaceableGroup(649985595);
                    if (function24 != null) {
                        State leadingIconColor = selectableChipColors2.leadingIconColor(z4, z3, composer2, ((i7 >> 9) & 14) | ((i7 << 3) & 112) | ((i7 >> 15) & 896));
                        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(leadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m1052getAlphaimpl(((Color) leadingIconColor.getValue()).m1060unboximpl())))}, function24, composer2, ((i7 >> 21) & 112) | 8);
                    }
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(-1943411323);
                    if (z3 && function25 != null) {
                        long m1060unboximpl = ((Color) state2.getValue()).m1060unboximpl();
                        composer2.startReplaceableGroup(649986426);
                        if (function24 != null) {
                            f3 = ChipKt.SelectedIconContainerSize;
                            modifier = ClipKt.clip(BackgroundKt.background-bw27NRU(SizeKt.requiredSize-3ABfNKs(modifier2, f3), ((Color) state2.getValue()).m1060unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                            m1060unboximpl = ((Color) selectableChipColors2.backgroundColor(z4, z3, composer2, ((i7 >> 9) & 14) | ((i7 << 3) & 112) | ((i7 >> 15) & 896)).getValue()).m1060unboximpl();
                        } else {
                            modifier = modifier2;
                        }
                        composer2.endReplaceableGroup();
                        Alignment center = alignment$Companion.getCenter();
                        composer2.startReplaceableGroup(733328855);
                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                        composer2.startReplaceableGroup(-1323940314);
                        Density density3 = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection3 = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration3 = (ViewConfiguration) composer2.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        Function0<ComposeUiNode> constructor3 = composeUiNode$Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(modifier);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor3);
                        } else {
                            composer2.useNode();
                        }
                        composer2.disableReusing();
                        Composer m747constructorimpl3 = Updater.m747constructorimpl(composer2);
                        Updater.m754setimpl(m747constructorimpl3, rememberBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) composeUiNode$Companion.getSetMeasurePolicy());
                        Updater.m754setimpl(m747constructorimpl3, density3, (Function2<? super T, ? super Density, Unit>) composeUiNode$Companion.getSetDensity());
                        Updater.m754setimpl(m747constructorimpl3, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) composeUiNode$Companion.getSetLayoutDirection());
                        Updater.m754setimpl(m747constructorimpl3, viewConfiguration3, (Function2<? super T, ? super ViewConfiguration, Unit>) composeUiNode$Companion.getSetViewConfiguration());
                        composer2.enableReusing();
                        materializerOf3.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-2137368960);
                        composer2.startReplaceableGroup(-370889391);
                        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m1040boximpl(m1060unboximpl))}, function25, composer2, ((i7 >> 24) & 112) | 8);
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                    }
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    f2 = ChipKt.LeadingIconEndSpacing;
                    i5 = 6;
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(modifier2, f2), composer2, 6);
                } else {
                    rowScopeInstance = rowScopeInstance2;
                    i5 = 6;
                }
                composer2.endReplaceableGroup();
                function32.invoke(rowScopeInstance, composer2, Integer.valueOf((i6 & 112) | i5));
                if (function26 != null) {
                    f4 = ChipKt.TrailingIconSpacing;
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(modifier2, f4), composer2, i5);
                    function26.invoke(composer2, Integer.valueOf(i6 & 14));
                    f5 = ChipKt.TrailingIconSpacing;
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(modifier2, f5), composer2, i5);
                }
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), composer, 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
