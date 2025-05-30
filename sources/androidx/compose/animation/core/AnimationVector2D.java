package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AnimationVector2D extends AnimationVector {
    public static final int $stable = 8;
    private final int size;
    private float v1;
    private float v2;

    public AnimationVector2D(float f, float f2) {
        super(null);
        this.v1 = f;
        this.v2 = f2;
        this.size = 2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof AnimationVector2D) {
            AnimationVector2D animationVector2D = (AnimationVector2D) obj;
            if (animationVector2D.v1 == this.v1) {
                if (animationVector2D.v2 == this.v2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float get$animation_core_release(int i) {
        if (i == 0) {
            return this.v1;
        }
        if (i != 1) {
            return 0.0f;
        }
        return this.v2;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int getSize$animation_core_release() {
        return this.size;
    }

    public final float getV1() {
        return this.v1;
    }

    public final float getV2() {
        return this.v2;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.v1) * 31) + Float.floatToIntBits(this.v2);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void reset$animation_core_release() {
        this.v1 = 0.0f;
        this.v2 = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void set$animation_core_release(int i, float f) {
        if (i == 0) {
            this.v1 = f;
        } else {
            if (i != 1) {
                return;
            }
            this.v2 = f;
        }
    }

    public final void setV1$animation_core_release(float f) {
        this.v1 = f;
    }

    public final void setV2$animation_core_release(float f) {
        this.v2 = f;
    }

    @NotNull
    public String toString() {
        return "AnimationVector2D: v1 = " + this.v1 + ", v2 = " + this.v2;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    @NotNull
    public AnimationVector2D newVector$animation_core_release() {
        return new AnimationVector2D(0.0f, 0.0f);
    }
}
