package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class BasicTextKt$selectionIdSaver$1 extends Lambda implements Function2<SaverScope, Long, Long> {
    final /* synthetic */ SelectionRegistrar $selectionRegistrar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasicTextKt$selectionIdSaver$1(SelectionRegistrar selectionRegistrar) {
        super(2);
        this.$selectionRegistrar = selectionRegistrar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((SaverScope) obj, ((Number) obj2).longValue());
    }

    @Nullable
    public final Long invoke(@NotNull SaverScope saverScope, long j) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        if (SelectionRegistrarKt.hasSelection(this.$selectionRegistrar, j)) {
            return Long.valueOf(j);
        }
        return null;
    }
}
