package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: classes.dex */
public interface LazyLayoutIntervalContent {

    /* compiled from: Taobao */
    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$-CC, reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        @Nullable
        /* renamed from: a */
        public static Function1 m78a(LazyLayoutIntervalContent lazyLayoutIntervalContent) {
            return null;
        }

        @NotNull
        /* renamed from: b */
        public static Function1 m79b(LazyLayoutIntervalContent _this) {
            return new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$type$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                @Nullable
                public final Void invoke(int i) {
                    return null;
                }
            };
        }
    }

    @Nullable
    Function1<Integer, Object> getKey();

    @NotNull
    Function1<Integer, Object> getType();
}
