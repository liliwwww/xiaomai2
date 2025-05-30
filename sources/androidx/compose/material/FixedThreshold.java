package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
@ExperimentalMaterialApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FixedThreshold implements ThresholdConfig {
    private final float offset;

    private FixedThreshold(float f) {
        this.offset = f;
    }

    public /* synthetic */ FixedThreshold(float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(f);
    }

    /* renamed from: component1-D9Ej5fM, reason: not valid java name */
    private final float m596component1D9Ej5fM() {
        return this.offset;
    }

    /* renamed from: copy-0680j_4$default, reason: not valid java name */
    public static /* synthetic */ FixedThreshold m597copy0680j_4$default(FixedThreshold fixedThreshold, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = fixedThreshold.offset;
        }
        return fixedThreshold.m598copy0680j_4(f);
    }

    public float computeThreshold(@NotNull Density density, float f, float f2) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return f + (density.mo321toPx0680j_4(this.offset) * Math.signum(f2 - f));
    }

    @NotNull
    /* renamed from: copy-0680j_4, reason: not valid java name */
    public final FixedThreshold m598copy0680j_4(float f) {
        return new FixedThreshold(f, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FixedThreshold) && Dp.m2147equalsimpl0(this.offset, ((FixedThreshold) obj).offset);
    }

    public int hashCode() {
        return Dp.m2148hashCodeimpl(this.offset);
    }

    @NotNull
    public String toString() {
        return "FixedThreshold(offset=" + ((Object) Dp.m2153toStringimpl(this.offset)) + ')';
    }
}
