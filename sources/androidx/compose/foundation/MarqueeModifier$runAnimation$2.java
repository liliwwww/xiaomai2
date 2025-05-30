package androidx.compose.foundation;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class MarqueeModifier$runAnimation$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ MarqueeModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MarqueeModifier$runAnimation$2(MarqueeModifier marqueeModifier) {
        super(0);
        this.this$0 = marqueeModifier;
    }

    @Nullable
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Float m161invoke() {
        if (MarqueeModifier.access$getContentWidth(this.this$0) <= MarqueeModifier.access$getContainerWidth(this.this$0)) {
            return null;
        }
        if (!MarqueeAnimationMode.equals-impl0(this.this$0.getAnimationMode-ZbEOnfQ(), MarqueeAnimationMode.Companion.getWhileFocused-ZbEOnfQ()) || MarqueeModifier.access$getHasFocus(this.this$0)) {
            return Float.valueOf(MarqueeModifier.access$getContentWidth(this.this$0) + MarqueeModifier.access$getSpacingPx(this.this$0));
        }
        return null;
    }
}
