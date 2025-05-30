package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ListViewCompat$Api19Impl {
    private ListViewCompat$Api19Impl() {
    }

    @DoNotInline
    static boolean canScrollList(ListView listView, int i) {
        return listView.canScrollList(i);
    }

    @DoNotInline
    static void scrollListBy(ListView listView, int i) {
        listView.scrollListBy(i);
    }
}
