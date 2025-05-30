package androidx.compose.material.ripple;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class AndroidRippleIndicationInstance$onInvalidateRipple$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AndroidRippleIndicationInstance this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidRippleIndicationInstance$onInvalidateRipple$1(AndroidRippleIndicationInstance androidRippleIndicationInstance) {
        super(0);
        this.this$0 = androidRippleIndicationInstance;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m726invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m726invoke() {
        AndroidRippleIndicationInstance.access$setInvalidateTick(this.this$0, !AndroidRippleIndicationInstance.access$getInvalidateTick(r0));
    }
}
