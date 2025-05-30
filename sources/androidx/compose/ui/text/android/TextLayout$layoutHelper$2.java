package androidx.compose.ui.text.android;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TextLayout$layoutHelper$2 extends Lambda implements Function0<LayoutHelper> {
    final /* synthetic */ TextLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextLayout$layoutHelper$2(TextLayout textLayout) {
        super(0);
        this.this$0 = textLayout;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final LayoutHelper m2356invoke() {
        return new LayoutHelper(this.this$0.getLayout());
    }
}
