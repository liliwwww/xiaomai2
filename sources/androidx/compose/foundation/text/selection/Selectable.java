package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Selectable {
    @NotNull
    Rect getBoundingBox(int i);

    /* renamed from: getHandlePosition-dBAh8RU */
    long mo591getHandlePositiondBAh8RU(@NotNull Selection selection, boolean z);

    @Nullable
    LayoutCoordinates getLayoutCoordinates();

    /* renamed from: getRangeOfLineContaining--jx7JFs */
    long mo592getRangeOfLineContainingjx7JFs(int i);

    @Nullable
    Selection getSelectAllSelection();

    long getSelectableId();

    @NotNull
    AnnotatedString getText();

    @NotNull
    /* renamed from: updateSelection-qCDeeow */
    Pair<Selection, Boolean> mo593updateSelectionqCDeeow(long j, long j2, @Nullable Offset offset, boolean z, @NotNull LayoutCoordinates layoutCoordinates, @NotNull SelectionAdjustment selectionAdjustment, @Nullable Selection selection);
}
