package androidx.compose.material;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TabKt$LeadingIconTab$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Indication $ripple;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TabKt$LeadingIconTab$2(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, int i, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.$modifier = modifier;
        this.$selected = z;
        this.$interactionSource = mutableInteractionSource;
        this.$ripple = indication;
        this.$enabled = z2;
        this.$onClick = function0;
        this.$icon = function2;
        this.$$dirty = i;
        this.$text = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        TextStyle m2339copyHL5avdY;
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(866677691, i, -1, "androidx.compose.material.LeadingIconTab.<anonymous> (Tab.kt:167)");
        }
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m334paddingVpY3zN4$default(SelectableKt.selectable-O2vRcR0(SizeKt.m360height3ABfNKs(this.$modifier, TabKt.access$getSmallTabHeight$p()), this.$selected, this.$interactionSource, this.$ripple, this.$enabled, Role.box-impl(Role.Companion.getTab-o7Vup1c()), this.$onClick), TabKt.access$getHorizontalTextPadding$p(), 0.0f, 2, null), 0.0f, 1, null);
        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
        Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
        Function2<Composer, Integer, Unit> function2 = this.$icon;
        int i2 = this.$$dirty;
        Function2<Composer, Integer, Unit> function22 = this.$text;
        composer.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
        composer.startReplaceableGroup(-1323940314);
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0 constructor = companion.getConstructor();
        Function3 materializerOf = LayoutKt.materializerOf(fillMaxWidth$default);
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
        Composer composer2 = Updater.constructor-impl(composer);
        Updater.set-impl(composer2, rowMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.set-impl(composer2, density, companion.getSetDensity());
        Updater.set-impl(composer2, layoutDirection, companion.getSetLayoutDirection());
        Updater.set-impl(composer2, viewConfiguration, companion.getSetViewConfiguration());
        composer.enableReusing();
        materializerOf.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        composer.startReplaceableGroup(-678309503);
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        composer.startReplaceableGroup(1002887383);
        function2.invoke(composer, Integer.valueOf((i2 >> 9) & 14));
        SpacerKt.Spacer(SizeKt.m371requiredWidth3ABfNKs(Modifier.Companion, TabKt.access$getTextDistanceFromLeadingIcon$p()), composer, 6);
        m2339copyHL5avdY = r8.m2339copyHL5avdY((r42 & 1) != 0 ? r8.spanStyle.m2299getColor0d7_KjU() : 0L, (r42 & 2) != 0 ? r8.spanStyle.m2300getFontSizeXSAIIZE() : 0L, (r42 & 4) != 0 ? r8.spanStyle.getFontWeight() : null, (r42 & 8) != 0 ? r8.spanStyle.m2301getFontStyle4Lr2A7w() : null, (r42 & 16) != 0 ? r8.spanStyle.m2302getFontSynthesisZQGJjVo() : null, (r42 & 32) != 0 ? r8.spanStyle.getFontFamily() : null, (r42 & 64) != 0 ? r8.spanStyle.getFontFeatureSettings() : null, (r42 & 128) != 0 ? r8.spanStyle.m2303getLetterSpacingXSAIIZE() : 0L, (r42 & 256) != 0 ? r8.spanStyle.m2298getBaselineShift5SSeXJ0() : null, (r42 & 512) != 0 ? r8.spanStyle.getTextGeometricTransform() : null, (r42 & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? r8.spanStyle.getLocaleList() : null, (r42 & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? r8.spanStyle.m2297getBackground0d7_KjU() : 0L, (r42 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? r8.spanStyle.getTextDecoration() : null, (r42 & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? r8.spanStyle.getShadow() : null, (r42 & AccessibilityEventCompat.TYPE_ANNOUNCEMENT) != 0 ? r8.paragraphStyle.m2274getTextAlignbuA522U() : TextAlign.m2499boximpl(TextAlign.Companion.m2506getCentere0LSkKk()), (r42 & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED) != 0 ? r8.paragraphStyle.m2275getTextDirectionmmuk1to() : null, (r42 & AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED) != 0 ? r8.paragraphStyle.m2273getLineHeightXSAIIZE() : 0L, (r42 & AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY) != 0 ? MaterialTheme.INSTANCE.getTypography(composer, 6).getButton().paragraphStyle.getTextIndent() : null);
        TextKt.ProvideTextStyle(m2339copyHL5avdY, function22, composer, (i2 >> 3) & 112);
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
