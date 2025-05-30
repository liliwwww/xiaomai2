package androidx.compose.animation.core;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VectorizedAnimationSpecKt$createSpringAnimations$2 implements Animations {

    @NotNull
    private final FloatSpringSpec anim;

    VectorizedAnimationSpecKt$createSpringAnimations$2(float f, float f2) {
        this.anim = new FloatSpringSpec(f, f2, 0.0f, 4, null);
    }

    @Override // androidx.compose.animation.core.Animations
    @NotNull
    public FloatSpringSpec get(int i) {
        return this.anim;
    }
}
