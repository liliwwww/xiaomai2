package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;

/* compiled from: Taobao */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    protected abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t);

    protected abstract String createQuery();

    public final int handle(T t) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t);
            return acquire.executeUpdateDelete();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> iterable) {
        SupportSQLiteStatement acquire = acquire();
        int i = 0;
        try {
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                i += acquire.executeUpdateDelete();
            }
            return i;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] tArr) {
        SupportSQLiteStatement acquire = acquire();
        try {
            int i = 0;
            for (T t : tArr) {
                bind(acquire, t);
                i += acquire.executeUpdateDelete();
            }
            return i;
        } finally {
            release(acquire);
        }
    }
}
