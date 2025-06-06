package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* compiled from: Taobao */
@Deprecated
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TraceCompat {
    private static final String TAG = "TraceCompat";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    /* compiled from: Taobao */
    @RequiresApi(18)
    static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static void beginSection(String str) {
            Trace.beginSection(str);
        }

        @DoNotInline
        static void endSection() {
            Trace.endSection();
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i < 18 || i >= 29) {
            return;
        }
        try {
            sTraceTagApp = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            Class cls = Long.TYPE;
            sIsTagEnabledMethod = Trace.class.getMethod("isTagEnabled", cls);
            Class cls2 = Integer.TYPE;
            sAsyncTraceBeginMethod = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
            sAsyncTraceEndMethod = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
            sTraceCounterMethod = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
        } catch (Exception e) {
            Log.i(TAG, "Unable to initialize via reflection.", e);
        }
    }

    private TraceCompat() {
    }

    public static void beginAsyncSection(@NonNull String str, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            Api29Impl.beginAsyncSection(str, i);
        } else if (i2 >= 18) {
            try {
                sAsyncTraceBeginMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i));
            } catch (Exception unused) {
                Log.v(TAG, "Unable to invoke asyncTraceBegin() via reflection.");
            }
        }
    }

    public static void beginSection(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Api18Impl.beginSection(str);
        }
    }

    public static void endAsyncSection(@NonNull String str, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            Api29Impl.endAsyncSection(str, i);
        } else if (i2 >= 18) {
            try {
                sAsyncTraceEndMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i));
            } catch (Exception unused) {
                Log.v(TAG, "Unable to invoke endAsyncSection() via reflection.");
            }
        }
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            Api18Impl.endSection();
        }
    }

    public static boolean isEnabled() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            return Api29Impl.isEnabled();
        }
        if (i >= 18) {
            try {
                return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
            } catch (Exception unused) {
                Log.v(TAG, "Unable to invoke isTagEnabled() via reflection.");
            }
        }
        return false;
    }

    public static void setCounter(@NonNull String str, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            Api29Impl.setCounter(str, i);
        } else if (i2 >= 18) {
            try {
                sTraceCounterMethod.invoke(null, Long.valueOf(sTraceTagApp), str, Integer.valueOf(i));
            } catch (Exception unused) {
                Log.v(TAG, "Unable to invoke traceCounter() via reflection.");
            }
        }
    }
}
