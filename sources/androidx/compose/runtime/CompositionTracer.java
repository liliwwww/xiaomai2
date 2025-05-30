package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@InternalComposeTracingApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface CompositionTracer {
    boolean isTraceInProgress();

    void traceEventEnd();

    void traceEventStart(int i, int i2, int i3, @NotNull String str);
}
