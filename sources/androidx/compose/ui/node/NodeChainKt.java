package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ActualKt;
import androidx.compose.ui.CombinedModifier;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class NodeChainKt {
    private static final int ActionReplace = 0;
    private static final int ActionReuse = 2;
    private static final int ActionUpdate = 1;

    @NotNull
    private static final SentinelHead.1 SentinelHead;

    static {
        SentinelHead.1 r0 = new SentinelHead.1();
        r0.setAggregateChildKindSet$ui_release(-1);
        SentinelHead = r0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableVector<Modifier.Element> fillVector(Modifier modifier, MutableVector<Modifier.Element> mutableVector) {
        MutableVector mutableVector2 = new MutableVector(new Modifier[mutableVector.getSize()], 0);
        mutableVector2.add(modifier);
        while (mutableVector2.isNotEmpty()) {
            Modifier modifier2 = (Modifier) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if (modifier2 instanceof CombinedModifier) {
                CombinedModifier combinedModifier = (CombinedModifier) modifier2;
                mutableVector2.add(combinedModifier.getInner$ui_release());
                mutableVector2.add(combinedModifier.getOuter$ui_release());
            } else if (modifier2 instanceof Modifier.Element) {
                mutableVector.add(modifier2);
            } else {
                modifier2.all(new fillVector.1(mutableVector));
            }
        }
        return mutableVector;
    }

    public static final int reuseActionForModifiers(@NotNull Modifier.Element element, @NotNull Modifier.Element element2) {
        Intrinsics.checkNotNullParameter(element, "prev");
        Intrinsics.checkNotNullParameter(element2, "next");
        if (Intrinsics.areEqual(element, element2)) {
            return 2;
        }
        return ActualKt.areObjectsOfSameType(element, element2) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends Modifier.Node> Modifier.Node updateUnsafe(ModifierNodeElement<T> modifierNodeElement, Modifier.Node node) {
        Intrinsics.checkNotNull(node, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
        return modifierNodeElement.update(node);
    }
}
