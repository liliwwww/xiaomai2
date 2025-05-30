package androidx.compose.material.ripple;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes2.dex */
public final class RippleAlpha {
    private final float draggedAlpha;
    private final float focusedAlpha;
    private final float hoveredAlpha;
    private final float pressedAlpha;

    public RippleAlpha(float f, float f2, float f3, float f4) {
        this.draggedAlpha = f;
        this.focusedAlpha = f2;
        this.hoveredAlpha = f3;
        this.pressedAlpha = f4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleAlpha)) {
            return false;
        }
        RippleAlpha rippleAlpha = (RippleAlpha) obj;
        if (!(this.draggedAlpha == rippleAlpha.draggedAlpha)) {
            return false;
        }
        if (!(this.focusedAlpha == rippleAlpha.focusedAlpha)) {
            return false;
        }
        if (this.hoveredAlpha == rippleAlpha.hoveredAlpha) {
            return (this.pressedAlpha > rippleAlpha.pressedAlpha ? 1 : (this.pressedAlpha == rippleAlpha.pressedAlpha ? 0 : -1)) == 0;
        }
        return false;
    }

    public final float getDraggedAlpha() {
        return this.draggedAlpha;
    }

    public final float getFocusedAlpha() {
        return this.focusedAlpha;
    }

    public final float getHoveredAlpha() {
        return this.hoveredAlpha;
    }

    public final float getPressedAlpha() {
        return this.pressedAlpha;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.draggedAlpha) * 31) + Float.floatToIntBits(this.focusedAlpha)) * 31) + Float.floatToIntBits(this.hoveredAlpha)) * 31) + Float.floatToIntBits(this.pressedAlpha);
    }

    @NotNull
    public String toString() {
        return "RippleAlpha(draggedAlpha=" + this.draggedAlpha + ", focusedAlpha=" + this.focusedAlpha + ", hoveredAlpha=" + this.hoveredAlpha + ", pressedAlpha=" + this.pressedAlpha + ')';
    }
}
