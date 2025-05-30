package androidx.compose.ui.tooling.animation;

import android.util.Log;
import androidx.compose.animation.tooling.ComposeAnimation;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PreviewAnimationClock$UnsupportedComposeAnimationSubscriber<T> {

    @NotNull
    private final LinkedHashSet<T> animations = new LinkedHashSet<>();

    @NotNull
    private final Object lock = new Object();
    final /* synthetic */ PreviewAnimationClock this$0;

    public PreviewAnimationClock$UnsupportedComposeAnimationSubscriber(PreviewAnimationClock previewAnimationClock) {
        this.this$0 = previewAnimationClock;
    }

    public final void clear() {
        this.animations.clear();
    }

    public final void trackAnimation(T t, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "label");
        UnsupportedComposeAnimation$Companion unsupportedComposeAnimation$Companion = UnsupportedComposeAnimation.Companion;
        if (unsupportedComposeAnimation$Companion.getApiAvailable()) {
            Object obj = this.lock;
            PreviewAnimationClock previewAnimationClock = this.this$0;
            synchronized (obj) {
                if (this.animations.contains(t)) {
                    if (PreviewAnimationClock.access$getDEBUG$p(previewAnimationClock)) {
                        Log.d(PreviewAnimationClock.access$getTAG$p(previewAnimationClock), "Animation " + t + " is already being tracked");
                    }
                    return;
                }
                this.animations.add(t);
                if (PreviewAnimationClock.access$getDEBUG$p(this.this$0)) {
                    Log.d(PreviewAnimationClock.access$getTAG$p(this.this$0), "Animation " + t + " is now tracked");
                }
                ComposeAnimation create = unsupportedComposeAnimation$Companion.create(str);
                if (create != null) {
                    PreviewAnimationClock previewAnimationClock2 = this.this$0;
                    previewAnimationClock2.getTrackedUnsupported$ui_tooling_release().add(create);
                    previewAnimationClock2.notifySubscribe(create);
                }
            }
        }
    }
}
