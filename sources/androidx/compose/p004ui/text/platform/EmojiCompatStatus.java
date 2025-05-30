package androidx.compose.p004ui.text.platform;

import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.State;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class EmojiCompatStatus implements EmojiCompatStatusDelegate {

    @NotNull
    public static final EmojiCompatStatus INSTANCE = new EmojiCompatStatus();

    @NotNull
    private static EmojiCompatStatusDelegate delegate = new DefaultImpl();

    private EmojiCompatStatus() {
    }

    @Override // androidx.compose.p004ui.text.platform.EmojiCompatStatusDelegate
    @NotNull
    public State<Boolean> getFontLoaded() {
        return delegate.getFontLoaded();
    }

    @VisibleForTesting
    public final void setDelegateForTesting$ui_text_release(@Nullable EmojiCompatStatusDelegate emojiCompatStatusDelegate) {
        if (emojiCompatStatusDelegate == null) {
            emojiCompatStatusDelegate = new DefaultImpl();
        }
        delegate = emojiCompatStatusDelegate;
    }
}
