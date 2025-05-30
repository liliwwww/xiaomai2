package androidx.compose.p004ui.focus;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.node.ModifierNodeElement;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class FocusRequesterModifierKt {
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0034, code lost:
    
        continue;
     */
    @androidx.compose.p004ui.ExperimentalComposeUiApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean captureFocus(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.focus.FocusRequesterModifierNode r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.p004ui.node.NodeKind.m4398constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r1 = r5.getNode()
            boolean r1 = r1.isAttached()
            if (r1 == 0) goto L6d
            r1 = 16
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r1 = new androidx.compose.ui.Modifier.Node[r1]
            r3 = 0
            r2.<init>(r1, r3)
            androidx.compose.ui.Modifier$Node r1 = r5.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getChild$ui_release()
            if (r1 != 0) goto L31
            androidx.compose.ui.Modifier$Node r5 = r5.getNode()
            androidx.compose.p004ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r5)
            goto L34
        L31:
            r2.add(r1)
        L34:
            boolean r5 = r2.isNotEmpty()
            if (r5 == 0) goto L6c
            int r5 = r2.getSize()
            r1 = 1
            int r5 = r5 - r1
            java.lang.Object r5 = r2.removeAt(r5)
            androidx.compose.ui.Modifier$Node r5 = (androidx.compose.ui.Modifier.Node) r5
            int r4 = r5.getAggregateChildKindSet$ui_release()
            r4 = r4 & r0
            if (r4 != 0) goto L51
            androidx.compose.p004ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r5)
            goto L34
        L51:
            if (r5 == 0) goto L34
            int r4 = r5.getKindSet$ui_release()
            r4 = r4 & r0
            if (r4 == 0) goto L67
            boolean r4 = r5 instanceof androidx.compose.p004ui.focus.FocusTargetModifierNode
            if (r4 == 0) goto L34
            androidx.compose.ui.focus.FocusTargetModifierNode r5 = (androidx.compose.p004ui.focus.FocusTargetModifierNode) r5
            boolean r5 = androidx.compose.p004ui.focus.FocusTransactionsKt.captureFocus(r5)
            if (r5 == 0) goto L34
            return r1
        L67:
            androidx.compose.ui.Modifier$Node r5 = r5.getChild$ui_release()
            goto L51
        L6c:
            return r3
        L6d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.focus.FocusRequesterModifierKt.captureFocus(androidx.compose.ui.focus.FocusRequesterModifierNode):boolean");
    }

    @NotNull
    public static final Modifier focusRequester(@NotNull Modifier modifier, @NotNull final FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        final Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierKt$focusRequester$$inlined$modifierElementOf$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("focusRequester");
                inspectorInfo.getProperties().set("focusRequester", FocusRequester.this);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return modifier.then(new ModifierNodeElement<FocusRequesterModifierNodeImpl>(focusRequester, noInspectorInfo) { // from class: androidx.compose.ui.focus.FocusRequesterModifierKt$focusRequester$$inlined$modifierElementOf$2
            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public FocusRequesterModifierNodeImpl create() {
                return new FocusRequesterModifierNodeImpl(focusRequester);
            }

            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public FocusRequesterModifierNodeImpl update(@NotNull FocusRequesterModifierNodeImpl focusRequesterModifierNodeImpl) {
                Intrinsics.checkNotNullParameter(focusRequesterModifierNodeImpl, "node");
                FocusRequesterModifierNodeImpl focusRequesterModifierNodeImpl2 = focusRequesterModifierNodeImpl;
                focusRequesterModifierNodeImpl2.getFocusRequester().getFocusRequesterNodes$ui_release().remove(focusRequesterModifierNodeImpl2);
                focusRequesterModifierNodeImpl2.setFocusRequester(focusRequester);
                focusRequesterModifierNodeImpl2.getFocusRequester().getFocusRequesterNodes$ui_release().add(focusRequesterModifierNodeImpl2);
                return focusRequesterModifierNodeImpl;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0034, code lost:
    
        continue;
     */
    @androidx.compose.p004ui.ExperimentalComposeUiApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean freeFocus(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.focus.FocusRequesterModifierNode r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.p004ui.node.NodeKind.m4398constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r1 = r5.getNode()
            boolean r1 = r1.isAttached()
            if (r1 == 0) goto L6d
            r1 = 16
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r1 = new androidx.compose.ui.Modifier.Node[r1]
            r3 = 0
            r2.<init>(r1, r3)
            androidx.compose.ui.Modifier$Node r1 = r5.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getChild$ui_release()
            if (r1 != 0) goto L31
            androidx.compose.ui.Modifier$Node r5 = r5.getNode()
            androidx.compose.p004ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r5)
            goto L34
        L31:
            r2.add(r1)
        L34:
            boolean r5 = r2.isNotEmpty()
            if (r5 == 0) goto L6c
            int r5 = r2.getSize()
            r1 = 1
            int r5 = r5 - r1
            java.lang.Object r5 = r2.removeAt(r5)
            androidx.compose.ui.Modifier$Node r5 = (androidx.compose.ui.Modifier.Node) r5
            int r4 = r5.getAggregateChildKindSet$ui_release()
            r4 = r4 & r0
            if (r4 != 0) goto L51
            androidx.compose.p004ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r5)
            goto L34
        L51:
            if (r5 == 0) goto L34
            int r4 = r5.getKindSet$ui_release()
            r4 = r4 & r0
            if (r4 == 0) goto L67
            boolean r4 = r5 instanceof androidx.compose.p004ui.focus.FocusTargetModifierNode
            if (r4 == 0) goto L34
            androidx.compose.ui.focus.FocusTargetModifierNode r5 = (androidx.compose.p004ui.focus.FocusTargetModifierNode) r5
            boolean r5 = androidx.compose.p004ui.focus.FocusTransactionsKt.freeFocus(r5)
            if (r5 == 0) goto L34
            return r1
        L67:
            androidx.compose.ui.Modifier$Node r5 = r5.getChild$ui_release()
            goto L51
        L6c:
            return r3
        L6d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.focus.FocusRequesterModifierKt.freeFocus(androidx.compose.ui.focus.FocusRequesterModifierNode):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0034, code lost:
    
        continue;
     */
    @androidx.compose.p004ui.ExperimentalComposeUiApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean requestFocus(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.focus.FocusRequesterModifierNode r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.p004ui.node.NodeKind.m4398constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r1 = r5.getNode()
            boolean r1 = r1.isAttached()
            if (r1 == 0) goto L6d
            r1 = 16
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r1 = new androidx.compose.ui.Modifier.Node[r1]
            r3 = 0
            r2.<init>(r1, r3)
            androidx.compose.ui.Modifier$Node r1 = r5.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getChild$ui_release()
            if (r1 != 0) goto L31
            androidx.compose.ui.Modifier$Node r5 = r5.getNode()
            androidx.compose.p004ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r5)
            goto L34
        L31:
            r2.add(r1)
        L34:
            boolean r5 = r2.isNotEmpty()
            if (r5 == 0) goto L6c
            int r5 = r2.getSize()
            r1 = 1
            int r5 = r5 - r1
            java.lang.Object r5 = r2.removeAt(r5)
            androidx.compose.ui.Modifier$Node r5 = (androidx.compose.ui.Modifier.Node) r5
            int r4 = r5.getAggregateChildKindSet$ui_release()
            r4 = r4 & r0
            if (r4 != 0) goto L51
            androidx.compose.p004ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r2, r5)
            goto L34
        L51:
            if (r5 == 0) goto L34
            int r4 = r5.getKindSet$ui_release()
            r4 = r4 & r0
            if (r4 == 0) goto L67
            boolean r4 = r5 instanceof androidx.compose.p004ui.focus.FocusTargetModifierNode
            if (r4 == 0) goto L34
            androidx.compose.ui.focus.FocusTargetModifierNode r5 = (androidx.compose.p004ui.focus.FocusTargetModifierNode) r5
            boolean r5 = androidx.compose.p004ui.focus.FocusTransactionsKt.requestFocus(r5)
            if (r5 == 0) goto L34
            return r1
        L67:
            androidx.compose.ui.Modifier$Node r5 = r5.getChild$ui_release()
            goto L51
        L6c:
            return r3
        L6d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.focus.FocusRequesterModifierKt.requestFocus(androidx.compose.ui.focus.FocusRequesterModifierNode):boolean");
    }
}
