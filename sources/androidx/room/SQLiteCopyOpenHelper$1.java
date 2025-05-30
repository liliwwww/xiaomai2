package androidx.room;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class SQLiteCopyOpenHelper$1 extends SupportSQLiteOpenHelper.Callback {
    final /* synthetic */ SQLiteCopyOpenHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SQLiteCopyOpenHelper$1(SQLiteCopyOpenHelper sQLiteCopyOpenHelper, int i) {
        super(i);
        this.this$0 = sQLiteCopyOpenHelper;
    }

    public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        int i = ((SupportSQLiteOpenHelper.Callback) this).version;
        if (i < 1) {
            supportSQLiteDatabase.setVersion(i);
        }
    }

    public void onUpgrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
    }
}
