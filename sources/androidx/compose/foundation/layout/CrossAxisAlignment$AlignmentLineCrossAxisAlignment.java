package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CrossAxisAlignment$AlignmentLineCrossAxisAlignment extends CrossAxisAlignment {

    @NotNull
    private final AlignmentLineProvider alignmentLineProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrossAxisAlignment$AlignmentLineCrossAxisAlignment(@NotNull AlignmentLineProvider alignmentLineProvider) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(alignmentLineProvider, "alignmentLineProvider");
        this.alignmentLineProvider = alignmentLineProvider;
    }

    public int align$foundation_layout_release(int i, @NotNull LayoutDirection layoutDirection, @NotNull Placeable placeable, int i2) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(placeable, "placeable");
        int calculateAlignmentLinePosition = this.alignmentLineProvider.calculateAlignmentLinePosition(placeable);
        if (calculateAlignmentLinePosition == Integer.MIN_VALUE) {
            return 0;
        }
        int i3 = i2 - calculateAlignmentLinePosition;
        return layoutDirection == LayoutDirection.Rtl ? i - i3 : i3;
    }

    @NotNull
    public Integer calculateAlignmentLinePosition$foundation_layout_release(@NotNull Placeable placeable) {
        Intrinsics.checkNotNullParameter(placeable, "placeable");
        return Integer.valueOf(this.alignmentLineProvider.calculateAlignmentLinePosition(placeable));
    }

    @NotNull
    public final AlignmentLineProvider getAlignmentLineProvider() {
        return this.alignmentLineProvider;
    }

    public boolean isRelative$foundation_layout_release() {
        return true;
    }
}
