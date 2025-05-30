package androidx.compose.p004ui.draw;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p004ui.graphics.GraphicsLayerScope;
import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.graphics.RenderEffectKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.graphics.TileMode;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.runtime.Stable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class BlurKt {
    @Stable
    @NotNull
    /* renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m2452blur1fqSgw(@NotNull Modifier modifier, final float f, final float f2, @NotNull final Shape shape) {
        final int m3113getDecal3opZhB0;
        final boolean z;
        Intrinsics.checkNotNullParameter(modifier, "$this$blur");
        if (shape != null) {
            m3113getDecal3opZhB0 = TileMode.Companion.m3112getClamp3opZhB0();
            z = true;
        } else {
            m3113getDecal3opZhB0 = TileMode.Companion.m3113getDecal3opZhB0();
            z = false;
        }
        float f3 = 0;
        return ((C0856Dp.m5215compareTo0680j_4(f, C0856Dp.m5216constructorimpl(f3)) <= 0 || C0856Dp.m5215compareTo0680j_4(f2, C0856Dp.m5216constructorimpl(f3)) <= 0) && !z) ? modifier : GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.BlurKt$blur$1
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
                float mo1283toPx0680j_4 = graphicsLayerScope.mo1283toPx0680j_4(f);
                float mo1283toPx0680j_42 = graphicsLayerScope.mo1283toPx0680j_4(f2);
                graphicsLayerScope.setRenderEffect((mo1283toPx0680j_4 <= 0.0f || mo1283toPx0680j_42 <= 0.0f) ? null : RenderEffectKt.m3055BlurEffect3YTHUZs(mo1283toPx0680j_4, mo1283toPx0680j_42, m3113getDecal3opZhB0));
                Shape shape2 = shape;
                if (shape2 == null) {
                    shape2 = RectangleShapeKt.getRectangleShape();
                }
                graphicsLayerScope.setShape(shape2);
                graphicsLayerScope.setClip(z);
            }
        });
    }

    /* renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2453blur1fqSgw$default(Modifier modifier, float f, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m2456boximpl(BlurredEdgeTreatment.Companion.m2463getRectangleGoahg());
        }
        return m2452blur1fqSgw(modifier, f, f2, blurredEdgeTreatment.m2462unboximpl());
    }

    @Stable
    @NotNull
    /* renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m2454blurF8QBwvs(@NotNull Modifier modifier, float f, @NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "$this$blur");
        return m2452blur1fqSgw(modifier, f, f, shape);
    }

    /* renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m2455blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m2456boximpl(BlurredEdgeTreatment.Companion.m2463getRectangleGoahg());
        }
        return m2454blurF8QBwvs(modifier, f, blurredEdgeTreatment.m2462unboximpl());
    }
}
