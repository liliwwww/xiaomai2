package androidx.compose.ui.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BackwardsCompatNodeKt {

    @NotNull
    private static final DetachedModifierLocalReadScope.1 DetachedModifierLocalReadScope = new DetachedModifierLocalReadScope.1();

    @NotNull
    private static final Function1<BackwardsCompatNode, Unit> onDrawCacheReadsChanged = onDrawCacheReadsChanged.1.INSTANCE;

    @NotNull
    private static final Function1<BackwardsCompatNode, Unit> updateModifierLocalConsumer = new Function1<BackwardsCompatNode, Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNodeKt$updateModifierLocalConsumer$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((BackwardsCompatNode) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull BackwardsCompatNode backwardsCompatNode) {
            Intrinsics.checkNotNullParameter(backwardsCompatNode, "it");
            backwardsCompatNode.updateModifierLocalConsumer();
        }
    };
}
