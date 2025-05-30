package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import org.jetbrains.annotations.NotNull;
import tb.qa;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Arrangement$Vertical {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
        public static float m291getSpacingD9Ej5fM(@NotNull Arrangement$Vertical arrangement$Vertical) {
            return qa.b(arrangement$Vertical);
        }
    }

    void arrange(@NotNull Density density, int i, @NotNull int[] iArr, @NotNull int[] iArr2);

    /* renamed from: getSpacing-D9Ej5fM */
    float mo285getSpacingD9Ej5fM();
}
