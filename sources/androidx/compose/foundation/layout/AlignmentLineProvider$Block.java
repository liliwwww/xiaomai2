package androidx.compose.foundation.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.Placeable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AlignmentLineProvider$Block extends AlignmentLineProvider {
    public static final int $stable = 0;

    @NotNull
    private final Function1<Measured, Integer> lineProviderBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlignmentLineProvider$Block(@NotNull Function1<? super Measured, Integer> function1) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(function1, "lineProviderBlock");
        this.lineProviderBlock = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlignmentLineProvider$Block copy$default(AlignmentLineProvider$Block alignmentLineProvider$Block, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = alignmentLineProvider$Block.lineProviderBlock;
        }
        return alignmentLineProvider$Block.copy(function1);
    }

    public int calculateAlignmentLinePosition(@NotNull Placeable placeable) {
        Intrinsics.checkNotNullParameter(placeable, "placeable");
        return ((Number) this.lineProviderBlock.invoke(placeable)).intValue();
    }

    @NotNull
    public final Function1<Measured, Integer> component1() {
        return this.lineProviderBlock;
    }

    @NotNull
    public final AlignmentLineProvider$Block copy(@NotNull Function1<? super Measured, Integer> function1) {
        Intrinsics.checkNotNullParameter(function1, "lineProviderBlock");
        return new AlignmentLineProvider$Block(function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AlignmentLineProvider$Block) && Intrinsics.areEqual(this.lineProviderBlock, ((AlignmentLineProvider$Block) obj).lineProviderBlock);
    }

    @NotNull
    public final Function1<Measured, Integer> getLineProviderBlock() {
        return this.lineProviderBlock;
    }

    public int hashCode() {
        return this.lineProviderBlock.hashCode();
    }

    @NotNull
    public String toString() {
        return "Block(lineProviderBlock=" + this.lineProviderBlock + ')';
    }
}
