package androidx.recyclerview.widget;

import android.util.SparseArray;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class RecyclerView$State {
    static final int STEP_ANIMATIONS = 4;
    static final int STEP_LAYOUT = 2;
    static final int STEP_START = 1;
    private SparseArray<Object> mData;
    long mFocusedItemId;
    int mFocusedItemPosition;
    int mFocusedSubChildId;
    int mRemainingScrollHorizontal;
    int mRemainingScrollVertical;
    int mTargetPosition = -1;
    int mPreviousLayoutItemCount = 0;
    int mDeletedInvisibleItemCountSincePreviousLayout = 0;
    int mLayoutStep = 1;
    int mItemCount = 0;
    boolean mStructureChanged = false;
    boolean mInPreLayout = false;
    boolean mTrackOldChangeHolders = false;
    boolean mIsMeasuring = false;
    boolean mRunSimpleAnimations = false;
    boolean mRunPredictiveAnimations = false;

    void assertLayoutStep(int i) {
        if ((this.mLayoutStep & i) != 0) {
            return;
        }
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
    }

    public boolean didStructureChange() {
        return this.mStructureChanged;
    }

    public <T> T get(int i) {
        SparseArray<Object> sparseArray = this.mData;
        if (sparseArray == null) {
            return null;
        }
        return (T) sparseArray.get(i);
    }

    public int getItemCount() {
        return this.mInPreLayout ? this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout : this.mItemCount;
    }

    public int getRemainingScrollHorizontal() {
        return this.mRemainingScrollHorizontal;
    }

    public int getRemainingScrollVertical() {
        return this.mRemainingScrollVertical;
    }

    public int getTargetScrollPosition() {
        return this.mTargetPosition;
    }

    public boolean hasTargetScrollPosition() {
        return this.mTargetPosition != -1;
    }

    public boolean isMeasuring() {
        return this.mIsMeasuring;
    }

    public boolean isPreLayout() {
        return this.mInPreLayout;
    }

    void prepareForNestedPrefetch(RecyclerView$Adapter recyclerView$Adapter) {
        this.mLayoutStep = 1;
        this.mItemCount = recyclerView$Adapter.getItemCount();
        this.mInPreLayout = false;
        this.mTrackOldChangeHolders = false;
        this.mIsMeasuring = false;
    }

    public void put(int i, Object obj) {
        if (this.mData == null) {
            this.mData = new SparseArray<>();
        }
        this.mData.put(i, obj);
    }

    public void remove(int i) {
        SparseArray<Object> sparseArray = this.mData;
        if (sparseArray == null) {
            return;
        }
        sparseArray.remove(i);
    }

    public String toString() {
        return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
    }

    public boolean willRunPredictiveAnimations() {
        return this.mRunPredictiveAnimations;
    }

    public boolean willRunSimpleAnimations() {
        return this.mRunSimpleAnimations;
    }
}
