package androidx.compose.ui.text.android;

import android.text.BoringLayout;
import android.text.TextPaint;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LayoutIntrinsics$boringMetrics$2 extends Lambda implements Function0<BoringLayout.Metrics> {
    final /* synthetic */ CharSequence $charSequence;
    final /* synthetic */ int $textDirectionHeuristic;
    final /* synthetic */ TextPaint $textPaint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutIntrinsics$boringMetrics$2(int i, CharSequence charSequence, TextPaint textPaint) {
        super(0);
        this.$textDirectionHeuristic = i;
        this.$charSequence = charSequence;
        this.$textPaint = textPaint;
    }

    @Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final BoringLayout.Metrics m2353invoke() {
        return BoringLayoutFactory.INSTANCE.measure(this.$charSequence, this.$textPaint, TextLayoutKt.getTextDirectionHeuristic(this.$textDirectionHeuristic));
    }
}
