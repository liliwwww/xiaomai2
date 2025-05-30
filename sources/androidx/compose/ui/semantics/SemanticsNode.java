package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SemanticsNode {
    public static final int $stable = 8;

    @Nullable
    private SemanticsNode fakeNodeParent;
    private final int id;
    private boolean isFake;

    @NotNull
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;

    @NotNull
    private final SemanticsModifierNode outerSemanticsNode;

    @NotNull
    private final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(@NotNull SemanticsModifierNode semanticsModifierNode, boolean z, @NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(semanticsModifierNode, "outerSemanticsNode");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.outerSemanticsNode = semanticsModifierNode;
        this.mergingEnabled = z;
        this.layoutNode = layoutNode;
        this.unmergedConfig = SemanticsModifierNodeKt.collapsedSemanticsConfiguration(semanticsModifierNode);
        this.id = layoutNode.getSemanticsId();
    }

    private final void emitFakeNodes(List<SemanticsNode> list) {
        final Role access$getRole = SemanticsNodeKt.access$getRole(this);
        if (access$getRole != null && this.unmergedConfig.isMergingSemanticsOfDescendants() && (!list.isEmpty())) {
            list.add(m2248fakeSemanticsNodeypyhhiA(access$getRole, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$fakeSemanticsNode");
                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, access$getRole.unbox-impl());
                }
            }));
        }
        SemanticsConfiguration semanticsConfiguration = this.unmergedConfig;
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (semanticsConfiguration.contains(semanticsProperties.getContentDescription()) && (!list.isEmpty()) && this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            List list2 = (List) SemanticsConfigurationKt.getOrNull(this.unmergedConfig, semanticsProperties.getContentDescription());
            final String str = list2 != null ? (String) CollectionsKt.firstOrNull(list2) : null;
            if (str != null) {
                list.add(0, m2248fakeSemanticsNodeypyhhiA(null, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$fakeSemanticsNode");
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                    }
                }));
            }
        }
    }

    /* renamed from: fakeSemanticsNode-ypyhhiA, reason: not valid java name */
    private final SemanticsNode m2248fakeSemanticsNodeypyhhiA(Role role, Function1<? super SemanticsPropertyReceiver, Unit> function1) {
        SemanticsNode semanticsNode = new SemanticsNode(new SemanticsNode$fakeSemanticsNode$fakeNode$1(function1), false, new LayoutNode(true, role != null ? SemanticsNodeKt.access$roleFakeNodeId(this) : SemanticsNodeKt.access$contentDescriptionFakeNodeId(this)));
        semanticsNode.isFake = true;
        semanticsNode.fakeNodeParent = this;
        return semanticsNode;
    }

    private final List<SemanticsNode> findOneLayerOfMergingSemanticsNodes(List<SemanticsNode> list, boolean z) {
        List unmergedChildren$ui_release$default = unmergedChildren$ui_release$default(this, z, false, 2, null);
        int size = unmergedChildren$ui_release$default.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode = (SemanticsNode) unmergedChildren$ui_release$default.get(i);
            if (semanticsNode.isMergingSemanticsOfDescendants()) {
                list.add(semanticsNode);
            } else if (!semanticsNode.unmergedConfig.isClearingSemantics()) {
                findOneLayerOfMergingSemanticsNodes$default(semanticsNode, list, false, 2, null);
            }
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List findOneLayerOfMergingSemanticsNodes$default(SemanticsNode semanticsNode, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return semanticsNode.findOneLayerOfMergingSemanticsNodes(list, z);
    }

    private final boolean isMergingSemanticsOfDescendants() {
        return this.mergingEnabled && this.unmergedConfig.isMergingSemanticsOfDescendants();
    }

    private final void mergeConfig(SemanticsConfiguration semanticsConfiguration) {
        if (this.unmergedConfig.isClearingSemantics()) {
            return;
        }
        List unmergedChildren$ui_release$default = unmergedChildren$ui_release$default(this, false, false, 3, null);
        int size = unmergedChildren$ui_release$default.size();
        for (int i = 0; i < size; i++) {
            SemanticsNode semanticsNode = (SemanticsNode) unmergedChildren$ui_release$default.get(i);
            if (!semanticsNode.isMergingSemanticsOfDescendants()) {
                semanticsConfiguration.mergeChild$ui_release(semanticsNode.unmergedConfig);
                semanticsNode.mergeConfig(semanticsConfiguration);
            }
        }
    }

    public static /* synthetic */ List unmergedChildren$ui_release$default(SemanticsNode semanticsNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return semanticsNode.unmergedChildren$ui_release(z, z2);
    }

    @NotNull
    public final NodeCoordinator findCoordinatorToGetBounds$ui_release() {
        if (!this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            return DelegatableNodeKt.requireCoordinator-64DMado(this.outerSemanticsNode, NodeKind.constructor-impl(8));
        }
        SemanticsModifierNode outerMergingSemantics = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
        if (outerMergingSemantics == null) {
            outerMergingSemantics = this.outerSemanticsNode;
        }
        return DelegatableNodeKt.requireCoordinator-64DMado(outerMergingSemantics, NodeKind.constructor-impl(8));
    }

    public final int getAlignmentLinePosition(@NotNull AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return findCoordinatorToGetBounds$ui_release().get(alignmentLine);
    }

    @NotNull
    public final Rect getBoundsInRoot() {
        return !this.layoutNode.isAttached() ? Rect.Companion.getZero() : LayoutCoordinatesKt.boundsInRoot(findCoordinatorToGetBounds$ui_release());
    }

    @NotNull
    public final Rect getBoundsInWindow() {
        return !this.layoutNode.isAttached() ? Rect.Companion.getZero() : LayoutCoordinatesKt.boundsInWindow(findCoordinatorToGetBounds$ui_release());
    }

    @NotNull
    public final List<SemanticsNode> getChildren() {
        return getChildren(false, !this.mergingEnabled, false);
    }

    @NotNull
    public final SemanticsConfiguration getConfig() {
        if (!isMergingSemanticsOfDescendants()) {
            return this.unmergedConfig;
        }
        SemanticsConfiguration copy = this.unmergedConfig.copy();
        mergeConfig(copy);
        return copy;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final LayoutInfo getLayoutInfo() {
        return this.layoutNode;
    }

    @NotNull
    public final LayoutNode getLayoutNode$ui_release() {
        return this.layoutNode;
    }

    public final boolean getMergingEnabled() {
        return this.mergingEnabled;
    }

    @NotNull
    public final SemanticsModifierNode getOuterSemanticsNode$ui_release() {
        return this.outerSemanticsNode;
    }

    @Nullable
    public final SemanticsNode getParent() {
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        LayoutNode access$findClosestParentNode = this.mergingEnabled ? SemanticsNodeKt.access$findClosestParentNode(this.layoutNode, parent.1.INSTANCE) : null;
        if (access$findClosestParentNode == null) {
            access$findClosestParentNode = SemanticsNodeKt.access$findClosestParentNode(this.layoutNode, parent.2.INSTANCE);
        }
        SemanticsModifierNode outerSemantics = access$findClosestParentNode != null ? SemanticsNodeKt.getOuterSemantics(access$findClosestParentNode) : null;
        if (outerSemantics == null) {
            return null;
        }
        return new SemanticsNode(outerSemantics, this.mergingEnabled, null, 4, null);
    }

    /* renamed from: getPositionInRoot-F1C5BW0, reason: not valid java name */
    public final long m2249getPositionInRootF1C5BW0() {
        return !this.layoutNode.isAttached() ? Offset.Companion.m1024getZeroF1C5BW0() : LayoutCoordinatesKt.positionInRoot(findCoordinatorToGetBounds$ui_release());
    }

    /* renamed from: getPositionInWindow-F1C5BW0, reason: not valid java name */
    public final long m2250getPositionInWindowF1C5BW0() {
        return !this.layoutNode.isAttached() ? Offset.Companion.m1024getZeroF1C5BW0() : LayoutCoordinatesKt.positionInWindow(findCoordinatorToGetBounds$ui_release());
    }

    @NotNull
    public final List<SemanticsNode> getReplacedChildren$ui_release() {
        return getChildren(false, false, true);
    }

    @NotNull
    public final List<SemanticsNode> getReplacedChildrenSortedByBounds$ui_release() {
        return getChildren(true, false, true);
    }

    @Nullable
    public final RootForTest getRoot() {
        Owner owner$ui_release = this.layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release.getRootForTest();
        }
        return null;
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m2251getSizeYbymL2g() {
        return findCoordinatorToGetBounds$ui_release().getSize-YbymL2g();
    }

    @NotNull
    public final Rect getTouchBoundsInRoot() {
        SemanticsModifierNode semanticsModifierNode;
        if (this.unmergedConfig.isMergingSemanticsOfDescendants()) {
            semanticsModifierNode = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
            if (semanticsModifierNode == null) {
                semanticsModifierNode = this.outerSemanticsNode;
            }
        } else {
            semanticsModifierNode = this.outerSemanticsNode;
        }
        return SemanticsModifierNodeKt.touchBoundsInRoot(semanticsModifierNode);
    }

    @NotNull
    public final SemanticsConfiguration getUnmergedConfig$ui_release() {
        return this.unmergedConfig;
    }

    public final boolean isFake$ui_release() {
        return this.isFake;
    }

    public final boolean isRoot() {
        return getParent() == null;
    }

    public final void setFake$ui_release(boolean z) {
        this.isFake = z;
    }

    @NotNull
    public final List<SemanticsNode> unmergedChildren$ui_release(boolean z, boolean z2) {
        if (this.isFake) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        List findOneLayerOfSemanticsWrappersSortedByBounds$default = z ? SemanticsSortKt.findOneLayerOfSemanticsWrappersSortedByBounds$default(this.layoutNode, (List) null, 1, (Object) null) : SemanticsNodeKt.findOneLayerOfSemanticsWrappers$default(this.layoutNode, (List) null, 1, (Object) null);
        int size = findOneLayerOfSemanticsWrappersSortedByBounds$default.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new SemanticsNode((SemanticsModifierNode) findOneLayerOfSemanticsWrappersSortedByBounds$default.get(i), this.mergingEnabled, null, 4, null));
        }
        if (z2) {
            emitFakeNodes(arrayList);
        }
        return arrayList;
    }

    private final List<SemanticsNode> getChildren(boolean z, boolean z2, boolean z3) {
        if (!z2 && this.unmergedConfig.isClearingSemantics()) {
            return CollectionsKt.emptyList();
        }
        if (isMergingSemanticsOfDescendants()) {
            return findOneLayerOfMergingSemanticsNodes$default(this, null, z, 1, null);
        }
        return unmergedChildren$ui_release(z, z3);
    }

    public /* synthetic */ SemanticsNode(SemanticsModifierNode semanticsModifierNode, boolean z, LayoutNode layoutNode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(semanticsModifierNode, z, (i & 4) != 0 ? DelegatableNodeKt.requireLayoutNode(semanticsModifierNode) : layoutNode);
    }
}
