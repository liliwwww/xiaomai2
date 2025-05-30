package androidx.core.os;

import android.os.Handler;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class HandlerKt {
    @NotNull
    public static final Runnable postAtTime(@NotNull Handler handler, long j, @Nullable Object obj, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(handler, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        postAtTime.runnable.1 r0 = new postAtTime.runnable.1(function0);
        handler.postAtTime(r0, obj, j);
        return r0;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler handler, long j, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        Intrinsics.checkNotNullParameter(handler, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        postAtTime.runnable.1 r5 = new postAtTime.runnable.1(function0);
        handler.postAtTime(r5, obj, j);
        return r5;
    }

    @NotNull
    public static final Runnable postDelayed(@NotNull Handler handler, long j, @Nullable Object obj, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(handler, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(function0);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j);
        }
        return handlerKt$postDelayed$runnable$1;
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler handler, long j, Object obj, Function0 function0, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        Intrinsics.checkNotNullParameter(handler, "<this>");
        Intrinsics.checkNotNullParameter(function0, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(function0);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j);
        } else {
            HandlerCompat.postDelayed(handler, handlerKt$postDelayed$runnable$1, obj, j);
        }
        return handlerKt$postDelayed$runnable$1;
    }
}
