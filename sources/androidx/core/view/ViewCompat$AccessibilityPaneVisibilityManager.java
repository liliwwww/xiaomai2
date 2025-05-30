package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewCompat$AccessibilityPaneVisibilityManager implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final WeakHashMap<View, Boolean> mPanesToVisible = new WeakHashMap<>();

    ViewCompat$AccessibilityPaneVisibilityManager() {
    }

    @RequiresApi(19)
    private void checkPaneVisibility(View view, boolean z) {
        boolean z2 = view.isShown() && view.getWindowVisibility() == 0;
        if (z != z2) {
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, z2 ? 16 : 32);
            this.mPanesToVisible.put(view, Boolean.valueOf(z2));
        }
    }

    @RequiresApi(19)
    private void registerForLayoutCallback(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @RequiresApi(19)
    private void unregisterForLayoutCallback(View view) {
        ViewCompat.Api16Impl.removeOnGlobalLayoutListener(view.getViewTreeObserver(), this);
    }

    @RequiresApi(19)
    void addAccessibilityPane(View view) {
        this.mPanesToVisible.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
        view.addOnAttachStateChangeListener(this);
        if (ViewCompat$Api19Impl.isAttachedToWindow(view)) {
            registerForLayoutCallback(view);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    @RequiresApi(19)
    public void onGlobalLayout() {
        if (Build.VERSION.SDK_INT < 28) {
            for (Map.Entry<View, Boolean> entry : this.mPanesToVisible.entrySet()) {
                checkPaneVisibility(entry.getKey(), entry.getValue().booleanValue());
            }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    @RequiresApi(19)
    public void onViewAttachedToWindow(View view) {
        registerForLayoutCallback(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }

    @RequiresApi(19)
    void removeAccessibilityPane(View view) {
        this.mPanesToVisible.remove(view);
        view.removeOnAttachStateChangeListener(this);
        unregisterForLayoutCallback(view);
    }
}
