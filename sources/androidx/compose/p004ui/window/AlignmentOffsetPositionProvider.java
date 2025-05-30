package androidx.compose.p004ui.window;

import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntOffsetKt;
import androidx.compose.p004ui.unit.IntRect;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.p004ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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

    @Override // androidx.compose.p004ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4 */
    public long mo1824calculatePositionllwVHH4(@NotNull IntRect intRect, long j, @NotNull LayoutDirection layoutDirection, long j2) {
        Intrinsics.checkNotNullParameter(intRect, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        long IntOffset = IntOffsetKt.IntOffset(0, 0);
        Alignment alignment = this.alignment;
        IntSize.Companion companion = IntSize.Companion;
        long mo2450alignKFBX0sM = alignment.mo2450alignKFBX0sM(companion.m5381getZeroYbymL2g(), IntSizeKt.IntSize(intRect.getWidth(), intRect.getHeight()), layoutDirection);
        long mo2450alignKFBX0sM2 = this.alignment.mo2450alignKFBX0sM(companion.m5381getZeroYbymL2g(), IntSizeKt.IntSize(IntSize.m5376getWidthimpl(j2), IntSize.m5375getHeightimpl(j2)), layoutDirection);
        long IntOffset2 = IntOffsetKt.IntOffset(intRect.getLeft(), intRect.getTop());
        long IntOffset3 = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset) + IntOffset.m5334getXimpl(IntOffset2), IntOffset.m5335getYimpl(IntOffset) + IntOffset.m5335getYimpl(IntOffset2));
        long IntOffset4 = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset3) + IntOffset.m5334getXimpl(mo2450alignKFBX0sM), IntOffset.m5335getYimpl(IntOffset3) + IntOffset.m5335getYimpl(mo2450alignKFBX0sM));
        long IntOffset5 = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(mo2450alignKFBX0sM2), IntOffset.m5335getYimpl(mo2450alignKFBX0sM2));
        long IntOffset6 = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset4) - IntOffset.m5334getXimpl(IntOffset5), IntOffset.m5335getYimpl(IntOffset4) - IntOffset.m5335getYimpl(IntOffset5));
        long IntOffset7 = IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(this.offset) * (layoutDirection == LayoutDirection.Ltr ? 1 : -1), IntOffset.m5335getYimpl(this.offset));
        return IntOffsetKt.IntOffset(IntOffset.m5334getXimpl(IntOffset6) + IntOffset.m5334getXimpl(IntOffset7), IntOffset.m5335getYimpl(IntOffset6) + IntOffset.m5335getYimpl(IntOffset7));
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: getOffset-nOcc-ac, reason: not valid java name */
    public final long m5460getOffsetnOccac() {
        return this.offset;
    }
}
