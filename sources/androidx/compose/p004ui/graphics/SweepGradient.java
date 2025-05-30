package androidx.compose.p004ui.graphics;

import android.graphics.Shader;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.runtime.Immutable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes2.dex */
public final class SweepGradient extends ShaderBrush {
    private final long center;

    @NotNull
    private final List<Color> colors;

    @Nullable
    private final List<Float> stops;

    public /* synthetic */ SweepGradient(long j, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, list, (i & 4) != 0 ? null : list2, null);
    }

    public /* synthetic */ SweepGradient(long j, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, list, list2);
    }

    @Override // androidx.compose.p004ui.graphics.ShaderBrush
    @NotNull
    /* renamed from: createShader-uvyYCjk */
    public Shader mo2762createShaderuvyYCjk(long j) {
        long Offset;
        if (OffsetKt.m2577isUnspecifiedk4lQ0M(this.center)) {
            Offset = SizeKt.m2635getCenteruvyYCjk(j);
        } else {
            Offset = OffsetKt.Offset((Offset.m2556getXimpl(this.center) > Float.POSITIVE_INFINITY ? 1 : (Offset.m2556getXimpl(this.center) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m2625getWidthimpl(j) : Offset.m2556getXimpl(this.center), Offset.m2557getYimpl(this.center) == Float.POSITIVE_INFINITY ? Size.m2622getHeightimpl(j) : Offset.m2557getYimpl(this.center));
        }
        return ShaderKt.m3066SweepGradientShader9KIMszo(Offset, this.colors, this.stops);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SweepGradient)) {
            return false;
        }
        SweepGradient sweepGradient = (SweepGradient) obj;
        return Offset.m2553equalsimpl0(this.center, sweepGradient.center) && Intrinsics.areEqual(this.colors, sweepGradient.colors) && Intrinsics.areEqual(this.stops, sweepGradient.stops);
    }

    public int hashCode() {
        int m2558hashCodeimpl = ((Offset.m2558hashCodeimpl(this.center) * 31) + this.colors.hashCode()) * 31;
        List<Float> list = this.stops;
        return m2558hashCodeimpl + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str;
        if (OffsetKt.m2575isSpecifiedk4lQ0M(this.center)) {
            str = "center=" + ((Object) Offset.m2564toStringimpl(this.center)) + ", ";
        } else {
            str = "";
        }
        return "SweepGradient(" + str + "colors=" + this.colors + ", stops=" + this.stops + ')';
    }

    private SweepGradient(long j, List<Color> list, List<Float> list2) {
        this.center = j;
        this.colors = list;
        this.stops = list2;
    }
}
