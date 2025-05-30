package androidx.compose.animation;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AnimatedContentScope$SlideDirection {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Left = m26constructorimpl(0);
    private static final int Right = m26constructorimpl(1);
    private static final int Up = m26constructorimpl(2);
    private static final int Down = m26constructorimpl(3);
    private static final int Start = m26constructorimpl(4);
    private static final int End = m26constructorimpl(5);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDown-aUPqQNE, reason: not valid java name */
        public final int m32getDownaUPqQNE() {
            return AnimatedContentScope$SlideDirection.Down;
        }

        /* renamed from: getEnd-aUPqQNE, reason: not valid java name */
        public final int m33getEndaUPqQNE() {
            return AnimatedContentScope$SlideDirection.End;
        }

        /* renamed from: getLeft-aUPqQNE, reason: not valid java name */
        public final int m34getLeftaUPqQNE() {
            return AnimatedContentScope$SlideDirection.Left;
        }

        /* renamed from: getRight-aUPqQNE, reason: not valid java name */
        public final int m35getRightaUPqQNE() {
            return AnimatedContentScope$SlideDirection.Right;
        }

        /* renamed from: getStart-aUPqQNE, reason: not valid java name */
        public final int m36getStartaUPqQNE() {
            return AnimatedContentScope$SlideDirection.Start;
        }

        /* renamed from: getUp-aUPqQNE, reason: not valid java name */
        public final int m37getUpaUPqQNE() {
            return AnimatedContentScope$SlideDirection.Up;
        }
    }

    private /* synthetic */ AnimatedContentScope$SlideDirection(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ AnimatedContentScope$SlideDirection m25boximpl(int i) {
        return new AnimatedContentScope$SlideDirection(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m26constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m27equalsimpl(int i, Object obj) {
        return (obj instanceof AnimatedContentScope$SlideDirection) && i == ((AnimatedContentScope$SlideDirection) obj).m31unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m28equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m29hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m30toStringimpl(int i) {
        return m28equalsimpl0(i, Left) ? "Left" : m28equalsimpl0(i, Right) ? "Right" : m28equalsimpl0(i, Up) ? "Up" : m28equalsimpl0(i, Down) ? "Down" : m28equalsimpl0(i, Start) ? "Start" : m28equalsimpl0(i, End) ? "End" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m27equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m29hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m30toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m31unboximpl() {
        return this.value;
    }
}
