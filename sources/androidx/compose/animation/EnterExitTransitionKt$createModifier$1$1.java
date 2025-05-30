package androidx.compose.animation;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class EnterExitTransitionKt$createModifier$1$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ State<Float> $alpha$delegate;
    final /* synthetic */ State<Float> $scale$delegate;
    final /* synthetic */ State<TransformOrigin> $transformOrigin$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EnterExitTransitionKt$createModifier$1$1(State<Float> state, State<Float> state2, State<TransformOrigin> state3) {
        super(1);
        this.$alpha$delegate = state;
        this.$scale$delegate = state2;
        this.$transformOrigin$delegate = state3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setAlpha(EnterExitTransitionKt.access$createModifier$lambda-8(this.$alpha$delegate));
        graphicsLayerScope.setScaleX(EnterExitTransitionKt.access$createModifier$lambda-11(this.$scale$delegate));
        graphicsLayerScope.setScaleY(EnterExitTransitionKt.access$createModifier$lambda-11(this.$scale$delegate));
        graphicsLayerScope.m1138setTransformOrigin__ExYCQ(EnterExitTransitionKt.access$createModifier$lambda-13(this.$transformOrigin$delegate));
    }
}
