package androidx.transition;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ChangeImageTransform$2 extends Property<ImageView, Matrix> {
    ChangeImageTransform$2(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public Matrix get(ImageView imageView) {
        return null;
    }

    @Override // android.util.Property
    public void set(ImageView imageView, Matrix matrix) {
        ImageViewUtils.animateTransform(imageView, matrix);
    }
}
