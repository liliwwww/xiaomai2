package androidx.appcompat.app;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import java.lang.Thread;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AppCompatDelegateImpl$1 implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ Thread.UncaughtExceptionHandler val$defHandler;

    AppCompatDelegateImpl$1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.val$defHandler = uncaughtExceptionHandler;
    }

    private boolean shouldWrapException(Throwable th) {
        String message;
        if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
            return false;
        }
        return message.contains("drawable") || message.contains("Drawable");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
        if (!shouldWrapException(th)) {
            this.val$defHandler.uncaughtException(thread, th);
            return;
        }
        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
        notFoundException.initCause(th.getCause());
        notFoundException.setStackTrace(th.getStackTrace());
        this.val$defHandler.uncaughtException(thread, notFoundException);
    }
}
