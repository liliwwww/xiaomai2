package androidx.compose.animation.core;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AnimateAsStateKt$animateValueAsState$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Channel<T> $channel;
    final /* synthetic */ T $targetValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnimateAsStateKt$animateValueAsState$2(Channel<T> channel, T t) {
        super(0);
        this.$channel = channel;
        this.$targetValue = t;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m62invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m62invoke() {
        this.$channel.trySend-JP2dKIU(this.$targetValue);
    }
}
