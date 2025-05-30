package androidx.compose.p004ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class OwnerSnapshotObserver {

    @NotNull
    private final SnapshotStateObserver observer;

    @NotNull
    private final Function1<LayoutNode, Unit> onCommitAffectingLayout;

    @NotNull
    private final Function1<LayoutNode, Unit> onCommitAffectingLayoutModifier;

    @NotNull
    private final Function1<LayoutNode, Unit> onCommitAffectingLayoutModifierInLookahead;

    @NotNull
    private final Function1<LayoutNode, Unit> onCommitAffectingLookaheadLayout;

    @NotNull
    private final Function1<LayoutNode, Unit> onCommitAffectingLookaheadMeasure;

    @NotNull
    private final Function1<LayoutNode, Unit> onCommitAffectingMeasure;

    public OwnerSnapshotObserver(@NotNull Function1<? super Function0<Unit>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onChangedExecutor");
        this.observer = new SnapshotStateObserver(function1);
        this.onCommitAffectingLookaheadMeasure = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
                if (layoutNode.isValid()) {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNode, false, 1, null);
                }
            }
        };
        this.onCommitAffectingMeasure = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingMeasure$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
                if (layoutNode.isValid()) {
                    LayoutNode.requestRemeasure$ui_release$default(layoutNode, false, 1, null);
                }
            }
        };
        this.onCommitAffectingLayout = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
                if (layoutNode.isValid()) {
                    LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                }
            }
        };
        this.onCommitAffectingLayoutModifier = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
                if (layoutNode.isValid()) {
                    LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                }
            }
        };
        this.onCommitAffectingLayoutModifierInLookahead = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayoutModifierInLookahead$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
                if (layoutNode.isValid()) {
                    LayoutNode.requestLookaheadRelayout$ui_release$default(layoutNode, false, 1, null);
                }
            }
        };
        this.onCommitAffectingLookaheadLayout = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLookaheadLayout$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutNode) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull LayoutNode layoutNode) {
                Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
                if (layoutNode.isValid()) {
                    LayoutNode.requestLookaheadRelayout$ui_release$default(layoutNode, false, 1, null);
                }
            }
        };
    }

    public static /* synthetic */ void observeLayoutModifierSnapshotReads$ui_release$default(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        ownerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release(layoutNode, z, function0);
    }

    public static /* synthetic */ void observeLayoutSnapshotReads$ui_release$default(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        ownerSnapshotObserver.observeLayoutSnapshotReads$ui_release(layoutNode, z, function0);
    }

    public static /* synthetic */ void observeMeasureSnapshotReads$ui_release$default(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        ownerSnapshotObserver.observeMeasureSnapshotReads$ui_release(layoutNode, z, function0);
    }

    public final void clear$ui_release(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, TypedValues.AttributesType.S_TARGET);
        this.observer.clear(obj);
    }

    public final void clearInvalidObservations$ui_release() {
        this.observer.clearIf(new Function1<Object, Boolean>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$clearInvalidObservations$1
            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m4450invoke(@NotNull Object obj) {
                Intrinsics.checkNotNullParameter(obj, "it");
                return Boolean.valueOf(!((OwnerScope) obj).isValid());
            }
        });
    }

    public final void observeLayoutModifierSnapshotReads$ui_release(@NotNull LayoutNode layoutNode, boolean z, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        Intrinsics.checkNotNullParameter(function0, "block");
        if (!z || layoutNode.getMLookaheadScope$ui_release() == null) {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLayoutModifier, function0);
        } else {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLayoutModifierInLookahead, function0);
        }
    }

    public final void observeLayoutSnapshotReads$ui_release(@NotNull LayoutNode layoutNode, boolean z, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        Intrinsics.checkNotNullParameter(function0, "block");
        if (!z || layoutNode.getMLookaheadScope$ui_release() == null) {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLayout, function0);
        } else {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLookaheadLayout, function0);
        }
    }

    public final void observeMeasureSnapshotReads$ui_release(@NotNull LayoutNode layoutNode, boolean z, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        Intrinsics.checkNotNullParameter(function0, "block");
        if (!z || layoutNode.getMLookaheadScope$ui_release() == null) {
            observeReads$ui_release(layoutNode, this.onCommitAffectingMeasure, function0);
        } else {
            observeReads$ui_release(layoutNode, this.onCommitAffectingLookaheadMeasure, function0);
        }
    }

    public final <T extends OwnerScope> void observeReads$ui_release(@NotNull T t, @NotNull Function1<? super T, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(t, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(function1, "onChanged");
        Intrinsics.checkNotNullParameter(function0, "block");
        this.observer.observeReads(t, function1, function0);
    }

    public final void startObserving$ui_release() {
        this.observer.start();
    }

    public final void stopObserving$ui_release() {
        this.observer.stop();
        this.observer.clear();
    }
}
