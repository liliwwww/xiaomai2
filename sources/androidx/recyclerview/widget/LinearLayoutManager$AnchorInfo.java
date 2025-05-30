package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class LinearLayoutManager$AnchorInfo {
    int mCoordinate;
    boolean mLayoutFromEnd;
    OrientationHelper mOrientationHelper;
    int mPosition;
    boolean mValid;

    LinearLayoutManager$AnchorInfo() {
        reset();
    }

    void assignCoordinateFromPadding() {
        this.mCoordinate = this.mLayoutFromEnd ? this.mOrientationHelper.getEndAfterPadding() : this.mOrientationHelper.getStartAfterPadding();
    }

    public void assignFromView(View view, int i) {
        if (this.mLayoutFromEnd) {
            this.mCoordinate = this.mOrientationHelper.getDecoratedEnd(view) + this.mOrientationHelper.getTotalSpaceChange();
        } else {
            this.mCoordinate = this.mOrientationHelper.getDecoratedStart(view);
        }
        this.mPosition = i;
    }

    public void assignFromViewAndKeepVisibleRect(View view, int i) {
        int totalSpaceChange = this.mOrientationHelper.getTotalSpaceChange();
        if (totalSpaceChange >= 0) {
            assignFromView(view, i);
            return;
        }
        this.mPosition = i;
        if (this.mLayoutFromEnd) {
            int endAfterPadding = (this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - this.mOrientationHelper.getDecoratedEnd(view);
            this.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - endAfterPadding;
            if (endAfterPadding > 0) {
                int decoratedMeasurement = this.mCoordinate - this.mOrientationHelper.getDecoratedMeasurement(view);
                int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
                int min = decoratedMeasurement - (startAfterPadding + Math.min(this.mOrientationHelper.getDecoratedStart(view) - startAfterPadding, 0));
                if (min < 0) {
                    this.mCoordinate += Math.min(endAfterPadding, -min);
                    return;
                }
                return;
            }
            return;
        }
        int decoratedStart = this.mOrientationHelper.getDecoratedStart(view);
        int startAfterPadding2 = decoratedStart - this.mOrientationHelper.getStartAfterPadding();
        this.mCoordinate = decoratedStart;
        if (startAfterPadding2 > 0) {
            int endAfterPadding2 = (this.mOrientationHelper.getEndAfterPadding() - Math.min(0, (this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - this.mOrientationHelper.getDecoratedEnd(view))) - (decoratedStart + this.mOrientationHelper.getDecoratedMeasurement(view));
            if (endAfterPadding2 < 0) {
                this.mCoordinate -= Math.min(startAfterPadding2, -endAfterPadding2);
            }
        }
    }

    boolean isViewValidAsAnchor(View view, RecyclerView.State state) {
        RecyclerView.LayoutParams layoutParams = view.getLayoutParams();
        return !layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount();
    }

    void reset() {
        this.mPosition = -1;
        this.mCoordinate = Integer.MIN_VALUE;
        this.mLayoutFromEnd = false;
        this.mValid = false;
    }

    public String toString() {
        return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + '}';
    }
}
