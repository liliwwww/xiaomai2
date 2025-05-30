package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS;
    private static final ViewUtilsBase IMPL;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            IMPL = new ViewUtilsApi29();
        } else if (i >= 23) {
            IMPL = new ViewUtilsApi23();
        } else if (i >= 22) {
            IMPL = new ViewUtilsApi22();
        } else if (i >= 21) {
            IMPL = new ViewUtilsApi21();
        } else if (i >= 19) {
            IMPL = new ViewUtilsApi19();
        } else {
            IMPL = new ViewUtilsBase();
        }
        TRANSITION_ALPHA = new 1(Float.class, "translationAlpha");
        CLIP_BOUNDS = new 2(Rect.class, "clipBounds");
    }

    private ViewUtils() {
    }

    static void clearNonTransitionAlpha(@NonNull View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    static ViewOverlayImpl getOverlay(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 18 ? new ViewOverlayApi18(view) : ViewOverlayApi14.createFrom(view);
    }

    static float getTransitionAlpha(@NonNull View view) {
        return IMPL.getTransitionAlpha(view);
    }

    static WindowIdImpl getWindowId(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 18 ? new WindowIdApi18(view) : new WindowIdApi14(view.getWindowToken());
    }

    static void saveNonTransitionAlpha(@NonNull View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    static void setAnimationMatrix(@NonNull View view, @Nullable Matrix matrix) {
        IMPL.setAnimationMatrix(view, matrix);
    }

    static void setLeftTopRightBottom(@NonNull View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    static void setTransitionAlpha(@NonNull View view, float f) {
        IMPL.setTransitionAlpha(view, f);
    }

    static void setTransitionVisibility(@NonNull View view, int i) {
        IMPL.setTransitionVisibility(view, i);
    }

    static void transformMatrixToGlobal(@NonNull View view, @NonNull Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    static void transformMatrixToLocal(@NonNull View view, @NonNull Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }
}
