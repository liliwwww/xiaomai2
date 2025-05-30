package androidx.compose.p004ui.text.platform;

import android.text.TextPaint;
import androidx.annotation.VisibleForTesting;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.graphics.AndroidPaint_androidKt;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.Paint;
import androidx.compose.p004ui.graphics.PaintingStyle;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.graphics.drawscope.Fill;
import androidx.compose.p004ui.graphics.drawscope.Stroke;
import androidx.compose.p004ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.p004ui.text.style.TextDecoration;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AndroidTextPaint extends TextPaint {

    @NotNull
    private final Paint composePaint;

    @Nullable
    private DrawStyle drawStyle;

    @NotNull
    private Shadow shadow;

    @NotNull
    private TextDecoration textDecoration;

    public AndroidTextPaint(int i, float f) {
        super(i);
        ((TextPaint) this).density = f;
        this.composePaint = AndroidPaint_androidKt.toComposePaint(this);
        this.textDecoration = TextDecoration.Companion.getNone();
        this.shadow = Shadow.Companion.getNone();
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getShadow$ui_text_release$annotations() {
    }

    /* renamed from: setBrush-12SF9DM$default, reason: not valid java name */
    public static /* synthetic */ void m4968setBrush12SF9DM$default(AndroidTextPaint androidTextPaint, Brush brush, long j, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Float.NaN;
        }
        androidTextPaint.m4969setBrush12SF9DM(brush, j, f);
    }

    @NotNull
    public final Shadow getShadow$ui_text_release() {
        return this.shadow;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
    
        r8.mo2740applyToPq9zytI(r9, r0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        r11 = kotlin.ranges.RangesKt.coerceIn(r11, 0.0f, 1.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
    
        if ((r9 != androidx.compose.p004ui.geometry.Size.Companion.m2633getUnspecifiedNHjbRc()) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if ((((androidx.compose.p004ui.graphics.SolidColor) r8).m3074getValue0d7_KjU() != androidx.compose.p004ui.graphics.Color.Companion.m2823getUnspecified0d7_KjU()) == false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:
    
        r0 = r7.composePaint;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        if (java.lang.Float.isNaN(r11) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        r11 = r7.composePaint.getAlpha();
     */
    /* renamed from: setBrush-12SF9DM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4969setBrush12SF9DM(@org.jetbrains.annotations.Nullable androidx.compose.p004ui.graphics.Brush r8, long r9, float r11) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.p004ui.graphics.SolidColor
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1c
            r0 = r8
            androidx.compose.ui.graphics.SolidColor r0 = (androidx.compose.p004ui.graphics.SolidColor) r0
            long r3 = r0.m3074getValue0d7_KjU()
            androidx.compose.ui.graphics.Color$Companion r0 = androidx.compose.p004ui.graphics.Color.Companion
            long r5 = r0.m2823getUnspecified0d7_KjU()
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L19
            r0 = 1
            goto L1a
        L19:
            r0 = 0
        L1a:
            if (r0 != 0) goto L2e
        L1c:
            boolean r0 = r8 instanceof androidx.compose.p004ui.graphics.ShaderBrush
            if (r0 == 0) goto L48
            androidx.compose.ui.geometry.Size$Companion r0 = androidx.compose.p004ui.geometry.Size.Companion
            long r3 = r0.m2633getUnspecifiedNHjbRc()
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 == 0) goto L2b
            goto L2c
        L2b:
            r1 = 0
        L2c:
            if (r1 == 0) goto L48
        L2e:
            androidx.compose.ui.graphics.Paint r0 = r7.composePaint
            boolean r1 = java.lang.Float.isNaN(r11)
            if (r1 == 0) goto L3d
            androidx.compose.ui.graphics.Paint r11 = r7.composePaint
            float r11 = r11.getAlpha()
            goto L44
        L3d:
            r1 = 0
            r2 = 1065353216(0x3f800000, float:1.0)
            float r11 = kotlin.ranges.RangesKt.coerceIn(r11, r1, r2)
        L44:
            r8.mo2740applyToPq9zytI(r9, r0, r11)
            goto L50
        L48:
            if (r8 != 0) goto L50
            androidx.compose.ui.graphics.Paint r8 = r7.composePaint
            r9 = 0
            r8.setShader(r9)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.text.platform.AndroidTextPaint.m4969setBrush12SF9DM(androidx.compose.ui.graphics.Brush, long, float):void");
    }

    /* renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m4970setColor8_81llA(long j) {
        ColorKt.m2841toArgb8_81llA(j);
        if (j != Color.Companion.m2823getUnspecified0d7_KjU()) {
            this.composePaint.mo2677setColor8_81llA(j);
            this.composePaint.setShader(null);
        }
    }

    public final void setDrawStyle(@Nullable DrawStyle drawStyle) {
        if (drawStyle == null || Intrinsics.areEqual(this.drawStyle, drawStyle)) {
            return;
        }
        this.drawStyle = drawStyle;
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            this.composePaint.mo2681setStylek9PVt8s(PaintingStyle.Companion.m3018getFillTiuSbCo());
            return;
        }
        if (drawStyle instanceof Stroke) {
            this.composePaint.mo2681setStylek9PVt8s(PaintingStyle.Companion.m3019getStrokeTiuSbCo());
            Stroke stroke = (Stroke) drawStyle;
            this.composePaint.setStrokeWidth(stroke.getWidth());
            this.composePaint.setStrokeMiterLimit(stroke.getMiter());
            this.composePaint.mo2680setStrokeJoinWw9F2mQ(stroke.m3293getJoinLxFBmk8());
            this.composePaint.mo2679setStrokeCapBeK7IIE(stroke.m3292getCapKaPHkGw());
            this.composePaint.setPathEffect(stroke.getPathEffect());
        }
    }

    public final void setShadow(@Nullable Shadow shadow) {
        if (shadow == null || Intrinsics.areEqual(this.shadow, shadow)) {
            return;
        }
        this.shadow = shadow;
        if (Intrinsics.areEqual(shadow, Shadow.Companion.getNone())) {
            clearShadowLayer();
        } else {
            setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.m2556getXimpl(this.shadow.m3073getOffsetF1C5BW0()), Offset.m2557getYimpl(this.shadow.m3073getOffsetF1C5BW0()), ColorKt.m2841toArgb8_81llA(this.shadow.m3072getColor0d7_KjU()));
        }
    }

    public final void setShadow$ui_text_release(@NotNull Shadow shadow) {
        Intrinsics.checkNotNullParameter(shadow, "<set-?>");
        this.shadow = shadow;
    }

    public final void setTextDecoration(@Nullable TextDecoration textDecoration) {
        if (textDecoration == null || Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            return;
        }
        this.textDecoration = textDecoration;
        TextDecoration.Companion companion = TextDecoration.Companion;
        setUnderlineText(textDecoration.contains(companion.getUnderline()));
        setStrikeThruText(this.textDecoration.contains(companion.getLineThrough()));
    }
}
