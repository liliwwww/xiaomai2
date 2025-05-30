package androidx.compose.p004ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes2.dex */
public final class PointMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Points = m3046constructorimpl(0);
    private static final int Lines = m3046constructorimpl(1);
    private static final int Polygon = m3046constructorimpl(2);

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getLines-r_lszbg, reason: not valid java name */
        public final int m3052getLinesr_lszbg() {
            return PointMode.Lines;
        }

        /* renamed from: getPoints-r_lszbg, reason: not valid java name */
        public final int m3053getPointsr_lszbg() {
            return PointMode.Points;
        }

        /* renamed from: getPolygon-r_lszbg, reason: not valid java name */
        public final int m3054getPolygonr_lszbg() {
            return PointMode.Polygon;
        }
    }

    private /* synthetic */ PointMode(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PointMode m3045boximpl(int i) {
        return new PointMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m3046constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3047equalsimpl(int i, Object obj) {
        return (obj instanceof PointMode) && i == ((PointMode) obj).m3051unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3048equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3049hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3050toStringimpl(int i) {
        return m3048equalsimpl0(i, Points) ? "Points" : m3048equalsimpl0(i, Lines) ? "Lines" : m3048equalsimpl0(i, Polygon) ? "Polygon" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m3047equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3049hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3050toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3051unboximpl() {
        return this.value;
    }
}
