package androidx.compose.foundation.shape;

import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.h82;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DpCornerSize implements CornerSize, InspectableValue {
    private final float size;

    private DpCornerSize(float f) {
        this.size = f;
    }

    public /* synthetic */ DpCornerSize(float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(f);
    }

    /* renamed from: component1-D9Ej5fM, reason: not valid java name */
    private final float m538component1D9Ej5fM() {
        return this.size;
    }

    /* renamed from: copy-0680j_4$default, reason: not valid java name */
    public static /* synthetic */ DpCornerSize m539copy0680j_4$default(DpCornerSize dpCornerSize, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = dpCornerSize.size;
        }
        return dpCornerSize.m540copy0680j_4(f);
    }

    @NotNull
    /* renamed from: copy-0680j_4, reason: not valid java name */
    public final DpCornerSize m540copy0680j_4(float f) {
        return new DpCornerSize(f, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DpCornerSize) && Dp.equals-impl0(this.size, ((DpCornerSize) obj).size);
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public /* synthetic */ Sequence getInspectableElements() {
        return h82.a(this);
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public /* synthetic */ String getNameFallback() {
        return h82.b(this);
    }

    @Override // androidx.compose.ui.platform.InspectableValue
    public /* bridge */ /* synthetic */ Object getValueOverride() {
        return Dp.box-impl(m541getValueOverrideD9Ej5fM());
    }

    /* renamed from: getValueOverride-D9Ej5fM, reason: not valid java name */
    public float m541getValueOverrideD9Ej5fM() {
        return this.size;
    }

    public int hashCode() {
        return Dp.hashCode-impl(this.size);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* renamed from: toPx-TmRCtEA */
    public float mo536toPxTmRCtEA(long j, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return density.toPx-0680j_4(this.size);
    }

    @NotNull
    public String toString() {
        return "CornerSize(size = " + this.size + ".dp)";
    }
}
