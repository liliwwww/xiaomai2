package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ChangeSize {

    @NotNull
    private final Alignment alignment;

    @NotNull
    private final FiniteAnimationSpec<IntSize> animationSpec;
    private final boolean clip;

    @NotNull
    private final Function1<IntSize, IntSize> size;

    public ChangeSize(@NotNull Alignment alignment, @NotNull Function1<? super IntSize, IntSize> function1, @NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, boolean z) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(function1, "size");
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        this.alignment = alignment;
        this.size = function1;
        this.animationSpec = finiteAnimationSpec;
        this.clip = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChangeSize copy$default(ChangeSize changeSize, Alignment alignment, Function1 function1, FiniteAnimationSpec finiteAnimationSpec, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment = changeSize.alignment;
        }
        if ((i & 2) != 0) {
            function1 = changeSize.size;
        }
        if ((i & 4) != 0) {
            finiteAnimationSpec = changeSize.animationSpec;
        }
        if ((i & 8) != 0) {
            z = changeSize.clip;
        }
        return changeSize.copy(alignment, function1, finiteAnimationSpec, z);
    }

    @NotNull
    public final Alignment component1() {
        return this.alignment;
    }

    @NotNull
    public final Function1<IntSize, IntSize> component2() {
        return this.size;
    }

    @NotNull
    public final FiniteAnimationSpec<IntSize> component3() {
        return this.animationSpec;
    }

    public final boolean component4() {
        return this.clip;
    }

    @NotNull
    public final ChangeSize copy(@NotNull Alignment alignment, @NotNull Function1<? super IntSize, IntSize> function1, @NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, boolean z) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(function1, "size");
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new ChangeSize(alignment, function1, finiteAnimationSpec, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangeSize)) {
            return false;
        }
        ChangeSize changeSize = (ChangeSize) obj;
        return Intrinsics.areEqual(this.alignment, changeSize.alignment) && Intrinsics.areEqual(this.size, changeSize.size) && Intrinsics.areEqual(this.animationSpec, changeSize.animationSpec) && this.clip == changeSize.clip;
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @NotNull
    public final FiniteAnimationSpec<IntSize> getAnimationSpec() {
        return this.animationSpec;
    }

    public final boolean getClip() {
        return this.clip;
    }

    @NotNull
    public final Function1<IntSize, IntSize> getSize() {
        return this.size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.alignment.hashCode() * 31) + this.size.hashCode()) * 31) + this.animationSpec.hashCode()) * 31;
        boolean z = this.clip;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "ChangeSize(alignment=" + this.alignment + ", size=" + this.size + ", animationSpec=" + this.animationSpec + ", clip=" + this.clip + ')';
    }

    public /* synthetic */ ChangeSize(Alignment alignment, Function1 function1, FiniteAnimationSpec finiteAnimationSpec, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment, (i & 2) != 0 ? 1.INSTANCE : function1, finiteAnimationSpec, (i & 8) != 0 ? true : z);
    }
}
