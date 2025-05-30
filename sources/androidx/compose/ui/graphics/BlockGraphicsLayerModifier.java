package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.a;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BlockGraphicsLayerModifier extends InspectorValueInfo implements LayoutModifier {

    @NotNull
    private final Function1<GraphicsLayerScope, Unit> layerBlock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BlockGraphicsLayerModifier(@NotNull Function1<? super GraphicsLayerScope, Unit> function1, @NotNull Function1<? super InspectorInfo, Unit> function12) {
        super(function12);
        Intrinsics.checkNotNullParameter(function1, "layerBlock");
        Intrinsics.checkNotNullParameter(function12, "inspectorInfo");
        this.layerBlock = function1;
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof BlockGraphicsLayerModifier) {
            return Intrinsics.areEqual(this.layerBlock, ((BlockGraphicsLayerModifier) obj).layerBlock);
        }
        return false;
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    public int hashCode() {
        return this.layerBlock.hashCode();
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.a(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.b(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    @NotNull
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo49measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Placeable placeable = measurable.measure-BRTryo0(j);
        return MeasureScope$CC.p(measureScope, placeable.getWidth(), placeable.getHeight(), null, new measure.1(placeable, this), 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.c(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.d(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "BlockGraphicsLayerModifier(block=" + this.layerBlock + ')';
    }
}
