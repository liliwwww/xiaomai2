package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BasicTextKt$BasicText$5 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Map<String, InlineTextContent> $inlineContent;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ int $minLines;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
    final /* synthetic */ int $overflow;
    final /* synthetic */ boolean $softWrap;
    final /* synthetic */ TextStyle $style;
    final /* synthetic */ AnnotatedString $text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasicTextKt$BasicText$5(AnnotatedString annotatedString, Modifier modifier, TextStyle textStyle, Function1<? super TextLayoutResult, Unit> function1, int i, boolean z, int i2, int i3, Map<String, InlineTextContent> map, int i4, int i5) {
        super(2);
        this.$text = annotatedString;
        this.$modifier = modifier;
        this.$style = textStyle;
        this.$onTextLayout = function1;
        this.$overflow = i;
        this.$softWrap = z;
        this.$maxLines = i2;
        this.$minLines = i3;
        this.$inlineContent = map;
        this.$$changed = i4;
        this.$$default = i5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        BasicTextKt.BasicText-VhcvRP8(this.$text, this.$modifier, this.$style, this.$onTextLayout, this.$overflow, this.$softWrap, this.$maxLines, this.$minLines, this.$inlineContent, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
