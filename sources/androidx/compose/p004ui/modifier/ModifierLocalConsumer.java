package androidx.compose.p004ui.modifier;

import androidx.compose.p004ui.Modifier;
import androidx.compose.runtime.Stable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.ot2;

/* compiled from: Taobao */
@Stable
/* loaded from: classes.dex */
public interface ModifierLocalConsumer extends Modifier.Element {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull ModifierLocalConsumer modifierLocalConsumer, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return ot2.a(modifierLocalConsumer, function1);
        }

        @Deprecated
        public static boolean any(@NotNull ModifierLocalConsumer modifierLocalConsumer, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return ot2.b(modifierLocalConsumer, function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull ModifierLocalConsumer modifierLocalConsumer, R r, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) ot2.c(modifierLocalConsumer, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull ModifierLocalConsumer modifierLocalConsumer, R r, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) ot2.d(modifierLocalConsumer, r, function2);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull ModifierLocalConsumer modifierLocalConsumer, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return ot2.e(modifierLocalConsumer, modifier);
        }
    }

    void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope);
}
