package androidx.sqlite.db;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteCompat;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class SupportSQLiteOpenHelper$Callback {
    private static final String TAG = "SupportSQLite";
    public final int version;

    public SupportSQLiteOpenHelper$Callback(int i) {
        this.version = i;
    }

    private void deleteDatabaseFile(String str) {
        if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
            return;
        }
        Log.w(TAG, "deleting the database file: " + str);
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                SupportSQLiteCompat.Api16Impl.deleteDatabase(new File(str));
            } else {
                try {
                    if (!new File(str).delete()) {
                        Log.e(TAG, "Could not delete the database file " + str);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "error while deleting corrupted database file", e);
                }
            }
        } catch (Exception e2) {
            Log.w(TAG, "delete failed: ", e2);
        }
    }

    public void onConfigure(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public void onCorruption(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        Log.e(TAG, "Corruption reported by sqlite on database: " + supportSQLiteDatabase.getPath());
        if (!supportSQLiteDatabase.isOpen()) {
            deleteDatabaseFile(supportSQLiteDatabase.getPath());
            return;
        }
        List<Pair<String, String>> list = null;
        try {
            try {
                list = supportSQLiteDatabase.getAttachedDbs();
            } catch (SQLiteException unused) {
            }
            try {
                supportSQLiteDatabase.close();
            } catch (IOException unused2) {
            }
        } finally {
            if (list != null) {
                Iterator<Pair<String, String>> it = list.iterator();
                while (it.hasNext()) {
                    deleteDatabaseFile((String) it.next().second);
                }
            } else {
                deleteDatabaseFile(supportSQLiteDatabase.getPath());
            }
        }
    }

    public abstract void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase);

    public void onDowngrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
    }

    public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
    }

    public abstract void onUpgrade(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);
}
