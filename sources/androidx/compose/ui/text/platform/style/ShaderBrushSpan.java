package androidx.compose.ui.text.platform.style;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ShaderBrushSpan extends CharacterStyle implements UpdateAppearance {
    private final float alpha;

    @Nullable
    private Pair<Size, ? extends Shader> cachedShader;

    @NotNull
    private final ShaderBrush shaderBrush;
    private long size;

    public ShaderBrushSpan(@NotNull ShaderBrush shaderBrush, float f) {
        Intrinsics.checkNotNullParameter(shaderBrush, "shaderBrush");
        this.shaderBrush = shaderBrush;
        this.alpha = f;
        this.size = Size.Companion.getUnspecified-NH-jbRc();
    }

    public final float getAlpha() {
        return this.alpha;
    }

    @NotNull
    public final ShaderBrush getShaderBrush() {
        return this.shaderBrush;
    }

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m2479getSizeNHjbRc() {
        return this.size;
    }

    /* renamed from: setSize-uvyYCjk, reason: not valid java name */
    public final void m2480setSizeuvyYCjk(long j) {
        this.size = j;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        AndroidTextPaint_androidKt.setAlpha(textPaint, this.alpha);
        if (this.size == Size.Companion.getUnspecified-NH-jbRc()) {
            return;
        }
        Pair<Size, ? extends Shader> pair = this.cachedShader;
        Shader shader = (pair == null || !Size.equals-impl0(((Size) pair.getFirst()).unbox-impl(), this.size)) ? this.shaderBrush.createShader-uvyYCjk(this.size) : (Shader) pair.getSecond();
        textPaint.setShader(shader);
        this.cachedShader = TuplesKt.to(Size.box-impl(this.size), shader);
    }
}
