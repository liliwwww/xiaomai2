package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(17)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class GravityCompat$Api17Impl {
    private GravityCompat$Api17Impl() {
    }

    @DoNotInline
    static void apply(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        Gravity.apply(i, i2, i3, rect, rect2, i4);
    }

    @DoNotInline
    static void applyDisplay(int i, Rect rect, Rect rect2, int i2) {
        Gravity.applyDisplay(i, rect, rect2, i2);
    }

    @DoNotInline
    static void apply(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2, int i6) {
        Gravity.apply(i, i2, i3, rect, i4, i5, rect2, i6);
    }
}
