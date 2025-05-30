package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.R;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ViewCompat$Api21Impl {
    private ViewCompat$Api21Impl() {
    }

    @DoNotInline
    static void callCompatInsetAnimationCallback(@NonNull WindowInsets windowInsets, @NonNull View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    @DoNotInline
    static WindowInsetsCompat computeSystemWindowInsets(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Rect rect) {
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            return WindowInsetsCompat.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
        }
        rect.setEmpty();
        return windowInsetsCompat;
    }

    @DoNotInline
    static boolean dispatchNestedFling(@NonNull View view, float f, float f2, boolean z) {
        return view.dispatchNestedFling(f, f2, z);
    }

    @DoNotInline
    static boolean dispatchNestedPreFling(@NonNull View view, float f, float f2) {
        return view.dispatchNestedPreFling(f, f2);
    }

    @DoNotInline
    static boolean dispatchNestedPreScroll(View view, int i, int i2, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @DoNotInline
    static boolean dispatchNestedScroll(View view, int i, int i2, int i3, int i4, int[] iArr) {
        return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @DoNotInline
    static ColorStateList getBackgroundTintList(View view) {
        return view.getBackgroundTintList();
    }

    @DoNotInline
    static PorterDuff.Mode getBackgroundTintMode(View view) {
        return view.getBackgroundTintMode();
    }

    @DoNotInline
    static float getElevation(View view) {
        return view.getElevation();
    }

    @Nullable
    @DoNotInline
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
        return WindowInsetsCompat.Api21ReflectionHolder.getRootWindowInsets(view);
    }

    @DoNotInline
    static String getTransitionName(View view) {
        return view.getTransitionName();
    }

    @DoNotInline
    static float getTranslationZ(View view) {
        return view.getTranslationZ();
    }

    @DoNotInline
    static float getZ(@NonNull View view) {
        return view.getZ();
    }

    @DoNotInline
    static boolean hasNestedScrollingParent(View view) {
        return view.hasNestedScrollingParent();
    }

    @DoNotInline
    static boolean isImportantForAccessibility(View view) {
        return view.isImportantForAccessibility();
    }

    @DoNotInline
    static boolean isNestedScrollingEnabled(View view) {
        return view.isNestedScrollingEnabled();
    }

    @DoNotInline
    static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    @DoNotInline
    static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    @DoNotInline
    static void setElevation(View view, float f) {
        view.setElevation(f);
    }

    @DoNotInline
    static void setNestedScrollingEnabled(View view, boolean z) {
        view.setNestedScrollingEnabled(z);
    }

    @DoNotInline
    static void setOnApplyWindowInsetsListener(@NonNull View view, @Nullable OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, onApplyWindowInsetsListener);
        }
        if (onApplyWindowInsetsListener == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new 1(view, onApplyWindowInsetsListener));
        }
    }

    @DoNotInline
    static void setTransitionName(View view, String str) {
        view.setTransitionName(str);
    }

    @DoNotInline
    static void setTranslationZ(View view, float f) {
        view.setTranslationZ(f);
    }

    @DoNotInline
    static void setZ(@NonNull View view, float f) {
        view.setZ(f);
    }

    @DoNotInline
    static boolean startNestedScroll(View view, int i) {
        return view.startNestedScroll(i);
    }

    @DoNotInline
    static void stopNestedScroll(View view) {
        view.stopNestedScroll();
    }
}
