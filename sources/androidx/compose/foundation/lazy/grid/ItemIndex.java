package androidx.compose.foundation.lazy.grid;

import kotlin.jvm.JvmInline;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ItemIndex {
    private final int value;

    private /* synthetic */ ItemIndex(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ItemIndex m439boximpl(int i) {
        return new ItemIndex(i);
    }

    /* renamed from: compareTo-YGsSkvE, reason: not valid java name */
    public static final int m440compareToYGsSkvE(int i, int i2) {
        return i - i2;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m441constructorimpl(int i) {
        return i;
    }

    /* renamed from: dec-VZbfaAc, reason: not valid java name */
    public static final int m442decVZbfaAc(int i) {
        return m441constructorimpl(i - 1);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m443equalsimpl(int i, Object obj) {
        return (obj instanceof ItemIndex) && i == ((ItemIndex) obj).m451unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m444equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m445hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: inc-VZbfaAc, reason: not valid java name */
    public static final int m446incVZbfaAc(int i) {
        return m441constructorimpl(i + 1);
    }

    /* renamed from: minus-41DfMLM, reason: not valid java name */
    public static final int m447minus41DfMLM(int i, int i2) {
        return m441constructorimpl(i - i2);
    }

    /* renamed from: minus-AoD1bsw, reason: not valid java name */
    public static final int m448minusAoD1bsw(int i, int i2) {
        return m441constructorimpl(i - i2);
    }

    /* renamed from: plus-AoD1bsw, reason: not valid java name */
    public static final int m449plusAoD1bsw(int i, int i2) {
        return m441constructorimpl(i + i2);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m450toStringimpl(int i) {
        return "ItemIndex(value=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m443equalsimpl(this.value, obj);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return m445hashCodeimpl(this.value);
    }

    public String toString() {
        return m450toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m451unboximpl() {
        return this.value;
    }
}
