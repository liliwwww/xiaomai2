package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LookaheadDelegate $lookaheadDelegate;
    final /* synthetic */ LayoutNodeLayoutDelegate.LookaheadPassDelegate this$0;
    final /* synthetic */ LayoutNodeLayoutDelegate this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1(LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate, LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, LookaheadDelegate lookaheadDelegate) {
        super(0);
        this.this$0 = lookaheadPassDelegate;
        this.this$1 = layoutNodeLayoutDelegate;
        this.$lookaheadDelegate = lookaheadDelegate;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1611invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m1611invoke() {
        MutableVector mutableVector = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0.this$0).get_children$ui_release();
        int size = mutableVector.getSize();
        int i = 0;
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i2 = 0;
            do {
                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release = ((LayoutNode) content[i2]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                LayoutNodeLayoutDelegate.LookaheadPassDelegate.access$setPreviouslyPlaced$p(lookaheadPassDelegate$ui_release, lookaheadPassDelegate$ui_release.isPlaced());
                lookaheadPassDelegate$ui_release.setPlaced(false);
                i2++;
            } while (i2 < size);
        }
        MutableVector mutableVector2 = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$1).get_children$ui_release();
        int size2 = mutableVector2.getSize();
        if (size2 > 0) {
            Object[] content2 = mutableVector2.getContent();
            int i3 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content2[i3];
                if (layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                    layoutNode.setMeasuredByParentInLookahead$ui_release(LayoutNode.UsageByParent.NotUsed);
                }
                i3++;
            } while (i3 < size2);
        }
        this.this$0.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1.3
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AlignmentLinesOwner) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull AlignmentLinesOwner alignmentLinesOwner) {
                Intrinsics.checkNotNullParameter(alignmentLinesOwner, "child");
                alignmentLinesOwner.getAlignmentLines().setUsedDuringParentLayout$ui_release(false);
            }
        });
        this.$lookaheadDelegate.getMeasureResult$ui_release().placeChildren();
        this.this$0.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1.4
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((AlignmentLinesOwner) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull AlignmentLinesOwner alignmentLinesOwner) {
                Intrinsics.checkNotNullParameter(alignmentLinesOwner, "child");
                alignmentLinesOwner.getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(alignmentLinesOwner.getAlignmentLines().getUsedDuringParentLayout$ui_release());
            }
        });
        MutableVector mutableVector3 = LayoutNodeLayoutDelegate.access$getLayoutNode$p(this.this$0.this$0).get_children$ui_release();
        int size3 = mutableVector3.getSize();
        if (size3 > 0) {
            Object[] content3 = mutableVector3.getContent();
            do {
                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate$ui_release2 = ((LayoutNode) content3[i]).getLayoutDelegate$ui_release().getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release2);
                if (!lookaheadPassDelegate$ui_release2.isPlaced()) {
                    LayoutNodeLayoutDelegate.LookaheadPassDelegate.access$markSubtreeNotPlaced(lookaheadPassDelegate$ui_release2);
                }
                i++;
            } while (i < size3);
        }
    }
}
