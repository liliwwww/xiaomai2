package androidx.cursoradapter.widget;

import android.database.DataSetObserver;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class CursorAdapter$MyDataSetObserver extends DataSetObserver {
    final /* synthetic */ CursorAdapter this$0;

    CursorAdapter$MyDataSetObserver(CursorAdapter cursorAdapter) {
        this.this$0 = cursorAdapter;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        CursorAdapter cursorAdapter = this.this$0;
        cursorAdapter.mDataValid = true;
        cursorAdapter.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        CursorAdapter cursorAdapter = this.this$0;
        cursorAdapter.mDataValid = false;
        cursorAdapter.notifyDataSetInvalidated();
    }
}
