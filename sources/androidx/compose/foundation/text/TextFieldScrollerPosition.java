package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextRange;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextFieldScrollerPosition {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Saver<TextFieldScrollerPosition, Object> Saver = ListSaverKt.listSaver(Companion.Saver.1.INSTANCE, Companion.Saver.2.INSTANCE);

    @NotNull
    private final MutableState maximum$delegate;

    @NotNull
    private final MutableState offset$delegate;

    @NotNull
    private final MutableState orientation$delegate;

    @NotNull
    private Rect previousCursorRect;
    private long previousSelection;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<TextFieldScrollerPosition, Object> getSaver() {
            return TextFieldScrollerPosition.Saver;
        }
    }

    public TextFieldScrollerPosition(@NotNull Orientation orientation, float f) {
        Intrinsics.checkNotNullParameter(orientation, "initialOrientation");
        this.offset$delegate = SnapshotStateKt.mutableStateOf$default(Float.valueOf(f), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.maximum$delegate = SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.previousCursorRect = Rect.Companion.getZero();
        this.previousSelection = TextRange.Companion.m1893getZerod9O1mEE();
        this.orientation$delegate = SnapshotStateKt.mutableStateOf(orientation, SnapshotStateKt.structuralEqualityPolicy());
    }

    private final void setMaximum(float f) {
        this.maximum$delegate.setValue(Float.valueOf(f));
    }

    public final void coerceOffset$foundation_release(float f, float f2, int i) {
        float offset = getOffset();
        float f3 = i;
        float f4 = offset + f3;
        setOffset(getOffset() + ((f2 <= f4 && (f >= offset || f2 - f <= f3)) ? (f >= offset || f2 - f > f3) ? 0.0f : f - offset : f2 - f4));
    }

    public final float getMaximum() {
        return ((Number) this.maximum$delegate.getValue()).floatValue();
    }

    public final float getOffset() {
        return ((Number) this.offset$delegate.getValue()).floatValue();
    }

    /* renamed from: getOffsetToFollow-5zc-tL8, reason: not valid java name */
    public final int m444getOffsetToFollow5zctL8(long j) {
        return TextRange.getStart-impl(j) != TextRange.getStart-impl(this.previousSelection) ? TextRange.getStart-impl(j) : TextRange.getEnd-impl(j) != TextRange.getEnd-impl(this.previousSelection) ? TextRange.getEnd-impl(j) : TextRange.getMin-impl(j);
    }

    @NotNull
    public final Orientation getOrientation() {
        return (Orientation) this.orientation$delegate.getValue();
    }

    /* renamed from: getPreviousSelection-d9O1mEE, reason: not valid java name */
    public final long m445getPreviousSelectiond9O1mEE() {
        return this.previousSelection;
    }

    public final void setOffset(float f) {
        this.offset$delegate.setValue(Float.valueOf(f));
    }

    public final void setOrientation(@NotNull Orientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "<set-?>");
        this.orientation$delegate.setValue(orientation);
    }

    /* renamed from: setPreviousSelection-5zc-tL8, reason: not valid java name */
    public final void m446setPreviousSelection5zctL8(long j) {
        this.previousSelection = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
    
        if ((r6.getTop() == r4.previousCursorRect.getTop()) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void update(@org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.Orientation r5, @org.jetbrains.annotations.NotNull androidx.compose.ui.geometry.Rect r6, int r7, int r8) {
        /*
            r4 = this;
            java.lang.String r0 = "orientation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "cursorRect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r8 = r8 - r7
            float r8 = (float) r8
            r4.setMaximum(r8)
            float r0 = r6.getLeft()
            androidx.compose.ui.geometry.Rect r1 = r4.previousCursorRect
            float r1 = r1.getLeft()
            r2 = 1
            r3 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L22
            r0 = 1
            goto L23
        L22:
            r0 = 0
        L23:
            if (r0 == 0) goto L38
            float r0 = r6.getTop()
            androidx.compose.ui.geometry.Rect r1 = r4.previousCursorRect
            float r1 = r1.getTop()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L35
            r0 = 1
            goto L36
        L35:
            r0 = 0
        L36:
            if (r0 != 0) goto L59
        L38:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r5 != r0) goto L3d
            goto L3e
        L3d:
            r2 = 0
        L3e:
            if (r2 == 0) goto L45
            float r5 = r6.getTop()
            goto L49
        L45:
            float r5 = r6.getLeft()
        L49:
            if (r2 == 0) goto L50
            float r0 = r6.getBottom()
            goto L54
        L50:
            float r0 = r6.getRight()
        L54:
            r4.coerceOffset$foundation_release(r5, r0, r7)
            r4.previousCursorRect = r6
        L59:
            float r5 = r4.getOffset()
            r6 = 0
            float r5 = kotlin.ranges.RangesKt.coerceIn(r5, r6, r8)
            r4.setOffset(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldScrollerPosition.update(androidx.compose.foundation.gestures.Orientation, androidx.compose.ui.geometry.Rect, int, int):void");
    }

    public /* synthetic */ TextFieldScrollerPosition(Orientation orientation, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(orientation, (i & 2) != 0 ? 0.0f : f);
    }

    public TextFieldScrollerPosition() {
        this(Orientation.Vertical, 0.0f, 2, null);
    }
}
