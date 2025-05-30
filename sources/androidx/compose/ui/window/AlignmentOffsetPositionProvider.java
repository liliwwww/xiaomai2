package androidx.compose.ui.window;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AlignmentOffsetPositionProvider implements PopupPositionProvider {

    @NotNull
    private final Alignment alignment;
    private final long offset;

    private AlignmentOffsetPositionProvider(Alignment alignment, long j) {
        this.alignment = alignment;
        this.offset = j;
    }

    public /* synthetic */ AlignmentOffsetPositionProvider(Alignment alignment, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment, j);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long mo2247calculatePositionllwVHH4(@NotNull IntRect intRect, long j, @NotNull LayoutDirection layoutDirection, long j2) {
        Intrinsics.checkNotNullParameter(intRect, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        long IntOffset = IntOffsetKt.IntOffset(0, 0);
        Alignment alignment = this.alignment;
        IntSize.Companion companion = IntSize.Companion;
        long j3 = alignment.align-KFBX0sM(companion.getZero-YbymL2g(), IntSizeKt.IntSize(intRect.getWidth(), intRect.getHeight()), layoutDirection);
        long j4 = this.alignment.align-KFBX0sM(companion.getZero-YbymL2g(), IntSizeKt.IntSize(IntSize.getWidth-impl(j2), IntSize.getHeight-impl(j2)), layoutDirection);
        long IntOffset2 = IntOffsetKt.IntOffset(intRect.getLeft(), intRect.getTop());
        long IntOffset3 = IntOffsetKt.IntOffset(IntOffset.getX-impl(IntOffset) + IntOffset.getX-impl(IntOffset2), IntOffset.getY-impl(IntOffset) + IntOffset.getY-impl(IntOffset2));
        long IntOffset4 = IntOffsetKt.IntOffset(IntOffset.getX-impl(IntOffset3) + IntOffset.getX-impl(j3), IntOffset.getY-impl(IntOffset3) + IntOffset.getY-impl(j3));
        long IntOffset5 = IntOffsetKt.IntOffset(IntOffset.getX-impl(j4), IntOffset.getY-impl(j4));
        long IntOffset6 = IntOffsetKt.IntOffset(IntOffset.getX-impl(IntOffset4) - IntOffset.getX-impl(IntOffset5), IntOffset.getY-impl(IntOffset4) - IntOffset.getY-impl(IntOffset5));
        long IntOffset7 = IntOffsetKt.IntOffset(IntOffset.getX-impl(this.offset) * (layoutDirection == LayoutDirection.Ltr ? 1 : -1), IntOffset.getY-impl(this.offset));
        return IntOffsetKt.IntOffset(IntOffset.getX-impl(IntOffset6) + IntOffset.getX-impl(IntOffset7), IntOffset.getY-impl(IntOffset6) + IntOffset.getY-impl(IntOffset7));
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: getOffset-nOcc-ac, reason: not valid java name */
    public final long m2248getOffsetnOccac() {
        return this.offset;
    }
}
