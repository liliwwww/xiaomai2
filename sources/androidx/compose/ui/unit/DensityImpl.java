package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jw0;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DensityImpl implements Density {
    private final float density;
    private final float fontScale;

    public DensityImpl(float f, float f2) {
        this.density = f;
        this.fontScale = f2;
    }

    public static /* synthetic */ DensityImpl copy$default(DensityImpl densityImpl, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = densityImpl.getDensity();
        }
        if ((i & 2) != 0) {
            f2 = densityImpl.getFontScale();
        }
        return densityImpl.copy(f, f2);
    }

    public final float component1() {
        return getDensity();
    }

    public final float component2() {
        return getFontScale();
    }

    @NotNull
    public final DensityImpl copy(float f, float f2) {
        return new DensityImpl(f, f2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DensityImpl)) {
            return false;
        }
        DensityImpl densityImpl = (DensityImpl) obj;
        return Float.compare(getDensity(), densityImpl.getDensity()) == 0 && Float.compare(getFontScale(), densityImpl.getFontScale()) == 0;
    }

    public float getDensity() {
        return this.density;
    }

    public float getFontScale() {
        return this.fontScale;
    }

    public int hashCode() {
        return (Float.floatToIntBits(getDensity()) * 31) + Float.floatToIntBits(getFontScale());
    }

    /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public /* synthetic */ int m2569roundToPxR2X_6o(long j) {
        return jw0.a(this, j);
    }

    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public /* synthetic */ int m2570roundToPx0680j_4(float f) {
        return jw0.b(this, f);
    }

    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public /* synthetic */ float m2571toDpGaN1DYA(long j) {
        return jw0.c(this, j);
    }

    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public /* synthetic */ float m2572toDpu2uoSUM(float f) {
        return jw0.d(this, f);
    }

    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public /* synthetic */ float m2573toDpu2uoSUM(int i) {
        return jw0.e(this, i);
    }

    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public /* synthetic */ long m2574toDpSizekrfVVM(long j) {
        return jw0.f(this, j);
    }

    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public /* synthetic */ float m2575toPxR2X_6o(long j) {
        return jw0.g(this, j);
    }

    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public /* synthetic */ float m2576toPx0680j_4(float f) {
        return jw0.h(this, f);
    }

    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return jw0.i(this, dpRect);
    }

    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public /* synthetic */ long m2577toSizeXkaWNTQ(long j) {
        return jw0.j(this, j);
    }

    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public /* synthetic */ long m2578toSp0xMU5do(float f) {
        return jw0.k(this, f);
    }

    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public /* synthetic */ long m2579toSpkPz2Gy4(float f) {
        return jw0.l(this, f);
    }

    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public /* synthetic */ long m2580toSpkPz2Gy4(int i) {
        return jw0.m(this, i);
    }

    @NotNull
    public String toString() {
        return "DensityImpl(density=" + getDensity() + ", fontScale=" + getFontScale() + ')';
    }
}
