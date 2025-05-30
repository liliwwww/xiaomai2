package androidx.compose.ui;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.Reference;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0005\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b5\u00106J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR+\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030+8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\r028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00067"}, d2 = {"Landroidx/constraintlayout/compose/State;", "Landroidx/constraintlayout/core/state/State;", "Landroidx/constraintlayout/compose/SolverState;", "", "value", "", "convertDimension", "", "reset", "id", "baselineNeededFor$compose_release", "(Ljava/lang/Object;)V", "baselineNeededFor", "Landroidx/constraintlayout/core/widgets/ConstraintWidget;", "constraintWidget", "", "isBaselineNeeded$compose_release", "(Landroidx/constraintlayout/core/widgets/ConstraintWidget;)Z", "isBaselineNeeded", "Landroidx/constraintlayout/core/widgets/HelperWidget;", "helperWidget", "getKeyId$compose_release", "(Landroidx/constraintlayout/core/widgets/HelperWidget;)Ljava/lang/Object;", "getKeyId", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "rootIncomingConstraints", "J", "getRootIncomingConstraints-msEJaDk", "()J", "setRootIncomingConstraints-BRTryo0", "(J)V", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "", "baselineNeeded", "Ljava/util/List;", "getBaselineNeeded$compose_release", "()Ljava/util/List;", "dirtyBaselineNeededWidgets", "Z", "", "baselineNeededWidgets", "Ljava/util/Set;", "<init>", "(Landroidx/compose/ui/unit/Density;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class State extends androidx.constraintlayout.core.state.State {
    public static final int $stable = 8;

    @NotNull
    private final List<Object> baselineNeeded;

    @NotNull
    private final Set<ConstraintWidget> baselineNeededWidgets;

    @NotNull
    private final Density density;
    private boolean dirtyBaselineNeededWidgets;
    public LayoutDirection layoutDirection;
    private long rootIncomingConstraints;

    public State(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        this.density = density;
        this.rootIncomingConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.baselineNeeded = new ArrayList();
        this.dirtyBaselineNeededWidgets = true;
        this.baselineNeededWidgets = new LinkedHashSet();
    }

    public final void baselineNeededFor$compose_release(@NotNull Object id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.baselineNeeded.add(id);
        this.dirtyBaselineNeededWidgets = true;
    }

    @Override // androidx.constraintlayout.core.state.State
    public int convertDimension(@Nullable Object value) {
        return value instanceof Dp ? this.density.mo319roundToPx0680j_4(((Dp) value).m2156unboximpl()) : super.convertDimension(value);
    }

    @NotNull
    public final List<Object> getBaselineNeeded$compose_release() {
        return this.baselineNeeded;
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @Nullable
    public final Object getKeyId$compose_release(@NotNull HelperWidget helperWidget) {
        Object obj;
        Intrinsics.checkNotNullParameter(helperWidget, "helperWidget");
        Set<Map.Entry<Object, HelperReference>> entrySet = this.mHelperReferences.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "mHelperReferences.entries");
        Iterator<T> it = entrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((HelperReference) ((Map.Entry) obj).getValue()).getHelperWidget(), helperWidget)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    @NotNull
    public final LayoutDirection getLayoutDirection() {
        LayoutDirection layoutDirection = this.layoutDirection;
        if (layoutDirection != null) {
            return layoutDirection;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutDirection");
        throw null;
    }

    /* renamed from: getRootIncomingConstraints-msEJaDk, reason: not valid java name and from getter */
    public final long getRootIncomingConstraints() {
        return this.rootIncomingConstraints;
    }

    public final boolean isBaselineNeeded$compose_release(@NotNull ConstraintWidget constraintWidget) {
        Intrinsics.checkNotNullParameter(constraintWidget, "constraintWidget");
        if (this.dirtyBaselineNeededWidgets) {
            this.baselineNeededWidgets.clear();
            Iterator<T> it = this.baselineNeeded.iterator();
            while (it.hasNext()) {
                Reference reference = this.mReferences.get(it.next());
                ConstraintWidget constraintWidget2 = reference == null ? null : reference.getConstraintWidget();
                if (constraintWidget2 != null) {
                    this.baselineNeededWidgets.add(constraintWidget2);
                }
            }
            this.dirtyBaselineNeededWidgets = false;
        }
        return this.baselineNeededWidgets.contains(constraintWidget);
    }

    @Override // androidx.constraintlayout.core.state.State
    public void reset() {
        ConstraintWidget constraintWidget;
        HashMap<Object, Reference> hashMap = this.mReferences;
        Intrinsics.checkNotNullExpressionValue(hashMap, "mReferences");
        Iterator<Map.Entry<Object, Reference>> it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Reference value = it.next().getValue();
            if (value != null && (constraintWidget = value.getConstraintWidget()) != null) {
                constraintWidget.reset();
            }
        }
        this.mReferences.clear();
        HashMap<Object, Reference> hashMap2 = this.mReferences;
        Intrinsics.checkNotNullExpressionValue(hashMap2, "mReferences");
        hashMap2.put(androidx.constraintlayout.core.state.State.PARENT, this.mParent);
        this.baselineNeeded.clear();
        this.dirtyBaselineNeededWidgets = true;
        super.reset();
    }

    public final void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    /* renamed from: setRootIncomingConstraints-BRTryo0, reason: not valid java name */
    public final void m2313setRootIncomingConstraintsBRTryo0(long j) {
        this.rootIncomingConstraints = j;
    }
}
