package androidx.compose.p004ui.draw;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p004ui.graphics.GraphicsLayerScope;
import androidx.compose.p004ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.runtime.Stable;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ShadowKt {
    @Stable
    @NotNull
    /* renamed from: shadow-s4CzXII, reason: not valid java name */
    public static final Modifier m2471shadows4CzXII(@NotNull Modifier modifier, final float f, @NotNull final Shape shape, final boolean z, final long j, final long j2) {
        Intrinsics.checkNotNullParameter(modifier, "$this$shadow");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (C0856Dp.m5215compareTo0680j_4(f, C0856Dp.m5216constructorimpl(0)) > 0 || z) {
            return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.draw.ShadowKt$shadow-s4CzXII$$inlined$debugInspectorInfo$1
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
                    inspectorInfo.setName("shadow");
                    inspectorInfo.getProperties().set("elevation", C0856Dp.m5214boximpl(f));
                    inspectorInfo.getProperties().set("shape", shape);
                    inspectorInfo.getProperties().set("clip", Boolean.valueOf(z));
                    inspectorInfo.getProperties().set("ambientColor", Color.m2777boximpl(j));
                    inspectorInfo.getProperties().set("spotColor", Color.m2777boximpl(j2));
                }
            } : InspectableValueKt.getNoInspectorInfo(), GraphicsLayerModifierKt.graphicsLayer(Modifier.Companion, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.ShadowKt$shadow$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((GraphicsLayerScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull GraphicsLayerScope graphicsLayerScope) {
                    Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
                    graphicsLayerScope.setShadowElevation(graphicsLayerScope.mo1283toPx0680j_4(f));
                    graphicsLayerScope.setShape(shape);
                    graphicsLayerScope.setClip(z);
                    graphicsLayerScope.mo2943setAmbientShadowColor8_81llA(j);
                    graphicsLayerScope.mo2945setSpotShadowColor8_81llA(j2);
                }
            }));
        }
        return modifier;
    }

    /* renamed from: shadow-s4CzXII$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2472shadows4CzXII$default(Modifier modifier, float f, Shape shape, boolean z, long j, long j2, int i, Object obj) {
        boolean z2;
        Shape rectangleShape = (i & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        if ((i & 4) != 0) {
            z2 = false;
            if (C0856Dp.m5215compareTo0680j_4(f, C0856Dp.m5216constructorimpl(0)) > 0) {
                z2 = true;
            }
        } else {
            z2 = z;
        }
        return m2471shadows4CzXII(modifier, f, rectangleShape, z2, (i & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j, (i & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : j2);
    }

    @Stable
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with shadow which accepts ambientColor and spotColor parameters", replaceWith = @ReplaceWith(expression = "Modifier.shadow(elevation, shape, clip, DefaultShadowColor, DefaultShadowColor)", imports = {"androidx.compose.ui.draw"}))
    /* renamed from: shadow-ziNgDLE, reason: not valid java name */
    public static final /* synthetic */ Modifier m2473shadowziNgDLE(Modifier modifier, float f, Shape shape, boolean z) {
        Intrinsics.checkNotNullParameter(modifier, "$this$shadow");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return m2471shadows4CzXII(modifier, f, shape, z, GraphicsLayerScopeKt.getDefaultShadowColor(), GraphicsLayerScopeKt.getDefaultShadowColor());
    }

    /* renamed from: shadow-ziNgDLE$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2474shadowziNgDLE$default(Modifier modifier, float f, Shape shape, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            shape = RectangleShapeKt.getRectangleShape();
        }
        if ((i & 4) != 0) {
            z = false;
            if (C0856Dp.m5215compareTo0680j_4(f, C0856Dp.m5216constructorimpl(0)) > 0) {
                z = true;
            }
        }
        return m2473shadowziNgDLE(modifier, f, shape, z);
    }
}
