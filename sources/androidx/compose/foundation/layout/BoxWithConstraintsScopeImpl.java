package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
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
    public static /* synthetic */ BoxWithConstraintsScopeImpl m199copy0kLqBqw$default(BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl, Density density, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            density = boxWithConstraintsScopeImpl.density;
        }
        if ((i & 2) != 0) {
            j = boxWithConstraintsScopeImpl.m202getConstraintsmsEJaDk();
        }
        return boxWithConstraintsScopeImpl.m201copy0kLqBqw(density, j);
    }

    @Stable
    @NotNull
    public Modifier align(@NotNull Modifier modifier, @NotNull Alignment alignment) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return this.$$delegate_0.align(modifier, alignment);
    }

    /* renamed from: component2-msEJaDk, reason: not valid java name */
    public final long m200component2msEJaDk() {
        return m202getConstraintsmsEJaDk();
    }

    @NotNull
    /* renamed from: copy-0kLqBqw, reason: not valid java name */
    public final BoxWithConstraintsScopeImpl m201copy0kLqBqw(@NotNull Density density, long j) {
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
        return Intrinsics.areEqual(this.density, boxWithConstraintsScopeImpl.density) && Constraints.m2115equalsimpl0(m202getConstraintsmsEJaDk(), boxWithConstraintsScopeImpl.m202getConstraintsmsEJaDk());
    }

    /* renamed from: getConstraints-msEJaDk, reason: not valid java name */
    public long m202getConstraintsmsEJaDk() {
        return this.constraints;
    }

    /* renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name */
    public float m203getMaxHeightD9Ej5fM() {
        return Constraints.m2117getHasBoundedHeightimpl(m202getConstraintsmsEJaDk()) ? this.density.mo312toDpu2uoSUM(Constraints.m2121getMaxHeightimpl(m202getConstraintsmsEJaDk())) : Dp.Companion.m2161getInfinityD9Ej5fM();
    }

    /* renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name */
    public float m204getMaxWidthD9Ej5fM() {
        return Constraints.m2118getHasBoundedWidthimpl(m202getConstraintsmsEJaDk()) ? this.density.mo312toDpu2uoSUM(Constraints.m2122getMaxWidthimpl(m202getConstraintsmsEJaDk())) : Dp.Companion.m2161getInfinityD9Ej5fM();
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public float m205getMinHeightD9Ej5fM() {
        return this.density.mo312toDpu2uoSUM(Constraints.m2123getMinHeightimpl(m202getConstraintsmsEJaDk()));
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public float m206getMinWidthD9Ej5fM() {
        return this.density.mo312toDpu2uoSUM(Constraints.m2124getMinWidthimpl(m202getConstraintsmsEJaDk()));
    }

    public int hashCode() {
        return (this.density.hashCode() * 31) + Constraints.m2125hashCodeimpl(m202getConstraintsmsEJaDk());
    }

    @Stable
    @NotNull
    public Modifier matchParentSize(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return this.$$delegate_0.matchParentSize(modifier);
    }

    @NotNull
    public String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.density + ", constraints=" + ((Object) Constraints.m2127toStringimpl(m202getConstraintsmsEJaDk())) + ')';
    }
}
