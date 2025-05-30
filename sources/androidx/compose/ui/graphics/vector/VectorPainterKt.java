package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableOpenTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.vector.VectorProperty;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cy5;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class VectorPainterKt {

    @NotNull
    public static final String RootGroupName = "VectorRootGroup";

    @ComposableTarget(applier = "androidx.compose.ui.graphics.vector.VectorComposable")
    @Composable
    public static final void RenderVectorGroup(@NotNull VectorGroup vectorGroup, @Nullable Map<String, ? extends VectorConfig> map, @Nullable Composer composer, int i, int i2) {
        int i3;
        Map<String, ? extends VectorConfig> map2;
        Composer composer2;
        Map<String, ? extends VectorConfig> map3;
        Intrinsics.checkNotNullParameter(vectorGroup, "group");
        Composer startRestartGroup = composer.startRestartGroup(-446179233);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(vectorGroup) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 16;
        }
        if (i4 == 2 && (i3 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            map2 = map;
            composer2 = startRestartGroup;
        } else {
            Map<String, ? extends VectorConfig> emptyMap = i4 != 0 ? MapsKt.emptyMap() : map;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-446179233, i, -1, "androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:327)");
            }
            Iterator it = vectorGroup.iterator();
            while (it.hasNext()) {
                VectorGroup vectorGroup2 = (VectorNode) it.next();
                if (vectorGroup2 instanceof VectorPath) {
                    startRestartGroup.startReplaceableGroup(-326285735);
                    VectorPath vectorPath = (VectorPath) vectorGroup2;
                    VectorConfig vectorConfig = emptyMap.get(vectorPath.getName());
                    if (vectorConfig == null) {
                        vectorConfig = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$1
                            @Override // androidx.compose.ui.graphics.vector.VectorConfig
                            public /* synthetic */ Object getOrDefault(VectorProperty vectorProperty, Object obj) {
                                return cy5.a(this, vectorProperty, obj);
                            }
                        };
                    }
                    VectorConfig vectorConfig2 = vectorConfig;
                    Composer composer3 = startRestartGroup;
                    VectorComposeKt.Path-9cdaXJ4((List) vectorConfig2.getOrDefault(new VectorProperty<List<? extends PathNode>>() { // from class: androidx.compose.ui.graphics.vector.VectorProperty$PathData
                        public static final int $stable = 0;
                    }, vectorPath.getPathData()), vectorPath.m1363getPathFillTypeRgk1Os(), vectorPath.getName(), (Brush) vectorConfig2.getOrDefault(new VectorProperty<Brush>() { // from class: androidx.compose.ui.graphics.vector.VectorProperty$Fill
                        public static final int $stable = 0;
                    }, vectorPath.getFill()), ((Number) vectorConfig2.getOrDefault(VectorProperty.FillAlpha.INSTANCE, Float.valueOf(vectorPath.getFillAlpha()))).floatValue(), (Brush) vectorConfig2.getOrDefault(VectorProperty.Stroke.INSTANCE, vectorPath.getStroke()), ((Number) vectorConfig2.getOrDefault(new VectorProperty<Float>() { // from class: androidx.compose.ui.graphics.vector.VectorProperty$StrokeAlpha
                        public static final int $stable = 0;
                    }, Float.valueOf(vectorPath.getStrokeAlpha()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.StrokeLineWidth.INSTANCE, Float.valueOf(vectorPath.getStrokeLineWidth()))).floatValue(), vectorPath.m1364getStrokeLineCapKaPHkGw(), vectorPath.m1365getStrokeLineJoinLxFBmk8(), vectorPath.getStrokeLineMiter(), ((Number) vectorConfig2.getOrDefault(new VectorProperty<Float>() { // from class: androidx.compose.ui.graphics.vector.VectorProperty$TrimPathStart
                        public static final int $stable = 0;
                    }, Float.valueOf(vectorPath.getTrimPathStart()))).floatValue(), ((Number) vectorConfig2.getOrDefault(VectorProperty.TrimPathEnd.INSTANCE, Float.valueOf(vectorPath.getTrimPathEnd()))).floatValue(), ((Number) vectorConfig2.getOrDefault(new VectorProperty<Float>() { // from class: androidx.compose.ui.graphics.vector.VectorProperty$TrimPathOffset
                        public static final int $stable = 0;
                    }, Float.valueOf(vectorPath.getTrimPathOffset()))).floatValue(), composer3, 8, 0, 0);
                    composer3.endReplaceableGroup();
                    it = it;
                    emptyMap = emptyMap;
                    startRestartGroup = composer3;
                } else {
                    Iterator it2 = it;
                    Map<String, ? extends VectorConfig> map4 = emptyMap;
                    Composer composer4 = startRestartGroup;
                    if (vectorGroup2 instanceof VectorGroup) {
                        composer4.startReplaceableGroup(-326283877);
                        VectorGroup vectorGroup3 = vectorGroup2;
                        map3 = map4;
                        VectorConfig vectorConfig3 = map3.get(vectorGroup3.getName());
                        if (vectorConfig3 == null) {
                            vectorConfig3 = new VectorConfig() { // from class: androidx.compose.ui.graphics.vector.VectorPainterKt$RenderVectorGroup$config$2
                                @Override // androidx.compose.ui.graphics.vector.VectorConfig
                                public /* synthetic */ Object getOrDefault(VectorProperty vectorProperty, Object obj) {
                                    return cy5.a(this, vectorProperty, obj);
                                }
                            };
                        }
                        VectorComposeKt.Group(vectorGroup3.getName(), ((Number) vectorConfig3.getOrDefault(VectorProperty.Rotation.INSTANCE, Float.valueOf(vectorGroup3.getRotation()))).floatValue(), ((Number) vectorConfig3.getOrDefault(VectorProperty.PivotX.INSTANCE, Float.valueOf(vectorGroup3.getPivotX()))).floatValue(), ((Number) vectorConfig3.getOrDefault(VectorProperty.PivotY.INSTANCE, Float.valueOf(vectorGroup3.getPivotY()))).floatValue(), ((Number) vectorConfig3.getOrDefault(VectorProperty.ScaleX.INSTANCE, Float.valueOf(vectorGroup3.getScaleX()))).floatValue(), ((Number) vectorConfig3.getOrDefault(VectorProperty.ScaleY.INSTANCE, Float.valueOf(vectorGroup3.getScaleY()))).floatValue(), ((Number) vectorConfig3.getOrDefault(new VectorProperty<Float>() { // from class: androidx.compose.ui.graphics.vector.VectorProperty$TranslateX
                            public static final int $stable = 0;
                        }, Float.valueOf(vectorGroup3.getTranslationX()))).floatValue(), ((Number) vectorConfig3.getOrDefault(new VectorProperty<Float>() { // from class: androidx.compose.ui.graphics.vector.VectorProperty$TranslateY
                            public static final int $stable = 0;
                        }, Float.valueOf(vectorGroup3.getTranslationY()))).floatValue(), (List) vectorConfig3.getOrDefault(new VectorProperty<List<? extends PathNode>>() { // from class: androidx.compose.ui.graphics.vector.VectorProperty$PathData
                            public static final int $stable = 0;
                        }, vectorGroup3.getClipPathData()), ComposableLambdaKt.composableLambda(composer4, 1450046638, true, new RenderVectorGroup.1(vectorGroup2, map3)), composer4, 939524096, 0);
                        composer4.endReplaceableGroup();
                    } else {
                        map3 = map4;
                        composer4.startReplaceableGroup(-326282407);
                        composer4.endReplaceableGroup();
                    }
                    startRestartGroup = composer4;
                    emptyMap = map3;
                    it = it2;
                }
            }
            map2 = emptyMap;
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new RenderVectorGroup.2(vectorGroup, map2, i, i2));
    }

    private static final void mirror(DrawScope drawScope, Function1<? super DrawScope, Unit> function1) {
        long mo1320getCenterF1C5BW0 = drawScope.mo1320getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long j = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1332scale0AR0LA0(-1.0f, 1.0f, mo1320getCenterF1C5BW0);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j);
    }

    @Composable
    @NotNull
    public static final VectorPainter rememberVectorPainter(@NotNull ImageVector imageVector, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(imageVector, "image");
        composer.startReplaceableGroup(1413834416);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1413834416, i, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:157)");
        }
        VectorPainter m1362rememberVectorPaintervIP8VLU = m1362rememberVectorPaintervIP8VLU(imageVector.getDefaultWidth-D9Ej5fM(), imageVector.getDefaultHeight-D9Ej5fM(), imageVector.getViewportWidth(), imageVector.getViewportHeight(), imageVector.getName(), imageVector.getTintColor-0d7_KjU(), imageVector.getTintBlendMode-0nO6VwU(), imageVector.getAutoMirror(), ComposableLambdaKt.composableLambda(composer, 1873274766, true, new rememberVectorPainter.3(imageVector)), composer, 100663296, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m1362rememberVectorPaintervIP8VLU;
    }

    @ComposableOpenTarget(index = -1)
    @NotNull
    @Deprecated(message = "Replace rememberVectorPainter graphicsLayer that consumes the auto mirror flag", replaceWith = @ReplaceWith(expression = "rememberVectorPainter(defaultWidth, defaultHeight, viewportWidth, viewportHeight, name, tintColor, tintBlendMode, false, content)", imports = {"androidx.compose.ui.graphics.vector"}))
    @Composable
    /* renamed from: rememberVectorPainter-mlNsNFs, reason: not valid java name */
    public static final VectorPainter m1361rememberVectorPaintermlNsNFs(float f, float f2, float f3, float f4, @Nullable String str, long j, int i, @NotNull Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, int i2, int i3) {
        Intrinsics.checkNotNullParameter(function4, "content");
        composer.startReplaceableGroup(-964365210);
        float f5 = (i3 & 4) != 0 ? Float.NaN : f3;
        float f6 = (i3 & 8) != 0 ? Float.NaN : f4;
        String str2 = (i3 & 16) != 0 ? RootGroupName : str;
        long j2 = (i3 & 32) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j;
        int m1003getSrcIn0nO6VwU = (i3 & 64) != 0 ? BlendMode.Companion.m1003getSrcIn0nO6VwU() : i;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-964365210, i2, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:73)");
        }
        VectorPainter m1362rememberVectorPaintervIP8VLU = m1362rememberVectorPaintervIP8VLU(f, f2, f5, f6, str2, j2, m1003getSrcIn0nO6VwU, false, function4, composer, 12582912 | (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | ((i2 << 3) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m1362rememberVectorPaintervIP8VLU;
    }

    @Composable
    @ComposableOpenTarget(index = -1)
    @NotNull
    /* renamed from: rememberVectorPainter-vIP8VLU, reason: not valid java name */
    public static final VectorPainter m1362rememberVectorPaintervIP8VLU(float f, float f2, float f3, float f4, @Nullable String str, long j, int i, boolean z, @NotNull Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, int i2, int i3) {
        Intrinsics.checkNotNullParameter(function4, "content");
        composer.startReplaceableGroup(1068590786);
        float f5 = (i3 & 4) != 0 ? Float.NaN : f3;
        float f6 = (i3 & 8) == 0 ? f4 : Float.NaN;
        String str2 = (i3 & 16) != 0 ? RootGroupName : str;
        long j2 = (i3 & 32) != 0 ? Color.Companion.getUnspecified-0d7_KjU() : j;
        int m1003getSrcIn0nO6VwU = (i3 & 64) != 0 ? BlendMode.Companion.m1003getSrcIn0nO6VwU() : i;
        boolean z2 = (i3 & 128) != 0 ? false : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1068590786, i2, -1, "androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:115)");
        }
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        float mo321toPx0680j_4 = density.mo321toPx0680j_4(f);
        float mo321toPx0680j_42 = density.mo321toPx0680j_4(f2);
        if (Float.isNaN(f5)) {
            f5 = mo321toPx0680j_4;
        }
        if (Float.isNaN(f6)) {
            f6 = mo321toPx0680j_42;
        }
        Color m1040boximpl = Color.m1040boximpl(j2);
        BlendMode m971boximpl = BlendMode.m971boximpl(m1003getSrcIn0nO6VwU);
        int i4 = i2 >> 15;
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(m1040boximpl) | composer.changed(m971boximpl);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = !Color.m1051equalsimpl0(j2, Color.Companion.getUnspecified-0d7_KjU()) ? ColorFilter.Companion.m1064tintxETnrds(j2, m1003getSrcIn0nO6VwU) : null;
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        ColorFilter colorFilter = (ColorFilter) rememberedValue;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new VectorPainter();
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        VectorPainter vectorPainter = (VectorPainter) rememberedValue2;
        vectorPainter.setSize-uvyYCjk$ui_release(SizeKt.Size(mo321toPx0680j_4, mo321toPx0680j_42));
        vectorPainter.setAutoMirror$ui_release(z2);
        vectorPainter.setIntrinsicColorFilter$ui_release(colorFilter);
        vectorPainter.RenderVector$ui_release(str2, f5, f6, function4, composer, ((i2 >> 12) & 14) | AccessibilityNodeInfoCompat.ACTION_PASTE | (i4 & 7168));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return vectorPainter;
    }
}
