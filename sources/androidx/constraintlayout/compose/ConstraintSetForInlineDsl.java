package androidx.constraintlayout.compose;

import android.os.Handler;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.constraintlayout.compose.ConstraintSet;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b'\u0010(J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016R\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintSetForInlineDsl;", "Landroidx/constraintlayout/compose/ConstraintSet;", "Landroidx/compose/runtime/RememberObserver;", "Landroidx/constraintlayout/compose/State;", "state", "", "Landroidx/compose/ui/layout/Measurable;", "measurables", "", "applyTo", "", "isDirty", "onRemembered", "onForgotten", "onAbandoned", "Landroidx/constraintlayout/compose/ConstraintLayoutScope;", "scope", "Landroidx/constraintlayout/compose/ConstraintLayoutScope;", "getScope", "()Landroidx/constraintlayout/compose/ConstraintLayoutScope;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "observer", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "knownDirty", "Z", "getKnownDirty", "()Z", "setKnownDirty", "(Z)V", "Lkotlin/Function1;", "onCommitAffectingConstrainLambdas", "Lkotlin/jvm/functions/Function1;", "", "Landroidx/constraintlayout/compose/ConstraintLayoutParentData;", "previousDatas", "Ljava/util/List;", "<init>", "(Landroidx/constraintlayout/compose/ConstraintLayoutScope;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ConstraintSetForInlineDsl implements RememberObserver, ConstraintSet {

    @Nullable
    private Handler handler;
    private boolean knownDirty;

    @NotNull
    private final SnapshotStateObserver observer;

    @NotNull
    private final Function1<Unit, Unit> onCommitAffectingConstrainLambdas;

    @NotNull
    private final List<ConstraintLayoutParentData> previousDatas;

    @NotNull
    private final ConstraintLayoutScope scope;

    public ConstraintSetForInlineDsl(@NotNull ConstraintLayoutScope constraintLayoutScope) {
        Intrinsics.checkNotNullParameter(constraintLayoutScope, "scope");
        this.scope = constraintLayoutScope;
        this.observer = new SnapshotStateObserver(new ConstraintSetForInlineDsl$observer$1(this));
        this.knownDirty = true;
        this.onCommitAffectingConstrainLambdas = new Function1<Unit, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintSetForInlineDsl$onCommitAffectingConstrainLambdas$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Unit) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "$noName_0");
                ConstraintSetForInlineDsl.this.setKnownDirty(true);
            }
        };
        this.previousDatas = new ArrayList();
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public void applyTo(@NotNull androidx.constraintlayout.core.state.Transition transition, int i) {
        ConstraintSet.DefaultImpls.applyTo(this, transition, i);
    }

    public final boolean getKnownDirty() {
        return this.knownDirty;
    }

    @NotNull
    public final ConstraintLayoutScope getScope() {
        return this.scope;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public boolean isDirty(@NotNull List<? extends Measurable> measurables) {
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        if (this.knownDirty || measurables.size() != this.previousDatas.size()) {
            return true;
        }
        int size = measurables.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Object parentData = measurables.get(i).getParentData();
                if (!Intrinsics.areEqual(parentData instanceof ConstraintLayoutParentData ? (ConstraintLayoutParentData) parentData : null, this.previousDatas.get(i))) {
                    return true;
                }
                if (i2 > size) {
                    break;
                }
                i = i2;
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        this.observer.stop();
        this.observer.clear();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
        this.observer.start();
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    @NotNull
    public ConstraintSet override(@NotNull String str, float f) {
        return ConstraintSet.DefaultImpls.override(this, str, f);
    }

    public final void setKnownDirty(boolean z) {
        this.knownDirty = z;
    }

    @Override // androidx.constraintlayout.compose.ConstraintSet
    public void applyTo(@NotNull final State state, @NotNull final List<? extends Measurable> measurables) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        this.scope.applyTo(state);
        this.previousDatas.clear();
        this.observer.observeReads(Unit.INSTANCE, this.onCommitAffectingConstrainLambdas, new Function0<Unit>() { // from class: androidx.constraintlayout.compose.ConstraintSetForInlineDsl$applyTo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m5524invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m5524invoke() {
                List list;
                List<Measurable> list2 = measurables;
                State state2 = state;
                ConstraintSetForInlineDsl constraintSetForInlineDsl = this;
                int size = list2.size() - 1;
                if (size < 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    Object parentData = list2.get(i).getParentData();
                    ConstraintLayoutParentData constraintLayoutParentData = parentData instanceof ConstraintLayoutParentData ? (ConstraintLayoutParentData) parentData : null;
                    if (constraintLayoutParentData != null) {
                        ConstrainScope constrainScope = new ConstrainScope(constraintLayoutParentData.getRef().getId());
                        constraintLayoutParentData.getConstrain().invoke(constrainScope);
                        constrainScope.applyTo$compose_release(state2);
                    }
                    list = constraintSetForInlineDsl.previousDatas;
                    list.add(constraintLayoutParentData);
                    if (i2 > size) {
                        return;
                    } else {
                        i = i2;
                    }
                }
            }
        });
        this.knownDirty = false;
    }
}
