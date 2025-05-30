package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ComposableSingletons$LazyGridItemProviderKt {

    @NotNull
    public static final ComposableSingletons$LazyGridItemProviderKt INSTANCE = new ComposableSingletons$LazyGridItemProviderKt();

    /* renamed from: lambda-1, reason: not valid java name */
    @NotNull
    public static Function4<IntervalList.Interval<LazyGridIntervalContent>, Integer, Composer, Integer, Unit> f0lambda1 = ComposableLambdaKt.composableLambdaInstance(-1961468361, false, lambda-1.1.INSTANCE);

    @NotNull
    /* renamed from: getLambda-1$foundation_release, reason: not valid java name */
    public final Function4<IntervalList.Interval<LazyGridIntervalContent>, Integer, Composer, Integer, Unit> m273getLambda1$foundation_release() {
        return f0lambda1;
    }
}
