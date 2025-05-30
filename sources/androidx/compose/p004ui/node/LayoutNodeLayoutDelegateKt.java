package androidx.compose.p004ui.node;

import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.jvm.functions.Function1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class LayoutNodeLayoutDelegateKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void updateChildMeasurables(LayoutNode layoutNode, MutableVector<Measurable> mutableVector, Function1<? super LayoutNode, ? extends Measurable> function1) {
        MutableVector<LayoutNode> mutableVector2 = layoutNode.get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            int i = 0;
            LayoutNode[] content = mutableVector2.getContent();
            do {
                LayoutNode layoutNode2 = content[i];
                if (mutableVector.getSize() <= i) {
                    mutableVector.add(function1.invoke(layoutNode2));
                } else {
                    mutableVector.set(i, function1.invoke(layoutNode2));
                }
                i++;
            } while (i < size);
        }
        mutableVector.removeRange(layoutNode.getChildren$ui_release().size(), mutableVector.getSize());
    }
}
