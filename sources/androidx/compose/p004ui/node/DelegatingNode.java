package androidx.compose.p004ui.node;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import androidx.compose.p004ui.Modifier;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
/* loaded from: classes2.dex */
public abstract class DelegatingNode extends Modifier.Node {
    public static final int $stable = 8;

    @Nullable
    private Modifier.Node delegate;

    private final void addDelegate(Modifier.Node node) {
        Modifier.Node node2 = this.delegate;
        if (node2 != null) {
            node.setParent$ui_release(node2);
        }
        this.delegate = node;
    }

    private final void forEachDelegate(Function1<? super Modifier.Node, Unit> function1) {
        for (Modifier.Node node = this.delegate; node != null; node = node.getParent$ui_release()) {
            function1.invoke(node);
        }
    }

    @NotNull
    public final <T extends Modifier.Node> T delegated(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "fn");
        Modifier.Node node = getNode();
        T t = (T) function0.invoke();
        t.setAsDelegateTo$ui_release(node);
        if (isAttached()) {
            updateCoordinator$ui_release(node.getCoordinator$ui_release());
            t.attach$ui_release();
        }
        addDelegate(t);
        return t;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        for (Modifier.Node node = this.delegate; node != null; node = node.getParent$ui_release()) {
            node.updateCoordinator$ui_release(getCoordinator$ui_release());
            node.attach$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        for (Modifier.Node node = this.delegate; node != null; node = node.getParent$ui_release()) {
            node.detach$ui_release();
        }
        super.onDetach();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void updateCoordinator$ui_release(@Nullable NodeCoordinator nodeCoordinator) {
        super.updateCoordinator$ui_release(nodeCoordinator);
        for (Modifier.Node node = this.delegate; node != null; node = node.getParent$ui_release()) {
            node.updateCoordinator$ui_release(nodeCoordinator);
        }
    }
}
