package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class FocusPropertiesKt {
    @NotNull
    public static final Modifier focusProperties(@NotNull Modifier modifier, @NotNull final Function1<? super FocusProperties, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "scope");
        final Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.focus.FocusPropertiesKt$focusProperties$$inlined$modifierElementOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("focusProperties");
                inspectorInfo.getProperties().set("scope", function1);
            }
        } : InspectableValueKt.getNoInspectorInfo();
        return modifier.then(new ModifierNodeElement<FocusPropertiesModifierNodeImpl>(function1, noInspectorInfo) { // from class: androidx.compose.ui.focus.FocusPropertiesKt$focusProperties$$inlined$modifierElementOf$2
            @Override // androidx.compose.ui.node.ModifierNodeElement
            @NotNull
            public FocusPropertiesModifierNodeImpl create() {
                return new FocusPropertiesModifierNodeImpl(function1);
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            @NotNull
            public FocusPropertiesModifierNodeImpl update(@NotNull FocusPropertiesModifierNodeImpl focusPropertiesModifierNodeImpl) {
                Intrinsics.checkNotNullParameter(focusPropertiesModifierNodeImpl, "node");
                focusPropertiesModifierNodeImpl.setFocusPropertiesScope$ui_release(function1);
                return focusPropertiesModifierNodeImpl;
            }
        });
    }

    @ExperimentalComposeUiApi
    public static final void scheduleInvalidationOfAssociatedFocusTargets(@NotNull FocusPropertiesModifierNode focusPropertiesModifierNode) {
        Intrinsics.checkNotNullParameter(focusPropertiesModifierNode, "<this>");
        int m1660constructorimpl = NodeKind.m1660constructorimpl(1024);
        if (!focusPropertiesModifierNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier$Node[16], 0);
        Modifier$Node child$ui_release = focusPropertiesModifierNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusPropertiesModifierNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier$Node modifier$Node = (Modifier$Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((modifier$Node.getAggregateChildKindSet$ui_release() & m1660constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, modifier$Node);
            } else {
                while (true) {
                    if (modifier$Node == null) {
                        break;
                    }
                    if ((modifier$Node.getKindSet$ui_release() & m1660constructorimpl) == 0) {
                        modifier$Node = modifier$Node.getChild$ui_release();
                    } else if (modifier$Node instanceof FocusTargetModifierNode) {
                        DelegatableNodeKt.requireOwner(focusPropertiesModifierNode).getFocusOwner().scheduleInvalidation((FocusTargetModifierNode) modifier$Node);
                    }
                }
            }
        }
    }
}
