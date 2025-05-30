package androidx.compose.p004ui.node;

import android.taobao.windvane.connect.api.ApiConstants;
import java.util.Arrays;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
final class Snake {

    @NotNull
    private final int[] data;

    private /* synthetic */ Snake(int[] iArr) {
        this.data = iArr;
    }

    /* renamed from: addDiagonalToStack-impl, reason: not valid java name */
    public static final void m4452addDiagonalToStackimpl(int[] iArr, @NotNull IntStack intStack) {
        Intrinsics.checkNotNullParameter(intStack, "diagonals");
        if (!m4460getHasAdditionOrRemovalimpl(iArr)) {
            intStack.pushDiagonal(m4462getStartXimpl(iArr), m4463getStartYimpl(iArr), m4458getEndXimpl(iArr) - m4462getStartXimpl(iArr));
            return;
        }
        if (m4461getReverseimpl(iArr)) {
            intStack.pushDiagonal(m4462getStartXimpl(iArr), m4463getStartYimpl(iArr), m4457getDiagonalSizeimpl(iArr));
        } else if (m4465isAdditionimpl(iArr)) {
            intStack.pushDiagonal(m4462getStartXimpl(iArr), m4463getStartYimpl(iArr) + 1, m4457getDiagonalSizeimpl(iArr));
        } else {
            intStack.pushDiagonal(m4462getStartXimpl(iArr) + 1, m4463getStartYimpl(iArr), m4457getDiagonalSizeimpl(iArr));
        }
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Snake m4453boximpl(int[] iArr) {
        return new Snake(iArr);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m4454constructorimpl(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, ApiConstants.DATA);
        return iArr;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4455equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof Snake) && Intrinsics.areEqual(iArr, ((Snake) obj).m4467unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4456equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    /* renamed from: getDiagonalSize-impl, reason: not valid java name */
    public static final int m4457getDiagonalSizeimpl(int[] iArr) {
        return Math.min(m4458getEndXimpl(iArr) - m4462getStartXimpl(iArr), m4459getEndYimpl(iArr) - m4463getStartYimpl(iArr));
    }

    /* renamed from: getEndX-impl, reason: not valid java name */
    public static final int m4458getEndXimpl(int[] iArr) {
        return iArr[2];
    }

    /* renamed from: getEndY-impl, reason: not valid java name */
    public static final int m4459getEndYimpl(int[] iArr) {
        return iArr[3];
    }

    /* renamed from: getHasAdditionOrRemoval-impl, reason: not valid java name */
    private static final boolean m4460getHasAdditionOrRemovalimpl(int[] iArr) {
        return m4459getEndYimpl(iArr) - m4463getStartYimpl(iArr) != m4458getEndXimpl(iArr) - m4462getStartXimpl(iArr);
    }

    /* renamed from: getReverse-impl, reason: not valid java name */
    public static final boolean m4461getReverseimpl(int[] iArr) {
        return iArr[4] != 0;
    }

    /* renamed from: getStartX-impl, reason: not valid java name */
    public static final int m4462getStartXimpl(int[] iArr) {
        return iArr[0];
    }

    /* renamed from: getStartY-impl, reason: not valid java name */
    public static final int m4463getStartYimpl(int[] iArr) {
        return iArr[1];
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4464hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* renamed from: isAddition-impl, reason: not valid java name */
    private static final boolean m4465isAdditionimpl(int[] iArr) {
        return m4459getEndYimpl(iArr) - m4463getStartYimpl(iArr) > m4458getEndXimpl(iArr) - m4462getStartXimpl(iArr);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4466toStringimpl(int[] iArr) {
        return "Snake(" + m4462getStartXimpl(iArr) + ',' + m4463getStartYimpl(iArr) + ',' + m4458getEndXimpl(iArr) + ',' + m4459getEndYimpl(iArr) + ',' + m4461getReverseimpl(iArr) + ')';
    }

    public boolean equals(Object obj) {
        return m4455equalsimpl(this.data, obj);
    }

    @NotNull
    public final int[] getData() {
        return this.data;
    }

    public int hashCode() {
        return m4464hashCodeimpl(this.data);
    }

    @NotNull
    public String toString() {
        return m4466toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m4467unboximpl() {
        return this.data;
    }
}
