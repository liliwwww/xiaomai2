package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BorderKt$border$2$1 extends Lambda implements Function1<CacheDrawScope, DrawResult> {
    final /* synthetic */ Ref<BorderCache> $borderCacheRef;
    final /* synthetic */ Brush $brush;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ float $width;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BorderKt$border$2$1(float f, Shape shape, Ref<BorderCache> ref, Brush brush) {
        super(1);
        this.$width = f;
        this.$shape = shape;
        this.$borderCacheRef = ref;
        this.$brush = brush;
    }

    @NotNull
    public final DrawResult invoke(@NotNull CacheDrawScope cacheDrawScope) {
        Intrinsics.checkNotNullParameter(cacheDrawScope, "$this$drawWithCache");
        if (!(cacheDrawScope.toPx-0680j_4(this.$width) >= 0.0f && Size.getMinDimension-impl(cacheDrawScope.m943getSizeNHjbRc()) > 0.0f)) {
            return BorderKt.access$drawContentWithoutBorder(cacheDrawScope);
        }
        float f = 2;
        float min = Math.min(Dp.equals-impl0(this.$width, Dp.Companion.getHairline-D9Ej5fM()) ? 1.0f : (float) Math.ceil(cacheDrawScope.toPx-0680j_4(this.$width)), (float) Math.ceil(Size.getMinDimension-impl(cacheDrawScope.m943getSizeNHjbRc()) / f));
        float f2 = min / f;
        long Offset = OffsetKt.Offset(f2, f2);
        long Size = SizeKt.Size(Size.getWidth-impl(cacheDrawScope.m943getSizeNHjbRc()) - min, Size.getHeight-impl(cacheDrawScope.m943getSizeNHjbRc()) - min);
        boolean z = f * min > Size.getMinDimension-impl(cacheDrawScope.m943getSizeNHjbRc());
        Outline outline = this.$shape.createOutline-Pq9zytI(cacheDrawScope.m943getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
        if (outline instanceof Outline$Generic) {
            return BorderKt.access$drawGenericBorder(cacheDrawScope, this.$borderCacheRef, this.$brush, (Outline$Generic) outline, z, min);
        }
        if (outline instanceof Outline$Rounded) {
            return BorderKt.access$drawRoundRectBorder-SYlcjDY(cacheDrawScope, this.$borderCacheRef, this.$brush, (Outline$Rounded) outline, Offset, Size, z, min);
        }
        if (outline instanceof Outline$Rectangle) {
            return BorderKt.access$drawRectBorder-NsqcLGU(cacheDrawScope, this.$brush, Offset, Size, z, min);
        }
        throw new NoWhenBranchMatchedException();
    }
}
