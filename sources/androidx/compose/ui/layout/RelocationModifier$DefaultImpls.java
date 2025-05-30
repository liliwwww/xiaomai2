package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier$Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.ja4;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RelocationModifier$DefaultImpls {
    @Deprecated
    public static boolean all(@NotNull RelocationModifier relocationModifier, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return ja4.a(relocationModifier, function1);
    }

    @Deprecated
    public static boolean any(@NotNull RelocationModifier relocationModifier, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return ja4.b(relocationModifier, function1);
    }

    @Deprecated
    public static <R> R foldIn(@NotNull RelocationModifier relocationModifier, R r, @NotNull Function2<? super R, ? super Modifier$Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) ja4.c(relocationModifier, r, function2);
    }

    @Deprecated
    public static <R> R foldOut(@NotNull RelocationModifier relocationModifier, R r, @NotNull Function2<? super Modifier$Element, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) ja4.d(relocationModifier, r, function2);
    }

    @Deprecated
    @NotNull
    public static Modifier then(@NotNull RelocationModifier relocationModifier, @NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "other");
        return ja4.e(relocationModifier, modifier);
    }
}
