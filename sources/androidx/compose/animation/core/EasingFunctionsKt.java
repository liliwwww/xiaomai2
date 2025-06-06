package androidx.compose.animation.core;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class EasingFunctionsKt {

    @NotNull
    private static final Easing Ease = new CubicBezierEasing(0.25f, 0.1f, 0.25f, 1.0f);

    @NotNull
    private static final Easing EaseOut = new CubicBezierEasing(0.0f, 0.0f, 0.58f, 1.0f);

    @NotNull
    private static final Easing EaseIn = new CubicBezierEasing(0.42f, 0.0f, 1.0f, 1.0f);

    @NotNull
    private static final Easing EaseInOut = new CubicBezierEasing(0.42f, 0.0f, 0.58f, 1.0f);

    @NotNull
    private static final Easing EaseInSine = new CubicBezierEasing(0.12f, 0.0f, 0.39f, 0.0f);

    @NotNull
    private static final Easing EaseOutSine = new CubicBezierEasing(0.61f, 1.0f, 0.88f, 1.0f);

    @NotNull
    private static final Easing EaseInOutSine = new CubicBezierEasing(0.37f, 0.0f, 0.63f, 1.0f);

    @NotNull
    private static final Easing EaseInCubic = new CubicBezierEasing(0.32f, 0.0f, 0.67f, 0.0f);

    @NotNull
    private static final Easing EaseOutCubic = new CubicBezierEasing(0.33f, 1.0f, 0.68f, 1.0f);

    @NotNull
    private static final Easing EaseInOutCubic = new CubicBezierEasing(0.65f, 0.0f, 0.35f, 1.0f);

    @NotNull
    private static final Easing EaseInQuint = new CubicBezierEasing(0.64f, 0.0f, 0.78f, 0.0f);

    @NotNull
    private static final Easing EaseOutQuint = new CubicBezierEasing(0.22f, 1.0f, 0.36f, 1.0f);

    @NotNull
    private static final Easing EaseInOutQuint = new CubicBezierEasing(0.83f, 0.0f, 0.17f, 1.0f);

    @NotNull
    private static final Easing EaseInCirc = new CubicBezierEasing(0.55f, 0.0f, 1.0f, 0.45f);

    @NotNull
    private static final Easing EaseOutCirc = new CubicBezierEasing(0.0f, 0.55f, 0.45f, 1.0f);

    @NotNull
    private static final Easing EaseInOutCirc = new CubicBezierEasing(0.85f, 0.0f, 0.15f, 1.0f);

    @NotNull
    private static final Easing EaseInQuad = new CubicBezierEasing(0.11f, 0.0f, 0.5f, 0.0f);

    @NotNull
    private static final Easing EaseOutQuad = new CubicBezierEasing(0.5f, 1.0f, 0.89f, 1.0f);

    @NotNull
    private static final Easing EaseInOutQuad = new CubicBezierEasing(0.45f, 0.0f, 0.55f, 1.0f);

    @NotNull
    private static final Easing EaseInQuart = new CubicBezierEasing(0.5f, 0.0f, 0.75f, 0.0f);

    @NotNull
    private static final Easing EaseOutQuart = new CubicBezierEasing(0.25f, 1.0f, 0.5f, 1.0f);

    @NotNull
    private static final Easing EaseInOutQuart = new CubicBezierEasing(0.76f, 0.0f, 0.24f, 1.0f);

    @NotNull
    private static final Easing EaseInExpo = new CubicBezierEasing(0.7f, 0.0f, 0.84f, 0.0f);

    @NotNull
    private static final Easing EaseOutExpo = new CubicBezierEasing(0.16f, 1.0f, 0.3f, 1.0f);

    @NotNull
    private static final Easing EaseInOutExpo = new CubicBezierEasing(0.87f, 0.0f, 0.13f, 1.0f);

    @NotNull
    private static final Easing EaseInBack = new CubicBezierEasing(0.36f, 0.0f, 0.66f, -0.56f);

    @NotNull
    private static final Easing EaseOutBack = new CubicBezierEasing(0.34f, 1.56f, 0.64f, 1.0f);

    @NotNull
    private static final Easing EaseInOutBack = new CubicBezierEasing(0.68f, -0.6f, 0.32f, 1.6f);

    @NotNull
    private static final Easing EaseInElastic = new Easing() { // from class: androidx.compose.animation.core.EasingFunctionsKt$EaseInElastic$1
        public final float transform(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            float f2 = f * 10.0f;
            return (float) ((-((float) Math.pow(2.0f, f2 - 10.0f))) * Math.sin((f2 - 10.75f) * 2.0943951023931953d));
        }
    };

    @NotNull
    private static final Easing EaseOutElastic = EaseOutElastic.1.INSTANCE;

    @NotNull
    private static final Easing EaseInOutElastic = new Easing() { // from class: androidx.compose.animation.core.EasingFunctionsKt$EaseInOutElastic$1
        public final float transform(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            if (!(0.0f <= f && f <= 0.5f)) {
                return ((float) ((((float) Math.pow(r8, ((-20.0f) * f) + 10.0f)) * Math.sin(((f * 20.0f) - 11.125f) * 1.3962634015954636d)) / 2.0f)) + 1.0f;
            }
            float f2 = f * 20.0f;
            return (float) ((-(((float) Math.pow(r4, f2 - 10.0f)) * Math.sin((f2 - 11.125f) * 1.3962634015954636d))) / 2.0f);
        }
    };

    @NotNull
    private static final Easing EaseOutBounce = new Easing() { // from class: androidx.compose.animation.core.EasingFunctionsKt$EaseOutBounce$1
        public final float transform(float f) {
            float f2;
            float f3;
            if (f < 0.36363637f) {
                return 7.5625f * f * f;
            }
            if (f < 0.72727275f) {
                float f4 = f - 0.54545456f;
                f2 = 7.5625f * f4 * f4;
                f3 = 0.75f;
            } else if (f < 0.90909094f) {
                float f5 = f - 0.8181818f;
                f2 = 7.5625f * f5 * f5;
                f3 = 0.9375f;
            } else {
                float f6 = f - 0.95454544f;
                f2 = 7.5625f * f6 * f6;
                f3 = 0.984375f;
            }
            return f2 + f3;
        }
    };

    @NotNull
    private static final Easing EaseInBounce = new Easing() { // from class: androidx.compose.animation.core.EasingFunctionsKt$EaseInBounce$1
        public final float transform(float f) {
            return 1 - EasingFunctionsKt.getEaseOutBounce().transform(1.0f - f);
        }
    };

    @NotNull
    private static final Easing EaseInOutBounce = EaseInOutBounce.1.INSTANCE;

    @NotNull
    public static final Easing getEase() {
        return Ease;
    }

    @NotNull
    public static final Easing getEaseIn() {
        return EaseIn;
    }

    @NotNull
    public static final Easing getEaseInBack() {
        return EaseInBack;
    }

    @NotNull
    public static final Easing getEaseInBounce() {
        return EaseInBounce;
    }

    @NotNull
    public static final Easing getEaseInCirc() {
        return EaseInCirc;
    }

    @NotNull
    public static final Easing getEaseInCubic() {
        return EaseInCubic;
    }

    @NotNull
    public static final Easing getEaseInElastic() {
        return EaseInElastic;
    }

    @NotNull
    public static final Easing getEaseInExpo() {
        return EaseInExpo;
    }

    @NotNull
    public static final Easing getEaseInOut() {
        return EaseInOut;
    }

    @NotNull
    public static final Easing getEaseInOutBack() {
        return EaseInOutBack;
    }

    @NotNull
    public static final Easing getEaseInOutBounce() {
        return EaseInOutBounce;
    }

    @NotNull
    public static final Easing getEaseInOutCirc() {
        return EaseInOutCirc;
    }

    @NotNull
    public static final Easing getEaseInOutCubic() {
        return EaseInOutCubic;
    }

    @NotNull
    public static final Easing getEaseInOutElastic() {
        return EaseInOutElastic;
    }

    @NotNull
    public static final Easing getEaseInOutExpo() {
        return EaseInOutExpo;
    }

    @NotNull
    public static final Easing getEaseInOutQuad() {
        return EaseInOutQuad;
    }

    @NotNull
    public static final Easing getEaseInOutQuart() {
        return EaseInOutQuart;
    }

    @NotNull
    public static final Easing getEaseInOutQuint() {
        return EaseInOutQuint;
    }

    @NotNull
    public static final Easing getEaseInOutSine() {
        return EaseInOutSine;
    }

    @NotNull
    public static final Easing getEaseInQuad() {
        return EaseInQuad;
    }

    @NotNull
    public static final Easing getEaseInQuart() {
        return EaseInQuart;
    }

    @NotNull
    public static final Easing getEaseInQuint() {
        return EaseInQuint;
    }

    @NotNull
    public static final Easing getEaseInSine() {
        return EaseInSine;
    }

    @NotNull
    public static final Easing getEaseOut() {
        return EaseOut;
    }

    @NotNull
    public static final Easing getEaseOutBack() {
        return EaseOutBack;
    }

    @NotNull
    public static final Easing getEaseOutBounce() {
        return EaseOutBounce;
    }

    @NotNull
    public static final Easing getEaseOutCirc() {
        return EaseOutCirc;
    }

    @NotNull
    public static final Easing getEaseOutCubic() {
        return EaseOutCubic;
    }

    @NotNull
    public static final Easing getEaseOutElastic() {
        return EaseOutElastic;
    }

    @NotNull
    public static final Easing getEaseOutExpo() {
        return EaseOutExpo;
    }

    @NotNull
    public static final Easing getEaseOutQuad() {
        return EaseOutQuad;
    }

    @NotNull
    public static final Easing getEaseOutQuart() {
        return EaseOutQuart;
    }

    @NotNull
    public static final Easing getEaseOutQuint() {
        return EaseOutQuint;
    }

    @NotNull
    public static final Easing getEaseOutSine() {
        return EaseOutSine;
    }
}
