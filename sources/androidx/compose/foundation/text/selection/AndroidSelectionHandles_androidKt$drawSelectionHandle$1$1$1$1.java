package androidx.compose.foundation.text.selection;

import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ ColorFilter $colorFilter;
    final /* synthetic */ ResolvedTextDirection $direction;
    final /* synthetic */ ImageBitmap $handleImage;
    final /* synthetic */ boolean $handlesCrossed;
    final /* synthetic */ boolean $isStartHandle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1$1(boolean z, ResolvedTextDirection resolvedTextDirection, boolean z2, ImageBitmap imageBitmap, ColorFilter colorFilter) {
        super(1);
        this.$isStartHandle = z;
        this.$direction = resolvedTextDirection;
        this.$handlesCrossed = z2;
        this.$handleImage = imageBitmap;
        this.$colorFilter = colorFilter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
        boolean isLeft;
        Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
        contentDrawScope.drawContent();
        isLeft = AndroidSelectionHandles_androidKt.isLeft(this.$isStartHandle, this.$direction, this.$handlesCrossed);
        if (!isLeft) {
            w51.A(contentDrawScope, this.$handleImage, 0L, 0.0f, (DrawStyle) null, this.$colorFilter, 0, 46, (Object) null);
            return;
        }
        ImageBitmap imageBitmap = this.$handleImage;
        ColorFilter colorFilter = this.$colorFilter;
        long j = contentDrawScope.getCenter-F1C5BW0();
        DrawContext drawContext = contentDrawScope.getDrawContext();
        long mo1254getSizeNHjbRc = drawContext.mo1254getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().scale-0AR0LA0(-1.0f, 1.0f, j);
        w51.A(contentDrawScope, imageBitmap, 0L, 0.0f, (DrawStyle) null, colorFilter, 0, 46, (Object) null);
        drawContext.getCanvas().restore();
        drawContext.mo1255setSizeuvyYCjk(mo1254getSizeNHjbRc);
    }
}
