package androidx.tracing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(@NonNull String str, int i) {
        android.os.Trace.beginAsyncSection(str, i);
    }

    public static void endAsyncSection(@NonNull String str, int i) {
        android.os.Trace.endAsyncSection(str, i);
    }

    public static void setCounter(@NonNull String str, int i) {
        android.os.Trace.setCounter(str, i);
    }
}
