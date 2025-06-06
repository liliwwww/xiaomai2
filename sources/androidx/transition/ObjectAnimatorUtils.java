package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ObjectAnimatorUtils {
    private ObjectAnimatorUtils() {
    }

    static <T> ObjectAnimator ofPointF(T t, Property<T, PointF> property, Path path) {
        return Build.VERSION.SDK_INT >= 21 ? ObjectAnimator.ofObject(t, property, (TypeConverter) null, path) : ObjectAnimator.ofFloat((Object) t, (Property) new PathProperty(property, path), 0.0f, 1.0f);
    }
}
