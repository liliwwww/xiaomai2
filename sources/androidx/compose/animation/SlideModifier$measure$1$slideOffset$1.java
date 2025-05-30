package androidx.compose.animation;

import androidx.compose.ui.unit.IntOffset;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SlideModifier$measure$1$slideOffset$1 extends Lambda implements Function1<EnterExitState, IntOffset> {
    final /* synthetic */ long $measuredSize;
    final /* synthetic */ SlideModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SlideModifier$measure$1$slideOffset$1(SlideModifier slideModifier, long j) {
        super(1);
        this.this$0 = slideModifier;
        this.$measuredSize = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntOffset.m2634boximpl(m60invokeBjo55l4((EnterExitState) obj));
    }

    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
    public final long m60invokeBjo55l4(@NotNull EnterExitState enterExitState) {
        Intrinsics.checkNotNullParameter(enterExitState, "it");
        return this.this$0.targetValueByState-oFUgxo0(enterExitState, this.$measuredSize);
    }
}
