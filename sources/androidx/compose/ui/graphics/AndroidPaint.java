package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.Shader;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidPaint implements Paint {
    private int _blendMode;

    @Nullable
    private ColorFilter internalColorFilter;

    @NotNull
    private Paint internalPaint;

    @Nullable
    private Shader internalShader;

    @Nullable
    private PathEffect pathEffect;

    public AndroidPaint(@NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "internalPaint");
        this.internalPaint = paint;
        this._blendMode = BlendMode.Companion.m1005getSrcOver0nO6VwU();
    }

    @NotNull
    public Paint asFrameworkPaint() {
        return this.internalPaint;
    }

    public float getAlpha() {
        return AndroidPaint_androidKt.getNativeAlpha(this.internalPaint);
    }

    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public int m940getBlendMode0nO6VwU() {
        return this._blendMode;
    }

    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public long m941getColor0d7_KjU() {
        return AndroidPaint_androidKt.getNativeColor(this.internalPaint);
    }

    @Nullable
    public ColorFilter getColorFilter() {
        return this.internalColorFilter;
    }

    /* renamed from: getFilterQuality-f-v9h1I, reason: not valid java name */
    public int m942getFilterQualityfv9h1I() {
        return AndroidPaint_androidKt.getNativeFilterQuality(this.internalPaint);
    }

    @Nullable
    public PathEffect getPathEffect() {
        return this.pathEffect;
    }

    @Nullable
    public Shader getShader() {
        return this.internalShader;
    }

    /* renamed from: getStrokeCap-KaPHkGw, reason: not valid java name */
    public int m943getStrokeCapKaPHkGw() {
        return AndroidPaint_androidKt.getNativeStrokeCap(this.internalPaint);
    }

    /* renamed from: getStrokeJoin-LxFBmk8, reason: not valid java name */
    public int m944getStrokeJoinLxFBmk8() {
        return AndroidPaint_androidKt.getNativeStrokeJoin(this.internalPaint);
    }

    public float getStrokeMiterLimit() {
        return AndroidPaint_androidKt.getNativeStrokeMiterLimit(this.internalPaint);
    }

    public float getStrokeWidth() {
        return AndroidPaint_androidKt.getNativeStrokeWidth(this.internalPaint);
    }

    /* renamed from: getStyle-TiuSbCo, reason: not valid java name */
    public int m945getStyleTiuSbCo() {
        return AndroidPaint_androidKt.getNativeStyle(this.internalPaint);
    }

    public boolean isAntiAlias() {
        return AndroidPaint_androidKt.getNativeAntiAlias(this.internalPaint);
    }

    public void setAlpha(float f) {
        AndroidPaint_androidKt.setNativeAlpha(this.internalPaint, f);
    }

    public void setAntiAlias(boolean z) {
        AndroidPaint_androidKt.setNativeAntiAlias(this.internalPaint, z);
    }

    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public void m946setBlendModes9anfk8(int i) {
        this._blendMode = i;
        AndroidPaint_androidKt.m952setNativeBlendModeGB0RdKg(this.internalPaint, i);
    }

    /* renamed from: setColor-8_81llA, reason: not valid java name */
    public void m947setColor8_81llA(long j) {
        AndroidPaint_androidKt.m953setNativeColor4WTKRHQ(this.internalPaint, j);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.internalColorFilter = colorFilter;
        AndroidPaint_androidKt.setNativeColorFilter(this.internalPaint, colorFilter);
    }

    /* renamed from: setFilterQuality-vDHp3xo, reason: not valid java name */
    public void m948setFilterQualityvDHp3xo(int i) {
        AndroidPaint_androidKt.m954setNativeFilterQuality50PEsBU(this.internalPaint, i);
    }

    public void setPathEffect(@Nullable PathEffect pathEffect) {
        AndroidPaint_androidKt.setNativePathEffect(this.internalPaint, pathEffect);
        this.pathEffect = pathEffect;
    }

    public void setShader(@Nullable Shader shader) {
        this.internalShader = shader;
        AndroidPaint_androidKt.setNativeShader(this.internalPaint, shader);
    }

    /* renamed from: setStrokeCap-BeK7IIE, reason: not valid java name */
    public void m949setStrokeCapBeK7IIE(int i) {
        AndroidPaint_androidKt.m955setNativeStrokeCapCSYIeUk(this.internalPaint, i);
    }

    /* renamed from: setStrokeJoin-Ww9F2mQ, reason: not valid java name */
    public void m950setStrokeJoinWw9F2mQ(int i) {
        AndroidPaint_androidKt.m956setNativeStrokeJoinkLtJ_vA(this.internalPaint, i);
    }

    public void setStrokeMiterLimit(float f) {
        AndroidPaint_androidKt.setNativeStrokeMiterLimit(this.internalPaint, f);
    }

    public void setStrokeWidth(float f) {
        AndroidPaint_androidKt.setNativeStrokeWidth(this.internalPaint, f);
    }

    /* renamed from: setStyle-k9PVt8s, reason: not valid java name */
    public void m951setStylek9PVt8s(int i) {
        AndroidPaint_androidKt.m957setNativeStyle5YerkU(this.internalPaint, i);
    }

    public AndroidPaint() {
        this(AndroidPaint_androidKt.makeNativePaint());
    }
}
