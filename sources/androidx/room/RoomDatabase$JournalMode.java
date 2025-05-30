package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public enum RoomDatabase$JournalMode {
    AUTOMATIC,
    TRUNCATE,
    WRITE_AHEAD_LOGGING;

    private static boolean isLowRamDevice(@NonNull ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return SupportSQLiteCompat.Api19Impl.isLowRamDevice(activityManager);
        }
        return false;
    }

    RoomDatabase$JournalMode resolve(Context context) {
        ActivityManager activityManager;
        return this != AUTOMATIC ? this : (Build.VERSION.SDK_INT < 16 || (activityManager = (ActivityManager) context.getSystemService("activity")) == null || isLowRamDevice(activityManager)) ? TRUNCATE : WRITE_AHEAD_LOGGING;
    }
}
