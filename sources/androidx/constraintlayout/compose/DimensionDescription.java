package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.state.Dimension;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B!\b\u0000\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0007j\u0002`\b0\f¢\u0006\u0004\b#\u0010$J\u001b\u0010\u000b\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\nR&\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0007j\u0002`\b0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR-\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR-\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R$\u0010 \u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001c\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/constraintlayout/compose/DimensionDescription;", "Landroidx/constraintlayout/compose/Dimension$Coercible;", "Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "Landroidx/constraintlayout/compose/Dimension;", "Landroidx/constraintlayout/compose/State;", "state", "Landroidx/constraintlayout/core/state/Dimension;", "Landroidx/constraintlayout/compose/SolverDimension;", "toSolverDimension$compose_release", "(Landroidx/constraintlayout/compose/State;)Landroidx/constraintlayout/core/state/Dimension;", "toSolverDimension", "Lkotlin/Function1;", "baseDimension", "Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/unit/Dp;", "min", "Landroidx/compose/ui/unit/Dp;", "getMin-lTKBWiU", "()Landroidx/compose/ui/unit/Dp;", "setMin-YLDhkOg", "(Landroidx/compose/ui/unit/Dp;)V", "", "minSymbol", "Ljava/lang/Object;", "getMinSymbol", "()Ljava/lang/Object;", "setMinSymbol", "(Ljava/lang/Object;)V", "max", "getMax-lTKBWiU", "setMax-YLDhkOg", "maxSymbol", "getMaxSymbol", "setMaxSymbol", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DimensionDescription implements Dimension$Coercible, Dimension$MaxCoercible, Dimension$MinCoercible, Dimension {

    @NotNull
    private final Function1<State, Dimension> baseDimension;

    @Nullable
    private Dp max;

    @Nullable
    private Object maxSymbol;

    @Nullable
    private Dp min;

    @Nullable
    private Object minSymbol;

    public DimensionDescription(@NotNull Function1<? super State, ? extends Dimension> function1) {
        Intrinsics.checkNotNullParameter(function1, "baseDimension");
        this.baseDimension = function1;
    }

    @Nullable
    /* renamed from: getMax-lTKBWiU, reason: not valid java name and from getter */
    public final Dp getMax() {
        return this.max;
    }

    @Nullable
    public final Object getMaxSymbol() {
        return this.maxSymbol;
    }

    @Nullable
    /* renamed from: getMin-lTKBWiU, reason: not valid java name and from getter */
    public final Dp getMin() {
        return this.min;
    }

    @Nullable
    public final Object getMinSymbol() {
        return this.minSymbol;
    }

    /* renamed from: setMax-YLDhkOg, reason: not valid java name */
    public final void m2755setMaxYLDhkOg(@Nullable Dp dp) {
        this.max = dp;
    }

    public final void setMaxSymbol(@Nullable Object obj) {
        this.maxSymbol = obj;
    }

    /* renamed from: setMin-YLDhkOg, reason: not valid java name */
    public final void m2756setMinYLDhkOg(@Nullable Dp dp) {
        this.min = dp;
    }

    public final void setMinSymbol(@Nullable Object obj) {
        this.minSymbol = obj;
    }

    @NotNull
    public final Dimension toSolverDimension$compose_release(@NotNull State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Dimension dimension = (Dimension) this.baseDimension.invoke(state);
        if (getMinSymbol() != null) {
            dimension.min(getMinSymbol());
        } else if (getMin() != null) {
            Dp min = getMin();
            Intrinsics.checkNotNull(min);
            dimension.min(state.convertDimension(min));
        }
        if (getMaxSymbol() != null) {
            dimension.max(getMaxSymbol());
        } else if (getMax() != null) {
            Dp max = getMax();
            Intrinsics.checkNotNull(max);
            dimension.max(state.convertDimension(max));
        }
        return dimension;
    }
}
