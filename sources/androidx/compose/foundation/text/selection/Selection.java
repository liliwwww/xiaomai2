package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Selection {

    @NotNull
    private final AnchorInfo end;
    private final boolean handlesCrossed;

    @NotNull
    private final AnchorInfo start;

    public Selection(@NotNull AnchorInfo anchorInfo, @NotNull AnchorInfo anchorInfo2, boolean z) {
        Intrinsics.checkNotNullParameter(anchorInfo, "start");
        Intrinsics.checkNotNullParameter(anchorInfo2, "end");
        this.start = anchorInfo;
        this.end = anchorInfo2;
        this.handlesCrossed = z;
    }

    public static /* synthetic */ Selection copy$default(Selection selection, AnchorInfo anchorInfo, AnchorInfo anchorInfo2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            anchorInfo = selection.start;
        }
        if ((i & 2) != 0) {
            anchorInfo2 = selection.end;
        }
        if ((i & 4) != 0) {
            z = selection.handlesCrossed;
        }
        return selection.copy(anchorInfo, anchorInfo2, z);
    }

    @NotNull
    public final AnchorInfo component1() {
        return this.start;
    }

    @NotNull
    public final AnchorInfo component2() {
        return this.end;
    }

    public final boolean component3() {
        return this.handlesCrossed;
    }

    @NotNull
    public final Selection copy(@NotNull AnchorInfo anchorInfo, @NotNull AnchorInfo anchorInfo2, boolean z) {
        Intrinsics.checkNotNullParameter(anchorInfo, "start");
        Intrinsics.checkNotNullParameter(anchorInfo2, "end");
        return new Selection(anchorInfo, anchorInfo2, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Selection)) {
            return false;
        }
        Selection selection = (Selection) obj;
        return Intrinsics.areEqual(this.start, selection.start) && Intrinsics.areEqual(this.end, selection.end) && this.handlesCrossed == selection.handlesCrossed;
    }

    @NotNull
    public final AnchorInfo getEnd() {
        return this.end;
    }

    public final boolean getHandlesCrossed() {
        return this.handlesCrossed;
    }

    @NotNull
    public final AnchorInfo getStart() {
        return this.start;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.start.hashCode() * 31) + this.end.hashCode()) * 31;
        boolean z = this.handlesCrossed;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    @NotNull
    public final Selection merge(@Nullable Selection selection) {
        return selection == null ? this : this.handlesCrossed ? copy$default(this, selection.start, null, false, 6, null) : copy$default(this, null, selection.end, false, 5, null);
    }

    @NotNull
    public String toString() {
        return "Selection(start=" + this.start + ", end=" + this.end + ", handlesCrossed=" + this.handlesCrossed + ')';
    }

    /* renamed from: toTextRange-d9O1mEE, reason: not valid java name */
    public final long m599toTextRanged9O1mEE() {
        return TextRangeKt.TextRange(this.start.getOffset(), this.end.getOffset());
    }
}
