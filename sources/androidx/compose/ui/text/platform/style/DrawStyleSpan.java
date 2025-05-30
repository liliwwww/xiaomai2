package androidx.compose.ui.text.platform.style;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.graphics.AndroidPathEffect_androidKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DrawStyleSpan extends CharacterStyle implements UpdateAppearance {

    @NotNull
    private final DrawStyle drawStyle;

    public DrawStyleSpan(@NotNull DrawStyle drawStyle) {
        Intrinsics.checkNotNullParameter(drawStyle, "drawStyle");
        this.drawStyle = drawStyle;
    }

    /* renamed from: toAndroidCap-BeK7IIE, reason: not valid java name */
    private final Paint.Cap m1998toAndroidCapBeK7IIE(int i) {
        StrokeCap.Companion companion = StrokeCap.Companion;
        return StrokeCap.m1247equalsimpl0(i, companion.getButt-KaPHkGw()) ? Paint.Cap.BUTT : StrokeCap.m1247equalsimpl0(i, companion.getRound-KaPHkGw()) ? Paint.Cap.ROUND : StrokeCap.m1247equalsimpl0(i, companion.getSquare-KaPHkGw()) ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
    }

    /* renamed from: toAndroidJoin-Ww9F2mQ, reason: not valid java name */
    private final Paint.Join m1999toAndroidJoinWw9F2mQ(int i) {
        StrokeJoin.Companion companion = StrokeJoin.Companion;
        return StrokeJoin.m1254equalsimpl0(i, companion.getMiter-LxFBmk8()) ? Paint.Join.MITER : StrokeJoin.m1254equalsimpl0(i, companion.getRound-LxFBmk8()) ? Paint.Join.ROUND : StrokeJoin.m1254equalsimpl0(i, companion.getBevel-LxFBmk8()) ? Paint.Join.BEVEL : Paint.Join.MITER;
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
                textPaint.setStrokeWidth(this.drawStyle.getWidth());
                textPaint.setStrokeMiter(this.drawStyle.getMiter());
                textPaint.setStrokeJoin(m1999toAndroidJoinWw9F2mQ(this.drawStyle.getJoin-LxFBmk8()));
                textPaint.setStrokeCap(m1998toAndroidCapBeK7IIE(this.drawStyle.getCap-KaPHkGw()));
                PathEffect pathEffect = this.drawStyle.getPathEffect();
                textPaint.setPathEffect(pathEffect != null ? AndroidPathEffect_androidKt.asAndroidPathEffect(pathEffect) : null);
            }
        }
    }
}
