package androidx.core.view;

import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(api = 29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WindowInsetsCompat$BuilderImpl29 extends WindowInsetsCompat$BuilderImpl {
    final WindowInsets.Builder mPlatBuilder;

    WindowInsetsCompat$BuilderImpl29() {
        this.mPlatBuilder = new WindowInsets.Builder();
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    @NonNull
    WindowInsetsCompat build() {
        applyInsetTypes();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatBuilder.build());
        windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        this.mPlatBuilder.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.unwrap() : null);
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    void setMandatorySystemGestureInsets(@NonNull Insets insets) {
        this.mPlatBuilder.setMandatorySystemGestureInsets(insets.toPlatformInsets());
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    void setStableInsets(@NonNull Insets insets) {
        this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    void setSystemGestureInsets(@NonNull Insets insets) {
        this.mPlatBuilder.setSystemGestureInsets(insets.toPlatformInsets());
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    void setSystemWindowInsets(@NonNull Insets insets) {
        this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    void setTappableElementInsets(@NonNull Insets insets) {
        this.mPlatBuilder.setTappableElementInsets(insets.toPlatformInsets());
    }

    WindowInsetsCompat$BuilderImpl29(@NonNull WindowInsetsCompat windowInsetsCompat) {
        super(windowInsetsCompat);
        WindowInsets.Builder builder;
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            builder = new WindowInsets.Builder(windowInsets);
        } else {
            builder = new WindowInsets.Builder();
        }
        this.mPlatBuilder = builder;
    }
}
