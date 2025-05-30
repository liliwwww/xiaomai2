package androidx.emoji2.text;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import tb.wv0;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class EmojiCompatInitializer$1 implements DefaultLifecycleObserver {
    final /* synthetic */ EmojiCompatInitializer this$0;
    final /* synthetic */ Lifecycle val$lifecycle;

    EmojiCompatInitializer$1(EmojiCompatInitializer emojiCompatInitializer, Lifecycle lifecycle) {
        this.this$0 = emojiCompatInitializer;
        this.val$lifecycle = lifecycle;
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        wv0.a(this, lifecycleOwner);
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        wv0.b(this, lifecycleOwner);
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        wv0.c(this, lifecycleOwner);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onResume(@NonNull LifecycleOwner lifecycleOwner) {
        this.this$0.loadEmojiCompatAfterDelay();
        this.val$lifecycle.removeObserver(this);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        wv0.e(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        wv0.f(this, lifecycleOwner);
    }
}
