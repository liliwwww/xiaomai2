package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LookaheadIntermediateLayoutModifierImpl extends InspectorValueInfo implements IntermediateLayoutModifier {

    @NotNull
    private final Function4<MeasureScope, Measurable, Constraints, IntSize, MeasureResult> measureBlock;
    private long targetSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LookaheadIntermediateLayoutModifierImpl(@NotNull Function4<? super MeasureScope, ? super Measurable, ? super Constraints, ? super IntSize, ? extends MeasureResult> function4, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(function4, "measureBlock");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.measureBlock = function4;
        this.targetSize = IntSize.Companion.getZero-YbymL2g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LookaheadIntermediateLayoutModifierImpl)) {
            return false;
        }
        LookaheadIntermediateLayoutModifierImpl lookaheadIntermediateLayoutModifierImpl = (LookaheadIntermediateLayoutModifierImpl) obj;
        return Intrinsics.areEqual(this.measureBlock, lookaheadIntermediateLayoutModifierImpl.measureBlock) && IntSize.equals-impl0(m1542getTargetSizeYbymL2g(), lookaheadIntermediateLayoutModifierImpl.m1542getTargetSizeYbymL2g());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    @NotNull
    public final Function4<MeasureScope, Measurable, Constraints, IntSize, MeasureResult> getMeasureBlock() {
        return this.measureBlock;
    }

    /* renamed from: getTargetSize-YbymL2g, reason: not valid java name */
    public long m1542getTargetSizeYbymL2g() {
        return this.targetSize;
    }

    public int hashCode() {
        return (this.measureBlock.hashCode() * 31) + IntSize.hashCode-impl(m1542getTargetSizeYbymL2g());
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.a(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.b(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1543measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return (MeasureResult) this.measureBlock.invoke(measureScope, measurable, Constraints.m2110boximpl(j), IntSize.box-impl(m1542getTargetSizeYbymL2g()));
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.c(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.d(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    /* renamed from: setTargetSize-ozmzZPI, reason: not valid java name */
    public void m1544setTargetSizeozmzZPI(long j) {
        this.targetSize = j;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }
}
