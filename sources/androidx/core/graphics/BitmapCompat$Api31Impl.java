package androidx.core.graphics;

import android.graphics.Bitmap;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(31)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class BitmapCompat$Api31Impl {
    private BitmapCompat$Api31Impl() {
    }

    @DoNotInline
    static Bitmap.Config getHardwareBitmapConfig(Bitmap bitmap) {
        return bitmap.getHardwareBuffer().getFormat() == 22 ? Bitmap.Config.RGBA_F16 : Bitmap.Config.ARGB_8888;
    }
}
