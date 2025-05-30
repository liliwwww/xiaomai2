package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LinearGradient extends ShaderBrush {

    @NotNull
    private final List<Color> colors;
    private final long end;
    private final long start;

    @Nullable
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? null : list2, j, j2, (i2 & 16) != 0 ? TileMode.Companion.m1258getClamp3opZhB0() : i, null);
    }

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, j2, i);
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    @NotNull
    /* renamed from: createShader-uvyYCjk */
    public Shader mo1027createShaderuvyYCjk(long j) {
        return ShaderKt.m1219LinearGradientShaderVjE6UOU(OffsetKt.Offset((Offset.m848getXimpl(this.start) > Float.POSITIVE_INFINITY ? 1 : (Offset.m848getXimpl(this.start) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m903getWidthimpl(j) : Offset.m848getXimpl(this.start), (Offset.m849getYimpl(this.start) > Float.POSITIVE_INFINITY ? 1 : (Offset.m849getYimpl(this.start) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m900getHeightimpl(j) : Offset.m849getYimpl(this.start)), OffsetKt.Offset((Offset.m848getXimpl(this.end) > Float.POSITIVE_INFINITY ? 1 : (Offset.m848getXimpl(this.end) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m903getWidthimpl(j) : Offset.m848getXimpl(this.end), Offset.m849getYimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m900getHeightimpl(j) : Offset.m849getYimpl(this.end)), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LinearGradient)) {
            return false;
        }
        LinearGradient linearGradient = (LinearGradient) obj;
        return Intrinsics.areEqual(this.colors, linearGradient.colors) && Intrinsics.areEqual(this.stops, linearGradient.stops) && Offset.m845equalsimpl0(this.start, linearGradient.start) && Offset.m845equalsimpl0(this.end, linearGradient.end) && TileMode.equals-impl0(this.tileMode, linearGradient.tileMode);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long m1150getIntrinsicSizeNHjbRc() {
        /*
            r6 = this;
            long r0 = r6.start
            float r0 = androidx.compose.ui.geometry.Offset.m848getXimpl(r0)
            boolean r1 = java.lang.Float.isInfinite(r0)
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L16
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L16
            r0 = 1
            goto L17
        L16:
            r0 = 0
        L17:
            r1 = 2143289344(0x7fc00000, float:NaN)
            if (r0 == 0) goto L44
            long r4 = r6.end
            float r0 = androidx.compose.ui.geometry.Offset.m848getXimpl(r4)
            boolean r4 = java.lang.Float.isInfinite(r0)
            if (r4 != 0) goto L2f
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L2f
            r0 = 1
            goto L30
        L2f:
            r0 = 0
        L30:
            if (r0 == 0) goto L44
            long r4 = r6.start
            float r0 = androidx.compose.ui.geometry.Offset.m848getXimpl(r4)
            long r4 = r6.end
            float r4 = androidx.compose.ui.geometry.Offset.m848getXimpl(r4)
            float r0 = r0 - r4
            float r0 = java.lang.Math.abs(r0)
            goto L46
        L44:
            r0 = 2143289344(0x7fc00000, float:NaN)
        L46:
            long r4 = r6.start
            float r4 = androidx.compose.ui.geometry.Offset.m849getYimpl(r4)
            boolean r5 = java.lang.Float.isInfinite(r4)
            if (r5 != 0) goto L5a
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L5a
            r4 = 1
            goto L5b
        L5a:
            r4 = 0
        L5b:
            if (r4 == 0) goto L84
            long r4 = r6.end
            float r4 = androidx.compose.ui.geometry.Offset.m849getYimpl(r4)
            boolean r5 = java.lang.Float.isInfinite(r4)
            if (r5 != 0) goto L70
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L70
            goto L71
        L70:
            r2 = 0
        L71:
            if (r2 == 0) goto L84
            long r1 = r6.start
            float r1 = androidx.compose.ui.geometry.Offset.m849getYimpl(r1)
            long r2 = r6.end
            float r2 = androidx.compose.ui.geometry.Offset.m849getYimpl(r2)
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
        L84:
            long r0 = androidx.compose.ui.geometry.SizeKt.Size(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.LinearGradient.m1150getIntrinsicSizeNHjbRc():long");
    }

    public int hashCode() {
        int hashCode = this.colors.hashCode() * 31;
        List<Float> list = this.stops;
        return ((((((hashCode + (list != null ? list.hashCode() : 0)) * 31) + Offset.m850hashCodeimpl(this.start)) * 31) + Offset.m850hashCodeimpl(this.end)) * 31) + TileMode.hashCode-impl(this.tileMode);
    }

    @NotNull
    public String toString() {
        String str;
        String str2 = "";
        if (OffsetKt.isFinite-k-4lQ0M(this.start)) {
            str = "start=" + ((Object) Offset.m856toStringimpl(this.start)) + ", ";
        } else {
            str = "";
        }
        if (OffsetKt.isFinite-k-4lQ0M(this.end)) {
            str2 = "end=" + ((Object) Offset.m856toStringimpl(this.end)) + ", ";
        }
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + str + str2 + "tileMode=" + ((Object) TileMode.toString-impl(this.tileMode)) + ')';
    }

    private LinearGradient(List<Color> list, List<Float> list2, long j, long j2, int i) {
        this.colors = list;
        this.stops = list2;
        this.start = j;
        this.end = j2;
        this.tileMode = i;
    }
}
