package androidx.compose.ui.node;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Ref<T> {
    public static final int $stable = 8;

    @Nullable
    private T value;

    @Nullable
    public final T getValue() {
        return this.value;
    }

    public final void setValue(@Nullable T t) {
        this.value = t;
    }
}
