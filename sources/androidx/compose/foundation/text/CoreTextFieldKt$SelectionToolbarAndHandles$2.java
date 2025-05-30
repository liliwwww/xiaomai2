package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class CoreTextFieldKt$SelectionToolbarAndHandles$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ boolean $show;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$SelectionToolbarAndHandles$2(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i) {
        super(2);
        this.$manager = textFieldSelectionManager;
        this.$show = z;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        CoreTextFieldKt.access$SelectionToolbarAndHandles(this.$manager, this.$show, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
