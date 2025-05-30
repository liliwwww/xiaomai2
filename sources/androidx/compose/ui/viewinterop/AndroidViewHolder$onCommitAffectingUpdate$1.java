package androidx.compose.ui.viewinterop;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidViewHolder$onCommitAffectingUpdate$1 extends Lambda implements Function1<AndroidViewHolder, Unit> {
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$onCommitAffectingUpdate$1(AndroidViewHolder androidViewHolder) {
        super(1);
        this.this$0 = androidViewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AndroidViewHolder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AndroidViewHolder androidViewHolder) {
        Intrinsics.checkNotNullParameter(androidViewHolder, "it");
        this.this$0.getHandler().post(new a(AndroidViewHolder.access$getRunUpdate$p(this.this$0)));
    }
}
