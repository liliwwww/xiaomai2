package androidx.appcompat.graphics.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class DrawableContainerCompat$BlockInvalidateCallback implements Drawable.Callback {
    private Drawable.Callback mCallback;

    DrawableContainerCompat$BlockInvalidateCallback() {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = this.mCallback;
        if (callback != null) {
            callback.scheduleDrawable(drawable, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = this.mCallback;
        if (callback != null) {
            callback.unscheduleDrawable(drawable, runnable);
        }
    }

    public Drawable.Callback unwrap() {
        Drawable.Callback callback = this.mCallback;
        this.mCallback = null;
        return callback;
    }

    public DrawableContainerCompat$BlockInvalidateCallback wrap(Drawable.Callback callback) {
        this.mCallback = callback;
        return this;
    }
}
