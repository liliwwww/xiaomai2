package androidx.window.layout;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.IBinder;
import androidx.annotation.VisibleForTesting;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 &2\u00020\u0001:\u0005&'()*B\u001d\b\u0007\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b!\u0010\"B\u0011\b\u0016\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b!\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0017R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010 ¨\u0006+"}, d2 = {"Landroidx/window/layout/SidecarCompat;", "Landroidx/window/layout/ExtensionInterfaceCompat;", "Landroid/app/Activity;", "activity", "", "registerConfigurationChangeListener", "unregisterComponentCallback", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "extensionCallback", "setExtensionCallback", "Landroidx/window/layout/WindowLayoutInfo;", "getWindowLayoutInfo", "onWindowLayoutChangeListenerAdded", "Landroid/os/IBinder;", "windowToken", "register", "onWindowLayoutChangeListenerRemoved", "", "validateExtensionInterface", "Landroidx/window/sidecar/SidecarInterface;", "sidecar", "Landroidx/window/sidecar/SidecarInterface;", "getSidecar", "()Landroidx/window/sidecar/SidecarInterface;", "Landroidx/window/layout/SidecarAdapter;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "", "windowListenerRegisteredContexts", "Ljava/util/Map;", "Landroid/content/ComponentCallbacks;", "componentCallbackMap", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "<init>", "(Landroidx/window/sidecar/SidecarInterface;Landroidx/window/layout/SidecarAdapter;)V", "Landroid/content/Context;", "context", "(Landroid/content/Context;)V", "Companion", "DistinctElementCallback", "DistinctSidecarElementCallback", "FirstAttachAdapter", "TranslatingCallback", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SidecarCompat implements ExtensionInterfaceCompat {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @NotNull
    private static final String TAG = "SidecarCompat";

    @NotNull
    private final Map<Activity, ComponentCallbacks> componentCallbackMap;

    @Nullable
    private ExtensionInterfaceCompat$ExtensionCallbackInterface extensionCallback;

    @Nullable
    private final SidecarInterface sidecar;

    @NotNull
    private final SidecarAdapter sidecarAdapter;

    @NotNull
    private final Map<IBinder, Activity> windowListenerRegisteredContexts;

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
                    ExtensionInterfaceCompat$ExtensionCallbackInterface extensionInterfaceCompat$ExtensionCallbackInterface;
                    Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                    extensionInterfaceCompat$ExtensionCallbackInterface = SidecarCompat.this.extensionCallback;
                    if (extensionInterfaceCompat$ExtensionCallbackInterface == null) {
                        return;
                    }
                    Activity activity2 = activity;
                    extensionInterfaceCompat$ExtensionCallbackInterface.onWindowLayoutChanged(activity2, SidecarCompat.this.getWindowLayoutInfo(activity2));
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
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
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

    public void onWindowLayoutChangeListenerAdded(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release != null) {
            register(activityWindowToken$window_release, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
        }
    }

    public void onWindowLayoutChangeListenerRemoved(@NotNull Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.checkNotNullParameter(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
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
        ExtensionInterfaceCompat$ExtensionCallbackInterface extensionInterfaceCompat$ExtensionCallbackInterface = this.extensionCallback;
        if (extensionInterfaceCompat$ExtensionCallbackInterface != null) {
            extensionInterfaceCompat$ExtensionCallbackInterface.onWindowLayoutChanged(activity, getWindowLayoutInfo(activity));
        }
        registerConfigurationChangeListener(activity);
    }

    public void setExtensionCallback(@NotNull ExtensionInterfaceCompat$ExtensionCallbackInterface extensionCallback) {
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
    @android.annotation.SuppressLint({"BanUncheckedReflection"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean validateExtensionInterface() {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.validateExtensionInterface():boolean");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(@NotNull Context context) {
        this(SidecarProvider.getSidecarImpl(context.getApplicationContext()), new SidecarAdapter());
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
