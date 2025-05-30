package androidx.compose.p004ui.draw;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.u51;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface DrawModifier extends Modifier.Element {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(@NotNull DrawModifier drawModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return u51.a(drawModifier, function1);
        }

        @Deprecated
        public static boolean any(@NotNull DrawModifier drawModifier, @NotNull Function1<? super Modifier.Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return u51.b(drawModifier, function1);
        }

        @Deprecated
        public static <R> R foldIn(@NotNull DrawModifier drawModifier, R r, @NotNull Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) u51.c(drawModifier, r, function2);
        }

        @Deprecated
        public static <R> R foldOut(@NotNull DrawModifier drawModifier, R r, @NotNull Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return (R) u51.d(drawModifier, r, function2);
        }

        @Deprecated
        @NotNull
        public static Modifier then(@NotNull DrawModifier drawModifier, @NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return u51.e(drawModifier, modifier);
        }
    }

    void draw(@NotNull ContentDrawScope contentDrawScope);
}
