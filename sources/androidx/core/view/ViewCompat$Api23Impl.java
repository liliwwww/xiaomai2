package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ViewCompat$Api23Impl {
    private ViewCompat$Api23Impl() {
    }

    @Nullable
    public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets);
        windowInsetsCompat.setRootWindowInsets(windowInsetsCompat);
        windowInsetsCompat.copyRootViewBounds(view.getRootView());
        return windowInsetsCompat;
    }

    @DoNotInline
    static int getScrollIndicators(@NonNull View view) {
        return view.getScrollIndicators();
    }

    @DoNotInline
    static void setScrollIndicators(@NonNull View view, int i) {
        view.setScrollIndicators(i);
    }

    @DoNotInline
    static void setScrollIndicators(@NonNull View view, int i, int i2) {
        view.setScrollIndicators(i, i2);
    }
}
