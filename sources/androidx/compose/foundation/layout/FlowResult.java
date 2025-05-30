package androidx.compose.foundation.layout;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class FlowResult {
    private final int crossAxisTotalSize;

    @NotNull
    private final MutableVector<RowColumnMeasureHelperResult> items;
    private final int mainAxisTotalSize;

    public FlowResult(int i, int i2, @NotNull MutableVector<RowColumnMeasureHelperResult> mutableVector) {
        Intrinsics.checkNotNullParameter(mutableVector, "items");
        this.mainAxisTotalSize = i;
        this.crossAxisTotalSize = i2;
        this.items = mutableVector;
    }

    public final int getCrossAxisTotalSize() {
        return this.crossAxisTotalSize;
    }

    @NotNull
    public final MutableVector<RowColumnMeasureHelperResult> getItems() {
        return this.items;
    }

    public final int getMainAxisTotalSize() {
        return this.mainAxisTotalSize;
    }
}
