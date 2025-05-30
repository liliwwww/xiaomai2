package androidx.compose.foundation.lazy.grid;

import kotlin.jvm.JvmInline;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
public final class LineIndex {
    private final int value;

    private /* synthetic */ LineIndex(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LineIndex m1598boximpl(int i) {
        return new LineIndex(i);
    }

    /* renamed from: compareTo-bKFJvoY, reason: not valid java name */
    public static final int m1599compareTobKFJvoY(int i, int i2) {
        return i - i2;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1600constructorimpl(int i) {
        return i;
    }

    /* renamed from: dec-hA7yfN8, reason: not valid java name */
    public static final int m1601dechA7yfN8(int i) {
        return m1600constructorimpl(i - 1);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1602equalsimpl(int i, Object obj) {
        return (obj instanceof LineIndex) && i == ((LineIndex) obj).m1610unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1603equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1604hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: inc-hA7yfN8, reason: not valid java name */
    public static final int m1605inchA7yfN8(int i) {
        return m1600constructorimpl(i + 1);
    }

    /* renamed from: minus--_Ze7BM, reason: not valid java name */
    public static final int m1606minus_Ze7BM(int i, int i2) {
        return m1600constructorimpl(i - i2);
    }

    /* renamed from: minus-fVkYB0M, reason: not valid java name */
    public static final int m1607minusfVkYB0M(int i, int i2) {
        return m1600constructorimpl(i - i2);
    }

    /* renamed from: plus--_Ze7BM, reason: not valid java name */
    public static final int m1608plus_Ze7BM(int i, int i2) {
        return m1600constructorimpl(i + i2);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1609toStringimpl(int i) {
        return "LineIndex(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1602equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m1604hashCodeimpl(this.value);
    }

    public String toString() {
        return m1609toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1610unboximpl() {
        return this.value;
    }
}
