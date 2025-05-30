package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class AnimationVector2D extends AnimationVector {
    public static final int $stable = 8;
    private final int size;

    /* renamed from: v1 */
    private float f65v1;

    /* renamed from: v2 */
    private float f66v2;

    public AnimationVector2D(float f, float f2) {
        super(null);
        this.f65v1 = f;
        this.f66v2 = f2;
        this.size = 2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof AnimationVector2D) {
            AnimationVector2D animationVector2D = (AnimationVector2D) obj;
            if (animationVector2D.f65v1 == this.f65v1) {
                if (animationVector2D.f66v2 == this.f66v2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float get$animation_core_release(int i) {
        if (i == 0) {
            return this.f65v1;
        }
        if (i != 1) {
            return 0.0f;
        }
        return this.f66v2;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int getSize$animation_core_release() {
        return this.size;
    }

    public final float getV1() {
        return this.f65v1;
    }

    public final float getV2() {
        return this.f66v2;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f65v1) * 31) + Float.floatToIntBits(this.f66v2);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void reset$animation_core_release() {
        this.f65v1 = 0.0f;
        this.f66v2 = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void set$animation_core_release(int i, float f) {
        if (i == 0) {
            this.f65v1 = f;
        } else {
            if (i != 1) {
                return;
            }
            this.f66v2 = f;
        }
    }

    public final void setV1$animation_core_release(float f) {
        this.f65v1 = f;
    }

    public final void setV2$animation_core_release(float f) {
        this.f66v2 = f;
    }

    @NotNull
    public String toString() {
        return "AnimationVector2D: v1 = " + this.f65v1 + ", v2 = " + this.f66v2;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    @NotNull
    public AnimationVector2D newVector$animation_core_release() {
        return new AnimationVector2D(0.0f, 0.0f);
    }
}
