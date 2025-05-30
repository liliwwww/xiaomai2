package androidx.constraintlayout.compose;

import androidx.compose.foundation.layout.LayoutScopeMarker;
import androidx.compose.runtime.Stable;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@LayoutScopeMarker
@Stable
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0002\u001a\u00020\u00018\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R.\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u00068\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017¨\u0006\u001c"}, d2 = {"Landroidx/constraintlayout/compose/VerticalChainScope;", "", "id", "Ljava/lang/Object;", "getId$compose_release", "()Ljava/lang/Object;", "", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/State;", "", "tasks", "Ljava/util/List;", "getTasks$compose_release", "()Ljava/util/List;", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "parent", "Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "getParent", "()Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "Landroidx/constraintlayout/compose/HorizontalAnchorable;", "top", "Landroidx/constraintlayout/compose/HorizontalAnchorable;", "getTop", "()Landroidx/constraintlayout/compose/HorizontalAnchorable;", "bottom", "getBottom", "<init>", "(Ljava/lang/Object;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VerticalChainScope {

    @NotNull
    private final HorizontalAnchorable bottom;

    @NotNull
    private final Object id;

    @NotNull
    private final ConstrainedLayoutReference parent;

    @NotNull
    private final List<Function1<State, Unit>> tasks;

    @NotNull
    private final HorizontalAnchorable top;

    public VerticalChainScope(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "id");
        this.id = obj;
        ArrayList arrayList = new ArrayList();
        this.tasks = arrayList;
        Integer num = State.PARENT;
        Intrinsics.checkNotNullExpressionValue(num, "PARENT");
        this.parent = new ConstrainedLayoutReference(num);
        this.top = new ChainHorizontalAnchorable(arrayList, obj, 0);
        this.bottom = new ChainHorizontalAnchorable(arrayList, obj, 1);
    }

    @NotNull
    public final HorizontalAnchorable getBottom() {
        return this.bottom;
    }

    @NotNull
    /* renamed from: getId$compose_release, reason: from getter */
    public final Object getId() {
        return this.id;
    }

    @NotNull
    public final ConstrainedLayoutReference getParent() {
        return this.parent;
    }

    @NotNull
    public final List<Function1<State, Unit>> getTasks$compose_release() {
        return this.tasks;
    }

    @NotNull
    public final HorizontalAnchorable getTop() {
        return this.top;
    }
}
