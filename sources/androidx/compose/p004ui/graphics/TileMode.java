package androidx.compose.p004ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes2.dex */
public final class TileMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Clamp = m3106constructorimpl(0);
    private static final int Repeated = m3106constructorimpl(1);
    private static final int Mirror = m3106constructorimpl(2);
    private static final int Decal = m3106constructorimpl(3);

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getClamp-3opZhB0, reason: not valid java name */
        public final int m3112getClamp3opZhB0() {
            return TileMode.Clamp;
        }

        /* renamed from: getDecal-3opZhB0, reason: not valid java name */
        public final int m3113getDecal3opZhB0() {
            return TileMode.Decal;
        }

        /* renamed from: getMirror-3opZhB0, reason: not valid java name */
        public final int m3114getMirror3opZhB0() {
            return TileMode.Mirror;
        }

        /* renamed from: getRepeated-3opZhB0, reason: not valid java name */
        public final int m3115getRepeated3opZhB0() {
            return TileMode.Repeated;
        }
    }

    private /* synthetic */ TileMode(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TileMode m3105boximpl(int i) {
        return new TileMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m3106constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3107equalsimpl(int i, Object obj) {
        return (obj instanceof TileMode) && i == ((TileMode) obj).m3111unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3108equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3109hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3110toStringimpl(int i) {
        return m3108equalsimpl0(i, Clamp) ? "Clamp" : m3108equalsimpl0(i, Repeated) ? "Repeated" : m3108equalsimpl0(i, Mirror) ? "Mirror" : m3108equalsimpl0(i, Decal) ? "Decal" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m3107equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3109hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3110toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3111unboximpl() {
        return this.value;
    }
}
