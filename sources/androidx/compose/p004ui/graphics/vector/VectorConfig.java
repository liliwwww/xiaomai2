package androidx.compose.p004ui.graphics.vector;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.cy5;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface VectorConfig {

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <T> T getOrDefault(@NotNull VectorConfig vectorConfig, @NotNull VectorProperty<T> vectorProperty, T t) {
            Intrinsics.checkNotNullParameter(vectorProperty, "property");
            return (T) cy5.b(vectorConfig, vectorProperty, t);
        }
    }

    <T> T getOrDefault(@NotNull VectorProperty<T> vectorProperty, T t);
}
