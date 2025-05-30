package androidx.compose.material;

import androidx.appcompat.R;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DrawerKt$Scrim$1$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ long $color;
    final /* synthetic */ Function0<Float> $fraction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DrawerKt$Scrim$1$1(long j, Function0<Float> function0) {
        super(1);
        this.$color = j;
        this.$fraction = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        w51.K(drawScope, this.$color, 0L, 0L, ((Number) this.$fraction.invoke()).floatValue(), (DrawStyle) null, (ColorFilter) null, 0, R.styleable.AppCompatTheme_windowActionBarOverlay, (Object) null);
    }
}
