package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Paint;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BitmapCompat {

    /* compiled from: Taobao */
    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void setPaintBlendMode(Paint paint) {
            paint.setBlendMode(BlendMode.SRC);
        }
    }

    private BitmapCompat() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x01a7, code lost:
    
        if (androidx.core.graphics.BitmapCompat.Api27Impl.isAlreadyF16AndLinear(r11) == false) goto L122;
     */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap createScaledBitmap(@androidx.annotation.NonNull android.graphics.Bitmap r21, int r22, int r23, @androidx.annotation.Nullable android.graphics.Rect r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.BitmapCompat.createScaledBitmap(android.graphics.Bitmap, int, int, android.graphics.Rect, boolean):android.graphics.Bitmap");
    }

    public static int getAllocationByteCount(@NonNull Bitmap bitmap) {
        return Build.VERSION.SDK_INT >= 19 ? Api19Impl.getAllocationByteCount(bitmap) : bitmap.getByteCount();
    }

    public static boolean hasMipMap(@NonNull Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 17) {
            return Api17Impl.hasMipMap(bitmap);
        }
        return false;
    }

    public static void setHasMipMap(@NonNull Bitmap bitmap, boolean z) {
        if (Build.VERSION.SDK_INT >= 17) {
            Api17Impl.setHasMipMap(bitmap, z);
        }
    }

    @VisibleForTesting
    public static int sizeAtStep(int i, int i2, int i3, int i4) {
        return i3 == 0 ? i2 : i3 > 0 ? i * (1 << (i4 - i3)) : i2 << ((-i3) - 1);
    }
}
