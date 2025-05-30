package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.qa;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Arrangement$Bottom$1 implements Arrangement$Vertical {
    Arrangement$Bottom$1() {
    }

    @Override // androidx.compose.foundation.layout.Arrangement$Vertical
    public void arrange(@NotNull Density density, int i, @NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "sizes");
        Intrinsics.checkNotNullParameter(iArr2, "outPositions");
        Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, false);
    }

    @Override // androidx.compose.foundation.layout.Arrangement$Vertical
    /* renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
    public /* synthetic */ float mo285getSpacingD9Ej5fM() {
        return qa.a(this);
    }

    @NotNull
    public String toString() {
        return "Arrangement#Bottom";
    }
}
