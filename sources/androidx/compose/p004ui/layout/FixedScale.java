package androidx.compose.p004ui.layout;

import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes2.dex */
public final class FixedScale implements ContentScale {
    private final float value;

    public FixedScale(float f) {
        this.value = f;
    }

    public static /* synthetic */ FixedScale copy$default(FixedScale fixedScale, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = fixedScale.value;
        }
        return fixedScale.copy(f);
    }

    public final float component1() {
        return this.value;
    }

    @Override // androidx.compose.p004ui.layout.ContentScale
    /* renamed from: computeScaleFactor-H7hwNQA */
    public long mo4178computeScaleFactorH7hwNQA(long j, long j2) {
        float f = this.value;
        return ScaleFactorKt.ScaleFactor(f, f);
    }

    @NotNull
    public final FixedScale copy(float f) {
        return new FixedScale(f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FixedScale) && Float.compare(this.value, ((FixedScale) obj).value) == 0;
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    @NotNull
    public String toString() {
        return "FixedScale(value=" + this.value + ')';
    }
}
