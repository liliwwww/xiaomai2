package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class RecyclerView$Recycler {
    static final int DEFAULT_CACHE_SIZE = 2;
    final ArrayList<RecyclerView$ViewHolder> mAttachedScrap;
    final ArrayList<RecyclerView$ViewHolder> mCachedViews;
    ArrayList<RecyclerView$ViewHolder> mChangedScrap;
    RecyclerView$RecycledViewPool mRecyclerPool;
    private int mRequestedCacheMax;
    private final List<RecyclerView$ViewHolder> mUnmodifiableAttachedScrap;
    private RecyclerView.ViewCacheExtension mViewCacheExtension;
    int mViewCacheMax;
    final /* synthetic */ RecyclerView this$0;

    public RecyclerView$Recycler(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
        ArrayList<RecyclerView$ViewHolder> arrayList = new ArrayList<>();
        this.mAttachedScrap = arrayList;
        this.mChangedScrap = null;
        this.mCachedViews = new ArrayList<>();
        this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(arrayList);
        this.mRequestedCacheMax = 2;
        this.mViewCacheMax = 2;
    }

    private void attachAccessibilityDelegateOnBind(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        if (this.this$0.isAccessibilityEnabled()) {
            View view = recyclerView$ViewHolder.itemView;
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
            }
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = this.this$0.mAccessibilityDelegate;
            if (recyclerViewAccessibilityDelegate == null) {
                return;
            }
            AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
            if (itemDelegate instanceof RecyclerViewAccessibilityDelegate$ItemDelegate) {
                ((RecyclerViewAccessibilityDelegate$ItemDelegate) itemDelegate).saveOriginalDelegate(view);
            }
            ViewCompat.setAccessibilityDelegate(view, itemDelegate);
        }
    }

    private void invalidateDisplayListInt(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        View view = recyclerView$ViewHolder.itemView;
        if (view instanceof ViewGroup) {
            invalidateDisplayListInt((ViewGroup) view, false);
        }
    }

    private boolean tryBindViewHolderByDeadline(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, int i, int i2, long j) {
        recyclerView$ViewHolder.mBindingAdapter = null;
        recyclerView$ViewHolder.mOwnerRecyclerView = this.this$0;
        int itemViewType = recyclerView$ViewHolder.getItemViewType();
        long nanoTime = this.this$0.getNanoTime();
        if (j != Long.MAX_VALUE && !this.mRecyclerPool.willBindInTime(itemViewType, nanoTime, j)) {
            return false;
        }
        this.this$0.mAdapter.bindViewHolder(recyclerView$ViewHolder, i);
        this.mRecyclerPool.factorInBindTime(recyclerView$ViewHolder.getItemViewType(), this.this$0.getNanoTime() - nanoTime);
        attachAccessibilityDelegateOnBind(recyclerView$ViewHolder);
        if (!this.this$0.mState.isPreLayout()) {
            return true;
        }
        recyclerView$ViewHolder.mPreLayoutPosition = i2;
        return true;
    }

    void addViewHolderToRecycledViewPool(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, boolean z) {
        RecyclerView.clearNestedRecyclerViewIfNotNested(recyclerView$ViewHolder);
        View view = recyclerView$ViewHolder.itemView;
        RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = this.this$0.mAccessibilityDelegate;
        if (recyclerViewAccessibilityDelegate != null) {
            AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
            ViewCompat.setAccessibilityDelegate(view, itemDelegate instanceof RecyclerViewAccessibilityDelegate$ItemDelegate ? ((RecyclerViewAccessibilityDelegate$ItemDelegate) itemDelegate).getAndRemoveOriginalDelegateForItem(view) : null);
        }
        if (z) {
            dispatchViewRecycled(recyclerView$ViewHolder);
        }
        recyclerView$ViewHolder.mBindingAdapter = null;
        recyclerView$ViewHolder.mOwnerRecyclerView = null;
        getRecycledViewPool().putRecycledView(recyclerView$ViewHolder);
    }

    public void bindViewToPosition(@NonNull View view, int i) {
        RecyclerView$LayoutParams recyclerView$LayoutParams;
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt == null) {
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + this.this$0.exceptionLabel());
        }
        int findPositionOffset = this.this$0.mAdapterHelper.findPositionOffset(i);
        if (findPositionOffset < 0 || findPositionOffset >= this.this$0.mAdapter.getItemCount()) {
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + findPositionOffset + ").state:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
        }
        tryBindViewHolderByDeadline(childViewHolderInt, findPositionOffset, i, Long.MAX_VALUE);
        ViewGroup.LayoutParams layoutParams = childViewHolderInt.itemView.getLayoutParams();
        if (layoutParams == null) {
            recyclerView$LayoutParams = (RecyclerView$LayoutParams) this.this$0.generateDefaultLayoutParams();
            childViewHolderInt.itemView.setLayoutParams(recyclerView$LayoutParams);
        } else if (this.this$0.checkLayoutParams(layoutParams)) {
            recyclerView$LayoutParams = (RecyclerView$LayoutParams) layoutParams;
        } else {
            recyclerView$LayoutParams = (RecyclerView$LayoutParams) this.this$0.generateLayoutParams(layoutParams);
            childViewHolderInt.itemView.setLayoutParams(recyclerView$LayoutParams);
        }
        recyclerView$LayoutParams.mInsetsDirty = true;
        recyclerView$LayoutParams.mViewHolder = childViewHolderInt;
        recyclerView$LayoutParams.mPendingInvalidate = childViewHolderInt.itemView.getParent() == null;
    }

    public void clear() {
        this.mAttachedScrap.clear();
        recycleAndClearCachedViews();
    }

    void clearOldPositions() {
        int size = this.mCachedViews.size();
        for (int i = 0; i < size; i++) {
            this.mCachedViews.get(i).clearOldPosition();
        }
        int size2 = this.mAttachedScrap.size();
        for (int i2 = 0; i2 < size2; i2++) {
            this.mAttachedScrap.get(i2).clearOldPosition();
        }
        ArrayList<RecyclerView$ViewHolder> arrayList = this.mChangedScrap;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i3 = 0; i3 < size3; i3++) {
                this.mChangedScrap.get(i3).clearOldPosition();
            }
        }
    }

    void clearScrap() {
        this.mAttachedScrap.clear();
        ArrayList<RecyclerView$ViewHolder> arrayList = this.mChangedScrap;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public int convertPreLayoutPositionToPostLayout(int i) {
        if (i >= 0 && i < this.this$0.mState.getItemCount()) {
            return !this.this$0.mState.isPreLayout() ? i : this.this$0.mAdapterHelper.findPositionOffset(i);
        }
        throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
    }

    void dispatchViewRecycled(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder) {
        RecyclerView$RecyclerListener recyclerView$RecyclerListener = this.this$0.mRecyclerListener;
        if (recyclerView$RecyclerListener != null) {
            recyclerView$RecyclerListener.onViewRecycled(recyclerView$ViewHolder);
        }
        int size = this.this$0.mRecyclerListeners.size();
        for (int i = 0; i < size; i++) {
            ((RecyclerView$RecyclerListener) this.this$0.mRecyclerListeners.get(i)).onViewRecycled(recyclerView$ViewHolder);
        }
        RecyclerView$Adapter recyclerView$Adapter = this.this$0.mAdapter;
        if (recyclerView$Adapter != null) {
            recyclerView$Adapter.onViewRecycled(recyclerView$ViewHolder);
        }
        RecyclerView recyclerView = this.this$0;
        if (recyclerView.mState != null) {
            recyclerView.mViewInfoStore.removeViewHolder(recyclerView$ViewHolder);
        }
    }

    RecyclerView$ViewHolder getChangedScrapViewForPosition(int i) {
        int size;
        int findPositionOffset;
        ArrayList<RecyclerView$ViewHolder> arrayList = this.mChangedScrap;
        if (arrayList != null && (size = arrayList.size()) != 0) {
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView$ViewHolder recyclerView$ViewHolder = this.mChangedScrap.get(i2);
                if (!recyclerView$ViewHolder.wasReturnedFromScrap() && recyclerView$ViewHolder.getLayoutPosition() == i) {
                    recyclerView$ViewHolder.addFlags(32);
                    return recyclerView$ViewHolder;
                }
            }
            if (this.this$0.mAdapter.hasStableIds() && (findPositionOffset = this.this$0.mAdapterHelper.findPositionOffset(i)) > 0 && findPositionOffset < this.this$0.mAdapter.getItemCount()) {
                long itemId = this.this$0.mAdapter.getItemId(findPositionOffset);
                for (int i3 = 0; i3 < size; i3++) {
                    RecyclerView$ViewHolder recyclerView$ViewHolder2 = this.mChangedScrap.get(i3);
                    if (!recyclerView$ViewHolder2.wasReturnedFromScrap() && recyclerView$ViewHolder2.getItemId() == itemId) {
                        recyclerView$ViewHolder2.addFlags(32);
                        return recyclerView$ViewHolder2;
                    }
                }
            }
        }
        return null;
    }

    RecyclerView$RecycledViewPool getRecycledViewPool() {
        if (this.mRecyclerPool == null) {
            this.mRecyclerPool = new RecyclerView$RecycledViewPool();
        }
        return this.mRecyclerPool;
    }

    int getScrapCount() {
        return this.mAttachedScrap.size();
    }

    @NonNull
    public List<RecyclerView$ViewHolder> getScrapList() {
        return this.mUnmodifiableAttachedScrap;
    }

    RecyclerView$ViewHolder getScrapOrCachedViewForId(long j, int i, boolean z) {
        for (int size = this.mAttachedScrap.size() - 1; size >= 0; size--) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mAttachedScrap.get(size);
            if (recyclerView$ViewHolder.getItemId() == j && !recyclerView$ViewHolder.wasReturnedFromScrap()) {
                if (i == recyclerView$ViewHolder.getItemViewType()) {
                    recyclerView$ViewHolder.addFlags(32);
                    if (recyclerView$ViewHolder.isRemoved() && !this.this$0.mState.isPreLayout()) {
                        recyclerView$ViewHolder.setFlags(2, 14);
                    }
                    return recyclerView$ViewHolder;
                }
                if (!z) {
                    this.mAttachedScrap.remove(size);
                    this.this$0.removeDetachedView(recyclerView$ViewHolder.itemView, false);
                    quickRecycleScrapView(recyclerView$ViewHolder.itemView);
                }
            }
        }
        int size2 = this.mCachedViews.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                return null;
            }
            RecyclerView$ViewHolder recyclerView$ViewHolder2 = this.mCachedViews.get(size2);
            if (recyclerView$ViewHolder2.getItemId() == j && !recyclerView$ViewHolder2.isAttachedToTransitionOverlay()) {
                if (i == recyclerView$ViewHolder2.getItemViewType()) {
                    if (!z) {
                        this.mCachedViews.remove(size2);
                    }
                    return recyclerView$ViewHolder2;
                }
                if (!z) {
                    recycleCachedViewAt(size2);
                    return null;
                }
            }
        }
    }

    RecyclerView$ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int i, boolean z) {
        View findHiddenNonRemovedView;
        int size = this.mAttachedScrap.size();
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mAttachedScrap.get(i2);
            if (!recyclerView$ViewHolder.wasReturnedFromScrap() && recyclerView$ViewHolder.getLayoutPosition() == i && !recyclerView$ViewHolder.isInvalid() && (this.this$0.mState.mInPreLayout || !recyclerView$ViewHolder.isRemoved())) {
                recyclerView$ViewHolder.addFlags(32);
                return recyclerView$ViewHolder;
            }
        }
        if (z || (findHiddenNonRemovedView = this.this$0.mChildHelper.findHiddenNonRemovedView(i)) == null) {
            int size2 = this.mCachedViews.size();
            for (int i3 = 0; i3 < size2; i3++) {
                RecyclerView$ViewHolder recyclerView$ViewHolder2 = this.mCachedViews.get(i3);
                if (!recyclerView$ViewHolder2.isInvalid() && recyclerView$ViewHolder2.getLayoutPosition() == i && !recyclerView$ViewHolder2.isAttachedToTransitionOverlay()) {
                    if (!z) {
                        this.mCachedViews.remove(i3);
                    }
                    return recyclerView$ViewHolder2;
                }
            }
            return null;
        }
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(findHiddenNonRemovedView);
        this.this$0.mChildHelper.unhide(findHiddenNonRemovedView);
        int indexOfChild = this.this$0.mChildHelper.indexOfChild(findHiddenNonRemovedView);
        if (indexOfChild != -1) {
            this.this$0.mChildHelper.detachViewFromParent(indexOfChild);
            scrapView(findHiddenNonRemovedView);
            childViewHolderInt.addFlags(8224);
            return childViewHolderInt;
        }
        throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + this.this$0.exceptionLabel());
    }

    View getScrapViewAt(int i) {
        return this.mAttachedScrap.get(i).itemView;
    }

    @NonNull
    public View getViewForPosition(int i) {
        return getViewForPosition(i, false);
    }

    void markItemDecorInsetsDirty() {
        int size = this.mCachedViews.size();
        for (int i = 0; i < size; i++) {
            RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) this.mCachedViews.get(i).itemView.getLayoutParams();
            if (recyclerView$LayoutParams != null) {
                recyclerView$LayoutParams.mInsetsDirty = true;
            }
        }
    }

    void markKnownViewsInvalid() {
        int size = this.mCachedViews.size();
        for (int i = 0; i < size; i++) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mCachedViews.get(i);
            if (recyclerView$ViewHolder != null) {
                recyclerView$ViewHolder.addFlags(6);
                recyclerView$ViewHolder.addChangePayload(null);
            }
        }
        RecyclerView$Adapter recyclerView$Adapter = this.this$0.mAdapter;
        if (recyclerView$Adapter == null || !recyclerView$Adapter.hasStableIds()) {
            recycleAndClearCachedViews();
        }
    }

    void offsetPositionRecordsForInsert(int i, int i2) {
        int size = this.mCachedViews.size();
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mCachedViews.get(i3);
            if (recyclerView$ViewHolder != null && recyclerView$ViewHolder.mPosition >= i) {
                recyclerView$ViewHolder.offsetPosition(i2, false);
            }
        }
    }

    void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i < i2) {
            i3 = -1;
            i5 = i;
            i4 = i2;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        int size = this.mCachedViews.size();
        for (int i7 = 0; i7 < size; i7++) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mCachedViews.get(i7);
            if (recyclerView$ViewHolder != null && (i6 = recyclerView$ViewHolder.mPosition) >= i5 && i6 <= i4) {
                if (i6 == i) {
                    recyclerView$ViewHolder.offsetPosition(i2 - i, false);
                } else {
                    recyclerView$ViewHolder.offsetPosition(i3, false);
                }
            }
        }
    }

    void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mCachedViews.get(size);
            if (recyclerView$ViewHolder != null) {
                int i4 = recyclerView$ViewHolder.mPosition;
                if (i4 >= i3) {
                    recyclerView$ViewHolder.offsetPosition(-i2, z);
                } else if (i4 >= i) {
                    recyclerView$ViewHolder.addFlags(8);
                    recycleCachedViewAt(size);
                }
            }
        }
    }

    void onAdapterChanged(RecyclerView$Adapter recyclerView$Adapter, RecyclerView$Adapter recyclerView$Adapter2, boolean z) {
        clear();
        getRecycledViewPool().onAdapterChanged(recyclerView$Adapter, recyclerView$Adapter2, z);
    }

    void quickRecycleScrapView(View view) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.mScrapContainer = null;
        childViewHolderInt.mInChangeScrap = false;
        childViewHolderInt.clearReturnedFromScrapFlag();
        recycleViewHolderInternal(childViewHolderInt);
    }

    void recycleAndClearCachedViews() {
        for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
            recycleCachedViewAt(size);
        }
        this.mCachedViews.clear();
        if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
            this.this$0.mPrefetchRegistry.clearPrefetchPositions();
        }
    }

    void recycleCachedViewAt(int i) {
        addViewHolderToRecycledViewPool(this.mCachedViews.get(i), true);
        this.mCachedViews.remove(i);
    }

    public void recycleView(@NonNull View view) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt.isTmpDetached()) {
            this.this$0.removeDetachedView(view, false);
        }
        if (childViewHolderInt.isScrap()) {
            childViewHolderInt.unScrap();
        } else if (childViewHolderInt.wasReturnedFromScrap()) {
            childViewHolderInt.clearReturnedFromScrapFlag();
        }
        recycleViewHolderInternal(childViewHolderInt);
        if (this.this$0.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
            return;
        }
        this.this$0.mItemAnimator.endAnimation(childViewHolderInt);
    }

    void recycleViewHolderInternal(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        boolean z;
        boolean z2 = true;
        if (recyclerView$ViewHolder.isScrap() || recyclerView$ViewHolder.itemView.getParent() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(recyclerView$ViewHolder.isScrap());
            sb.append(" isAttached:");
            sb.append(recyclerView$ViewHolder.itemView.getParent() != null);
            sb.append(this.this$0.exceptionLabel());
            throw new IllegalArgumentException(sb.toString());
        }
        if (recyclerView$ViewHolder.isTmpDetached()) {
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + recyclerView$ViewHolder + this.this$0.exceptionLabel());
        }
        if (recyclerView$ViewHolder.shouldIgnore()) {
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.this$0.exceptionLabel());
        }
        boolean doesTransientStatePreventRecycling = recyclerView$ViewHolder.doesTransientStatePreventRecycling();
        RecyclerView$Adapter recyclerView$Adapter = this.this$0.mAdapter;
        if ((recyclerView$Adapter != null && doesTransientStatePreventRecycling && recyclerView$Adapter.onFailedToRecycleView(recyclerView$ViewHolder)) || recyclerView$ViewHolder.isRecyclable()) {
            if (this.mViewCacheMax <= 0 || recyclerView$ViewHolder.hasAnyOfTheFlags(526)) {
                z = false;
            } else {
                int size = this.mCachedViews.size();
                if (size >= this.mViewCacheMax && size > 0) {
                    recycleCachedViewAt(0);
                    size--;
                }
                if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(recyclerView$ViewHolder.mPosition)) {
                    int i = size - 1;
                    while (i >= 0) {
                        if (!this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(i).mPosition)) {
                            break;
                        } else {
                            i--;
                        }
                    }
                    size = i + 1;
                }
                this.mCachedViews.add(size, recyclerView$ViewHolder);
                z = true;
            }
            if (!z) {
                addViewHolderToRecycledViewPool(recyclerView$ViewHolder, true);
                r1 = z;
                this.this$0.mViewInfoStore.removeViewHolder(recyclerView$ViewHolder);
                if (r1 && !z2 && doesTransientStatePreventRecycling) {
                    recyclerView$ViewHolder.mBindingAdapter = null;
                    recyclerView$ViewHolder.mOwnerRecyclerView = null;
                    return;
                }
                return;
            }
            r1 = z;
        }
        z2 = false;
        this.this$0.mViewInfoStore.removeViewHolder(recyclerView$ViewHolder);
        if (r1) {
        }
    }

    void scrapView(View view) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !this.this$0.canReuseUpdatedViewHolder(childViewHolderInt)) {
            if (this.mChangedScrap == null) {
                this.mChangedScrap = new ArrayList<>();
            }
            childViewHolderInt.setScrapContainer(this, true);
            this.mChangedScrap.add(childViewHolderInt);
            return;
        }
        if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.this$0.mAdapter.hasStableIds()) {
            childViewHolderInt.setScrapContainer(this, false);
            this.mAttachedScrap.add(childViewHolderInt);
        } else {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.this$0.exceptionLabel());
        }
    }

    void setRecycledViewPool(RecyclerView$RecycledViewPool recyclerView$RecycledViewPool) {
        RecyclerView$RecycledViewPool recyclerView$RecycledViewPool2 = this.mRecyclerPool;
        if (recyclerView$RecycledViewPool2 != null) {
            recyclerView$RecycledViewPool2.detach();
        }
        this.mRecyclerPool = recyclerView$RecycledViewPool;
        if (recyclerView$RecycledViewPool == null || this.this$0.getAdapter() == null) {
            return;
        }
        this.mRecyclerPool.attach();
    }

    void setViewCacheExtension(RecyclerView.ViewCacheExtension viewCacheExtension) {
        this.mViewCacheExtension = viewCacheExtension;
    }

    public void setViewCacheSize(int i) {
        this.mRequestedCacheMax = i;
        updateViewCacheSize();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0228 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01d4  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.recyclerview.widget.RecyclerView$ViewHolder tryGetViewHolderForPositionByDeadline(int r17, boolean r18, long r19) {
        /*
            Method dump skipped, instructions count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView$Recycler.tryGetViewHolderForPositionByDeadline(int, boolean, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
    }

    void unscrapView(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        if (recyclerView$ViewHolder.mInChangeScrap) {
            this.mChangedScrap.remove(recyclerView$ViewHolder);
        } else {
            this.mAttachedScrap.remove(recyclerView$ViewHolder);
        }
        recyclerView$ViewHolder.mScrapContainer = null;
        recyclerView$ViewHolder.mInChangeScrap = false;
        recyclerView$ViewHolder.clearReturnedFromScrapFlag();
    }

    void updateViewCacheSize() {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.this$0.mLayout;
        this.mViewCacheMax = this.mRequestedCacheMax + (recyclerView$LayoutManager != null ? recyclerView$LayoutManager.mPrefetchMaxCountObserved : 0);
        for (int size = this.mCachedViews.size() - 1; size >= 0 && this.mCachedViews.size() > this.mViewCacheMax; size--) {
            recycleCachedViewAt(size);
        }
    }

    boolean validateViewHolderForOffsetPosition(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        if (recyclerView$ViewHolder.isRemoved()) {
            return this.this$0.mState.isPreLayout();
        }
        int i = recyclerView$ViewHolder.mPosition;
        if (i >= 0 && i < this.this$0.mAdapter.getItemCount()) {
            if (this.this$0.mState.isPreLayout() || this.this$0.mAdapter.getItemViewType(recyclerView$ViewHolder.mPosition) == recyclerView$ViewHolder.getItemViewType()) {
                return !this.this$0.mAdapter.hasStableIds() || recyclerView$ViewHolder.getItemId() == this.this$0.mAdapter.getItemId(recyclerView$ViewHolder.mPosition);
            }
            return false;
        }
        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + recyclerView$ViewHolder + this.this$0.exceptionLabel());
    }

    void viewRangeUpdate(int i, int i2) {
        int i3;
        int i4 = i2 + i;
        for (int size = this.mCachedViews.size() - 1; size >= 0; size--) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.mCachedViews.get(size);
            if (recyclerView$ViewHolder != null && (i3 = recyclerView$ViewHolder.mPosition) >= i && i3 < i4) {
                recyclerView$ViewHolder.addFlags(2);
                recycleCachedViewAt(size);
            }
        }
    }

    View getViewForPosition(int i, boolean z) {
        return tryGetViewHolderForPositionByDeadline(i, z, Long.MAX_VALUE).itemView;
    }

    private void invalidateDisplayListInt(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                invalidateDisplayListInt((ViewGroup) childAt, true);
            }
        }
        if (z) {
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
            } else {
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }
    }
}
