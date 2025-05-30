package androidx.compose.p004ui.graphics.vector;

import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public abstract class VectorProperty<T> {
    public static final int $stable = 0;

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class Fill extends VectorProperty<Brush> {
        public static final int $stable = 0;

        @NotNull
        public static final Fill INSTANCE = new Fill();

        private Fill() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class FillAlpha extends VectorProperty<Float> {
        public static final int $stable = 0;

        @NotNull
        public static final FillAlpha INSTANCE = new FillAlpha();

        private FillAlpha() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class PathData extends VectorProperty<List<? extends PathNode>> {
        public static final int $stable = 0;

        @NotNull
        public static final PathData INSTANCE = new PathData();

        private PathData() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class PivotX extends VectorProperty<Float> {
        public static final int $stable = 0;

        @NotNull
        public static final PivotX INSTANCE = new PivotX();

        private PivotX() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class PivotY extends VectorProperty<Float> {
        public static final int $stable = 0;

        @NotNull
        public static final PivotY INSTANCE = new PivotY();

        private PivotY() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class Rotation extends VectorProperty<Float> {
        public static final int $stable = 0;

        @NotNull
        public static final Rotation INSTANCE = new Rotation();

        private Rotation() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class ScaleX extends VectorProperty<Float> {
        public static final int $stable = 0;

        @NotNull
        public static final ScaleX INSTANCE = new ScaleX();

        private ScaleX() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class ScaleY extends VectorProperty<Float> {
        public static final int $stable = 0;

        @NotNull
        public static final ScaleY INSTANCE = new ScaleY();

        private ScaleY() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class Stroke extends VectorProperty<Brush> {
        public static final int $stable = 0;

        @NotNull
        public static final Stroke INSTANCE = new Stroke();

        private Stroke() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class StrokeAlpha extends VectorProperty<Float> {
        public static final int $stable = 0;

        @NotNull
        public static final StrokeAlpha INSTANCE = new StrokeAlpha();

        private StrokeAlpha() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class StrokeLineWidth extends VectorProperty<Float> {
        public static final int $stable = 0;

        @NotNull
        public static final StrokeLineWidth INSTANCE = new StrokeLineWidth();

        private StrokeLineWidth() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class TranslateX extends VectorProperty<Float> {
        public static final int $stable = 0;

        @NotNull
        public static final TranslateX INSTANCE = new TranslateX();

        private TranslateX() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class TranslateY extends VectorProperty<Float> {
        public static final int $stable = 0;

        @NotNull
        public static final TranslateY INSTANCE = new TranslateY();

        private TranslateY() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class TrimPathEnd extends VectorProperty<Float> {
        public static final int $stable = 0;

        @NotNull
        public static final TrimPathEnd INSTANCE = new TrimPathEnd();

        private TrimPathEnd() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class TrimPathOffset extends VectorProperty<Float> {
        public static final int $stable = 0;

        @NotNull
        public static final TrimPathOffset INSTANCE = new TrimPathOffset();

        private TrimPathOffset() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class TrimPathStart extends VectorProperty<Float> {
        public static final int $stable = 0;

        @NotNull
        public static final TrimPathStart INSTANCE = new TrimPathStart();

        private TrimPathStart() {
            super(null);
        }
    }

    private VectorProperty() {
    }

    public /* synthetic */ VectorProperty(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
