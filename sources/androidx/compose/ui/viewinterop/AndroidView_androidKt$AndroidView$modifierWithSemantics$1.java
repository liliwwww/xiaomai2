package androidx.compose.ui.viewinterop;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidView_androidKt$AndroidView$modifierWithSemantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public static final AndroidView_androidKt$AndroidView$modifierWithSemantics$1 INSTANCE = new AndroidView_androidKt$AndroidView$modifierWithSemantics$1();

    AndroidView_androidKt$AndroidView$modifierWithSemantics$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
    }
}
