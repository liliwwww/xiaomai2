package androidx.core.content.res;

import android.content.res.Resources;
import androidx.annotation.DimenRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ResourcesCompat$Api29Impl {
    private ResourcesCompat$Api29Impl() {
    }

    @DoNotInline
    static float getFloat(@NonNull Resources resources, @DimenRes int i) {
        return resources.getFloat(i);
    }
}
