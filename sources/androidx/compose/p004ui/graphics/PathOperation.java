package androidx.compose.p004ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes2.dex */
public final class PathOperation {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Difference = m3033constructorimpl(0);
    private static final int Intersect = m3033constructorimpl(1);
    private static final int Union = m3033constructorimpl(2);
    private static final int Xor = m3033constructorimpl(3);
    private static final int ReverseDifference = m3033constructorimpl(4);

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDifference-b3I0S0c, reason: not valid java name */
        public final int m3039getDifferenceb3I0S0c() {
            return PathOperation.Difference;
        }

        /* renamed from: getIntersect-b3I0S0c, reason: not valid java name */
        public final int m3040getIntersectb3I0S0c() {
            return PathOperation.Intersect;
        }

        /* renamed from: getReverseDifference-b3I0S0c, reason: not valid java name */
        public final int m3041getReverseDifferenceb3I0S0c() {
            return PathOperation.ReverseDifference;
        }

        /* renamed from: getUnion-b3I0S0c, reason: not valid java name */
        public final int m3042getUnionb3I0S0c() {
            return PathOperation.Union;
        }

        /* renamed from: getXor-b3I0S0c, reason: not valid java name */
        public final int m3043getXorb3I0S0c() {
            return PathOperation.Xor;
        }
    }

    private /* synthetic */ PathOperation(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PathOperation m3032boximpl(int i) {
        return new PathOperation(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m3033constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3034equalsimpl(int i, Object obj) {
        return (obj instanceof PathOperation) && i == ((PathOperation) obj).m3038unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3035equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3036hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3037toStringimpl(int i) {
        return m3035equalsimpl0(i, Difference) ? "Difference" : m3035equalsimpl0(i, Intersect) ? "Intersect" : m3035equalsimpl0(i, Union) ? "Union" : m3035equalsimpl0(i, Xor) ? "Xor" : m3035equalsimpl0(i, ReverseDifference) ? "ReverseDifference" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m3034equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3036hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3037toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3038unboximpl() {
        return this.value;
    }
}
