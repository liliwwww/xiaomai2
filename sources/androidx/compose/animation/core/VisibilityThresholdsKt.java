package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset$Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect$Companion;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VisibilityThresholdsKt {
    private static final float DpVisibilityThreshold = 0.1f;
    private static final float PxVisibilityThreshold = 0.5f;

    @NotNull
    private static final Rect rectVisibilityThreshold;

    @NotNull
    private static final Map<TwoWayConverter<?, ?>, Float> visibilityThresholdMap;

    static {
        Float valueOf = Float.valueOf(0.5f);
        rectVisibilityThreshold = new Rect(0.5f, 0.5f, 0.5f, 0.5f);
        TwoWayConverter<Integer, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        Float valueOf2 = Float.valueOf(1.0f);
        TwoWayConverter<Dp, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(Dp.Companion);
        Float valueOf3 = Float.valueOf(DpVisibilityThreshold);
        visibilityThresholdMap = MapsKt.mapOf(new Pair[]{TuplesKt.to(vectorConverter, valueOf2), TuplesKt.to(VectorConvertersKt.getVectorConverter(IntSize.Companion), valueOf2), TuplesKt.to(VectorConvertersKt.getVectorConverter(IntOffset.Companion), valueOf2), TuplesKt.to(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(0.01f)), TuplesKt.to(VectorConvertersKt.getVectorConverter(Rect.Companion), valueOf), TuplesKt.to(VectorConvertersKt.getVectorConverter(Size.Companion), valueOf), TuplesKt.to(VectorConvertersKt.getVectorConverter(Offset.Companion), valueOf), TuplesKt.to(vectorConverter2, valueOf3), TuplesKt.to(VectorConvertersKt.getVectorConverter(DpOffset.Companion), valueOf3)});
    }

    public static final int getVisibilityThreshold(@NotNull IntCompanionObject intCompanionObject) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return 1;
    }

    public static final long getVisibilityThreshold(@NotNull IntOffset.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return IntOffsetKt.IntOffset(1, 1);
    }

    @NotNull
    public static final Map<TwoWayConverter<?, ?>, Float> getVisibilityThresholdMap() {
        return visibilityThresholdMap;
    }

    public static final long getVisibilityThreshold(@NotNull Offset$Companion offset$Companion) {
        Intrinsics.checkNotNullParameter(offset$Companion, "<this>");
        return OffsetKt.Offset(0.5f, 0.5f);
    }

    public static final long getVisibilityThreshold(@NotNull DpOffset.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Dp.Companion companion2 = Dp.Companion;
        return DpKt.m2581DpOffsetYgX7TsA(getVisibilityThreshold(companion2), getVisibilityThreshold(companion2));
    }

    public static final long getVisibilityThreshold(@NotNull Size.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return SizeKt.Size(0.5f, 0.5f);
    }

    public static final long getVisibilityThreshold(@NotNull IntSize.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return IntSizeKt.IntSize(1, 1);
    }

    @NotNull
    public static final Rect getVisibilityThreshold(@NotNull Rect$Companion rect$Companion) {
        Intrinsics.checkNotNullParameter(rect$Companion, "<this>");
        return rectVisibilityThreshold;
    }

    public static final float getVisibilityThreshold(@NotNull Dp.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return Dp.constructor-impl(DpVisibilityThreshold);
    }
}
