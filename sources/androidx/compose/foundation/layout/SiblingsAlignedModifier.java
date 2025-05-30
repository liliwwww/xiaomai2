package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.AlignmentLineProvider;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.AlignmentLine;
import androidx.compose.p004ui.layout.Measured;
import androidx.compose.p004ui.layout.ParentDataModifier;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.platform.InspectorValueInfo;
import androidx.compose.p004ui.unit.Density;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class SiblingsAlignedModifier extends InspectorValueInfo implements ParentDataModifier {

    /* compiled from: Taobao */
    public static final class WithAlignmentLine extends SiblingsAlignedModifier {

        @NotNull
        private final AlignmentLine alignmentLine;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WithAlignmentLine(@NotNull AlignmentLine alignmentLine, @NotNull Function1<? super InspectorInfo, Unit> function1) {
            super(function1, null);
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
            this.alignmentLine = alignmentLine;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            WithAlignmentLine withAlignmentLine = obj instanceof WithAlignmentLine ? (WithAlignmentLine) obj : null;
            if (withAlignmentLine == null) {
                return false;
            }
            return Intrinsics.areEqual(this.alignmentLine, withAlignmentLine.alignmentLine);
        }

        @NotNull
        public final AlignmentLine getAlignmentLine() {
            return this.alignmentLine;
        }

        public int hashCode() {
            return this.alignmentLine.hashCode();
        }

        @Override // androidx.compose.foundation.layout.SiblingsAlignedModifier, androidx.compose.p004ui.layout.ParentDataModifier
        @NotNull
        public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            RowColumnParentData rowColumnParentData = obj instanceof RowColumnParentData ? (RowColumnParentData) obj : null;
            if (rowColumnParentData == null) {
                rowColumnParentData = new RowColumnParentData(0.0f, false, null, 7, null);
            }
            rowColumnParentData.setCrossAxisAlignment(CrossAxisAlignment.Companion.Relative$foundation_layout_release(new AlignmentLineProvider.Value(this.alignmentLine)));
            return rowColumnParentData;
        }

        @NotNull
        public String toString() {
            return "WithAlignmentLine(line=" + this.alignmentLine + ')';
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class WithAlignmentLineBlock extends SiblingsAlignedModifier {

        @NotNull
        private final Function1<Measured, Integer> block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public WithAlignmentLineBlock(@NotNull Function1<? super Measured, Integer> function1, @NotNull Function1<? super InspectorInfo, Unit> function12) {
            super(function12, null);
            Intrinsics.checkNotNullParameter(function1, "block");
            Intrinsics.checkNotNullParameter(function12, "inspectorInfo");
            this.block = function1;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            WithAlignmentLineBlock withAlignmentLineBlock = obj instanceof WithAlignmentLineBlock ? (WithAlignmentLineBlock) obj : null;
            if (withAlignmentLineBlock == null) {
                return false;
            }
            return Intrinsics.areEqual(this.block, withAlignmentLineBlock.block);
        }

        @NotNull
        public final Function1<Measured, Integer> getBlock() {
            return this.block;
        }

        public int hashCode() {
            return this.block.hashCode();
        }

        @Override // androidx.compose.foundation.layout.SiblingsAlignedModifier, androidx.compose.p004ui.layout.ParentDataModifier
        @NotNull
        public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            RowColumnParentData rowColumnParentData = obj instanceof RowColumnParentData ? (RowColumnParentData) obj : null;
            if (rowColumnParentData == null) {
                rowColumnParentData = new RowColumnParentData(0.0f, false, null, 7, null);
            }
            rowColumnParentData.setCrossAxisAlignment(CrossAxisAlignment.Companion.Relative$foundation_layout_release(new AlignmentLineProvider.Block(this.block)));
            return rowColumnParentData;
        }

        @NotNull
        public String toString() {
            return "WithAlignmentLineBlock(block=" + this.block + ')';
        }
    }

    private SiblingsAlignedModifier(Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
    }

    public /* synthetic */ SiblingsAlignedModifier(Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.p004ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    @Override // androidx.compose.p004ui.layout.ParentDataModifier
    @Nullable
    public abstract Object modifyParentData(@NotNull Density density, @Nullable Object obj);

    @Override // androidx.compose.p004ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
