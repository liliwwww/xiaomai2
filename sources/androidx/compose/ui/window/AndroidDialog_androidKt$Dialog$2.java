package androidx.compose.ui.window;

import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class AndroidDialog_androidKt$Dialog$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DialogWrapper $dialog;
    final /* synthetic */ LayoutDirection $layoutDirection;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    final /* synthetic */ DialogProperties $properties;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidDialog_androidKt$Dialog$2(DialogWrapper dialogWrapper, Function0<Unit> function0, DialogProperties dialogProperties, LayoutDirection layoutDirection) {
        super(0);
        this.$dialog = dialogWrapper;
        this.$onDismissRequest = function0;
        this.$properties = dialogProperties;
        this.$layoutDirection = layoutDirection;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2724invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2724invoke() {
        this.$dialog.updateParameters(this.$onDismissRequest, this.$properties, this.$layoutDirection);
    }
}
