package androidx.compose.ui;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface Modifier$Element extends Modifier {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull Modifier$Element modifier$Element, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return nt2.e(modifier$Element, function1);
        }

        @Deprecated
        public static boolean any(@NotNull Modifier$Element modifier$Element, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return nt2.f(modifier$Element, function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull Modifier$Element modifier$Element, R r, @NotNull Function2<? super R, ? super Modifier$Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) nt2.g(modifier$Element, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull Modifier$Element modifier$Element, R r, @NotNull Function2<? super Modifier$Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) nt2.h(modifier$Element, r, function2);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull Modifier$Element modifier$Element, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return nt2.i(modifier$Element, modifier);
        }
    }

    boolean all(@NotNull Function1<? super Modifier$Element, Boolean> function1);

    boolean any(@NotNull Function1<? super Modifier$Element, Boolean> function1);

    <R> R foldIn(R r, @NotNull Function2<? super R, ? super Modifier$Element, ? extends R> function2);

    <R> R foldOut(R r, @NotNull Function2<? super Modifier$Element, ? super R, ? extends R> function2);
}
