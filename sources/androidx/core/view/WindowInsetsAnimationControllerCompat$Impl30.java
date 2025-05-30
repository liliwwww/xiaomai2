package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.WindowInsetsAnimationController;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(30)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WindowInsetsAnimationControllerCompat$Impl30 extends WindowInsetsAnimationControllerCompat$Impl {
    private final WindowInsetsAnimationController mController;

    WindowInsetsAnimationControllerCompat$Impl30(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
        this.mController = windowInsetsAnimationController;
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    void finish(boolean z) {
        this.mController.finish(z);
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    public float getCurrentAlpha() {
        return this.mController.getCurrentAlpha();
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    public float getCurrentFraction() {
        return this.mController.getCurrentFraction();
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    @NonNull
    public Insets getCurrentInsets() {
        return Insets.toCompatInsets(this.mController.getCurrentInsets());
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    @NonNull
    public Insets getHiddenStateInsets() {
        return Insets.toCompatInsets(this.mController.getHiddenStateInsets());
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    @NonNull
    public Insets getShownStateInsets() {
        return Insets.toCompatInsets(this.mController.getShownStateInsets());
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    @SuppressLint({"WrongConstant"})
    public int getTypes() {
        return this.mController.getTypes();
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    boolean isCancelled() {
        return this.mController.isCancelled();
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    boolean isFinished() {
        return this.mController.isFinished();
    }

    @Override // androidx.core.view.WindowInsetsAnimationControllerCompat$Impl
    public void setInsetsAndAlpha(@Nullable Insets insets, float f, float f2) {
        this.mController.setInsetsAndAlpha(insets == null ? null : insets.toPlatformInsets(), f, f2);
    }
}
