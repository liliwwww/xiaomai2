package androidx.compose.foundation.lazy.layout;

import androidx.compose.p004ui.unit.C0856Dp;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class LazyAnimateScrollKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = C0856Dp.m5216constructorimpl(2500);
    private static final float BoundDistance = C0856Dp.m5216constructorimpl(1500);

    @Nullable
    public static final Object animateScrollToItem(@NotNull LazyAnimateScrollScope lazyAnimateScrollScope, int i, int i2, @NotNull Continuation<? super Unit> continuation) {
        Object scroll = lazyAnimateScrollScope.scroll(new LazyAnimateScrollKt$animateScrollToItem$2(i, lazyAnimateScrollScope, i2, null), continuation);
        return scroll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll : Unit.INSTANCE;
    }

    private static final void debugLog(Function0<String> function0) {
    }
}
