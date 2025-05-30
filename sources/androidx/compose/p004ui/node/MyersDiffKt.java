package androidx.compose.p004ui.node;

import android.taobao.windvane.connect.api.ApiConstants;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class MyersDiffKt {
    private static final void applyDiff(int i, int i2, IntStack intStack, DiffCallback diffCallback) {
        while (intStack.isNotEmpty()) {
            int pop = intStack.pop();
            int pop2 = intStack.pop();
            int pop3 = intStack.pop();
            while (i > pop3) {
                i--;
                diffCallback.remove(i);
            }
            while (i2 > pop2) {
                i2--;
                diffCallback.insert(i, i2);
            }
            while (true) {
                int i3 = pop - 1;
                if (pop > 0) {
                    i--;
                    i2--;
                    diffCallback.same(i, i2);
                    pop = i3;
                }
            }
        }
        while (i > 0) {
            i--;
            diffCallback.remove(i);
        }
        while (i2 > 0) {
            i2--;
            diffCallback.insert(i, i2);
        }
    }

    /* renamed from: backward-4l5_RBY, reason: not valid java name */
    private static final boolean m4352backward4l5_RBY(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int m4275getimpl;
        int i6;
        int i7;
        int i8 = (i2 - i) - (i4 - i3);
        boolean z = i8 % 2 == 0;
        int i9 = -i5;
        for (int i10 = i9; i10 <= i5; i10 += 2) {
            if (i10 == i9 || (i10 != i5 && CenteredArray.m4275getimpl(iArr2, i10 + 1) < CenteredArray.m4275getimpl(iArr2, i10 - 1))) {
                m4275getimpl = CenteredArray.m4275getimpl(iArr2, i10 + 1);
                i6 = m4275getimpl;
            } else {
                m4275getimpl = CenteredArray.m4275getimpl(iArr2, i10 - 1);
                i6 = m4275getimpl - 1;
            }
            int i11 = i4 - ((i2 - i6) - i10);
            int i12 = (i5 == 0 || i6 != m4275getimpl) ? i11 : i11 + 1;
            while (i6 > i && i11 > i3) {
                if (!diffCallback.areItemsTheSame(i6 - 1, i11 - 1)) {
                    break;
                }
                i6--;
                i11--;
            }
            CenteredArray.m4278setimpl(iArr2, i10, i6);
            if (z && (i7 = i8 - i10) >= i9 && i7 <= i5) {
                if (CenteredArray.m4275getimpl(iArr, i7) >= i6) {
                    fillSnake(i6, i11, m4275getimpl, i12, true, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    private static final IntStack calculateDiff(int i, int i2, DiffCallback diffCallback) {
        int i3 = ((i + i2) + 1) / 2;
        IntStack intStack = new IntStack(i3 * 3);
        IntStack intStack2 = new IntStack(i3 * 4);
        intStack2.pushRange(0, i, 0, i2);
        int i4 = (i3 * 2) + 1;
        int[] m4272constructorimpl = CenteredArray.m4272constructorimpl(new int[i4]);
        int[] m4272constructorimpl2 = CenteredArray.m4272constructorimpl(new int[i4]);
        int[] m4454constructorimpl = Snake.m4454constructorimpl(new int[5]);
        while (intStack2.isNotEmpty()) {
            int pop = intStack2.pop();
            int pop2 = intStack2.pop();
            int pop3 = intStack2.pop();
            int pop4 = intStack2.pop();
            int[] iArr = m4272constructorimpl;
            int[] iArr2 = m4272constructorimpl2;
            if (m4354midPointq5eDKzI(pop4, pop3, pop2, pop, diffCallback, m4272constructorimpl, m4272constructorimpl2, m4454constructorimpl)) {
                if (Snake.m4457getDiagonalSizeimpl(m4454constructorimpl) > 0) {
                    Snake.m4452addDiagonalToStackimpl(m4454constructorimpl, intStack);
                }
                intStack2.pushRange(pop4, Snake.m4462getStartXimpl(m4454constructorimpl), pop2, Snake.m4463getStartYimpl(m4454constructorimpl));
                intStack2.pushRange(Snake.m4458getEndXimpl(m4454constructorimpl), pop3, Snake.m4459getEndYimpl(m4454constructorimpl), pop);
            }
            m4272constructorimpl = iArr;
            m4272constructorimpl2 = iArr2;
        }
        intStack.sortDiagonals();
        intStack.pushDiagonal(i, i2, 0);
        return intStack;
    }

    public static final void executeDiff(int i, int i2, @NotNull DiffCallback diffCallback) {
        Intrinsics.checkNotNullParameter(diffCallback, "callback");
        applyDiff(i, i2, calculateDiff(i, i2, diffCallback), diffCallback);
    }

    public static final void fillSnake(int i, int i2, int i3, int i4, boolean z, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, ApiConstants.DATA);
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        iArr[4] = z ? 1 : 0;
    }

    /* renamed from: forward-4l5_RBY, reason: not valid java name */
    private static final boolean m4353forward4l5_RBY(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int m4275getimpl;
        int i6;
        int i7;
        int i8 = (i2 - i) - (i4 - i3);
        boolean z = Math.abs(i8) % 2 == 1;
        int i9 = -i5;
        for (int i10 = i9; i10 <= i5; i10 += 2) {
            if (i10 == i9 || (i10 != i5 && CenteredArray.m4275getimpl(iArr, i10 + 1) > CenteredArray.m4275getimpl(iArr, i10 - 1))) {
                m4275getimpl = CenteredArray.m4275getimpl(iArr, i10 + 1);
                i6 = m4275getimpl;
            } else {
                m4275getimpl = CenteredArray.m4275getimpl(iArr, i10 - 1);
                i6 = m4275getimpl + 1;
            }
            int i11 = (i3 + (i6 - i)) - i10;
            int i12 = (i5 == 0 || i6 != m4275getimpl) ? i11 : i11 - 1;
            while (i6 < i2 && i11 < i4) {
                if (!diffCallback.areItemsTheSame(i6, i11)) {
                    break;
                }
                i6++;
                i11++;
            }
            CenteredArray.m4278setimpl(iArr, i10, i6);
            if (z && (i7 = i8 - i10) >= i9 + 1 && i7 <= i5 - 1) {
                if (CenteredArray.m4275getimpl(iArr2, i7) <= i6) {
                    fillSnake(m4275getimpl, i12, i6, i11, false, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: midPoint-q5eDKzI, reason: not valid java name */
    private static final boolean m4354midPointq5eDKzI(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int[] iArr3) {
        int i5 = i2 - i;
        int i6 = i4 - i3;
        if (i5 >= 1 && i6 >= 1) {
            int i7 = ((i5 + i6) + 1) / 2;
            CenteredArray.m4278setimpl(iArr, 1, i);
            CenteredArray.m4278setimpl(iArr2, 1, i2);
            int i8 = 0;
            while (i8 < i7) {
                int i9 = i8;
                if (m4353forward4l5_RBY(i, i2, i3, i4, diffCallback, iArr, iArr2, i8, iArr3) || m4352backward4l5_RBY(i, i2, i3, i4, diffCallback, iArr, iArr2, i9, iArr3)) {
                    return true;
                }
                i8 = i9 + 1;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void swap(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }
}
