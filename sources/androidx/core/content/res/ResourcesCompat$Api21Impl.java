package androidx.core.content.res;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ResourcesCompat$Api21Impl {
    private ResourcesCompat$Api21Impl() {
    }

    @DoNotInline
    static Drawable getDrawable(Resources resources, int i, Resources.Theme theme) {
        return resources.getDrawable(i, theme);
    }

    @DoNotInline
    static Drawable getDrawableForDensity(Resources resources, int i, int i2, Resources.Theme theme) {
        return resources.getDrawableForDensity(i, i2, theme);
    }
}
