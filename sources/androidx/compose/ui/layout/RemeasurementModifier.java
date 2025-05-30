package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier$Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.ka4;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface RemeasurementModifier extends Modifier$Element {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull RemeasurementModifier remeasurementModifier, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return ka4.a(remeasurementModifier, function1);
        }

        @Deprecated
        public static boolean any(@NotNull RemeasurementModifier remeasurementModifier, @NotNull Function1<? super Modifier$Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return ka4.b(remeasurementModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull RemeasurementModifier remeasurementModifier, R r, @NotNull Function2<? super R, ? super Modifier$Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) ka4.c(remeasurementModifier, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull RemeasurementModifier remeasurementModifier, R r, @NotNull Function2<? super Modifier$Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) ka4.d(remeasurementModifier, r, function2);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull RemeasurementModifier remeasurementModifier, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return ka4.e(remeasurementModifier, modifier);
        }
    }

    void onRemeasurementAvailable(@NotNull Remeasurement remeasurement);
}
