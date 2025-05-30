package androidx.compose.foundation.text;

import androidx.compose.p004ui.graphics.Canvas;
import androidx.compose.p004ui.graphics.Paint;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.SpanStyle;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextPainter;
import androidx.compose.p004ui.text.TextRange;
import androidx.compose.p004ui.text.TextRangeKt;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontSynthesis;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.input.EditCommand;
import androidx.compose.p004ui.text.input.EditProcessor;
import androidx.compose.p004ui.text.input.ImeAction;
import androidx.compose.p004ui.text.input.ImeOptions;
import androidx.compose.p004ui.text.input.OffsetMapping;
import androidx.compose.p004ui.text.input.TextFieldValue;
import androidx.compose.p004ui.text.input.TextInputService;
import androidx.compose.p004ui.text.input.TextInputSession;
import androidx.compose.p004ui.text.input.TransformedText;
import androidx.compose.p004ui.text.intl.LocaleList;
import androidx.compose.p004ui.text.style.BaselineShift;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.text.style.TextGeometricTransform;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class TextFieldDelegate {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: layout-_EkL_-Y$foundation_release$default, reason: not valid java name */
        public static /* synthetic */ Triple m1784layout_EkL_Y$foundation_release$default(Companion companion, TextDelegate textDelegate, long j, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult, int i, Object obj) {
            if ((i & 8) != 0) {
                textLayoutResult = null;
            }
            return companion.m1786layout_EkL_Y$foundation_release(textDelegate, j, layoutDirection, textLayoutResult);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void onEditCommand(List<? extends EditCommand> list, EditProcessor editProcessor, Function1<? super TextFieldValue, Unit> function1, TextInputSession textInputSession) {
            TextFieldValue apply = editProcessor.apply(list);
            if (textInputSession != null) {
                textInputSession.updateState(null, apply);
            }
            function1.invoke(apply);
        }

        @NotNull
        /* renamed from: applyCompositionDecoration-72CqOWE, reason: not valid java name */
        public final TransformedText m1785applyCompositionDecoration72CqOWE(long j, @NotNull TransformedText transformedText) {
            Intrinsics.checkNotNullParameter(transformedText, "transformed");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(transformedText.getText());
            builder.addStyle(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.Companion.getUnderline(), (Shadow) null, 12287, (DefaultConstructorMarker) null), transformedText.getOffsetMapping().originalToTransformed(TextRange.m4749getStartimpl(j)), transformedText.getOffsetMapping().originalToTransformed(TextRange.m4744getEndimpl(j)));
            return new TransformedText(builder.toAnnotatedString(), transformedText.getOffsetMapping());
        }

        @JvmStatic
        public final void draw$foundation_release(@NotNull Canvas canvas, @NotNull TextFieldValue textFieldValue, @NotNull OffsetMapping offsetMapping, @NotNull TextLayoutResult textLayoutResult, @NotNull Paint paint) {
            int originalToTransformed;
            int originalToTransformed2;
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(textFieldValue, "value");
            Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
            Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
            Intrinsics.checkNotNullParameter(paint, "selectionPaint");
            if (!TextRange.m4743getCollapsedimpl(textFieldValue.m4956getSelectiond9O1mEE()) && (originalToTransformed = offsetMapping.originalToTransformed(TextRange.m4747getMinimpl(textFieldValue.m4956getSelectiond9O1mEE()))) != (originalToTransformed2 = offsetMapping.originalToTransformed(TextRange.m4746getMaximpl(textFieldValue.m4956getSelectiond9O1mEE())))) {
                canvas.drawPath(textLayoutResult.getPathForRange(originalToTransformed, originalToTransformed2), paint);
            }
            TextPainter.INSTANCE.paint(canvas, textLayoutResult);
        }

        @JvmStatic
        @NotNull
        /* renamed from: layout-_EkL_-Y$foundation_release, reason: not valid java name */
        public final Triple<Integer, Integer, TextLayoutResult> m1786layout_EkL_Y$foundation_release(@NotNull TextDelegate textDelegate, long j, @NotNull LayoutDirection layoutDirection, @Nullable TextLayoutResult textLayoutResult) {
            Intrinsics.checkNotNullParameter(textDelegate, "textDelegate");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            TextLayoutResult m1781layoutNN6EwU = textDelegate.m1781layoutNN6EwU(j, layoutDirection, textLayoutResult);
            return new Triple<>(Integer.valueOf(IntSize.m5376getWidthimpl(m1781layoutNN6EwU.m4724getSizeYbymL2g())), Integer.valueOf(IntSize.m5375getHeightimpl(m1781layoutNN6EwU.m4724getSizeYbymL2g())), m1781layoutNN6EwU);
        }

        @JvmStatic
        public final void onBlur$foundation_release(@NotNull TextInputSession textInputSession, @NotNull EditProcessor editProcessor, @NotNull Function1<? super TextFieldValue, Unit> function1) {
            Intrinsics.checkNotNullParameter(textInputSession, "textInputSession");
            Intrinsics.checkNotNullParameter(editProcessor, "editProcessor");
            Intrinsics.checkNotNullParameter(function1, "onValueChange");
            function1.invoke(TextFieldValue.m4951copy3r_uNRQ$default(editProcessor.toTextFieldValue(), (AnnotatedString) null, 0L, (TextRange) null, 3, (Object) null));
            textInputSession.dispose();
        }

        @JvmStatic
        @NotNull
        public final TextInputSession onFocus$foundation_release(@NotNull TextInputService textInputService, @NotNull TextFieldValue textFieldValue, @NotNull EditProcessor editProcessor, @NotNull ImeOptions imeOptions, @NotNull Function1<? super TextFieldValue, Unit> function1, @NotNull Function1<? super ImeAction, Unit> function12) {
            Intrinsics.checkNotNullParameter(textInputService, "textInputService");
            Intrinsics.checkNotNullParameter(textFieldValue, "value");
            Intrinsics.checkNotNullParameter(editProcessor, "editProcessor");
            Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
            Intrinsics.checkNotNullParameter(function1, "onValueChange");
            Intrinsics.checkNotNullParameter(function12, "onImeActionPerformed");
            return restartInput$foundation_release(textInputService, textFieldValue, editProcessor, imeOptions, function1, function12);
        }

        @JvmStatic
        @NotNull
        public final TextInputSession restartInput$foundation_release(@NotNull TextInputService textInputService, @NotNull TextFieldValue textFieldValue, @NotNull final EditProcessor editProcessor, @NotNull ImeOptions imeOptions, @NotNull final Function1<? super TextFieldValue, Unit> function1, @NotNull Function1<? super ImeAction, Unit> function12) {
            Intrinsics.checkNotNullParameter(textInputService, "textInputService");
            Intrinsics.checkNotNullParameter(textFieldValue, "value");
            Intrinsics.checkNotNullParameter(editProcessor, "editProcessor");
            Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
            Intrinsics.checkNotNullParameter(function1, "onValueChange");
            Intrinsics.checkNotNullParameter(function12, "onImeActionPerformed");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            TextInputSession startInput = textInputService.startInput(textFieldValue, imeOptions, new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.foundation.text.TextFieldDelegate$Companion$restartInput$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List<? extends EditCommand>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull List<? extends EditCommand> list) {
                    Intrinsics.checkNotNullParameter(list, "it");
                    TextFieldDelegate.Companion.onEditCommand(list, EditProcessor.this, function1, (TextInputSession) objectRef.element);
                }
            }, function12);
            objectRef.element = startInput;
            return startInput;
        }

        @JvmStatic
        /* renamed from: setCursorOffset-ULxng0E$foundation_release, reason: not valid java name */
        public final void m1787setCursorOffsetULxng0E$foundation_release(long j, @NotNull TextLayoutResultProxy textLayoutResultProxy, @NotNull EditProcessor editProcessor, @NotNull OffsetMapping offsetMapping, @NotNull Function1<? super TextFieldValue, Unit> function1) {
            Intrinsics.checkNotNullParameter(textLayoutResultProxy, "textLayoutResult");
            Intrinsics.checkNotNullParameter(editProcessor, "editProcessor");
            Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
            Intrinsics.checkNotNullParameter(function1, "onValueChange");
            function1.invoke(TextFieldValue.m4951copy3r_uNRQ$default(editProcessor.toTextFieldValue(), (AnnotatedString) null, TextRangeKt.TextRange(offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1809getOffsetForPosition3MmeM6k$default(textLayoutResultProxy, j, false, 2, null))), (TextRange) null, 5, (Object) null));
        }
    }

    @JvmStatic
    private static final void onEditCommand(List<? extends EditCommand> list, EditProcessor editProcessor, Function1<? super TextFieldValue, Unit> function1, TextInputSession textInputSession) {
        Companion.onEditCommand(list, editProcessor, function1, textInputSession);
    }
}
