package androidx.compose.material;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SwipeToDismissKt$SwipeToDismiss$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $background;
    final /* synthetic */ Set<DismissDirection> $directions;
    final /* synthetic */ Function3<RowScope, Composer, Integer, Unit> $dismissContent;
    final /* synthetic */ Function1<DismissDirection, ThresholdConfig> $dismissThresholds;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ DismissState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeToDismissKt$SwipeToDismiss$3(DismissState dismissState, Modifier modifier, Set<? extends DismissDirection> set, Function1<? super DismissDirection, ? extends ThresholdConfig> function1, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32, int i, int i2) {
        super(2);
        this.$state = dismissState;
        this.$modifier = modifier;
        this.$directions = set;
        this.$dismissThresholds = function1;
        this.$background = function3;
        this.$dismissContent = function32;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i) {
        SwipeToDismissKt.SwipeToDismiss(this.$state, this.$modifier, this.$directions, this.$dismissThresholds, this.$background, this.$dismissContent, composer, this.$$changed | 1, this.$$default);
    }
}
