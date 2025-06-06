package androidx.compose.foundation.lazy.grid;

import kotlin.jvm.JvmInline;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LineIndex {
    private final int value;

    private /* synthetic */ LineIndex(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LineIndex m473boximpl(int i) {
        return new LineIndex(i);
    }

    /* renamed from: compareTo-bKFJvoY, reason: not valid java name */
    public static final int m474compareTobKFJvoY(int i, int i2) {
        return i - i2;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m475constructorimpl(int i) {
        return i;
    }

    /* renamed from: dec-hA7yfN8, reason: not valid java name */
    public static final int m476dechA7yfN8(int i) {
        return m475constructorimpl(i - 1);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m477equalsimpl(int i, Object obj) {
        return (obj instanceof LineIndex) && i == ((LineIndex) obj).m485unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m478equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m479hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: inc-hA7yfN8, reason: not valid java name */
    public static final int m480inchA7yfN8(int i) {
        return m475constructorimpl(i + 1);
    }

    /* renamed from: minus--_Ze7BM, reason: not valid java name */
    public static final int m481minus_Ze7BM(int i, int i2) {
        return m475constructorimpl(i - i2);
    }

    /* renamed from: minus-fVkYB0M, reason: not valid java name */
    public static final int m482minusfVkYB0M(int i, int i2) {
        return m475constructorimpl(i - i2);
    }

    /* renamed from: plus--_Ze7BM, reason: not valid java name */
    public static final int m483plus_Ze7BM(int i, int i2) {
        return m475constructorimpl(i + i2);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m484toStringimpl(int i) {
        return "LineIndex(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m477equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m479hashCodeimpl(this.value);
    }

    public String toString() {
        return m484toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m485unboximpl() {
        return this.value;
    }
}
