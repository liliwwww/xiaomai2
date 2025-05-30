package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BlurKt {
    @Stable
    @NotNull
    /* renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m813blur1fqSgw(@NotNull Modifier modifier, final float f, final float f2, @NotNull final Shape shape) {
        final int m1259getDecal3opZhB0;
        final boolean z;
        Intrinsics.checkNotNullParameter(modifier, "$this$blur");
        if (shape != null) {
            m1259getDecal3opZhB0 = TileMode.Companion.m1258getClamp3opZhB0();
            z = true;
        } else {
            m1259getDecal3opZhB0 = TileMode.Companion.m1259getDecal3opZhB0();
            z = false;
        }
        float f3 = 0;
        return ((Dp.m2141compareTo0680j_4(f, Dp.m2142constructorimpl(f3)) <= 0 || Dp.m2141compareTo0680j_4(f2, Dp.m2142constructorimpl(f3)) <= 0) && !z) ? modifier : GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.BlurKt$blur$1
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
                float mo321toPx0680j_4 = graphicsLayerScope.mo321toPx0680j_4(f);
                float mo321toPx0680j_42 = graphicsLayerScope.mo321toPx0680j_4(f2);
                graphicsLayerScope.setRenderEffect((mo321toPx0680j_4 <= 0.0f || mo321toPx0680j_42 <= 0.0f) ? null : RenderEffectKt.BlurEffect-3YTHUZs(mo321toPx0680j_4, mo321toPx0680j_42, m1259getDecal3opZhB0));
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
    public static /* synthetic */ Modifier m814blur1fqSgw$default(Modifier modifier, float f, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.box-impl(BlurredEdgeTreatment.Companion.m817getRectangleGoahg());
        }
        return m813blur1fqSgw(modifier, f, f2, blurredEdgeTreatment.unbox-impl());
    }

    @Stable
    @NotNull
    /* renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m815blurF8QBwvs(@NotNull Modifier modifier, float f, @NotNull Shape shape) {
        Intrinsics.checkNotNullParameter(modifier, "$this$blur");
        return m813blur1fqSgw(modifier, f, f, shape);
    }

    /* renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m816blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.box-impl(BlurredEdgeTreatment.Companion.m817getRectangleGoahg());
        }
        return m815blurF8QBwvs(modifier, f, blurredEdgeTreatment.unbox-impl());
    }
}
