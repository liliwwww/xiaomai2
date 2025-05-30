package androidx.room;

import androidx.annotation.NonNull;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class QueryInterceptorOpenHelperFactory implements SupportSQLiteOpenHelper$Factory {
    private final SupportSQLiteOpenHelper$Factory mDelegate;
    private final RoomDatabase.QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    QueryInterceptorOpenHelperFactory(@NonNull SupportSQLiteOpenHelper$Factory supportSQLiteOpenHelper$Factory, @NonNull RoomDatabase.QueryCallback queryCallback, @NonNull Executor executor) {
        this.mDelegate = supportSQLiteOpenHelper$Factory;
        this.mQueryCallback = queryCallback;
        this.mQueryCallbackExecutor = executor;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
    @NonNull
    public SupportSQLiteOpenHelper create(@NonNull SupportSQLiteOpenHelper$Configuration supportSQLiteOpenHelper$Configuration) {
        return new QueryInterceptorOpenHelper(this.mDelegate.create(supportSQLiteOpenHelper$Configuration), this.mQueryCallback, this.mQueryCallbackExecutor);
    }
}
