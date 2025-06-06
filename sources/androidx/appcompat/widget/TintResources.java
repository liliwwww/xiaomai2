package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class TintResources extends ResourcesWrapper {
    private final WeakReference<Context> mContextRef;

    public TintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources);
        this.mContextRef = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable drawableCanonical = getDrawableCanonical(i);
        Context context = this.mContextRef.get();
        if (drawableCanonical != null && context != null) {
            ResourceManagerInternal.get().tintDrawableUsingColorFilter(context, i, drawableCanonical);
        }
        return drawableCanonical;
    }
}
