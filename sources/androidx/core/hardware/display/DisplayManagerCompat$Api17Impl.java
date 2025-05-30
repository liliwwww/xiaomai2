package androidx.core.hardware.display;

import android.hardware.display.DisplayManager;
import android.view.Display;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(17)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DisplayManagerCompat$Api17Impl {
    private DisplayManagerCompat$Api17Impl() {
    }

    @DoNotInline
    static Display getDisplay(DisplayManager displayManager, int i) {
        return displayManager.getDisplay(i);
    }

    @DoNotInline
    static Display[] getDisplays(DisplayManager displayManager) {
        return displayManager.getDisplays();
    }
}
