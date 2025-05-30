package androidx.compose.foundation.gestures;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ScrollExtensionsKt$animateScrollBy$2$1 extends Lambda implements Function2<Float, Float, Unit> {
    final /* synthetic */ ScrollScope $$this$scroll;
    final /* synthetic */ Ref.FloatRef $previousValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollExtensionsKt$animateScrollBy$2$1(Ref.FloatRef floatRef, ScrollScope scrollScope) {
        super(2);
        this.$previousValue = floatRef;
        this.$$this$scroll = scrollScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f, float f2) {
        Ref.FloatRef floatRef = this.$previousValue;
        float f3 = floatRef.element;
        floatRef.element = f3 + this.$$this$scroll.scrollBy(f - f3);
    }
}
