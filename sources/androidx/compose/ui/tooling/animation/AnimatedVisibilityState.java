package androidx.compose.ui.tooling.animation;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AnimatedVisibilityState {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String Enter = m2096constructorimpl("Enter");

    @NotNull
    private static final String Exit = m2096constructorimpl("Exit");

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
        public final String m2102getEnterq9NwIk0() {
            return AnimatedVisibilityState.Enter;
        }

        @NotNull
        /* renamed from: getExit-q9NwIk0, reason: not valid java name */
        public final String m2103getExitq9NwIk0() {
            return AnimatedVisibilityState.Exit;
        }
    }

    private /* synthetic */ AnimatedVisibilityState(String str) {
        this.value = str;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AnimatedVisibilityState m2095boximpl(String str) {
        return new AnimatedVisibilityState(str);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static String m2096constructorimpl(String str) {
        return str;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2097equalsimpl(String str, Object obj) {
        return (obj instanceof AnimatedVisibilityState) && Intrinsics.areEqual(str, ((AnimatedVisibilityState) obj).m2101unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2098equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2099hashCodeimpl(String str) {
        return str.hashCode();
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2100toStringimpl(String str) {
        return str;
    }

    public boolean equals(Object obj) {
        return m2097equalsimpl(this.value, obj);
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return m2099hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m2100toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ String m2101unboximpl() {
        return this.value;
    }
}
