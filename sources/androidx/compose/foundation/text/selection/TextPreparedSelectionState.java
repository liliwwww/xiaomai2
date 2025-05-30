package androidx.compose.foundation.text.selection;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextPreparedSelectionState {

    @Nullable
    private Float cachedX;

    @Nullable
    public final Float getCachedX() {
        return this.cachedX;
    }

    public final void resetCachedX() {
        this.cachedX = null;
    }

    public final void setCachedX(@Nullable Float f) {
        this.cachedX = f;
    }
}
