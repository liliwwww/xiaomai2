package androidx.compose.p004ui.focus;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.ModifierNodeElement;
import androidx.compose.p004ui.node.NodeKind;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
            @Override // androidx.compose.p004ui.node.ModifierNodeElement
            @NotNull
            public FocusPropertiesModifierNodeImpl create() {
                return new FocusPropertiesModifierNodeImpl(function1);
            }

            @Override // androidx.compose.p004ui.node.ModifierNodeElement
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
        int m4398constructorimpl = NodeKind.m4398constructorimpl(1024);
        if (!focusPropertiesModifierNode.getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = focusPropertiesModifierNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusPropertiesModifierNode.getNode());
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m4398constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet$ui_release() & m4398constructorimpl) == 0) {
                        node = node.getChild$ui_release();
                    } else if (node instanceof FocusTargetModifierNode) {
                        DelegatableNodeKt.requireOwner(focusPropertiesModifierNode).getFocusOwner().scheduleInvalidation((FocusTargetModifierNode) node);
                    }
                }
            }
        }
    }
}
