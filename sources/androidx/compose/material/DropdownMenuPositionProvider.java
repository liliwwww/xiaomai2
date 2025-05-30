package androidx.compose.material;

import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DpOffset;
import androidx.compose.p004ui.unit.IntOffsetKt;
import androidx.compose.p004ui.unit.IntRect;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.p004ui.window.PopupPositionProvider;
import androidx.compose.runtime.Immutable;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes2.dex */
public final class DropdownMenuPositionProvider implements PopupPositionProvider {
    private final long contentOffset;

    @NotNull
    private final Density density;

    @NotNull
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;

    /* JADX WARN: Multi-variable type inference failed */
    private DropdownMenuPositionProvider(long j, Density density, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        this.contentOffset = j;
        this.density = density;
        this.onPositionCalculated = function2;
    }

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-rOJDEFc$default, reason: not valid java name */
    public static /* synthetic */ DropdownMenuPositionProvider m2088copyrOJDEFc$default(DropdownMenuPositionProvider dropdownMenuPositionProvider, long j, Density density, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = dropdownMenuPositionProvider.contentOffset;
        }
        if ((i & 2) != 0) {
            density = dropdownMenuPositionProvider.density;
        }
        if ((i & 4) != 0) {
            function2 = dropdownMenuPositionProvider.onPositionCalculated;
        }
        return dropdownMenuPositionProvider.m2090copyrOJDEFc(j, density, function2);
    }

    @Override // androidx.compose.p004ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4 */
    public long mo1824calculatePositionllwVHH4(@NotNull IntRect intRect, long j, @NotNull LayoutDirection layoutDirection, long j2) {
        Sequence sequenceOf;
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(intRect, "anchorBounds");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        int mo1277roundToPx0680j_4 = this.density.mo1277roundToPx0680j_4(MenuKt.getMenuVerticalMargin());
        int mo1277roundToPx0680j_42 = this.density.mo1277roundToPx0680j_4(DpOffset.m5277getXD9Ej5fM(this.contentOffset));
        int mo1277roundToPx0680j_43 = this.density.mo1277roundToPx0680j_4(DpOffset.m5279getYD9Ej5fM(this.contentOffset));
        int left = intRect.getLeft() + mo1277roundToPx0680j_42;
        int right = (intRect.getRight() - mo1277roundToPx0680j_42) - IntSize.m5376getWidthimpl(j2);
        int m5376getWidthimpl = IntSize.m5376getWidthimpl(j) - IntSize.m5376getWidthimpl(j2);
        if (layoutDirection == LayoutDirection.Ltr) {
            Integer[] numArr = new Integer[3];
            numArr[0] = Integer.valueOf(left);
            numArr[1] = Integer.valueOf(right);
            if (intRect.getLeft() < 0) {
                m5376getWidthimpl = 0;
            }
            numArr[2] = Integer.valueOf(m5376getWidthimpl);
            sequenceOf = SequencesKt.sequenceOf(numArr);
        } else {
            Integer[] numArr2 = new Integer[3];
            numArr2[0] = Integer.valueOf(right);
            numArr2[1] = Integer.valueOf(left);
            if (intRect.getRight() <= IntSize.m5376getWidthimpl(j)) {
                m5376getWidthimpl = 0;
            }
            numArr2[2] = Integer.valueOf(m5376getWidthimpl);
            sequenceOf = SequencesKt.sequenceOf(numArr2);
        }
        Iterator it = sequenceOf.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            int intValue = ((Number) obj2).intValue();
            if (intValue >= 0 && intValue + IntSize.m5376getWidthimpl(j2) <= IntSize.m5376getWidthimpl(j)) {
                break;
            }
        }
        Integer num = (Integer) obj2;
        if (num != null) {
            right = num.intValue();
        }
        int max = Math.max(intRect.getBottom() + mo1277roundToPx0680j_43, mo1277roundToPx0680j_4);
        int top = (intRect.getTop() - mo1277roundToPx0680j_43) - IntSize.m5375getHeightimpl(j2);
        Iterator it2 = SequencesKt.sequenceOf(new Integer[]{Integer.valueOf(max), Integer.valueOf(top), Integer.valueOf(intRect.getTop() - (IntSize.m5375getHeightimpl(j2) / 2)), Integer.valueOf((IntSize.m5375getHeightimpl(j) - IntSize.m5375getHeightimpl(j2)) - mo1277roundToPx0680j_4)}).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            int intValue2 = ((Number) next).intValue();
            if (intValue2 >= mo1277roundToPx0680j_4 && intValue2 + IntSize.m5375getHeightimpl(j2) <= IntSize.m5375getHeightimpl(j) - mo1277roundToPx0680j_4) {
                obj = next;
                break;
            }
        }
        Integer num2 = (Integer) obj;
        if (num2 != null) {
            top = num2.intValue();
        }
        this.onPositionCalculated.invoke(intRect, new IntRect(right, top, IntSize.m5376getWidthimpl(j2) + right, IntSize.m5375getHeightimpl(j2) + top));
        return IntOffsetKt.IntOffset(right, top);
    }

    /* renamed from: component1-RKDOV3M, reason: not valid java name */
    public final long m2089component1RKDOV3M() {
        return this.contentOffset;
    }

    @NotNull
    public final Density component2() {
        return this.density;
    }

    @NotNull
    public final Function2<IntRect, IntRect, Unit> component3() {
        return this.onPositionCalculated;
    }

    @NotNull
    /* renamed from: copy-rOJDEFc, reason: not valid java name */
    public final DropdownMenuPositionProvider m2090copyrOJDEFc(long j, @NotNull Density density, @NotNull Function2<? super IntRect, ? super IntRect, Unit> function2) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(function2, "onPositionCalculated");
        return new DropdownMenuPositionProvider(j, density, function2, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) obj;
        return DpOffset.m5276equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && Intrinsics.areEqual(this.density, dropdownMenuPositionProvider.density) && Intrinsics.areEqual(this.onPositionCalculated, dropdownMenuPositionProvider.onPositionCalculated);
    }

    /* renamed from: getContentOffset-RKDOV3M, reason: not valid java name */
    public final long m2091getContentOffsetRKDOV3M() {
        return this.contentOffset;
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final Function2<IntRect, IntRect, Unit> getOnPositionCalculated() {
        return this.onPositionCalculated;
    }

    public int hashCode() {
        return (((DpOffset.m5281hashCodeimpl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + this.onPositionCalculated.hashCode();
    }

    @NotNull
    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.m5284toStringimpl(this.contentOffset)) + ", density=" + this.density + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }

    public /* synthetic */ DropdownMenuPositionProvider(long j, Density density, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, density, (i & 4) != 0 ? new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.DropdownMenuPositionProvider.1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((IntRect) obj, (IntRect) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull IntRect intRect, @NotNull IntRect intRect2) {
                Intrinsics.checkNotNullParameter(intRect, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(intRect2, "<anonymous parameter 1>");
            }
        } : function2, null);
    }
}
