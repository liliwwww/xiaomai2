package androidx.compose.ui.draw;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class RotateKt {
    @Stable
    @NotNull
    public static final Modifier rotate(@NotNull Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return !((f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) == 0) ? GraphicsLayerModifierKt.m1125graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 130815, null) : modifier;
    }
}
