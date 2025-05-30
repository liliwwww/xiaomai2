package androidx.core.graphics;

import android.graphics.Bitmap;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(17)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class BitmapCompat$Api17Impl {
    private BitmapCompat$Api17Impl() {
    }

    @DoNotInline
    static boolean hasMipMap(Bitmap bitmap) {
        return bitmap.hasMipMap();
    }

    @DoNotInline
    static void setHasMipMap(Bitmap bitmap, boolean z) {
        bitmap.setHasMipMap(z);
    }
}
