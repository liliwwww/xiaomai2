package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier$Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.vv3;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PointerInputModifier$DefaultImpls {
    @Deprecated
    public static boolean all(@NotNull PointerInputModifier pointerInputModifier, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return vv3.a(pointerInputModifier, function1);
    }

    @Deprecated
    public static boolean any(@NotNull PointerInputModifier pointerInputModifier, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return vv3.b(pointerInputModifier, function1);
    }

    @Deprecated
    public static <R> R foldIn(@NotNull PointerInputModifier pointerInputModifier, R r, @NotNull Function2<? super R, ? super Modifier$Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) vv3.c(pointerInputModifier, r, function2);
    }

    @Deprecated
    public static <R> R foldOut(@NotNull PointerInputModifier pointerInputModifier, R r, @NotNull Function2<? super Modifier$Element, ? super R, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return (R) vv3.d(pointerInputModifier, r, function2);
    }

    @Deprecated
    @NotNull
    public static Modifier then(@NotNull PointerInputModifier pointerInputModifier, @NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "other");
        return vv3.e(pointerInputModifier, modifier);
    }
}
