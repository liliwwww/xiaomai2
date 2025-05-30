package androidx.compose.ui.state;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ToggleableStateKt {
    @NotNull
    public static final ToggleableState ToggleableState(boolean z) {
        return z ? ToggleableState.On : ToggleableState.Off;
    }
}
