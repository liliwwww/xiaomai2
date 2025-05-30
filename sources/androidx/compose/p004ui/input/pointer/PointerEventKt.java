package androidx.compose.p004ui.input.pointer;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class PointerEventKt {
    @Deprecated(message = "Partial consumption has been deprecated. Use isConsumed instead", replaceWith = @ReplaceWith(expression = "isConsumed", imports = {}))
    public static final boolean anyChangeConsumed(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return pointerInputChange.isConsumed();
    }

    public static final boolean changedToDown(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return (pointerInputChange.isConsumed() || pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToDownIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return !pointerInputChange.getPreviousPressed() && pointerInputChange.getPressed();
    }

    public static final boolean changedToUp(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return (pointerInputChange.isConsumed() || !pointerInputChange.getPreviousPressed() || pointerInputChange.getPressed()) ? false : true;
    }

    public static final boolean changedToUpIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return pointerInputChange.getPreviousPressed() && !pointerInputChange.getPressed();
    }

    @Deprecated(message = "Use consume() instead", replaceWith = @ReplaceWith(expression = "consume()", imports = {}))
    public static final void consumeAllChanges(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        pointerInputChange.consume();
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use consume() instead.", replaceWith = @ReplaceWith(expression = "if (pressed != previousPressed) consume()", imports = {}))
    public static final void consumeDownChange(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        if (pointerInputChange.getPressed() != pointerInputChange.getPreviousPressed()) {
            pointerInputChange.consume();
        }
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use consume() instead.", replaceWith = @ReplaceWith(expression = "if (positionChange() != Offset.Zero) consume()", imports = {}))
    public static final void consumePositionChange(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        if (Offset.m2553equalsimpl0(positionChange(pointerInputChange), Offset.Companion.m2572getZeroF1C5BW0())) {
            return;
        }
        pointerInputChange.consume();
    }

    @Deprecated(message = "Use isOutOfBounds() that supports minimum touch target", replaceWith = @ReplaceWith(expression = "this.isOutOfBounds(size, extendedTouchPadding)", imports = {}))
    /* renamed from: isOutOfBounds-O0kMr_c, reason: not valid java name */
    public static final boolean m4028isOutOfBoundsO0kMr_c(@NotNull PointerInputChange pointerInputChange, long j) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "$this$isOutOfBounds");
        long m4081getPositionF1C5BW0 = pointerInputChange.m4081getPositionF1C5BW0();
        float m2556getXimpl = Offset.m2556getXimpl(m4081getPositionF1C5BW0);
        float m2557getYimpl = Offset.m2557getYimpl(m4081getPositionF1C5BW0);
        return m2556getXimpl < 0.0f || m2556getXimpl > ((float) IntSize.m5376getWidthimpl(j)) || m2557getYimpl < 0.0f || m2557getYimpl > ((float) IntSize.m5375getHeightimpl(j));
    }

    /* renamed from: isOutOfBounds-jwHxaWs, reason: not valid java name */
    public static final boolean m4029isOutOfBoundsjwHxaWs(@NotNull PointerInputChange pointerInputChange, long j, long j2) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "$this$isOutOfBounds");
        if (!PointerType.m4139equalsimpl0(pointerInputChange.m4084getTypeT8wyACA(), PointerType.Companion.m4146getTouchT8wyACA())) {
            return m4028isOutOfBoundsO0kMr_c(pointerInputChange, j);
        }
        long m4081getPositionF1C5BW0 = pointerInputChange.m4081getPositionF1C5BW0();
        float m2556getXimpl = Offset.m2556getXimpl(m4081getPositionF1C5BW0);
        float m2557getYimpl = Offset.m2557getYimpl(m4081getPositionF1C5BW0);
        return m2556getXimpl < (-Size.m2625getWidthimpl(j2)) || m2556getXimpl > ((float) IntSize.m5376getWidthimpl(j)) + Size.m2625getWidthimpl(j2) || m2557getYimpl < (-Size.m2622getHeightimpl(j2)) || m2557getYimpl > ((float) IntSize.m5375getHeightimpl(j)) + Size.m2622getHeightimpl(j2);
    }

    public static final long positionChange(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return positionChangeInternal(pointerInputChange, false);
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use isConsumed instead", replaceWith = @ReplaceWith(expression = "isConsumed", imports = {}))
    public static final boolean positionChangeConsumed(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return pointerInputChange.isConsumed();
    }

    public static final long positionChangeIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return positionChangeInternal(pointerInputChange, true);
    }

    private static final long positionChangeInternal(PointerInputChange pointerInputChange, boolean z) {
        long m2560minusMKHz9U = Offset.m2560minusMKHz9U(pointerInputChange.m4081getPositionF1C5BW0(), pointerInputChange.m4082getPreviousPositionF1C5BW0());
        return (z || !pointerInputChange.isConsumed()) ? m2560minusMKHz9U : Offset.Companion.m2572getZeroF1C5BW0();
    }

    static /* synthetic */ long positionChangeInternal$default(PointerInputChange pointerInputChange, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return positionChangeInternal(pointerInputChange, z);
    }

    public static final boolean positionChanged(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return !Offset.m2553equalsimpl0(positionChangeInternal(pointerInputChange, false), Offset.Companion.m2572getZeroF1C5BW0());
    }

    public static final boolean positionChangedIgnoreConsumed(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<this>");
        return !Offset.m2553equalsimpl0(positionChangeInternal(pointerInputChange, true), Offset.Companion.m2572getZeroF1C5BW0());
    }
}
