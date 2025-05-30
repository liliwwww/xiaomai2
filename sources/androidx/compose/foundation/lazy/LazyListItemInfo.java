package androidx.compose.foundation.lazy;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface LazyListItemInfo {
    int getIndex();

    @NotNull
    Object getKey();

    int getOffset();

    int getSize();
}
