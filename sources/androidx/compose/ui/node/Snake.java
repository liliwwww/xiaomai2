package androidx.compose.ui.node;

import android.taobao.windvane.connect.api.ApiConstants;
import java.util.Arrays;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class Snake {

    @NotNull
    private final int[] data;

    private /* synthetic */ Snake(int[] iArr) {
        this.data = iArr;
    }

    /* renamed from: addDiagonalToStack-impl, reason: not valid java name */
    public static final void m2181addDiagonalToStackimpl(int[] iArr, @NotNull IntStack intStack) {
        Intrinsics.checkNotNullParameter(intStack, "diagonals");
        if (!m2189getHasAdditionOrRemovalimpl(iArr)) {
            intStack.pushDiagonal(m2191getStartXimpl(iArr), m2192getStartYimpl(iArr), m2187getEndXimpl(iArr) - m2191getStartXimpl(iArr));
            return;
        }
        if (m2190getReverseimpl(iArr)) {
            intStack.pushDiagonal(m2191getStartXimpl(iArr), m2192getStartYimpl(iArr), m2186getDiagonalSizeimpl(iArr));
        } else if (m2194isAdditionimpl(iArr)) {
            intStack.pushDiagonal(m2191getStartXimpl(iArr), m2192getStartYimpl(iArr) + 1, m2186getDiagonalSizeimpl(iArr));
        } else {
            intStack.pushDiagonal(m2191getStartXimpl(iArr) + 1, m2192getStartYimpl(iArr), m2186getDiagonalSizeimpl(iArr));
        }
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Snake m2182boximpl(int[] iArr) {
        return new Snake(iArr);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m2183constructorimpl(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, ApiConstants.DATA);
        return iArr;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2184equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof Snake) && Intrinsics.areEqual(iArr, ((Snake) obj).m2196unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2185equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    /* renamed from: getDiagonalSize-impl, reason: not valid java name */
    public static final int m2186getDiagonalSizeimpl(int[] iArr) {
        return Math.min(m2187getEndXimpl(iArr) - m2191getStartXimpl(iArr), m2188getEndYimpl(iArr) - m2192getStartYimpl(iArr));
    }

    /* renamed from: getEndX-impl, reason: not valid java name */
    public static final int m2187getEndXimpl(int[] iArr) {
        return iArr[2];
    }

    /* renamed from: getEndY-impl, reason: not valid java name */
    public static final int m2188getEndYimpl(int[] iArr) {
        return iArr[3];
    }

    /* renamed from: getHasAdditionOrRemoval-impl, reason: not valid java name */
    private static final boolean m2189getHasAdditionOrRemovalimpl(int[] iArr) {
        return m2188getEndYimpl(iArr) - m2192getStartYimpl(iArr) != m2187getEndXimpl(iArr) - m2191getStartXimpl(iArr);
    }

    /* renamed from: getReverse-impl, reason: not valid java name */
    public static final boolean m2190getReverseimpl(int[] iArr) {
        return iArr[4] != 0;
    }

    /* renamed from: getStartX-impl, reason: not valid java name */
    public static final int m2191getStartXimpl(int[] iArr) {
        return iArr[0];
    }

    /* renamed from: getStartY-impl, reason: not valid java name */
    public static final int m2192getStartYimpl(int[] iArr) {
        return iArr[1];
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2193hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* renamed from: isAddition-impl, reason: not valid java name */
    private static final boolean m2194isAdditionimpl(int[] iArr) {
        return m2188getEndYimpl(iArr) - m2192getStartYimpl(iArr) > m2187getEndXimpl(iArr) - m2191getStartXimpl(iArr);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2195toStringimpl(int[] iArr) {
        return "Snake(" + m2191getStartXimpl(iArr) + ',' + m2192getStartYimpl(iArr) + ',' + m2187getEndXimpl(iArr) + ',' + m2188getEndYimpl(iArr) + ',' + m2190getReverseimpl(iArr) + ')';
    }

    public boolean equals(Object obj) {
        return m2184equalsimpl(this.data, obj);
    }

    @NotNull
    public final int[] getData() {
        return this.data;
    }

    public int hashCode() {
        return m2193hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m2195toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m2196unboximpl() {
        return this.data;
    }
}
