package androidx.appcompat.widget;

import android.content.res.Configuration;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(17)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MenuPopupWindow$MenuDropDownListView$Api17Impl {
    private MenuPopupWindow$MenuDropDownListView$Api17Impl() {
    }

    @DoNotInline
    static int getLayoutDirection(Configuration configuration) {
        return configuration.getLayoutDirection();
    }
}
