package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewUtilsApi21 extends ViewUtilsApi19 {
    private static boolean sTryHiddenSetAnimationMatrix = true;
    private static boolean sTryHiddenTransformMatrixToGlobal = true;
    private static boolean sTryHiddenTransformMatrixToLocal = true;

    ViewUtilsApi21() {
    }

    @SuppressLint({"NewApi"})
    public void setAnimationMatrix(@NonNull View view, @Nullable Matrix matrix) {
        if (sTryHiddenSetAnimationMatrix) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetAnimationMatrix = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        if (sTryHiddenTransformMatrixToGlobal) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransformMatrixToGlobal = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        if (sTryHiddenTransformMatrixToLocal) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransformMatrixToLocal = false;
            }
        }
    }
}
