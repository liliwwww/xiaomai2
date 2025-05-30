package androidx.compose.foundation.text.selection;

import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntOffsetKt;
import androidx.compose.p004ui.unit.IntRect;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.p004ui.window.PopupPositionProvider;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class HandlePositionProvider implements PopupPositionProvider {

    @NotNull
    private final HandleReferencePoint handleReferencePoint;
    private final long offset;

    /* compiled from: Taobao */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HandleReferencePoint.values().length];
            try {
                iArr[HandleReferencePoint.TopLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HandleReferencePoint.TopRight.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HandleReferencePoint.TopMiddle.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private HandlePositionProvider(HandleReferencePoint handleReferencePoint, long j) {
        this.handleReferencePoint = handleReferencePoint;
        this.offset = j;
    }

    public /* synthetic */ HandlePositionProvider(HandleReferencePoint handleReferencePoint, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(handleReferencePoint, j);
    }

    @Override // androidx.compose.p004ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4, reason: not valid java name */
    public long mo1824calculatePositionllwVHH4(@NotNull IntRect intRect, long j, @NotNull LayoutDirection layoutDirection, long j2) {
        Intrinsics.checkNotNullParameter(intRect, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int i = WhenMappings.$EnumSwitchMapping$0[this.handleReferencePoint.ordinal()];
        if (i == 1) {
            return IntOffsetKt.IntOffset(intRect.getLeft() + IntOffset.m5334getXimpl(this.offset), intRect.getTop() + IntOffset.m5335getYimpl(this.offset));
        }
        if (i == 2) {
            return IntOffsetKt.IntOffset((intRect.getLeft() + IntOffset.m5334getXimpl(this.offset)) - IntSize.m5376getWidthimpl(j2), intRect.getTop() + IntOffset.m5335getYimpl(this.offset));
        }
        if (i == 3) {
            return IntOffsetKt.IntOffset((intRect.getLeft() + IntOffset.m5334getXimpl(this.offset)) - (IntSize.m5376getWidthimpl(j2) / 2), intRect.getTop() + IntOffset.m5335getYimpl(this.offset));
        }
        throw new NoWhenBranchMatchedException();
    }
}
