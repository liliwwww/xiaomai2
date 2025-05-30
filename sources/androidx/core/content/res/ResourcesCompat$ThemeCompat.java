package androidx.core.content.res;

import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ResourcesCompat$ThemeCompat {
    private ResourcesCompat$ThemeCompat() {
    }

    public static void rebase(@NonNull Resources.Theme theme) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            Api29Impl.rebase(theme);
        } else if (i >= 23) {
            Api23Impl.rebase(theme);
        }
    }
}
