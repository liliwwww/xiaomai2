package androidx.core.os;

import android.os.Trace;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class TraceCompat$Api29Impl {
    private TraceCompat$Api29Impl() {
    }

    @DoNotInline
    static void beginAsyncSection(String str, int i) {
        Trace.beginAsyncSection(str, i);
    }

    @DoNotInline
    static void endAsyncSection(String str, int i) {
        Trace.endAsyncSection(str, i);
    }

    @DoNotInline
    static boolean isEnabled() {
        return Trace.isEnabled();
    }

    @DoNotInline
    static void setCounter(String str, long j) {
        Trace.setCounter(str, j);
    }
}
