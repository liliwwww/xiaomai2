package androidx.compose.foundation.text.selection;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SelectionManager$showSelectionToolbar$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionManager$showSelectionToolbar$1$1(SelectionManager selectionManager) {
        super(0);
        this.this$0 = selectionManager;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m469invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m469invoke() {
        this.this$0.copy$foundation_release();
        this.this$0.onRelease();
    }
}
