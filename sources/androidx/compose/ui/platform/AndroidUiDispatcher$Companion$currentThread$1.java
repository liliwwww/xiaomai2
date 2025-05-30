package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.core.os.HandlerCompat;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidUiDispatcher$Companion$currentThread$1 extends ThreadLocal<CoroutineContext> {
    AndroidUiDispatcher$Companion$currentThread$1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    @NotNull
    public CoroutineContext initialValue() {
        Choreographer choreographer = Choreographer.getInstance();
        Intrinsics.checkNotNullExpressionValue(choreographer, "getInstance()");
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            throw new IllegalStateException("no Looper on this thread".toString());
        }
        Handler createAsync = HandlerCompat.createAsync(myLooper);
        Intrinsics.checkNotNullExpressionValue(createAsync, "createAsync(\n           …d\")\n                    )");
        AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, createAsync, (DefaultConstructorMarker) null);
        return androidUiDispatcher.plus(androidUiDispatcher.getFrameClock());
    }
}
