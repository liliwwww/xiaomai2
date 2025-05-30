package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(26)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class PathUtils$Api26Impl {
    private PathUtils$Api26Impl() {
    }

    @DoNotInline
    static float[] approximate(Path path, float f) {
        return path.approximate(f);
    }
}
