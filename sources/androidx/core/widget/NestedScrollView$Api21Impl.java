package androidx.core.widget;

import android.view.ViewGroup;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class NestedScrollView$Api21Impl {
    private NestedScrollView$Api21Impl() {
    }

    @DoNotInline
    static boolean getClipToPadding(ViewGroup viewGroup) {
        return viewGroup.getClipToPadding();
    }
}
