package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class Group extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    protected void applyLayoutFeaturesInConstraintSet(ConstraintLayout constraintLayout) {
        applyLayoutFeatures(constraintLayout);
    }

    protected void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        ((ConstraintHelper) this).mUseViewMeasure = false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        applyLayoutFeatures();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setElevation(float f) {
        super/*android.view.View*/.setElevation(f);
        applyLayoutFeatures();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setVisibility(int i) {
        super/*android.view.View*/.setVisibility(i);
        applyLayoutFeatures();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void updatePostLayout(ConstraintLayout constraintLayout) {
        ConstraintLayout.LayoutParams layoutParams = getLayoutParams();
        layoutParams.widget.setWidth(0);
        layoutParams.widget.setHeight(0);
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
