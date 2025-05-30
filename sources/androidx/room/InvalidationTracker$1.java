package androidx.room;

import android.database.Cursor;
import androidx.sqlite.db.SimpleSQLiteQuery;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class InvalidationTracker$1 implements Runnable {
    final /* synthetic */ InvalidationTracker this$0;

    InvalidationTracker$1(InvalidationTracker invalidationTracker) {
        this.this$0 = invalidationTracker;
    }

    private Set<Integer> checkUpdatedTable() {
        HashSet hashSet = new HashSet();
        Cursor query = this.this$0.mDatabase.query(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
        while (query.moveToNext()) {
            try {
                hashSet.add(Integer.valueOf(query.getInt(0)));
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        if (!hashSet.isEmpty()) {
            this.this$0.mCleanupStatement.executeUpdateDelete();
        }
        return hashSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
    
        if (r0 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
    
        r0.decrementCountAndScheduleClose();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0092, code lost:
    
        if (r1 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0098, code lost:
    
        if (r1.isEmpty() != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009a, code lost:
    
        r0 = r5.this$0.mObserverMap;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009e, code lost:
    
        monitor-enter(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009f, code lost:
    
        r2 = r5.this$0.mObserverMap.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ab, code lost:
    
        if (r2.hasNext() == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ad, code lost:
    
        ((androidx.room.InvalidationTracker.ObserverWrapper) ((java.util.Map.Entry) r2.next()).getValue()).notifyByTableInvalidStatus(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bd, code lost:
    
        monitor-exit(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c2, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x008f, code lost:
    
        if (r0 == null) goto L39;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r5 = this;
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.RoomDatabase r0 = r0.mDatabase
            java.util.concurrent.locks.Lock r0 = r0.getCloseLock()
            r0.lock()
            r1 = 0
            androidx.room.InvalidationTracker r2 = r5.this$0     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            boolean r2 = r2.ensureInitialization()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            if (r2 != 0) goto L21
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.AutoCloser r0 = r0.mAutoCloser
            if (r0 == 0) goto L20
            r0.decrementCountAndScheduleClose()
        L20:
            return
        L21:
            androidx.room.InvalidationTracker r2 = r5.this$0     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            java.util.concurrent.atomic.AtomicBoolean r2 = r2.mPendingRefresh     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            r3 = 1
            r4 = 0
            boolean r2 = r2.compareAndSet(r3, r4)     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            if (r2 != 0) goto L3a
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.AutoCloser r0 = r0.mAutoCloser
            if (r0 == 0) goto L39
            r0.decrementCountAndScheduleClose()
        L39:
            return
        L3a:
            androidx.room.InvalidationTracker r2 = r5.this$0     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            androidx.room.RoomDatabase r2 = r2.mDatabase     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            boolean r2 = r2.inTransaction()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            if (r2 == 0) goto L51
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.AutoCloser r0 = r0.mAutoCloser
            if (r0 == 0) goto L50
            r0.decrementCountAndScheduleClose()
        L50:
            return
        L51:
            androidx.room.InvalidationTracker r2 = r5.this$0     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            androidx.room.RoomDatabase r2 = r2.mDatabase     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            androidx.sqlite.db.SupportSQLiteOpenHelper r2 = r2.getOpenHelper()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            androidx.sqlite.db.SupportSQLiteDatabase r2 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            r2.beginTransactionNonExclusive()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            java.util.Set r1 = r5.checkUpdatedTable()     // Catch: java.lang.Throwable -> L77
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L77
            r2.endTransaction()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.AutoCloser r0 = r0.mAutoCloser
            if (r0 == 0) goto L92
        L73:
            r0.decrementCountAndScheduleClose()
            goto L92
        L77:
            r3 = move-exception
            r2.endTransaction()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
            throw r3     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteException -> L7e java.lang.IllegalStateException -> L80
        L7c:
            r1 = move-exception
            goto Lc3
        L7e:
            r2 = move-exception
            goto L81
        L80:
            r2 = move-exception
        L81:
            java.lang.String r3 = "ROOM"
            java.lang.String r4 = "Cannot run invalidation tracker. Is the db closed?"
            android.util.Log.e(r3, r4, r2)     // Catch: java.lang.Throwable -> L7c
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.AutoCloser r0 = r0.mAutoCloser
            if (r0 == 0) goto L92
            goto L73
        L92:
            if (r1 == 0) goto Lc2
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto Lc2
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.arch.core.internal.SafeIterableMap r0 = r0.mObserverMap
            monitor-enter(r0)
            androidx.room.InvalidationTracker r2 = r5.this$0     // Catch: java.lang.Throwable -> Lbf
            androidx.arch.core.internal.SafeIterableMap r2 = r2.mObserverMap     // Catch: java.lang.Throwable -> Lbf
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> Lbf
        La7:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> Lbf
            if (r3 == 0) goto Lbd
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> Lbf
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> Lbf
            java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> Lbf
            androidx.room.InvalidationTracker$ObserverWrapper r3 = (androidx.room.InvalidationTracker.ObserverWrapper) r3     // Catch: java.lang.Throwable -> Lbf
            r3.notifyByTableInvalidStatus(r1)     // Catch: java.lang.Throwable -> Lbf
            goto La7
        Lbd:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbf
            goto Lc2
        Lbf:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbf
            throw r1
        Lc2:
            return
        Lc3:
            r0.unlock()
            androidx.room.InvalidationTracker r0 = r5.this$0
            androidx.room.AutoCloser r0 = r0.mAutoCloser
            if (r0 == 0) goto Lcf
            r0.decrementCountAndScheduleClose()
        Lcf:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker$1.run():void");
    }
}
