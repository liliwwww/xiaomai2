package androidx.compose.ui.text.platform;

import androidx.compose.runtime.MutableState;
import androidx.emoji2.text.EmojiCompat;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DefaultImpl$getFontLoadState$initCallback$1 extends EmojiCompat.InitCallback {
    final /* synthetic */ MutableState<Boolean> $mutableLoaded;
    final /* synthetic */ DefaultImpl this$0;

    DefaultImpl$getFontLoadState$initCallback$1(MutableState<Boolean> mutableState, DefaultImpl defaultImpl) {
        this.$mutableLoaded = mutableState;
        this.this$0 = defaultImpl;
    }

    @Override // androidx.emoji2.text.EmojiCompat.InitCallback
    public void onFailed(@Nullable Throwable th) {
        DefaultImpl.access$setLoadState$p(this.this$0, EmojiCompatStatusKt.access$getFalsey$p());
    }

    @Override // androidx.emoji2.text.EmojiCompat.InitCallback
    public void onInitialized() {
        this.$mutableLoaded.setValue(Boolean.TRUE);
        DefaultImpl.access$setLoadState$p(this.this$0, new ImmutableBool(true));
    }
}
