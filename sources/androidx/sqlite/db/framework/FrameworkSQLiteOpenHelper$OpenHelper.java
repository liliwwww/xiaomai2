package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Callback;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FrameworkSQLiteOpenHelper$OpenHelper extends SQLiteOpenHelper {
    final SupportSQLiteOpenHelper$Callback mCallback;
    final FrameworkSQLiteDatabase[] mDbRef;
    private boolean mMigrated;

    FrameworkSQLiteOpenHelper$OpenHelper(Context context, String str, final FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, final SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback) {
        super(context, str, null, supportSQLiteOpenHelper$Callback.version, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper.1
            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                SupportSQLiteOpenHelper$Callback.this.onCorruption(FrameworkSQLiteOpenHelper$OpenHelper.getWrappedDb(frameworkSQLiteDatabaseArr, sQLiteDatabase));
            }
        });
        this.mCallback = supportSQLiteOpenHelper$Callback;
        this.mDbRef = frameworkSQLiteDatabaseArr;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
        this.mDbRef[0] = null;
    }

    synchronized SupportSQLiteDatabase getReadableSupportDatabase() {
        this.mMigrated = false;
        SQLiteDatabase readableDatabase = super.getReadableDatabase();
        if (!this.mMigrated) {
            return getWrappedDb(readableDatabase);
        }
        close();
        return getReadableSupportDatabase();
    }

    FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
        return getWrappedDb(this.mDbRef, sQLiteDatabase);
    }

    synchronized SupportSQLiteDatabase getWritableSupportDatabase() {
        this.mMigrated = false;
        SQLiteDatabase writableDatabase = super.getWritableDatabase();
        if (!this.mMigrated) {
            return getWrappedDb(writableDatabase);
        }
        close();
        return getWritableSupportDatabase();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.mCallback.onConfigure(getWrappedDb(sQLiteDatabase));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.mCallback.onCreate(getWrappedDb(sQLiteDatabase));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.mMigrated = true;
        this.mCallback.onDowngrade(getWrappedDb(sQLiteDatabase), i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (this.mMigrated) {
            return;
        }
        this.mCallback.onOpen(getWrappedDb(sQLiteDatabase));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.mMigrated = true;
        this.mCallback.onUpgrade(getWrappedDb(sQLiteDatabase), i, i2);
    }

    static FrameworkSQLiteDatabase getWrappedDb(FrameworkSQLiteDatabase[] frameworkSQLiteDatabaseArr, SQLiteDatabase sQLiteDatabase) {
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = frameworkSQLiteDatabaseArr[0];
        if (frameworkSQLiteDatabase == null || !frameworkSQLiteDatabase.isDelegate(sQLiteDatabase)) {
            frameworkSQLiteDatabaseArr[0] = new FrameworkSQLiteDatabase(sQLiteDatabase);
        }
        return frameworkSQLiteDatabaseArr[0];
    }
}
