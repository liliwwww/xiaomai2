package androidx.sqlite.db.framework;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FrameworkSQLiteOpenHelperFactory implements SupportSQLiteOpenHelper$Factory {
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
    @NonNull
    public SupportSQLiteOpenHelper create(@NonNull SupportSQLiteOpenHelper$Configuration supportSQLiteOpenHelper$Configuration) {
        return new FrameworkSQLiteOpenHelper(supportSQLiteOpenHelper$Configuration.context, supportSQLiteOpenHelper$Configuration.name, supportSQLiteOpenHelper$Configuration.callback, supportSQLiteOpenHelper$Configuration.useNoBackupDirectory);
    }
}
