package androidx.constraintlayout.compose;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n"}, d2 = {"Lkotlin/Function0;", "", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ConstraintSetForInlineDsl$observer$1 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {
    final /* synthetic */ ConstraintSetForInlineDsl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConstraintSetForInlineDsl$observer$1(ConstraintSetForInlineDsl constraintSetForInlineDsl) {
        super(1);
        this.this$0 = constraintSetForInlineDsl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-1, reason: not valid java name */
    public static final void m2750invoke$lambda1(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Function0<Unit>) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "it");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            function0.invoke();
            return;
        }
        Handler access$getHandler$p = ConstraintSetForInlineDsl.access$getHandler$p(this.this$0);
        if (access$getHandler$p == null) {
            access$getHandler$p = new Handler(Looper.getMainLooper());
            ConstraintSetForInlineDsl.access$setHandler$p(this.this$0, access$getHandler$p);
        }
        access$getHandler$p.post(new a(function0));
    }
}
