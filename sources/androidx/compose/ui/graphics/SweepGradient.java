package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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

    @NotNull
    /* renamed from: createShader-uvyYCjk, reason: not valid java name */
    public Shader m1214createShaderuvyYCjk(long j) {
        long Offset;
        if (OffsetKt.m1029isUnspecifiedk4lQ0M(this.center)) {
            Offset = SizeKt.getCenter-uvyYCjk(j);
        } else {
            Offset = OffsetKt.Offset((Offset.getX-impl(this.center) > Float.POSITIVE_INFINITY ? 1 : (Offset.getX-impl(this.center) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.getWidth-impl(j) : Offset.getX-impl(this.center), Offset.getY-impl(this.center) == Float.POSITIVE_INFINITY ? Size.getHeight-impl(j) : Offset.getY-impl(this.center));
        }
        return ShaderKt.SweepGradientShader-9KIMszo(Offset, this.colors, this.stops);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SweepGradient)) {
            return false;
        }
        SweepGradient sweepGradient = (SweepGradient) obj;
        return Offset.equals-impl0(this.center, sweepGradient.center) && Intrinsics.areEqual(this.colors, sweepGradient.colors) && Intrinsics.areEqual(this.stops, sweepGradient.stops);
    }

    public int hashCode() {
        int i = ((Offset.hashCode-impl(this.center) * 31) + this.colors.hashCode()) * 31;
        List<Float> list = this.stops;
        return i + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str;
        if (OffsetKt.m1027isSpecifiedk4lQ0M(this.center)) {
            str = "center=" + ((Object) Offset.toString-impl(this.center)) + ", ";
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
