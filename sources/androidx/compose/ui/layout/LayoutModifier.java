package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface LayoutModifier extends Modifier.Element {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull LayoutModifier layoutModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return a.e(layoutModifier, function1);
        }

        @Deprecated
        public static boolean any(@NotNull LayoutModifier layoutModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return a.f(layoutModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull LayoutModifier layoutModifier, R r, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) a.g(layoutModifier, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull LayoutModifier layoutModifier, R r, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) a.h(layoutModifier, r, function2);
        }

        @Deprecated
        public static int maxIntrinsicHeight(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return a.i(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i);
        }

        @Deprecated
        public static int maxIntrinsicWidth(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return a.j(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i);
        }

        @Deprecated
        public static int minIntrinsicHeight(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return a.k(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i);
        }

        @Deprecated
        public static int minIntrinsicWidth(@NotNull LayoutModifier layoutModifier, @NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "$receiver");
            Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
            return a.l(layoutModifier, intrinsicMeasureScope, intrinsicMeasurable, i);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull LayoutModifier layoutModifier, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return a.m(layoutModifier, modifier);
        }
    }

    int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);

    int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);

    @NotNull
    /* renamed from: measure-3p2s80s */
    MeasureResult mo49measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j);

    int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);

    int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i);
}
