package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class OrientationHelper$2 extends OrientationHelper {
    OrientationHelper$2(RecyclerView.LayoutManager layoutManager) {
        super(layoutManager, (OrientationHelper$1) null);
    }

    public int getDecoratedEnd(View view) {
        return ((OrientationHelper) this).mLayoutManager.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
    }

    public int getDecoratedMeasurement(View view) {
        RecyclerView.LayoutParams layoutParams = view.getLayoutParams();
        return ((OrientationHelper) this).mLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    public int getDecoratedMeasurementInOther(View view) {
        RecyclerView.LayoutParams layoutParams = view.getLayoutParams();
        return ((OrientationHelper) this).mLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    public int getDecoratedStart(View view) {
        return ((OrientationHelper) this).mLayoutManager.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public int getEnd() {
        return ((OrientationHelper) this).mLayoutManager.getHeight();
    }

    public int getEndAfterPadding() {
        return ((OrientationHelper) this).mLayoutManager.getHeight() - ((OrientationHelper) this).mLayoutManager.getPaddingBottom();
    }

    public int getEndPadding() {
        return ((OrientationHelper) this).mLayoutManager.getPaddingBottom();
    }

    public int getMode() {
        return ((OrientationHelper) this).mLayoutManager.getHeightMode();
    }

    public int getModeInOther() {
        return ((OrientationHelper) this).mLayoutManager.getWidthMode();
    }

    public int getStartAfterPadding() {
        return ((OrientationHelper) this).mLayoutManager.getPaddingTop();
    }

    public int getTotalSpace() {
        return (((OrientationHelper) this).mLayoutManager.getHeight() - ((OrientationHelper) this).mLayoutManager.getPaddingTop()) - ((OrientationHelper) this).mLayoutManager.getPaddingBottom();
    }

    public int getTransformedEndWithDecoration(View view) {
        ((OrientationHelper) this).mLayoutManager.getTransformedBoundingBox(view, true, ((OrientationHelper) this).mTmpRect);
        return ((OrientationHelper) this).mTmpRect.bottom;
    }

    public int getTransformedStartWithDecoration(View view) {
        ((OrientationHelper) this).mLayoutManager.getTransformedBoundingBox(view, true, ((OrientationHelper) this).mTmpRect);
        return ((OrientationHelper) this).mTmpRect.top;
    }

    public void offsetChild(View view, int i) {
        view.offsetTopAndBottom(i);
    }

    public void offsetChildren(int i) {
        ((OrientationHelper) this).mLayoutManager.offsetChildrenVertical(i);
    }
}
