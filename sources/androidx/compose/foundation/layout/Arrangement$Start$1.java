package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.oa;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Arrangement$Start$1 implements Arrangement$Horizontal {
    Arrangement$Start$1() {
    }

    @Override // androidx.compose.foundation.layout.Arrangement$Horizontal
    public void arrange(@NotNull Density density, int i, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "sizes");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(iArr2, "outPositions");
        if (layoutDirection == LayoutDirection.Ltr) {
            Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
        } else {
            Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, true);
        }
    }

    @Override // androidx.compose.foundation.layout.Arrangement$Horizontal
    /* renamed from: getSpacing-D9Ej5fM */
    public /* synthetic */ float mo284getSpacingD9Ej5fM() {
        return oa.a(this);
    }

    @NotNull
    public String toString() {
        return "Arrangement#Start";
    }
}
