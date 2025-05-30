package androidx.compose.animation.core;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class AnimationVector4D extends AnimationVector {
    public static final int $stable = 8;
    private final int size;

    /* renamed from: v1 */
    private float f70v1;

    /* renamed from: v2 */
    private float f71v2;

    /* renamed from: v3 */
    private float f72v3;

    /* renamed from: v4 */
    private float f73v4;

    public AnimationVector4D(float f, float f2, float f3, float f4) {
        super(null);
        this.f70v1 = f;
        this.f71v2 = f2;
        this.f72v3 = f3;
        this.f73v4 = f4;
        this.size = 4;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof AnimationVector4D) {
            AnimationVector4D animationVector4D = (AnimationVector4D) obj;
            if (animationVector4D.f70v1 == this.f70v1) {
                if (animationVector4D.f71v2 == this.f71v2) {
                    if (animationVector4D.f72v3 == this.f72v3) {
                        if (animationVector4D.f73v4 == this.f73v4) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float get$animation_core_release(int i) {
        if (i == 0) {
            return this.f70v1;
        }
        if (i == 1) {
            return this.f71v2;
        }
        if (i == 2) {
            return this.f72v3;
        }
        if (i != 3) {
            return 0.0f;
        }
        return this.f73v4;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int getSize$animation_core_release() {
        return this.size;
    }

    public final float getV1() {
        return this.f70v1;
    }

    public final float getV2() {
        return this.f71v2;
    }

    public final float getV3() {
        return this.f72v3;
    }

    public final float getV4() {
        return this.f73v4;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f70v1) * 31) + Float.floatToIntBits(this.f71v2)) * 31) + Float.floatToIntBits(this.f72v3)) * 31) + Float.floatToIntBits(this.f73v4);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void reset$animation_core_release() {
        this.f70v1 = 0.0f;
        this.f71v2 = 0.0f;
        this.f72v3 = 0.0f;
        this.f73v4 = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void set$animation_core_release(int i, float f) {
        if (i == 0) {
            this.f70v1 = f;
            return;
        }
        if (i == 1) {
            this.f71v2 = f;
        } else if (i == 2) {
            this.f72v3 = f;
        } else {
            if (i != 3) {
                return;
            }
            this.f73v4 = f;
        }
    }

    public final void setV1$animation_core_release(float f) {
        this.f70v1 = f;
    }

    public final void setV2$animation_core_release(float f) {
        this.f71v2 = f;
    }

    public final void setV3$animation_core_release(float f) {
        this.f72v3 = f;
    }

    public final void setV4$animation_core_release(float f) {
        this.f73v4 = f;
    }

    @NotNull
    public String toString() {
        return "AnimationVector4D: v1 = " + this.f70v1 + ", v2 = " + this.f71v2 + ", v3 = " + this.f72v3 + ", v4 = " + this.f73v4;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    @NotNull
    public AnimationVector4D newVector$animation_core_release() {
        return new AnimationVector4D(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
