package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.style.TextForegroundStyle;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextForegroundStyle$Companion {
    static final /* synthetic */ TextForegroundStyle$Companion $$INSTANCE = new TextForegroundStyle$Companion();

    private TextForegroundStyle$Companion() {
    }

    @NotNull
    public final TextForegroundStyle from(@Nullable Brush brush, float f) {
        if (brush == null) {
            return TextForegroundStyle.Unspecified.INSTANCE;
        }
        if (brush instanceof SolidColor) {
            return m2075from8_81llA(TextDrawStyleKt.m2074modulateDxMtmZc(((SolidColor) brush).m1233getValue0d7_KjU(), f));
        }
        if (brush instanceof ShaderBrush) {
            return new BrushStyle((ShaderBrush) brush, f);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    /* renamed from: from-8_81llA, reason: not valid java name */
    public final TextForegroundStyle m2075from8_81llA(long j) {
        return (j > Color.Companion.getUnspecified-0d7_KjU() ? 1 : (j == Color.Companion.getUnspecified-0d7_KjU() ? 0 : -1)) != 0 ? new ColorStyle(j, null) : TextForegroundStyle.Unspecified.INSTANCE;
    }
}
