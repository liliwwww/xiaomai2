package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.view.ViewParent;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.R$id;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gs;
import tb.i80;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class WindowRecomposer_androidKt {

    @NotNull
    private static final Map<Context, StateFlow<Float>> animationScale = new LinkedHashMap();

    @ExperimentalComposeUiApi
    @NotNull
    public static final Recomposer createLifecycleAwareWindowRecomposer(@NotNull View view, @NotNull CoroutineContext coroutineContext, @Nullable Lifecycle lifecycle) {
        PausableMonotonicFrameClock pausableMonotonicFrameClock;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        if (coroutineContext.get(ContinuationInterceptor.Key) == null || coroutineContext.get(MonotonicFrameClock.Key) == null) {
            coroutineContext = AndroidUiDispatcher.Companion.getCurrentThread().plus(coroutineContext);
        }
        MonotonicFrameClock monotonicFrameClock = (MonotonicFrameClock) coroutineContext.get(MonotonicFrameClock.Key);
        if (monotonicFrameClock != null) {
            PausableMonotonicFrameClock pausableMonotonicFrameClock2 = new PausableMonotonicFrameClock(monotonicFrameClock);
            pausableMonotonicFrameClock2.pause();
            pausableMonotonicFrameClock = pausableMonotonicFrameClock2;
        } else {
            pausableMonotonicFrameClock = null;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        MotionDurationScaleImpl motionDurationScaleImpl = (MotionDurationScale) coroutineContext.get(MotionDurationScale.Key);
        if (motionDurationScaleImpl == null) {
            motionDurationScaleImpl = new MotionDurationScaleImpl();
            objectRef.element = motionDurationScaleImpl;
        }
        CoroutineContext plus = coroutineContext.plus(pausableMonotonicFrameClock != null ? pausableMonotonicFrameClock : EmptyCoroutineContext.INSTANCE).plus(motionDurationScaleImpl);
        Recomposer recomposer = new Recomposer(plus);
        CoroutineScope a = i80.a(plus);
        if (lifecycle == null) {
            LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(view);
            lifecycle = lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null;
        }
        if (lifecycle != null) {
            view.addOnAttachStateChangeListener(new createLifecycleAwareWindowRecomposer.1(view, recomposer));
            lifecycle.addObserver(new createLifecycleAwareWindowRecomposer.2(a, pausableMonotonicFrameClock, recomposer, objectRef, view));
            return recomposer;
        }
        throw new IllegalStateException(("ViewTreeLifecycleOwner not found from " + view).toString());
    }

    public static /* synthetic */ Recomposer createLifecycleAwareWindowRecomposer$default(View view, CoroutineContext coroutineContext, Lifecycle lifecycle, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            lifecycle = null;
        }
        return createLifecycleAwareWindowRecomposer(view, coroutineContext, lifecycle);
    }

    @Nullable
    public static final CompositionContext findViewTreeCompositionContext(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        CompositionContext compositionContext = getCompositionContext(view);
        if (compositionContext != null) {
            return compositionContext;
        }
        for (ViewParent parent = view.getParent(); compositionContext == null && (parent instanceof View); parent = parent.getParent()) {
            compositionContext = getCompositionContext((View) parent);
        }
        return compositionContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1] */
    public static final StateFlow<Float> getAnimationScaleFlowFor(Context context) {
        StateFlow<Float> stateFlow;
        Map<Context, StateFlow<Float>> map = animationScale;
        synchronized (map) {
            StateFlow<Float> stateFlow2 = map.get(context);
            if (stateFlow2 == null) {
                ContentResolver contentResolver = context.getContentResolver();
                Uri uriFor = Settings.Global.getUriFor("animator_duration_scale");
                final Channel b = gs.b(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
                final Handler createAsync = HandlerCompat.createAsync(Looper.getMainLooper());
                stateFlow2 = d.J(d.y(new getAnimationScaleFlowFor.1.1.1(contentResolver, uriFor, (WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1) new ContentObserver(createAsync) { // from class: androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z, @Nullable Uri uri) {
                        b.trySend-JP2dKIU(Unit.INSTANCE);
                    }
                }, b, context, (Continuation) null)), i80.b(), SharingStarted.a.b(SharingStarted.Companion, 0L, 0L, 3, (Object) null), Float.valueOf(Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f)));
                map.put(context, stateFlow2);
            }
            stateFlow = stateFlow2;
        }
        return stateFlow;
    }

    @Nullable
    public static final CompositionContext getCompositionContext(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(R$id.androidx_compose_ui_view_composition_context);
        if (tag instanceof CompositionContext) {
            return (CompositionContext) tag;
        }
        return null;
    }

    private static final View getContentChild(View view) {
        Object parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            if (view2.getId() == 16908290) {
                return view;
            }
            parent = view2.getParent();
            view = view2;
        }
        return view;
    }

    @NotNull
    public static final Recomposer getWindowRecomposer(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (!view.isAttachedToWindow()) {
            throw new IllegalStateException(("Cannot locate windowRecomposer; View " + view + " is not attached to a window").toString());
        }
        View contentChild = getContentChild(view);
        Recomposer compositionContext = getCompositionContext(contentChild);
        if (compositionContext == null) {
            return WindowRecomposerPolicy.INSTANCE.createAndInstallWindowRecomposer$ui_release(contentChild);
        }
        if (compositionContext instanceof Recomposer) {
            return compositionContext;
        }
        throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer".toString());
    }

    public static /* synthetic */ void getWindowRecomposer$annotations(View view) {
    }

    public static final void setCompositionContext(@NotNull View view, @Nullable CompositionContext compositionContext) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(R$id.androidx_compose_ui_view_composition_context, compositionContext);
    }
}
