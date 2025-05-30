package androidx.compose.animation.core;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class EasingFunctionsKt$EaseInOutBounce$1 implements Easing {
    public static final EasingFunctionsKt$EaseInOutBounce$1 INSTANCE = new EasingFunctionsKt$EaseInOutBounce$1();

    EasingFunctionsKt$EaseInOutBounce$1() {
    }

    @Override // androidx.compose.animation.core.Easing
    public final float transform(float f) {
        return (((double) f) < 0.5d ? 1 - EasingFunctionsKt.getEaseOutBounce().transform(1.0f - (f * 2.0f)) : 1 + EasingFunctionsKt.getEaseOutBounce().transform((f * 2.0f) - 1.0f)) / 2.0f;
    }
}
