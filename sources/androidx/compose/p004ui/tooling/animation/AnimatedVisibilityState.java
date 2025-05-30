package androidx.compose.p004ui.tooling.animation;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes.dex */
public final class AnimatedVisibilityState {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String Enter = m5152constructorimpl("Enter");

    @NotNull
    private static final String Exit = m5152constructorimpl("Exit");

    @NotNull
    private final String value;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        /* renamed from: getEnter-q9NwIk0, reason: not valid java name */
        public final String m5158getEnterq9NwIk0() {
            return AnimatedVisibilityState.Enter;
        }

        @NotNull
        /* renamed from: getExit-q9NwIk0, reason: not valid java name */
        public final String m5159getExitq9NwIk0() {
            return AnimatedVisibilityState.Exit;
        }
    }

    private /* synthetic */ AnimatedVisibilityState(String str) {
        this.value = str;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AnimatedVisibilityState m5151boximpl(String str) {
        return new AnimatedVisibilityState(str);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static String m5152constructorimpl(String str) {
        return str;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5153equalsimpl(String str, Object obj) {
        return (obj instanceof AnimatedVisibilityState) && Intrinsics.areEqual(str, ((AnimatedVisibilityState) obj).m5157unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5154equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5155hashCodeimpl(String str) {
        return str.hashCode();
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5156toStringimpl(String str) {
        return str;
    }

    public boolean equals(Object obj) {
        return m5153equalsimpl(this.value, obj);
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return m5155hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m5156toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m5157unboximpl() {
        return this.value;
    }
}
