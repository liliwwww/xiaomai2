package androidx.core.content;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.io.File;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ContextCompat$Api21Impl {
    private ContextCompat$Api21Impl() {
    }

    @DoNotInline
    static File getCodeCacheDir(Context context) {
        return context.getCodeCacheDir();
    }

    @DoNotInline
    static Drawable getDrawable(Context context, int i) {
        return context.getDrawable(i);
    }

    @DoNotInline
    static File getNoBackupFilesDir(Context context) {
        return context.getNoBackupFilesDir();
    }
}
