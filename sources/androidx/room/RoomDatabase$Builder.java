package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class RoomDatabase$Builder<T extends RoomDatabase> {
    private boolean mAllowDestructiveMigrationOnDowngrade;
    private boolean mAllowMainThreadQueries;
    private TimeUnit mAutoCloseTimeUnit;
    private List<AutoMigrationSpec> mAutoMigrationSpecs;
    private ArrayList<RoomDatabase.Callback> mCallbacks;
    private final Context mContext;
    private String mCopyFromAssetPath;
    private File mCopyFromFile;
    private Callable<InputStream> mCopyFromInputStream;
    private final Class<T> mDatabaseClass;
    private SupportSQLiteOpenHelper.Factory mFactory;
    private Set<Integer> mMigrationStartAndEndVersions;
    private Set<Integer> mMigrationsNotRequiredFrom;
    private Intent mMultiInstanceInvalidationIntent;
    private final String mName;
    private RoomDatabase.PrepackagedDatabaseCallback mPrepackagedDatabaseCallback;
    private RoomDatabase$QueryCallback mQueryCallback;
    private Executor mQueryCallbackExecutor;
    private Executor mQueryExecutor;
    private Executor mTransactionExecutor;
    private List<Object> mTypeConverters;
    private long mAutoCloseTimeout = -1;
    private RoomDatabase$JournalMode mJournalMode = RoomDatabase$JournalMode.AUTOMATIC;
    private boolean mRequireMigration = true;
    private final RoomDatabase$MigrationContainer mMigrationContainer = new RoomDatabase$MigrationContainer();

    RoomDatabase$Builder(@NonNull Context context, @NonNull Class<T> cls, @Nullable String str) {
        this.mContext = context;
        this.mDatabaseClass = cls;
        this.mName = str;
    }

    @NonNull
    public RoomDatabase$Builder<T> addAutoMigrationSpec(@NonNull AutoMigrationSpec autoMigrationSpec) {
        if (this.mAutoMigrationSpecs == null) {
            this.mAutoMigrationSpecs = new ArrayList();
        }
        this.mAutoMigrationSpecs.add(autoMigrationSpec);
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> addCallback(@NonNull RoomDatabase.Callback callback) {
        if (this.mCallbacks == null) {
            this.mCallbacks = new ArrayList<>();
        }
        this.mCallbacks.add(callback);
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> addMigrations(@NonNull Migration... migrationArr) {
        if (this.mMigrationStartAndEndVersions == null) {
            this.mMigrationStartAndEndVersions = new HashSet();
        }
        for (Migration migration : migrationArr) {
            this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
            this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
        }
        this.mMigrationContainer.addMigrations(migrationArr);
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> addTypeConverter(@NonNull Object obj) {
        if (this.mTypeConverters == null) {
            this.mTypeConverters = new ArrayList();
        }
        this.mTypeConverters.add(obj);
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> allowMainThreadQueries() {
        this.mAllowMainThreadQueries = true;
        return this;
    }

    @NonNull
    @SuppressLint({"RestrictedApi"})
    public T build() {
        Executor executor;
        if (this.mContext == null) {
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }
        if (this.mDatabaseClass == null) {
            throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
        }
        Executor executor2 = this.mQueryExecutor;
        if (executor2 == null && this.mTransactionExecutor == null) {
            Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
            this.mTransactionExecutor = iOThreadExecutor;
            this.mQueryExecutor = iOThreadExecutor;
        } else if (executor2 != null && this.mTransactionExecutor == null) {
            this.mTransactionExecutor = executor2;
        } else if (executor2 == null && (executor = this.mTransactionExecutor) != null) {
            this.mQueryExecutor = executor;
        }
        Set<Integer> set = this.mMigrationStartAndEndVersions;
        if (set != null && this.mMigrationsNotRequiredFrom != null) {
            for (Integer num : set) {
                if (this.mMigrationsNotRequiredFrom.contains(num)) {
                    throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                }
            }
        }
        FrameworkSQLiteOpenHelperFactory frameworkSQLiteOpenHelperFactory = this.mFactory;
        if (frameworkSQLiteOpenHelperFactory == null) {
            frameworkSQLiteOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
        }
        long j = this.mAutoCloseTimeout;
        if (j > 0) {
            if (this.mName == null) {
                throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
            }
            frameworkSQLiteOpenHelperFactory = new AutoClosingRoomOpenHelperFactory(frameworkSQLiteOpenHelperFactory, new AutoCloser(j, this.mAutoCloseTimeUnit, this.mTransactionExecutor));
        }
        String str = this.mCopyFromAssetPath;
        if (str != null || this.mCopyFromFile != null || this.mCopyFromInputStream != null) {
            if (this.mName == null) {
                throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
            }
            int i = str == null ? 0 : 1;
            File file = this.mCopyFromFile;
            int i2 = i + (file == null ? 0 : 1);
            Callable<InputStream> callable = this.mCopyFromInputStream;
            if (i2 + (callable != null ? 1 : 0) != 1) {
                throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
            }
            frameworkSQLiteOpenHelperFactory = new SQLiteCopyOpenHelperFactory(str, file, callable, frameworkSQLiteOpenHelperFactory);
        }
        RoomDatabase$QueryCallback roomDatabase$QueryCallback = this.mQueryCallback;
        FrameworkSQLiteOpenHelperFactory queryInterceptorOpenHelperFactory = roomDatabase$QueryCallback != null ? new QueryInterceptorOpenHelperFactory(frameworkSQLiteOpenHelperFactory, roomDatabase$QueryCallback, this.mQueryCallbackExecutor) : frameworkSQLiteOpenHelperFactory;
        Context context = this.mContext;
        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, this.mName, (SupportSQLiteOpenHelper.Factory) queryInterceptorOpenHelperFactory, this.mMigrationContainer, (List<RoomDatabase.Callback>) this.mCallbacks, this.mAllowMainThreadQueries, this.mJournalMode.resolve(context), this.mQueryExecutor, this.mTransactionExecutor, this.mMultiInstanceInvalidationIntent, this.mRequireMigration, this.mAllowDestructiveMigrationOnDowngrade, this.mMigrationsNotRequiredFrom, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, this.mPrepackagedDatabaseCallback, this.mTypeConverters, this.mAutoMigrationSpecs);
        T t = (T) Room.getGeneratedImplementation(this.mDatabaseClass, "_Impl");
        t.init(databaseConfiguration);
        return t;
    }

    @NonNull
    public RoomDatabase$Builder<T> createFromAsset(@NonNull String str) {
        this.mCopyFromAssetPath = str;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> createFromFile(@NonNull File file) {
        this.mCopyFromFile = file;
        return this;
    }

    @NonNull
    @SuppressLint({"BuilderSetStyle"})
    public RoomDatabase$Builder<T> createFromInputStream(@NonNull Callable<InputStream> callable) {
        this.mCopyFromInputStream = callable;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> enableMultiInstanceInvalidation() {
        this.mMultiInstanceInvalidationIntent = this.mName != null ? new Intent(this.mContext, (Class<?>) MultiInstanceInvalidationService.class) : null;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> fallbackToDestructiveMigration() {
        this.mRequireMigration = false;
        this.mAllowDestructiveMigrationOnDowngrade = true;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> fallbackToDestructiveMigrationFrom(int... iArr) {
        if (this.mMigrationsNotRequiredFrom == null) {
            this.mMigrationsNotRequiredFrom = new HashSet(iArr.length);
        }
        for (int i : iArr) {
            this.mMigrationsNotRequiredFrom.add(Integer.valueOf(i));
        }
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
        this.mRequireMigration = true;
        this.mAllowDestructiveMigrationOnDowngrade = true;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> openHelperFactory(@Nullable SupportSQLiteOpenHelper.Factory factory) {
        this.mFactory = factory;
        return this;
    }

    @NonNull
    @ExperimentalRoomApi
    public RoomDatabase$Builder<T> setAutoCloseTimeout(@IntRange(from = 0) long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
        }
        this.mAutoCloseTimeout = j;
        this.mAutoCloseTimeUnit = timeUnit;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> setJournalMode(@NonNull RoomDatabase$JournalMode roomDatabase$JournalMode) {
        this.mJournalMode = roomDatabase$JournalMode;
        return this;
    }

    @NonNull
    @ExperimentalRoomApi
    public RoomDatabase$Builder<T> setMultiInstanceInvalidationServiceIntent(@NonNull Intent intent) {
        if (this.mName == null) {
            intent = null;
        }
        this.mMultiInstanceInvalidationIntent = intent;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> setQueryCallback(@NonNull RoomDatabase$QueryCallback roomDatabase$QueryCallback, @NonNull Executor executor) {
        this.mQueryCallback = roomDatabase$QueryCallback;
        this.mQueryCallbackExecutor = executor;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> setQueryExecutor(@NonNull Executor executor) {
        this.mQueryExecutor = executor;
        return this;
    }

    @NonNull
    public RoomDatabase$Builder<T> setTransactionExecutor(@NonNull Executor executor) {
        this.mTransactionExecutor = executor;
        return this;
    }

    @NonNull
    @SuppressLint({"BuilderSetStyle"})
    public RoomDatabase$Builder<T> createFromAsset(@NonNull String str, @NonNull RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        this.mPrepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.mCopyFromAssetPath = str;
        return this;
    }

    @NonNull
    @SuppressLint({"BuilderSetStyle", "StreamFiles"})
    public RoomDatabase$Builder<T> createFromFile(@NonNull File file, @NonNull RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        this.mPrepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.mCopyFromFile = file;
        return this;
    }

    @NonNull
    @SuppressLint({"BuilderSetStyle", "LambdaLast"})
    public RoomDatabase$Builder<T> createFromInputStream(@NonNull Callable<InputStream> callable, @NonNull RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        this.mPrepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.mCopyFromInputStream = callable;
        return this;
    }
}
