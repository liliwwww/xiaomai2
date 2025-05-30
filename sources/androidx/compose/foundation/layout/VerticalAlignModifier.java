package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class VerticalAlignModifier extends InspectorValueInfo implements ParentDataModifier {

    @NotNull
    private final Alignment$Vertical vertical;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalAlignModifier(@NotNull Alignment$Vertical alignment$Vertical, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(alignment$Vertical, "vertical");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.vertical = alignment$Vertical;
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        VerticalAlignModifier verticalAlignModifier = obj instanceof VerticalAlignModifier ? (VerticalAlignModifier) obj : null;
        if (verticalAlignModifier == null) {
            return false;
        }
        return Intrinsics.areEqual(this.vertical, verticalAlignModifier.vertical);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    @NotNull
    public final Alignment$Vertical getVertical() {
        return this.vertical;
    }

    public int hashCode() {
        return this.vertical.hashCode();
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "VerticalAlignModifier(vertical=" + this.vertical + ')';
    }

    @Override // androidx.compose.ui.layout.ParentDataModifier
    @NotNull
    public RowColumnParentData modifyParentData(@NotNull Density density, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        RowColumnParentData rowColumnParentData = obj instanceof RowColumnParentData ? (RowColumnParentData) obj : null;
        if (rowColumnParentData == null) {
            rowColumnParentData = new RowColumnParentData(0.0f, false, null, 7, null);
        }
        rowColumnParentData.setCrossAxisAlignment(CrossAxisAlignment.Companion.vertical$foundation_layout_release(this.vertical));
        return rowColumnParentData;
    }
}
