package androidx.compose.ui.text;

import androidx.compose.ui.text.android.selection.WordBoundary;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidParagraph$wordBoundary$2 extends Lambda implements Function0<WordBoundary> {
    final /* synthetic */ AndroidParagraph this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidParagraph$wordBoundary$2(AndroidParagraph androidParagraph) {
        super(0);
        this.this$0 = androidParagraph;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final WordBoundary m2253invoke() {
        return new WordBoundary(this.this$0.getTextLocale$ui_text_release(), AndroidParagraph.access$getLayout$p(this.this$0).getText());
    }
}
