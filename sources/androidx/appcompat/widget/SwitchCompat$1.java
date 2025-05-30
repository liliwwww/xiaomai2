package androidx.appcompat.widget;

import android.util.Property;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class SwitchCompat$1 extends Property<SwitchCompat, Float> {
    SwitchCompat$1(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public Float get(SwitchCompat switchCompat) {
        return Float.valueOf(switchCompat.mThumbPosition);
    }

    @Override // android.util.Property
    public void set(SwitchCompat switchCompat, Float f) {
        switchCompat.setThumbPosition(f.floatValue());
    }
}
