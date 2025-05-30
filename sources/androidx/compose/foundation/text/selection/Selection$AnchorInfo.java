package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.c8;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Selection$AnchorInfo {

    @NotNull
    private final ResolvedTextDirection direction;
    private final int offset;
    private final long selectableId;

    public Selection$AnchorInfo(@NotNull ResolvedTextDirection resolvedTextDirection, int i, long j) {
        Intrinsics.checkNotNullParameter(resolvedTextDirection, "direction");
        this.direction = resolvedTextDirection;
        this.offset = i;
        this.selectableId = j;
    }

    public static /* synthetic */ Selection$AnchorInfo copy$default(Selection$AnchorInfo selection$AnchorInfo, ResolvedTextDirection resolvedTextDirection, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            resolvedTextDirection = selection$AnchorInfo.direction;
        }
        if ((i2 & 2) != 0) {
            i = selection$AnchorInfo.offset;
        }
        if ((i2 & 4) != 0) {
            j = selection$AnchorInfo.selectableId;
        }
        return selection$AnchorInfo.copy(resolvedTextDirection, i, j);
    }

    @NotNull
    public final ResolvedTextDirection component1() {
        return this.direction;
    }

    public final int component2() {
        return this.offset;
    }

    public final long component3() {
        return this.selectableId;
    }

    @NotNull
    public final Selection$AnchorInfo copy(@NotNull ResolvedTextDirection resolvedTextDirection, int i, long j) {
        Intrinsics.checkNotNullParameter(resolvedTextDirection, "direction");
        return new Selection$AnchorInfo(resolvedTextDirection, i, j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Selection$AnchorInfo)) {
            return false;
        }
        Selection$AnchorInfo selection$AnchorInfo = (Selection$AnchorInfo) obj;
        return this.direction == selection$AnchorInfo.direction && this.offset == selection$AnchorInfo.offset && this.selectableId == selection$AnchorInfo.selectableId;
    }

    @NotNull
    public final ResolvedTextDirection getDirection() {
        return this.direction;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final long getSelectableId() {
        return this.selectableId;
    }

    public int hashCode() {
        return (((this.direction.hashCode() * 31) + this.offset) * 31) + c8.a(this.selectableId);
    }

    @NotNull
    public String toString() {
        return "AnchorInfo(direction=" + this.direction + ", offset=" + this.offset + ", selectableId=" + this.selectableId + ')';
    }
}
