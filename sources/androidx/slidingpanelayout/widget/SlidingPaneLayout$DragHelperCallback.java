package androidx.slidingpanelayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.customview.widget.ViewDragHelper;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class SlidingPaneLayout$DragHelperCallback extends ViewDragHelper.Callback {
    final /* synthetic */ SlidingPaneLayout this$0;

    SlidingPaneLayout$DragHelperCallback(SlidingPaneLayout slidingPaneLayout) {
        this.this$0 = slidingPaneLayout;
    }

    public int clampViewPositionHorizontal(View view, int i, int i2) {
        SlidingPaneLayout.LayoutParams layoutParams = this.this$0.mSlideableView.getLayoutParams();
        if (this.this$0.isLayoutRtlSupport()) {
            int width = this.this$0.getWidth() - ((this.this$0.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + this.this$0.mSlideableView.getWidth());
            return Math.max(Math.min(i, width), width - this.this$0.mSlideRange);
        }
        int paddingLeft = this.this$0.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        return Math.min(Math.max(i, paddingLeft), this.this$0.mSlideRange + paddingLeft);
    }

    public int clampViewPositionVertical(View view, int i, int i2) {
        return view.getTop();
    }

    public int getViewHorizontalDragRange(View view) {
        return this.this$0.mSlideRange;
    }

    public void onEdgeDragStarted(int i, int i2) {
        SlidingPaneLayout slidingPaneLayout = this.this$0;
        slidingPaneLayout.mDragHelper.captureChildView(slidingPaneLayout.mSlideableView, i2);
    }

    public void onViewCaptured(View view, int i) {
        this.this$0.setAllChildrenVisible();
    }

    public void onViewDragStateChanged(int i) {
        if (this.this$0.mDragHelper.getViewDragState() == 0) {
            SlidingPaneLayout slidingPaneLayout = this.this$0;
            if (slidingPaneLayout.mSlideOffset != 0.0f) {
                slidingPaneLayout.dispatchOnPanelOpened(slidingPaneLayout.mSlideableView);
                this.this$0.mPreservedOpenState = true;
            } else {
                slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                SlidingPaneLayout slidingPaneLayout2 = this.this$0;
                slidingPaneLayout2.dispatchOnPanelClosed(slidingPaneLayout2.mSlideableView);
                this.this$0.mPreservedOpenState = false;
            }
        }
    }

    public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        this.this$0.onPanelDragged(i);
        this.this$0.invalidate();
    }

    public void onViewReleased(View view, float f, float f2) {
        int paddingLeft;
        SlidingPaneLayout.LayoutParams layoutParams = view.getLayoutParams();
        if (this.this$0.isLayoutRtlSupport()) {
            int paddingRight = this.this$0.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            if (f < 0.0f || (f == 0.0f && this.this$0.mSlideOffset > 0.5f)) {
                paddingRight += this.this$0.mSlideRange;
            }
            paddingLeft = (this.this$0.getWidth() - paddingRight) - this.this$0.mSlideableView.getWidth();
        } else {
            paddingLeft = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + this.this$0.getPaddingLeft();
            if (f > 0.0f || (f == 0.0f && this.this$0.mSlideOffset > 0.5f)) {
                paddingLeft += this.this$0.mSlideRange;
            }
        }
        this.this$0.mDragHelper.settleCapturedViewAt(paddingLeft, view.getTop());
        this.this$0.invalidate();
    }

    public boolean tryCaptureView(View view, int i) {
        if (this.this$0.mIsUnableToDrag) {
            return false;
        }
        return view.getLayoutParams().slideable;
    }
}
