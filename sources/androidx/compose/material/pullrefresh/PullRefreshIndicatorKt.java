package androidx.compose.material.pullrefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.graphics.AndroidPath_androidKt;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.Path;
import androidx.compose.p004ui.graphics.PathFillType;
import androidx.compose.p004ui.graphics.StrokeCap;
import androidx.compose.p004ui.graphics.drawscope.DrawContext;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.graphics.drawscope.Stroke;
import androidx.compose.p004ui.layout.LayoutKt;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.platform.ViewConfiguration;
import androidx.compose.p004ui.semantics.SemanticsModifierKt;
import androidx.compose.p004ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class PullRefreshIndicatorKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float MaxProgressArc = 0.8f;
    private static final float IndicatorSize = C0856Dp.m5216constructorimpl(40);

    @NotNull
    private static final RoundedCornerShape SpinnerShape = RoundedCornerShapeKt.getCircleShape();
    private static final float ArcRadius = C0856Dp.m5216constructorimpl((float) 7.5d);
    private static final float StrokeWidth = C0856Dp.m5216constructorimpl((float) 2.5d);
    private static final float ArrowWidth = C0856Dp.m5216constructorimpl(10);
    private static final float ArrowHeight = C0856Dp.m5216constructorimpl(5);
    private static final float Elevation = C0856Dp.m5216constructorimpl(6);

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float f) {
        float max = (Math.max(Math.min(1.0f, f) - 0.4f, 0.0f) * 5) / 3;
        float coerceIn = RangesKt.coerceIn(Math.abs(f) - 1.0f, 0.0f, 2.0f);
        float pow = (((0.4f * max) - 0.25f) + (coerceIn - (((float) Math.pow(coerceIn, 2)) / 4))) * 0.5f;
        float f2 = 360;
        return new ArrowValues(RangesKt.coerceIn(f, 0.0f, 1.0f), pow, pow * f2, ((MaxProgressArc * max) + pow) * f2, Math.min(1.0f, max));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterialApi
    /* renamed from: CircularArrowIndicator-iJQMabo, reason: not valid java name */
    public static final void m2351CircularArrowIndicatoriJQMabo(final PullRefreshState pullRefreshState, final long j, final Modifier modifier, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-486016981);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-486016981, i, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:120)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Object obj = rememberedValue;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            Path Path = AndroidPath_androidKt.Path();
            Path.mo2691setFillTypeoQ8Xj4U(PathFillType.Companion.m3030getEvenOddRgk1Os());
            startRestartGroup.updateRememberedValue(Path);
            obj = Path;
        }
        startRestartGroup.endReplaceableGroup();
        final Path path = (Path) obj;
        CanvasKt.Canvas(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((SemanticsPropertyReceiver) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, "Refreshing");
            }
        }, 1, null), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((DrawScope) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull DrawScope drawScope) {
                ArrowValues ArrowValues;
                float f;
                float f2;
                float f3;
                Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
                ArrowValues = PullRefreshIndicatorKt.ArrowValues(PullRefreshState.this.getProgress());
                float rotation = ArrowValues.getRotation();
                long j2 = j;
                Path path2 = path;
                long mo3204getCenterF1C5BW0 = drawScope.mo3204getCenterF1C5BW0();
                DrawContext drawContext = drawScope.getDrawContext();
                long mo3211getSizeNHjbRc = drawContext.mo3211getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().mo3217rotateUv8p0NA(rotation, mo3204getCenterF1C5BW0);
                f = PullRefreshIndicatorKt.ArcRadius;
                float mo1283toPx0680j_4 = drawScope.mo1283toPx0680j_4(f);
                f2 = PullRefreshIndicatorKt.StrokeWidth;
                float mo1283toPx0680j_42 = mo1283toPx0680j_4 + (drawScope.mo1283toPx0680j_4(f2) / 2.0f);
                Rect rect = new Rect(Offset.m2556getXimpl(SizeKt.m2635getCenteruvyYCjk(drawScope.mo3205getSizeNHjbRc())) - mo1283toPx0680j_42, Offset.m2557getYimpl(SizeKt.m2635getCenteruvyYCjk(drawScope.mo3205getSizeNHjbRc())) - mo1283toPx0680j_42, Offset.m2556getXimpl(SizeKt.m2635getCenteruvyYCjk(drawScope.mo3205getSizeNHjbRc())) + mo1283toPx0680j_42, Offset.m2557getYimpl(SizeKt.m2635getCenteruvyYCjk(drawScope.mo3205getSizeNHjbRc())) + mo1283toPx0680j_42);
                float alpha = ArrowValues.getAlpha();
                float startAngle = ArrowValues.getStartAngle();
                float endAngle = ArrowValues.getEndAngle() - ArrowValues.getStartAngle();
                long m2591getTopLeftF1C5BW0 = rect.m2591getTopLeftF1C5BW0();
                long m2589getSizeNHjbRc = rect.m2589getSizeNHjbRc();
                f3 = PullRefreshIndicatorKt.StrokeWidth;
                w51.v(drawScope, j2, startAngle, endAngle, false, m2591getTopLeftF1C5BW0, m2589getSizeNHjbRc, alpha, new Stroke(drawScope.mo1283toPx0680j_4(f3), 0.0f, StrokeCap.Companion.m3094getSquareKaPHkGw(), 0, null, 26, null), (ColorFilter) null, 0, 768, (Object) null);
                PullRefreshIndicatorKt.m2356drawArrow42QJj7c(drawScope, path2, rect, j2, ArrowValues);
                drawContext.getCanvas().restore();
                drawContext.mo3212setSizeuvyYCjk(mo3211getSizeNHjbRc);
            }
        }, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i2) {
                PullRefreshIndicatorKt.m2351CircularArrowIndicatoriJQMabo(PullRefreshState.this, j, modifier, composer2, i | 1);
            }
        });
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterialApi
    /* renamed from: PullRefreshIndicator-jB83MbM, reason: not valid java name */
    public static final void m2352PullRefreshIndicatorjB83MbM(final boolean z, @NotNull final PullRefreshState pullRefreshState, @Nullable Modifier modifier, long j, long j2, boolean z2, @Nullable Composer composer, final int i, final int i2) {
        long j3;
        int i3;
        long j4;
        Intrinsics.checkNotNullParameter(pullRefreshState, "state");
        Composer startRestartGroup = composer.startRestartGroup(308716636);
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        if ((i2 & 8) != 0) {
            i3 = i & (-7169);
            j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m2020getSurface0d7_KjU();
        } else {
            j3 = j;
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            long m2034contentColorForek8zF_U = ColorsKt.m2034contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 9) & 14);
            i3 &= -57345;
            j4 = m2034contentColorForek8zF_U;
        } else {
            j4 = j2;
        }
        boolean z3 = (i2 & 32) != 0 ? false : z2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(308716636, i3, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator (PullRefreshIndicator.kt:71)");
        }
        Boolean valueOf = Boolean.valueOf(z);
        startRestartGroup.startReplaceableGroup(511388516);
        boolean changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(pullRefreshState);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$showElevation$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @NotNull
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Boolean m2357invoke() {
                    return Boolean.valueOf(z || pullRefreshState.getPosition$material_release() > 0.5f);
                }
            });
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        final int i4 = i3;
        final long j5 = j4;
        final boolean z4 = z3;
        final long j6 = j3;
        SurfaceKt.m2242SurfaceFjzlyU(PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(androidx.compose.foundation.layout.SizeKt.m1437size3ABfNKs(modifier2, IndicatorSize), pullRefreshState, z3), SpinnerShape, j3, 0L, null, m2353PullRefreshIndicator_jB83MbM$lambda1((State) rememberedValue) ? Elevation : C0856Dp.m5216constructorimpl(0), ComposableLambdaKt.composableLambda(startRestartGroup, -194757728, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$1
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
            public final void invoke(@Nullable Composer composer2, int i5) {
                if ((i5 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-194757728, i5, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator.<anonymous> (PullRefreshIndicator.kt:90)");
                }
                Boolean valueOf2 = Boolean.valueOf(z);
                TweenSpec tween$default = AnimationSpecKt.tween$default(100, 0, null, 6, null);
                final long j7 = j5;
                final int i6 = i4;
                final PullRefreshState pullRefreshState2 = pullRefreshState;
                CrossfadeKt.Crossfade(valueOf2, null, tween$default, ComposableLambdaKt.composableLambda(composer2, -2067838016, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke(((Boolean) obj).booleanValue(), (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                    @Composable
                    public final void invoke(boolean z5, @Nullable Composer composer3, int i7) {
                        int i8;
                        float f;
                        float f2;
                        float f3;
                        if ((i7 & 14) == 0) {
                            i8 = (composer3.changed(z5) ? 4 : 2) | i7;
                        } else {
                            i8 = i7;
                        }
                        if ((i8 & 91) == 18 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2067838016, i7, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator.<anonymous>.<anonymous> (PullRefreshIndicator.kt:94)");
                        }
                        Modifier.Companion companion = Modifier.Companion;
                        Modifier fillMaxSize$default = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                        Alignment center = Alignment.Companion.getCenter();
                        long j8 = j7;
                        int i9 = i6;
                        PullRefreshState pullRefreshState3 = pullRefreshState2;
                        composer3.startReplaceableGroup(733328855);
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composer3, 6);
                        composer3.startReplaceableGroup(-1323940314);
                        Density density = (Density) composer3.consume(CompositionLocalsKt.getLocalDensity());
                        LayoutDirection layoutDirection = (LayoutDirection) composer3.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ViewConfiguration viewConfiguration = (ViewConfiguration) composer3.consume(CompositionLocalsKt.getLocalViewConfiguration());
                        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                        Function0<ComposeUiNode> constructor = companion2.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(fillMaxSize$default);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        composer3.disableReusing();
                        Composer m2410constructorimpl = Updater.m2410constructorimpl(composer3);
                        Updater.m2417setimpl(m2410constructorimpl, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                        Updater.m2417setimpl(m2410constructorimpl, density, companion2.getSetDensity());
                        Updater.m2417setimpl(m2410constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
                        Updater.m2417setimpl(m2410constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
                        composer3.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2398boximpl(SkippableUpdater.m2399constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        composer3.startReplaceableGroup(-2137368960);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        composer3.startReplaceableGroup(831079366);
                        f = PullRefreshIndicatorKt.ArcRadius;
                        f2 = PullRefreshIndicatorKt.StrokeWidth;
                        float m5216constructorimpl = C0856Dp.m5216constructorimpl(C0856Dp.m5216constructorimpl(f + f2) * 2);
                        if (z5) {
                            composer3.startReplaceableGroup(-2035147616);
                            f3 = PullRefreshIndicatorKt.StrokeWidth;
                            ProgressIndicatorKt.m2177CircularProgressIndicatoraMcp0Q(androidx.compose.foundation.layout.SizeKt.m1437size3ABfNKs(companion, m5216constructorimpl), j8, f3, composer3, ((i9 >> 9) & 112) | 390, 0);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-2035147362);
                            PullRefreshIndicatorKt.m2351CircularArrowIndicatoriJQMabo(pullRefreshState3, j8, androidx.compose.foundation.layout.SizeKt.m1437size3ABfNKs(companion, m5216constructorimpl), composer3, ((i9 >> 9) & 112) | 392);
                            composer3.endReplaceableGroup();
                        }
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), composer2, (i4 & 14) | 3456, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, ((i3 >> 3) & 896) | 1572912, 24);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final long j7 = j4;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i5) {
                PullRefreshIndicatorKt.m2352PullRefreshIndicatorjB83MbM(z, pullRefreshState, modifier3, j6, j7, z4, composer2, i | 1, i2);
            }
        });
    }

    /* renamed from: PullRefreshIndicator_jB83MbM$lambda-1, reason: not valid java name */
    private static final boolean m2353PullRefreshIndicator_jB83MbM$lambda1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawArrow-42QJj7c, reason: not valid java name */
    public static final void m2356drawArrow42QJj7c(DrawScope drawScope, Path path, Rect rect, long j, ArrowValues arrowValues) {
        path.reset();
        path.moveTo(0.0f, 0.0f);
        float f = ArrowWidth;
        path.lineTo(drawScope.mo1283toPx0680j_4(f) * arrowValues.getScale(), 0.0f);
        path.lineTo((drawScope.mo1283toPx0680j_4(f) * arrowValues.getScale()) / 2, drawScope.mo1283toPx0680j_4(ArrowHeight) * arrowValues.getScale());
        path.mo2692translatek4lQ0M(OffsetKt.Offset(((Math.min(rect.getWidth(), rect.getHeight()) / 2.0f) + Offset.m2556getXimpl(rect.m2586getCenterF1C5BW0())) - ((drawScope.mo1283toPx0680j_4(f) * arrowValues.getScale()) / 2.0f), Offset.m2557getYimpl(rect.m2586getCenterF1C5BW0()) + (drawScope.mo1283toPx0680j_4(StrokeWidth) / 2.0f)));
        path.close();
        float endAngle = arrowValues.getEndAngle();
        long mo3204getCenterF1C5BW0 = drawScope.mo3204getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long mo3211getSizeNHjbRc = drawContext.mo3211getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo3217rotateUv8p0NA(endAngle, mo3204getCenterF1C5BW0);
        w51.G(drawScope, path, j, arrowValues.getAlpha(), (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
        drawContext.getCanvas().restore();
        drawContext.mo3212setSizeuvyYCjk(mo3211getSizeNHjbRc);
    }
}
