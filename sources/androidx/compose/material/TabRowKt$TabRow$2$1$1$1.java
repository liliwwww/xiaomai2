package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TabRowKt$TabRow$2$1$1$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $constraints;
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ List<Placeable> $tabPlaceables;
    final /* synthetic */ List<TabPosition> $tabPositions;
    final /* synthetic */ int $tabRowHeight;
    final /* synthetic */ int $tabRowWidth;
    final /* synthetic */ int $tabWidth;
    final /* synthetic */ SubcomposeMeasureScope $this_SubcomposeLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TabRowKt$TabRow$2$1$1$1(List<? extends Placeable> list, SubcomposeMeasureScope subcomposeMeasureScope, Function2<? super Composer, ? super Integer, Unit> function2, int i, long j, int i2, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, List<TabPosition> list2, int i3, int i4) {
        super(1);
        this.$tabPlaceables = list;
        this.$this_SubcomposeLayout = subcomposeMeasureScope;
        this.$divider = function2;
        this.$tabWidth = i;
        this.$constraints = j;
        this.$tabRowHeight = i2;
        this.$indicator = function3;
        this.$tabPositions = list2;
        this.$$dirty = i3;
        this.$tabRowWidth = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        List<Placeable> list = this.$tabPlaceables;
        int i = this.$tabWidth;
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) obj, i2 * i, 0, 0.0f, 4, (Object) null);
            i2 = i3;
        }
        List subcompose = this.$this_SubcomposeLayout.subcompose(TabSlots.Divider, this.$divider);
        long j = this.$constraints;
        int i4 = this.$tabRowHeight;
        Iterator it = subcompose.iterator();
        while (it.hasNext()) {
            Placeable mo1521measureBRTryo0 = ((Measurable) it.next()).mo1521measureBRTryo0(Constraints.m2113copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
            Placeable.PlacementScope.placeRelative$default(placementScope, mo1521measureBRTryo0, 0, i4 - mo1521measureBRTryo0.getHeight(), 0.0f, 4, (Object) null);
            i4 = i4;
            j = j;
        }
        List subcompose2 = this.$this_SubcomposeLayout.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(-1341594997, true, new 3(this.$indicator, this.$tabPositions, this.$$dirty)));
        int i5 = this.$tabRowWidth;
        int i6 = this.$tabRowHeight;
        Iterator it2 = subcompose2.iterator();
        while (it2.hasNext()) {
            Placeable.PlacementScope.placeRelative$default(placementScope, ((Measurable) it2.next()).mo1521measureBRTryo0(Constraints.Companion.m2130fixedJhjzzOo(i5, i6)), 0, 0, 0.0f, 4, (Object) null);
        }
    }
}
