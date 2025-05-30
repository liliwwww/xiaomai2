package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ResistanceConfig {
    private final float basis;
    private final float factorAtMax;
    private final float factorAtMin;

    public ResistanceConfig(float f, float f2, float f3) {
        this.basis = f;
        this.factorAtMin = f2;
        this.factorAtMax = f3;
    }

    public final float computeResistance(float f) {
        float f2 = f < 0.0f ? this.factorAtMin : this.factorAtMax;
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return (this.basis / f2) * ((float) Math.sin((RangesKt.coerceIn(f / this.basis, -1.0f, 1.0f) * 3.1415927f) / 2));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResistanceConfig)) {
            return false;
        }
        ResistanceConfig resistanceConfig = (ResistanceConfig) obj;
        if (!(this.basis == resistanceConfig.basis)) {
            return false;
        }
        if (this.factorAtMin == resistanceConfig.factorAtMin) {
            return (this.factorAtMax > resistanceConfig.factorAtMax ? 1 : (this.factorAtMax == resistanceConfig.factorAtMax ? 0 : -1)) == 0;
        }
        return false;
    }

    public final float getBasis() {
        return this.basis;
    }

    public final float getFactorAtMax() {
        return this.factorAtMax;
    }

    public final float getFactorAtMin() {
        return this.factorAtMin;
    }

    public int hashCode() {
        return (((Float.floatToIntBits(this.basis) * 31) + Float.floatToIntBits(this.factorAtMin)) * 31) + Float.floatToIntBits(this.factorAtMax);
    }

    @NotNull
    public String toString() {
        return "ResistanceConfig(basis=" + this.basis + ", factorAtMin=" + this.factorAtMin + ", factorAtMax=" + this.factorAtMax + ')';
    }

    public /* synthetic */ ResistanceConfig(float f, float f2, float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i & 2) != 0 ? 10.0f : f2, (i & 4) != 0 ? 10.0f : f3);
    }
}
