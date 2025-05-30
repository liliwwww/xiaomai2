package androidx.compose.p004ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes.dex */
public final class ClipOp {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Difference = m2769constructorimpl(0);
    private static final int Intersect = m2769constructorimpl(1);
    private final int value;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDifference-rtfAjoo, reason: not valid java name */
        public final int m2775getDifferencertfAjoo() {
            return ClipOp.Difference;
        }

        /* renamed from: getIntersect-rtfAjoo, reason: not valid java name */
        public final int m2776getIntersectrtfAjoo() {
            return ClipOp.Intersect;
        }
    }

    private /* synthetic */ ClipOp(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ClipOp m2768boximpl(int i) {
        return new ClipOp(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m2769constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2770equalsimpl(int i, Object obj) {
        return (obj instanceof ClipOp) && i == ((ClipOp) obj).m2774unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2771equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2772hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2773toStringimpl(int i) {
        return m2771equalsimpl0(i, Difference) ? "Difference" : m2771equalsimpl0(i, Intersect) ? "Intersect" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m2770equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m2772hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2773toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m2774unboximpl() {
        return this.value;
    }
}
