package androidx.compose.ui;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.Alignment;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BiasAlignment$Vertical implements Alignment.Vertical {
    private final float bias;

    public BiasAlignment$Vertical(float f) {
        this.bias = f;
    }

    private final float component1() {
        return this.bias;
    }

    public static /* synthetic */ BiasAlignment$Vertical copy$default(BiasAlignment$Vertical biasAlignment$Vertical, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = biasAlignment$Vertical.bias;
        }
        return biasAlignment$Vertical.copy(f);
    }

    public int align(int i, int i2) {
        return MathKt.roundToInt(((i2 - i) / 2.0f) * (1 + this.bias));
    }

    @NotNull
    public final BiasAlignment$Vertical copy(float f) {
        return new BiasAlignment$Vertical(f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BiasAlignment$Vertical) && Float.compare(this.bias, ((BiasAlignment$Vertical) obj).bias) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.bias);
    }

    @NotNull
    public String toString() {
        return "Vertical(bias=" + this.bias + ')';
    }
}
