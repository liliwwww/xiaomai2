package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface LayoutModifier extends Modifier.Element {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull LayoutModifier layoutModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            boolean a;
            Intrinsics.checkNotNullParameter(function1, "predicate");
            a = nt2.a(layoutModifier, function1);
            return a;
        }

        @Deprecated
        public static boolean any(@NotNull LayoutModifier layoutModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            boolean b;
            Intrinsics.checkNotNullParameter(function1, "predicate");
            b = nt2.b(layoutModifier, function1);
            return b;
        }

        @Deprecated
        public static <R> R foldIn(@NotNull LayoutModifier layoutModifier, R r, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Object c;
            Intrinsics.checkNotNullParameter(function2, "operation");
            c = nt2.c(layoutModifier, r, function2);
            return (R) c;
        }

        @Deprecated
        public static <R> R foldOut(@NotNull LayoutModifier layoutModifier, R r, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Object d;
            Intrinsics.checkNotNullParameter(function2, "operation");
            d = nt2.d(layoutModifier, r, function2);
            return (R) d;
        }

        @Deprecated
        public static int maxIntrinsicHeight(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
            int m141a;
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            m141a = C0790a.m141a(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i);
            return m141a;
        }

        @Deprecated
        public static int maxIntrinsicWidth(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
            int m142b;
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            m142b = C0790a.m142b(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i);
            return m142b;
        }

        @Deprecated
        public static int minIntrinsicHeight(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
            int m143c;
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            m143c = C0790a.m143c(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i);
            return m143c;
        }

        @Deprecated
        public static int minIntrinsicWidth(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
            int m144d;
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            m144d = C0790a.m144d(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i);
            return m144d;
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull LayoutModifier layoutModifier, @NotNull Modifier modifier) {
            Modifier a;
            Intrinsics.checkNotNullParameter(modifier, "other");
            a = mt2.a(layoutModifier, modifier);
            return a;
        }
    }

    int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);

    int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);

    @NotNull
    /* renamed from: measure-3p2s80s */
    MeasureResult mo959measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j);

    int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);

    int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);
}
