package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.view.DisplayCutout;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(30)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DisplayCutoutCompat$Api30Impl {
    private DisplayCutoutCompat$Api30Impl() {
    }

    @DoNotInline
    static DisplayCutout createDisplayCutout(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, Insets insets2) {
        return new DisplayCutout(insets, rect, rect2, rect3, rect4, insets2);
    }

    @DoNotInline
    static Insets getWaterfallInsets(DisplayCutout displayCutout) {
        return displayCutout.getWaterfallInsets();
    }
}
