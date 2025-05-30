package androidx.constraintlayout.compose;

import androidx.compose.runtime.Stable;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\"\u0010\r\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010\b\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0015\u0010\f\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\b\u0012\u0004\b\u0018\u0010\f\u001a\u0004\b\u0017\u0010\nR\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\b\u0012\u0004\b\u001b\u0010\f\u001a\u0004\b\u001a\u0010\nR\"\u0010\u001c\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u0012\u0004\b\u001e\u0010\f\u001a\u0004\b\u001d\u0010\u0014R\"\u0010 \u001a\u00020\u001f8\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b \u0010!\u0012\u0004\b$\u0010\f\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Landroidx/constraintlayout/compose/ConstrainedLayoutReference;", "", "id", "Ljava/lang/Object;", "getId", "()Ljava/lang/Object;", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "start", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "getStart", "()Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "getStart$annotations", "()V", "absoluteLeft", "getAbsoluteLeft", "getAbsoluteLeft$annotations", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "top", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "getTop", "()Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$HorizontalAnchor;", "getTop$annotations", "end", "getEnd", "getEnd$annotations", "absoluteRight", "getAbsoluteRight", "getAbsoluteRight$annotations", "bottom", "getBottom", "getBottom$annotations", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", "baseline", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", "getBaseline", "()Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$BaselineAnchor;", "getBaseline$annotations", "<init>", "(Ljava/lang/Object;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ConstrainedLayoutReference {

    @NotNull
    private final VerticalAnchor absoluteLeft;

    @NotNull
    private final VerticalAnchor absoluteRight;

    @NotNull
    private final ConstraintLayoutBaseScope.BaselineAnchor baseline;

    @NotNull
    private final ConstraintLayoutBaseScope.HorizontalAnchor bottom;

    @NotNull
    private final VerticalAnchor end;

    @NotNull
    private final Object id;

    @NotNull
    private final VerticalAnchor start;

    @NotNull
    private final ConstraintLayoutBaseScope.HorizontalAnchor top;

    public ConstrainedLayoutReference(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "id");
        this.id = obj;
        this.start = new VerticalAnchor(obj, -2);
        this.absoluteLeft = new VerticalAnchor(obj, 0);
        this.top = new ConstraintLayoutBaseScope.HorizontalAnchor(obj, 0);
        this.end = new VerticalAnchor(obj, -1);
        this.absoluteRight = new VerticalAnchor(obj, 1);
        this.bottom = new ConstraintLayoutBaseScope.HorizontalAnchor(obj, 1);
        this.baseline = new ConstraintLayoutBaseScope.BaselineAnchor(obj);
    }

    @Stable
    public static /* synthetic */ void getAbsoluteLeft$annotations() {
    }

    @Stable
    public static /* synthetic */ void getAbsoluteRight$annotations() {
    }

    @Stable
    public static /* synthetic */ void getBaseline$annotations() {
    }

    @Stable
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Stable
    public static /* synthetic */ void getEnd$annotations() {
    }

    @Stable
    public static /* synthetic */ void getStart$annotations() {
    }

    @Stable
    public static /* synthetic */ void getTop$annotations() {
    }

    @NotNull
    public final VerticalAnchor getAbsoluteLeft() {
        return this.absoluteLeft;
    }

    @NotNull
    public final VerticalAnchor getAbsoluteRight() {
        return this.absoluteRight;
    }

    @NotNull
    public final ConstraintLayoutBaseScope.BaselineAnchor getBaseline() {
        return this.baseline;
    }

    @NotNull
    public final ConstraintLayoutBaseScope.HorizontalAnchor getBottom() {
        return this.bottom;
    }

    @NotNull
    public final VerticalAnchor getEnd() {
        return this.end;
    }

    @NotNull
    public final Object getId() {
        return this.id;
    }

    @NotNull
    public final VerticalAnchor getStart() {
        return this.start;
    }

    @NotNull
    public final ConstraintLayoutBaseScope.HorizontalAnchor getTop() {
        return this.top;
    }
}
