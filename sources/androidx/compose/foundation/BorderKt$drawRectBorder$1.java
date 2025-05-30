package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BorderKt$drawRectBorder$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ Brush $brush;
    final /* synthetic */ long $rectTopLeft;
    final /* synthetic */ long $size;
    final /* synthetic */ DrawStyle $style;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BorderKt$drawRectBorder$1(Brush brush, long j, long j2, DrawStyle drawStyle) {
        super(1);
        this.$brush = brush;
        this.$rectTopLeft = j;
        this.$size = j2;
        this.$style = drawStyle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
        contentDrawScope.drawContent();
        w51.J(contentDrawScope, this.$brush, this.$rectTopLeft, this.$size, 0.0f, this.$style, (ColorFilter) null, 0, 104, (Object) null);
    }
}
