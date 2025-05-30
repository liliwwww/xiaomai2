package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class CheckboxKt$CheckboxImpl$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ State<Color> $borderColor$delegate;
    final /* synthetic */ State<Color> $boxColor$delegate;
    final /* synthetic */ CheckDrawingCache $checkCache;
    final /* synthetic */ State<Float> $checkCenterGravitationShiftFraction$delegate;
    final /* synthetic */ State<Color> $checkColor$delegate;
    final /* synthetic */ State<Float> $checkDrawFraction$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CheckboxKt$CheckboxImpl$1$1(CheckDrawingCache checkDrawingCache, State<Color> state, State<Color> state2, State<Color> state3, State<Float> state4, State<Float> state5) {
        super(1);
        this.$checkCache = checkDrawingCache;
        this.$boxColor$delegate = state;
        this.$borderColor$delegate = state2;
        this.$checkColor$delegate = state3;
        this.$checkDrawFraction$delegate = state4;
        this.$checkCenterGravitationShiftFraction$delegate = state5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        float floor = (float) Math.floor(drawScope.toPx-0680j_4(CheckboxKt.access$getStrokeWidth$p()));
        CheckboxKt.access$drawBox-1wkBAMs(drawScope, CheckboxKt.access$CheckboxImpl$lambda-9(this.$boxColor$delegate), CheckboxKt.access$CheckboxImpl$lambda-10(this.$borderColor$delegate), drawScope.toPx-0680j_4(CheckboxKt.access$getRadiusSize$p()), floor);
        CheckboxKt.access$drawCheck-3IgeMak(drawScope, CheckboxKt.access$CheckboxImpl$lambda-8(this.$checkColor$delegate), CheckboxKt.access$CheckboxImpl$lambda-4(this.$checkDrawFraction$delegate), CheckboxKt.access$CheckboxImpl$lambda-6(this.$checkCenterGravitationShiftFraction$delegate), floor, this.$checkCache);
    }
}
