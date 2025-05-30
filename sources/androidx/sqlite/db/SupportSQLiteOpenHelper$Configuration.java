package androidx.sqlite.db;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class SupportSQLiteOpenHelper$Configuration {

    @NonNull
    public final SupportSQLiteOpenHelper$Callback callback;

    @NonNull
    public final Context context;

    @Nullable
    public final String name;
    public final boolean useNoBackupDirectory;

    /* compiled from: Taobao */
    public static class Builder {
        SupportSQLiteOpenHelper$Callback mCallback;
        Context mContext;
        String mName;
        boolean mUseNoBackupDirectory;

        Builder(@NonNull Context context) {
            this.mContext = context;
        }

        @NonNull
        public SupportSQLiteOpenHelper$Configuration build() {
            if (this.mCallback == null) {
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            }
            if (this.mContext == null) {
                throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
            }
            if (this.mUseNoBackupDirectory && TextUtils.isEmpty(this.mName)) {
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
            }
            return new SupportSQLiteOpenHelper$Configuration(this.mContext, this.mName, this.mCallback, this.mUseNoBackupDirectory);
        }

        @NonNull
        public Builder callback(@NonNull SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback) {
            this.mCallback = supportSQLiteOpenHelper$Callback;
            return this;
        }

        @NonNull
        public Builder name(@Nullable String str) {
            this.mName = str;
            return this;
        }

        @NonNull
        public Builder noBackupDirectory(boolean z) {
            this.mUseNoBackupDirectory = z;
            return this;
        }
    }

    SupportSQLiteOpenHelper$Configuration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback) {
        this(context, str, supportSQLiteOpenHelper$Callback, false);
    }

    @NonNull
    public static Builder builder(@NonNull Context context) {
        return new Builder(context);
    }

    SupportSQLiteOpenHelper$Configuration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper$Callback supportSQLiteOpenHelper$Callback, boolean z) {
        this.context = context;
        this.name = str;
        this.callback = supportSQLiteOpenHelper$Callback;
        this.useNoBackupDirectory = z;
    }
}
