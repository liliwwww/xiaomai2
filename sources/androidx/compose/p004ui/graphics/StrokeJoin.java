package androidx.compose.p004ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes.dex */
public final class StrokeJoin {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Miter = m3096constructorimpl(0);
    private static final int Round = m3096constructorimpl(1);
    private static final int Bevel = m3096constructorimpl(2);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getBevel-LxFBmk8, reason: not valid java name */
        public final int m3102getBevelLxFBmk8() {
            return StrokeJoin.Bevel;
        }

        /* renamed from: getMiter-LxFBmk8, reason: not valid java name */
        public final int m3103getMiterLxFBmk8() {
            return StrokeJoin.Miter;
        }

        /* renamed from: getRound-LxFBmk8, reason: not valid java name */
        public final int m3104getRoundLxFBmk8() {
            return StrokeJoin.Round;
        }
    }

    private /* synthetic */ StrokeJoin(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StrokeJoin m3095boximpl(int i) {
        return new StrokeJoin(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m3096constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3097equalsimpl(int i, Object obj) {
        return (obj instanceof StrokeJoin) && i == ((StrokeJoin) obj).m3101unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3098equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3099hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3100toStringimpl(int i) {
        return m3098equalsimpl0(i, Miter) ? "Miter" : m3098equalsimpl0(i, Round) ? "Round" : m3098equalsimpl0(i, Bevel) ? "Bevel" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m3097equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3099hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3100toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3101unboximpl() {
        return this.value;
    }
}
