package androidx.compose.runtime.snapshots;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SnapshotKt$mergedReadObserver$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ Function1<Object, Unit> $parentObserver;
    final /* synthetic */ Function1<Object, Unit> $readObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotKt$mergedReadObserver$1(Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(1);
        this.$readObserver = function1;
        this.$parentObserver = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m801invoke(obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m801invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "state");
        this.$readObserver.invoke(obj);
        this.$parentObserver.invoke(obj);
    }
}
