package androidx.compose.p004ui;

import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.BiasAbsoluteAlignment;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class AbsoluteAlignment {
    public static final int $stable = 0;

    @NotNull
    public static final AbsoluteAlignment INSTANCE = new AbsoluteAlignment();

    @NotNull
    private static final Alignment TopLeft = new BiasAbsoluteAlignment(-1.0f, -1.0f);

    @NotNull
    private static final Alignment TopRight = new BiasAbsoluteAlignment(1.0f, -1.0f);

    @NotNull
    private static final Alignment CenterLeft = new BiasAbsoluteAlignment(-1.0f, 0.0f);

    @NotNull
    private static final Alignment CenterRight = new BiasAbsoluteAlignment(1.0f, 0.0f);

    @NotNull
    private static final Alignment BottomLeft = new BiasAbsoluteAlignment(-1.0f, 1.0f);

    @NotNull
    private static final Alignment BottomRight = new BiasAbsoluteAlignment(1.0f, 1.0f);

    @NotNull
    private static final Alignment.Horizontal Left = new BiasAbsoluteAlignment.Horizontal(-1.0f);

    @NotNull
    private static final Alignment.Horizontal Right = new BiasAbsoluteAlignment.Horizontal(1.0f);

    private AbsoluteAlignment() {
    }

    @Stable
    public static /* synthetic */ void getBottomLeft$annotations() {
    }

    @Stable
    public static /* synthetic */ void getBottomRight$annotations() {
    }

    @Stable
    public static /* synthetic */ void getCenterLeft$annotations() {
    }

    @Stable
    public static /* synthetic */ void getCenterRight$annotations() {
    }

    @Stable
    public static /* synthetic */ void getLeft$annotations() {
    }

    @Stable
    public static /* synthetic */ void getRight$annotations() {
    }

    @Stable
    public static /* synthetic */ void getTopLeft$annotations() {
    }

    @Stable
    public static /* synthetic */ void getTopRight$annotations() {
    }

    @NotNull
    public final Alignment getBottomLeft() {
        return BottomLeft;
    }

    @NotNull
    public final Alignment getBottomRight() {
        return BottomRight;
    }

    @NotNull
    public final Alignment getCenterLeft() {
        return CenterLeft;
    }

    @NotNull
    public final Alignment getCenterRight() {
        return CenterRight;
    }

    @NotNull
    public final Alignment.Horizontal getLeft() {
        return Left;
    }

    @NotNull
    public final Alignment.Horizontal getRight() {
        return Right;
    }

    @NotNull
    public final Alignment getTopLeft() {
        return TopLeft;
    }

    @NotNull
    public final Alignment getTopRight() {
        return TopRight;
    }
}
