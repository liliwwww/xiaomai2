package androidx.compose.foundation.text;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TextDragObserver $observer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LongPressTextDragObserverKt$detectDragGesturesAfterLongPressWithObserver$3(TextDragObserver textDragObserver) {
        super(0);
        this.$observer = textDragObserver;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m400invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m400invoke() {
        this.$observer.onStop();
    }
}
