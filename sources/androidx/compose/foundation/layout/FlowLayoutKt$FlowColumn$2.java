package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class FlowLayoutKt$FlowColumn$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<ColumnScope, Composer, Integer, Unit> $content;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ int $maxItemsInEachColumn;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Arrangement$Vertical $verticalArrangement;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowLayoutKt$FlowColumn$2(Modifier modifier, Arrangement$Vertical arrangement$Vertical, Alignment.Horizontal horizontal, int i, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, int i2, int i3) {
        super(2);
        this.$modifier = modifier;
        this.$verticalArrangement = arrangement$Vertical;
        this.$horizontalAlignment = horizontal;
        this.$maxItemsInEachColumn = i;
        this.$content = function3;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        FlowLayoutKt.FlowColumn(this.$modifier, this.$verticalArrangement, this.$horizontalAlignment, this.$maxItemsInEachColumn, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}
