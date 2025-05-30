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
/* loaded from: classes.dex */
public final class RadialGradient extends ShaderBrush {
    private final long center;

    @NotNull
    private final List<Color> colors;
    private final float radius;

    @Nullable
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ RadialGradient(List list, List list2, long j, float f, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? null : list2, j, f, (i2 & 16) != 0 ? TileMode.Companion.m3112getClamp3opZhB0() : i, null);
    }

    public /* synthetic */ RadialGradient(List list, List list2, long j, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, f, i);
    }

    @Override // androidx.compose.p004ui.graphics.ShaderBrush
    @NotNull
    /* renamed from: createShader-uvyYCjk */
    public Shader mo2762createShaderuvyYCjk(long j) {
        float m2625getWidthimpl;
        float m2622getHeightimpl;
        if (OffsetKt.m2577isUnspecifiedk4lQ0M(this.center)) {
            long m2635getCenteruvyYCjk = SizeKt.m2635getCenteruvyYCjk(j);
            m2625getWidthimpl = Offset.m2556getXimpl(m2635getCenteruvyYCjk);
            m2622getHeightimpl = Offset.m2557getYimpl(m2635getCenteruvyYCjk);
        } else {
            m2625getWidthimpl = (Offset.m2556getXimpl(this.center) > Float.POSITIVE_INFINITY ? 1 : (Offset.m2556getXimpl(this.center) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m2625getWidthimpl(j) : Offset.m2556getXimpl(this.center);
            m2622getHeightimpl = (Offset.m2557getYimpl(this.center) > Float.POSITIVE_INFINITY ? 1 : (Offset.m2557getYimpl(this.center) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m2622getHeightimpl(j) : Offset.m2557getYimpl(this.center);
        }
        List<Color> list = this.colors;
        List<Float> list2 = this.stops;
        long Offset = OffsetKt.Offset(m2625getWidthimpl, m2622getHeightimpl);
        float f = this.radius;
        return ShaderKt.m3064RadialGradientShader8uybcMk(Offset, f == Float.POSITIVE_INFINITY ? Size.m2624getMinDimensionimpl(j) / 2 : f, list, list2, this.tileMode);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RadialGradient)) {
            return false;
        }
        RadialGradient radialGradient = (RadialGradient) obj;
        if (Intrinsics.areEqual(this.colors, radialGradient.colors) && Intrinsics.areEqual(this.stops, radialGradient.stops) && Offset.m2553equalsimpl0(this.center, radialGradient.center)) {
            return ((this.radius > radialGradient.radius ? 1 : (this.radius == radialGradient.radius ? 0 : -1)) == 0) && TileMode.m3108equalsimpl0(this.tileMode, radialGradient.tileMode);
        }
        return false;
    }

    @Override // androidx.compose.p004ui.graphics.Brush
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public long mo2741getIntrinsicSizeNHjbRc() {
        float f = this.radius;
        if (!((Float.isInfinite(f) || Float.isNaN(f)) ? false : true)) {
            return Size.Companion.m2633getUnspecifiedNHjbRc();
        }
        float f2 = this.radius;
        float f3 = 2;
        return SizeKt.Size(f2 * f3, f2 * f3);
    }

    public int hashCode() {
        int hashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((((((hashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.m2558hashCodeimpl(this.center)) * 31) + Float.floatToIntBits(this.radius)) * 31) + TileMode.m3109hashCodeimpl(this.tileMode);
    }

    @NotNull
    public String toString() {
        String str;
        String str2 = "";
        if (OffsetKt.m2575isSpecifiedk4lQ0M(this.center)) {
            str = "center=" + ((Object) Offset.m2564toStringimpl(this.center)) + ", ";
        } else {
            str = "";
        }
        float f = this.radius;
        if ((Float.isInfinite(f) || Float.isNaN(f)) ? false : true) {
            str2 = "radius=" + this.radius + ", ";
        }
        return "RadialGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + str + str2 + "tileMode=" + ((Object) TileMode.m3110toStringimpl(this.tileMode)) + ')';
    }

    private RadialGradient(List<Color> list, List<Float> list2, long j, float f, int i) {
        this.colors = list;
        this.stops = list2;
        this.center = j;
        this.radius = f;
        this.tileMode = i;
    }
}
