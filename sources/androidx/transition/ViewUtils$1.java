package androidx.transition;

import android.util.Property;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewUtils$1 extends Property<View, Float> {
    ViewUtils$1(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public Float get(View view) {
        return Float.valueOf(ViewUtils.getTransitionAlpha(view));
    }

    @Override // android.util.Property
    public void set(View view, Float f) {
        ViewUtils.setTransitionAlpha(view, f.floatValue());
    }
}
