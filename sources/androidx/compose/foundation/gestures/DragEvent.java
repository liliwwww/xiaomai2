package androidx.compose.foundation.gestures;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
abstract class DragEvent {

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class DragCancelled extends DragEvent {
        public static final int $stable = 0;

        @NotNull
        public static final DragCancelled INSTANCE = new DragCancelled();

        private DragCancelled() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class DragDelta extends DragEvent {
        public static final int $stable = 0;
        private final long delta;

        private DragDelta(long j) {
            super(null);
            this.delta = j;
        }

        public /* synthetic */ DragDelta(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        /* renamed from: getDelta-F1C5BW0, reason: not valid java name */
        public final long m1211getDeltaF1C5BW0() {
            return this.delta;
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class DragStarted extends DragEvent {
        public static final int $stable = 0;
        private final long startPoint;

        private DragStarted(long j) {
            super(null);
            this.startPoint = j;
        }

        public /* synthetic */ DragStarted(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        /* renamed from: getStartPoint-F1C5BW0, reason: not valid java name */
        public final long m1212getStartPointF1C5BW0() {
            return this.startPoint;
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class DragStopped extends DragEvent {
        public static final int $stable = 0;
        private final long velocity;

        private DragStopped(long j) {
            super(null);
            this.velocity = j;
        }

        public /* synthetic */ DragStopped(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        /* renamed from: getVelocity-9UxMQ8M, reason: not valid java name */
        public final long m1213getVelocity9UxMQ8M() {
            return this.velocity;
        }
    }

    private DragEvent() {
    }

    public /* synthetic */ DragEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
