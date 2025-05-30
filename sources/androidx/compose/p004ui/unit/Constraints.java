package androidx.compose.p004ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import tb.c8;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: classes.dex */
public final class Constraints {
    private static final long FocusMask = 3;
    public static final int Infinity = Integer.MAX_VALUE;
    private static final int MaxFocusBits = 18;
    private static final long MaxFocusHeight = 3;
    private static final long MaxFocusWidth = 1;
    private static final int MaxNonFocusBits = 13;
    private static final int MinFocusBits = 16;
    private static final long MinFocusHeight = 2;
    private static final int MinFocusMask = 65535;
    private static final long MinFocusWidth = 0;
    private static final int MinNonFocusBits = 15;
    private final long value;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final int[] MinHeightOffsets = {18, 20, 17, 15};
    private static final int MaxFocusMask = 262143;
    private static final int MinNonFocusMask = 32767;
    private static final int MaxNonFocusMask = 8191;

    @NotNull
    private static final int[] WidthMask = {65535, MaxFocusMask, MinNonFocusMask, MaxNonFocusMask};

    @NotNull
    private static final int[] HeightMask = {MinNonFocusMask, MaxNonFocusMask, 65535, MaxFocusMask};

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int bitsNeedForSize(int i) {
            if (i < Constraints.MaxNonFocusMask) {
                return 13;
            }
            if (i < Constraints.MinNonFocusMask) {
                return 15;
            }
            if (i < 65535) {
                return 16;
            }
            if (i < Constraints.MaxFocusMask) {
                return 18;
            }
            throw new IllegalArgumentException("Can't represent a size of " + i + " in Constraints");
        }

        /* renamed from: createConstraints-Zbe2FdA$ui_unit_release, reason: not valid java name */
        public final long m5191createConstraintsZbe2FdA$ui_unit_release(int i, int i2, int i3, int i4) {
            long j;
            int i5 = i4 == Integer.MAX_VALUE ? i3 : i4;
            int bitsNeedForSize = bitsNeedForSize(i5);
            int i6 = i2 == Integer.MAX_VALUE ? i : i2;
            int bitsNeedForSize2 = bitsNeedForSize(i6);
            if (bitsNeedForSize + bitsNeedForSize2 > 31) {
                throw new IllegalArgumentException("Can't represent a width of " + i6 + " and height of " + i5 + " in Constraints");
            }
            if (bitsNeedForSize2 == 13) {
                j = 3;
            } else if (bitsNeedForSize2 == 18) {
                j = 1;
            } else if (bitsNeedForSize2 == 15) {
                j = 2;
            } else {
                if (bitsNeedForSize2 != 16) {
                    throw new IllegalStateException("Should only have the provided constants.");
                }
                j = 0;
            }
            int i7 = i2 == Integer.MAX_VALUE ? 0 : i2 + 1;
            int i8 = i4 != Integer.MAX_VALUE ? i4 + 1 : 0;
            int i9 = Constraints.MinHeightOffsets[(int) j];
            return Constraints.m5173constructorimpl((i7 << 33) | j | (i << 2) | (i3 << i9) | (i8 << (i9 + 31)));
        }

        @Stable
        /* renamed from: fixed-JhjzzOo, reason: not valid java name */
        public final long m5192fixedJhjzzOo(int i, int i2) {
            if (i >= 0 && i2 >= 0) {
                return m5191createConstraintsZbe2FdA$ui_unit_release(i, i, i2, i2);
            }
            throw new IllegalArgumentException(("width(" + i + ") and height(" + i2 + ") must be >= 0").toString());
        }

        @Stable
        /* renamed from: fixedHeight-OenEA2s, reason: not valid java name */
        public final long m5193fixedHeightOenEA2s(int i) {
            if (i >= 0) {
                return m5191createConstraintsZbe2FdA$ui_unit_release(0, Integer.MAX_VALUE, i, i);
            }
            throw new IllegalArgumentException(("height(" + i + ") must be >= 0").toString());
        }

        @Stable
        /* renamed from: fixedWidth-OenEA2s, reason: not valid java name */
        public final long m5194fixedWidthOenEA2s(int i) {
            if (i >= 0) {
                return m5191createConstraintsZbe2FdA$ui_unit_release(i, i, 0, Integer.MAX_VALUE);
            }
            throw new IllegalArgumentException(("width(" + i + ") must be >= 0").toString());
        }
    }

    private /* synthetic */ Constraints(long j) {
        this.value = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Constraints m5172boximpl(long j) {
        return new Constraints(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5173constructorimpl(long j) {
        return j;
    }

    /* renamed from: copy-Zbe2FdA, reason: not valid java name */
    public static final long m5174copyZbe2FdA(long j, int i, int i2, int i3, int i4) {
        boolean z = true;
        if (!(i3 >= 0 && i >= 0)) {
            throw new IllegalArgumentException(("minHeight(" + i3 + ") and minWidth(" + i + ") must be >= 0").toString());
        }
        if (!(i2 >= i || i2 == Integer.MAX_VALUE)) {
            throw new IllegalArgumentException(("maxWidth(" + i2 + ") must be >= minWidth(" + i + ')').toString());
        }
        if (i4 < i3 && i4 != Integer.MAX_VALUE) {
            z = false;
        }
        if (z) {
            return Companion.m5191createConstraintsZbe2FdA$ui_unit_release(i, i2, i3, i4);
        }
        throw new IllegalArgumentException(("maxHeight(" + i4 + ") must be >= minHeight(" + i3 + ')').toString());
    }

    /* renamed from: copy-Zbe2FdA$default, reason: not valid java name */
    public static /* synthetic */ long m5175copyZbe2FdA$default(long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = m5186getMinWidthimpl(j);
        }
        int i6 = i;
        if ((i5 & 2) != 0) {
            i2 = m5184getMaxWidthimpl(j);
        }
        int i7 = i2;
        if ((i5 & 4) != 0) {
            i3 = m5185getMinHeightimpl(j);
        }
        int i8 = i3;
        if ((i5 & 8) != 0) {
            i4 = m5183getMaxHeightimpl(j);
        }
        return m5174copyZbe2FdA(j, i6, i7, i8, i4);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5176equalsimpl(long j, Object obj) {
        return (obj instanceof Constraints) && j == ((Constraints) obj).m5190unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5177equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getFocusIndex-impl, reason: not valid java name */
    private static final int m5178getFocusIndeximpl(long j) {
        return (int) (j & 3);
    }

    /* renamed from: getHasBoundedHeight-impl, reason: not valid java name */
    public static final boolean m5179getHasBoundedHeightimpl(long j) {
        int m5178getFocusIndeximpl = m5178getFocusIndeximpl(j);
        return (((int) (j >> (MinHeightOffsets[m5178getFocusIndeximpl] + 31))) & HeightMask[m5178getFocusIndeximpl]) != 0;
    }

    /* renamed from: getHasBoundedWidth-impl, reason: not valid java name */
    public static final boolean m5180getHasBoundedWidthimpl(long j) {
        return (((int) (j >> 33)) & WidthMask[m5178getFocusIndeximpl(j)]) != 0;
    }

    @Stable
    public static /* synthetic */ void getHasFixedHeight$annotations() {
    }

    /* renamed from: getHasFixedHeight-impl, reason: not valid java name */
    public static final boolean m5181getHasFixedHeightimpl(long j) {
        return m5183getMaxHeightimpl(j) == m5185getMinHeightimpl(j);
    }

    @Stable
    public static /* synthetic */ void getHasFixedWidth$annotations() {
    }

    /* renamed from: getHasFixedWidth-impl, reason: not valid java name */
    public static final boolean m5182getHasFixedWidthimpl(long j) {
        return m5184getMaxWidthimpl(j) == m5186getMinWidthimpl(j);
    }

    /* renamed from: getMaxHeight-impl, reason: not valid java name */
    public static final int m5183getMaxHeightimpl(long j) {
        int m5178getFocusIndeximpl = m5178getFocusIndeximpl(j);
        int i = ((int) (j >> (MinHeightOffsets[m5178getFocusIndeximpl] + 31))) & HeightMask[m5178getFocusIndeximpl];
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        return i - 1;
    }

    /* renamed from: getMaxWidth-impl, reason: not valid java name */
    public static final int m5184getMaxWidthimpl(long j) {
        int i = ((int) (j >> 33)) & WidthMask[m5178getFocusIndeximpl(j)];
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        return i - 1;
    }

    /* renamed from: getMinHeight-impl, reason: not valid java name */
    public static final int m5185getMinHeightimpl(long j) {
        int m5178getFocusIndeximpl = m5178getFocusIndeximpl(j);
        return ((int) (j >> MinHeightOffsets[m5178getFocusIndeximpl])) & HeightMask[m5178getFocusIndeximpl];
    }

    /* renamed from: getMinWidth-impl, reason: not valid java name */
    public static final int m5186getMinWidthimpl(long j) {
        return ((int) (j >> 2)) & WidthMask[m5178getFocusIndeximpl(j)];
    }

    @PublishedApi
    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5187hashCodeimpl(long j) {
        return c8.a(j);
    }

    @Stable
    public static /* synthetic */ void isZero$annotations() {
    }

    /* renamed from: isZero-impl, reason: not valid java name */
    public static final boolean m5188isZeroimpl(long j) {
        return m5184getMaxWidthimpl(j) == 0 || m5183getMaxHeightimpl(j) == 0;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5189toStringimpl(long j) {
        int m5184getMaxWidthimpl = m5184getMaxWidthimpl(j);
        String valueOf = m5184getMaxWidthimpl == Integer.MAX_VALUE ? "Infinity" : String.valueOf(m5184getMaxWidthimpl);
        int m5183getMaxHeightimpl = m5183getMaxHeightimpl(j);
        return "Constraints(minWidth = " + m5186getMinWidthimpl(j) + ", maxWidth = " + valueOf + ", minHeight = " + m5185getMinHeightimpl(j) + ", maxHeight = " + (m5183getMaxHeightimpl != Integer.MAX_VALUE ? String.valueOf(m5183getMaxHeightimpl) : "Infinity") + ')';
    }

    public boolean equals(Object obj) {
        return m5176equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m5187hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m5189toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m5190unboximpl() {
        return this.value;
    }
}
