package androidx.cursoradapter.widget;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class CursorAdapter$ChangeObserver extends ContentObserver {
    final /* synthetic */ CursorAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CursorAdapter$ChangeObserver(CursorAdapter cursorAdapter) {
        super(new Handler());
        this.this$0 = cursorAdapter;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        return true;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        this.this$0.onContentChanged();
    }
}
