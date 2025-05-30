package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class PathInterpolatorCompat$Api21Impl {
    private PathInterpolatorCompat$Api21Impl() {
    }

    @DoNotInline
    static PathInterpolator createPathInterpolator(Path path) {
        return new PathInterpolator(path);
    }

    @DoNotInline
    static PathInterpolator createPathInterpolator(float f, float f2) {
        return new PathInterpolator(f, f2);
    }

    @DoNotInline
    static PathInterpolator createPathInterpolator(float f, float f2, float f3, float f4) {
        return new PathInterpolator(f, f2, f3, f4);
    }
}
