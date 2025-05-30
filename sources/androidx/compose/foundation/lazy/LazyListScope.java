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
/* loaded from: classes2.dex */
public interface LazyListScope {

    /* compiled from: Taobao */
    /* renamed from: androidx.compose.foundation.lazy.LazyListScope$-CC, reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC {
        /* renamed from: a */
        public static void m65a(@Nullable LazyListScope _this, @Nullable Object obj, @NotNull Object obj2, Function3 function3) {
            Intrinsics.checkNotNullParameter(function3, "content");
            throw new IllegalStateException("The method is not implemented".toString());
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        /* renamed from: b */
        public static /* synthetic */ void m66b(LazyListScope _this, Object obj, Function3 function3) {
            Intrinsics.checkNotNullParameter(function3, "content");
            _this.item(obj, null, function3);
        }

        /* renamed from: c */
        public static void m67c(LazyListScope _this, @Nullable int i, @NotNull Function1 function1, @NotNull Function1 function12, Function4 function4) {
            Intrinsics.checkNotNullParameter(function12, "contentType");
            Intrinsics.checkNotNullParameter(function4, "itemContent");
            throw new IllegalStateException("The method is not implemented".toString());
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        /* renamed from: d */
        public static /* synthetic */ void m68d(LazyListScope _this, int i, Function1 function1, Function4 function4) {
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

        /* renamed from: i */
        public static /* synthetic */ void m73i(LazyListScope lazyListScope, Object obj, Object obj2, Function3 function3, int i, Object obj3) {
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

        /* renamed from: j */
        public static /* synthetic */ void m74j(LazyListScope lazyListScope, Object obj, Function3 function3, int i, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
            }
            if ((i & 1) != 0) {
                obj = null;
            }
            lazyListScope.item(obj, function3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: k */
        public static /* synthetic */ void m75k(LazyListScope lazyListScope, int i, Function1 function1, Function1 function12, Function4 function4, int i2, Object obj) {
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

        /* renamed from: l */
        public static /* synthetic */ void m76l(LazyListScope lazyListScope, int i, Function1 function1, Function4 function4, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
            }
            if ((i2 & 2) != 0) {
                function1 = null;
            }
            lazyListScope.items(i, function1, function4);
        }

        /* renamed from: m */
        public static /* synthetic */ void m77m(LazyListScope lazyListScope, Object obj, Object obj2, Function3 function3, int i, Object obj3) {
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

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static void item(@NotNull LazyListScope lazyListScope, @Nullable Object obj, @Nullable Object obj2, @NotNull Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> function3) {
            Intrinsics.checkNotNullParameter(function3, "content");
            CC.m65a(lazyListScope, obj, obj2, function3);
        }

        @Deprecated
        public static void items(@NotNull LazyListScope lazyListScope, int i, @Nullable Function1<? super Integer, ? extends Object> function1, @NotNull Function1<? super Integer, ? extends Object> function12, @NotNull Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4) {
            Intrinsics.checkNotNullParameter(function12, "contentType");
            Intrinsics.checkNotNullParameter(function4, "itemContent");
            CC.m67c(lazyListScope, i, function1, function12, function4);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        @Deprecated
        public static /* synthetic */ void item(LazyListScope lazyListScope, Object obj, Function3 function3) {
            Intrinsics.checkNotNullParameter(function3, "content");
            CC.m66b(lazyListScope, obj, function3);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
        @Deprecated
        public static /* synthetic */ void items(LazyListScope lazyListScope, int i, Function1 function1, Function4 function4) {
            Intrinsics.checkNotNullParameter(function4, "itemContent");
            CC.m68d(lazyListScope, i, function1, function4);
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
