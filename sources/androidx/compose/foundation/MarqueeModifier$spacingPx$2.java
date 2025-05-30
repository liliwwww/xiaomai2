package androidx.compose.foundation;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class MarqueeModifier$spacingPx$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ MarqueeModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MarqueeModifier$spacingPx$2(MarqueeModifier marqueeModifier) {
        super(0);
        this.this$0 = marqueeModifier;
    }

    @NotNull
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Integer m162invoke() {
        MarqueeSpacing spacing = this.this$0.getSpacing();
        MarqueeModifier marqueeModifier = this.this$0;
        return Integer.valueOf(spacing.calculateSpacing(MarqueeModifier.access$getDensity$p(marqueeModifier), MarqueeModifier.access$getContentWidth(marqueeModifier), MarqueeModifier.access$getContainerWidth(marqueeModifier)));
    }
}
