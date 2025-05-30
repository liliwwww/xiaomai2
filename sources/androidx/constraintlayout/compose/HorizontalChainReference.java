package androidx.constraintlayout.compose;

import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u00020\u00018\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\"\u0010\r\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010\b\u0012\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\b\u0012\u0004\b\u0012\u0010\f\u001a\u0004\b\u0011\u0010\nR\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\b\u0012\u0004\b\u0015\u0010\f\u001a\u0004\b\u0014\u0010\n¨\u0006\u0018"}, d2 = {"Landroidx/constraintlayout/compose/HorizontalChainReference;", "", "id", "Ljava/lang/Object;", "getId$compose_release", "()Ljava/lang/Object;", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "start", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "getStart", "()Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "getStart$annotations", "()V", "absoluteLeft", "getAbsoluteLeft", "getAbsoluteLeft$annotations", "end", "getEnd", "getEnd$annotations", "absoluteRight", "getAbsoluteRight", "getAbsoluteRight$annotations", "<init>", "(Ljava/lang/Object;)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class HorizontalChainReference {

    @NotNull
    private final VerticalAnchor absoluteLeft;

    @NotNull
    private final VerticalAnchor absoluteRight;

    @NotNull
    private final VerticalAnchor end;

    @NotNull
    private final Object id;

    @NotNull
    private final VerticalAnchor start;

    public HorizontalChainReference(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "id");
        this.id = obj;
        this.start = new VerticalAnchor(obj, -2);
        this.absoluteLeft = new VerticalAnchor(obj, 0);
        this.end = new VerticalAnchor(obj, -1);
        this.absoluteRight = new VerticalAnchor(obj, 1);
    }

    @Stable
    public static /* synthetic */ void getAbsoluteLeft$annotations() {
    }

    @Stable
    public static /* synthetic */ void getAbsoluteRight$annotations() {
    }

    @Stable
    public static /* synthetic */ void getEnd$annotations() {
    }

    @Stable
    public static /* synthetic */ void getStart$annotations() {
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
    public final VerticalAnchor getEnd() {
        return this.end;
    }

    @NotNull
    /* renamed from: getId$compose_release, reason: from getter */
    public final Object getId() {
        return this.id;
    }

    @NotNull
    public final VerticalAnchor getStart() {
        return this.start;
    }
}
