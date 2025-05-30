package androidx.compose.animation.core;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class EasingFunctionsKt$EaseOutElastic$1 implements Easing {
    public static final EasingFunctionsKt$EaseOutElastic$1 INSTANCE = new EasingFunctionsKt$EaseOutElastic$1();

    EasingFunctionsKt$EaseOutElastic$1() {
    }

    @Override // androidx.compose.animation.core.Easing
    public final float transform(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        if (f == 1.0f) {
            return 1.0f;
        }
        return (float) ((((float) Math.pow(2.0f, (-10.0f) * f)) * Math.sin(((f * 10.0f) - 0.75f) * 2.0943951023931953d)) + 1.0f);
    }
}
