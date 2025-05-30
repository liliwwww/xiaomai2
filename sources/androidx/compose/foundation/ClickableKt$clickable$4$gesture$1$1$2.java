package androidx.compose.foundation;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ClickableKt$clickable$4$gesture$1$1$2 extends Lambda implements Function1<Offset, Unit> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ State<Function0<Unit>> $onClickState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$clickable$4$gesture$1$1$2(boolean z, State<? extends Function0<Unit>> state) {
        super(1);
        this.$enabled = z;
        this.$onClickState = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m141invokek4lQ0M(((Offset) obj).unbox-impl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
    public final void m141invokek4lQ0M(long j) {
        if (this.$enabled) {
            this.$onClickState.getValue().invoke();
        }
    }
}
