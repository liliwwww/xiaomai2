package androidx.compose.foundation.text;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.a;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.Constraints;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.mt2;
import tb.nt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class HorizontalScrollLayoutModifier implements LayoutModifier {
    private final int cursorOffset;

    @NotNull
    private final TextFieldScrollerPosition scrollerPosition;

    @NotNull
    private final Function0<TextLayoutResultProxy> textLayoutResultProvider;

    @NotNull
    private final TransformedText transformedText;

    public HorizontalScrollLayoutModifier(@NotNull TextFieldScrollerPosition textFieldScrollerPosition, int i, @NotNull TransformedText transformedText, @NotNull Function0<TextLayoutResultProxy> function0) {
        Intrinsics.checkNotNullParameter(textFieldScrollerPosition, "scrollerPosition");
        Intrinsics.checkNotNullParameter(transformedText, "transformedText");
        Intrinsics.checkNotNullParameter(function0, "textLayoutResultProvider");
        this.scrollerPosition = textFieldScrollerPosition;
        this.cursorOffset = i;
        this.transformedText = transformedText;
        this.textLayoutResultProvider = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HorizontalScrollLayoutModifier copy$default(HorizontalScrollLayoutModifier horizontalScrollLayoutModifier, TextFieldScrollerPosition textFieldScrollerPosition, int i, TransformedText transformedText, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            textFieldScrollerPosition = horizontalScrollLayoutModifier.scrollerPosition;
        }
        if ((i2 & 2) != 0) {
            i = horizontalScrollLayoutModifier.cursorOffset;
        }
        if ((i2 & 4) != 0) {
            transformedText = horizontalScrollLayoutModifier.transformedText;
        }
        if ((i2 & 8) != 0) {
            function0 = horizontalScrollLayoutModifier.textLayoutResultProvider;
        }
        return horizontalScrollLayoutModifier.copy(textFieldScrollerPosition, i, transformedText, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean all(Function1 function1) {
        return nt2.a(this, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ boolean any(Function1 function1) {
        return nt2.b(this, function1);
    }

    @NotNull
    public final TextFieldScrollerPosition component1() {
        return this.scrollerPosition;
    }

    public final int component2() {
        return this.cursorOffset;
    }

    @NotNull
    public final TransformedText component3() {
        return this.transformedText;
    }

    @NotNull
    public final Function0<TextLayoutResultProxy> component4() {
        return this.textLayoutResultProvider;
    }

    @NotNull
    public final HorizontalScrollLayoutModifier copy(@NotNull TextFieldScrollerPosition textFieldScrollerPosition, int i, @NotNull TransformedText transformedText, @NotNull Function0<TextLayoutResultProxy> function0) {
        Intrinsics.checkNotNullParameter(textFieldScrollerPosition, "scrollerPosition");
        Intrinsics.checkNotNullParameter(transformedText, "transformedText");
        Intrinsics.checkNotNullParameter(function0, "textLayoutResultProvider");
        return new HorizontalScrollLayoutModifier(textFieldScrollerPosition, i, transformedText, function0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HorizontalScrollLayoutModifier)) {
            return false;
        }
        HorizontalScrollLayoutModifier horizontalScrollLayoutModifier = (HorizontalScrollLayoutModifier) obj;
        return Intrinsics.areEqual(this.scrollerPosition, horizontalScrollLayoutModifier.scrollerPosition) && this.cursorOffset == horizontalScrollLayoutModifier.cursorOffset && Intrinsics.areEqual(this.transformedText, horizontalScrollLayoutModifier.transformedText) && Intrinsics.areEqual(this.textLayoutResultProvider, horizontalScrollLayoutModifier.textLayoutResultProvider);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return nt2.c(this, obj, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return nt2.d(this, obj, function2);
    }

    public final int getCursorOffset() {
        return this.cursorOffset;
    }

    @NotNull
    public final TextFieldScrollerPosition getScrollerPosition() {
        return this.scrollerPosition;
    }

    @NotNull
    public final Function0<TextLayoutResultProxy> getTextLayoutResultProvider() {
        return this.textLayoutResultProvider;
    }

    @NotNull
    public final TransformedText getTransformedText() {
        return this.transformedText;
    }

    public int hashCode() {
        return (((((this.scrollerPosition.hashCode() * 31) + this.cursorOffset) * 31) + this.transformedText.hashCode()) * 31) + this.textLayoutResultProvider.hashCode();
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.a(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.b(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m394measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Placeable mo1521measureBRTryo0 = measurable.mo1521measureBRTryo0(measurable.maxIntrinsicWidth(Constraints.m2121getMaxHeightimpl(j)) < Constraints.m2122getMaxWidthimpl(j) ? j : Constraints.m2113copyZbe2FdA$default(j, 0, Integer.MAX_VALUE, 0, 0, 13, null));
        int min = Math.min(mo1521measureBRTryo0.getWidth(), Constraints.m2122getMaxWidthimpl(j));
        return MeasureScope.-CC.p(measureScope, min, mo1521measureBRTryo0.getHeight(), (Map) null, new measure.1(measureScope, this, mo1521measureBRTryo0, min), 4, (Object) null);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.c(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return a.d(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return mt2.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "HorizontalScrollLayoutModifier(scrollerPosition=" + this.scrollerPosition + ", cursorOffset=" + this.cursorOffset + ", transformedText=" + this.transformedText + ", textLayoutResultProvider=" + this.textLayoutResultProvider + ')';
    }
}
