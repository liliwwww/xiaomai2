package androidx.compose.foundation.lazy;

import kotlin.jvm.JvmInline;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes.dex */
public final class DataIndex {
    private final int value;

    private /* synthetic */ DataIndex(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DataIndex m1481boximpl(int i) {
        return new DataIndex(i);
    }

    /* renamed from: compareTo-ZjPyQlc, reason: not valid java name */
    public static final int m1482compareToZjPyQlc(int i, int i2) {
        return i - i2;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1483constructorimpl(int i) {
        return i;
    }

    /* renamed from: dec-jQJCoq8, reason: not valid java name */
    public static final int m1484decjQJCoq8(int i) {
        return m1483constructorimpl(i - 1);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1485equalsimpl(int i, Object obj) {
        return (obj instanceof DataIndex) && i == ((DataIndex) obj).m1493unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1486equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1487hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: inc-jQJCoq8, reason: not valid java name */
    public static final int m1488incjQJCoq8(int i) {
        return m1483constructorimpl(i + 1);
    }

    /* renamed from: minus-PBKCTt8, reason: not valid java name */
    public static final int m1489minusPBKCTt8(int i, int i2) {
        return m1483constructorimpl(i - i2);
    }

    /* renamed from: minus-yUvdeeg, reason: not valid java name */
    public static final int m1490minusyUvdeeg(int i, int i2) {
        return m1483constructorimpl(i - i2);
    }

    /* renamed from: plus-PBKCTt8, reason: not valid java name */
    public static final int m1491plusPBKCTt8(int i, int i2) {
        return m1483constructorimpl(i + i2);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1492toStringimpl(int i) {
        return "DataIndex(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1485equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m1487hashCodeimpl(this.value);
    }

    public String toString() {
        return m1492toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1493unboximpl() {
        return this.value;
    }
}
