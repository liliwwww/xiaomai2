package androidx.compose.ui.text.platform;

import androidx.compose.runtime.State;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ImmutableBool implements State<Boolean> {
    private final boolean value;

    public ImmutableBool(boolean z) {
        this.value = z;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.State
    @NotNull
    public Boolean getValue() {
        return Boolean.valueOf(this.value);
    }
}
