package androidx.compose.p004ui.text.style;

import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ShaderBrush;
import androidx.compose.p004ui.text.style.TextForegroundStyle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class BrushStyle implements TextForegroundStyle {
    private final float alpha;

    @NotNull
    private final ShaderBrush value;

    public BrushStyle(@NotNull ShaderBrush shaderBrush, float f) {
        Intrinsics.checkNotNullParameter(shaderBrush, "value");
        this.value = shaderBrush;
        this.alpha = f;
    }

    public static /* synthetic */ BrushStyle copy$default(BrushStyle brushStyle, ShaderBrush shaderBrush, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            shaderBrush = brushStyle.value;
        }
        if ((i & 2) != 0) {
            f = brushStyle.getAlpha();
        }
        return brushStyle.copy(shaderBrush, f);
    }

    @NotNull
    public final ShaderBrush component1() {
        return this.value;
    }

    public final float component2() {
        return getAlpha();
    }

    @NotNull
    public final BrushStyle copy(@NotNull ShaderBrush shaderBrush, float f) {
        Intrinsics.checkNotNullParameter(shaderBrush, "value");
        return new BrushStyle(shaderBrush, f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrushStyle)) {
            return false;
        }
        BrushStyle brushStyle = (BrushStyle) obj;
        return Intrinsics.areEqual(this.value, brushStyle.value) && Float.compare(getAlpha(), brushStyle.getAlpha()) == 0;
    }

    @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
    @NotNull
    public Brush getBrush() {
        return this.value;
    }

    @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public long mo5002getColor0d7_KjU() {
        return Color.Companion.m2823getUnspecified0d7_KjU();
    }

    @NotNull
    public final ShaderBrush getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + Float.floatToIntBits(getAlpha());
    }

    @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
    public /* synthetic */ TextForegroundStyle merge(TextForegroundStyle textForegroundStyle) {
        return TextForegroundStyle.CC.m170a(this, textForegroundStyle);
    }

    @Override // androidx.compose.p004ui.text.style.TextForegroundStyle
    public /* synthetic */ TextForegroundStyle takeOrElse(Function0 function0) {
        return TextForegroundStyle.CC.m171b(this, function0);
    }

    @NotNull
    public String toString() {
        return "BrushStyle(value=" + this.value + ", alpha=" + getAlpha() + ')';
    }
}
