package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.w43;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface OnPlacedModifier extends Modifier.Element {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull OnPlacedModifier onPlacedModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return w43.a(onPlacedModifier, function1);
        }

        @Deprecated
        public static boolean any(@NotNull OnPlacedModifier onPlacedModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return w43.b(onPlacedModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull OnPlacedModifier onPlacedModifier, R r, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) w43.c(onPlacedModifier, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull OnPlacedModifier onPlacedModifier, R r, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) w43.d(onPlacedModifier, r, function2);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull OnPlacedModifier onPlacedModifier, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return w43.e(onPlacedModifier, modifier);
        }
    }

    void onPlaced(@NotNull LayoutCoordinates layoutCoordinates);
}
