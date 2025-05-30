package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier$Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.t43;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class OnGloballyPositionedModifier$DefaultImpls {
    @Deprecated
    public static boolean all(@NotNull OnGloballyPositionedModifier onGloballyPositionedModifier, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return t43.a(onGloballyPositionedModifier, function1);
    }

    @Deprecated
    public static boolean any(@NotNull OnGloballyPositionedModifier onGloballyPositionedModifier, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return t43.b(onGloballyPositionedModifier, function1);
    }

    @Deprecated
    public static <R> R foldIn(@NotNull OnGloballyPositionedModifier onGloballyPositionedModifier, R r, @NotNull Function2<? super R, ? super Modifier$Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) t43.c(onGloballyPositionedModifier, r, function2);
    }

    @Deprecated
    public static <R> R foldOut(@NotNull OnGloballyPositionedModifier onGloballyPositionedModifier, R r, @NotNull Function2<? super Modifier$Element, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) t43.d(onGloballyPositionedModifier, r, function2);
    }

    @Deprecated
    @NotNull
    public static Modifier then(@NotNull OnGloballyPositionedModifier onGloballyPositionedModifier, @NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "other");
        return t43.e(onGloballyPositionedModifier, modifier);
    }
}
