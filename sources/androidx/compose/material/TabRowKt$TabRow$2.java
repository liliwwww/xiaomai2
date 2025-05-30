package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope$CC;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class TabRowKt$TabRow$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TabRowKt$TabRow$2(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, int i) {
        super(2);
        this.$tabs = function2;
        this.$divider = function22;
        this.$indicator = function3;
        this.$$dirty = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1961746365, i, -1, "androidx.compose.material.TabRow.<anonymous> (TabRow.kt:149)");
        }
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
        final Function2<Composer, Integer, Unit> function2 = this.$tabs;
        final Function2<Composer, Integer, Unit> function22 = this.$divider;
        final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.$indicator;
        final int i2 = this.$$dirty;
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(function2) | composer.changed(function22) | composer.changed(function3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.TabRowKt$TabRow$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    return m850invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                }

                @NotNull
                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final MeasureResult m850invoke0kLqBqw(@NotNull SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                    Object next;
                    Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                    int i3 = Constraints.getMaxWidth-impl(j);
                    List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function2);
                    int size = subcompose.size();
                    int i4 = i3 / size;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subcompose, 10));
                    Iterator<T> it = subcompose.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((Measurable) it.next()).measure-BRTryo0(Constraints.copy-Zbe2FdA$default(j, i4, i4, 0, 0, 12, (Object) null)));
                    }
                    Iterator it2 = arrayList.iterator();
                    if (it2.hasNext()) {
                        next = it2.next();
                        if (it2.hasNext()) {
                            int height = ((Placeable) next).getHeight();
                            do {
                                Object next2 = it2.next();
                                int height2 = ((Placeable) next2).getHeight();
                                if (height < height2) {
                                    next = next2;
                                    height = height2;
                                }
                            } while (it2.hasNext());
                        }
                    } else {
                        next = null;
                    }
                    Placeable placeable = (Placeable) next;
                    int height3 = placeable != null ? placeable.getHeight() : 0;
                    ArrayList arrayList2 = new ArrayList(size);
                    for (int i5 = 0; i5 < size; i5++) {
                        arrayList2.add(new TabPosition(Dp.constructor-impl(subcomposeMeasureScope.toDp-u2uoSUM(i4) * i5), subcomposeMeasureScope.toDp-u2uoSUM(i4), null));
                    }
                    return MeasureScope$CC.p(subcomposeMeasureScope, i3, height3, null, new 1(arrayList, subcomposeMeasureScope, function22, i4, j, height3, function3, arrayList2, i2, i3), 4, null);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        SubcomposeLayoutKt.SubcomposeLayout(fillMaxWidth$default, (Function2) rememberedValue, composer, 6, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
