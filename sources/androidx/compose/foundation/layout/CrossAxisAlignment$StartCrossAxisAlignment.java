package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CrossAxisAlignment$StartCrossAxisAlignment extends CrossAxisAlignment {

    @NotNull
    public static final CrossAxisAlignment$StartCrossAxisAlignment INSTANCE = new CrossAxisAlignment$StartCrossAxisAlignment();

    private CrossAxisAlignment$StartCrossAxisAlignment() {
        super((DefaultConstructorMarker) null);
    }

    public int align$foundation_layout_release(int i, @NotNull LayoutDirection layoutDirection, @NotNull Placeable placeable, int i2) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(placeable, "placeable");
        if (layoutDirection == LayoutDirection.Ltr) {
            return 0;
        }
        return i;
    }
}
