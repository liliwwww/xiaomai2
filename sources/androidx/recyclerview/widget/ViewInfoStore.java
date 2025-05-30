package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewInfoStore {
    private static final boolean DEBUG = false;

    @VisibleForTesting
    final SimpleArrayMap<RecyclerView$ViewHolder, InfoRecord> mLayoutHolderMap = new SimpleArrayMap<>();

    @VisibleForTesting
    final LongSparseArray<RecyclerView$ViewHolder> mOldChangedHolders = new LongSparseArray<>();

    /* compiled from: Taobao */
    interface ProcessCallback {
        void processAppeared(RecyclerView$ViewHolder recyclerView$ViewHolder, @Nullable RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2);

        void processDisappeared(RecyclerView$ViewHolder recyclerView$ViewHolder, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, @Nullable RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2);

        void processPersistent(RecyclerView$ViewHolder recyclerView$ViewHolder, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2);

        void unused(RecyclerView$ViewHolder recyclerView$ViewHolder);
    }

    ViewInfoStore() {
    }

    private RecyclerView$ItemAnimator$ItemHolderInfo popFromLayoutStep(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        InfoRecord valueAt;
        RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo;
        int indexOfKey = this.mLayoutHolderMap.indexOfKey(recyclerView$ViewHolder);
        if (indexOfKey >= 0 && (valueAt = this.mLayoutHolderMap.valueAt(indexOfKey)) != null) {
            int i2 = valueAt.flags;
            if ((i2 & i) != 0) {
                int i3 = (~i) & i2;
                valueAt.flags = i3;
                if (i == 4) {
                    recyclerView$ItemAnimator$ItemHolderInfo = valueAt.preInfo;
                } else {
                    if (i != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    recyclerView$ItemAnimator$ItemHolderInfo = valueAt.postInfo;
                }
                if ((i3 & 12) == 0) {
                    this.mLayoutHolderMap.removeAt(indexOfKey);
                    InfoRecord.recycle(valueAt);
                }
                return recyclerView$ItemAnimator$ItemHolderInfo;
            }
        }
        return null;
    }

    void addToAppearedInPreLayoutHolders(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.obtain();
            this.mLayoutHolderMap.put(recyclerView$ViewHolder, infoRecord);
        }
        infoRecord.flags |= 2;
        infoRecord.preInfo = recyclerView$ItemAnimator$ItemHolderInfo;
    }

    void addToDisappearedInLayout(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.obtain();
            this.mLayoutHolderMap.put(recyclerView$ViewHolder, infoRecord);
        }
        infoRecord.flags |= 1;
    }

    void addToOldChangeHolders(long j, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        this.mOldChangedHolders.put(j, recyclerView$ViewHolder);
    }

    void addToPostLayout(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.obtain();
            this.mLayoutHolderMap.put(recyclerView$ViewHolder, infoRecord);
        }
        infoRecord.postInfo = recyclerView$ItemAnimator$ItemHolderInfo;
        infoRecord.flags |= 8;
    }

    void addToPreLayout(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (infoRecord == null) {
            infoRecord = InfoRecord.obtain();
            this.mLayoutHolderMap.put(recyclerView$ViewHolder, infoRecord);
        }
        infoRecord.preInfo = recyclerView$ItemAnimator$ItemHolderInfo;
        infoRecord.flags |= 4;
    }

    void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.clear();
    }

    RecyclerView$ViewHolder getFromOldChangeHolders(long j) {
        return this.mOldChangedHolders.get(j);
    }

    boolean isDisappearing(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        return (infoRecord == null || (infoRecord.flags & 1) == 0) ? false : true;
    }

    boolean isInPreLayout(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        return (infoRecord == null || (infoRecord.flags & 4) == 0) ? false : true;
    }

    void onDetach() {
        InfoRecord.drainCache();
    }

    public void onViewDetached(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        removeFromDisappearedInLayout(recyclerView$ViewHolder);
    }

    @Nullable
    RecyclerView$ItemAnimator$ItemHolderInfo popFromPostLayout(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return popFromLayoutStep(recyclerView$ViewHolder, 8);
    }

    @Nullable
    RecyclerView$ItemAnimator$ItemHolderInfo popFromPreLayout(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return popFromLayoutStep(recyclerView$ViewHolder, 4);
    }

    void process(ProcessCallback processCallback) {
        for (int size = this.mLayoutHolderMap.size() - 1; size >= 0; size--) {
            RecyclerView$ViewHolder keyAt = this.mLayoutHolderMap.keyAt(size);
            InfoRecord removeAt = this.mLayoutHolderMap.removeAt(size);
            int i = removeAt.flags;
            if ((i & 3) == 3) {
                processCallback.unused(keyAt);
            } else if ((i & 1) != 0) {
                RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo = removeAt.preInfo;
                if (recyclerView$ItemAnimator$ItemHolderInfo == null) {
                    processCallback.unused(keyAt);
                } else {
                    processCallback.processDisappeared(keyAt, recyclerView$ItemAnimator$ItemHolderInfo, removeAt.postInfo);
                }
            } else if ((i & 14) == 14) {
                processCallback.processAppeared(keyAt, removeAt.preInfo, removeAt.postInfo);
            } else if ((i & 12) == 12) {
                processCallback.processPersistent(keyAt, removeAt.preInfo, removeAt.postInfo);
            } else if ((i & 4) != 0) {
                processCallback.processDisappeared(keyAt, removeAt.preInfo, null);
            } else if ((i & 8) != 0) {
                processCallback.processAppeared(keyAt, removeAt.preInfo, removeAt.postInfo);
            }
            InfoRecord.recycle(removeAt);
        }
    }

    void removeFromDisappearedInLayout(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        InfoRecord infoRecord = this.mLayoutHolderMap.get(recyclerView$ViewHolder);
        if (infoRecord == null) {
            return;
        }
        infoRecord.flags &= -2;
    }

    void removeViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        int size = this.mOldChangedHolders.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            if (recyclerView$ViewHolder == this.mOldChangedHolders.valueAt(size)) {
                this.mOldChangedHolders.removeAt(size);
                break;
            }
            size--;
        }
        InfoRecord remove = this.mLayoutHolderMap.remove(recyclerView$ViewHolder);
        if (remove != null) {
            InfoRecord.recycle(remove);
        }
    }
}
