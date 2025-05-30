package androidx.compose.runtime.saveable;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Saver<Original, Saveable> {
    @Nullable
    Original restore(@NotNull Saveable saveable);

    @Nullable
    Saveable save(@NotNull SaverScope saverScope, Original original);
}
