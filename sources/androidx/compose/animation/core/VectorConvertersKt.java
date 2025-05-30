package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset$Companion;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect$Companion;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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
    private static final TwoWayConverter<Integer, AnimationVector1D> IntToVector = TwoWayConverter(IntToVector.1.INSTANCE, IntToVector.2.INSTANCE);

    @NotNull
    private static final TwoWayConverter<Dp, AnimationVector1D> DpToVector = TwoWayConverter(new Function1<Dp, AnimationVector1D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m101invoke0680j_4(((Dp) obj).unbox-impl());
        }

        @NotNull
        /* renamed from: invoke-0680j_4, reason: not valid java name */
        public final AnimationVector1D m101invoke0680j_4(float f) {
            return new AnimationVector1D(f);
        }
    }, new Function1<AnimationVector1D, Dp>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Dp.box-impl(m102invokeu2uoSUM((AnimationVector1D) obj));
        }

        /* renamed from: invoke-u2uoSUM, reason: not valid java name */
        public final float m102invokeu2uoSUM(@NotNull AnimationVector1D animationVector1D) {
            Intrinsics.checkNotNullParameter(animationVector1D, "it");
            return Dp.constructor-impl(animationVector1D.getValue());
        }
    });

    @NotNull
    private static final TwoWayConverter<DpOffset, AnimationVector2D> DpOffsetToVector = TwoWayConverter(DpOffsetToVector.1.INSTANCE, DpOffsetToVector.2.INSTANCE);

    @NotNull
    private static final TwoWayConverter<Size, AnimationVector2D> SizeToVector = TwoWayConverter(new Function1<Size, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m105invokeuvyYCjk(((Size) obj).unbox-impl());
        }

        @NotNull
        /* renamed from: invoke-uvyYCjk, reason: not valid java name */
        public final AnimationVector2D m105invokeuvyYCjk(long j) {
            return new AnimationVector2D(Size.getWidth-impl(j), Size.getHeight-impl(j));
        }
    }, new Function1<AnimationVector2D, Size>() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Size.box-impl(m106invoke7Ah8Wj8((AnimationVector2D) obj));
        }

        /* renamed from: invoke-7Ah8Wj8, reason: not valid java name */
        public final long m106invoke7Ah8Wj8(@NotNull AnimationVector2D animationVector2D) {
            Intrinsics.checkNotNullParameter(animationVector2D, "it");
            return SizeKt.Size(animationVector2D.getV1(), animationVector2D.getV2());
        }
    });

    @NotNull
    private static final TwoWayConverter<Offset, AnimationVector2D> OffsetToVector = TwoWayConverter(OffsetToVector.1.INSTANCE, OffsetToVector.2.INSTANCE);

    @NotNull
    private static final TwoWayConverter<IntOffset, AnimationVector2D> IntOffsetToVector = TwoWayConverter(IntOffsetToVector.1.INSTANCE, IntOffsetToVector.2.INSTANCE);

    @NotNull
    private static final TwoWayConverter<IntSize, AnimationVector2D> IntSizeToVector = TwoWayConverter(new Function1<IntSize, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m103invokeozmzZPI(((IntSize) obj).m2689unboximpl());
        }

        @NotNull
        /* renamed from: invoke-ozmzZPI, reason: not valid java name */
        public final AnimationVector2D m103invokeozmzZPI(long j) {
            return new AnimationVector2D(IntSize.m2685getWidthimpl(j), IntSize.m2684getHeightimpl(j));
        }
    }, new Function1<AnimationVector2D, IntSize>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntSize.m2677boximpl(m104invokeYEO4UFw((AnimationVector2D) obj));
        }

        /* renamed from: invoke-YEO4UFw, reason: not valid java name */
        public final long m104invokeYEO4UFw(@NotNull AnimationVector2D animationVector2D) {
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
    public static final TwoWayConverter<Rect, AnimationVector4D> getVectorConverter(@NotNull Rect$Companion rect$Companion) {
        Intrinsics.checkNotNullParameter(rect$Companion, "<this>");
        return RectToVector;
    }

    @NotNull
    public static final TwoWayConverter<Dp, AnimationVector1D> getVectorConverter(@NotNull Dp.Companion companion) {
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
    public static final TwoWayConverter<Offset, AnimationVector2D> getVectorConverter(@NotNull Offset$Companion offset$Companion) {
        Intrinsics.checkNotNullParameter(offset$Companion, "<this>");
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
