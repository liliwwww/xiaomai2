package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SnapshotMutableStateImpl$component2$1<T> extends Lambda implements Function1<T, Unit> {
    final /* synthetic */ SnapshotMutableStateImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotMutableStateImpl$component2$1(SnapshotMutableStateImpl<T> snapshotMutableStateImpl) {
        super(1);
        this.this$0 = snapshotMutableStateImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m745invoke((SnapshotMutableStateImpl$component2$1<T>) obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m745invoke(T t) {
        this.this$0.setValue(t);
    }
}
