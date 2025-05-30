package androidx.core.os;

import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TraceKt {
    @Deprecated(message = "Use androidx.tracing.Trace instead", replaceWith = @ReplaceWith(expression = "trace(sectionName)", imports = {"androidx.tracing.trace"}))
    public static final <T> T trace(@NotNull String str, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(str, "sectionName");
        Intrinsics.checkNotNullParameter(function0, "block");
        TraceCompat.beginSection(str);
        try {
            return (T) function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            TraceCompat.endSection();
            InlineMarker.finallyEnd(1);
        }
    }
}
