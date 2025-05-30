package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ListAdapter$1 implements AsyncListDiffer.ListListener<Object> {
    final /* synthetic */ ListAdapter this$0;

    ListAdapter$1(ListAdapter listAdapter) {
        this.this$0 = listAdapter;
    }

    public void onCurrentListChanged(@NonNull List<Object> list, @NonNull List<Object> list2) {
        this.this$0.onCurrentListChanged(list, list2);
    }
}
