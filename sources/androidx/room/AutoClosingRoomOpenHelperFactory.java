package androidx.room;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper$Factory {

    @NonNull
    private final AutoCloser mAutoCloser;

    @NonNull
    private final SupportSQLiteOpenHelper$Factory mDelegate;

    AutoClosingRoomOpenHelperFactory(@NonNull SupportSQLiteOpenHelper$Factory supportSQLiteOpenHelper$Factory, @NonNull AutoCloser autoCloser) {
        this.mDelegate = supportSQLiteOpenHelper$Factory;
        this.mAutoCloser = autoCloser;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
    @NonNull
    public AutoClosingRoomOpenHelper create(@NonNull SupportSQLiteOpenHelper$Configuration supportSQLiteOpenHelper$Configuration) {
        return new AutoClosingRoomOpenHelper(this.mDelegate.create(supportSQLiteOpenHelper$Configuration), this.mAutoCloser);
    }
}
