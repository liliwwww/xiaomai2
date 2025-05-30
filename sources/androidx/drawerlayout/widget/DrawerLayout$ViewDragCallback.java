package androidx.drawerlayout.widget;

import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class DrawerLayout$ViewDragCallback extends ViewDragHelper.Callback {
    private final int mAbsGravity;
    private ViewDragHelper mDragger;
    private final Runnable mPeekRunnable = new Runnable() { // from class: androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback.1
        @Override // java.lang.Runnable
        public void run() {
            DrawerLayout$ViewDragCallback.this.peekDrawer();
        }
    };
    final /* synthetic */ DrawerLayout this$0;

    DrawerLayout$ViewDragCallback(DrawerLayout drawerLayout, int i) {
        this.this$0 = drawerLayout;
        this.mAbsGravity = i;
    }

    private void closeOtherDrawer() {
        View findDrawerWithGravity = this.this$0.findDrawerWithGravity(this.mAbsGravity == 3 ? 5 : 3);
        if (findDrawerWithGravity != null) {
            this.this$0.closeDrawer(findDrawerWithGravity);
        }
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public int clampViewPositionHorizontal(View view, int i, int i2) {
        if (this.this$0.checkDrawerViewAbsoluteGravity(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.this$0.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public int clampViewPositionVertical(View view, int i, int i2) {
        return view.getTop();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public int getViewHorizontalDragRange(View view) {
        if (this.this$0.isDrawerView(view)) {
            return view.getWidth();
        }
        return 0;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public void onEdgeDragStarted(int i, int i2) {
        View findDrawerWithGravity = (i & 1) == 1 ? this.this$0.findDrawerWithGravity(3) : this.this$0.findDrawerWithGravity(5);
        if (findDrawerWithGravity == null || this.this$0.getDrawerLockMode(findDrawerWithGravity) != 0) {
            return;
        }
        this.mDragger.captureChildView(findDrawerWithGravity, i2);
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public boolean onEdgeLock(int i) {
        return false;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public void onEdgeTouched(int i, int i2) {
        this.this$0.postDelayed(this.mPeekRunnable, 160L);
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public void onViewCaptured(View view, int i) {
        view.getLayoutParams().isPeeking = false;
        closeOtherDrawer();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public void onViewDragStateChanged(int i) {
        this.this$0.updateDrawerState(i, this.mDragger.getCapturedView());
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        float width = (this.this$0.checkDrawerViewAbsoluteGravity(view, 3) ? i + r3 : this.this$0.getWidth() - i) / view.getWidth();
        this.this$0.setDrawerViewOffset(view, width);
        view.setVisibility(width == 0.0f ? 4 : 0);
        this.this$0.invalidate();
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public void onViewReleased(View view, float f, float f2) {
        int i;
        float drawerViewOffset = this.this$0.getDrawerViewOffset(view);
        int width = view.getWidth();
        if (this.this$0.checkDrawerViewAbsoluteGravity(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && drawerViewOffset > 0.5f)) ? 0 : -width;
        } else {
            int width2 = this.this$0.getWidth();
            if (f < 0.0f || (f == 0.0f && drawerViewOffset > 0.5f)) {
                width2 -= width;
            }
            i = width2;
        }
        this.mDragger.settleCapturedViewAt(i, view.getTop());
        this.this$0.invalidate();
    }

    void peekDrawer() {
        View findDrawerWithGravity;
        int width;
        int edgeSize = this.mDragger.getEdgeSize();
        boolean z = this.mAbsGravity == 3;
        if (z) {
            findDrawerWithGravity = this.this$0.findDrawerWithGravity(3);
            width = (findDrawerWithGravity != null ? -findDrawerWithGravity.getWidth() : 0) + edgeSize;
        } else {
            findDrawerWithGravity = this.this$0.findDrawerWithGravity(5);
            width = this.this$0.getWidth() - edgeSize;
        }
        if (findDrawerWithGravity != null) {
            if (((!z || findDrawerWithGravity.getLeft() >= width) && (z || findDrawerWithGravity.getLeft() <= width)) || this.this$0.getDrawerLockMode(findDrawerWithGravity) != 0) {
                return;
            }
            DrawerLayout.LayoutParams layoutParams = findDrawerWithGravity.getLayoutParams();
            this.mDragger.smoothSlideViewTo(findDrawerWithGravity, width, findDrawerWithGravity.getTop());
            layoutParams.isPeeking = true;
            this.this$0.invalidate();
            closeOtherDrawer();
            this.this$0.cancelChildViewTouch();
        }
    }

    public void removeCallbacks() {
        this.this$0.removeCallbacks(this.mPeekRunnable);
    }

    public void setDragger(ViewDragHelper viewDragHelper) {
        this.mDragger = viewDragHelper;
    }

    @Override // androidx.customview.widget.ViewDragHelper.Callback
    public boolean tryCaptureView(View view, int i) {
        return this.this$0.isDrawerView(view) && this.this$0.checkDrawerViewAbsoluteGravity(view, this.mAbsGravity) && this.this$0.getDrawerLockMode(view) == 0;
    }
}
