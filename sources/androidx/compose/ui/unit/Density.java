package androidx.compose.ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface Density {
    float getDensity();

    float getFontScale();

    @Stable
    /* renamed from: roundToPx--R2X_6o */
    int mo318roundToPxR2X_6o(long j);

    @Stable
    /* renamed from: roundToPx-0680j_4 */
    int mo319roundToPx0680j_4(float f);

    @Stable
    /* renamed from: toDp-GaN1DYA */
    float mo310toDpGaN1DYA(long j);

    @Stable
    /* renamed from: toDp-u2uoSUM */
    float mo311toDpu2uoSUM(float f);

    @Stable
    /* renamed from: toDp-u2uoSUM */
    float mo312toDpu2uoSUM(int i);

    @Stable
    /* renamed from: toDpSize-k-rfVVM */
    long mo313toDpSizekrfVVM(long j);

    @Stable
    /* renamed from: toPx--R2X_6o */
    float mo320toPxR2X_6o(long j);

    @Stable
    /* renamed from: toPx-0680j_4 */
    float mo321toPx0680j_4(float f);

    @Stable
    @NotNull
    Rect toRect(@NotNull DpRect dpRect);

    @Stable
    /* renamed from: toSize-XkaWNTQ */
    long mo314toSizeXkaWNTQ(long j);

    @Stable
    /* renamed from: toSp-0xMU5do */
    long mo315toSp0xMU5do(float f);

    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    long mo316toSpkPz2Gy4(float f);

    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    long mo317toSpkPz2Gy4(int i);
}
