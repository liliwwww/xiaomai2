package androidx.compose.ui.unit;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextUnitType {
    private final long type;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified = m2692constructorimpl(0);
    private static final long Sp = m2692constructorimpl(4294967296L);
    private static final long Em = m2692constructorimpl(8589934592L);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getEm-UIouoOA, reason: not valid java name */
        public final long m2698getEmUIouoOA() {
            return TextUnitType.Em;
        }

        /* renamed from: getSp-UIouoOA, reason: not valid java name */
        public final long m2699getSpUIouoOA() {
            return TextUnitType.Sp;
        }

        /* renamed from: getUnspecified-UIouoOA, reason: not valid java name */
        public final long m2700getUnspecifiedUIouoOA() {
            return TextUnitType.Unspecified;
        }
    }

    private /* synthetic */ TextUnitType(long j) {
        this.type = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnitType m2691boximpl(long j) {
        return new TextUnitType(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2692constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2693equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnitType) && j == ((TextUnitType) obj).m2697unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2694equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2695hashCodeimpl(long j) {
        return c8.a(j);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2696toStringimpl(long j) {
        return m2694equalsimpl0(j, Unspecified) ? "Unspecified" : m2694equalsimpl0(j, Sp) ? "Sp" : m2694equalsimpl0(j, Em) ? "Em" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m2693equalsimpl(this.type, obj);
    }

    public int hashCode() {
        return m2695hashCodeimpl(this.type);
    }

    @NotNull
    public String toString() {
        return m2696toStringimpl(this.type);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m2697unboximpl() {
        return this.type;
    }
}
