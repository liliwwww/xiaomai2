package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface LazyLayoutMeasureScope extends MeasureScope {
    @NotNull
    /* renamed from: measure-0kLqBqw, reason: not valid java name */
    List<Placeable> mo309measure0kLqBqw(int i, long j);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    float mo310toDpGaN1DYA(long j);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    float mo311toDpu2uoSUM(float f);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    float mo312toDpu2uoSUM(int i);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    long mo313toDpSizekrfVVM(long j);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    long mo314toSizeXkaWNTQ(long j);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    long mo315toSp0xMU5do(float f);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    long mo316toSpkPz2Gy4(float f);

    @Override // androidx.compose.ui.unit.Density
    @Stable
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    long mo317toSpkPz2Gy4(int i);
}
