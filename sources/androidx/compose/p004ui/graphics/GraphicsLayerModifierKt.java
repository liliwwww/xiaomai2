package androidx.compose.p004ui.graphics;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.runtime.Stable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class GraphicsLayerModifierKt {
    @Stable
    @NotNull
    public static final Modifier graphicsLayer(@NotNull Modifier modifier, @NotNull final Function1<? super GraphicsLayerScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        return modifier.then(new BlockGraphicsLayerModifier(function1, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.graphics.GraphicsLayerModifierKt$graphicsLayer$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("graphicsLayer");
                inspectorInfo.getProperties().set("block", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }

    @Stable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes shadow color parameters", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null, DefaultShadowColor, DefaultShadowColor)", imports = {"androidx.compose.ui.graphics"}))
    /* renamed from: graphicsLayer-2Xn7asI, reason: not valid java name */
    public static final /* synthetic */ Modifier m2930graphicsLayer2Xn7asI(Modifier modifier, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect) {
        Intrinsics.checkNotNullParameter(modifier, "$this$graphicsLayer");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m2932graphicsLayerAp8cVGQ(modifier, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape, z, renderEffect, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor(), CompositingStrategy.Companion.m2871getAutoNrFUSI());
    }

    @Stable
    @NotNull
    /* renamed from: graphicsLayer-Ap8cVGQ, reason: not valid java name */
    public static final Modifier m2932graphicsLayerAp8cVGQ(@NotNull Modifier modifier, final float f, final float f2, final float f3, final float f4, final float f5, final float f6, final float f7, final float f8, final float f9, final float f10, final long j, @NotNull final Shape shape, final boolean z, @Nullable final RenderEffect renderEffect, final long j2, final long j3, final int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$graphicsLayer");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return modifier.then(new SimpleGraphicsLayerModifier(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape, z, renderEffect, j2, j3, i, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.graphics.GraphicsLayerModifierKt$graphicsLayer-Ap8cVGQ$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("graphicsLayer");
                inspectorInfo.getProperties().set("scaleX", Float.valueOf(f));
                inspectorInfo.getProperties().set("scaleY", Float.valueOf(f2));
                inspectorInfo.getProperties().set("alpha", Float.valueOf(f3));
                inspectorInfo.getProperties().set("translationX", Float.valueOf(f4));
                inspectorInfo.getProperties().set("translationY", Float.valueOf(f5));
                inspectorInfo.getProperties().set("shadowElevation", Float.valueOf(f6));
                inspectorInfo.getProperties().set("rotationX", Float.valueOf(f7));
                inspectorInfo.getProperties().set("rotationY", Float.valueOf(f8));
                inspectorInfo.getProperties().set("rotationZ", Float.valueOf(f9));
                inspectorInfo.getProperties().set("cameraDistance", Float.valueOf(f10));
                inspectorInfo.getProperties().set("transformOrigin", TransformOrigin.m3117boximpl(j));
                inspectorInfo.getProperties().set("shape", shape);
                inspectorInfo.getProperties().set("clip", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("renderEffect", renderEffect);
                inspectorInfo.getProperties().set("ambientShadowColor", Color.m2777boximpl(j2));
                inspectorInfo.getProperties().set("spotShadowColor", Color.m2777boximpl(j3));
                inspectorInfo.getProperties().set("compositingStrategy", CompositingStrategy.m2864boximpl(i));
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: graphicsLayer-Ap8cVGQ$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2933graphicsLayerAp8cVGQ$default(Modifier modifier, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, int i2, Object obj) {
        return m2932graphicsLayerAp8cVGQ(modifier, (i2 & 1) != 0 ? 1.0f : f, (i2 & 2) != 0 ? 1.0f : f2, (i2 & 4) == 0 ? f3 : 1.0f, (i2 & 8) != 0 ? 0.0f : f4, (i2 & 16) != 0 ? 0.0f : f5, (i2 & 32) != 0 ? 0.0f : f6, (i2 & 64) != 0 ? 0.0f : f7, (i2 & 128) != 0 ? 0.0f : f8, (i2 & 256) == 0 ? f9 : 0.0f, (i2 & 512) != 0 ? 8.0f : f10, (i2 & 1024) != 0 ? TransformOrigin.Companion.m3130getCenterSzJe1aQ() : j, (i2 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (i2 & 4096) != 0 ? false : z, (i2 & 8192) != 0 ? null : renderEffect, (i2 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j2, (i2 & 32768) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j3, (i2 & 65536) != 0 ? CompositingStrategy.Companion.m2871getAutoNrFUSI() : i);
    }

    @Stable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes a compositing strategy", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null, DefaultShadowColor, DefaultShadowColor, CompositingStrategy.Auto)", imports = {"androidx.compose.ui.graphics"}))
    /* renamed from: graphicsLayer-pANQ8Wg, reason: not valid java name */
    public static final /* synthetic */ Modifier m2934graphicsLayerpANQ8Wg(Modifier modifier, final float f, final float f2, final float f3, final float f4, final float f5, final float f6, final float f7, final float f8, final float f9, final float f10, final long j, final Shape shape, final boolean z, final RenderEffect renderEffect, final long j2, final long j3) {
        Intrinsics.checkNotNullParameter(modifier, "$this$graphicsLayer");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return modifier.then(new SimpleGraphicsLayerModifier(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape, z, renderEffect, j2, j3, 0, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.graphics.GraphicsLayerModifierKt$graphicsLayer-pANQ8Wg$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("graphicsLayer");
                inspectorInfo.getProperties().set("scaleX", Float.valueOf(f));
                inspectorInfo.getProperties().set("scaleY", Float.valueOf(f2));
                inspectorInfo.getProperties().set("alpha", Float.valueOf(f3));
                inspectorInfo.getProperties().set("translationX", Float.valueOf(f4));
                inspectorInfo.getProperties().set("translationY", Float.valueOf(f5));
                inspectorInfo.getProperties().set("shadowElevation", Float.valueOf(f6));
                inspectorInfo.getProperties().set("rotationX", Float.valueOf(f7));
                inspectorInfo.getProperties().set("rotationY", Float.valueOf(f8));
                inspectorInfo.getProperties().set("rotationZ", Float.valueOf(f9));
                inspectorInfo.getProperties().set("cameraDistance", Float.valueOf(f10));
                inspectorInfo.getProperties().set("transformOrigin", TransformOrigin.m3117boximpl(j));
                inspectorInfo.getProperties().set("shape", shape);
                inspectorInfo.getProperties().set("clip", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("renderEffect", renderEffect);
                inspectorInfo.getProperties().set("ambientShadowColor", Color.m2777boximpl(j2));
                inspectorInfo.getProperties().set("spotShadowColor", Color.m2777boximpl(j3));
            }
        } : InspectableValueKt.getNoInspectorInfo(), 65536, null));
    }

    @Stable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes an optional RenderEffect parameter and shadow color parameters", replaceWith = @ReplaceWith(expression = "Modifier.graphicsLayer(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, shape, clip, null, DefaultShadowColor, DefaultShadowColor)", imports = {"androidx.compose.ui.graphics"}))
    /* renamed from: graphicsLayer-sKFY_QE, reason: not valid java name */
    public static final /* synthetic */ Modifier m2936graphicsLayersKFY_QE(Modifier modifier, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "$this$graphicsLayer");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m2933graphicsLayerAp8cVGQ$default(modifier, f, f2, f3, f4, f5, f6, f7, f8, f9, f10, j, shape, z, null, 0L, 0L, 0, 114688, null);
    }

    @Stable
    @NotNull
    public static final Modifier toolingGraphicsLayer(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return InspectableValueKt.isDebugInspectorInfoEnabled() ? modifier.then(m2933graphicsLayerAp8cVGQ$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null)) : modifier;
    }
}
