package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DpRect {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    private DpRect(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    public /* synthetic */ DpRect(float f, float f2, float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4);
    }

    public /* synthetic */ DpRect(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    /* renamed from: copy-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ DpRect m2163copya9UjIt4$default(DpRect dpRect, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = dpRect.left;
        }
        if ((i & 2) != 0) {
            f2 = dpRect.top;
        }
        if ((i & 4) != 0) {
            f3 = dpRect.right;
        }
        if ((i & 8) != 0) {
            f4 = dpRect.bottom;
        }
        return dpRect.m2172copya9UjIt4(f, f2, f3, f4);
    }

    @Stable
    /* renamed from: getBottom-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2164getBottomD9Ej5fM$annotations() {
    }

    @Stable
    /* renamed from: getLeft-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2165getLeftD9Ej5fM$annotations() {
    }

    @Stable
    /* renamed from: getRight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2166getRightD9Ej5fM$annotations() {
    }

    @Stable
    /* renamed from: getTop-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2167getTopD9Ej5fM$annotations() {
    }

    /* renamed from: component1-D9Ej5fM, reason: not valid java name */
    public final float m2168component1D9Ej5fM() {
        return this.left;
    }

    /* renamed from: component2-D9Ej5fM, reason: not valid java name */
    public final float m2169component2D9Ej5fM() {
        return this.top;
    }

    /* renamed from: component3-D9Ej5fM, reason: not valid java name */
    public final float m2170component3D9Ej5fM() {
        return this.right;
    }

    /* renamed from: component4-D9Ej5fM, reason: not valid java name */
    public final float m2171component4D9Ej5fM() {
        return this.bottom;
    }

    @NotNull
    /* renamed from: copy-a9UjIt4, reason: not valid java name */
    public final DpRect m2172copya9UjIt4(float f, float f2, float f3, float f4) {
        return new DpRect(f, f2, f3, f4, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DpRect)) {
            return false;
        }
        DpRect dpRect = (DpRect) obj;
        return Dp.m2147equalsimpl0(this.left, dpRect.left) && Dp.m2147equalsimpl0(this.top, dpRect.top) && Dp.m2147equalsimpl0(this.right, dpRect.right) && Dp.m2147equalsimpl0(this.bottom, dpRect.bottom);
    }

    /* renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m2173getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* renamed from: getLeft-D9Ej5fM, reason: not valid java name */
    public final float m2174getLeftD9Ej5fM() {
        return this.left;
    }

    /* renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m2175getRightD9Ej5fM() {
        return this.right;
    }

    /* renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m2176getTopD9Ej5fM() {
        return this.top;
    }

    public int hashCode() {
        return (((((Dp.m2148hashCodeimpl(this.left) * 31) + Dp.m2148hashCodeimpl(this.top)) * 31) + Dp.m2148hashCodeimpl(this.right)) * 31) + Dp.m2148hashCodeimpl(this.bottom);
    }

    @NotNull
    public String toString() {
        return "DpRect(left=" + ((Object) Dp.m2153toStringimpl(this.left)) + ", top=" + ((Object) Dp.m2153toStringimpl(this.top)) + ", right=" + ((Object) Dp.m2153toStringimpl(this.right)) + ", bottom=" + ((Object) Dp.m2153toStringimpl(this.bottom)) + ')';
    }

    private DpRect(long j, long j2) {
        this(DpOffset.getX-D9Ej5fM(j), DpOffset.getY-D9Ej5fM(j), Dp.m2142constructorimpl(DpOffset.getX-D9Ej5fM(j) + DpSize.m2189getWidthD9Ej5fM(j2)), Dp.m2142constructorimpl(DpOffset.getY-D9Ej5fM(j) + DpSize.m2187getHeightD9Ej5fM(j2)), null);
    }
}
