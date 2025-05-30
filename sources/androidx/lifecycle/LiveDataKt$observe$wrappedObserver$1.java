package androidx.lifecycle;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LiveDataKt$observe$wrappedObserver$1<T> implements Observer {
    final /* synthetic */ Function1<T, Unit> $onChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveDataKt$observe$wrappedObserver$1(Function1<? super T, Unit> function1) {
        this.$onChanged = function1;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        this.$onChanged.invoke(t);
    }
}
