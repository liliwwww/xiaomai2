package androidx.compose.ui.layout;

import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure$1 implements MeasureResult {
    final /* synthetic */ int $indexAfterMeasure;
    final /* synthetic */ MeasureResult $result;
    final /* synthetic */ LayoutNodeSubcompositionsState this$0;

    LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure$1(MeasureResult measureResult, LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i) {
        this.$result = measureResult;
        this.this$0 = layoutNodeSubcompositionsState;
        this.$indexAfterMeasure = i;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    @NotNull
    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$result.getAlignmentLines();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getHeight() {
        return this.$result.getHeight();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getWidth() {
        return this.$result.getWidth();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public void placeChildren() {
        int i;
        this.this$0.currentIndex = this.$indexAfterMeasure;
        this.$result.placeChildren();
        LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.this$0;
        i = layoutNodeSubcompositionsState.currentIndex;
        layoutNodeSubcompositionsState.disposeOrReuseStartingFromIndex(i);
    }
}
