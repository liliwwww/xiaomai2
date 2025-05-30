package androidx.compose.p004ui.graphics;

import android.graphics.Shader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Paint {
    @NotNull
    android.graphics.Paint asFrameworkPaint();

    float getAlpha();

    /* renamed from: getBlendMode-0nO6VwU */
    int mo2670getBlendMode0nO6VwU();

    /* renamed from: getColor-0d7_KjU */
    long mo2671getColor0d7_KjU();

    @Nullable
    ColorFilter getColorFilter();

    /* renamed from: getFilterQuality-f-v9h1I */
    int mo2672getFilterQualityfv9h1I();

    @Nullable
    PathEffect getPathEffect();

    @Nullable
    Shader getShader();

    /* renamed from: getStrokeCap-KaPHkGw */
    int mo2673getStrokeCapKaPHkGw();

    /* renamed from: getStrokeJoin-LxFBmk8 */
    int mo2674getStrokeJoinLxFBmk8();

    float getStrokeMiterLimit();

    float getStrokeWidth();

    /* renamed from: getStyle-TiuSbCo */
    int mo2675getStyleTiuSbCo();

    boolean isAntiAlias();

    void setAlpha(float f);

    void setAntiAlias(boolean z);

    /* renamed from: setBlendMode-s9anfk8 */
    void mo2676setBlendModes9anfk8(int i);

    /* renamed from: setColor-8_81llA */
    void mo2677setColor8_81llA(long j);

    void setColorFilter(@Nullable ColorFilter colorFilter);

    /* renamed from: setFilterQuality-vDHp3xo */
    void mo2678setFilterQualityvDHp3xo(int i);

    void setPathEffect(@Nullable PathEffect pathEffect);

    void setShader(@Nullable Shader shader);

    /* renamed from: setStrokeCap-BeK7IIE */
    void mo2679setStrokeCapBeK7IIE(int i);

    /* renamed from: setStrokeJoin-Ww9F2mQ */
    void mo2680setStrokeJoinWw9F2mQ(int i);

    void setStrokeMiterLimit(float f);

    void setStrokeWidth(float f);

    /* renamed from: setStyle-k9PVt8s */
    void mo2681setStylek9PVt8s(int i);
}
