package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.oa;
import tb.qa;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Arrangement {

    @NotNull
    public static final Arrangement INSTANCE = new Arrangement();

    @NotNull
    private static final Horizontal Start = new Start.1();

    @NotNull
    private static final Horizontal End = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$End$1
        public void arrange(@NotNull Density density, int i, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull int[] iArr2) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(iArr, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(iArr2, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, true);
            }
        }

        /* renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
        public /* synthetic */ float m192getSpacingD9Ej5fM() {
            return oa.a(this);
        }

        @NotNull
        public String toString() {
            return "Arrangement#End";
        }
    };

    @NotNull
    private static final Vertical Top = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Top$1
        public void arrange(@NotNull Density density, int i, @NotNull int[] iArr, @NotNull int[] iArr2) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(iArr, "sizes");
            Intrinsics.checkNotNullParameter(iArr2, "outPositions");
            Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
        }

        /* renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
        public /* synthetic */ float m198getSpacingD9Ej5fM() {
            return qa.a(this);
        }

        @NotNull
        public String toString() {
            return "Arrangement#Top";
        }
    };

    @NotNull
    private static final Vertical Bottom = new Bottom.1();

    @NotNull
    private static final HorizontalOrVertical Center = new Center.1();

    @NotNull
    private static final HorizontalOrVertical SpaceEvenly = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceEvenly$1
        private final float spacing = Dp.m2142constructorimpl(0);

        public void arrange(@NotNull Density density, int i, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull int[] iArr2) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(iArr, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(iArr2, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical
        /* renamed from: getSpacing-D9Ej5fM */
        public float mo193getSpacingD9Ej5fM() {
            return this.spacing;
        }

        @NotNull
        public String toString() {
            return "Arrangement#SpaceEvenly";
        }

        public void arrange(@NotNull Density density, int i, @NotNull int[] iArr, @NotNull int[] iArr2) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(iArr, "sizes");
            Intrinsics.checkNotNullParameter(iArr2, "outPositions");
            Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, iArr, iArr2, false);
        }
    };

    @NotNull
    private static final HorizontalOrVertical SpaceBetween = new SpaceBetween.1();

    @NotNull
    private static final HorizontalOrVertical SpaceAround = new SpaceAround.1();

    /* compiled from: Taobao */
    @Immutable
    public static final class Absolute {

        @NotNull
        public static final Absolute INSTANCE = new Absolute();

        @NotNull
        private static final Horizontal Left = new Left.1();

        @NotNull
        private static final Horizontal Center = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Center$1
            public void arrange(@NotNull Density density, int i, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull int[] iArr2) {
                Intrinsics.checkNotNullParameter(density, "<this>");
                Intrinsics.checkNotNullParameter(iArr, "sizes");
                Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                Intrinsics.checkNotNullParameter(iArr2, "outPositions");
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, iArr, iArr2, false);
            }

            /* renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
            public /* synthetic */ float m191getSpacingD9Ej5fM() {
                return oa.a(this);
            }

            @NotNull
            public String toString() {
                return "AbsoluteArrangement#Center";
            }
        };

        @NotNull
        private static final Horizontal Right = new Right.1();

        @NotNull
        private static final Horizontal SpaceBetween = new SpaceBetween.1();

        @NotNull
        private static final Horizontal SpaceEvenly = new SpaceEvenly.1();

        @NotNull
        private static final Horizontal SpaceAround = new SpaceAround.1();

        private Absolute() {
        }

        @Stable
        public static /* synthetic */ void getCenter$annotations() {
        }

        @Stable
        public static /* synthetic */ void getLeft$annotations() {
        }

        @Stable
        public static /* synthetic */ void getRight$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSpaceAround$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSpaceBetween$annotations() {
        }

        @Stable
        public static /* synthetic */ void getSpaceEvenly$annotations() {
        }

        @Stable
        @NotNull
        public final Horizontal aligned(@NotNull final Alignment$Horizontal alignment$Horizontal) {
            Intrinsics.checkNotNullParameter(alignment$Horizontal, "alignment");
            return new SpacedAligned(Dp.m2142constructorimpl(0), false, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$aligned$1
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke(((Number) obj).intValue(), (LayoutDirection) obj2);
                }

                @NotNull
                public final Integer invoke(int i, @NotNull LayoutDirection layoutDirection) {
                    Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                    return Integer.valueOf(Alignment$Horizontal.this.align(0, i, layoutDirection));
                }
            }, null);
        }

        @NotNull
        public final Horizontal getCenter() {
            return Center;
        }

        @NotNull
        public final Horizontal getLeft() {
            return Left;
        }

        @NotNull
        public final Horizontal getRight() {
            return Right;
        }

        @NotNull
        public final Horizontal getSpaceAround() {
            return SpaceAround;
        }

        @NotNull
        public final Horizontal getSpaceBetween() {
            return SpaceBetween;
        }

        @NotNull
        public final Horizontal getSpaceEvenly() {
            return SpaceEvenly;
        }

        @Stable
        @NotNull
        /* renamed from: spacedBy-0680j_4, reason: not valid java name */
        public final HorizontalOrVertical m188spacedBy0680j_4(float f) {
            Function2 function2 = null;
            return new SpacedAligned(f, false, function2, function2);
        }

        @Stable
        @NotNull
        /* renamed from: spacedBy-D5KLDUw, reason: not valid java name */
        public final Horizontal m189spacedByD5KLDUw(float f, @NotNull final Alignment$Horizontal alignment$Horizontal) {
            Intrinsics.checkNotNullParameter(alignment$Horizontal, "alignment");
            return new SpacedAligned(f, false, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$spacedBy$1
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke(((Number) obj).intValue(), (LayoutDirection) obj2);
                }

                @NotNull
                public final Integer invoke(int i, @NotNull LayoutDirection layoutDirection) {
                    Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                    return Integer.valueOf(Alignment$Horizontal.this.align(0, i, layoutDirection));
                }
            }, null);
        }

        @Stable
        @NotNull
        /* renamed from: spacedBy-D5KLDUw, reason: not valid java name */
        public final Vertical m190spacedByD5KLDUw(float f, @NotNull final Alignment$Vertical alignment$Vertical) {
            Intrinsics.checkNotNullParameter(alignment$Vertical, "alignment");
            return new SpacedAligned(f, false, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$spacedBy$2
                {
                    super(2);
                }

                @NotNull
                public final Integer invoke(int i, @NotNull LayoutDirection layoutDirection) {
                    Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 1>");
                    return Integer.valueOf(Alignment$Vertical.this.align(0, i));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return invoke(((Number) obj).intValue(), (LayoutDirection) obj2);
                }
            }, null);
        }
    }

    /* compiled from: Taobao */
    @Stable
    public interface HorizontalOrVertical extends Horizontal, Vertical {
        /* renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
        float mo193getSpacingD9Ej5fM();
    }

    private Arrangement() {
    }

    private final void forEachIndexed(int[] iArr, boolean z, Function2<? super Integer, ? super Integer, Unit> function2) {
        if (!z) {
            int length = iArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                function2.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i]));
                i++;
                i2++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            } else {
                function2.invoke(Integer.valueOf(length2), Integer.valueOf(iArr[length2]));
            }
        }
    }

    @Stable
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Stable
    public static /* synthetic */ void getCenter$annotations() {
    }

    @Stable
    public static /* synthetic */ void getEnd$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpaceAround$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpaceBetween$annotations() {
    }

    @Stable
    public static /* synthetic */ void getSpaceEvenly$annotations() {
    }

    @Stable
    public static /* synthetic */ void getStart$annotations() {
    }

    @Stable
    public static /* synthetic */ void getTop$annotations() {
    }

    @Stable
    @NotNull
    public final Horizontal aligned(@NotNull Alignment$Horizontal alignment$Horizontal) {
        Intrinsics.checkNotNullParameter(alignment$Horizontal, "alignment");
        return new SpacedAligned(Dp.m2142constructorimpl(0), true, new aligned.1(alignment$Horizontal), null);
    }

    @NotNull
    public final Vertical getBottom() {
        return Bottom;
    }

    @NotNull
    public final HorizontalOrVertical getCenter() {
        return Center;
    }

    @NotNull
    public final Horizontal getEnd() {
        return End;
    }

    @NotNull
    public final HorizontalOrVertical getSpaceAround() {
        return SpaceAround;
    }

    @NotNull
    public final HorizontalOrVertical getSpaceBetween() {
        return SpaceBetween;
    }

    @NotNull
    public final HorizontalOrVertical getSpaceEvenly() {
        return SpaceEvenly;
    }

    @NotNull
    public final Horizontal getStart() {
        return Start;
    }

    @NotNull
    public final Vertical getTop() {
        return Top;
    }

    public final void placeCenter$foundation_layout_release(int i, @NotNull int[] iArr, @NotNull int[] iArr2, boolean z) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float f = (i - i3) / 2;
        if (!z) {
            int length = iArr.length;
            int i5 = 0;
            while (i2 < length) {
                int i6 = iArr[i2];
                iArr2[i5] = MathKt.roundToInt(f);
                f += i6;
                i2++;
                i5++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i7 = iArr[length2];
            iArr2[length2] = MathKt.roundToInt(f);
            f += i7;
        }
    }

    public final void placeLeftOrTop$foundation_layout_release(@NotNull int[] iArr, @NotNull int[] iArr2, boolean z) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int i = 0;
        if (!z) {
            int length = iArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i < length) {
                int i4 = iArr[i];
                iArr2[i2] = i3;
                i3 += i4;
                i++;
                i2++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i5 = iArr[length2];
            iArr2[length2] = i;
            i += i5;
        }
    }

    public final void placeRightOrBottom$foundation_layout_release(int i, @NotNull int[] iArr, @NotNull int[] iArr2, boolean z) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        int i5 = i - i3;
        if (!z) {
            int length = iArr.length;
            int i6 = 0;
            while (i2 < length) {
                int i7 = iArr[i2];
                iArr2[i6] = i5;
                i5 += i7;
                i2++;
                i6++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i8 = iArr[length2];
            iArr2[length2] = i5;
            i5 += i8;
        }
    }

    public final void placeSpaceAround$foundation_layout_release(int i, @NotNull int[] iArr, @NotNull int[] iArr2, boolean z) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float length = (iArr.length == 0) ^ true ? (i - i3) / iArr.length : 0.0f;
        float f = length / 2;
        if (z) {
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i5 = iArr[length2];
                iArr2[length2] = MathKt.roundToInt(f);
                f += i5 + length;
            }
            return;
        }
        int length3 = iArr.length;
        int i6 = 0;
        while (i2 < length3) {
            int i7 = iArr[i2];
            iArr2[i6] = MathKt.roundToInt(f);
            f += i7 + length;
            i2++;
            i6++;
        }
    }

    public final void placeSpaceBetween$foundation_layout_release(int i, @NotNull int[] iArr, @NotNull int[] iArr2, boolean z) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float f = 0.0f;
        float length = iArr.length > 1 ? (i - i3) / (iArr.length - 1) : 0.0f;
        if (z) {
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i5 = iArr[length2];
                iArr2[length2] = MathKt.roundToInt(f);
                f += i5 + length;
            }
            return;
        }
        int length3 = iArr.length;
        int i6 = 0;
        while (i2 < length3) {
            int i7 = iArr[i2];
            iArr2[i6] = MathKt.roundToInt(f);
            f += i7 + length;
            i2++;
            i6++;
        }
    }

    public final void placeSpaceEvenly$foundation_layout_release(int i, @NotNull int[] iArr, @NotNull int[] iArr2, boolean z) {
        Intrinsics.checkNotNullParameter(iArr, "size");
        Intrinsics.checkNotNullParameter(iArr2, "outPosition");
        int i2 = 0;
        int i3 = 0;
        for (int i4 : iArr) {
            i3 += i4;
        }
        float length = (i - i3) / (iArr.length + 1);
        if (z) {
            float f = length;
            for (int length2 = iArr.length - 1; -1 < length2; length2--) {
                int i5 = iArr[length2];
                iArr2[length2] = MathKt.roundToInt(f);
                f += i5 + length;
            }
            return;
        }
        int length3 = iArr.length;
        float f2 = length;
        int i6 = 0;
        while (i2 < length3) {
            int i7 = iArr[i2];
            iArr2[i6] = MathKt.roundToInt(f2);
            f2 += i7 + length;
            i2++;
            i6++;
        }
    }

    @Stable
    @NotNull
    /* renamed from: spacedBy-0680j_4, reason: not valid java name */
    public final HorizontalOrVertical m185spacedBy0680j_4(float f) {
        return new SpacedAligned(f, true, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).intValue(), (LayoutDirection) obj2);
            }

            @NotNull
            public final Integer invoke(int i, @NotNull LayoutDirection layoutDirection) {
                Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                return Integer.valueOf(Alignment.Companion.getStart().align(0, i, layoutDirection));
            }
        }, null);
    }

    @Stable
    @NotNull
    /* renamed from: spacedBy-D5KLDUw, reason: not valid java name */
    public final Horizontal m186spacedByD5KLDUw(float f, @NotNull final Alignment$Horizontal alignment$Horizontal) {
        Intrinsics.checkNotNullParameter(alignment$Horizontal, "alignment");
        return new SpacedAligned(f, true, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$2
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).intValue(), (LayoutDirection) obj2);
            }

            @NotNull
            public final Integer invoke(int i, @NotNull LayoutDirection layoutDirection) {
                Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                return Integer.valueOf(Alignment$Horizontal.this.align(0, i, layoutDirection));
            }
        }, null);
    }

    @Stable
    @NotNull
    /* renamed from: spacedBy-D5KLDUw, reason: not valid java name */
    public final Vertical m187spacedByD5KLDUw(float f, @NotNull final Alignment$Vertical alignment$Vertical) {
        Intrinsics.checkNotNullParameter(alignment$Vertical, "alignment");
        return new SpacedAligned(f, false, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$3
            {
                super(2);
            }

            @NotNull
            public final Integer invoke(int i, @NotNull LayoutDirection layoutDirection) {
                Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 1>");
                return Integer.valueOf(Alignment$Vertical.this.align(0, i));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).intValue(), (LayoutDirection) obj2);
            }
        }, null);
    }

    @Stable
    @NotNull
    public final Vertical aligned(@NotNull Alignment$Vertical alignment$Vertical) {
        Intrinsics.checkNotNullParameter(alignment$Vertical, "alignment");
        return new SpacedAligned(Dp.m2142constructorimpl(0), false, new aligned.2(alignment$Vertical), null);
    }

    /* compiled from: Taobao */
    @Immutable
    public static final class SpacedAligned implements HorizontalOrVertical {

        @Nullable
        private final Function2<Integer, LayoutDirection, Integer> alignment;
        private final boolean rtlMirror;
        private final float space;
        private final float spacing;

        /* JADX WARN: Multi-variable type inference failed */
        private SpacedAligned(float f, boolean z, Function2<? super Integer, ? super LayoutDirection, Integer> function2) {
            this.space = f;
            this.rtlMirror = z;
            this.alignment = function2;
            this.spacing = f;
        }

        public /* synthetic */ SpacedAligned(float f, boolean z, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, z, function2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: copy-8Feqmps$default, reason: not valid java name */
        public static /* synthetic */ SpacedAligned m194copy8Feqmps$default(SpacedAligned spacedAligned, float f, boolean z, Function2 function2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = spacedAligned.space;
            }
            if ((i & 2) != 0) {
                z = spacedAligned.rtlMirror;
            }
            if ((i & 4) != 0) {
                function2 = spacedAligned.alignment;
            }
            return spacedAligned.m196copy8Feqmps(f, z, function2);
        }

        public void arrange(@NotNull Density density, int i, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull int[] iArr2) {
            int i2;
            int i3;
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(iArr, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(iArr2, "outPositions");
            if (iArr.length == 0) {
                return;
            }
            int mo319roundToPx0680j_4 = density.mo319roundToPx0680j_4(this.space);
            boolean z = this.rtlMirror && layoutDirection == LayoutDirection.Rtl;
            Arrangement arrangement = Arrangement.INSTANCE;
            if (z) {
                i2 = 0;
                i3 = 0;
                for (int length = iArr.length - 1; -1 < length; length--) {
                    int i4 = iArr[length];
                    iArr2[length] = Math.min(i2, i - i4);
                    i3 = Math.min(mo319roundToPx0680j_4, (i - iArr2[length]) - i4);
                    i2 = iArr2[length] + i4 + i3;
                }
            } else {
                int length2 = iArr.length;
                int i5 = 0;
                i2 = 0;
                i3 = 0;
                int i6 = 0;
                while (i5 < length2) {
                    int i7 = iArr[i5];
                    iArr2[i6] = Math.min(i2, i - i7);
                    int min = Math.min(mo319roundToPx0680j_4, (i - iArr2[i6]) - i7);
                    int i8 = iArr2[i6] + i7 + min;
                    i5++;
                    i6++;
                    i3 = min;
                    i2 = i8;
                }
            }
            int i9 = i2 - i3;
            Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
            if (function2 == null || i9 >= i) {
                return;
            }
            int intValue = ((Number) function2.invoke(Integer.valueOf(i - i9), layoutDirection)).intValue();
            int length3 = iArr2.length;
            for (int i10 = 0; i10 < length3; i10++) {
                iArr2[i10] = iArr2[i10] + intValue;
            }
        }

        /* renamed from: component1-D9Ej5fM, reason: not valid java name */
        public final float m195component1D9Ej5fM() {
            return this.space;
        }

        public final boolean component2() {
            return this.rtlMirror;
        }

        @Nullable
        public final Function2<Integer, LayoutDirection, Integer> component3() {
            return this.alignment;
        }

        @NotNull
        /* renamed from: copy-8Feqmps, reason: not valid java name */
        public final SpacedAligned m196copy8Feqmps(float f, boolean z, @Nullable Function2<? super Integer, ? super LayoutDirection, Integer> function2) {
            return new SpacedAligned(f, z, function2, null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SpacedAligned)) {
                return false;
            }
            SpacedAligned spacedAligned = (SpacedAligned) obj;
            return Dp.m2147equalsimpl0(this.space, spacedAligned.space) && this.rtlMirror == spacedAligned.rtlMirror && Intrinsics.areEqual(this.alignment, spacedAligned.alignment);
        }

        @Nullable
        public final Function2<Integer, LayoutDirection, Integer> getAlignment() {
            return this.alignment;
        }

        public final boolean getRtlMirror() {
            return this.rtlMirror;
        }

        /* renamed from: getSpace-D9Ej5fM, reason: not valid java name */
        public final float m197getSpaceD9Ej5fM() {
            return this.space;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical
        /* renamed from: getSpacing-D9Ej5fM */
        public float mo193getSpacingD9Ej5fM() {
            return this.spacing;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int m2148hashCodeimpl = Dp.m2148hashCodeimpl(this.space) * 31;
            boolean z = this.rtlMirror;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (m2148hashCodeimpl + i) * 31;
            Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
            return i2 + (function2 == null ? 0 : function2.hashCode());
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.rtlMirror ? "" : "Absolute");
            sb.append("Arrangement#spacedAligned(");
            sb.append((Object) Dp.m2153toStringimpl(this.space));
            sb.append(", ");
            sb.append(this.alignment);
            sb.append(')');
            return sb.toString();
        }

        public void arrange(@NotNull Density density, int i, @NotNull int[] iArr, @NotNull int[] iArr2) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(iArr, "sizes");
            Intrinsics.checkNotNullParameter(iArr2, "outPositions");
            arrange(density, i, iArr, LayoutDirection.Ltr, iArr2);
        }
    }
}
