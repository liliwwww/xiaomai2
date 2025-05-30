package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@LazyScopeMarker
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface LazyListScope {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static void item(@NotNull LazyListScope lazyListScope, @Nullable Object obj, @Nullable Object obj2, @NotNull Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> function3) {
            Intrinsics.checkNotNullParameter(function3, "content");
            -CC.e(lazyListScope, obj, obj2, function3);
        }

        @Deprecated
        public static void items(@NotNull LazyListScope lazyListScope, int i, @Nullable Function1<? super Integer, ? extends Object> function1, @NotNull Function1<? super Integer, ? extends Object> function12, @NotNull Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
            Intrinsics.checkNotNullParameter(function12, "contentType");
            Intrinsics.checkNotNullParameter(function4, "itemContent");
            -CC.g(lazyListScope, i, function1, function12, function4);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        @Deprecated
        public static /* synthetic */ void item(LazyListScope lazyListScope, Object obj, Function3 function3) {
            Intrinsics.checkNotNullParameter(function3, "content");
            -CC.f(lazyListScope, obj, function3);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        @Deprecated
        public static /* synthetic */ void items(LazyListScope lazyListScope, int i, Function1 function1, Function4 function4) {
            Intrinsics.checkNotNullParameter(function4, "itemContent");
            -CC.h(lazyListScope, i, function1, function4);
        }
    }

    void item(@Nullable Object obj, @Nullable Object obj2, @NotNull Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> function3);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* synthetic */ void item(Object obj, Function3 function3);

    void items(int i, @Nullable Function1<? super Integer, ? extends Object> function1, @NotNull Function1<? super Integer, ? extends Object> function12, @NotNull Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* synthetic */ void items(int i, Function1 function1, Function4 function4);

    @ExperimentalFoundationApi
    void stickyHeader(@Nullable Object obj, @Nullable Object obj2, @NotNull Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> function3);
}
