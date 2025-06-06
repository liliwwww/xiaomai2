package androidx.compose.animation;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FlingCalculatorKt {
    private static final float DecelerationRate = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final float GravityEarth = 9.80665f;
    private static final float InchesPerMeter = 39.37f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final float computeDeceleration(float f, float f2) {
        return f2 * 386.0878f * 160.0f * f;
    }
}
