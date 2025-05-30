package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class DiffUtil$DiffResult {
    private static final int FLAG_CHANGED = 2;
    private static final int FLAG_MASK = 15;
    private static final int FLAG_MOVED = 12;
    private static final int FLAG_MOVED_CHANGED = 4;
    private static final int FLAG_MOVED_NOT_CHANGED = 8;
    private static final int FLAG_NOT_CHANGED = 1;
    private static final int FLAG_OFFSET = 4;
    public static final int NO_POSITION = -1;
    private final DiffUtil.Callback mCallback;
    private final boolean mDetectMoves;
    private final List<DiffUtil.Diagonal> mDiagonals;
    private final int[] mNewItemStatuses;
    private final int mNewListSize;
    private final int[] mOldItemStatuses;
    private final int mOldListSize;

    DiffUtil$DiffResult(DiffUtil.Callback callback, List<DiffUtil.Diagonal> list, int[] iArr, int[] iArr2, boolean z) {
        this.mDiagonals = list;
        this.mOldItemStatuses = iArr;
        this.mNewItemStatuses = iArr2;
        Arrays.fill(iArr, 0);
        Arrays.fill(iArr2, 0);
        this.mCallback = callback;
        this.mOldListSize = callback.getOldListSize();
        this.mNewListSize = callback.getNewListSize();
        this.mDetectMoves = z;
        addEdgeDiagonals();
        findMatchingItems();
    }

    private void addEdgeDiagonals() {
        DiffUtil.Diagonal diagonal = this.mDiagonals.isEmpty() ? null : this.mDiagonals.get(0);
        if (diagonal == null || diagonal.x != 0 || diagonal.y != 0) {
            this.mDiagonals.add(0, new DiffUtil.Diagonal(0, 0, 0));
        }
        this.mDiagonals.add(new DiffUtil.Diagonal(this.mOldListSize, this.mNewListSize, 0));
    }

    private void findMatchingAddition(int i) {
        int size = this.mDiagonals.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            DiffUtil.Diagonal diagonal = this.mDiagonals.get(i3);
            while (i2 < diagonal.y) {
                if (this.mNewItemStatuses[i2] == 0 && this.mCallback.areItemsTheSame(i, i2)) {
                    int i4 = this.mCallback.areContentsTheSame(i, i2) ? 8 : 4;
                    this.mOldItemStatuses[i] = (i2 << 4) | i4;
                    this.mNewItemStatuses[i2] = (i << 4) | i4;
                    return;
                }
                i2++;
            }
            i2 = diagonal.endY();
        }
    }

    private void findMatchingItems() {
        for (DiffUtil.Diagonal diagonal : this.mDiagonals) {
            for (int i = 0; i < diagonal.size; i++) {
                int i2 = diagonal.x + i;
                int i3 = diagonal.y + i;
                int i4 = this.mCallback.areContentsTheSame(i2, i3) ? 1 : 2;
                this.mOldItemStatuses[i2] = (i3 << 4) | i4;
                this.mNewItemStatuses[i3] = (i2 << 4) | i4;
            }
        }
        if (this.mDetectMoves) {
            findMoveMatches();
        }
    }

    private void findMoveMatches() {
        int i = 0;
        for (DiffUtil.Diagonal diagonal : this.mDiagonals) {
            while (i < diagonal.x) {
                if (this.mOldItemStatuses[i] == 0) {
                    findMatchingAddition(i);
                }
                i++;
            }
            i = diagonal.endX();
        }
    }

    @Nullable
    private static DiffUtil.PostponedUpdate getPostponedUpdate(Collection<DiffUtil.PostponedUpdate> collection, int i, boolean z) {
        DiffUtil.PostponedUpdate postponedUpdate;
        Iterator<DiffUtil.PostponedUpdate> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                postponedUpdate = null;
                break;
            }
            postponedUpdate = it.next();
            if (postponedUpdate.posInOwnerList == i && postponedUpdate.removal == z) {
                it.remove();
                break;
            }
        }
        while (it.hasNext()) {
            DiffUtil.PostponedUpdate next = it.next();
            if (z) {
                next.currentPos--;
            } else {
                next.currentPos++;
            }
        }
        return postponedUpdate;
    }

    public int convertNewPositionToOld(@IntRange(from = 0) int i) {
        if (i >= 0 && i < this.mNewListSize) {
            int i2 = this.mNewItemStatuses[i];
            if ((i2 & 15) == 0) {
                return -1;
            }
            return i2 >> 4;
        }
        throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", new list size = " + this.mNewListSize);
    }

    public int convertOldPositionToNew(@IntRange(from = 0) int i) {
        if (i >= 0 && i < this.mOldListSize) {
            int i2 = this.mOldItemStatuses[i];
            if ((i2 & 15) == 0) {
                return -1;
            }
            return i2 >> 4;
        }
        throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i + ", old list size = " + this.mOldListSize);
    }

    public void dispatchUpdatesTo(@NonNull RecyclerView$Adapter recyclerView$Adapter) {
        dispatchUpdatesTo(new AdapterListUpdateCallback(recyclerView$Adapter));
    }

    public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
        int i;
        BatchingListUpdateCallback batchingListUpdateCallback = listUpdateCallback instanceof BatchingListUpdateCallback ? (BatchingListUpdateCallback) listUpdateCallback : new BatchingListUpdateCallback(listUpdateCallback);
        int i2 = this.mOldListSize;
        ArrayDeque arrayDeque = new ArrayDeque();
        int i3 = this.mOldListSize;
        int i4 = this.mNewListSize;
        for (int size = this.mDiagonals.size() - 1; size >= 0; size--) {
            DiffUtil.Diagonal diagonal = this.mDiagonals.get(size);
            int endX = diagonal.endX();
            int endY = diagonal.endY();
            while (true) {
                if (i3 <= endX) {
                    break;
                }
                i3--;
                int i5 = this.mOldItemStatuses[i3];
                if ((i5 & 12) != 0) {
                    int i6 = i5 >> 4;
                    DiffUtil.PostponedUpdate postponedUpdate = getPostponedUpdate(arrayDeque, i6, false);
                    if (postponedUpdate != null) {
                        int i7 = (i2 - postponedUpdate.currentPos) - 1;
                        batchingListUpdateCallback.onMoved(i3, i7);
                        if ((i5 & 4) != 0) {
                            batchingListUpdateCallback.onChanged(i7, 1, this.mCallback.getChangePayload(i3, i6));
                        }
                    } else {
                        arrayDeque.add(new DiffUtil.PostponedUpdate(i3, (i2 - i3) - 1, true));
                    }
                } else {
                    batchingListUpdateCallback.onRemoved(i3, 1);
                    i2--;
                }
            }
            while (i4 > endY) {
                i4--;
                int i8 = this.mNewItemStatuses[i4];
                if ((i8 & 12) != 0) {
                    int i9 = i8 >> 4;
                    DiffUtil.PostponedUpdate postponedUpdate2 = getPostponedUpdate(arrayDeque, i9, true);
                    if (postponedUpdate2 == null) {
                        arrayDeque.add(new DiffUtil.PostponedUpdate(i4, i2 - i3, false));
                    } else {
                        batchingListUpdateCallback.onMoved((i2 - postponedUpdate2.currentPos) - 1, i3);
                        if ((i8 & 4) != 0) {
                            batchingListUpdateCallback.onChanged(i3, 1, this.mCallback.getChangePayload(i9, i4));
                        }
                    }
                } else {
                    batchingListUpdateCallback.onInserted(i3, 1);
                    i2++;
                }
            }
            int i10 = diagonal.x;
            int i11 = diagonal.y;
            for (i = 0; i < diagonal.size; i++) {
                if ((this.mOldItemStatuses[i10] & 15) == 2) {
                    batchingListUpdateCallback.onChanged(i10, 1, this.mCallback.getChangePayload(i10, i11));
                }
                i10++;
                i11++;
            }
            i3 = diagonal.x;
            i4 = diagonal.y;
        }
        batchingListUpdateCallback.dispatchLastEvent();
    }
}
