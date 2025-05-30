package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.layout.AlignmentLine;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.layout.SubcomposeMeasureScope;
import androidx.compose.p004ui.unit.DpRect;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Stable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: classes.dex */
public final class LazyLayoutMeasureScopeImpl implements LazyLayoutMeasureScope, MeasureScope {

    @NotNull
    private final LazyLayoutItemContentFactory itemContentFactory;

    @NotNull
    private final HashMap<Integer, List<Placeable>> placeablesCache;

    @NotNull
    private final SubcomposeMeasureScope subcomposeMeasureScope;

    public LazyLayoutMeasureScopeImpl(@NotNull LazyLayoutItemContentFactory lazyLayoutItemContentFactory, @NotNull SubcomposeMeasureScope subcomposeMeasureScope) {
        Intrinsics.checkNotNullParameter(lazyLayoutItemContentFactory, "itemContentFactory");
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "subcomposeMeasureScope");
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.subcomposeMeasureScope = subcomposeMeasureScope;
        this.placeablesCache = new HashMap<>();
    }

    @Override // androidx.compose.p004ui.unit.Density
    public float getDensity() {
        return this.subcomposeMeasureScope.getDensity();
    }

    @Override // androidx.compose.p004ui.unit.Density
    public float getFontScale() {
        return this.subcomposeMeasureScope.getFontScale();
    }

    @Override // androidx.compose.p004ui.layout.IntrinsicMeasureScope
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.subcomposeMeasureScope.getLayoutDirection();
    }

    @Override // androidx.compose.p004ui.layout.MeasureScope
    @NotNull
    public MeasureResult layout(int i, int i2, @NotNull Map<AlignmentLine, Integer> map, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(map, "alignmentLines");
        Intrinsics.checkNotNullParameter(function1, "placementBlock");
        return this.subcomposeMeasureScope.layout(i, i2, map, function1);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    @NotNull
    /* renamed from: measure-0kLqBqw */
    public List<Placeable> mo1615measure0kLqBqw(int i, long j) {
        List<Placeable> list = this.placeablesCache.get(Integer.valueOf(i));
        if (list != null) {
            return list;
        }
        Object key = ((LazyLayoutItemProvider) this.itemContentFactory.getItemProvider().invoke()).getKey(i);
        List<Measurable> subcompose = this.subcomposeMeasureScope.subcompose(key, this.itemContentFactory.getContent(i, key));
        int size = subcompose.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(subcompose.get(i2).mo4187measureBRTryo0(j));
        }
        this.placeablesCache.put(Integer.valueOf(i), arrayList);
        return arrayList;
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: roundToPx--R2X_6o */
    public int mo1276roundToPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.mo1276roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: roundToPx-0680j_4 */
    public int mo1277roundToPx0680j_4(float f) {
        return this.subcomposeMeasureScope.mo1277roundToPx0680j_4(f);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-GaN1DYA */
    public float mo1278toDpGaN1DYA(long j) {
        return this.subcomposeMeasureScope.mo1278toDpGaN1DYA(j);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo1280toDpu2uoSUM(int i) {
        return this.subcomposeMeasureScope.mo1280toDpu2uoSUM(i);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p004ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public long mo1281toDpSizekrfVVM(long j) {
        return this.subcomposeMeasureScope.mo1281toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toPx--R2X_6o */
    public float mo1282toPxR2X_6o(long j) {
        return this.subcomposeMeasureScope.mo1282toPxR2X_6o(j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toPx-0680j_4 */
    public float mo1283toPx0680j_4(float f) {
        return this.subcomposeMeasureScope.mo1283toPx0680j_4(f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    @NotNull
    public Rect toRect(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.subcomposeMeasureScope.toRect(dpRect);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p004ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public long mo1284toSizeXkaWNTQ(long j) {
        return this.subcomposeMeasureScope.mo1284toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-0xMU5do */
    public long mo1285toSp0xMU5do(float f) {
        return this.subcomposeMeasureScope.mo1285toSp0xMU5do(f);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo1286toSpkPz2Gy4(float f) {
        return this.subcomposeMeasureScope.mo1286toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo1279toDpu2uoSUM(float f) {
        return this.subcomposeMeasureScope.mo1279toDpu2uoSUM(f);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo1287toSpkPz2Gy4(int i) {
        return this.subcomposeMeasureScope.mo1287toSpkPz2Gy4(i);
    }
}
