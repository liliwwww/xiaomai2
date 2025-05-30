package androidx.compose.foundation.interaction;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface PressInteraction extends Interaction {

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class Cancel implements PressInteraction {
        public static final int $stable = 0;

        @NotNull
        private final Press press;

        public Cancel(@NotNull Press press) {
            Intrinsics.checkNotNullParameter(press, "press");
            this.press = press;
        }

        @NotNull
        public final Press getPress() {
            return this.press;
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class Press implements PressInteraction {
        public static final int $stable = 0;
        private final long pressPosition;

        private Press(long j) {
            this.pressPosition = j;
        }

        public /* synthetic */ Press(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        /* renamed from: getPressPosition-F1C5BW0, reason: not valid java name */
        public final long m1316getPressPositionF1C5BW0() {
            return this.pressPosition;
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class Release implements PressInteraction {
        public static final int $stable = 0;

        @NotNull
        private final Press press;

        public Release(@NotNull Press press) {
            Intrinsics.checkNotNullParameter(press, "press");
            this.press = press;
        }

        @NotNull
        public final Press getPress() {
            return this.press;
        }
    }
}
