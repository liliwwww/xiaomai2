package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@LazyGridScopeMarker
/* loaded from: classes.dex */
public interface LazyGridScope {
    void item(@Nullable Object obj, @Nullable Function1<? super LazyGridItemSpanScope, GridItemSpan> function1, @Nullable Object obj2, @NotNull Function3<? super LazyGridItemScope, ? super Composer, ? super Integer, Unit> function3);

    void items(int i, @Nullable Function1<? super Integer, ? extends Object> function1, @Nullable Function2<? super LazyGridItemSpanScope, ? super Integer, GridItemSpan> function2, @NotNull Function1<? super Integer, ? extends Object> function12, @NotNull Function4<? super LazyGridItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4);
}
