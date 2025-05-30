package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import java.lang.reflect.Field;

/* compiled from: Taobao */
@RequiresApi(21)
@SuppressLint({"SoonBlockedPrivateApi"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WindowInsetsCompat$Api21ReflectionHolder {
    private static Field sContentInsets;
    private static boolean sReflectionSucceeded;
    private static Field sStableInsets;
    private static Field sViewAttachInfoField;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            sViewAttachInfoField = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            sStableInsets = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            sContentInsets = declaredField3;
            declaredField3.setAccessible(true);
            sReflectionSucceeded = true;
        } catch (ReflectiveOperationException e) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
        }
    }

    private WindowInsetsCompat$Api21ReflectionHolder() {
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
        if (sReflectionSucceeded && view.isAttachedToWindow()) {
            try {
                Object obj = sViewAttachInfoField.get(view.getRootView());
                if (obj != null) {
                    Rect rect = (Rect) sStableInsets.get(obj);
                    Rect rect2 = (Rect) sContentInsets.get(obj);
                    if (rect != null && rect2 != null) {
                        WindowInsetsCompat build = new WindowInsetsCompat.Builder().setStableInsets(Insets.of(rect)).setSystemWindowInsets(Insets.of(rect2)).build();
                        build.setRootWindowInsets(build);
                        build.copyRootViewBounds(view.getRootView());
                        return build;
                    }
                }
            } catch (IllegalAccessException e) {
                Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            }
        }
        return null;
    }
}
