package androidx.compose.foundation.shape;

import androidx.compose.p004ui.platform.InspectableValue;
import androidx.compose.p004ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import tb.h82;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class CornerSizeKt$ZeroCornerSize$1 implements CornerSize, InspectableValue {
    CornerSizeKt$ZeroCornerSize$1() {
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
    @NotNull
    public String getValueOverride() {
        return "ZeroCornerSize";
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* renamed from: toPx-TmRCtEA */
    public float mo1685toPxTmRCtEA(long j, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return 0.0f;
    }

    @NotNull
    public String toString() {
        return "ZeroCornerSize";
    }
}
