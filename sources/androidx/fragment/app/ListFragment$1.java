package androidx.fragment.app;

import android.widget.ListView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ListFragment$1 implements Runnable {
    final /* synthetic */ ListFragment this$0;

    ListFragment$1(ListFragment listFragment) {
        this.this$0 = listFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView = this.this$0.mList;
        listView.focusableViewAvailable(listView);
    }
}
