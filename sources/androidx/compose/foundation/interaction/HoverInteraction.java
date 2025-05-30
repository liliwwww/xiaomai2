package androidx.compose.foundation.interaction;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface HoverInteraction extends Interaction {

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class Enter implements HoverInteraction {
        public static final int $stable = 0;
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class Exit implements HoverInteraction {
        public static final int $stable = 0;

        @NotNull
        private final Enter enter;

        public Exit(@NotNull Enter enter) {
            Intrinsics.checkNotNullParameter(enter, "enter");
            this.enter = enter;
        }

        @NotNull
        public final Enter getEnter() {
            return this.enter;
        }
    }
}
