package androidx.compose.foundation.shape;

import androidx.compose.p004ui.platform.InspectableValue;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Density;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.h82;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class DpCornerSize implements CornerSize, InspectableValue {
    private final float size;

    private DpCornerSize(float f) {
        this.size = f;
    }

    public /* synthetic */ DpCornerSize(float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(f);
    }

    /* renamed from: component1-D9Ej5fM, reason: not valid java name */
    private final float m1690component1D9Ej5fM() {
        return this.size;
    }

    /* renamed from: copy-0680j_4$default, reason: not valid java name */
    public static /* synthetic */ DpCornerSize m1691copy0680j_4$default(DpCornerSize dpCornerSize, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = dpCornerSize.size;
        }
        return dpCornerSize.m1692copy0680j_4(f);
    }

    @NotNull
    /* renamed from: copy-0680j_4, reason: not valid java name */
    public final DpCornerSize m1692copy0680j_4(float f) {
        return new DpCornerSize(f, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DpCornerSize) && C0856Dp.m5221equalsimpl0(this.size, ((DpCornerSize) obj).size);
    }

    @Override // androidx.compose.p004ui.platform.InspectableValue
    public /* synthetic */ Sequence getInspectableElements() {
        return h82.a(this);
    }

    @Override // androidx.compose.p004ui.platform.InspectableValue
    public /* synthetic */ String getNameFallback() {
        return h82.b(this);
    }

    @Override // androidx.compose.p004ui.platform.InspectableValue
    public /* bridge */ /* synthetic */ Object getValueOverride() {
        return C0856Dp.m5214boximpl(m1693getValueOverrideD9Ej5fM());
    }

    /* renamed from: getValueOverride-D9Ej5fM, reason: not valid java name */
    public float m1693getValueOverrideD9Ej5fM() {
        return this.size;
    }

    public int hashCode() {
        return C0856Dp.m5222hashCodeimpl(this.size);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* renamed from: toPx-TmRCtEA */
    public float mo1685toPxTmRCtEA(long j, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return density.mo1283toPx0680j_4(this.size);
    }

    @NotNull
    public String toString() {
        return "CornerSize(size = " + this.size + ".dp)";
    }
}
