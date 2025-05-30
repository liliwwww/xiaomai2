package androidx.compose.runtime.internal;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ThreadMapKt {

    @NotNull
    private static final ThreadMap emptyThreadMap = new ThreadMap(0, new long[0], new Object[0]);

    @NotNull
    public static final ThreadMap getEmptyThreadMap() {
        return emptyThreadMap;
    }
}
