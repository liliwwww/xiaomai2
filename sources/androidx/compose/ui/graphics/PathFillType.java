package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PathFillType {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int NonZero = m1181constructorimpl(0);
    private static final int EvenOdd = m1181constructorimpl(1);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getEvenOdd-Rg-k1Os, reason: not valid java name */
        public final int m1187getEvenOddRgk1Os() {
            return PathFillType.EvenOdd;
        }

        /* renamed from: getNonZero-Rg-k1Os, reason: not valid java name */
        public final int m1188getNonZeroRgk1Os() {
            return PathFillType.NonZero;
        }
    }

    private /* synthetic */ PathFillType(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PathFillType m1180boximpl(int i) {
        return new PathFillType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1181constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1182equalsimpl(int i, Object obj) {
        return (obj instanceof PathFillType) && i == ((PathFillType) obj).m1186unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1183equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1184hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1185toStringimpl(int i) {
        return m1183equalsimpl0(i, NonZero) ? "NonZero" : m1183equalsimpl0(i, EvenOdd) ? "EvenOdd" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1182equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1184hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1185toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1186unboximpl() {
        return this.value;
    }
}
