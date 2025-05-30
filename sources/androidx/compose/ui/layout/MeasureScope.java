package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.DpRect;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface MeasureScope extends IntrinsicMeasureScope {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static MeasureResult layout(@NotNull MeasureScope measureScope, int i, int i2, @NotNull Map<AlignmentLine, Integer> map, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(map, "alignmentLines");
            Intrinsics.checkNotNullParameter(function1, "placementBlock");
            return -CC.b(measureScope, i, i2, map, function1);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m1546roundToPxR2X_6o(@NotNull MeasureScope measureScope, long j) {
            return -CC.c(measureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m1547roundToPx0680j_4(@NotNull MeasureScope measureScope, float f) {
            return -CC.d(measureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m1548toDpGaN1DYA(@NotNull MeasureScope measureScope, long j) {
            return -CC.e(measureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1549toDpu2uoSUM(@NotNull MeasureScope measureScope, float f) {
            return -CC.f(measureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m1551toDpSizekrfVVM(@NotNull MeasureScope measureScope, long j) {
            return -CC.h(measureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m1552toPxR2X_6o(@NotNull MeasureScope measureScope, long j) {
            return -CC.i(measureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m1553toPx0680j_4(@NotNull MeasureScope measureScope, float f) {
            return -CC.j(measureScope, f);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull MeasureScope measureScope, @NotNull DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "$receiver");
            return -CC.k(measureScope, dpRect);
        }

        @Stable
        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m1554toSizeXkaWNTQ(@NotNull MeasureScope measureScope, long j) {
            return -CC.l(measureScope, j);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m1555toSp0xMU5do(@NotNull MeasureScope measureScope, float f) {
            return -CC.m(measureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1556toSpkPz2Gy4(@NotNull MeasureScope measureScope, float f) {
            return -CC.n(measureScope, f);
        }

        @Stable
        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m1550toDpu2uoSUM(@NotNull MeasureScope measureScope, int i) {
            return -CC.g(measureScope, i);
        }

        @Stable
        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m1557toSpkPz2Gy4(@NotNull MeasureScope measureScope, int i) {
            return -CC.o(measureScope, i);
        }
    }

    @NotNull
    MeasureResult layout(int i, int i2, @NotNull Map<AlignmentLine, Integer> map, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1);
}
