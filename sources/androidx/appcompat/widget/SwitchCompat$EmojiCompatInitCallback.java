package androidx.appcompat.widget;

import androidx.annotation.Nullable;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class SwitchCompat$EmojiCompatInitCallback extends EmojiCompat.InitCallback {
    private final Reference<SwitchCompat> mOuterWeakRef;

    SwitchCompat$EmojiCompatInitCallback(SwitchCompat switchCompat) {
        this.mOuterWeakRef = new WeakReference(switchCompat);
    }

    public void onFailed(@Nullable Throwable th) {
        SwitchCompat switchCompat = this.mOuterWeakRef.get();
        if (switchCompat != null) {
            switchCompat.onEmojiCompatInitializedForSwitchText();
        }
    }

    public void onInitialized() {
        SwitchCompat switchCompat = this.mOuterWeakRef.get();
        if (switchCompat != null) {
            switchCompat.onEmojiCompatInitializedForSwitchText();
        }
    }
}
