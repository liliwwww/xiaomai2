package androidx.compose.foundation.layout;

import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class BoxWithConstraintsScopeImpl implements BoxScope, BoxWithConstraintsScope {
    private final /* synthetic */ BoxScopeInstance $$delegate_0;
    private final long constraints;

    @NotNull
    private final Density density;

    private BoxWithConstraintsScopeImpl(Density density, long j) {
        this.density = density;
        this.constraints = j;
        this.$$delegate_0 = BoxScopeInstance.INSTANCE;
    }

    public /* synthetic */ BoxWithConstraintsScopeImpl(Density density, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(density, j);
    }

    private final Density component1() {
        return this.density;
    }

    /* renamed from: copy-0kLqBqw$default, reason: not valid java name */
    public static /* synthetic */ BoxWithConstraintsScopeImpl m1370copy0kLqBqw$default(BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl, Density density, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            density = boxWithConstraintsScopeImpl.density;
        }
        if ((i & 2) != 0) {
            j = boxWithConstraintsScopeImpl.mo1365getConstraintsmsEJaDk();
        }
        return boxWithConstraintsScopeImpl.m1372copy0kLqBqw(density, j);
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    @Stable
    @NotNull
    public Modifier align(@NotNull Modifier modifier, @NotNull Alignment alignment) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return this.$$delegate_0.align(modifier, alignment);
    }

    /* renamed from: component2-msEJaDk, reason: not valid java name */
    public final long m1371component2msEJaDk() {
        return mo1365getConstraintsmsEJaDk();
    }

    @NotNull
    /* renamed from: copy-0kLqBqw, reason: not valid java name */
    public final BoxWithConstraintsScopeImpl m1372copy0kLqBqw(@NotNull Density density, long j) {
        Intrinsics.checkNotNullParameter(density, "density");
        return new BoxWithConstraintsScopeImpl(density, j, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxWithConstraintsScopeImpl)) {
            return false;
        }
        BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
        return Intrinsics.areEqual(this.density, boxWithConstraintsScopeImpl.density) && Constraints.m5177equalsimpl0(mo1365getConstraintsmsEJaDk(), boxWithConstraintsScopeImpl.mo1365getConstraintsmsEJaDk());
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* renamed from: getConstraints-msEJaDk */
    public long mo1365getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* renamed from: getMaxHeight-D9Ej5fM */
    public float mo1366getMaxHeightD9Ej5fM() {
        return Constraints.m5179getHasBoundedHeightimpl(mo1365getConstraintsmsEJaDk()) ? this.density.mo1280toDpu2uoSUM(Constraints.m5183getMaxHeightimpl(mo1365getConstraintsmsEJaDk())) : C0856Dp.Companion.m5235getInfinityD9Ej5fM();
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* renamed from: getMaxWidth-D9Ej5fM */
    public float mo1367getMaxWidthD9Ej5fM() {
        return Constraints.m5180getHasBoundedWidthimpl(mo1365getConstraintsmsEJaDk()) ? this.density.mo1280toDpu2uoSUM(Constraints.m5184getMaxWidthimpl(mo1365getConstraintsmsEJaDk())) : C0856Dp.Companion.m5235getInfinityD9Ej5fM();
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* renamed from: getMinHeight-D9Ej5fM */
    public float mo1368getMinHeightD9Ej5fM() {
        return this.density.mo1280toDpu2uoSUM(Constraints.m5185getMinHeightimpl(mo1365getConstraintsmsEJaDk()));
    }

    @Override // androidx.compose.foundation.layout.BoxWithConstraintsScope
    /* renamed from: getMinWidth-D9Ej5fM */
    public float mo1369getMinWidthD9Ej5fM() {
        return this.density.mo1280toDpu2uoSUM(Constraints.m5186getMinWidthimpl(mo1365getConstraintsmsEJaDk()));
    }

    public int hashCode() {
        return (this.density.hashCode() * 31) + Constraints.m5187hashCodeimpl(mo1365getConstraintsmsEJaDk());
    }

    @Override // androidx.compose.foundation.layout.BoxScope
    @Stable
    @NotNull
    public Modifier matchParentSize(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return this.$$delegate_0.matchParentSize(modifier);
    }

    @NotNull
    public String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.density + ", constraints=" + ((Object) Constraints.m5189toStringimpl(mo1365getConstraintsmsEJaDk())) + ')';
    }
}
