package kotlinx.coroutines.flow;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.window.core.Version;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ExtensionInterfaceCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 &2\u00020\u0001:\u0005&'()*B\u001d\b\u0007\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b!\u0010\"B\u0011\b\u0016\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b!\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0017R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010 ¨\u0006+"}, d2 = {"Landroidx/window/layout/SidecarCompat;", "Landroidx/window/layout/ExtensionInterfaceCompat;", "Landroid/app/Activity;", "activity", "", "registerConfigurationChangeListener", "unregisterComponentCallback", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "extensionCallback", "setExtensionCallback", "Landroidx/window/layout/WindowLayoutInfo;", "getWindowLayoutInfo", "onWindowLayoutChangeListenerAdded", "Landroid/os/IBinder;", "windowToken", "register", "onWindowLayoutChangeListenerRemoved", "", "validateExtensionInterface", "Landroidx/window/sidecar/SidecarInterface;", "sidecar", "Landroidx/window/sidecar/SidecarInterface;", "getSidecar", "()Landroidx/window/sidecar/SidecarInterface;", "Landroidx/window/layout/SidecarAdapter;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "", "windowListenerRegisteredContexts", "Ljava/util/Map;", "Landroid/content/ComponentCallbacks;", "componentCallbackMap", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "<init>", "(Landroidx/window/sidecar/SidecarInterface;Landroidx/window/layout/SidecarAdapter;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "Companion", "DistinctElementCallback", "DistinctSidecarElementCallback", "FirstAttachAdapter", "TranslatingCallback", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SidecarCompat implements ExtensionInterfaceCompat {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "SidecarCompat";

    @NotNull
    private final Map<Activity, ComponentCallbacks> componentCallbackMap;

    @Nullable
    private ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback;

    @Nullable
    private final SidecarInterface sidecar;

    @NotNull
    private final SidecarAdapter sidecarAdapter;

    @NotNull
    private final Map<IBinder, Activity> windowListenerRegisteredContexts;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b8F@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/window/layout/SidecarCompat$Companion;", "", "Landroid/app/Activity;", "activity", "Landroid/os/IBinder;", "getActivityWindowToken$window_release", "(Landroid/app/Activity;)Landroid/os/IBinder;", "getActivityWindowToken", "Landroidx/window/core/Version;", "getSidecarVersion", "()Landroidx/window/core/Version;", "sidecarVersion", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "window_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final IBinder getActivityWindowToken$window_release(@Nullable Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        @Nullable
        public final Version getSidecarVersion() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return Version.INSTANCE.parse(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r8\u0002@\u0003X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctElementCallback;", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/WindowLayoutInfo;", "newLayout", "", "onWindowLayoutChanged", "callbackInterface", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/WeakHashMap;", "activityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "<init>", "(Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;)V", "window_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {

        @GuardedBy("mLock")
        @NotNull
        private final WeakHashMap<Activity, WindowLayoutInfo> activityWindowLayoutInfo;

        @NotNull
        private final ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface;

        @NotNull
        private final ReentrantLock lock;

        public DistinctElementCallback(@NotNull ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
            Intrinsics.checkNotNullParameter(extensionCallbackInterface, "callbackInterface");
            this.callbackInterface = extensionCallbackInterface;
            this.lock = new ReentrantLock();
            this.activityWindowLayoutInfo = new WeakHashMap<>();
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void onWindowLayoutChanged(@NotNull Activity activity, @NotNull WindowLayoutInfo newLayout) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(newLayout, "newLayout");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (Intrinsics.areEqual(newLayout, this.activityWindowLayoutInfo.get(activity))) {
                    return;
                }
                this.activityWindowLayoutInfo.put(activity, newLayout);
                reentrantLock.unlock();
                this.callbackInterface.onWindowLayoutChanged(activity, newLayout);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00158\u0002@\u0003X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctSidecarElementCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Landroidx/window/sidecar/SidecarDeviceState;", "newDeviceState", "", "onDeviceStateChanged", "Landroid/os/IBinder;", "token", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "newLayout", "onWindowLayoutChanged", "Landroidx/window/layout/SidecarAdapter;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "callbackInterface", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "lastDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "Ljava/util/WeakHashMap;", "mActivityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "<init>", "(Landroidx/window/layout/SidecarAdapter;Landroidx/window/sidecar/SidecarInterface$SidecarCallback;)V", "window_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {

        @NotNull
        private final SidecarInterface.SidecarCallback callbackInterface;

        @GuardedBy("lock")
        @Nullable
        private SidecarDeviceState lastDeviceState;

        @NotNull
        private final ReentrantLock lock;

        @GuardedBy("mLock")
        @NotNull
        private final WeakHashMap<IBinder, SidecarWindowLayoutInfo> mActivityWindowLayoutInfo;

        @NotNull
        private final SidecarAdapter sidecarAdapter;

        public DistinctSidecarElementCallback(@NotNull SidecarAdapter sidecarAdapter, @NotNull SidecarInterface.SidecarCallback sidecarCallback) {
            Intrinsics.checkNotNullParameter(sidecarAdapter, "sidecarAdapter");
            Intrinsics.checkNotNullParameter(sidecarCallback, "callbackInterface");
            this.sidecarAdapter = sidecarAdapter;
            this.callbackInterface = sidecarCallback;
            this.lock = new ReentrantLock();
            this.mActivityWindowLayoutInfo = new WeakHashMap<>();
        }

        public void onDeviceStateChanged(@NotNull SidecarDeviceState newDeviceState) {
            Intrinsics.checkNotNullParameter(newDeviceState, "newDeviceState");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.sidecarAdapter.isEqualSidecarDeviceState(this.lastDeviceState, newDeviceState)) {
                    return;
                }
                this.lastDeviceState = newDeviceState;
                this.callbackInterface.onDeviceStateChanged(newDeviceState);
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(@NotNull IBinder token, @NotNull SidecarWindowLayoutInfo newLayout) {
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(newLayout, "newLayout");
            synchronized (this.lock) {
                if (this.sidecarAdapter.isEqualSidecarWindowLayoutInfo(this.mActivityWindowLayoutInfo.get(token), newLayout)) {
                    return;
                }
                this.mActivityWindowLayoutInfo.put(token, newLayout);
                this.callbackInterface.onWindowLayoutChanged(token, newLayout);
            }
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR$\u0010\r\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Landroidx/window/layout/SidecarCompat$FirstAttachAdapter;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroidx/window/layout/SidecarCompat;", "sidecarCompat", "Landroidx/window/layout/SidecarCompat;", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "kotlin.jvm.PlatformType", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "activity", "<init>", "(Landroidx/window/layout/SidecarCompat;Landroid/app/Activity;)V", "window_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    private static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {

        @NotNull
        private final WeakReference<Activity> activityWeakReference;

        @NotNull
        private final SidecarCompat sidecarCompat;

        public FirstAttachAdapter(@NotNull SidecarCompat sidecarCompat, @NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(sidecarCompat, "sidecarCompat");
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.sidecarCompat = sidecarCompat;
            this.activityWeakReference = new WeakReference<>(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = this.activityWeakReference.get();
            IBinder activityWindowToken$window_release = SidecarCompat.INSTANCE.getActivityWindowToken$window_release(activity);
            if (activity == null || activityWindowToken$window_release == null) {
                return;
            }
            this.sidecarCompat.register(activityWindowToken$window_release, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0017¨\u0006\r"}, d2 = {"Landroidx/window/layout/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Landroidx/window/sidecar/SidecarDeviceState;", "newDeviceState", "", "onDeviceStateChanged", "Landroid/os/IBinder;", "windowToken", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "newLayout", "onWindowLayoutChanged", "<init>", "(Landroidx/window/layout/SidecarCompat;)V", "window_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        final /* synthetic */ SidecarCompat this$0;

        public TranslatingCallback(SidecarCompat sidecarCompat) {
            Intrinsics.checkNotNullParameter(sidecarCompat, "this$0");
            this.this$0 = sidecarCompat;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDeviceStateChanged(@NotNull SidecarDeviceState newDeviceState) {
            SidecarInterface sidecar;
            Intrinsics.checkNotNullParameter(newDeviceState, "newDeviceState");
            Collection<Activity> values = this.this$0.windowListenerRegisteredContexts.values();
            SidecarCompat sidecarCompat = this.this$0;
            for (Activity activity : values) {
                IBinder activityWindowToken$window_release = SidecarCompat.INSTANCE.getActivityWindowToken$window_release(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (activityWindowToken$window_release != null && (sidecar = sidecarCompat.getSidecar()) != null) {
                    sidecarWindowLayoutInfo = sidecar.getWindowLayoutInfo(activityWindowToken$window_release);
                }
                ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = sidecarCompat.extensionCallback;
                if (extensionCallbackInterface != null) {
                    extensionCallbackInterface.onWindowLayoutChanged(activity, sidecarCompat.sidecarAdapter.translate(sidecarWindowLayoutInfo, newDeviceState));
                }
            }
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(@NotNull IBinder windowToken, @NotNull SidecarWindowLayoutInfo newLayout) {
            Intrinsics.checkNotNullParameter(windowToken, "windowToken");
            Intrinsics.checkNotNullParameter(newLayout, "newLayout");
            Activity activity = (Activity) this.this$0.windowListenerRegisteredContexts.get(windowToken);
            if (activity == null) {
                Log.w(SidecarCompat.TAG, "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter sidecarAdapter = this.this$0.sidecarAdapter;
            SidecarInterface sidecar = this.this$0.getSidecar();
            SidecarDeviceState deviceState = sidecar == null ? null : sidecar.getDeviceState();
            if (deviceState == null) {
                deviceState = new SidecarDeviceState();
            }
            WindowLayoutInfo translate = sidecarAdapter.translate(newLayout, deviceState);
            ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.this$0.extensionCallback;
            if (extensionCallbackInterface == null) {
                return;
            }
            extensionCallbackInterface.onWindowLayoutChanged(activity, translate);
        }
    }

    @VisibleForTesting
    public SidecarCompat(@VisibleForTesting @Nullable SidecarInterface sidecarInterface, @NotNull SidecarAdapter sidecarAdapter) {
        Intrinsics.checkNotNullParameter(sidecarAdapter, "sidecarAdapter");
        this.sidecar = sidecarInterface;
        this.sidecarAdapter = sidecarAdapter;
        this.windowListenerRegisteredContexts = new LinkedHashMap();
        this.componentCallbackMap = new LinkedHashMap();
    }

    private final void registerConfigurationChangeListener(final Activity activity) {
        if (this.componentCallbackMap.get(activity) == null) {
            ComponentCallbacks componentCallbacks = new ComponentCallbacks() { // from class: androidx.window.layout.SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(@NotNull Configuration newConfig) {
                    Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                    ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = SidecarCompat.this.extensionCallback;
                    if (extensionCallbackInterface == null) {
                        return;
                    }
                    Activity activity2 = activity;
                    extensionCallbackInterface.onWindowLayoutChanged(activity2, SidecarCompat.this.getWindowLayoutInfo(activity2));
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                }
            };
            this.componentCallbackMap.put(activity, componentCallbacks);
            activity.registerComponentCallbacks(componentCallbacks);
        }
    }

    private final void unregisterComponentCallback(Activity activity) {
        activity.unregisterComponentCallbacks(this.componentCallbackMap.get(activity));
        this.componentCallbackMap.remove(activity);
    }

    @Nullable
    public final SidecarInterface getSidecar() {
        return this.sidecar;
    }

    @VisibleForTesting
    @NotNull
    public final WindowLayoutInfo getWindowLayoutInfo(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder activityWindowToken$window_release = INSTANCE.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release == null) {
            return new WindowLayoutInfo(CollectionsKt.emptyList());
        }
        SidecarInterface sidecarInterface = this.sidecar;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface == null ? null : sidecarInterface.getWindowLayoutInfo(activityWindowToken$window_release);
        SidecarAdapter sidecarAdapter = this.sidecarAdapter;
        SidecarInterface sidecarInterface2 = this.sidecar;
        SidecarDeviceState deviceState = sidecarInterface2 != null ? sidecarInterface2.getDeviceState() : null;
        if (deviceState == null) {
            deviceState = new SidecarDeviceState();
        }
        return sidecarAdapter.translate(windowLayoutInfo, deviceState);
    }

    @Override // kotlinx.coroutines.flow.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerAdded(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder activityWindowToken$window_release = INSTANCE.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release != null) {
            register(activityWindowToken$window_release, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
        }
    }

    @Override // kotlinx.coroutines.flow.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerRemoved(@NotNull Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder activityWindowToken$window_release = INSTANCE.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(activityWindowToken$window_release);
        }
        unregisterComponentCallback(activity);
        boolean z = this.windowListenerRegisteredContexts.size() == 1;
        this.windowListenerRegisteredContexts.remove(activityWindowToken$window_release);
        if (!z || (sidecarInterface = this.sidecar) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    public final void register(@NotNull IBinder windowToken, @NotNull Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.checkNotNullParameter(windowToken, "windowToken");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.windowListenerRegisteredContexts.put(windowToken, activity);
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(windowToken);
        }
        if (this.windowListenerRegisteredContexts.size() == 1 && (sidecarInterface = this.sidecar) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.extensionCallback;
        if (extensionCallbackInterface != null) {
            extensionCallbackInterface.onWindowLayoutChanged(activity, getWindowLayoutInfo(activity));
        }
        registerConfigurationChangeListener(activity);
    }

    @Override // kotlinx.coroutines.flow.ExtensionInterfaceCompat
    public void setExtensionCallback(@NotNull ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback) {
        Intrinsics.checkNotNullParameter(extensionCallback, "extensionCallback");
        this.extensionCallback = new DistinctElementCallback(extensionCallback);
        SidecarInterface sidecarInterface = this.sidecar;
        if (sidecarInterface == null) {
            return;
        }
        sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.sidecarAdapter, new TranslatingCallback(this)));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d A[Catch: all -> 0x019d, TryCatch #2 {all -> 0x019d, blocks: (B:3:0x0002, B:8:0x0025, B:10:0x002d, B:13:0x0035, B:16:0x003d, B:21:0x005e, B:23:0x0066, B:28:0x0087, B:30:0x008f, B:35:0x00af, B:37:0x00b7, B:40:0x00bd, B:41:0x00f4, B:43:0x0110, B:47:0x0114, B:49:0x0144, B:53:0x014d, B:54:0x0154, B:55:0x0155, B:56:0x015c, B:58:0x00c0, B:60:0x00ec, B:62:0x015d, B:63:0x0164, B:64:0x0165, B:65:0x016c, B:66:0x016d, B:67:0x0178, B:68:0x00ab, B:69:0x0095, B:72:0x009c, B:73:0x0179, B:74:0x0184, B:75:0x0083, B:76:0x006c, B:79:0x0073, B:80:0x0185, B:81:0x0190, B:82:0x005a, B:83:0x0043, B:86:0x004a, B:87:0x003a, B:88:0x0032, B:89:0x0191, B:90:0x019c, B:91:0x0021, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[Catch: all -> 0x019d, TryCatch #2 {all -> 0x019d, blocks: (B:3:0x0002, B:8:0x0025, B:10:0x002d, B:13:0x0035, B:16:0x003d, B:21:0x005e, B:23:0x0066, B:28:0x0087, B:30:0x008f, B:35:0x00af, B:37:0x00b7, B:40:0x00bd, B:41:0x00f4, B:43:0x0110, B:47:0x0114, B:49:0x0144, B:53:0x014d, B:54:0x0154, B:55:0x0155, B:56:0x015c, B:58:0x00c0, B:60:0x00ec, B:62:0x015d, B:63:0x0164, B:64:0x0165, B:65:0x016c, B:66:0x016d, B:67:0x0178, B:68:0x00ab, B:69:0x0095, B:72:0x009c, B:73:0x0179, B:74:0x0184, B:75:0x0083, B:76:0x006c, B:79:0x0073, B:80:0x0185, B:81:0x0190, B:82:0x005a, B:83:0x0043, B:86:0x004a, B:87:0x003a, B:88:0x0032, B:89:0x0191, B:90:0x019c, B:91:0x0021, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008f A[Catch: all -> 0x019d, TryCatch #2 {all -> 0x019d, blocks: (B:3:0x0002, B:8:0x0025, B:10:0x002d, B:13:0x0035, B:16:0x003d, B:21:0x005e, B:23:0x0066, B:28:0x0087, B:30:0x008f, B:35:0x00af, B:37:0x00b7, B:40:0x00bd, B:41:0x00f4, B:43:0x0110, B:47:0x0114, B:49:0x0144, B:53:0x014d, B:54:0x0154, B:55:0x0155, B:56:0x015c, B:58:0x00c0, B:60:0x00ec, B:62:0x015d, B:63:0x0164, B:64:0x0165, B:65:0x016c, B:66:0x016d, B:67:0x0178, B:68:0x00ab, B:69:0x0095, B:72:0x009c, B:73:0x0179, B:74:0x0184, B:75:0x0083, B:76:0x006c, B:79:0x0073, B:80:0x0185, B:81:0x0190, B:82:0x005a, B:83:0x0043, B:86:0x004a, B:87:0x003a, B:88:0x0032, B:89:0x0191, B:90:0x019c, B:91:0x0021, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7 A[Catch: all -> 0x019d, TRY_LEAVE, TryCatch #2 {all -> 0x019d, blocks: (B:3:0x0002, B:8:0x0025, B:10:0x002d, B:13:0x0035, B:16:0x003d, B:21:0x005e, B:23:0x0066, B:28:0x0087, B:30:0x008f, B:35:0x00af, B:37:0x00b7, B:40:0x00bd, B:41:0x00f4, B:43:0x0110, B:47:0x0114, B:49:0x0144, B:53:0x014d, B:54:0x0154, B:55:0x0155, B:56:0x015c, B:58:0x00c0, B:60:0x00ec, B:62:0x015d, B:63:0x0164, B:64:0x0165, B:65:0x016c, B:66:0x016d, B:67:0x0178, B:68:0x00ab, B:69:0x0095, B:72:0x009c, B:73:0x0179, B:74:0x0184, B:75:0x0083, B:76:0x006c, B:79:0x0073, B:80:0x0185, B:81:0x0190, B:82:0x005a, B:83:0x0043, B:86:0x004a, B:87:0x003a, B:88:0x0032, B:89:0x0191, B:90:0x019c, B:91:0x0021, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016d A[Catch: all -> 0x019d, TryCatch #2 {all -> 0x019d, blocks: (B:3:0x0002, B:8:0x0025, B:10:0x002d, B:13:0x0035, B:16:0x003d, B:21:0x005e, B:23:0x0066, B:28:0x0087, B:30:0x008f, B:35:0x00af, B:37:0x00b7, B:40:0x00bd, B:41:0x00f4, B:43:0x0110, B:47:0x0114, B:49:0x0144, B:53:0x014d, B:54:0x0154, B:55:0x0155, B:56:0x015c, B:58:0x00c0, B:60:0x00ec, B:62:0x015d, B:63:0x0164, B:64:0x0165, B:65:0x016c, B:66:0x016d, B:67:0x0178, B:68:0x00ab, B:69:0x0095, B:72:0x009c, B:73:0x0179, B:74:0x0184, B:75:0x0083, B:76:0x006c, B:79:0x0073, B:80:0x0185, B:81:0x0190, B:82:0x005a, B:83:0x0043, B:86:0x004a, B:87:0x003a, B:88:0x0032, B:89:0x0191, B:90:0x019c, B:91:0x0021, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ab A[Catch: all -> 0x019d, TryCatch #2 {all -> 0x019d, blocks: (B:3:0x0002, B:8:0x0025, B:10:0x002d, B:13:0x0035, B:16:0x003d, B:21:0x005e, B:23:0x0066, B:28:0x0087, B:30:0x008f, B:35:0x00af, B:37:0x00b7, B:40:0x00bd, B:41:0x00f4, B:43:0x0110, B:47:0x0114, B:49:0x0144, B:53:0x014d, B:54:0x0154, B:55:0x0155, B:56:0x015c, B:58:0x00c0, B:60:0x00ec, B:62:0x015d, B:63:0x0164, B:64:0x0165, B:65:0x016c, B:66:0x016d, B:67:0x0178, B:68:0x00ab, B:69:0x0095, B:72:0x009c, B:73:0x0179, B:74:0x0184, B:75:0x0083, B:76:0x006c, B:79:0x0073, B:80:0x0185, B:81:0x0190, B:82:0x005a, B:83:0x0043, B:86:0x004a, B:87:0x003a, B:88:0x0032, B:89:0x0191, B:90:0x019c, B:91:0x0021, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0179 A[Catch: all -> 0x019d, TryCatch #2 {all -> 0x019d, blocks: (B:3:0x0002, B:8:0x0025, B:10:0x002d, B:13:0x0035, B:16:0x003d, B:21:0x005e, B:23:0x0066, B:28:0x0087, B:30:0x008f, B:35:0x00af, B:37:0x00b7, B:40:0x00bd, B:41:0x00f4, B:43:0x0110, B:47:0x0114, B:49:0x0144, B:53:0x014d, B:54:0x0154, B:55:0x0155, B:56:0x015c, B:58:0x00c0, B:60:0x00ec, B:62:0x015d, B:63:0x0164, B:64:0x0165, B:65:0x016c, B:66:0x016d, B:67:0x0178, B:68:0x00ab, B:69:0x0095, B:72:0x009c, B:73:0x0179, B:74:0x0184, B:75:0x0083, B:76:0x006c, B:79:0x0073, B:80:0x0185, B:81:0x0190, B:82:0x005a, B:83:0x0043, B:86:0x004a, B:87:0x003a, B:88:0x0032, B:89:0x0191, B:90:0x019c, B:91:0x0021, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0083 A[Catch: all -> 0x019d, TryCatch #2 {all -> 0x019d, blocks: (B:3:0x0002, B:8:0x0025, B:10:0x002d, B:13:0x0035, B:16:0x003d, B:21:0x005e, B:23:0x0066, B:28:0x0087, B:30:0x008f, B:35:0x00af, B:37:0x00b7, B:40:0x00bd, B:41:0x00f4, B:43:0x0110, B:47:0x0114, B:49:0x0144, B:53:0x014d, B:54:0x0154, B:55:0x0155, B:56:0x015c, B:58:0x00c0, B:60:0x00ec, B:62:0x015d, B:63:0x0164, B:64:0x0165, B:65:0x016c, B:66:0x016d, B:67:0x0178, B:68:0x00ab, B:69:0x0095, B:72:0x009c, B:73:0x0179, B:74:0x0184, B:75:0x0083, B:76:0x006c, B:79:0x0073, B:80:0x0185, B:81:0x0190, B:82:0x005a, B:83:0x0043, B:86:0x004a, B:87:0x003a, B:88:0x0032, B:89:0x0191, B:90:0x019c, B:91:0x0021, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0185 A[Catch: all -> 0x019d, TryCatch #2 {all -> 0x019d, blocks: (B:3:0x0002, B:8:0x0025, B:10:0x002d, B:13:0x0035, B:16:0x003d, B:21:0x005e, B:23:0x0066, B:28:0x0087, B:30:0x008f, B:35:0x00af, B:37:0x00b7, B:40:0x00bd, B:41:0x00f4, B:43:0x0110, B:47:0x0114, B:49:0x0144, B:53:0x014d, B:54:0x0154, B:55:0x0155, B:56:0x015c, B:58:0x00c0, B:60:0x00ec, B:62:0x015d, B:63:0x0164, B:64:0x0165, B:65:0x016c, B:66:0x016d, B:67:0x0178, B:68:0x00ab, B:69:0x0095, B:72:0x009c, B:73:0x0179, B:74:0x0184, B:75:0x0083, B:76:0x006c, B:79:0x0073, B:80:0x0185, B:81:0x0190, B:82:0x005a, B:83:0x0043, B:86:0x004a, B:87:0x003a, B:88:0x0032, B:89:0x0191, B:90:0x019c, B:91:0x0021, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x005a A[Catch: all -> 0x019d, TryCatch #2 {all -> 0x019d, blocks: (B:3:0x0002, B:8:0x0025, B:10:0x002d, B:13:0x0035, B:16:0x003d, B:21:0x005e, B:23:0x0066, B:28:0x0087, B:30:0x008f, B:35:0x00af, B:37:0x00b7, B:40:0x00bd, B:41:0x00f4, B:43:0x0110, B:47:0x0114, B:49:0x0144, B:53:0x014d, B:54:0x0154, B:55:0x0155, B:56:0x015c, B:58:0x00c0, B:60:0x00ec, B:62:0x015d, B:63:0x0164, B:64:0x0165, B:65:0x016c, B:66:0x016d, B:67:0x0178, B:68:0x00ab, B:69:0x0095, B:72:0x009c, B:73:0x0179, B:74:0x0184, B:75:0x0083, B:76:0x006c, B:79:0x0073, B:80:0x0185, B:81:0x0190, B:82:0x005a, B:83:0x0043, B:86:0x004a, B:87:0x003a, B:88:0x0032, B:89:0x0191, B:90:0x019c, B:91:0x0021, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0191 A[Catch: all -> 0x019d, TryCatch #2 {all -> 0x019d, blocks: (B:3:0x0002, B:8:0x0025, B:10:0x002d, B:13:0x0035, B:16:0x003d, B:21:0x005e, B:23:0x0066, B:28:0x0087, B:30:0x008f, B:35:0x00af, B:37:0x00b7, B:40:0x00bd, B:41:0x00f4, B:43:0x0110, B:47:0x0114, B:49:0x0144, B:53:0x014d, B:54:0x0154, B:55:0x0155, B:56:0x015c, B:58:0x00c0, B:60:0x00ec, B:62:0x015d, B:63:0x0164, B:64:0x0165, B:65:0x016c, B:66:0x016d, B:67:0x0178, B:68:0x00ab, B:69:0x0095, B:72:0x009c, B:73:0x0179, B:74:0x0184, B:75:0x0083, B:76:0x006c, B:79:0x0073, B:80:0x0185, B:81:0x0190, B:82:0x005a, B:83:0x0043, B:86:0x004a, B:87:0x003a, B:88:0x0032, B:89:0x0191, B:90:0x019c, B:91:0x0021, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0021 A[Catch: all -> 0x019d, TryCatch #2 {all -> 0x019d, blocks: (B:3:0x0002, B:8:0x0025, B:10:0x002d, B:13:0x0035, B:16:0x003d, B:21:0x005e, B:23:0x0066, B:28:0x0087, B:30:0x008f, B:35:0x00af, B:37:0x00b7, B:40:0x00bd, B:41:0x00f4, B:43:0x0110, B:47:0x0114, B:49:0x0144, B:53:0x014d, B:54:0x0154, B:55:0x0155, B:56:0x015c, B:58:0x00c0, B:60:0x00ec, B:62:0x015d, B:63:0x0164, B:64:0x0165, B:65:0x016c, B:66:0x016d, B:67:0x0178, B:68:0x00ab, B:69:0x0095, B:72:0x009c, B:73:0x0179, B:74:0x0184, B:75:0x0083, B:76:0x006c, B:79:0x0073, B:80:0x0185, B:81:0x0190, B:82:0x005a, B:83:0x0043, B:86:0x004a, B:87:0x003a, B:88:0x0032, B:89:0x0191, B:90:0x019c, B:91:0x0021, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    @Override // kotlinx.coroutines.flow.ExtensionInterfaceCompat
    @android.annotation.SuppressLint({"BanUncheckedReflection"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean validateExtensionInterface() {
        /*
            Method dump skipped, instructions count: 415
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SidecarCompat.validateExtensionInterface():boolean");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(@NotNull Context context) {
        this(SidecarProvider.getSidecarImpl(context.getApplicationContext()), new SidecarAdapter());
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
