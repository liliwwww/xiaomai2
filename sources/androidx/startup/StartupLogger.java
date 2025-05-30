package androidx.startup;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
    }

    /* renamed from: e */
    public static void m332e(@NonNull String str, @Nullable Throwable th) {
        Log.e(TAG, str, th);
    }

    /* renamed from: i */
    public static void m333i(@NonNull String str) {
        Log.i(TAG, str);
    }

    /* renamed from: w */
    public static void m334w(@NonNull String str) {
        Log.w(TAG, str);
    }
}
