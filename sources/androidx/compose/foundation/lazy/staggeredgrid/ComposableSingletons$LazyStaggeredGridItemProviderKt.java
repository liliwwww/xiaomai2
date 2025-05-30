package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ComposableSingletons$LazyStaggeredGridItemProviderKt {

    @NotNull
    public static final ComposableSingletons$LazyStaggeredGridItemProviderKt INSTANCE = new ComposableSingletons$LazyStaggeredGridItemProviderKt();

    /* renamed from: lambda-1, reason: not valid java name */
    @NotNull
    public static Function4<IntervalList.Interval<LazyStaggeredGridIntervalContent>, Integer, Composer, Integer, Unit> f1007lambda1 = ComposableLambdaKt.composableLambdaInstance(539390666, false, new Function4<IntervalList.Interval<? extends LazyStaggeredGridIntervalContent>, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.ComposableSingletons$LazyStaggeredGridItemProviderKt$lambda-1$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            invoke((IntervalList.Interval<LazyStaggeredGridIntervalContent>) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
            return Unit.INSTANCE;
        }

        @Composable
        public final void invoke(@NotNull IntervalList.Interval<LazyStaggeredGridIntervalContent> interval, int i, @Nullable Composer composer, int i2) {
            int i3;
            Intrinsics.checkNotNullParameter(interval, "interval");
            if ((i2 & 14) == 0) {
                i3 = (composer.changed(interval) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 112) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if ((i3 & 731) == 146 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(539390666, i2, -1, "androidx.compose.foundation.lazy.staggeredgrid.ComposableSingletons$LazyStaggeredGridItemProviderKt.lambda-1.<anonymous> (LazyStaggeredGridItemProvider.kt:45)");
            }
            interval.getValue().getItem().invoke(LazyStaggeredGridItemScopeImpl.INSTANCE, Integer.valueOf(i - interval.getStartIndex()), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    @NotNull
    /* renamed from: getLambda-1$foundation_release, reason: not valid java name */
    public final Function4<IntervalList.Interval<LazyStaggeredGridIntervalContent>, Integer, Composer, Integer, Unit> m1623getLambda1$foundation_release() {
        return f1007lambda1;
    }
}
