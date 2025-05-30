package androidx.compose.ui.text.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.emoji2.text.EmojiCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DefaultImpl implements EmojiCompatStatusDelegate {

    @Nullable
    private State<Boolean> loadState;

    public DefaultImpl() {
        this.loadState = EmojiCompat.isConfigured() ? getFontLoadState() : null;
    }

    private final State<Boolean> getFontLoadState() {
        MutableState mutableStateOf$default;
        EmojiCompat emojiCompat = EmojiCompat.get();
        Intrinsics.checkNotNullExpressionValue(emojiCompat, "get()");
        if (emojiCompat.getLoadState() == 1) {
            return new ImmutableBool(true);
        }
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        emojiCompat.registerInitCallback(new getFontLoadState.initCallback.1(mutableStateOf$default, this));
        return mutableStateOf$default;
    }

    @NotNull
    public State<Boolean> getFontLoaded() {
        ImmutableBool immutableBool;
        State<Boolean> state = this.loadState;
        if (state != null) {
            Intrinsics.checkNotNull(state);
            return state;
        }
        if (!EmojiCompat.isConfigured()) {
            immutableBool = EmojiCompatStatusKt.Falsey;
            return immutableBool;
        }
        State<Boolean> fontLoadState = getFontLoadState();
        this.loadState = fontLoadState;
        Intrinsics.checkNotNull(fontLoadState);
        return fontLoadState;
    }
}
