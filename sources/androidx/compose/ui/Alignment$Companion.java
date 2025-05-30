package androidx.compose.ui;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.BiasAlignment;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Alignment$Companion {
    static final /* synthetic */ Alignment$Companion $$INSTANCE = new Alignment$Companion();

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
    private static final Alignment$Vertical Top = new BiasAlignment.Vertical(-1.0f);

    @NotNull
    private static final Alignment$Vertical CenterVertically = new BiasAlignment.Vertical(0.0f);

    @NotNull
    private static final Alignment$Vertical Bottom = new BiasAlignment.Vertical(1.0f);

    @NotNull
    private static final Alignment$Horizontal Start = new BiasAlignment.Horizontal(-1.0f);

    @NotNull
    private static final Alignment$Horizontal CenterHorizontally = new BiasAlignment.Horizontal(0.0f);

    @NotNull
    private static final Alignment$Horizontal End = new BiasAlignment.Horizontal(1.0f);

    private Alignment$Companion() {
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
    public final Alignment$Vertical getBottom() {
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
    public final Alignment$Horizontal getCenterHorizontally() {
        return CenterHorizontally;
    }

    @NotNull
    public final Alignment getCenterStart() {
        return CenterStart;
    }

    @NotNull
    public final Alignment$Vertical getCenterVertically() {
        return CenterVertically;
    }

    @NotNull
    public final Alignment$Horizontal getEnd() {
        return End;
    }

    @NotNull
    public final Alignment$Horizontal getStart() {
        return Start;
    }

    @NotNull
    public final Alignment$Vertical getTop() {
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
