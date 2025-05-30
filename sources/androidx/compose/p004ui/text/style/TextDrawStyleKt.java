package androidx.compose.p004ui.text.style;

import android.taobao.windvane.extra.p002uc.AliRequestAdapter;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.text.SpanStyleKt;
import androidx.compose.p004ui.util.MathHelpersKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmName(name = "TextDrawStyleKt")
/* loaded from: classes.dex */
public final class TextDrawStyleKt {
    @NotNull
    public static final TextForegroundStyle lerp(@NotNull TextForegroundStyle textForegroundStyle, @NotNull TextForegroundStyle textForegroundStyle2, float f) {
        Intrinsics.checkNotNullParameter(textForegroundStyle, "start");
        Intrinsics.checkNotNullParameter(textForegroundStyle2, AliRequestAdapter.PHASE_STOP);
        boolean z = textForegroundStyle instanceof BrushStyle;
        return (z || (textForegroundStyle2 instanceof BrushStyle)) ? (z && (textForegroundStyle2 instanceof BrushStyle)) ? TextForegroundStyle.Companion.from((Brush) SpanStyleKt.lerpDiscrete(((BrushStyle) textForegroundStyle).getBrush(), ((BrushStyle) textForegroundStyle2).getBrush(), f), MathHelpersKt.lerp(textForegroundStyle.getAlpha(), textForegroundStyle2.getAlpha(), f)) : (TextForegroundStyle) SpanStyleKt.lerpDiscrete(textForegroundStyle, textForegroundStyle2, f) : TextForegroundStyle.Companion.m5098from8_81llA(ColorKt.m2838lerpjxsXWHM(textForegroundStyle.mo5002getColor0d7_KjU(), textForegroundStyle2.mo5002getColor0d7_KjU(), f));
    }

    /* renamed from: modulate-DxMtmZc, reason: not valid java name */
    public static final long m5097modulateDxMtmZc(long j, float f) {
        return (Float.isNaN(f) || f >= 1.0f) ? j : Color.m2786copywmQWz5c$default(j, Color.m2789getAlphaimpl(j) * f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float takeOrElse(float f, Function0<Float> function0) {
        return Float.isNaN(f) ? ((Number) function0.invoke()).floatValue() : f;
    }
}
