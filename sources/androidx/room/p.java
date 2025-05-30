package androidx.room;

import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteStatement;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final /* synthetic */ class p implements Function {
    public static final /* synthetic */ p a = new p();

    private /* synthetic */ p() {
    }

    public final Object apply(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement.a((SupportSQLiteStatement) obj);
    }
}
