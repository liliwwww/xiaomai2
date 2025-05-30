package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Arrangement$SpaceBetween$1 implements Arrangement.HorizontalOrVertical {
    private final float spacing = Dp.constructor-impl(0);

    Arrangement$SpaceBetween$1() {
    }

    public void arrange(@NotNull Density density, int i, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "sizes");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(iArr2, "outPositions");
        if (layoutDirection == LayoutDirection.Ltr) {
            Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, false);
        } else {
            Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, true);
        }
    }

    /* renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
    public float m290getSpacingD9Ej5fM() {
        return this.spacing;
    }

    @NotNull
    public String toString() {
        return "Arrangement#SpaceBetween";
    }

    public void arrange(@NotNull Density density, int i, @NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "sizes");
        Intrinsics.checkNotNullParameter(iArr2, "outPositions");
        Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, iArr, iArr2, false);
    }
}
