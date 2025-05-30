package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewConfigurationCompat$Api26Impl {
    private ViewConfigurationCompat$Api26Impl() {
    }

    @DoNotInline
    static float getScaledHorizontalScrollFactor(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHorizontalScrollFactor();
    }

    @DoNotInline
    static float getScaledVerticalScrollFactor(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledVerticalScrollFactor();
    }
}
