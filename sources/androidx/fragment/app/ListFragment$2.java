package androidx.fragment.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ListFragment$2 implements AdapterView.OnItemClickListener {
    final /* synthetic */ ListFragment this$0;

    ListFragment$2(ListFragment listFragment) {
        this.this$0 = listFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.this$0.onListItemClick((ListView) adapterView, view, i, j);
    }
}
