package androidx.compose.ui.modifier;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier$Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.qt2;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface ModifierLocalProvider<T> extends Modifier$Element {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static <T> boolean all(@NotNull ModifierLocalProvider<T> modifierLocalProvider, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return qt2.a(modifierLocalProvider, function1);
        }

        @Deprecated
        public static <T> boolean any(@NotNull ModifierLocalProvider<T> modifierLocalProvider, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return qt2.b(modifierLocalProvider, function1);
        }

        @Deprecated
        public static <T, R> R foldIn(@NotNull ModifierLocalProvider<T> modifierLocalProvider, R r, @NotNull Function2<? super R, ? super Modifier$Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) qt2.c(modifierLocalProvider, r, function2);
        }

        @Deprecated
        public static <T, R> R foldOut(@NotNull ModifierLocalProvider<T> modifierLocalProvider, R r, @NotNull Function2<? super Modifier$Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) qt2.d(modifierLocalProvider, r, function2);
        }

        @Deprecated
        @NotNull
        public static <T> Modifier then(@NotNull ModifierLocalProvider<T> modifierLocalProvider, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return qt2.e(modifierLocalProvider, modifier);
        }
    }

    @NotNull
    ProvidableModifierLocal<T> getKey();

    T getValue();
}
