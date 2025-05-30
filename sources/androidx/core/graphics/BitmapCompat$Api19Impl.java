package androidx.core.graphics;

import android.graphics.Bitmap;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class BitmapCompat$Api19Impl {
    private BitmapCompat$Api19Impl() {
    }

    @DoNotInline
    static int getAllocationByteCount(Bitmap bitmap) {
        return bitmap.getAllocationByteCount();
    }
}
