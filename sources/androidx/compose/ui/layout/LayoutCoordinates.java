package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface LayoutCoordinates {
    int get(@NotNull AlignmentLine alignmentLine);

    @Nullable
    LayoutCoordinates getParentCoordinates();

    @Nullable
    LayoutCoordinates getParentLayoutCoordinates();

    @NotNull
    Set<AlignmentLine> getProvidedAlignmentLines();

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo1522getSizeYbymL2g();

    boolean isAttached();

    @NotNull
    Rect localBoundingBoxOf(@NotNull LayoutCoordinates layoutCoordinates, boolean z);

    /* renamed from: localPositionOf-R5De75A, reason: not valid java name */
    long mo1523localPositionOfR5De75A(@NotNull LayoutCoordinates layoutCoordinates, long j);

    /* renamed from: localToRoot-MK-Hz9U, reason: not valid java name */
    long mo1524localToRootMKHz9U(long j);

    /* renamed from: localToWindow-MK-Hz9U, reason: not valid java name */
    long mo1525localToWindowMKHz9U(long j);

    /* renamed from: transformFrom-EL8BTi8, reason: not valid java name */
    void mo1526transformFromEL8BTi8(@NotNull LayoutCoordinates layoutCoordinates, @NotNull float[] fArr);

    /* renamed from: windowToLocal-MK-Hz9U, reason: not valid java name */
    long mo1527windowToLocalMKHz9U(long j);
}
