package androidx.compose.p004ui.platform;

import android.os.Handler;
import android.taobao.windvane.connect.api.ApiConstants;
import android.view.View;
import androidx.compose.p004ui.InternalComposeUiApi;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.ExceptionsKt;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import tb.cy1;
import tb.iw1;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@InternalComposeUiApi
/* loaded from: classes.dex */
public final class WindowRecomposerPolicy {

    @NotNull
    public static final WindowRecomposerPolicy INSTANCE = new WindowRecomposerPolicy();

    @NotNull
    private static final AtomicReference<WindowRecomposerFactory> factory = new AtomicReference<>(WindowRecomposerFactory.Companion.getLifecycleAware());
    public static final int $stable = 8;

    private WindowRecomposerPolicy() {
    }

    @PublishedApi
    public final boolean compareAndSetFactory(@NotNull WindowRecomposerFactory windowRecomposerFactory, @NotNull WindowRecomposerFactory windowRecomposerFactory2) {
        Intrinsics.checkNotNullParameter(windowRecomposerFactory, "expected");
        Intrinsics.checkNotNullParameter(windowRecomposerFactory2, "factory");
        return factory.compareAndSet(windowRecomposerFactory, windowRecomposerFactory2);
    }

    @NotNull
    public final Recomposer createAndInstallWindowRecomposer$ui_release(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Recomposer createRecomposer = factory.get().createRecomposer(view);
        WindowRecomposer_androidKt.setCompositionContext(view, createRecomposer);
        iw1 iw1Var = iw1.INSTANCE;
        Handler handler = view.getHandler();
        Intrinsics.checkNotNullExpressionValue(handler, "rootView.handler");
        final Job d = d.d(iw1Var, cy1.d(handler, "windowRecomposer cleanup").e(), (CoroutineStart) null, new C0830xbfd085b3(createRecomposer, view, null), 2, (Object) null);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.WindowRecomposerPolicy$createAndInstallWindowRecomposer$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, ApiConstants.f5V);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, ApiConstants.f5V);
                view2.removeOnAttachStateChangeListener(this);
                Job.a.b(d, (CancellationException) null, 1, (Object) null);
            }
        });
        return createRecomposer;
    }

    @PublishedApi
    @NotNull
    public final WindowRecomposerFactory getAndSetFactory(@NotNull WindowRecomposerFactory windowRecomposerFactory) {
        Intrinsics.checkNotNullParameter(windowRecomposerFactory, "factory");
        WindowRecomposerFactory andSet = factory.getAndSet(windowRecomposerFactory);
        Intrinsics.checkNotNullExpressionValue(andSet, "factory.getAndSet(factory)");
        return andSet;
    }

    public final void setFactory(@NotNull WindowRecomposerFactory windowRecomposerFactory) {
        Intrinsics.checkNotNullParameter(windowRecomposerFactory, "factory");
        factory.set(windowRecomposerFactory);
    }

    public final <R> R withFactory(@NotNull WindowRecomposerFactory windowRecomposerFactory, @NotNull Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(windowRecomposerFactory, "factory");
        Intrinsics.checkNotNullParameter(function0, "block");
        WindowRecomposerFactory andSetFactory = getAndSetFactory(windowRecomposerFactory);
        try {
            R r = (R) function0.invoke();
            InlineMarker.finallyStart(1);
            if (!compareAndSetFactory(windowRecomposerFactory, andSetFactory)) {
                throw new IllegalStateException("WindowRecomposerFactory was set to unexpected value; cannot safely restore old state");
            }
            InlineMarker.finallyEnd(1);
            return r;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                if (compareAndSetFactory(windowRecomposerFactory, andSetFactory)) {
                    InlineMarker.finallyEnd(1);
                    throw th2;
                }
                ExceptionsKt.addSuppressed(th, new IllegalStateException("WindowRecomposerFactory was set to unexpected value; cannot safely restore old state"));
                throw th;
            }
        }
    }
}
