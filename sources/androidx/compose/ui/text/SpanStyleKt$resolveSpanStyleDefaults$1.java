package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextForegroundStyle;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SpanStyleKt$resolveSpanStyleDefaults$1 extends Lambda implements Function0<TextForegroundStyle> {
    public static final SpanStyleKt$resolveSpanStyleDefaults$1 INSTANCE = new SpanStyleKt$resolveSpanStyleDefaults$1();

    SpanStyleKt$resolveSpanStyleDefaults$1() {
        super(0);
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final TextForegroundStyle m2304invoke() {
        return TextForegroundStyle.Companion.from-8_81llA(SpanStyleKt.access$getDefaultColor$p());
    }
}
