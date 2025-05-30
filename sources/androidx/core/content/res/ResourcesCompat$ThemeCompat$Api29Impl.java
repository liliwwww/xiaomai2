package androidx.core.content.res;

import android.content.res.Resources;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ResourcesCompat$ThemeCompat$Api29Impl {
    private ResourcesCompat$ThemeCompat$Api29Impl() {
    }

    @DoNotInline
    static void rebase(@NonNull Resources.Theme theme) {
        theme.rebase();
    }
}
