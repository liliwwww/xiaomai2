package androidx.core.view;

import android.graphics.Rect;
import android.view.DisplayCutout;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.util.List;

/* compiled from: Taobao */
@RequiresApi(28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DisplayCutoutCompat$Api28Impl {
    private DisplayCutoutCompat$Api28Impl() {
    }

    @DoNotInline
    static DisplayCutout createDisplayCutout(Rect rect, List<Rect> list) {
        return new DisplayCutout(rect, list);
    }

    @DoNotInline
    static List<Rect> getBoundingRects(DisplayCutout displayCutout) {
        return displayCutout.getBoundingRects();
    }

    @DoNotInline
    static int getSafeInsetBottom(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetBottom();
    }

    @DoNotInline
    static int getSafeInsetLeft(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetLeft();
    }

    @DoNotInline
    static int getSafeInsetRight(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetRight();
    }

    @DoNotInline
    static int getSafeInsetTop(DisplayCutout displayCutout) {
        return displayCutout.getSafeInsetTop();
    }
}
