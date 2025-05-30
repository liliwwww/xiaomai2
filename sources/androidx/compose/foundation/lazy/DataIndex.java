package androidx.compose.foundation.lazy;

import kotlin.jvm.JvmInline;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DataIndex {
    private final int value;

    private /* synthetic */ DataIndex(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DataIndex m243boximpl(int i) {
        return new DataIndex(i);
    }

    /* renamed from: compareTo-ZjPyQlc, reason: not valid java name */
    public static final int m244compareToZjPyQlc(int i, int i2) {
        return i - i2;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m245constructorimpl(int i) {
        return i;
    }

    /* renamed from: dec-jQJCoq8, reason: not valid java name */
    public static final int m246decjQJCoq8(int i) {
        return m245constructorimpl(i - 1);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m247equalsimpl(int i, Object obj) {
        return (obj instanceof DataIndex) && i == ((DataIndex) obj).m255unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m248equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m249hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: inc-jQJCoq8, reason: not valid java name */
    public static final int m250incjQJCoq8(int i) {
        return m245constructorimpl(i + 1);
    }

    /* renamed from: minus-PBKCTt8, reason: not valid java name */
    public static final int m251minusPBKCTt8(int i, int i2) {
        return m245constructorimpl(i - i2);
    }

    /* renamed from: minus-yUvdeeg, reason: not valid java name */
    public static final int m252minusyUvdeeg(int i, int i2) {
        return m245constructorimpl(i - i2);
    }

    /* renamed from: plus-PBKCTt8, reason: not valid java name */
    public static final int m253plusPBKCTt8(int i, int i2) {
        return m245constructorimpl(i + i2);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m254toStringimpl(int i) {
        return "DataIndex(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m247equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m249hashCodeimpl(this.value);
    }

    public String toString() {
        return m254toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m255unboximpl() {
        return this.value;
    }
}
