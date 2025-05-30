package androidx.core.view;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(30)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WindowInsetsCompat$BuilderImpl30 extends WindowInsetsCompat$BuilderImpl29 {
    WindowInsetsCompat$BuilderImpl30() {
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    void setInsets(int i, @NonNull Insets insets) {
        this.mPlatBuilder.setInsets(WindowInsetsCompat.TypeImpl30.toPlatformType(i), insets.toPlatformInsets());
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    void setInsetsIgnoringVisibility(int i, @NonNull Insets insets) {
        this.mPlatBuilder.setInsetsIgnoringVisibility(WindowInsetsCompat.TypeImpl30.toPlatformType(i), insets.toPlatformInsets());
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    void setVisible(int i, boolean z) {
        this.mPlatBuilder.setVisible(WindowInsetsCompat.TypeImpl30.toPlatformType(i), z);
    }

    WindowInsetsCompat$BuilderImpl30(@NonNull WindowInsetsCompat windowInsetsCompat) {
        super(windowInsetsCompat);
    }
}
