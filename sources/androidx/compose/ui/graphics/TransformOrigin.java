package androidx.compose.ui.graphics;

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
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TransformOrigin {
    private final long packedValue;

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long Center = TransformOriginKt.TransformOrigin(0.5f, 0.5f);

    private /* synthetic */ TransformOrigin(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TransformOrigin m1262boximpl(long j) {
        return new TransformOrigin(j);
    }

    @Stable
    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m1263component1impl(long j) {
        return m1270getPivotFractionXimpl(j);
    }

    @Stable
    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m1264component2impl(long j) {
        return m1271getPivotFractionYimpl(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m1265constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-zey9I6w, reason: not valid java name */
    public static final long m1266copyzey9I6w(long j, float f, float f2) {
        return TransformOriginKt.TransformOrigin(f, f2);
    }

    /* renamed from: copy-zey9I6w$default, reason: not valid java name */
    public static /* synthetic */ long m1267copyzey9I6w$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m1270getPivotFractionXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m1271getPivotFractionYimpl(j);
        }
        return m1266copyzey9I6w(j, f, f2);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1268equalsimpl(long j, Object obj) {
        return (obj instanceof TransformOrigin) && j == ((TransformOrigin) obj).m1274unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1269equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getPivotFractionX-impl, reason: not valid java name */
    public static final float m1270getPivotFractionXimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getPivotFractionY-impl, reason: not valid java name */
    public static final float m1271getPivotFractionYimpl(long j) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1272hashCodeimpl(long j) {
        return c8.a(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1273toStringimpl(long j) {
        return "TransformOrigin(packedValue=" + j + ')';
    }

    public boolean equals(Object obj) {
        return m1268equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m1272hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m1273toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m1274unboximpl() {
        return this.packedValue;
    }
}
