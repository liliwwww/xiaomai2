package androidx.compose.p004ui.graphics;

import android.graphics.Paint;
import android.graphics.Shader;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
        this._blendMode = BlendMode.Companion.m2737getSrcOver0nO6VwU();
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    @NotNull
    public Paint asFrameworkPaint() {
        return this.internalPaint;
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    public float getAlpha() {
        return AndroidPaint_androidKt.getNativeAlpha(this.internalPaint);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    /* renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public int mo2670getBlendMode0nO6VwU() {
        return this._blendMode;
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public long mo2671getColor0d7_KjU() {
        return AndroidPaint_androidKt.getNativeColor(this.internalPaint);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    @Nullable
    public ColorFilter getColorFilter() {
        return this.internalColorFilter;
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    /* renamed from: getFilterQuality-f-v9h1I, reason: not valid java name */
    public int mo2672getFilterQualityfv9h1I() {
        return AndroidPaint_androidKt.getNativeFilterQuality(this.internalPaint);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    @Nullable
    public PathEffect getPathEffect() {
        return this.pathEffect;
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    @Nullable
    public Shader getShader() {
        return this.internalShader;
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    /* renamed from: getStrokeCap-KaPHkGw, reason: not valid java name */
    public int mo2673getStrokeCapKaPHkGw() {
        return AndroidPaint_androidKt.getNativeStrokeCap(this.internalPaint);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    /* renamed from: getStrokeJoin-LxFBmk8, reason: not valid java name */
    public int mo2674getStrokeJoinLxFBmk8() {
        return AndroidPaint_androidKt.getNativeStrokeJoin(this.internalPaint);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    public float getStrokeMiterLimit() {
        return AndroidPaint_androidKt.getNativeStrokeMiterLimit(this.internalPaint);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    public float getStrokeWidth() {
        return AndroidPaint_androidKt.getNativeStrokeWidth(this.internalPaint);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    /* renamed from: getStyle-TiuSbCo, reason: not valid java name */
    public int mo2675getStyleTiuSbCo() {
        return AndroidPaint_androidKt.getNativeStyle(this.internalPaint);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    public boolean isAntiAlias() {
        return AndroidPaint_androidKt.getNativeAntiAlias(this.internalPaint);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    public void setAlpha(float f) {
        AndroidPaint_androidKt.setNativeAlpha(this.internalPaint, f);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    public void setAntiAlias(boolean z) {
        AndroidPaint_androidKt.setNativeAntiAlias(this.internalPaint, z);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    /* renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public void mo2676setBlendModes9anfk8(int i) {
        this._blendMode = i;
        AndroidPaint_androidKt.m2682setNativeBlendModeGB0RdKg(this.internalPaint, i);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    /* renamed from: setColor-8_81llA, reason: not valid java name */
    public void mo2677setColor8_81llA(long j) {
        AndroidPaint_androidKt.m2683setNativeColor4WTKRHQ(this.internalPaint, j);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.internalColorFilter = colorFilter;
        AndroidPaint_androidKt.setNativeColorFilter(this.internalPaint, colorFilter);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    /* renamed from: setFilterQuality-vDHp3xo, reason: not valid java name */
    public void mo2678setFilterQualityvDHp3xo(int i) {
        AndroidPaint_androidKt.m2684setNativeFilterQuality50PEsBU(this.internalPaint, i);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    public void setPathEffect(@Nullable PathEffect pathEffect) {
        AndroidPaint_androidKt.setNativePathEffect(this.internalPaint, pathEffect);
        this.pathEffect = pathEffect;
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    public void setShader(@Nullable Shader shader) {
        this.internalShader = shader;
        AndroidPaint_androidKt.setNativeShader(this.internalPaint, shader);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    /* renamed from: setStrokeCap-BeK7IIE, reason: not valid java name */
    public void mo2679setStrokeCapBeK7IIE(int i) {
        AndroidPaint_androidKt.m2685setNativeStrokeCapCSYIeUk(this.internalPaint, i);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    /* renamed from: setStrokeJoin-Ww9F2mQ, reason: not valid java name */
    public void mo2680setStrokeJoinWw9F2mQ(int i) {
        AndroidPaint_androidKt.m2686setNativeStrokeJoinkLtJ_vA(this.internalPaint, i);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    public void setStrokeMiterLimit(float f) {
        AndroidPaint_androidKt.setNativeStrokeMiterLimit(this.internalPaint, f);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    public void setStrokeWidth(float f) {
        AndroidPaint_androidKt.setNativeStrokeWidth(this.internalPaint, f);
    }

    @Override // androidx.compose.p004ui.graphics.Paint
    /* renamed from: setStyle-k9PVt8s, reason: not valid java name */
    public void mo2681setStylek9PVt8s(int i) {
        AndroidPaint_androidKt.m2687setNativeStyle5YerkU(this.internalPaint, i);
    }

    public AndroidPaint() {
        this(AndroidPaint_androidKt.makeNativePaint());
    }
}
