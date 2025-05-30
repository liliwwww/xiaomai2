package androidx.constraintlayout.compose;

import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\t\u001a\u00020\u0001\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0004\u001a\u00020\u0001HÀ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u0005HÀ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\t\u001a\u00020\u00018\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0003R\u001c\u0010\n\u001a\u00020\u00058\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u0018"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", "", "component1$compose_release", "()Ljava/lang/Object;", "component1", "", "component2$compose_release", "()I", "component2", "id", "index", "copy", "", "toString", "hashCode", "other", "", "equals", "Ljava/lang/Object;", "getId$compose_release", "I", "getIndex$compose_release", "<init>", "(Ljava/lang/Object;I)V", "compose_release"}, k = 1, mv = {1, 5, 1})
/* renamed from: androidx.constraintlayout.compose.ConstraintLayoutBaseScope$VerticalAnchor, reason: from toString */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final /* data */ class VerticalAnchor {

    @NotNull
    private final Object id;
    private final int index;

    public VerticalAnchor(@NotNull Object obj, int i) {
        Intrinsics.checkNotNullParameter(obj, "id");
        this.id = obj;
        this.index = i;
    }

    public static /* synthetic */ VerticalAnchor copy$default(VerticalAnchor verticalAnchor, Object obj, int i, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = verticalAnchor.id;
        }
        if ((i2 & 2) != 0) {
            i = verticalAnchor.index;
        }
        return verticalAnchor.copy(obj, i);
    }

    @NotNull
    /* renamed from: component1$compose_release, reason: from getter */
    public final Object getId() {
        return this.id;
    }

    /* renamed from: component2$compose_release, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final VerticalAnchor copy(@NotNull Object id, int index) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new VerticalAnchor(id, index);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VerticalAnchor)) {
            return false;
        }
        VerticalAnchor verticalAnchor = (VerticalAnchor) other;
        return Intrinsics.areEqual(this.id, verticalAnchor.id) && this.index == verticalAnchor.index;
    }

    @NotNull
    public final Object getId$compose_release() {
        return this.id;
    }

    public final int getIndex$compose_release() {
        return this.index;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.index;
    }

    @NotNull
    public String toString() {
        return "VerticalAnchor(id=" + this.id + ", index=" + this.index + ')';
    }
}
