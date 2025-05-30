package androidx.compose.p004ui.unit;

import androidx.compose.p004ui.geometry.Rect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jw0;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
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

    @Override // androidx.compose.p004ui.unit.Density
    public float getDensity() {
        return this.density;
    }

    @Override // androidx.compose.p004ui.unit.Density
    public float getFontScale() {
        return this.fontScale;
    }

    public int hashCode() {
        return (Float.floatToIntBits(getDensity()) * 31) + Float.floatToIntBits(getFontScale());
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo1276roundToPxR2X_6o(long j) {
        return jw0.a(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo1277roundToPx0680j_4(float f) {
        return jw0.b(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo1278toDpGaN1DYA(long j) {
        return jw0.c(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo1279toDpu2uoSUM(float f) {
        return jw0.d(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo1280toDpu2uoSUM(int i) {
        return jw0.e(this, i);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo1281toDpSizekrfVVM(long j) {
        return jw0.f(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo1282toPxR2X_6o(long j) {
        return jw0.g(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo1283toPx0680j_4(float f) {
        return jw0.h(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return jw0.i(this, dpRect);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo1284toSizeXkaWNTQ(long j) {
        return jw0.j(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo1285toSp0xMU5do(float f) {
        return jw0.k(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo1286toSpkPz2Gy4(float f) {
        return jw0.l(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo1287toSpkPz2Gy4(int i) {
        return jw0.m(this, i);
    }

    @NotNull
    public String toString() {
        return "DensityImpl(density=" + getDensity() + ", fontScale=" + getFontScale() + ')';
    }
}
