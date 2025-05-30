package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class OrientationHelper$1 extends OrientationHelper {
    OrientationHelper$1(RecyclerView.LayoutManager layoutManager) {
        super(layoutManager, (OrientationHelper$1) null);
    }

    public int getDecoratedEnd(View view) {
        return ((OrientationHelper) this).mLayoutManager.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin;
    }

    public int getDecoratedMeasurement(View view) {
        RecyclerView.LayoutParams layoutParams = view.getLayoutParams();
        return ((OrientationHelper) this).mLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    public int getDecoratedMeasurementInOther(View view) {
        RecyclerView.LayoutParams layoutParams = view.getLayoutParams();
        return ((OrientationHelper) this).mLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    public int getDecoratedStart(View view) {
        return ((OrientationHelper) this).mLayoutManager.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin;
    }

    public int getEnd() {
        return ((OrientationHelper) this).mLayoutManager.getWidth();
    }

    public int getEndAfterPadding() {
        return ((OrientationHelper) this).mLayoutManager.getWidth() - ((OrientationHelper) this).mLayoutManager.getPaddingRight();
    }

    public int getEndPadding() {
        return ((OrientationHelper) this).mLayoutManager.getPaddingRight();
    }

    public int getMode() {
        return ((OrientationHelper) this).mLayoutManager.getWidthMode();
    }

    public int getModeInOther() {
        return ((OrientationHelper) this).mLayoutManager.getHeightMode();
    }

    public int getStartAfterPadding() {
        return ((OrientationHelper) this).mLayoutManager.getPaddingLeft();
    }

    public int getTotalSpace() {
        return (((OrientationHelper) this).mLayoutManager.getWidth() - ((OrientationHelper) this).mLayoutManager.getPaddingLeft()) - ((OrientationHelper) this).mLayoutManager.getPaddingRight();
    }

    public int getTransformedEndWithDecoration(View view) {
        ((OrientationHelper) this).mLayoutManager.getTransformedBoundingBox(view, true, ((OrientationHelper) this).mTmpRect);
        return ((OrientationHelper) this).mTmpRect.right;
    }

    public int getTransformedStartWithDecoration(View view) {
        ((OrientationHelper) this).mLayoutManager.getTransformedBoundingBox(view, true, ((OrientationHelper) this).mTmpRect);
        return ((OrientationHelper) this).mTmpRect.left;
    }

    public void offsetChild(View view, int i) {
        view.offsetLeftAndRight(i);
    }

    public void offsetChildren(int i) {
        ((OrientationHelper) this).mLayoutManager.offsetChildrenHorizontal(i);
    }
}
