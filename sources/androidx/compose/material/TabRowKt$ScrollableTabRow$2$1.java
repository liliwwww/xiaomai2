package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class TabRowKt$ScrollableTabRow$2$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ ScrollableTabData $scrollableTabData;
    final /* synthetic */ int $selectedTabIndex;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TabRowKt$ScrollableTabRow$2$1(float f, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, ScrollableTabData scrollableTabData, int i, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i2) {
        super(2);
        this.$edgePadding = f;
        this.$tabs = function2;
        this.$divider = function22;
        this.$scrollableTabData = scrollableTabData;
        this.$selectedTabIndex = i;
        this.$indicator = function3;
        this.$$dirty = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m692invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m2128unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
    public final MeasureResult m692invoke0kLqBqw(@NotNull final SubcomposeMeasureScope subcomposeMeasureScope, final long j) {
        float f;
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
        f = TabRowKt.ScrollableTabRowMinimumTabWidth;
        int mo319roundToPx0680j_4 = subcomposeMeasureScope.mo319roundToPx0680j_4(f);
        final int mo319roundToPx0680j_42 = subcomposeMeasureScope.mo319roundToPx0680j_4(this.$edgePadding);
        long m2113copyZbe2FdA$default = Constraints.m2113copyZbe2FdA$default(j, mo319roundToPx0680j_4, 0, 0, 0, 14, null);
        List subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, this.$tabs);
        final ArrayList<Placeable> arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subcompose, 10));
        Iterator it = subcompose.iterator();
        while (it.hasNext()) {
            arrayList.add(((Measurable) it.next()).mo1521measureBRTryo0(m2113copyZbe2FdA$default));
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = mo319roundToPx0680j_42 * 2;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        for (Placeable placeable : arrayList) {
            intRef.element += placeable.getWidth();
            intRef2.element = Math.max(intRef2.element, placeable.getHeight());
        }
        int i = intRef.element;
        int i2 = intRef2.element;
        final Function2<Composer, Integer, Unit> function2 = this.$divider;
        final ScrollableTabData scrollableTabData = this.$scrollableTabData;
        final int i3 = this.$selectedTabIndex;
        final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.$indicator;
        final int i4 = this.$$dirty;
        return MeasureScope.-CC.p(subcomposeMeasureScope, i, i2, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.TabRowKt$ScrollableTabRow$2$1.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                ArrayList arrayList2 = new ArrayList();
                int i5 = mo319roundToPx0680j_42;
                List<Placeable> list = arrayList;
                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                int i6 = i5;
                for (Placeable placeable2 : list) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i6, 0, 0.0f, 4, (Object) null);
                    arrayList2.add(new TabPosition(subcomposeMeasureScope2.mo312toDpu2uoSUM(i6), subcomposeMeasureScope2.mo312toDpu2uoSUM(placeable2.getWidth()), (DefaultConstructorMarker) null));
                    i6 += placeable2.getWidth();
                }
                List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function2);
                long j2 = j;
                Ref.IntRef intRef3 = intRef;
                Ref.IntRef intRef4 = intRef2;
                for (Measurable measurable : subcompose2) {
                    int i7 = intRef3.element;
                    Placeable mo1521measureBRTryo0 = measurable.mo1521measureBRTryo0(Constraints.m2113copyZbe2FdA$default(j2, i7, i7, 0, 0, 8, null));
                    Placeable.PlacementScope.placeRelative$default(placementScope, mo1521measureBRTryo0, 0, intRef4.element - mo1521measureBRTryo0.getHeight(), 0.0f, 4, (Object) null);
                    intRef3 = intRef3;
                    intRef4 = intRef4;
                    j2 = j2;
                }
                List subcompose3 = subcomposeMeasureScope.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(230769237, true, new 3(function3, arrayList2, i4)));
                Ref.IntRef intRef5 = intRef;
                Ref.IntRef intRef6 = intRef2;
                Iterator it2 = subcompose3.iterator();
                while (it2.hasNext()) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, ((Measurable) it2.next()).mo1521measureBRTryo0(Constraints.Companion.m2130fixedJhjzzOo(intRef5.element, intRef6.element)), 0, 0, 0.0f, 4, (Object) null);
                }
                scrollableTabData.onLaidOut(subcomposeMeasureScope, mo319roundToPx0680j_42, arrayList2, i3);
            }
        }, 4, (Object) null);
    }
}
