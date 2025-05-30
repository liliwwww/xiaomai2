package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.UiComposable;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.node.LayoutNode;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.platform.ViewConfiguration;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LookaheadLayoutKt {
    @Composable
    @ExperimentalComposeUiApi
    @UiComposable
    public static final void LookaheadLayout(@NotNull final Function3<? super LookaheadLayoutScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Modifier modifier, @NotNull final MeasurePolicy measurePolicy, @Nullable Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(function3, "content");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer startRestartGroup = composer.startRestartGroup(1697006219);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            i3 |= startRestartGroup.changed(measurePolicy) ? 256 : 128;
        }
        if ((i3 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1697006219, i3, -1, "androidx.compose.ui.layout.LookaheadLayout (LookaheadLayout.kt:67)");
            }
            Modifier materialize = ComposedModifierKt.materialize(startRestartGroup, modifier);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new LookaheadLayoutScopeImpl();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl = (LookaheadLayoutScopeImpl) rememberedValue;
            Function0<LayoutNode> constructor$ui_release = LayoutNode.Companion.getConstructor$ui_release();
            startRestartGroup.startReplaceableGroup(-692256719);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor$ui_release);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer m2410constructorimpl = Updater.m2410constructorimpl(startRestartGroup);
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Updater.m2417setimpl(m2410constructorimpl, materialize, companion.getSetModifier());
            Updater.m2417setimpl(m2410constructorimpl, measurePolicy, companion.getSetMeasurePolicy());
            Updater.m2417setimpl(m2410constructorimpl, density, companion.getSetDensity());
            Updater.m2417setimpl(m2410constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2417setimpl(m2410constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            Updater.m2417setimpl(m2410constructorimpl, lookaheadLayoutScopeImpl, new Function2<LayoutNode, LookaheadLayoutScopeImpl, Unit>() { // from class: androidx.compose.ui.layout.LookaheadLayoutKt$LookaheadLayout$1$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((LayoutNode) obj, (LookaheadLayoutScopeImpl) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull LayoutNode layoutNode, @NotNull LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl2) {
                    Intrinsics.checkNotNullParameter(layoutNode, "$this$set");
                    Intrinsics.checkNotNullParameter(lookaheadLayoutScopeImpl2, "scope");
                    lookaheadLayoutScopeImpl2.setRoot(layoutNode.getInnerCoordinator$ui_release());
                }
            });
            Updater.m2414initimpl(m2410constructorimpl, new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.layout.LookaheadLayoutKt$LookaheadLayout$1$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((LayoutNode) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull LayoutNode layoutNode) {
                    Intrinsics.checkNotNullParameter(layoutNode, "$this$init");
                    layoutNode.setLookaheadRoot(true);
                }
            });
            startRestartGroup.enableReusing();
            startRestartGroup.startReplaceableGroup(1130448943);
            function3.invoke(lookaheadLayoutScopeImpl, startRestartGroup, Integer.valueOf(((i3 << 3) & 112) | 8));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LookaheadLayoutKt$LookaheadLayout$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i5) {
                LookaheadLayoutKt.LookaheadLayout(function3, modifier2, measurePolicy, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
            }
        });
    }
}
