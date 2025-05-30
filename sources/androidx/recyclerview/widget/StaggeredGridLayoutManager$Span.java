package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class StaggeredGridLayoutManager$Span {
    static final int INVALID_LINE = Integer.MIN_VALUE;
    final int mIndex;
    final /* synthetic */ StaggeredGridLayoutManager this$0;
    ArrayList<View> mViews = new ArrayList<>();
    int mCachedStart = Integer.MIN_VALUE;
    int mCachedEnd = Integer.MIN_VALUE;
    int mDeletedSize = 0;

    StaggeredGridLayoutManager$Span(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.this$0 = staggeredGridLayoutManager;
        this.mIndex = i;
    }

    void appendToSpan(View view) {
        StaggeredGridLayoutManager.LayoutParams layoutParams = getLayoutParams(view);
        layoutParams.mSpan = this;
        this.mViews.add(view);
        this.mCachedEnd = Integer.MIN_VALUE;
        if (this.mViews.size() == 1) {
            this.mCachedStart = Integer.MIN_VALUE;
        }
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(view);
        }
    }

    void cacheReferenceLineAndClear(boolean z, int i) {
        int endLine = z ? getEndLine(Integer.MIN_VALUE) : getStartLine(Integer.MIN_VALUE);
        clear();
        if (endLine == Integer.MIN_VALUE) {
            return;
        }
        if (!z || endLine >= this.this$0.mPrimaryOrientation.getEndAfterPadding()) {
            if (z || endLine <= this.this$0.mPrimaryOrientation.getStartAfterPadding()) {
                if (i != Integer.MIN_VALUE) {
                    endLine += i;
                }
                this.mCachedEnd = endLine;
                this.mCachedStart = endLine;
            }
        }
    }

    void calculateCachedEnd() {
        StaggeredGridLayoutManager$LazySpanLookup.FullSpanItem fullSpanItem;
        ArrayList<View> arrayList = this.mViews;
        View view = arrayList.get(arrayList.size() - 1);
        StaggeredGridLayoutManager.LayoutParams layoutParams = getLayoutParams(view);
        this.mCachedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd(view);
        if (layoutParams.mFullSpan && (fullSpanItem = this.this$0.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == 1) {
            this.mCachedEnd += fullSpanItem.getGapForSpan(this.mIndex);
        }
    }

    void calculateCachedStart() {
        StaggeredGridLayoutManager$LazySpanLookup.FullSpanItem fullSpanItem;
        View view = this.mViews.get(0);
        StaggeredGridLayoutManager.LayoutParams layoutParams = getLayoutParams(view);
        this.mCachedStart = this.this$0.mPrimaryOrientation.getDecoratedStart(view);
        if (layoutParams.mFullSpan && (fullSpanItem = this.this$0.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == -1) {
            this.mCachedStart -= fullSpanItem.getGapForSpan(this.mIndex);
        }
    }

    void clear() {
        this.mViews.clear();
        invalidateCache();
        this.mDeletedSize = 0;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        return this.this$0.mReverseLayout ? findOneVisibleChild(this.mViews.size() - 1, -1, true) : findOneVisibleChild(0, this.mViews.size(), true);
    }

    public int findFirstPartiallyVisibleItemPosition() {
        return this.this$0.mReverseLayout ? findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true) : findOnePartiallyVisibleChild(0, this.mViews.size(), true);
    }

    public int findFirstVisibleItemPosition() {
        return this.this$0.mReverseLayout ? findOneVisibleChild(this.mViews.size() - 1, -1, false) : findOneVisibleChild(0, this.mViews.size(), false);
    }

    public int findLastCompletelyVisibleItemPosition() {
        return this.this$0.mReverseLayout ? findOneVisibleChild(0, this.mViews.size(), true) : findOneVisibleChild(this.mViews.size() - 1, -1, true);
    }

    public int findLastPartiallyVisibleItemPosition() {
        return this.this$0.mReverseLayout ? findOnePartiallyVisibleChild(0, this.mViews.size(), true) : findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
    }

    public int findLastVisibleItemPosition() {
        return this.this$0.mReverseLayout ? findOneVisibleChild(0, this.mViews.size(), false) : findOneVisibleChild(this.mViews.size() - 1, -1, false);
    }

    int findOnePartiallyOrCompletelyVisibleChild(int i, int i2, boolean z, boolean z2, boolean z3) {
        int startAfterPadding = this.this$0.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.this$0.mPrimaryOrientation.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View view = this.mViews.get(i);
            int decoratedStart = this.this$0.mPrimaryOrientation.getDecoratedStart(view);
            int decoratedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd(view);
            boolean z4 = false;
            boolean z5 = !z3 ? decoratedStart >= endAfterPadding : decoratedStart > endAfterPadding;
            if (!z3 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                z4 = true;
            }
            if (z5 && z4) {
                if (z && z2) {
                    if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return this.this$0.getPosition(view);
                    }
                } else {
                    if (z2) {
                        return this.this$0.getPosition(view);
                    }
                    if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                        return this.this$0.getPosition(view);
                    }
                }
            }
            i += i3;
        }
        return -1;
    }

    int findOnePartiallyVisibleChild(int i, int i2, boolean z) {
        return findOnePartiallyOrCompletelyVisibleChild(i, i2, false, false, z);
    }

    int findOneVisibleChild(int i, int i2, boolean z) {
        return findOnePartiallyOrCompletelyVisibleChild(i, i2, z, true, false);
    }

    public int getDeletedSize() {
        return this.mDeletedSize;
    }

    int getEndLine(int i) {
        int i2 = this.mCachedEnd;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (this.mViews.size() == 0) {
            return i;
        }
        calculateCachedEnd();
        return this.mCachedEnd;
    }

    public View getFocusableViewAfter(int i, int i2) {
        View view = null;
        if (i2 != -1) {
            int size = this.mViews.size() - 1;
            while (size >= 0) {
                View view2 = this.mViews.get(size);
                StaggeredGridLayoutManager staggeredGridLayoutManager = this.this$0;
                if (staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view2) >= i) {
                    break;
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager2 = this.this$0;
                if ((!staggeredGridLayoutManager2.mReverseLayout && staggeredGridLayoutManager2.getPosition(view2) <= i) || !view2.hasFocusable()) {
                    break;
                }
                size--;
                view = view2;
            }
        } else {
            int size2 = this.mViews.size();
            int i3 = 0;
            while (i3 < size2) {
                View view3 = this.mViews.get(i3);
                StaggeredGridLayoutManager staggeredGridLayoutManager3 = this.this$0;
                if (staggeredGridLayoutManager3.mReverseLayout && staggeredGridLayoutManager3.getPosition(view3) <= i) {
                    break;
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager4 = this.this$0;
                if ((!staggeredGridLayoutManager4.mReverseLayout && staggeredGridLayoutManager4.getPosition(view3) >= i) || !view3.hasFocusable()) {
                    break;
                }
                i3++;
                view = view3;
            }
        }
        return view;
    }

    StaggeredGridLayoutManager.LayoutParams getLayoutParams(View view) {
        return view.getLayoutParams();
    }

    int getStartLine(int i) {
        int i2 = this.mCachedStart;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (this.mViews.size() == 0) {
            return i;
        }
        calculateCachedStart();
        return this.mCachedStart;
    }

    void invalidateCache() {
        this.mCachedStart = Integer.MIN_VALUE;
        this.mCachedEnd = Integer.MIN_VALUE;
    }

    void onOffset(int i) {
        int i2 = this.mCachedStart;
        if (i2 != Integer.MIN_VALUE) {
            this.mCachedStart = i2 + i;
        }
        int i3 = this.mCachedEnd;
        if (i3 != Integer.MIN_VALUE) {
            this.mCachedEnd = i3 + i;
        }
    }

    void popEnd() {
        int size = this.mViews.size();
        View remove = this.mViews.remove(size - 1);
        StaggeredGridLayoutManager.LayoutParams layoutParams = getLayoutParams(remove);
        layoutParams.mSpan = null;
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(remove);
        }
        if (size == 1) {
            this.mCachedStart = Integer.MIN_VALUE;
        }
        this.mCachedEnd = Integer.MIN_VALUE;
    }

    void popStart() {
        View remove = this.mViews.remove(0);
        StaggeredGridLayoutManager.LayoutParams layoutParams = getLayoutParams(remove);
        layoutParams.mSpan = null;
        if (this.mViews.size() == 0) {
            this.mCachedEnd = Integer.MIN_VALUE;
        }
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(remove);
        }
        this.mCachedStart = Integer.MIN_VALUE;
    }

    void prependToSpan(View view) {
        StaggeredGridLayoutManager.LayoutParams layoutParams = getLayoutParams(view);
        layoutParams.mSpan = this;
        this.mViews.add(0, view);
        this.mCachedStart = Integer.MIN_VALUE;
        if (this.mViews.size() == 1) {
            this.mCachedEnd = Integer.MIN_VALUE;
        }
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(view);
        }
    }

    void setLine(int i) {
        this.mCachedStart = i;
        this.mCachedEnd = i;
    }

    int getEndLine() {
        int i = this.mCachedEnd;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        calculateCachedEnd();
        return this.mCachedEnd;
    }

    int getStartLine() {
        int i = this.mCachedStart;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        calculateCachedStart();
        return this.mCachedStart;
    }
}
