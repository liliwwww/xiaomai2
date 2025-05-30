package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final /* synthetic */ class o implements Function {
    public final /* synthetic */ AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement a;
    public final /* synthetic */ Function b;

    public /* synthetic */ o(AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement, Function function) {
        this.a = autoClosingSupportSqliteStatement;
        this.b = function;
    }

    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement.b(this.a, this.b, (SupportSQLiteDatabase) obj);
    }
}
