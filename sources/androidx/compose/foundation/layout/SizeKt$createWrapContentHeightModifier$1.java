package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SizeKt$createWrapContentHeightModifier$1 extends Lambda implements Function2<IntSize, LayoutDirection, IntOffset> {
    final /* synthetic */ Alignment$Vertical $align;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SizeKt$createWrapContentHeightModifier$1(Alignment$Vertical alignment$Vertical) {
        super(2);
        this.$align = alignment$Vertical;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return IntOffset.box-impl(m239invoke5SAbXVA(((IntSize) obj).unbox-impl(), (LayoutDirection) obj2));
    }

    /* renamed from: invoke-5SAbXVA, reason: not valid java name */
    public final long m239invoke5SAbXVA(long j, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 1>");
        return IntOffsetKt.IntOffset(0, this.$align.align(0, IntSize.getHeight-impl(j)));
    }
}
