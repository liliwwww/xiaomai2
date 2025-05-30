package androidx.compose.p004ui.layout;

import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface BeyondBoundsLayout {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface BeyondBoundsScope {
        boolean getHasMoreContent();
    }

    /* compiled from: Taobao */
    @JvmInline
    /* loaded from: classes2.dex */
    public static final class LayoutDirection {
        private final int value;

        @NotNull
        public static final Companion Companion = new Companion(null);
        private static final int Before = m4164constructorimpl(1);
        private static final int After = m4164constructorimpl(2);
        private static final int Left = m4164constructorimpl(3);
        private static final int Right = m4164constructorimpl(4);
        private static final int Above = m4164constructorimpl(5);
        private static final int Below = m4164constructorimpl(6);

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: getAbove-hoxUOeE, reason: not valid java name */
            public final int m4170getAbovehoxUOeE() {
                return LayoutDirection.Above;
            }

            /* renamed from: getAfter-hoxUOeE, reason: not valid java name */
            public final int m4171getAfterhoxUOeE() {
                return LayoutDirection.After;
            }

            /* renamed from: getBefore-hoxUOeE, reason: not valid java name */
            public final int m4172getBeforehoxUOeE() {
                return LayoutDirection.Before;
            }

            /* renamed from: getBelow-hoxUOeE, reason: not valid java name */
            public final int m4173getBelowhoxUOeE() {
                return LayoutDirection.Below;
            }

            /* renamed from: getLeft-hoxUOeE, reason: not valid java name */
            public final int m4174getLefthoxUOeE() {
                return LayoutDirection.Left;
            }

            /* renamed from: getRight-hoxUOeE, reason: not valid java name */
            public final int m4175getRighthoxUOeE() {
                return LayoutDirection.Right;
            }
        }

        private /* synthetic */ LayoutDirection(int i) {
            this.value = i;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ LayoutDirection m4163boximpl(int i) {
            return new LayoutDirection(i);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static int m4164constructorimpl(int i) {
            return i;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m4165equalsimpl(int i, Object obj) {
            return (obj instanceof LayoutDirection) && i == ((LayoutDirection) obj).m4169unboximpl();
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m4166equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m4167hashCodeimpl(int i) {
            return i;
        }

        @NotNull
        /* renamed from: toString-impl, reason: not valid java name */
        public static String m4168toStringimpl(int i) {
            return m4166equalsimpl0(i, Before) ? "Before" : m4166equalsimpl0(i, After) ? "After" : m4166equalsimpl0(i, Left) ? "Left" : m4166equalsimpl0(i, Right) ? "Right" : m4166equalsimpl0(i, Above) ? "Above" : m4166equalsimpl0(i, Below) ? "Below" : "invalid LayoutDirection";
        }

        public boolean equals(Object obj) {
            return m4165equalsimpl(this.value, obj);
        }

        public int hashCode() {
            return m4167hashCodeimpl(this.value);
        }

        @NotNull
        public String toString() {
            return m4168toStringimpl(this.value);
        }

        /* renamed from: unbox-impl, reason: not valid java name */
        public final /* synthetic */ int m4169unboximpl() {
            return this.value;
        }
    }

    @Nullable
    /* renamed from: layout-o7g1Pn8 */
    <T> T mo1503layouto7g1Pn8(int i, @NotNull Function1<? super BeyondBoundsScope, ? extends T> function1);
}
