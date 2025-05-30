package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.runtime.Stable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: classes.dex */
public interface LazyLayoutMeasureScope extends MeasureScope {
    @NotNull
    /* renamed from: measure-0kLqBqw, reason: not valid java name */
    List<Placeable> mo1615measure0kLqBqw(int i, long j);

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toDp-GaN1DYA */
    float mo1278toDpGaN1DYA(long j);

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toDp-u2uoSUM */
    float mo1279toDpu2uoSUM(float f);

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toDp-u2uoSUM */
    float mo1280toDpu2uoSUM(int i);

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toDpSize-k-rfVVM */
    long mo1281toDpSizekrfVVM(long j);

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toSize-XkaWNTQ */
    long mo1284toSizeXkaWNTQ(long j);

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toSp-0xMU5do */
    long mo1285toSp0xMU5do(float f);

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    long mo1286toSpkPz2Gy4(float f);

    @Override // androidx.compose.p004ui.unit.Density
    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    long mo1287toSpkPz2Gy4(int i);
}
