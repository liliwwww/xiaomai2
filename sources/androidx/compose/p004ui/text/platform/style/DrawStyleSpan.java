package androidx.compose.p004ui.text.platform.style;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.p004ui.graphics.AndroidPathEffect_androidKt;
import androidx.compose.p004ui.graphics.PathEffect;
import androidx.compose.p004ui.graphics.StrokeCap;
import androidx.compose.p004ui.graphics.StrokeJoin;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.graphics.drawscope.Fill;
import androidx.compose.p004ui.graphics.drawscope.Stroke;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class DrawStyleSpan extends CharacterStyle implements UpdateAppearance {

    @NotNull
    private final DrawStyle drawStyle;

    public DrawStyleSpan(@NotNull DrawStyle drawStyle) {
        Intrinsics.checkNotNullParameter(drawStyle, "drawStyle");
        this.drawStyle = drawStyle;
    }

    /* renamed from: toAndroidCap-BeK7IIE, reason: not valid java name */
    private final Paint.Cap m4984toAndroidCapBeK7IIE(int i) {
        StrokeCap.Companion companion = StrokeCap.Companion;
        return StrokeCap.m3088equalsimpl0(i, companion.m3092getButtKaPHkGw()) ? Paint.Cap.BUTT : StrokeCap.m3088equalsimpl0(i, companion.m3093getRoundKaPHkGw()) ? Paint.Cap.ROUND : StrokeCap.m3088equalsimpl0(i, companion.m3094getSquareKaPHkGw()) ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
    }

    /* renamed from: toAndroidJoin-Ww9F2mQ, reason: not valid java name */
    private final Paint.Join m4985toAndroidJoinWw9F2mQ(int i) {
        StrokeJoin.Companion companion = StrokeJoin.Companion;
        return StrokeJoin.m3098equalsimpl0(i, companion.m3103getMiterLxFBmk8()) ? Paint.Join.MITER : StrokeJoin.m3098equalsimpl0(i, companion.m3104getRoundLxFBmk8()) ? Paint.Join.ROUND : StrokeJoin.m3098equalsimpl0(i, companion.m3102getBevelLxFBmk8()) ? Paint.Join.BEVEL : Paint.Join.MITER;
    }

    @NotNull
    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@Nullable TextPaint textPaint) {
        if (textPaint != null) {
            DrawStyle drawStyle = this.drawStyle;
            if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
                textPaint.setStyle(Paint.Style.FILL);
                return;
            }
            if (drawStyle instanceof Stroke) {
                textPaint.setStyle(Paint.Style.STROKE);
                textPaint.setStrokeWidth(((Stroke) this.drawStyle).getWidth());
                textPaint.setStrokeMiter(((Stroke) this.drawStyle).getMiter());
                textPaint.setStrokeJoin(m4985toAndroidJoinWw9F2mQ(((Stroke) this.drawStyle).m3293getJoinLxFBmk8()));
                textPaint.setStrokeCap(m4984toAndroidCapBeK7IIE(((Stroke) this.drawStyle).m3292getCapKaPHkGw()));
                PathEffect pathEffect = ((Stroke) this.drawStyle).getPathEffect();
                textPaint.setPathEffect(pathEffect != null ? AndroidPathEffect_androidKt.asAndroidPathEffect(pathEffect) : null);
            }
        }
    }
}
