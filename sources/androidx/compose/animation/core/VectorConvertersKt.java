package androidx.compose.animation.core;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.geometry.SizeKt;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.DpKt;
import androidx.compose.p004ui.unit.DpOffset;
import androidx.compose.p004ui.unit.IntOffset;
import androidx.compose.p004ui.unit.IntOffsetKt;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.IntSizeKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class VectorConvertersKt {

    @NotNull
    private static final TwoWayConverter<Float, AnimationVector1D> FloatToVector = TwoWayConverter(new Function1<Float, AnimationVector1D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$FloatToVector$1
        @NotNull
        public final AnimationVector1D invoke(float f) {
            return new AnimationVector1D(f);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).floatValue());
        }
    }, new Function1<AnimationVector1D, Float>() { // from class: androidx.compose.animation.core.VectorConvertersKt$FloatToVector$2
        @NotNull
        public final Float invoke(@NotNull AnimationVector1D animationVector1D) {
            Intrinsics.checkNotNullParameter(animationVector1D, "it");
            return Float.valueOf(animationVector1D.getValue());
        }
    });

    @NotNull
    private static final TwoWayConverter<Integer, AnimationVector1D> IntToVector = TwoWayConverter(new Function1<Integer, AnimationVector1D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntToVector$1
        @NotNull
        public final AnimationVector1D invoke(int i) {
            return new AnimationVector1D(i);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }, new Function1<AnimationVector1D, Integer>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntToVector$2
        @NotNull
        public final Integer invoke(@NotNull AnimationVector1D animationVector1D) {
            Intrinsics.checkNotNullParameter(animationVector1D, "it");
            return Integer.valueOf((int) animationVector1D.getValue());
        }
    });

    @NotNull
    private static final TwoWayConverter<C0856Dp, AnimationVector1D> DpToVector = TwoWayConverter(new Function1<C0856Dp, AnimationVector1D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m1093invoke0680j_4(((C0856Dp) obj).m5230unboximpl());
        }

        @NotNull
        /* renamed from: invoke-0680j_4, reason: not valid java name */
        public final AnimationVector1D m1093invoke0680j_4(float f) {
            return new AnimationVector1D(f);
        }
    }, new Function1<AnimationVector1D, C0856Dp>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return C0856Dp.m5214boximpl(m1094invokeu2uoSUM((AnimationVector1D) obj));
        }

        /* renamed from: invoke-u2uoSUM, reason: not valid java name */
        public final float m1094invokeu2uoSUM(@NotNull AnimationVector1D animationVector1D) {
            Intrinsics.checkNotNullParameter(animationVector1D, "it");
            return C0856Dp.m5216constructorimpl(animationVector1D.getValue());
        }
    });

    @NotNull
    private static final TwoWayConverter<DpOffset, AnimationVector2D> DpOffsetToVector = TwoWayConverter(new Function1<DpOffset, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpOffsetToVector$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m1091invokejoFl9I(((DpOffset) obj).m5285unboximpl());
        }

        @NotNull
        /* renamed from: invoke-jo-Fl9I, reason: not valid java name */
        public final AnimationVector2D m1091invokejoFl9I(long j) {
            return new AnimationVector2D(DpOffset.m5277getXD9Ej5fM(j), DpOffset.m5279getYD9Ej5fM(j));
        }
    }, new Function1<AnimationVector2D, DpOffset>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpOffsetToVector$2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return DpOffset.m5271boximpl(m1092invokegVRvYmI((AnimationVector2D) obj));
        }

        /* renamed from: invoke-gVRvYmI, reason: not valid java name */
        public final long m1092invokegVRvYmI(@NotNull AnimationVector2D animationVector2D) {
            Intrinsics.checkNotNullParameter(animationVector2D, "it");
            return DpKt.m5237DpOffsetYgX7TsA(C0856Dp.m5216constructorimpl(animationVector2D.getV1()), C0856Dp.m5216constructorimpl(animationVector2D.getV2()));
        }
    });

    @NotNull
    private static final TwoWayConverter<Size, AnimationVector2D> SizeToVector = TwoWayConverter(new Function1<Size, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m1101invokeuvyYCjk(((Size) obj).m2630unboximpl());
        }

        @NotNull
        /* renamed from: invoke-uvyYCjk, reason: not valid java name */
        public final AnimationVector2D m1101invokeuvyYCjk(long j) {
            return new AnimationVector2D(Size.m2625getWidthimpl(j), Size.m2622getHeightimpl(j));
        }
    }, new Function1<AnimationVector2D, Size>() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Size.m2613boximpl(m1102invoke7Ah8Wj8((AnimationVector2D) obj));
        }

        /* renamed from: invoke-7Ah8Wj8, reason: not valid java name */
        public final long m1102invoke7Ah8Wj8(@NotNull AnimationVector2D animationVector2D) {
            Intrinsics.checkNotNullParameter(animationVector2D, "it");
            return SizeKt.Size(animationVector2D.getV1(), animationVector2D.getV2());
        }
    });

    @NotNull
    private static final TwoWayConverter<Offset, AnimationVector2D> OffsetToVector = TwoWayConverter(new Function1<Offset, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$OffsetToVector$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m1099invokek4lQ0M(((Offset) obj).m2566unboximpl());
        }

        @NotNull
        /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final AnimationVector2D m1099invokek4lQ0M(long j) {
            return new AnimationVector2D(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j));
        }
    }, new Function1<AnimationVector2D, Offset>() { // from class: androidx.compose.animation.core.VectorConvertersKt$OffsetToVector$2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Offset.m2545boximpl(m1100invoketuRUvjQ((AnimationVector2D) obj));
        }

        /* renamed from: invoke-tuRUvjQ, reason: not valid java name */
        public final long m1100invoketuRUvjQ(@NotNull AnimationVector2D animationVector2D) {
            Intrinsics.checkNotNullParameter(animationVector2D, "it");
            return OffsetKt.Offset(animationVector2D.getV1(), animationVector2D.getV2());
        }
    });

    @NotNull
    private static final TwoWayConverter<IntOffset, AnimationVector2D> IntOffsetToVector = TwoWayConverter(new Function1<IntOffset, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntOffsetToVector$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m1095invokegyyYBs(((IntOffset) obj).m5343unboximpl());
        }

        @NotNull
        /* renamed from: invoke--gyyYBs, reason: not valid java name */
        public final AnimationVector2D m1095invokegyyYBs(long j) {
            return new AnimationVector2D(IntOffset.m5334getXimpl(j), IntOffset.m5335getYimpl(j));
        }
    }, new Function1<AnimationVector2D, IntOffset>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntOffsetToVector$2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntOffset.m5325boximpl(m1096invokeBjo55l4((AnimationVector2D) obj));
        }

        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
        public final long m1096invokeBjo55l4(@NotNull AnimationVector2D animationVector2D) {
            Intrinsics.checkNotNullParameter(animationVector2D, "it");
            return IntOffsetKt.IntOffset(MathKt.roundToInt(animationVector2D.getV1()), MathKt.roundToInt(animationVector2D.getV2()));
        }
    });

    @NotNull
    private static final TwoWayConverter<IntSize, AnimationVector2D> IntSizeToVector = TwoWayConverter(new Function1<IntSize, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m1097invokeozmzZPI(((IntSize) obj).m5380unboximpl());
        }

        @NotNull
        /* renamed from: invoke-ozmzZPI, reason: not valid java name */
        public final AnimationVector2D m1097invokeozmzZPI(long j) {
            return new AnimationVector2D(IntSize.m5376getWidthimpl(j), IntSize.m5375getHeightimpl(j));
        }
    }, new Function1<AnimationVector2D, IntSize>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntSize.m5368boximpl(m1098invokeYEO4UFw((AnimationVector2D) obj));
        }

        /* renamed from: invoke-YEO4UFw, reason: not valid java name */
        public final long m1098invokeYEO4UFw(@NotNull AnimationVector2D animationVector2D) {
            Intrinsics.checkNotNullParameter(animationVector2D, "it");
            return IntSizeKt.IntSize(MathKt.roundToInt(animationVector2D.getV1()), MathKt.roundToInt(animationVector2D.getV2()));
        }
    });

    @NotNull
    private static final TwoWayConverter<Rect, AnimationVector4D> RectToVector = TwoWayConverter(new Function1<Rect, AnimationVector4D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$RectToVector$1
        @NotNull
        public final AnimationVector4D invoke(@NotNull Rect rect) {
            Intrinsics.checkNotNullParameter(rect, "it");
            return new AnimationVector4D(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
        }
    }, new Function1<AnimationVector4D, Rect>() { // from class: androidx.compose.animation.core.VectorConvertersKt$RectToVector$2
        @NotNull
        public final Rect invoke(@NotNull AnimationVector4D animationVector4D) {
            Intrinsics.checkNotNullParameter(animationVector4D, "it");
            return new Rect(animationVector4D.getV1(), animationVector4D.getV2(), animationVector4D.getV3(), animationVector4D.getV4());
        }
    });

    @NotNull
    public static final <T, V extends AnimationVector> TwoWayConverter<T, V> TwoWayConverter(@NotNull Function1<? super T, ? extends V> function1, @NotNull Function1<? super V, ? extends T> function12) {
        Intrinsics.checkNotNullParameter(function1, "convertToVector");
        Intrinsics.checkNotNullParameter(function12, "convertFromVector");
        return new TwoWayConverterImpl(function1, function12);
    }

    @NotNull
    public static final TwoWayConverter<Float, AnimationVector1D> getVectorConverter(@NotNull FloatCompanionObject floatCompanionObject) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return FloatToVector;
    }

    public static final float lerp(float f, float f2, float f3) {
        return (f * (1 - f3)) + (f2 * f3);
    }

    @NotNull
    public static final TwoWayConverter<Integer, AnimationVector1D> getVectorConverter(@NotNull IntCompanionObject intCompanionObject) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return IntToVector;
    }

    @NotNull
    public static final TwoWayConverter<Rect, AnimationVector4D> getVectorConverter(@NotNull Rect.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return RectToVector;
    }

    @NotNull
    public static final TwoWayConverter<C0856Dp, AnimationVector1D> getVectorConverter(@NotNull C0856Dp.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return DpToVector;
    }

    @NotNull
    public static final TwoWayConverter<DpOffset, AnimationVector2D> getVectorConverter(@NotNull DpOffset.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return DpOffsetToVector;
    }

    @NotNull
    public static final TwoWayConverter<Size, AnimationVector2D> getVectorConverter(@NotNull Size.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return SizeToVector;
    }

    @NotNull
    public static final TwoWayConverter<Offset, AnimationVector2D> getVectorConverter(@NotNull Offset.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return OffsetToVector;
    }

    @NotNull
    public static final TwoWayConverter<IntOffset, AnimationVector2D> getVectorConverter(@NotNull IntOffset.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return IntOffsetToVector;
    }

    @NotNull
    public static final TwoWayConverter<IntSize, AnimationVector2D> getVectorConverter(@NotNull IntSize.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return IntSizeToVector;
    }
}
