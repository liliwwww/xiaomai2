package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = Dp.constructor-impl(20);

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void BackLayerTransition(final BackdropValue backdropValue, final Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        final Function2<? super Composer, ? super Integer, Unit> function23 = function22;
        Composer startRestartGroup = composer.startRestartGroup(-950970976);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(backdropValue) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(function23) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-950970976, i3, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:414)");
            }
            State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(backdropValue == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, (Function1) null, startRestartGroup, 0, 12);
            float f = ((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).toPx-0680j_4(AnimationSlideOffset);
            float f2 = 1;
            float coerceIn = RangesKt.coerceIn(m665BackLayerTransition$lambda7(animateFloatAsState) - f2, 0.0f, 1.0f);
            float coerceIn2 = RangesKt.coerceIn(f2 - m665BackLayerTransition$lambda7(animateFloatAsState), 0.0f, 1.0f);
            startRestartGroup.startReplaceableGroup(733328855);
            Modifier.Companion companion = Modifier.Companion;
            Alignment.Companion companion2 = Alignment.Companion;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0 constructor = companion3.getConstructor();
            Function3 materializerOf = LayoutKt.materializerOf(companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer composer2 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer2, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.set-impl(composer2, density, companion3.getSetDensity());
            Updater.set-impl(composer2, layoutDirection, companion3.getSetLayoutDirection());
            Updater.set-impl(composer2, viewConfiguration, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            startRestartGroup.startReplaceableGroup(2065804710);
            Modifier modifier = GraphicsLayerModifierKt.graphicsLayer-pANQ8Wg$default(ZIndexModifierKt.zIndex(companion, coerceIn), 0.0f, 0.0f, coerceIn, 0.0f, (f2 - coerceIn) * f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 65515, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0 constructor2 = companion3.getConstructor();
            Function3 materializerOf2 = LayoutKt.materializerOf(modifier);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer composer3 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer3, rememberBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.set-impl(composer3, density2, companion3.getSetDensity());
            Updater.set-impl(composer3, layoutDirection2, companion3.getSetLayoutDirection());
            Updater.set-impl(composer3, viewConfiguration2, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf2.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            startRestartGroup.startReplaceableGroup(-1057690836);
            function2.invoke(startRestartGroup, Integer.valueOf((i3 >> 3) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier modifier2 = GraphicsLayerModifierKt.graphicsLayer-pANQ8Wg$default(ZIndexModifierKt.zIndex(companion, coerceIn2), 0.0f, 0.0f, coerceIn2, 0.0f, (f2 - coerceIn2) * (-f), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 65515, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            Function0 constructor3 = companion3.getConstructor();
            Function3 materializerOf3 = LayoutKt.materializerOf(modifier2);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer composer4 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer4, rememberBoxMeasurePolicy3, companion3.getSetMeasurePolicy());
            Updater.set-impl(composer4, density3, companion3.getSetDensity());
            Updater.set-impl(composer4, layoutDirection3, companion3.getSetLayoutDirection());
            Updater.set-impl(composer4, viewConfiguration3, companion3.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf3.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-2137368960);
            startRestartGroup.startReplaceableGroup(-676544093);
            function23 = function22;
            function23.invoke(startRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackLayerTransition$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer5, int i4) {
                BackdropScaffoldKt.BackLayerTransition(backdropValue, function2, function23, composer5, i | 1);
            }
        });
    }

    /* renamed from: BackLayerTransition$lambda-7, reason: not valid java name */
    private static final float m665BackLayerTransition$lambda7(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x0463, code lost:
    
        if (r4 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L282;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x024c  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: BackdropScaffold-BZszfkY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m666BackdropScaffoldBZszfkY(@org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r56, @org.jetbrains.annotations.Nullable androidx.compose.material.BackdropScaffoldState r57, boolean r58, float r59, float r60, boolean r61, boolean r62, long r63, long r65, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r67, float r68, long r69, long r71, long r73, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r75, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r76, int r77, int r78, int r79) {
        /*
            Method dump skipped, instructions count: 1323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt.m666BackdropScaffoldBZszfkY(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material.BackdropScaffoldState, boolean, float, float, boolean, boolean, long, long, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @UiComposable
    public static final void BackdropStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function1<? super Constraints, Constraints> function1, Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1248995194);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(function1) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(function4) ? AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED : AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END;
        }
        if ((i2 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1248995194, i2, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:451)");
            }
            startRestartGroup.startReplaceableGroup(1618982084);
            boolean changed = startRestartGroup.changed(function2) | startRestartGroup.changed(function1) | startRestartGroup.changed(function4);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new BackdropStack.1.1(function2, function1, function4, i2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) rememberedValue, startRestartGroup, i2 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new BackdropStack.2(modifier, function2, function1, function4, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m667Scrim3JVO9M(long j, Function0<Unit> function0, boolean z, Composer composer, int i) {
        int i2;
        Modifier modifier;
        Composer startRestartGroup = composer.startRestartGroup(-92141505);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-92141505, i2, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:382)");
            }
            if (j != Color.Companion.m1084getUnspecified0d7_KjU()) {
                State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, (Function1) null, startRestartGroup, 0, 12);
                startRestartGroup.startReplaceableGroup(1010547004);
                if (z) {
                    Modifier.Companion companion = Modifier.Companion;
                    Unit unit = Unit.INSTANCE;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    boolean changed = startRestartGroup.changed(function0);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Scrim.dismissModifier.1.1(function0, (Continuation) null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    modifier = SuspendingPointerInputFilterKt.pointerInput(companion, unit, (Function2) rememberedValue);
                } else {
                    modifier = Modifier.Companion;
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null).then(modifier);
                Color color = Color.box-impl(j);
                startRestartGroup.startReplaceableGroup(511388516);
                boolean changed2 = startRestartGroup.changed(color) | startRestartGroup.changed(animateFloatAsState);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Scrim.1.1(j, animateFloatAsState);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) rememberedValue2, startRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Scrim.2(j, function0, z, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim_3J_VO9M$lambda-4, reason: not valid java name */
    public static final float m668Scrim_3J_VO9M$lambda4(State<Float> state) {
        return state.getValue().floatValue();
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final BackdropScaffoldState rememberBackdropScaffoldState(@NotNull BackdropValue backdropValue, @Nullable AnimationSpec<Float> animationSpec, @Nullable Function1<? super BackdropValue, Boolean> function1, @Nullable SnackbarHostState snackbarHostState, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(backdropValue, "initialValue");
        composer.startReplaceableGroup(-862178912);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = rememberBackdropScaffoldState.1.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) rememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-862178912, i, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:167)");
        }
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.rememberSaveable(new Object[]{animationSpec, function1, snackbarHostState}, BackdropScaffoldState.Companion.Saver(animationSpec, function1, snackbarHostState), (String) null, new rememberBackdropScaffoldState.3(backdropValue, animationSpec, function1, snackbarHostState), composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return backdropScaffoldState;
    }
}
