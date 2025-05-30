package androidx.compose.material.pullrefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ExperimentalMaterialApi;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PullRefreshIndicatorKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float MaxProgressArc = 0.8f;
    private static final float IndicatorSize = Dp.m2142constructorimpl(40);

    @NotNull
    private static final RoundedCornerShape SpinnerShape = RoundedCornerShapeKt.getCircleShape();
    private static final float ArcRadius = Dp.m2142constructorimpl((float) 7.5d);
    private static final float StrokeWidth = Dp.m2142constructorimpl((float) 2.5d);
    private static final float ArrowWidth = Dp.m2142constructorimpl(10);
    private static final float ArrowHeight = Dp.m2142constructorimpl(5);
    private static final float Elevation = Dp.m2142constructorimpl(6);

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
    public static final void m708CircularArrowIndicatoriJQMabo(final PullRefreshState pullRefreshState, final long j, final Modifier modifier, Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-486016981);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-486016981, i, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:120)");
        }
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Object obj = rememberedValue;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            Path Path = AndroidPath_androidKt.Path();
            Path.setFillType-oQ8Xj4U(PathFillType.Companion.getEvenOdd-Rg-k1Os());
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
                ArrowValues = PullRefreshIndicatorKt.ArrowValues(pullRefreshState.getProgress());
                float rotation = ArrowValues.getRotation();
                long j2 = j;
                Path path2 = path;
                long mo1320getCenterF1C5BW0 = drawScope.mo1320getCenterF1C5BW0();
                DrawContext drawContext = drawScope.getDrawContext();
                long j3 = drawContext.getSize-NH-jbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().mo1331rotateUv8p0NA(rotation, mo1320getCenterF1C5BW0);
                f = PullRefreshIndicatorKt.ArcRadius;
                float mo321toPx0680j_4 = drawScope.mo321toPx0680j_4(f);
                f2 = PullRefreshIndicatorKt.StrokeWidth;
                float mo321toPx0680j_42 = mo321toPx0680j_4 + (drawScope.mo321toPx0680j_4(f2) / 2.0f);
                Rect rect = new Rect(Offset.m848getXimpl(SizeKt.m913getCenteruvyYCjk(drawScope.mo1321getSizeNHjbRc())) - mo321toPx0680j_42, Offset.m849getYimpl(SizeKt.m913getCenteruvyYCjk(drawScope.mo1321getSizeNHjbRc())) - mo321toPx0680j_42, Offset.m848getXimpl(SizeKt.m913getCenteruvyYCjk(drawScope.mo1321getSizeNHjbRc())) + mo321toPx0680j_42, Offset.m849getYimpl(SizeKt.m913getCenteruvyYCjk(drawScope.mo1321getSizeNHjbRc())) + mo321toPx0680j_42);
                float alpha = ArrowValues.getAlpha();
                float startAngle = ArrowValues.getStartAngle();
                float endAngle = ArrowValues.getEndAngle() - ArrowValues.getStartAngle();
                long m869getTopLeftF1C5BW0 = rect.m869getTopLeftF1C5BW0();
                long m867getSizeNHjbRc = rect.m867getSizeNHjbRc();
                f3 = PullRefreshIndicatorKt.StrokeWidth;
                w51.v(drawScope, j2, startAngle, endAngle, false, m869getTopLeftF1C5BW0, m867getSizeNHjbRc, alpha, new Stroke(drawScope.mo321toPx0680j_4(f3), 0.0f, StrokeCap.Companion.getSquare-KaPHkGw(), 0, (PathEffect) null, 26, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 768, (Object) null);
                PullRefreshIndicatorKt.m713drawArrow42QJj7c(drawScope, path2, rect, j2, ArrowValues);
                drawContext.getCanvas().restore();
                drawContext.setSize-uvyYCjk(j3);
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
                PullRefreshIndicatorKt.m708CircularArrowIndicatoriJQMabo(pullRefreshState, j, modifier, composer2, i | 1);
            }
        });
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    @ExperimentalMaterialApi
    /* renamed from: PullRefreshIndicator-jB83MbM, reason: not valid java name */
    public static final void m709PullRefreshIndicatorjB83MbM(final boolean z, @NotNull final PullRefreshState pullRefreshState, @Nullable Modifier modifier, long j, long j2, boolean z2, @Nullable Composer composer, final int i, final int i2) {
        long j3;
        int i3;
        long j4;
        Intrinsics.checkNotNullParameter(pullRefreshState, "state");
        Composer startRestartGroup = composer.startRestartGroup(308716636);
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.Companion : modifier;
        if ((i2 & 8) != 0) {
            i3 = i & (-7169);
            j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).getSurface-0d7_KjU();
        } else {
            j3 = j;
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            long m561contentColorForek8zF_U = ColorsKt.m561contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 9) & 14);
            i3 &= -57345;
            j4 = m561contentColorForek8zF_U;
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
                public final Boolean m714invoke() {
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
        SurfaceKt.m659SurfaceFjzlyU(PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(androidx.compose.foundation.layout.SizeKt.size-3ABfNKs(modifier2, IndicatorSize), pullRefreshState, z3), SpinnerShape, j3, 0L, null, m710PullRefreshIndicator_jB83MbM$lambda1((State) rememberedValue) ? Elevation : Dp.m2142constructorimpl(0), ComposableLambdaKt.composableLambda(startRestartGroup, -194757728, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$1
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
                CrossfadeKt.Crossfade(Boolean.valueOf(z), null, AnimationSpecKt.tween$default(100, 0, (Easing) null, 6, (Object) null), ComposableLambdaKt.composableLambda(composer2, -2067838016, true, new 1(j5, i4, pullRefreshState)), composer2, (i4 & 14) | 3456, 2);
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
                PullRefreshIndicatorKt.m709PullRefreshIndicatorjB83MbM(z, pullRefreshState, modifier3, j6, j7, z4, composer2, i | 1, i2);
            }
        });
    }

    /* renamed from: PullRefreshIndicator_jB83MbM$lambda-1, reason: not valid java name */
    private static final boolean m710PullRefreshIndicator_jB83MbM$lambda1(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawArrow-42QJj7c, reason: not valid java name */
    public static final void m713drawArrow42QJj7c(DrawScope drawScope, Path path, Rect rect, long j, ArrowValues arrowValues) {
        path.reset();
        path.moveTo(0.0f, 0.0f);
        float f = ArrowWidth;
        path.lineTo(drawScope.mo321toPx0680j_4(f) * arrowValues.getScale(), 0.0f);
        path.lineTo((drawScope.mo321toPx0680j_4(f) * arrowValues.getScale()) / 2, drawScope.mo321toPx0680j_4(ArrowHeight) * arrowValues.getScale());
        path.translate-k-4lQ0M(OffsetKt.Offset(((Math.min(rect.getWidth(), rect.getHeight()) / 2.0f) + Offset.m848getXimpl(rect.m864getCenterF1C5BW0())) - ((drawScope.mo321toPx0680j_4(f) * arrowValues.getScale()) / 2.0f), Offset.m849getYimpl(rect.m864getCenterF1C5BW0()) + (drawScope.mo321toPx0680j_4(StrokeWidth) / 2.0f)));
        path.close();
        float endAngle = arrowValues.getEndAngle();
        long mo1320getCenterF1C5BW0 = drawScope.mo1320getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long j2 = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1331rotateUv8p0NA(endAngle, mo1320getCenterF1C5BW0);
        w51.G(drawScope, path, j, arrowValues.getAlpha(), (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j2);
    }
}
