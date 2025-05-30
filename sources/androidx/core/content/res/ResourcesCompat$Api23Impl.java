package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(23)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ResourcesCompat$Api23Impl {
    private ResourcesCompat$Api23Impl() {
    }

    @DoNotInline
    static int getColor(Resources resources, int i, Resources.Theme theme) {
        return resources.getColor(i, theme);
    }

    @NonNull
    @DoNotInline
    static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i, @Nullable Resources.Theme theme) {
        return resources.getColorStateList(i, theme);
    }
}
