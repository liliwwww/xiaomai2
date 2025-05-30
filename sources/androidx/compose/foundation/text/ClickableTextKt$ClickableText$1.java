package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ClickableTextKt$ClickableText$1 extends Lambda implements Function1<TextLayoutResult, Unit> {
    public static final ClickableTextKt$ClickableText$1 INSTANCE = new ClickableTextKt$ClickableText$1();

    ClickableTextKt$ClickableText$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextLayoutResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "it");
    }
}
