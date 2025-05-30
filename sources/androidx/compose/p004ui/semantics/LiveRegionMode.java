package androidx.compose.p004ui.semantics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes.dex */
public final class LiveRegionMode {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Polite = m4576constructorimpl(0);
    private static final int Assertive = m4576constructorimpl(1);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAssertive-0phEisY, reason: not valid java name */
        public final int m4582getAssertive0phEisY() {
            return LiveRegionMode.Assertive;
        }

        /* renamed from: getPolite-0phEisY, reason: not valid java name */
        public final int m4583getPolite0phEisY() {
            return LiveRegionMode.Polite;
        }
    }

    private /* synthetic */ LiveRegionMode(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ LiveRegionMode m4575boximpl(int i) {
        return new LiveRegionMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m4576constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4577equalsimpl(int i, Object obj) {
        return (obj instanceof LiveRegionMode) && i == ((LiveRegionMode) obj).m4581unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4578equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4579hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4580toStringimpl(int i) {
        return m4578equalsimpl0(i, Polite) ? "Polite" : m4578equalsimpl0(i, Assertive) ? "Assertive" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m4577equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m4579hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m4580toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m4581unboximpl() {
        return this.value;
    }
}
