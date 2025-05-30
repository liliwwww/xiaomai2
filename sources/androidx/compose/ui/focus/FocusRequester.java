package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FocusRequester {

    @NotNull
    private final MutableVector<FocusRequesterModifierNode> focusRequesterNodes = new MutableVector<>(new FocusRequesterModifierNode[16], 0);

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int $stable = MutableVector.$stable;

    @NotNull
    private static final FocusRequester Default = new FocusRequester();

    @NotNull
    private static final FocusRequester Cancel = new FocusRequester();

    public static /* synthetic */ void getFocusRequesterNodes$ui_release$annotations() {
    }

    public final boolean captureFocus() {
        if (!this.focusRequesterNodes.isNotEmpty()) {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        }
        MutableVector<FocusRequesterModifierNode> mutableVector = this.focusRequesterNodes;
        int size = mutableVector.getSize();
        if (size > 0) {
            FocusRequesterModifierNode[] content = mutableVector.getContent();
            int i = 0;
            while (!FocusRequesterModifierKt.captureFocus(content[i])) {
                i++;
                if (i >= size) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x005d, code lost:
    
        continue;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Boolean findFocusTarget$ui_release(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.compose.ui.focus.FocusTargetModifierNode, java.lang.Boolean> r10) {
        /*
            r9 = this;
            java.lang.String r0 = "onFound"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            androidx.compose.ui.focus.FocusRequester r0 = androidx.compose.ui.focus.FocusRequester.Cancel
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r0)
            r1 = 0
            if (r0 == 0) goto L13
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            goto Lae
        L13:
            androidx.compose.ui.focus.FocusRequester r0 = androidx.compose.ui.focus.FocusRequester.Default
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r0)
            if (r0 == 0) goto L1d
            goto Lae
        L1d:
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.focus.FocusRequesterModifierNode> r0 = r9.focusRequesterNodes
            int r2 = r0.getSize()
            if (r2 <= 0) goto Lae
            java.lang.Object[] r0 = r0.getContent()
            r3 = 0
            r4 = 0
        L2b:
            r5 = r0[r4]
            androidx.compose.ui.focus.FocusRequesterModifierNode r5 = (androidx.compose.ui.focus.FocusRequesterModifierNode) r5
            r6 = 1024(0x400, float:1.435E-42)
            int r6 = androidx.compose.ui.node.NodeKind.constructor-impl(r6)
            androidx.compose.ui.Modifier$Node r7 = r5.getNode()
            boolean r7 = r7.isAttached()
            if (r7 == 0) goto La2
            r7 = 16
            androidx.compose.runtime.collection.MutableVector r8 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r7 = new androidx.compose.ui.Modifier.Node[r7]
            r8.<init>(r7, r3)
            androidx.compose.ui.Modifier$Node r7 = r5.getNode()
            androidx.compose.ui.Modifier$Node r7 = r7.getChild$ui_release()
            if (r7 != 0) goto L5a
            androidx.compose.ui.Modifier$Node r5 = r5.getNode()
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r8, r5)
            goto L5d
        L5a:
            r8.add(r7)
        L5d:
            boolean r5 = r8.isNotEmpty()
            if (r5 == 0) goto L9d
            int r5 = r8.getSize()
            int r5 = r5 + (-1)
            java.lang.Object r5 = r8.removeAt(r5)
            androidx.compose.ui.Modifier$Node r5 = (androidx.compose.ui.Modifier.Node) r5
            int r7 = r5.getAggregateChildKindSet$ui_release()
            r7 = r7 & r6
            if (r7 != 0) goto L7a
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r8, r5)
            goto L5d
        L7a:
            if (r5 == 0) goto L5d
            int r7 = r5.getKindSet$ui_release()
            r7 = r7 & r6
            if (r7 == 0) goto L98
            boolean r7 = r5 instanceof androidx.compose.ui.focus.FocusTargetModifierNode
            if (r7 == 0) goto L5d
            androidx.compose.ui.focus.FocusTargetModifierNode r5 = (androidx.compose.ui.focus.FocusTargetModifierNode) r5
            java.lang.Object r5 = r10.invoke(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L5d
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            goto L9d
        L98:
            androidx.compose.ui.Modifier$Node r5 = r5.getChild$ui_release()
            goto L7a
        L9d:
            int r4 = r4 + 1
            if (r4 < r2) goto L2b
            goto Lae
        La2:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        Lae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusRequester.findFocusTarget$ui_release(kotlin.jvm.functions.Function1):java.lang.Boolean");
    }

    public final boolean freeFocus() {
        if (!this.focusRequesterNodes.isNotEmpty()) {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        }
        MutableVector<FocusRequesterModifierNode> mutableVector = this.focusRequesterNodes;
        int size = mutableVector.getSize();
        if (size > 0) {
            FocusRequesterModifierNode[] content = mutableVector.getContent();
            int i = 0;
            while (!FocusRequesterModifierKt.freeFocus(content[i])) {
                i++;
                if (i >= size) {
                }
            }
            return true;
        }
        return false;
    }

    @NotNull
    public final MutableVector<FocusRequesterModifierNode> getFocusRequesterNodes$ui_release() {
        return this.focusRequesterNodes;
    }

    public final void requestFocus() {
        if (!this.focusRequesterNodes.isNotEmpty()) {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        }
        findFocusTarget$ui_release(new Function1<FocusTargetModifierNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequester$requestFocus$2
            @NotNull
            public final Boolean invoke(@NotNull FocusTargetModifierNode focusTargetModifierNode) {
                Intrinsics.checkNotNullParameter(focusTargetModifierNode, "it");
                return Boolean.valueOf(FocusTransactionsKt.requestFocus(focusTargetModifierNode));
            }
        });
    }
}
