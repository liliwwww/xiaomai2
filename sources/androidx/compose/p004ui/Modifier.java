package androidx.compose.p004ui;

import androidx.compose.p004ui.node.DelegatableNode;
import androidx.compose.p004ui.node.DelegatableNodeKt;
import androidx.compose.p004ui.node.NodeCoordinator;
import androidx.compose.p004ui.node.OwnerScope;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
@Stable
/* loaded from: classes2.dex */
public interface Modifier {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion implements Modifier {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @Override // androidx.compose.p004ui.Modifier
        public boolean all(@NotNull Function1<? super Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return true;
        }

        @Override // androidx.compose.p004ui.Modifier
        public boolean any(@NotNull Function1<? super Element, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "predicate");
            return false;
        }

        @Override // androidx.compose.p004ui.Modifier
        public <R> R foldIn(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return r;
        }

        @Override // androidx.compose.p004ui.Modifier
        public <R> R foldOut(R r, @NotNull Function2<? super Element, ? super R, ? extends R> function2) {
            Intrinsics.checkNotNullParameter(function2, "operation");
            return r;
        }

        @Override // androidx.compose.p004ui.Modifier
        @NotNull
        public Modifier then(@NotNull Modifier modifier) {
            Intrinsics.checkNotNullParameter(modifier, "other");
            return modifier;
        }

        @NotNull
        public String toString() {
            return "Modifier";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        @Deprecated
        @NotNull
        public static Modifier then(@NotNull Modifier modifier, @NotNull Modifier modifier2) {
            Intrinsics.checkNotNullParameter(modifier2, "other");
            return mt2.b(modifier, modifier2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface Element extends Modifier {

        /* compiled from: Taobao */
        public static final class DefaultImpls {
            @Deprecated
            public static boolean all(@NotNull Element element, @NotNull Function1<? super Element, Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "predicate");
                return nt2.e(element, function1);
            }

            @Deprecated
            public static boolean any(@NotNull Element element, @NotNull Function1<? super Element, Boolean> function1) {
                Intrinsics.checkNotNullParameter(function1, "predicate");
                return nt2.f(element, function1);
            }

            @Deprecated
            public static <R> R foldIn(@NotNull Element element, R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2) {
                Intrinsics.checkNotNullParameter(function2, "operation");
                return (R) nt2.g(element, r, function2);
            }

            @Deprecated
            public static <R> R foldOut(@NotNull Element element, R r, @NotNull Function2<? super Element, ? super R, ? extends R> function2) {
                Intrinsics.checkNotNullParameter(function2, "operation");
                return (R) nt2.h(element, r, function2);
            }

            @Deprecated
            @NotNull
            public static Modifier then(@NotNull Element element, @NotNull Modifier modifier) {
                Intrinsics.checkNotNullParameter(modifier, "other");
                return nt2.i(element, modifier);
            }
        }

        @Override // androidx.compose.p004ui.Modifier
        boolean all(@NotNull Function1<? super Element, Boolean> function1);

        @Override // androidx.compose.p004ui.Modifier
        boolean any(@NotNull Function1<? super Element, Boolean> function1);

        @Override // androidx.compose.p004ui.Modifier
        <R> R foldIn(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2);

        @Override // androidx.compose.p004ui.Modifier
        <R> R foldOut(R r, @NotNull Function2<? super Element, ? super R, ? extends R> function2);
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    @ExperimentalComposeUiApi
    /* loaded from: classes.dex */
    public static abstract class Node implements DelegatableNode, OwnerScope {
        public static final int $stable = 8;
        private int aggregateChildKindSet;

        @Nullable
        private Node child;

        @Nullable
        private NodeCoordinator coordinator;
        private boolean isAttached;
        private int kindSet;

        @NotNull
        private Node node = this;

        @Nullable
        private Node parent;

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
        public final Node getChild$ui_release() {
            return this.child;
        }

        @Nullable
        public final NodeCoordinator getCoordinator$ui_release() {
            return this.coordinator;
        }

        public final int getKindSet$ui_release() {
            return this.kindSet;
        }

        @Override // androidx.compose.p004ui.node.DelegatableNode
        @NotNull
        public final Node getNode() {
            return this.node;
        }

        @Nullable
        public final Node getParent$ui_release() {
            return this.parent;
        }

        public final boolean isAttached() {
            return this.isAttached;
        }

        /* renamed from: isKind-H91voCI$ui_release, reason: not valid java name */
        public final boolean m2451isKindH91voCI$ui_release(int i) {
            return (i & getKindSet$ui_release()) != 0;
        }

        @Override // androidx.compose.p004ui.node.OwnerScope
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

        public final void setAsDelegateTo$ui_release(@NotNull Node node) {
            Intrinsics.checkNotNullParameter(node, "owner");
            this.node = node;
        }

        public final void setChild$ui_release(@Nullable Node node) {
            this.child = node;
        }

        public final void setKindSet$ui_release(int i) {
            this.kindSet = i;
        }

        public final void setParent$ui_release(@Nullable Node node) {
            this.parent = node;
        }

        public final void sideEffect(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "effect");
            DelegatableNodeKt.requireOwner(this).registerOnEndApplyChangesListener(function0);
        }

        public void updateCoordinator$ui_release(@Nullable NodeCoordinator nodeCoordinator) {
            this.coordinator = nodeCoordinator;
        }
    }

    boolean all(@NotNull Function1<? super Element, Boolean> function1);

    boolean any(@NotNull Function1<? super Element, Boolean> function1);

    <R> R foldIn(R r, @NotNull Function2<? super R, ? super Element, ? extends R> function2);

    <R> R foldOut(R r, @NotNull Function2<? super Element, ? super R, ? extends R> function2);

    @NotNull
    Modifier then(@NotNull Modifier modifier);
}
