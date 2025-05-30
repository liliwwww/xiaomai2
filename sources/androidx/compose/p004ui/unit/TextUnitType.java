package androidx.compose.p004ui.unit;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
public final class TextUnitType {
    private final long type;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified = m5423constructorimpl(0);

    /* renamed from: Sp */
    private static final long f214Sp = m5423constructorimpl(4294967296L);

    /* renamed from: Em */
    private static final long f213Em = m5423constructorimpl(8589934592L);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getEm-UIouoOA, reason: not valid java name */
        public final long m5429getEmUIouoOA() {
            return TextUnitType.f213Em;
        }

        /* renamed from: getSp-UIouoOA, reason: not valid java name */
        public final long m5430getSpUIouoOA() {
            return TextUnitType.f214Sp;
        }

        /* renamed from: getUnspecified-UIouoOA, reason: not valid java name */
        public final long m5431getUnspecifiedUIouoOA() {
            return TextUnitType.Unspecified;
        }
    }

    private /* synthetic */ TextUnitType(long j) {
        this.type = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnitType m5422boximpl(long j) {
        return new TextUnitType(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5423constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5424equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnitType) && j == ((TextUnitType) obj).m5428unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5425equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5426hashCodeimpl(long j) {
        return c8.a(j);
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5427toStringimpl(long j) {
        return m5425equalsimpl0(j, Unspecified) ? "Unspecified" : m5425equalsimpl0(j, f214Sp) ? "Sp" : m5425equalsimpl0(j, f213Em) ? "Em" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m5424equalsimpl(this.type, obj);
    }

    public int hashCode() {
        return m5426hashCodeimpl(this.type);
    }

    @NotNull
    public String toString() {
        return m5427toStringimpl(this.type);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5428unboximpl() {
        return this.type;
    }
}
