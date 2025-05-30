package androidx.compose.p004ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes.dex */
public final class TransformOrigin {
    private final long packedValue;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final long Center = TransformOriginKt.TransformOrigin(0.5f, 0.5f);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getCenter-SzJe1aQ, reason: not valid java name */
        public final long m3130getCenterSzJe1aQ() {
            return TransformOrigin.Center;
        }
    }

    private /* synthetic */ TransformOrigin(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TransformOrigin m3117boximpl(long j) {
        return new TransformOrigin(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m3118component1impl(long j) {
        return m3125getPivotFractionXimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m3119component2impl(long j) {
        return m3126getPivotFractionYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m3120constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-zey9I6w, reason: not valid java name */
    public static final long m3121copyzey9I6w(long j, float f, float f2) {
        return TransformOriginKt.TransformOrigin(f, f2);
    }

    /* renamed from: copy-zey9I6w$default, reason: not valid java name */
    public static /* synthetic */ long m3122copyzey9I6w$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m3125getPivotFractionXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m3126getPivotFractionYimpl(j);
        }
        return m3121copyzey9I6w(j, f, f2);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3123equalsimpl(long j, Object obj) {
        return (obj instanceof TransformOrigin) && j == ((TransformOrigin) obj).m3129unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3124equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getPivotFractionX-impl, reason: not valid java name */
    public static final float m3125getPivotFractionXimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getPivotFractionY-impl, reason: not valid java name */
    public static final float m3126getPivotFractionYimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3127hashCodeimpl(long j) {
        return c8.a(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3128toStringimpl(long j) {
        return "TransformOrigin(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m3123equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m3127hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m3128toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m3129unboximpl() {
        return this.packedValue;
    }
}
