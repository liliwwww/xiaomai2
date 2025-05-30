package androidx.compose.p004ui;

import androidx.compose.p004ui.BiasAlignment;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: classes2.dex */
public interface Alignment {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final Alignment TopStart = new BiasAlignment(-1.0f, -1.0f);

        @NotNull
        private static final Alignment TopCenter = new BiasAlignment(0.0f, -1.0f);

        @NotNull
        private static final Alignment TopEnd = new BiasAlignment(1.0f, -1.0f);

        @NotNull
        private static final Alignment CenterStart = new BiasAlignment(-1.0f, 0.0f);

        @NotNull
        private static final Alignment Center = new BiasAlignment(0.0f, 0.0f);

        @NotNull
        private static final Alignment CenterEnd = new BiasAlignment(1.0f, 0.0f);

        @NotNull
        private static final Alignment BottomStart = new BiasAlignment(-1.0f, 1.0f);

        @NotNull
        private static final Alignment BottomCenter = new BiasAlignment(0.0f, 1.0f);

        @NotNull
        private static final Alignment BottomEnd = new BiasAlignment(1.0f, 1.0f);

        @NotNull
        private static final Vertical Top = new BiasAlignment.Vertical(-1.0f);

        @NotNull
        private static final Vertical CenterVertically = new BiasAlignment.Vertical(0.0f);

        @NotNull
        private static final Vertical Bottom = new BiasAlignment.Vertical(1.0f);

        @NotNull
        private static final Horizontal Start = new BiasAlignment.Horizontal(-1.0f);

        @NotNull
        private static final Horizontal CenterHorizontally = new BiasAlignment.Horizontal(0.0f);

        @NotNull
        private static final Horizontal End = new BiasAlignment.Horizontal(1.0f);

        private Companion() {
        }

        @Stable
        public static /* synthetic */ void getBottom$annotations() {
        }

        @Stable
        public static /* synthetic */ void getBottomCenter$annotations() {
        }

        @Stable
        public static /* synthetic */ void getBottomEnd$annotations() {
        }

        @Stable
        public static /* synthetic */ void getBottomStart$annotations() {
        }

        @Stable
        public static /* synthetic */ void getCenter$annotations() {
        }

        @Stable
        public static /* synthetic */ void getCenterEnd$annotations() {
        }

        @Stable
        public static /* synthetic */ void getCenterHorizontally$annotations() {
        }

        @Stable
        public static /* synthetic */ void getCenterStart$annotations() {
        }

        @Stable
        public static /* synthetic */ void getCenterVertically$annotations() {
        }

        @Stable
        public static /* synthetic */ void getEnd$annotations() {
        }

        @Stable
        public static /* synthetic */ void getStart$annotations() {
        }

        @Stable
        public static /* synthetic */ void getTop$annotations() {
        }

        @Stable
        public static /* synthetic */ void getTopCenter$annotations() {
        }

        @Stable
        public static /* synthetic */ void getTopEnd$annotations() {
        }

        @Stable
        public static /* synthetic */ void getTopStart$annotations() {
        }

        @NotNull
        public final Vertical getBottom() {
            return Bottom;
        }

        @NotNull
        public final Alignment getBottomCenter() {
            return BottomCenter;
        }

        @NotNull
        public final Alignment getBottomEnd() {
            return BottomEnd;
        }

        @NotNull
        public final Alignment getBottomStart() {
            return BottomStart;
        }

        @NotNull
        public final Alignment getCenter() {
            return Center;
        }

        @NotNull
        public final Alignment getCenterEnd() {
            return CenterEnd;
        }

        @NotNull
        public final Horizontal getCenterHorizontally() {
            return CenterHorizontally;
        }

        @NotNull
        public final Alignment getCenterStart() {
            return CenterStart;
        }

        @NotNull
        public final Vertical getCenterVertically() {
            return CenterVertically;
        }

        @NotNull
        public final Horizontal getEnd() {
            return End;
        }

        @NotNull
        public final Horizontal getStart() {
            return Start;
        }

        @NotNull
        public final Vertical getTop() {
            return Top;
        }

        @NotNull
        public final Alignment getTopCenter() {
            return TopCenter;
        }

        @NotNull
        public final Alignment getTopEnd() {
            return TopEnd;
        }

        @NotNull
        public final Alignment getTopStart() {
            return TopStart;
        }
    }

    /* compiled from: Taobao */
    @Stable
    /* loaded from: classes.dex */
    public interface Horizontal {
        int align(int i, int i2, @NotNull LayoutDirection layoutDirection);
    }

    /* compiled from: Taobao */
    @Stable
    /* loaded from: classes.dex */
    public interface Vertical {
        int align(int i, int i2);
    }

    /* renamed from: align-KFBX0sM, reason: not valid java name */
    long mo2450alignKFBX0sM(long j, long j2, @NotNull LayoutDirection layoutDirection);
}
