package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {
    private final SQLiteStatement mDelegate;

    FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.mDelegate = sQLiteStatement;
    }

    public void execute() {
        this.mDelegate.execute();
    }

    public long executeInsert() {
        return this.mDelegate.executeInsert();
    }

    public int executeUpdateDelete() {
        return this.mDelegate.executeUpdateDelete();
    }

    public long simpleQueryForLong() {
        return this.mDelegate.simpleQueryForLong();
    }

    public String simpleQueryForString() {
        return this.mDelegate.simpleQueryForString();
    }
}
