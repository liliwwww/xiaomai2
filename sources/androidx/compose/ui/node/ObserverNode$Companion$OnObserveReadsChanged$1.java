package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ObserverNode$Companion$OnObserveReadsChanged$1 extends Lambda implements Function1<ObserverNode, Unit> {
    public static final ObserverNode$Companion$OnObserveReadsChanged$1 INSTANCE = new ObserverNode$Companion$OnObserveReadsChanged$1();

    ObserverNode$Companion$OnObserveReadsChanged$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ObserverNode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull ObserverNode observerNode) {
        Intrinsics.checkNotNullParameter(observerNode, "it");
        if (observerNode.getNode().isAttached()) {
            observerNode.onObservedReadsChanged();
        }
    }
}
