package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class DiffUtil {
    private static final Comparator<Diagonal> DIAGONAL_COMPARATOR = new Comparator<Diagonal>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.x - diagonal2.x;
        }
    };

    /* compiled from: Taobao */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i, int i2);

        public abstract boolean areItemsTheSame(int i, int i2);

        @Nullable
        public Object getChangePayload(int i, int i2) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* compiled from: Taobao */
    static class Diagonal {
        public final int size;
        public final int x;
        public final int y;

        Diagonal(int i, int i2, int i3) {
            this.x = i;
            this.y = i2;
            this.size = i3;
        }

        int endX() {
            return this.x + this.size;
        }

        int endY() {
            return this.y + this.size;
        }
    }

    /* compiled from: Taobao */
    private static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        PostponedUpdate(int i, int i2, boolean z) {
            this.posInOwnerList = i;
            this.currentPos = i2;
            this.removal = z;
        }
    }

    /* compiled from: Taobao */
    static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        int newSize() {
            return this.newListEnd - this.newListStart;
        }

        int oldSize() {
            return this.oldListEnd - this.oldListStart;
        }

        public Range(int i, int i2, int i3, int i4) {
            this.oldListStart = i;
            this.oldListEnd = i2;
            this.newListStart = i3;
            this.newListEnd = i4;
        }
    }

    /* compiled from: Taobao */
    static class Snake {
        public int endX;
        public int endY;
        public boolean reverse;
        public int startX;
        public int startY;

        Snake() {
        }

        int diagonalSize() {
            return Math.min(this.endX - this.startX, this.endY - this.startY);
        }

        boolean hasAdditionOrRemoval() {
            return this.endY - this.startY != this.endX - this.startX;
        }

        boolean isAddition() {
            return this.endY - this.startY > this.endX - this.startX;
        }

        @NonNull
        Diagonal toDiagonal() {
            if (hasAdditionOrRemoval()) {
                return this.reverse ? new Diagonal(this.startX, this.startY, diagonalSize()) : isAddition() ? new Diagonal(this.startX, this.startY + 1, diagonalSize()) : new Diagonal(this.startX + 1, this.startY, diagonalSize());
            }
            int i = this.startX;
            return new Diagonal(i, this.startY, this.endX - i);
        }
    }

    private DiffUtil() {
    }

    @Nullable
    private static Snake backward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i) {
        int i2;
        int i3;
        int i4;
        boolean z = (range.oldSize() - range.newSize()) % 2 == 0;
        int oldSize = range.oldSize() - range.newSize();
        int i5 = -i;
        for (int i6 = i5; i6 <= i; i6 += 2) {
            if (i6 == i5 || (i6 != i && centeredArray2.get(i6 + 1) < centeredArray2.get(i6 - 1))) {
                i2 = centeredArray2.get(i6 + 1);
                i3 = i2;
            } else {
                i2 = centeredArray2.get(i6 - 1);
                i3 = i2 - 1;
            }
            int i7 = range.newListEnd - ((range.oldListEnd - i3) - i6);
            int i8 = (i == 0 || i3 != i2) ? i7 : i7 + 1;
            while (i3 > range.oldListStart && i7 > range.newListStart && callback.areItemsTheSame(i3 - 1, i7 - 1)) {
                i3--;
                i7--;
            }
            centeredArray2.set(i6, i3);
            if (z && (i4 = oldSize - i6) >= i5 && i4 <= i && centeredArray.get(i4) >= i3) {
                Snake snake = new Snake();
                snake.startX = i3;
                snake.startY = i7;
                snake.endX = i2;
                snake.endY = i8;
                snake.reverse = true;
                return snake;
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    @Nullable
    private static Snake forward(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i) {
        int i2;
        int i3;
        int i4;
        boolean z = Math.abs(range.oldSize() - range.newSize()) % 2 == 1;
        int oldSize = range.oldSize() - range.newSize();
        int i5 = -i;
        for (int i6 = i5; i6 <= i; i6 += 2) {
            if (i6 == i5 || (i6 != i && centeredArray.get(i6 + 1) > centeredArray.get(i6 - 1))) {
                i2 = centeredArray.get(i6 + 1);
                i3 = i2;
            } else {
                i2 = centeredArray.get(i6 - 1);
                i3 = i2 + 1;
            }
            int i7 = (range.newListStart + (i3 - range.oldListStart)) - i6;
            int i8 = (i == 0 || i3 != i2) ? i7 : i7 - 1;
            while (i3 < range.oldListEnd && i7 < range.newListEnd && callback.areItemsTheSame(i3, i7)) {
                i3++;
                i7++;
            }
            centeredArray.set(i6, i3);
            if (z && (i4 = oldSize - i6) >= i5 + 1 && i4 <= i - 1 && centeredArray2.get(i4) <= i3) {
                Snake snake = new Snake();
                snake.startX = i2;
                snake.startY = i8;
                snake.endX = i3;
                snake.endY = i7;
                snake.reverse = false;
                return snake;
            }
        }
        return null;
    }

    @Nullable
    private static Snake midPoint(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.oldSize() >= 1 && range.newSize() >= 1) {
            int oldSize = ((range.oldSize() + range.newSize()) + 1) / 2;
            centeredArray.set(1, range.oldListStart);
            centeredArray2.set(1, range.oldListEnd);
            for (int i = 0; i < oldSize; i++) {
                Snake forward = forward(range, callback, centeredArray, centeredArray2, i);
                if (forward != null) {
                    return forward;
                }
                Snake backward = backward(range, callback, centeredArray, centeredArray2, i);
                if (backward != null) {
                    return backward;
                }
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i);
        CenteredArray centeredArray2 = new CenteredArray(i);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake midPoint = midPoint(range, callback, centeredArray, centeredArray2);
            if (midPoint != null) {
                if (midPoint.diagonalSize() > 0) {
                    arrayList.add(midPoint.toDiagonal());
                }
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                range2.oldListEnd = midPoint.startX;
                range2.newListEnd = midPoint.startY;
                arrayList2.add(range2);
                range.oldListEnd = range.oldListEnd;
                range.newListEnd = range.newListEnd;
                range.oldListStart = midPoint.endX;
                range.newListStart = midPoint.endY;
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, DIAGONAL_COMPARATOR);
        return new DiffResult(callback, arrayList, centeredArray.backingData(), centeredArray2.backingData(), z);
    }
}
