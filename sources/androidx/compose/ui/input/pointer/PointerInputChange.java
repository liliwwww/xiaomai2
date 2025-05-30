package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PointerInputChange {

    @Nullable
    private List<HistoricalChange> _historical;

    @Nullable
    private Float _pressure;

    @NotNull
    private ConsumedData consumed;
    private final long id;
    private final long position;
    private final boolean pressed;
    private final long previousPosition;
    private final boolean previousPressed;
    private final long previousUptimeMillis;
    private final long scrollDelta;
    private final int type;
    private final long uptimeMillis;

    @ExperimentalComposeUiApi
    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, j6);
    }

    @ExperimentalComposeUiApi
    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, List list, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, (List<HistoricalChange>) list, j6);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another constructor with `scrollDelta` and without `ConsumedData` instead", replaceWith = @ReplaceWith(expression = "this(id, uptimeMillis, position, pressed, previousUptimeMillis, previousPosition, previousPressed, consumed.downChange || consumed.positionChange, type, Offset.Zero)", imports = {}))
    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, consumedData, i);
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, int i, long j6) {
        this.id = j;
        this.uptimeMillis = j2;
        this.position = j3;
        this.pressed = z;
        this.previousUptimeMillis = j4;
        this.previousPosition = j5;
        this.previousPressed = z2;
        this.type = i;
        this.scrollDelta = j6;
        this.consumed = new ConsumedData(z3, z3);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, int i, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, z3, i, j6);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, int i, List list, long j6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, z3, i, (List<HistoricalChange>) list, j6);
    }

    @Deprecated(message = "use isConsumed and consume() pair of methods instead")
    public static /* synthetic */ void getConsumed$annotations() {
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getHistorical$annotations() {
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getPressure$annotations() {
    }

    public static /* synthetic */ void isConsumed$annotations() {
    }

    public final void consume() {
        this.consumed.setDownChange(true);
        this.consumed.setPositionChange(true);
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use copy() instead without `consumed` parameter to create a shallow copy or a constructor to create a new PointerInputChange", replaceWith = @ReplaceWith(expression = "copy(id, currentTime, currentPosition, currentPressed, previousTime, previousPosition, previousPressed, type, scrollDelta)", imports = {}))
    @NotNull
    /* renamed from: copy-0GkPj7c, reason: not valid java name */
    public final PointerInputChange m1459copy0GkPj7c(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, @NotNull ConsumedData consumedData, int i, long j6) {
        Intrinsics.checkNotNullParameter(consumedData, "consumed");
        PointerInputChange pointerInputChange = new PointerInputChange(j, j2, j3, z, getPressure(), j4, j5, z2, consumedData.getDownChange() || consumedData.getPositionChange(), i, getHistorical(), j6, (DefaultConstructorMarker) null);
        this.consumed = consumedData;
        return pointerInputChange;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another copy() method with scrollDelta parameter instead", replaceWith = @ReplaceWith(expression = "copy(id,currentTime, currentPosition, currentPressed, previousTime,previousPosition, previousPressed, consumed, type, this.scrollDelta)", imports = {}))
    /* renamed from: copy-Ezr-O64, reason: not valid java name */
    public final /* synthetic */ PointerInputChange m1460copyEzrO64(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i) {
        Intrinsics.checkNotNullParameter(consumedData, "consumed");
        PointerInputChange pointerInputChange = new PointerInputChange(j, j2, j3, z, getPressure(), j4, j5, z2, consumedData.getDownChange() || consumedData.getPositionChange(), i, getHistorical(), this.scrollDelta, (DefaultConstructorMarker) null);
        this.consumed = consumedData;
        return pointerInputChange;
    }

    @NotNull
    /* renamed from: copy-JKmWfYY, reason: not valid java name */
    public final PointerInputChange m1461copyJKmWfYY(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, int i, long j6) {
        PointerInputChange pointerInputChange = new PointerInputChange(j, j2, j3, z, getPressure(), j4, j5, z2, false, i, (List) getHistorical(), j6, (DefaultConstructorMarker) null);
        pointerInputChange.consumed = this.consumed;
        return pointerInputChange;
    }

    @ExperimentalComposeUiApi
    @NotNull
    /* renamed from: copy-OHpmEuE, reason: not valid java name */
    public final PointerInputChange m1462copyOHpmEuE(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, int i, @NotNull List<HistoricalChange> list, long j6) {
        Intrinsics.checkNotNullParameter(list, "historical");
        PointerInputChange pointerInputChange = new PointerInputChange(j, j2, j3, z, getPressure(), j4, j5, z2, false, i, (List) list, j6, (DefaultConstructorMarker) null);
        pointerInputChange.consumed = this.consumed;
        return pointerInputChange;
    }

    @ExperimentalComposeUiApi
    @NotNull
    /* renamed from: copy-wbzehF4, reason: not valid java name */
    public final PointerInputChange m1463copywbzehF4(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, int i, @NotNull List<HistoricalChange> list, long j6) {
        Intrinsics.checkNotNullParameter(list, "historical");
        PointerInputChange pointerInputChange = new PointerInputChange(j, j2, j3, z, f, j4, j5, z2, false, i, (List) list, j6, (DefaultConstructorMarker) null);
        pointerInputChange.consumed = this.consumed;
        return pointerInputChange;
    }

    @NotNull
    public final ConsumedData getConsumed() {
        return this.consumed;
    }

    @ExperimentalComposeUiApi
    @NotNull
    public final List<HistoricalChange> getHistorical() {
        List<HistoricalChange> list = this._historical;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    /* renamed from: getId-J3iCeTQ, reason: not valid java name */
    public final long m1464getIdJ3iCeTQ() {
        return this.id;
    }

    /* renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m1465getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    @ExperimentalComposeUiApi
    public final float getPressure() {
        Float f = this._pressure;
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    /* renamed from: getPreviousPosition-F1C5BW0, reason: not valid java name */
    public final long m1466getPreviousPositionF1C5BW0() {
        return this.previousPosition;
    }

    public final boolean getPreviousPressed() {
        return this.previousPressed;
    }

    public final long getPreviousUptimeMillis() {
        return this.previousUptimeMillis;
    }

    /* renamed from: getScrollDelta-F1C5BW0, reason: not valid java name */
    public final long m1467getScrollDeltaF1C5BW0() {
        return this.scrollDelta;
    }

    /* renamed from: getType-T8wyACA, reason: not valid java name */
    public final int m1468getTypeT8wyACA() {
        return this.type;
    }

    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final boolean isConsumed() {
        return this.consumed.getDownChange() || this.consumed.getPositionChange();
    }

    @NotNull
    public String toString() {
        return "PointerInputChange(id=" + ((Object) PointerId.m1452toStringimpl(this.id)) + ", uptimeMillis=" + this.uptimeMillis + ", position=" + ((Object) Offset.m856toStringimpl(this.position)) + ", pressed=" + this.pressed + ", pressure=" + getPressure() + ", previousUptimeMillis=" + this.previousUptimeMillis + ", previousPosition=" + ((Object) Offset.m856toStringimpl(this.previousPosition)) + ", previousPressed=" + this.previousPressed + ", isConsumed=" + isConsumed() + ", type=" + ((Object) PointerType.toString-impl(this.type)) + ", historical=" + getHistorical() + ",scrollDelta=" + ((Object) Offset.m856toStringimpl(this.scrollDelta)) + ')';
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, int i, long j6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, z3, (i2 & 256) != 0 ? PointerType.Companion.m1486getTouchT8wyACA() : i, (i2 & 512) != 0 ? Offset.Companion.getZero-F1C5BW0() : j6, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, j4, j5, z2, consumedData, (i2 & 256) != 0 ? PointerType.Companion.m1486getTouchT8wyACA() : i, (DefaultConstructorMarker) null);
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, ConsumedData consumedData, int i) {
        this(j, j2, j3, z, 1.0f, j4, j5, z2, consumedData.getDownChange() || consumedData.getPositionChange(), i, Offset.Companion.getZero-F1C5BW0(), (DefaultConstructorMarker) null);
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, long j4, long j5, boolean z2, boolean z3, int i, List<HistoricalChange> list, long j6) {
        this(j, j2, j3, z, 1.0f, j4, j5, z2, z3, i, list, j6, (DefaultConstructorMarker) null);
        this._historical = list;
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, List<HistoricalChange> list, long j6) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, i, j6, (DefaultConstructorMarker) null);
        this._historical = list;
    }

    public /* synthetic */ PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, z, f, j4, j5, z2, z3, (i2 & 512) != 0 ? PointerType.Companion.m1486getTouchT8wyACA() : i, (i2 & 1024) != 0 ? Offset.Companion.getZero-F1C5BW0() : j6, (DefaultConstructorMarker) null);
    }

    private PointerInputChange(long j, long j2, long j3, boolean z, float f, long j4, long j5, boolean z2, boolean z3, int i, long j6) {
        this(j, j2, j3, z, j4, j5, z2, z3, i, j6, (DefaultConstructorMarker) null);
        this._pressure = Float.valueOf(f);
    }
}
