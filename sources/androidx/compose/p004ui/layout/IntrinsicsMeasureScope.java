package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DpRect;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class IntrinsicsMeasureScope implements MeasureScope, Density {
    private final /* synthetic */ Density $$delegate_0;

    @NotNull
    private final LayoutDirection layoutDirection;

    public IntrinsicsMeasureScope(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.layoutDirection = layoutDirection;
        this.$$delegate_0 = density;
    }

    @Override // androidx.compose.p004ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.p004ui.unit.Density
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.p004ui.layout.IntrinsicMeasureScope
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    @Override // androidx.compose.p004ui.layout.MeasureScope
    public /* synthetic */ MeasureResult layout(int i, int i2, Map map, Function1 function1) {
        return MeasureScope.CC.m125a(this, i, i2, map, function1);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: roundToPx--R2X_6o */
    public int mo1276roundToPxR2X_6o(long j) {
        return this.$$delegate_0.mo1276roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: roundToPx-0680j_4 */
    public int mo1277roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo1277roundToPx0680j_4(f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toDp-GaN1DYA */
    public float mo1278toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo1278toDpGaN1DYA(j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toDp-u2uoSUM */
    public float mo1279toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo1279toDpu2uoSUM(f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toDp-u2uoSUM */
    public float mo1280toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo1280toDpu2uoSUM(i);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toDpSize-k-rfVVM */
    public long mo1281toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo1281toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toPx--R2X_6o */
    public float mo1282toPxR2X_6o(long j) {
        return this.$$delegate_0.mo1282toPxR2X_6o(j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toPx-0680j_4 */
    public float mo1283toPx0680j_4(float f) {
        return this.$$delegate_0.mo1283toPx0680j_4(f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    @NotNull
    public Rect toRect(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toSize-XkaWNTQ */
    public long mo1284toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo1284toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toSp-0xMU5do */
    public long mo1285toSp0xMU5do(float f) {
        return this.$$delegate_0.mo1285toSp0xMU5do(f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    public long mo1286toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo1286toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    public long mo1287toSpkPz2Gy4(int i) {
        return this.$$delegate_0.mo1287toSpkPz2Gy4(i);
    }
}
