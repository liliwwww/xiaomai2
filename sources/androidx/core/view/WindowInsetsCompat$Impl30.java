package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(30)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WindowInsetsCompat$Impl30 extends WindowInsetsCompat.Impl29 {

    @NonNull
    static final WindowInsetsCompat CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(WindowInsets.CONSUMED);

    WindowInsetsCompat$Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
    }

    final void copyRootViewBounds(@NonNull View view) {
    }

    @NonNull
    public Insets getInsets(int i) {
        return Insets.toCompatInsets(((WindowInsetsCompat.Impl20) this).mPlatformInsets.getInsets(WindowInsetsCompat.TypeImpl30.toPlatformType(i)));
    }

    @NonNull
    public Insets getInsetsIgnoringVisibility(int i) {
        return Insets.toCompatInsets(((WindowInsetsCompat.Impl20) this).mPlatformInsets.getInsetsIgnoringVisibility(WindowInsetsCompat.TypeImpl30.toPlatformType(i)));
    }

    public boolean isVisible(int i) {
        return ((WindowInsetsCompat.Impl20) this).mPlatformInsets.isVisible(WindowInsetsCompat.TypeImpl30.toPlatformType(i));
    }

    WindowInsetsCompat$Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat$Impl30 windowInsetsCompat$Impl30) {
        super(windowInsetsCompat, windowInsetsCompat$Impl30);
    }
}
