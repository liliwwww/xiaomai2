package androidx.room;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class QueryInterceptorOpenHelper implements DelegatingOpenHelper, SupportSQLiteOpenHelper {
    private final SupportSQLiteOpenHelper mDelegate;
    private final RoomDatabase$QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    QueryInterceptorOpenHelper(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper, @NonNull RoomDatabase$QueryCallback roomDatabase$QueryCallback, @NonNull Executor executor) {
        this.mDelegate = supportSQLiteOpenHelper;
        this.mQueryCallback = roomDatabase$QueryCallback;
        this.mQueryCallbackExecutor = executor;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @Nullable
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @NonNull
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return new QueryInterceptorDatabase(this.mDelegate.getReadableDatabase(), this.mQueryCallback, this.mQueryCallbackExecutor);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return new QueryInterceptorDatabase(this.mDelegate.getWritableDatabase(), this.mQueryCallback, this.mQueryCallbackExecutor);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.mDelegate.setWriteAheadLoggingEnabled(z);
    }
}
