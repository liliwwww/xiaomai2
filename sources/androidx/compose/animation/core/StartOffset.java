package androidx.compose.animation.core;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tb.c8;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
public final class StartOffset {
    private final long value;

    private /* synthetic */ StartOffset(long j) {
        this.value = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StartOffset m1068boximpl(long j) {
        return new StartOffset(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1069constructorimpl(int i, int i2) {
        return m1070constructorimpl(i * i2);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static long m1070constructorimpl(long j) {
        return j;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ long m1071constructorimpl$default(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 2) != 0) {
            i2 = StartOffsetType.Companion.m1086getDelayEo1U57Q();
        }
        return m1069constructorimpl(i, i2);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1072equalsimpl(long j, Object obj) {
        return (obj instanceof StartOffset) && j == ((StartOffset) obj).m1078unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1073equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getOffsetMillis-impl, reason: not valid java name */
    public static final int m1074getOffsetMillisimpl(long j) {
        return Math.abs((int) j);
    }

    /* renamed from: getOffsetType-Eo1U57Q, reason: not valid java name */
    public static final int m1075getOffsetTypeEo1U57Q(long j) {
        boolean z = j > 0;
        if (z) {
            return StartOffsetType.Companion.m1087getFastForwardEo1U57Q();
        }
        if (z) {
            throw new NoWhenBranchMatchedException();
        }
        return StartOffsetType.Companion.m1086getDelayEo1U57Q();
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1076hashCodeimpl(long j) {
        return c8.a(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1077toStringimpl(long j) {
        return "StartOffset(value=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m1072equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1076hashCodeimpl(this.value);
    }

    public String toString() {
        return m1077toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1078unboximpl() {
        return this.value;
    }
}
