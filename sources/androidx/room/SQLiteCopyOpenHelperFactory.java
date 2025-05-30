package androidx.room;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration;
import androidx.sqlite.db.SupportSQLiteOpenHelper$Factory;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper$Factory {

    @Nullable
    private final String mCopyFromAssetPath;

    @Nullable
    private final File mCopyFromFile;

    @Nullable
    private final Callable<InputStream> mCopyFromInputStream;

    @NonNull
    private final SupportSQLiteOpenHelper$Factory mDelegate;

    SQLiteCopyOpenHelperFactory(@Nullable String str, @Nullable File file, @Nullable Callable<InputStream> callable, @NonNull SupportSQLiteOpenHelper$Factory supportSQLiteOpenHelper$Factory) {
        this.mCopyFromAssetPath = str;
        this.mCopyFromFile = file;
        this.mCopyFromInputStream = callable;
        this.mDelegate = supportSQLiteOpenHelper$Factory;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper$Factory
    @NonNull
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper$Configuration supportSQLiteOpenHelper$Configuration) {
        return new SQLiteCopyOpenHelper(supportSQLiteOpenHelper$Configuration.context, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, supportSQLiteOpenHelper$Configuration.callback.version, this.mDelegate.create(supportSQLiteOpenHelper$Configuration));
    }
}
