package androidx.compose.foundation.lazy;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface LazyListItemInfo {
    int getIndex();

    @NotNull
    Object getKey();

    int getOffset();

    int getSize();
}
