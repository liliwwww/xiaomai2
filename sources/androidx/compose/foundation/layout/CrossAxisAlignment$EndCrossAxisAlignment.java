package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CrossAxisAlignment$EndCrossAxisAlignment extends CrossAxisAlignment {

    @NotNull
    public static final CrossAxisAlignment$EndCrossAxisAlignment INSTANCE = new CrossAxisAlignment$EndCrossAxisAlignment();

    private CrossAxisAlignment$EndCrossAxisAlignment() {
        super((DefaultConstructorMarker) null);
    }

    public int align$foundation_layout_release(int i, @NotNull LayoutDirection layoutDirection, @NotNull Placeable placeable, int i2) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(placeable, "placeable");
        if (layoutDirection == LayoutDirection.Ltr) {
            return i;
        }
        return 0;
    }
}
