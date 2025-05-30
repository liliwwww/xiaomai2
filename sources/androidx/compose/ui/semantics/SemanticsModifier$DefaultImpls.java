package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier$Element;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.gw4;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SemanticsModifier$DefaultImpls {
    @Deprecated
    public static boolean all(@NotNull SemanticsModifier semanticsModifier, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return gw4.b(semanticsModifier, function1);
    }

    @Deprecated
    public static boolean any(@NotNull SemanticsModifier semanticsModifier, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return gw4.c(semanticsModifier, function1);
    }

    @Deprecated
    public static <R> R foldIn(@NotNull SemanticsModifier semanticsModifier, R r, @NotNull Function2<? super R, ? super Modifier$Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) gw4.d(semanticsModifier, r, function2);
    }

    @Deprecated
    public static <R> R foldOut(@NotNull SemanticsModifier semanticsModifier, R r, @NotNull Function2<? super Modifier$Element, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) gw4.e(semanticsModifier, r, function2);
    }

    @Deprecated
    public static int getId(@NotNull SemanticsModifier semanticsModifier) {
        return gw4.f(semanticsModifier);
    }

    @Deprecated(message = "SemanticsModifier.id is now unused and has been set to a fixed value. Retrieve the id from LayoutInfo instead.", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public static /* synthetic */ void getId$annotations() {
    }

    @Deprecated
    @NotNull
    public static Modifier then(@NotNull SemanticsModifier semanticsModifier, @NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "other");
        return gw4.g(semanticsModifier, modifier);
    }
}
