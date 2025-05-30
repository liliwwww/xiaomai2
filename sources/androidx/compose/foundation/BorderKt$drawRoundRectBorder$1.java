package androidx.compose.foundation;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BorderKt$drawRoundRectBorder$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ long $borderSize;
    final /* synthetic */ Stroke $borderStroke;
    final /* synthetic */ Brush $brush;
    final /* synthetic */ long $cornerRadius;
    final /* synthetic */ boolean $fillArea;
    final /* synthetic */ float $halfStroke;
    final /* synthetic */ float $strokeWidth;
    final /* synthetic */ long $topLeft;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BorderKt$drawRoundRectBorder$1(boolean z, Brush brush, long j, float f, float f2, long j2, long j3, Stroke stroke) {
        super(1);
        this.$fillArea = z;
        this.$brush = brush;
        this.$cornerRadius = j;
        this.$halfStroke = f;
        this.$strokeWidth = f2;
        this.$topLeft = j2;
        this.$borderSize = j3;
        this.$borderStroke = stroke;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
        contentDrawScope.drawContent();
        if (this.$fillArea) {
            w51.L(contentDrawScope, this.$brush, 0L, 0L, this.$cornerRadius, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 246, (Object) null);
            return;
        }
        float m1006getXimpl = CornerRadius.m1006getXimpl(this.$cornerRadius);
        float f = this.$halfStroke;
        if (m1006getXimpl >= f) {
            w51.L(contentDrawScope, this.$brush, this.$topLeft, this.$borderSize, BorderKt.access$shrink-Kibmq7A(this.$cornerRadius, f), 0.0f, this.$borderStroke, (ColorFilter) null, 0, 208, (Object) null);
            return;
        }
        float f2 = this.$strokeWidth;
        float f3 = Size.getWidth-impl(contentDrawScope.getSize-NH-jbRc()) - this.$strokeWidth;
        float f4 = Size.getHeight-impl(contentDrawScope.getSize-NH-jbRc()) - this.$strokeWidth;
        int m1057getDifferencertfAjoo = ClipOp.Companion.m1057getDifferencertfAjoo();
        Brush brush = this.$brush;
        long j = this.$cornerRadius;
        DrawContext drawContext = contentDrawScope.getDrawContext();
        long mo1254getSizeNHjbRc = drawContext.mo1254getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().clipRect-N_I0leg(f2, f2, f3, f4, m1057getDifferencertfAjoo);
        w51.L(contentDrawScope, brush, 0L, 0L, j, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 246, (Object) null);
        drawContext.getCanvas().restore();
        drawContext.mo1255setSizeuvyYCjk(mo1254getSizeNHjbRc);
    }
}
