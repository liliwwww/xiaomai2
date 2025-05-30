package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2 implements LifecycleEventObserver {
    final /* synthetic */ PausableMonotonicFrameClock $pausableClock;
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ CoroutineScope $runRecomposeScope;
    final /* synthetic */ Ref.ObjectRef<MotionDurationScaleImpl> $systemDurationScaleSettingConsumer;
    final /* synthetic */ View $this_createLifecycleAwareWindowRecomposer;

    WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$2(CoroutineScope coroutineScope, PausableMonotonicFrameClock pausableMonotonicFrameClock, Recomposer recomposer, Ref.ObjectRef<MotionDurationScaleImpl> objectRef, View view) {
        this.$runRecomposeScope = coroutineScope;
        this.$pausableClock = pausableMonotonicFrameClock;
        this.$recomposer = recomposer;
        this.$systemDurationScaleSettingConsumer = objectRef;
        this.$this_createLifecycleAwareWindowRecomposer = view;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            d.d(this.$runRecomposeScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new onStateChanged.1(this.$systemDurationScaleSettingConsumer, this.$recomposer, lifecycleOwner, this, this.$this_createLifecycleAwareWindowRecomposer, (Continuation) null), 1, (Object) null);
            return;
        }
        if (i == 2) {
            PausableMonotonicFrameClock pausableMonotonicFrameClock = this.$pausableClock;
            if (pausableMonotonicFrameClock != null) {
                pausableMonotonicFrameClock.resume();
                return;
            }
            return;
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            this.$recomposer.cancel();
        } else {
            PausableMonotonicFrameClock pausableMonotonicFrameClock2 = this.$pausableClock;
            if (pausableMonotonicFrameClock2 != null) {
                pausableMonotonicFrameClock2.pause();
            }
        }
    }
}
