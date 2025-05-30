package androidx.core.content.res;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(15)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ResourcesCompat$Api15Impl {
    private ResourcesCompat$Api15Impl() {
    }

    @DoNotInline
    static Drawable getDrawableForDensity(Resources resources, int i, int i2) {
        return resources.getDrawableForDensity(i, i2);
    }
}
