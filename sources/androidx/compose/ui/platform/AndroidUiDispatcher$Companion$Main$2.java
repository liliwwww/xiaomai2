package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.core.os.HandlerCompat;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import tb.m11;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class AndroidUiDispatcher$Companion$Main$2 extends Lambda implements Function0<CoroutineContext> {
    public static final AndroidUiDispatcher$Companion$Main$2 INSTANCE = new AndroidUiDispatcher$Companion$Main$2();

    AndroidUiDispatcher$Companion$Main$2() {
        super(0);
    }

    @NotNull
    public final CoroutineContext invoke() {
        boolean isMainThread;
        isMainThread = AndroidUiDispatcher_androidKt.isMainThread();
        Choreographer choreographer = isMainThread ? Choreographer.getInstance() : (Choreographer) d.e(m11.c(), new AndroidUiDispatcher$Companion$Main$2$dispatcher$1(null));
        Intrinsics.checkNotNullExpressionValue(choreographer, "if (isMainThread()) Chor…eographer.getInstance() }");
        Handler createAsync = HandlerCompat.createAsync(Looper.getMainLooper());
        Intrinsics.checkNotNullExpressionValue(createAsync, "createAsync(Looper.getMainLooper())");
        AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, createAsync, (DefaultConstructorMarker) null);
        return androidUiDispatcher.plus(androidUiDispatcher.getFrameClock());
    }
}
