package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class BlendModeColorFilterCompat$Api29Impl {
    private BlendModeColorFilterCompat$Api29Impl() {
    }

    @DoNotInline
    static ColorFilter createBlendModeColorFilter(int i, Object obj) {
        return new BlendModeColorFilter(i, (BlendMode) obj);
    }
}
