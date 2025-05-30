package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import org.jetbrains.annotations.NotNull;
import tb.oa;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Arrangement$Horizontal {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
        public static float m287getSpacingD9Ej5fM(@NotNull Arrangement$Horizontal arrangement$Horizontal) {
            return oa.b(arrangement$Horizontal);
        }
    }

    void arrange(@NotNull Density density, int i, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull int[] iArr2);

    /* renamed from: getSpacing-D9Ej5fM */
    float mo284getSpacingD9Ej5fM();
}
