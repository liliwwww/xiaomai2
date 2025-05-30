package androidx.compose.p004ui.graphics;

import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes2.dex */
public abstract class Brush {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private final long intrinsicSize;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m2742horizontalGradient8A3gB4$default(Companion companion, List list, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3112getClamp3opZhB0();
            }
            return companion.m2752horizontalGradient8A3gB4((List<Color>) list, f, f2, i);
        }

        /* renamed from: linearGradient-mHitzGk$default, reason: not valid java name */
        public static /* synthetic */ Brush m2745linearGradientmHitzGk$default(Companion companion, Pair[] pairArr, long j, long j2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = Offset.Companion.m2572getZeroF1C5BW0();
            }
            long j3 = j;
            if ((i2 & 4) != 0) {
                j2 = Offset.Companion.m2570getInfiniteF1C5BW0();
            }
            long j4 = j2;
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3112getClamp3opZhB0();
            }
            return companion.m2755linearGradientmHitzGk((Pair<Float, Color>[]) pairArr, j3, j4, i);
        }

        /* renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
        public static /* synthetic */ Brush m2747radialGradientP_VxKs$default(Companion companion, Pair[] pairArr, long j, float f, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = Offset.Companion.m2571getUnspecifiedF1C5BW0();
            }
            long j2 = j;
            float f2 = (i2 & 4) != 0 ? Float.POSITIVE_INFINITY : f;
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3112getClamp3opZhB0();
            }
            return companion.m2757radialGradientP_VxKs((Pair<Float, Color>[]) pairArr, j2, f2, i);
        }

        /* renamed from: sweepGradient-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ Brush m2749sweepGradientUv8p0NA$default(Companion companion, Pair[] pairArr, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = Offset.Companion.m2571getUnspecifiedF1C5BW0();
            }
            return companion.m2759sweepGradientUv8p0NA((Pair<Float, Color>[]) pairArr, j);
        }

        /* renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m2750verticalGradient8A3gB4$default(Companion companion, List list, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3112getClamp3opZhB0();
            }
            return companion.m2760verticalGradient8A3gB4((List<Color>) list, f, f2, i);
        }

        @Stable
        @NotNull
        /* renamed from: horizontalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m2752horizontalGradient8A3gB4(@NotNull List<Color> list, float f, float f2, int i) {
            Intrinsics.checkNotNullParameter(list, "colors");
            return m2754linearGradientmHitzGk(list, OffsetKt.Offset(f, 0.0f), OffsetKt.Offset(f2, 0.0f), i);
        }

        @Stable
        @NotNull
        /* renamed from: linearGradient-mHitzGk, reason: not valid java name */
        public final Brush m2755linearGradientmHitzGk(@NotNull Pair<Float, Color>[] pairArr, long j, long j2, int i) {
            Intrinsics.checkNotNullParameter(pairArr, "colorStops");
            ArrayList arrayList = new ArrayList(pairArr.length);
            for (Pair<Float, Color> pair : pairArr) {
                arrayList.add(Color.m2777boximpl(((Color) pair.getSecond()).m2797unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(pairArr.length);
            for (Pair<Float, Color> pair2 : pairArr) {
                arrayList2.add(Float.valueOf(((Number) pair2.getFirst()).floatValue()));
            }
            return new LinearGradient(arrayList, arrayList2, j, j2, i, null);
        }

        @Stable
        @NotNull
        /* renamed from: radialGradient-P_Vx-Ks, reason: not valid java name */
        public final Brush m2757radialGradientP_VxKs(@NotNull Pair<Float, Color>[] pairArr, long j, float f, int i) {
            Intrinsics.checkNotNullParameter(pairArr, "colorStops");
            ArrayList arrayList = new ArrayList(pairArr.length);
            for (Pair<Float, Color> pair : pairArr) {
                arrayList.add(Color.m2777boximpl(((Color) pair.getSecond()).m2797unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(pairArr.length);
            for (Pair<Float, Color> pair2 : pairArr) {
                arrayList2.add(Float.valueOf(((Number) pair2.getFirst()).floatValue()));
            }
            return new RadialGradient(arrayList, arrayList2, j, f, i, null);
        }

        @Stable
        @NotNull
        /* renamed from: sweepGradient-Uv8p0NA, reason: not valid java name */
        public final Brush m2759sweepGradientUv8p0NA(@NotNull Pair<Float, Color>[] pairArr, long j) {
            Intrinsics.checkNotNullParameter(pairArr, "colorStops");
            ArrayList arrayList = new ArrayList(pairArr.length);
            for (Pair<Float, Color> pair : pairArr) {
                arrayList.add(Color.m2777boximpl(((Color) pair.getSecond()).m2797unboximpl()));
            }
            ArrayList arrayList2 = new ArrayList(pairArr.length);
            for (Pair<Float, Color> pair2 : pairArr) {
                arrayList2.add(Float.valueOf(((Number) pair2.getFirst()).floatValue()));
            }
            return new SweepGradient(j, arrayList, arrayList2, null);
        }

        @Stable
        @NotNull
        /* renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m2760verticalGradient8A3gB4(@NotNull List<Color> list, float f, float f2, int i) {
            Intrinsics.checkNotNullParameter(list, "colors");
            return m2754linearGradientmHitzGk(list, OffsetKt.Offset(0.0f, f), OffsetKt.Offset(0.0f, f2), i);
        }

        @Stable
        @NotNull
        /* renamed from: horizontalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m2753horizontalGradient8A3gB4(@NotNull Pair<Float, Color>[] pairArr, float f, float f2, int i) {
            Intrinsics.checkNotNullParameter(pairArr, "colorStops");
            return m2755linearGradientmHitzGk((Pair<Float, Color>[]) Arrays.copyOf(pairArr, pairArr.length), OffsetKt.Offset(f, 0.0f), OffsetKt.Offset(f2, 0.0f), i);
        }

        @Stable
        @NotNull
        /* renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
        public final Brush m2761verticalGradient8A3gB4(@NotNull Pair<Float, Color>[] pairArr, float f, float f2, int i) {
            Intrinsics.checkNotNullParameter(pairArr, "colorStops");
            return m2755linearGradientmHitzGk((Pair<Float, Color>[]) Arrays.copyOf(pairArr, pairArr.length), OffsetKt.Offset(0.0f, f), OffsetKt.Offset(0.0f, f2), i);
        }

        /* renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m2743horizontalGradient8A3gB4$default(Companion companion, Pair[] pairArr, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3112getClamp3opZhB0();
            }
            return companion.m2753horizontalGradient8A3gB4((Pair<Float, Color>[]) pairArr, f, f2, i);
        }

        /* renamed from: sweepGradient-Uv8p0NA$default, reason: not valid java name */
        public static /* synthetic */ Brush m2748sweepGradientUv8p0NA$default(Companion companion, List list, long j, int i, Object obj) {
            if ((i & 2) != 0) {
                j = Offset.Companion.m2571getUnspecifiedF1C5BW0();
            }
            return companion.m2758sweepGradientUv8p0NA((List<Color>) list, j);
        }

        /* renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
        public static /* synthetic */ Brush m2751verticalGradient8A3gB4$default(Companion companion, Pair[] pairArr, float f, float f2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                f = 0.0f;
            }
            if ((i2 & 4) != 0) {
                f2 = Float.POSITIVE_INFINITY;
            }
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3112getClamp3opZhB0();
            }
            return companion.m2761verticalGradient8A3gB4((Pair<Float, Color>[]) pairArr, f, f2, i);
        }

        /* renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
        public static /* synthetic */ Brush m2746radialGradientP_VxKs$default(Companion companion, List list, long j, float f, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = Offset.Companion.m2571getUnspecifiedF1C5BW0();
            }
            long j2 = j;
            float f2 = (i2 & 4) != 0 ? Float.POSITIVE_INFINITY : f;
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3112getClamp3opZhB0();
            }
            return companion.m2756radialGradientP_VxKs((List<Color>) list, j2, f2, i);
        }

        @Stable
        @NotNull
        /* renamed from: linearGradient-mHitzGk, reason: not valid java name */
        public final Brush m2754linearGradientmHitzGk(@NotNull List<Color> list, long j, long j2, int i) {
            Intrinsics.checkNotNullParameter(list, "colors");
            return new LinearGradient(list, null, j, j2, i, null);
        }

        @Stable
        @NotNull
        /* renamed from: radialGradient-P_Vx-Ks, reason: not valid java name */
        public final Brush m2756radialGradientP_VxKs(@NotNull List<Color> list, long j, float f, int i) {
            Intrinsics.checkNotNullParameter(list, "colors");
            return new RadialGradient(list, null, j, f, i, null);
        }

        @Stable
        @NotNull
        /* renamed from: sweepGradient-Uv8p0NA, reason: not valid java name */
        public final Brush m2758sweepGradientUv8p0NA(@NotNull List<Color> list, long j) {
            Intrinsics.checkNotNullParameter(list, "colors");
            return new SweepGradient(j, list, null, null);
        }

        /* renamed from: linearGradient-mHitzGk$default, reason: not valid java name */
        public static /* synthetic */ Brush m2744linearGradientmHitzGk$default(Companion companion, List list, long j, long j2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                j = Offset.Companion.m2572getZeroF1C5BW0();
            }
            long j3 = j;
            if ((i2 & 4) != 0) {
                j2 = Offset.Companion.m2570getInfiniteF1C5BW0();
            }
            long j4 = j2;
            if ((i2 & 8) != 0) {
                i = TileMode.Companion.m3112getClamp3opZhB0();
            }
            return companion.m2754linearGradientmHitzGk((List<Color>) list, j3, j4, i);
        }
    }

    private Brush() {
        this.intrinsicSize = Size.Companion.m2633getUnspecifiedNHjbRc();
    }

    public /* synthetic */ Brush(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: applyTo-Pq9zytI, reason: not valid java name */
    public abstract void mo2740applyToPq9zytI(long j, @NotNull Paint paint, float f);

    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long mo2741getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }
}
