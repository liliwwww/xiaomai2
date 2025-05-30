package androidx.compose.ui.semantics;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface SemanticsPropertyReceiver {
    <T> void set(@NotNull SemanticsPropertyKey<T> semanticsPropertyKey, T t);
}
