package androidx.compose.ui.graphics;

import android.graphics.Shader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Paint {
    @NotNull
    android.graphics.Paint asFrameworkPaint();

    float getAlpha();

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    int m1160getBlendMode0nO6VwU();

    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    long m1161getColor0d7_KjU();

    @Nullable
    ColorFilter getColorFilter();

    /* renamed from: getFilterQuality-f-v9h1I, reason: not valid java name */
    int m1162getFilterQualityfv9h1I();

    @Nullable
    PathEffect getPathEffect();

    @Nullable
    Shader getShader();

    /* renamed from: getStrokeCap-KaPHkGw, reason: not valid java name */
    int m1163getStrokeCapKaPHkGw();

    /* renamed from: getStrokeJoin-LxFBmk8, reason: not valid java name */
    int m1164getStrokeJoinLxFBmk8();

    float getStrokeMiterLimit();

    float getStrokeWidth();

    /* renamed from: getStyle-TiuSbCo, reason: not valid java name */
    int m1165getStyleTiuSbCo();

    boolean isAntiAlias();

    void setAlpha(float f);

    void setAntiAlias(boolean z);

    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    void m1166setBlendModes9anfk8(int i);

    /* renamed from: setColor-8_81llA, reason: not valid java name */
    void m1167setColor8_81llA(long j);

    void setColorFilter(@Nullable ColorFilter colorFilter);

    /* renamed from: setFilterQuality-vDHp3xo, reason: not valid java name */
    void m1168setFilterQualityvDHp3xo(int i);

    void setPathEffect(@Nullable PathEffect pathEffect);

    void setShader(@Nullable Shader shader);

    /* renamed from: setStrokeCap-BeK7IIE, reason: not valid java name */
    void m1169setStrokeCapBeK7IIE(int i);

    /* renamed from: setStrokeJoin-Ww9F2mQ, reason: not valid java name */
    void m1170setStrokeJoinWw9F2mQ(int i);

    void setStrokeMiterLimit(float f);

    void setStrokeWidth(float f);

    /* renamed from: setStyle-k9PVt8s, reason: not valid java name */
    void m1171setStylek9PVt8s(int i);
}
