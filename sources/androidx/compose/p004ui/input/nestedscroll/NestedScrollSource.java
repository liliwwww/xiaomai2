package androidx.compose.p004ui.input.nestedscroll;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import kotlin.Deprecated;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes.dex */
public final class NestedScrollSource {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Drag = m3986constructorimpl(1);
    private static final int Fling = m3986constructorimpl(2);
    private static final int Relocate = m3986constructorimpl(3);
    private final int value;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "Do not use. Will be removed in the future.")
        @ExperimentalComposeUiApi
        /* renamed from: getRelocate-WNlRxjI$annotations, reason: not valid java name */
        public static /* synthetic */ void m3992getRelocateWNlRxjI$annotations() {
        }

        /* renamed from: getDrag-WNlRxjI, reason: not valid java name */
        public final int m3993getDragWNlRxjI() {
            return NestedScrollSource.Drag;
        }

        /* renamed from: getFling-WNlRxjI, reason: not valid java name */
        public final int m3994getFlingWNlRxjI() {
            return NestedScrollSource.Fling;
        }

        /* renamed from: getRelocate-WNlRxjI, reason: not valid java name */
        public final int m3995getRelocateWNlRxjI() {
            return NestedScrollSource.Relocate;
        }
    }

    private /* synthetic */ NestedScrollSource(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ NestedScrollSource m3985boximpl(int i) {
        return new NestedScrollSource(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m3986constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3987equalsimpl(int i, Object obj) {
        return (obj instanceof NestedScrollSource) && i == ((NestedScrollSource) obj).m3991unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3988equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3989hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3990toStringimpl(int i) {
        return m3988equalsimpl0(i, Drag) ? "Drag" : m3988equalsimpl0(i, Fling) ? "Fling" : m3988equalsimpl0(i, Relocate) ? "Relocate" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m3987equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3989hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3990toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3991unboximpl() {
        return this.value;
    }
}
