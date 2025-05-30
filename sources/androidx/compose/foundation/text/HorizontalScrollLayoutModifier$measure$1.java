package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class HorizontalScrollLayoutModifier$measure$1 extends Lambda implements Function1<Placeable$PlacementScope, Unit> {
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_measure;
    final /* synthetic */ int $width;
    final /* synthetic */ HorizontalScrollLayoutModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HorizontalScrollLayoutModifier$measure$1(MeasureScope measureScope, HorizontalScrollLayoutModifier horizontalScrollLayoutModifier, Placeable placeable, int i) {
        super(1);
        this.$this_measure = measureScope;
        this.this$0 = horizontalScrollLayoutModifier;
        this.$placeable = placeable;
        this.$width = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable$PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
        Rect cursorRectInScroller;
        Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
        MeasureScope measureScope = this.$this_measure;
        int cursorOffset = this.this$0.getCursorOffset();
        TransformedText transformedText = this.this$0.getTransformedText();
        TextLayoutResultProxy textLayoutResultProxy = (TextLayoutResultProxy) this.this$0.getTextLayoutResultProvider().invoke();
        cursorRectInScroller = TextFieldScrollKt.getCursorRectInScroller(measureScope, cursorOffset, transformedText, textLayoutResultProxy != null ? textLayoutResultProxy.getValue() : null, this.$this_measure.getLayoutDirection() == LayoutDirection.Rtl, this.$placeable.getWidth());
        this.this$0.getScrollerPosition().update(Orientation.Horizontal, cursorRectInScroller, this.$width, this.$placeable.getWidth());
        Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, this.$placeable, MathKt.roundToInt(-this.this$0.getScrollerPosition().getOffset()), 0, 0.0f, 4, null);
    }
}
