package androidx.compose.foundation.text;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot$Companion;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import tb.on2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CoreTextFieldKt$CoreTextField$5$1$1$2 implements MeasurePolicy {
    final /* synthetic */ Density $density;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
    final /* synthetic */ TextFieldState $state;

    CoreTextFieldKt$CoreTextField$5$1$1$2(TextFieldState textFieldState, Function1<? super TextLayoutResult, Unit> function1, Density density, int i) {
        this.$state = textFieldState;
        this.$onTextLayout = function1;
        this.$density = density;
        this.$maxLines = i;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.a(this, intrinsicMeasureScope, list, i);
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(list, "measurables");
        this.$state.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
        return this.$state.getTextDelegate().getMaxIntrinsicWidth();
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m550measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Snapshot$Companion snapshot$Companion = Snapshot.Companion;
        TextFieldState textFieldState = this.$state;
        Snapshot createNonObservableSnapshot = snapshot$Companion.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                createNonObservableSnapshot.dispose();
                Triple<Integer, Integer, TextLayoutResult> m575layout_EkL_Y$foundation_release = TextFieldDelegate.Companion.m575layout_EkL_Y$foundation_release(this.$state.getTextDelegate(), j, measureScope.getLayoutDirection(), value);
                int intValue = ((Number) m575layout_EkL_Y$foundation_release.component1()).intValue();
                int intValue2 = ((Number) m575layout_EkL_Y$foundation_release.component2()).intValue();
                TextLayoutResult textLayoutResult = (TextLayoutResult) m575layout_EkL_Y$foundation_release.component3();
                if (!Intrinsics.areEqual(value, textLayoutResult)) {
                    this.$state.setLayoutResult(new TextLayoutResultProxy(textLayoutResult));
                    this.$onTextLayout.invoke(textLayoutResult);
                }
                this.$state.setMinHeightForSingleLineField-0680j_4(this.$density.toDp-u2uoSUM(this.$maxLines == 1 ? TextDelegateKt.ceilToIntPx(textLayoutResult.getLineBottom(0)) : 0));
                return measureScope.layout(intValue, intValue2, MapsKt.mapOf(new Pair[]{TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(MathKt.roundToInt(textLayoutResult.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(MathKt.roundToInt(textLayoutResult.getLastBaseline())))}), measure.2.INSTANCE);
            } finally {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
            }
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.c(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return on2.d(this, intrinsicMeasureScope, list, i);
    }
}
