package androidx.compose.p004ui.text.platform.style;

import android.graphics.Shader;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.ShaderBrush;
import androidx.compose.p004ui.text.platform.AndroidTextPaint_androidKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
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
        this.size = Size.Companion.m2633getUnspecifiedNHjbRc();
    }

    public final float getAlpha() {
        return this.alpha;
    }

    @NotNull
    public final ShaderBrush getShaderBrush() {
        return this.shaderBrush;
    }

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m4986getSizeNHjbRc() {
        return this.size;
    }

    /* renamed from: setSize-uvyYCjk, reason: not valid java name */
    public final void m4987setSizeuvyYCjk(long j) {
        this.size = j;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        AndroidTextPaint_androidKt.setAlpha(textPaint, this.alpha);
        if (this.size == Size.Companion.m2633getUnspecifiedNHjbRc()) {
            return;
        }
        Pair<Size, ? extends Shader> pair = this.cachedShader;
        Shader mo2762createShaderuvyYCjk = (pair == null || !Size.m2621equalsimpl0(((Size) pair.getFirst()).m2630unboximpl(), this.size)) ? this.shaderBrush.mo2762createShaderuvyYCjk(this.size) : (Shader) pair.getSecond();
        textPaint.setShader(mo2762createShaderuvyYCjk);
        this.cachedShader = TuplesKt.to(Size.m2613boximpl(this.size), mo2762createShaderuvyYCjk);
    }
}
