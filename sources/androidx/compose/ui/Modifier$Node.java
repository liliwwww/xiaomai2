package androidx.compose.ui;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.OwnerScope;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class Modifier$Node implements DelegatableNode, OwnerScope {
    public static final int $stable = 8;
    private int aggregateChildKindSet;

    @Nullable
    private Modifier$Node child;

    @Nullable
    private NodeCoordinator coordinator;
    private boolean isAttached;
    private int kindSet;

    @NotNull
    private Modifier$Node node = this;

    @Nullable
    private Modifier$Node parent;

    public static /* synthetic */ void getNode$annotations() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "isValid is hidden so that we can keep the OwnerScope interface internal.")
    public static /* synthetic */ void isValid$annotations() {
    }

    public final void attach$ui_release() {
        if (!(!this.isAttached)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.coordinator != null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.isAttached = true;
        onAttach();
    }

    public final void detach$ui_release() {
        if (!this.isAttached) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.coordinator != null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        onDetach();
        this.isAttached = false;
    }

    public final int getAggregateChildKindSet$ui_release() {
        return this.aggregateChildKindSet;
    }

    @Nullable
    public final Modifier$Node getChild$ui_release() {
        return this.child;
    }

    @Nullable
    public final NodeCoordinator getCoordinator$ui_release() {
        return this.coordinator;
    }

    public final int getKindSet$ui_release() {
        return this.kindSet;
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    @NotNull
    public final Modifier$Node getNode() {
        return this.node;
    }

    @Nullable
    public final Modifier$Node getParent$ui_release() {
        return this.parent;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    /* renamed from: isKind-H91voCI$ui_release, reason: not valid java name */
    public final boolean m812isKindH91voCI$ui_release(int i) {
        return (i & getKindSet$ui_release()) != 0;
    }

    public /* synthetic */ boolean isValid() {
        return this.isAttached;
    }

    public void onAttach() {
    }

    public void onDetach() {
    }

    public final void setAggregateChildKindSet$ui_release(int i) {
        this.aggregateChildKindSet = i;
    }

    public final void setAsDelegateTo$ui_release(@NotNull Modifier$Node modifier$Node) {
        Intrinsics.checkNotNullParameter(modifier$Node, "owner");
        this.node = modifier$Node;
    }

    public final void setChild$ui_release(@Nullable Modifier$Node modifier$Node) {
        this.child = modifier$Node;
    }

    public final void setKindSet$ui_release(int i) {
        this.kindSet = i;
    }

    public final void setParent$ui_release(@Nullable Modifier$Node modifier$Node) {
        this.parent = modifier$Node;
    }

    public final void sideEffect(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "effect");
        DelegatableNodeKt.requireOwner(this).registerOnEndApplyChangesListener(function0);
    }

    public void updateCoordinator$ui_release(@Nullable NodeCoordinator nodeCoordinator) {
        this.coordinator = nodeCoordinator;
    }
}
