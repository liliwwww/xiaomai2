package androidx.compose.foundation.text.selection;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SelectionManager$onSelectionChange$1 extends Lambda implements Function1<Selection, Unit> {
    public static final SelectionManager$onSelectionChange$1 INSTANCE = new SelectionManager$onSelectionChange$1();

    SelectionManager$onSelectionChange$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Selection) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Selection selection) {
    }
}
