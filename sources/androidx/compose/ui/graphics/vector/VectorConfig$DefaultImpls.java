package androidx.compose.ui.graphics.vector;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.cy5;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VectorConfig$DefaultImpls {
    @Deprecated
    public static <T> T getOrDefault(@NotNull VectorConfig vectorConfig, @NotNull VectorProperty<T> vectorProperty, T t) {
        Intrinsics.checkNotNullParameter(vectorProperty, "property");
        return (T) cy5.b(vectorConfig, vectorProperty, t);
    }
}
