package androidx.compose.p004ui.unit;

import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.jw0;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes.dex */
public interface Density {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Stable
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m5202roundToPxR2X_6o(@NotNull Density density, long j) {
            return jw0.n(density, j);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m5203roundToPx0680j_4(@NotNull Density density, float f) {
            return jw0.o(density, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m5204toDpGaN1DYA(@NotNull Density density, long j) {
            return jw0.p(density, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5206toDpu2uoSUM(@NotNull Density density, int i) {
            return jw0.r(density, i);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5207toDpSizekrfVVM(@NotNull Density density, long j) {
            return jw0.s(density, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m5208toPxR2X_6o(@NotNull Density density, long j) {
            return jw0.t(density, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m5209toPx0680j_4(@NotNull Density density, float f) {
            return jw0.u(density, f);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull Density density, @NotNull DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "$receiver");
            return jw0.v(density, dpRect);
        }

        @Stable
        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m5210toSizeXkaWNTQ(@NotNull Density density, long j) {
            return jw0.w(density, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m5211toSp0xMU5do(@NotNull Density density, float f) {
            return jw0.x(density, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5213toSpkPz2Gy4(@NotNull Density density, int i) {
            return jw0.z(density, i);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5205toDpu2uoSUM(@NotNull Density density, float f) {
            return jw0.q(density, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5212toSpkPz2Gy4(@NotNull Density density, float f) {
            return jw0.y(density, f);
        }
    }

    float getDensity();

    float getFontScale();

    @Stable
    /* renamed from: roundToPx--R2X_6o */
    int mo1276roundToPxR2X_6o(long j);

    @Stable
    /* renamed from: roundToPx-0680j_4 */
    int mo1277roundToPx0680j_4(float f);

    @Stable
    /* renamed from: toDp-GaN1DYA */
    float mo1278toDpGaN1DYA(long j);

    @Stable
    /* renamed from: toDp-u2uoSUM */
    float mo1279toDpu2uoSUM(float f);

    @Stable
    /* renamed from: toDp-u2uoSUM */
    float mo1280toDpu2uoSUM(int i);

    @Stable
    /* renamed from: toDpSize-k-rfVVM */
    long mo1281toDpSizekrfVVM(long j);

    @Stable
    /* renamed from: toPx--R2X_6o */
    float mo1282toPxR2X_6o(long j);

    @Stable
    /* renamed from: toPx-0680j_4 */
    float mo1283toPx0680j_4(float f);

    @Stable
    @NotNull
    Rect toRect(@NotNull DpRect dpRect);

    @Stable
    /* renamed from: toSize-XkaWNTQ */
    long mo1284toSizeXkaWNTQ(long j);

    @Stable
    /* renamed from: toSp-0xMU5do */
    long mo1285toSp0xMU5do(float f);

    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    long mo1286toSpkPz2Gy4(float f);

    @Stable
    /* renamed from: toSp-kPz2Gy4 */
    long mo1287toSpkPz2Gy4(int i);
}
