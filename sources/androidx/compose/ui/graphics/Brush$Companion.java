package androidx.compose.ui.graphics;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Brush$Companion {
    private Brush$Companion() {
    }

    public /* synthetic */ Brush$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
    public static /* synthetic */ Brush m1007horizontalGradient8A3gB4$default(Brush$Companion brush$Companion, List list, float f, float f2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f2 = Float.POSITIVE_INFINITY;
        }
        if ((i2 & 8) != 0) {
            i = TileMode.Companion.m1258getClamp3opZhB0();
        }
        return brush$Companion.m1017horizontalGradient8A3gB4((List<Color>) list, f, f2, i);
    }

    /* renamed from: linearGradient-mHitzGk$default, reason: not valid java name */
    public static /* synthetic */ Brush m1010linearGradientmHitzGk$default(Brush$Companion brush$Companion, Pair[] pairArr, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = Offset.Companion.getZero-F1C5BW0();
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = Offset.Companion.getInfinite-F1C5BW0();
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            i = TileMode.Companion.m1258getClamp3opZhB0();
        }
        return brush$Companion.m1020linearGradientmHitzGk((Pair<Float, Color>[]) pairArr, j3, j4, i);
    }

    /* renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
    public static /* synthetic */ Brush m1012radialGradientP_VxKs$default(Brush$Companion brush$Companion, Pair[] pairArr, long j, float f, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = Offset.Companion.getUnspecified-F1C5BW0();
        }
        long j2 = j;
        float f2 = (i2 & 4) != 0 ? Float.POSITIVE_INFINITY : f;
        if ((i2 & 8) != 0) {
            i = TileMode.Companion.m1258getClamp3opZhB0();
        }
        return brush$Companion.m1022radialGradientP_VxKs((Pair<Float, Color>[]) pairArr, j2, f2, i);
    }

    /* renamed from: sweepGradient-Uv8p0NA$default, reason: not valid java name */
    public static /* synthetic */ Brush m1014sweepGradientUv8p0NA$default(Brush$Companion brush$Companion, Pair[] pairArr, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Offset.Companion.getUnspecified-F1C5BW0();
        }
        return brush$Companion.m1024sweepGradientUv8p0NA((Pair<Float, Color>[]) pairArr, j);
    }

    /* renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
    public static /* synthetic */ Brush m1015verticalGradient8A3gB4$default(Brush$Companion brush$Companion, List list, float f, float f2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f2 = Float.POSITIVE_INFINITY;
        }
        if ((i2 & 8) != 0) {
            i = TileMode.Companion.m1258getClamp3opZhB0();
        }
        return brush$Companion.m1025verticalGradient8A3gB4((List<Color>) list, f, f2, i);
    }

    @Stable
    @NotNull
    /* renamed from: horizontalGradient-8A-3gB4, reason: not valid java name */
    public final Brush m1017horizontalGradient8A3gB4(@NotNull List<Color> list, float f, float f2, int i) {
        Intrinsics.checkNotNullParameter(list, "colors");
        return m1019linearGradientmHitzGk(list, OffsetKt.Offset(f, 0.0f), OffsetKt.Offset(f2, 0.0f), i);
    }

    @Stable
    @NotNull
    /* renamed from: linearGradient-mHitzGk, reason: not valid java name */
    public final Brush m1020linearGradientmHitzGk(@NotNull Pair<Float, Color>[] pairArr, long j, long j2, int i) {
        Intrinsics.checkNotNullParameter(pairArr, "colorStops");
        ArrayList arrayList = new ArrayList(pairArr.length);
        for (Pair<Float, Color> pair : pairArr) {
            arrayList.add(Color.m1040boximpl(((Color) pair.getSecond()).m1060unboximpl()));
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
    public final Brush m1022radialGradientP_VxKs(@NotNull Pair<Float, Color>[] pairArr, long j, float f, int i) {
        Intrinsics.checkNotNullParameter(pairArr, "colorStops");
        ArrayList arrayList = new ArrayList(pairArr.length);
        for (Pair<Float, Color> pair : pairArr) {
            arrayList.add(Color.m1040boximpl(((Color) pair.getSecond()).m1060unboximpl()));
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
    public final Brush m1024sweepGradientUv8p0NA(@NotNull Pair<Float, Color>[] pairArr, long j) {
        Intrinsics.checkNotNullParameter(pairArr, "colorStops");
        ArrayList arrayList = new ArrayList(pairArr.length);
        for (Pair<Float, Color> pair : pairArr) {
            arrayList.add(Color.m1040boximpl(((Color) pair.getSecond()).m1060unboximpl()));
        }
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair<Float, Color> pair2 : pairArr) {
            arrayList2.add(Float.valueOf(((Number) pair2.getFirst()).floatValue()));
        }
        return new SweepGradient(j, arrayList, arrayList2, (DefaultConstructorMarker) null);
    }

    @Stable
    @NotNull
    /* renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
    public final Brush m1025verticalGradient8A3gB4(@NotNull List<Color> list, float f, float f2, int i) {
        Intrinsics.checkNotNullParameter(list, "colors");
        return m1019linearGradientmHitzGk(list, OffsetKt.Offset(0.0f, f), OffsetKt.Offset(0.0f, f2), i);
    }

    @Stable
    @NotNull
    /* renamed from: horizontalGradient-8A-3gB4, reason: not valid java name */
    public final Brush m1018horizontalGradient8A3gB4(@NotNull Pair<Float, Color>[] pairArr, float f, float f2, int i) {
        Intrinsics.checkNotNullParameter(pairArr, "colorStops");
        return m1020linearGradientmHitzGk((Pair<Float, Color>[]) Arrays.copyOf(pairArr, pairArr.length), OffsetKt.Offset(f, 0.0f), OffsetKt.Offset(f2, 0.0f), i);
    }

    @Stable
    @NotNull
    /* renamed from: verticalGradient-8A-3gB4, reason: not valid java name */
    public final Brush m1026verticalGradient8A3gB4(@NotNull Pair<Float, Color>[] pairArr, float f, float f2, int i) {
        Intrinsics.checkNotNullParameter(pairArr, "colorStops");
        return m1020linearGradientmHitzGk((Pair<Float, Color>[]) Arrays.copyOf(pairArr, pairArr.length), OffsetKt.Offset(0.0f, f), OffsetKt.Offset(0.0f, f2), i);
    }

    /* renamed from: horizontalGradient-8A-3gB4$default, reason: not valid java name */
    public static /* synthetic */ Brush m1008horizontalGradient8A3gB4$default(Brush$Companion brush$Companion, Pair[] pairArr, float f, float f2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f2 = Float.POSITIVE_INFINITY;
        }
        if ((i2 & 8) != 0) {
            i = TileMode.Companion.m1258getClamp3opZhB0();
        }
        return brush$Companion.m1018horizontalGradient8A3gB4((Pair<Float, Color>[]) pairArr, f, f2, i);
    }

    /* renamed from: sweepGradient-Uv8p0NA$default, reason: not valid java name */
    public static /* synthetic */ Brush m1013sweepGradientUv8p0NA$default(Brush$Companion brush$Companion, List list, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Offset.Companion.getUnspecified-F1C5BW0();
        }
        return brush$Companion.m1023sweepGradientUv8p0NA((List<Color>) list, j);
    }

    /* renamed from: verticalGradient-8A-3gB4$default, reason: not valid java name */
    public static /* synthetic */ Brush m1016verticalGradient8A3gB4$default(Brush$Companion brush$Companion, Pair[] pairArr, float f, float f2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f2 = Float.POSITIVE_INFINITY;
        }
        if ((i2 & 8) != 0) {
            i = TileMode.Companion.m1258getClamp3opZhB0();
        }
        return brush$Companion.m1026verticalGradient8A3gB4((Pair<Float, Color>[]) pairArr, f, f2, i);
    }

    /* renamed from: radialGradient-P_Vx-Ks$default, reason: not valid java name */
    public static /* synthetic */ Brush m1011radialGradientP_VxKs$default(Brush$Companion brush$Companion, List list, long j, float f, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = Offset.Companion.getUnspecified-F1C5BW0();
        }
        long j2 = j;
        float f2 = (i2 & 4) != 0 ? Float.POSITIVE_INFINITY : f;
        if ((i2 & 8) != 0) {
            i = TileMode.Companion.m1258getClamp3opZhB0();
        }
        return brush$Companion.m1021radialGradientP_VxKs((List<Color>) list, j2, f2, i);
    }

    @Stable
    @NotNull
    /* renamed from: linearGradient-mHitzGk, reason: not valid java name */
    public final Brush m1019linearGradientmHitzGk(@NotNull List<Color> list, long j, long j2, int i) {
        Intrinsics.checkNotNullParameter(list, "colors");
        return new LinearGradient(list, null, j, j2, i, null);
    }

    @Stable
    @NotNull
    /* renamed from: radialGradient-P_Vx-Ks, reason: not valid java name */
    public final Brush m1021radialGradientP_VxKs(@NotNull List<Color> list, long j, float f, int i) {
        Intrinsics.checkNotNullParameter(list, "colors");
        return new RadialGradient(list, null, j, f, i, null);
    }

    @Stable
    @NotNull
    /* renamed from: sweepGradient-Uv8p0NA, reason: not valid java name */
    public final Brush m1023sweepGradientUv8p0NA(@NotNull List<Color> list, long j) {
        Intrinsics.checkNotNullParameter(list, "colors");
        return new SweepGradient(j, list, (List) null, (DefaultConstructorMarker) null);
    }

    /* renamed from: linearGradient-mHitzGk$default, reason: not valid java name */
    public static /* synthetic */ Brush m1009linearGradientmHitzGk$default(Brush$Companion brush$Companion, List list, long j, long j2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = Offset.Companion.getZero-F1C5BW0();
        }
        long j3 = j;
        if ((i2 & 4) != 0) {
            j2 = Offset.Companion.getInfinite-F1C5BW0();
        }
        long j4 = j2;
        if ((i2 & 8) != 0) {
            i = TileMode.Companion.m1258getClamp3opZhB0();
        }
        return brush$Companion.m1019linearGradientmHitzGk((List<Color>) list, j3, j4, i);
    }
}
