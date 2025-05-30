package androidx.compose.p004ui.text.platform;

import android.text.TextPaint;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AndroidTextPaint_androidKt {
    public static final void setAlpha(@NotNull TextPaint textPaint, float f) {
        Intrinsics.checkNotNullParameter(textPaint, "<this>");
        if (Float.isNaN(f)) {
            return;
        }
        textPaint.setAlpha(MathKt.roundToInt(RangesKt.coerceIn(f, 0.0f, 1.0f) * 255));
    }
}
