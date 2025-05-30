package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CrossAxisAlignment$HorizontalCrossAxisAlignment extends CrossAxisAlignment {

    @NotNull
    private final Alignment.Horizontal horizontal;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CrossAxisAlignment$HorizontalCrossAxisAlignment(@NotNull Alignment.Horizontal horizontal) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(horizontal, "horizontal");
        this.horizontal = horizontal;
    }

    public int align$foundation_layout_release(int i, @NotNull LayoutDirection layoutDirection, @NotNull Placeable placeable, int i2) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(placeable, "placeable");
        return this.horizontal.align(0, i, layoutDirection);
    }

    @NotNull
    public final Alignment.Horizontal getHorizontal() {
        return this.horizontal;
    }
}
