package androidx.compose.foundation.interaction;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface DragInteraction extends Interaction {

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class Cancel implements DragInteraction {
        public static final int $stable = 0;

        @NotNull
        private final Start start;

        public Cancel(@NotNull Start start) {
            Intrinsics.checkNotNullParameter(start, "start");
            this.start = start;
        }

        @NotNull
        public final Start getStart() {
            return this.start;
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class Start implements DragInteraction {
        public static final int $stable = 0;
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class Stop implements DragInteraction {
        public static final int $stable = 0;

        @NotNull
        private final Start start;

        public Stop(@NotNull Start start) {
            Intrinsics.checkNotNullParameter(start, "start");
            this.start = start;
        }

        @NotNull
        public final Start getStart() {
            return this.start;
        }
    }
}
