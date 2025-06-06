package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewUtilsApi29 extends ViewUtilsApi23 {
    ViewUtilsApi29() {
    }

    @Override // androidx.transition.ViewUtilsApi19
    public float getTransitionAlpha(@NonNull View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.ViewUtilsApi21
    public void setAnimationMatrix(@NonNull View view, @Nullable Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // androidx.transition.ViewUtilsApi22
    public void setLeftTopRightBottom(@NonNull View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // androidx.transition.ViewUtilsApi19
    public void setTransitionAlpha(@NonNull View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // androidx.transition.ViewUtilsApi23
    public void setTransitionVisibility(@NonNull View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // androidx.transition.ViewUtilsApi21
    public void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.ViewUtilsApi21
    public void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
