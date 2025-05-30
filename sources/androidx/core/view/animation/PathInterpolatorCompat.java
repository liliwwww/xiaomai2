package androidx.core.view.animation;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class PathInterpolatorCompat {

    /* compiled from: Taobao */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    static class Api21Impl {
        private Api21Impl() {
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

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(@NonNull Path path) {
        return Build.VERSION.SDK_INT >= 21 ? Api21Impl.createPathInterpolator(path) : new PathInterpolatorApi14(path);
    }

    @NonNull
    public static Interpolator create(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.createPathInterpolator(f, f2);
        }
        return new PathInterpolatorApi14(f, f2);
    }

    @NonNull
    public static Interpolator create(float f, float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.createPathInterpolator(f, f2, f3, f4);
        }
        return new PathInterpolatorApi14(f, f2, f3, f4);
    }
}
