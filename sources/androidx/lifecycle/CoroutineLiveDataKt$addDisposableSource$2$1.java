package androidx.lifecycle;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class CoroutineLiveDataKt$addDisposableSource$2$1<T> extends Lambda implements Function1<T, Unit> {
    final /* synthetic */ MediatorLiveData<T> $this_addDisposableSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutineLiveDataKt$addDisposableSource$2$1(MediatorLiveData<T> mediatorLiveData) {
        super(1);
        this.$this_addDisposableSource = mediatorLiveData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m2805invoke((CoroutineLiveDataKt$addDisposableSource$2$1<T>) obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2805invoke(T t) {
        this.$this_addDisposableSource.setValue(t);
    }
}
