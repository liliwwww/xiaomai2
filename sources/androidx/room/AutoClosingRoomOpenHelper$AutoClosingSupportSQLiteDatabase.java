package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import tb.ca5;
import tb.nd;
import tb.od;
import tb.pd;
import tb.qd;
import tb.rd;
import tb.sd;
import tb.td;
import tb.ud;
import tb.vd;
import tb.wd;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {

    @NonNull
    private final AutoCloser mAutoCloser;

    AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase(@NonNull AutoCloser autoCloser) {
        this.mAutoCloser = autoCloser;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$delete$5(String str, String str2, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
        return Integer.valueOf(supportSQLiteDatabase.delete(str, str2, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$execSQL$7(String str, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$execSQL$8(String str, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(str, objArr);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$insert$4(String str, int i, ContentValues contentValues, SupportSQLiteDatabase supportSQLiteDatabase) {
        return Long.valueOf(supportSQLiteDatabase.insert(str, i, contentValues));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$isWriteAheadLoggingEnabled$13(SupportSQLiteDatabase supportSQLiteDatabase) {
        return Build.VERSION.SDK_INT >= 16 ? Boolean.valueOf(supportSQLiteDatabase.isWriteAheadLoggingEnabled()) : Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$needUpgrade$9(int i, SupportSQLiteDatabase supportSQLiteDatabase) {
        return Boolean.valueOf(supportSQLiteDatabase.needUpgrade(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$pokeOpen$0(SupportSQLiteDatabase supportSQLiteDatabase) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$setForeignKeyConstraintsEnabled$12(boolean z, SupportSQLiteDatabase supportSQLiteDatabase) {
        if (Build.VERSION.SDK_INT < 16) {
            return null;
        }
        supportSQLiteDatabase.setForeignKeyConstraintsEnabled(z);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$setLocale$10(Locale locale, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.setLocale(locale);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$setMaxSqlCacheSize$11(int i, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.setMaxSqlCacheSize(i);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long lambda$setMaximumSize$2(long j, SupportSQLiteDatabase supportSQLiteDatabase) {
        return Long.valueOf(supportSQLiteDatabase.setMaximumSize(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$setPageSize$3(long j, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.setPageSize(j);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$setVersion$1(int i, SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.setVersion(i);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$update$6(String str, int i, ContentValues contentValues, String str2, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
        return Integer.valueOf(supportSQLiteDatabase.update(str, i, contentValues, str2, objArr));
    }

    public void beginTransaction() {
        try {
            this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();
        } catch (Throwable th) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }
    }

    public void beginTransactionNonExclusive() {
        try {
            this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();
        } catch (Throwable th) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        try {
            this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(sQLiteTransactionListener);
        } catch (Throwable th) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        try {
            this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
        } catch (Throwable th) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }
    }

    public void close() throws IOException {
        this.mAutoCloser.closeDatabaseIfOpen();
    }

    public SupportSQLiteStatement compileStatement(String str) {
        return new AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement(str, this.mAutoCloser);
    }

    public int delete(final String str, final String str2, final Object[] objArr) {
        return ((Integer) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.m
            public final Object apply(Object obj) {
                Integer lambda$delete$5;
                lambda$delete$5 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$delete$5(str, str2, objArr, (SupportSQLiteDatabase) obj);
                return lambda$delete$5;
            }
        })).intValue();
    }

    public void disableWriteAheadLogging() {
        throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
    }

    public boolean enableWriteAheadLogging() {
        throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
    }

    public void endTransaction() {
        if (this.mAutoCloser.getDelegateDatabase() == null) {
            throw new IllegalStateException("End transaction called but delegateDb is null");
        }
        try {
            this.mAutoCloser.getDelegateDatabase().endTransaction();
        } finally {
            this.mAutoCloser.decrementCountAndScheduleClose();
        }
    }

    public /* synthetic */ void execPerConnectionSQL(String str, Object[] objArr) {
        ca5.a(this, str, objArr);
    }

    public void execSQL(final String str) throws SQLException {
        this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.j
            public final Object apply(Object obj) {
                Object lambda$execSQL$7;
                lambda$execSQL$7 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$execSQL$7(str, (SupportSQLiteDatabase) obj);
                return lambda$execSQL$7;
            }
        });
    }

    public List<Pair<String, String>> getAttachedDbs() {
        return (List) this.mAutoCloser.executeRefCountingFunction(nd.a);
    }

    public long getMaximumSize() {
        return ((Long) this.mAutoCloser.executeRefCountingFunction(vd.a)).longValue();
    }

    public long getPageSize() {
        return ((Long) this.mAutoCloser.executeRefCountingFunction(wd.a)).longValue();
    }

    public String getPath() {
        return (String) this.mAutoCloser.executeRefCountingFunction(od.a);
    }

    public int getVersion() {
        return ((Integer) this.mAutoCloser.executeRefCountingFunction(pd.a)).intValue();
    }

    public boolean inTransaction() {
        if (this.mAutoCloser.getDelegateDatabase() == null) {
            return false;
        }
        return ((Boolean) this.mAutoCloser.executeRefCountingFunction(qd.a)).booleanValue();
    }

    public long insert(final String str, final int i, final ContentValues contentValues) throws SQLException {
        return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.k
            public final Object apply(Object obj) {
                Long lambda$insert$4;
                lambda$insert$4 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$insert$4(str, i, contentValues, (SupportSQLiteDatabase) obj);
                return lambda$insert$4;
            }
        })).longValue();
    }

    public boolean isDatabaseIntegrityOk() {
        return ((Boolean) this.mAutoCloser.executeRefCountingFunction(rd.a)).booleanValue();
    }

    public boolean isDbLockedByCurrentThread() {
        if (this.mAutoCloser.getDelegateDatabase() == null) {
            return false;
        }
        return ((Boolean) this.mAutoCloser.executeRefCountingFunction(sd.a)).booleanValue();
    }

    public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
        return ca5.b(this);
    }

    public boolean isOpen() {
        SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
        if (delegateDatabase == null) {
            return false;
        }
        return delegateDatabase.isOpen();
    }

    public boolean isReadOnly() {
        return ((Boolean) this.mAutoCloser.executeRefCountingFunction(td.a)).booleanValue();
    }

    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.d
            public final Object apply(Object obj) {
                Boolean lambda$isWriteAheadLoggingEnabled$13;
                lambda$isWriteAheadLoggingEnabled$13 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$isWriteAheadLoggingEnabled$13((SupportSQLiteDatabase) obj);
                return lambda$isWriteAheadLoggingEnabled$13;
            }
        })).booleanValue();
    }

    public boolean needUpgrade(final int i) {
        return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.a
            public final Object apply(Object obj) {
                Boolean lambda$needUpgrade$9;
                lambda$needUpgrade$9 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$needUpgrade$9(i, (SupportSQLiteDatabase) obj);
                return lambda$needUpgrade$9;
            }
        })).booleanValue();
    }

    void pokeOpen() {
        this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.e
            public final Object apply(Object obj) {
                Object lambda$pokeOpen$0;
                lambda$pokeOpen$0 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$pokeOpen$0((SupportSQLiteDatabase) obj);
                return lambda$pokeOpen$0;
            }
        });
    }

    public Cursor query(String str) {
        try {
            return new AutoClosingRoomOpenHelper.KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(str), this.mAutoCloser);
        } catch (Throwable th) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }
    }

    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(final boolean z) {
        this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.c
            public final Object apply(Object obj) {
                Object lambda$setForeignKeyConstraintsEnabled$12;
                lambda$setForeignKeyConstraintsEnabled$12 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$setForeignKeyConstraintsEnabled$12(z, (SupportSQLiteDatabase) obj);
                return lambda$setForeignKeyConstraintsEnabled$12;
            }
        });
    }

    public void setLocale(final Locale locale) {
        this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.b
            public final Object apply(Object obj) {
                Object lambda$setLocale$10;
                lambda$setLocale$10 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$setLocale$10(locale, (SupportSQLiteDatabase) obj);
                return lambda$setLocale$10;
            }
        });
    }

    public void setMaxSqlCacheSize(final int i) {
        this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.f
            public final Object apply(Object obj) {
                Object lambda$setMaxSqlCacheSize$11;
                lambda$setMaxSqlCacheSize$11 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$setMaxSqlCacheSize$11(i, (SupportSQLiteDatabase) obj);
                return lambda$setMaxSqlCacheSize$11;
            }
        });
    }

    public long setMaximumSize(final long j) {
        return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.i
            public final Object apply(Object obj) {
                Long lambda$setMaximumSize$2;
                lambda$setMaximumSize$2 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$setMaximumSize$2(j, (SupportSQLiteDatabase) obj);
                return lambda$setMaximumSize$2;
            }
        })).longValue();
    }

    public void setPageSize(final long j) {
        this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.h
            public final Object apply(Object obj) {
                Object lambda$setPageSize$3;
                lambda$setPageSize$3 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$setPageSize$3(j, (SupportSQLiteDatabase) obj);
                return lambda$setPageSize$3;
            }
        });
    }

    public void setTransactionSuccessful() {
        SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
        if (delegateDatabase == null) {
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        }
        delegateDatabase.setTransactionSuccessful();
    }

    public void setVersion(final int i) {
        this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.g
            public final Object apply(Object obj) {
                Object lambda$setVersion$1;
                lambda$setVersion$1 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$setVersion$1(i, (SupportSQLiteDatabase) obj);
                return lambda$setVersion$1;
            }
        });
    }

    public int update(final String str, final int i, final ContentValues contentValues, final String str2, final Object[] objArr) {
        return ((Integer) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.l
            public final Object apply(Object obj) {
                Integer lambda$update$6;
                lambda$update$6 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$update$6(str, i, contentValues, str2, objArr, (SupportSQLiteDatabase) obj);
                return lambda$update$6;
            }
        })).intValue();
    }

    public boolean yieldIfContendedSafely() {
        return ((Boolean) this.mAutoCloser.executeRefCountingFunction(ud.a)).booleanValue();
    }

    public void execSQL(final String str, final Object[] objArr) throws SQLException {
        this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.n
            public final Object apply(Object obj) {
                Object lambda$execSQL$8;
                lambda$execSQL$8 = AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase.lambda$execSQL$8(str, objArr, (SupportSQLiteDatabase) obj);
                return lambda$execSQL$8;
            }
        });
    }

    public boolean yieldIfContendedSafely(long j) {
        return ((Boolean) this.mAutoCloser.executeRefCountingFunction(ud.a)).booleanValue();
    }

    public Cursor query(String str, Object[] objArr) {
        try {
            return new AutoClosingRoomOpenHelper.KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(str, objArr), this.mAutoCloser);
        } catch (Throwable th) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        try {
            return new AutoClosingRoomOpenHelper.KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery), this.mAutoCloser);
        } catch (Throwable th) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }
    }

    @RequiresApi(api = 24)
    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        try {
            return new AutoClosingRoomOpenHelper.KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery, cancellationSignal), this.mAutoCloser);
        } catch (Throwable th) {
            this.mAutoCloser.decrementCountAndScheduleClose();
            throw th;
        }
    }
}
