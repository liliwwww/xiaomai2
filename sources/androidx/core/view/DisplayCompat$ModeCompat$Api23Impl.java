package androidx.core.view;

import android.view.Display;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class DisplayCompat$ModeCompat$Api23Impl {
    private DisplayCompat$ModeCompat$Api23Impl() {
    }

    @DoNotInline
    static int getPhysicalHeight(Display.Mode mode) {
        return mode.getPhysicalHeight();
    }

    @DoNotInline
    static int getPhysicalWidth(Display.Mode mode) {
        return mode.getPhysicalWidth();
    }
}
