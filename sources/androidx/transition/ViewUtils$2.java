package androidx.transition;

import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewUtils$2 extends Property<View, Rect> {
    ViewUtils$2(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public Rect get(View view) {
        return ViewCompat.getClipBounds(view);
    }

    @Override // android.util.Property
    public void set(View view, Rect rect) {
        ViewCompat.setClipBounds(view, rect);
    }
}
