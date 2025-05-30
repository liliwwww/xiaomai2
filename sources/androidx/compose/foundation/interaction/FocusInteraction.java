package androidx.compose.foundation.interaction;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface FocusInteraction extends Interaction {

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class Focus implements FocusInteraction {
        public static final int $stable = 0;
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class Unfocus implements FocusInteraction {
        public static final int $stable = 0;

        @NotNull
        private final Focus focus;

        public Unfocus(@NotNull Focus focus) {
            Intrinsics.checkNotNullParameter(focus, "focus");
            this.focus = focus;
        }

        @NotNull
        public final Focus getFocus() {
            return this.focus;
        }
    }
}
