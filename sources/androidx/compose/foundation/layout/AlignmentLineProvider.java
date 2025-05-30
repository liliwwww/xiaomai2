package androidx.compose.foundation.layout;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class AlignmentLineProvider {

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class Value extends AlignmentLineProvider {
        public static final int $stable = 0;

        @NotNull
        private final AlignmentLine alignmentLine;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Value(@NotNull AlignmentLine alignmentLine) {
            super(null);
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            this.alignmentLine = alignmentLine;
        }

        public static /* synthetic */ Value copy$default(Value value, AlignmentLine alignmentLine, int i, Object obj) {
            if ((i & 1) != 0) {
                alignmentLine = value.alignmentLine;
            }
            return value.copy(alignmentLine);
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public int calculateAlignmentLinePosition(@NotNull Placeable placeable) {
            Intrinsics.checkNotNullParameter(placeable, "placeable");
            return placeable.get(this.alignmentLine);
        }

        @NotNull
        public final AlignmentLine component1() {
            return this.alignmentLine;
        }

        @NotNull
        public final Value copy(@NotNull AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            return new Value(alignmentLine);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Value) && Intrinsics.areEqual(this.alignmentLine, ((Value) obj).alignmentLine);
        }

        @NotNull
        public final AlignmentLine getAlignmentLine() {
            return this.alignmentLine;
        }

        public int hashCode() {
            return this.alignmentLine.hashCode();
        }

        @NotNull
        public String toString() {
            return "Value(alignmentLine=" + this.alignmentLine + ')';
        }
    }

    private AlignmentLineProvider() {
    }

    public /* synthetic */ AlignmentLineProvider(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int calculateAlignmentLinePosition(@NotNull Placeable placeable);
}
