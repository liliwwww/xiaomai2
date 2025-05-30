package androidx.compose.foundation.lazy.grid;

import kotlin.jvm.JvmInline;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
public final class ItemIndex {
    private final int value;

    private /* synthetic */ ItemIndex(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ItemIndex m1542boximpl(int i) {
        return new ItemIndex(i);
    }

    /* renamed from: compareTo-YGsSkvE, reason: not valid java name */
    public static final int m1543compareToYGsSkvE(int i, int i2) {
        return i - i2;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1544constructorimpl(int i) {
        return i;
    }

    /* renamed from: dec-VZbfaAc, reason: not valid java name */
    public static final int m1545decVZbfaAc(int i) {
        return m1544constructorimpl(i - 1);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1546equalsimpl(int i, Object obj) {
        return (obj instanceof ItemIndex) && i == ((ItemIndex) obj).m1554unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1547equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1548hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: inc-VZbfaAc, reason: not valid java name */
    public static final int m1549incVZbfaAc(int i) {
        return m1544constructorimpl(i + 1);
    }

    /* renamed from: minus-41DfMLM, reason: not valid java name */
    public static final int m1550minus41DfMLM(int i, int i2) {
        return m1544constructorimpl(i - i2);
    }

    /* renamed from: minus-AoD1bsw, reason: not valid java name */
    public static final int m1551minusAoD1bsw(int i, int i2) {
        return m1544constructorimpl(i - i2);
    }

    /* renamed from: plus-AoD1bsw, reason: not valid java name */
    public static final int m1552plusAoD1bsw(int i, int i2) {
        return m1544constructorimpl(i + i2);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1553toStringimpl(int i) {
        return "ItemIndex(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1546equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m1548hashCodeimpl(this.value);
    }

    public String toString() {
        return m1553toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1554unboximpl() {
        return this.value;
    }
}
