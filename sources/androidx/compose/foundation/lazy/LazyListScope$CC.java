package androidx.compose.foundation.lazy;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* renamed from: androidx.compose.foundation.lazy.LazyListScope$-CC, reason: invalid class name */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final /* synthetic */ class LazyListScope$CC {
    public static void a(@Nullable LazyListScope _this, @Nullable Object obj, @NotNull Object obj2, Function3 function3) {
        Intrinsics.checkNotNullParameter(function3, "content");
        throw new IllegalStateException("The method is not implemented".toString());
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static /* synthetic */ void b(LazyListScope _this, Object obj, Function3 function3) {
        Intrinsics.checkNotNullParameter(function3, "content");
        _this.item(obj, (Object) null, function3);
    }

    public static void c(LazyListScope _this, @Nullable int i, @NotNull Function1 function1, @NotNull Function1 function12, Function4 function4) {
        Intrinsics.checkNotNullParameter(function12, "contentType");
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        throw new IllegalStateException("The method is not implemented".toString());
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static /* synthetic */ void d(LazyListScope _this, int i, Function1 function1, Function4 function4) {
        Intrinsics.checkNotNullParameter(function4, "itemContent");
        _this.items(i, function1, new Function1<Integer, Object>() { // from class: androidx.compose.foundation.lazy.LazyListScope$items$2
            @Nullable
            public final Object invoke(int i2) {
                return null;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }
        }, function4);
    }

    public static /* synthetic */ void i(LazyListScope lazyListScope, Object obj, Object obj2, Function3 function3, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        if ((i & 2) != 0) {
            obj2 = null;
        }
        lazyListScope.item(obj, obj2, function3);
    }

    public static /* synthetic */ void j(LazyListScope lazyListScope, Object obj, Function3 function3, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        lazyListScope.item(obj, function3);
    }

    public static /* synthetic */ void k(LazyListScope lazyListScope, int i, Function1 function1, Function1 function12, Function4 function4, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        if ((i2 & 4) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.LazyListScope$items$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }

                @Nullable
                public final Void invoke(int i3) {
                    return null;
                }
            };
        }
        lazyListScope.items(i, function1, function12, function4);
    }

    public static /* synthetic */ void l(LazyListScope lazyListScope, int i, Function1 function1, Function4 function4, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        lazyListScope.items(i, function1, function4);
    }

    public static /* synthetic */ void m(LazyListScope lazyListScope, Object obj, Object obj2, Function3 function3, int i, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
        }
        if ((i & 1) != 0) {
            obj = null;
        }
        if ((i & 2) != 0) {
            obj2 = null;
        }
        lazyListScope.stickyHeader(obj, obj2, function3);
    }
}
