package androidx.compose.runtime;

import android.view.Choreographer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DefaultChoreographerFrameClock$withFrameNanos$2$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Choreographer.FrameCallback $callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultChoreographerFrameClock$withFrameNanos$2$1(Choreographer.FrameCallback frameCallback) {
        super(1);
        this.$callback = frameCallback;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        DefaultChoreographerFrameClock.access$getChoreographer$p().removeFrameCallback(this.$callback);
    }
}
