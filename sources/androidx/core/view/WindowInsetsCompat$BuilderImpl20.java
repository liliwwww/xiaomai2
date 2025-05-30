package androidx.core.view;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(api = 20)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WindowInsetsCompat$BuilderImpl20 extends WindowInsetsCompat$BuilderImpl {
    private static Constructor<WindowInsets> sConstructor;
    private static boolean sConstructorFetched;
    private static Field sConsumedField;
    private static boolean sConsumedFieldFetched;
    private WindowInsets mPlatformInsets;
    private Insets mStableInsets;

    WindowInsetsCompat$BuilderImpl20() {
        this.mPlatformInsets = createWindowInsetsInstance();
    }

    @Nullable
    private static WindowInsets createWindowInsetsInstance() {
        if (!sConsumedFieldFetched) {
            try {
                sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
            }
            sConsumedFieldFetched = true;
        }
        Field field = sConsumedField;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e2) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e2);
            }
        }
        if (!sConstructorFetched) {
            try {
                sConstructor = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e3) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e3);
            }
            sConstructorFetched = true;
        }
        Constructor<WindowInsets> constructor = sConstructor;
        if (constructor != null) {
            try {
                return constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e4) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e4);
            }
        }
        return null;
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    @NonNull
    WindowInsetsCompat build() {
        applyInsetTypes();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
        windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
        windowInsetsCompat.setStableInsets(this.mStableInsets);
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    void setStableInsets(@Nullable Insets insets) {
        this.mStableInsets = insets;
    }

    @Override // androidx.core.view.WindowInsetsCompat$BuilderImpl
    void setSystemWindowInsets(@NonNull Insets insets) {
        WindowInsets windowInsets = this.mPlatformInsets;
        if (windowInsets != null) {
            this.mPlatformInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
        }
    }

    WindowInsetsCompat$BuilderImpl20(@NonNull WindowInsetsCompat windowInsetsCompat) {
        super(windowInsetsCompat);
        this.mPlatformInsets = windowInsetsCompat.toWindowInsets();
    }
}
