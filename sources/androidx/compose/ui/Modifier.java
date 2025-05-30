package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Modifier {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion implements Modifier {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @Override // androidx.compose.ui.Modifier
        public boolean all(@NotNull Function1<? super Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return true;
        }

        @Override // androidx.compose.ui.Modifier
        public boolean any(@NotNull Function1<? super Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return false;
        }

        @Override // androidx.compose.ui.Modifier
        public <R> R foldIn(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return r;
        }

        @Override // androidx.compose.ui.Modifier
        public <R> R foldOut(R r, @NotNull Function2<? super Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return r;
        }

        @Override // androidx.compose.ui.Modifier
        @NotNull
        public Modifier then(@NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return modifier;
        }

        @NotNull
        public String toString() {
            return "Modifier";
        }
    }

    boolean all(@NotNull Function1<? super Element, Boolean> function1);

    boolean any(@NotNull Function1<? super Element, Boolean> function1);

    <R> R foldIn(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2);

    <R> R foldOut(R r, @NotNull Function2<? super Element, ? super R, ? extends R> function2);

    @NotNull
    Modifier then(@NotNull Modifier modifier);
}
