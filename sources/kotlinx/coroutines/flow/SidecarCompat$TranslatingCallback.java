package kotlinx.coroutines.flow;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.IBinder;
import android.util.Log;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ExtensionInterfaceCompat;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0017¨\u0006\r"}, d2 = {"Landroidx/window/layout/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Landroidx/window/sidecar/SidecarDeviceState;", "newDeviceState", "", "onDeviceStateChanged", "Landroid/os/IBinder;", "windowToken", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "newLayout", "onWindowLayoutChanged", "<init>", "(Landroidx/window/layout/SidecarCompat;)V", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SidecarCompat$TranslatingCallback implements SidecarInterface.SidecarCallback {
    final /* synthetic */ SidecarCompat this$0;

    public SidecarCompat$TranslatingCallback(SidecarCompat sidecarCompat) {
        Intrinsics.checkNotNullParameter(sidecarCompat, "this$0");
        this.this$0 = sidecarCompat;
    }

    @SuppressLint({"SyntheticAccessor"})
    public void onDeviceStateChanged(@NotNull SidecarDeviceState newDeviceState) {
        SidecarInterface sidecar;
        Intrinsics.checkNotNullParameter(newDeviceState, "newDeviceState");
        Collection<Activity> values = SidecarCompat.access$getWindowListenerRegisteredContexts$p(this.this$0).values();
        SidecarCompat sidecarCompat = this.this$0;
        for (Activity activity : values) {
            IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
            SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
            if (activityWindowToken$window_release != null && (sidecar = sidecarCompat.getSidecar()) != null) {
                sidecarWindowLayoutInfo = sidecar.getWindowLayoutInfo(activityWindowToken$window_release);
            }
            ExtensionInterfaceCompat.ExtensionCallbackInterface access$getExtensionCallback$p = SidecarCompat.access$getExtensionCallback$p(sidecarCompat);
            if (access$getExtensionCallback$p != null) {
                access$getExtensionCallback$p.onWindowLayoutChanged(activity, SidecarCompat.access$getSidecarAdapter$p(sidecarCompat).translate(sidecarWindowLayoutInfo, newDeviceState));
            }
        }
    }

    @SuppressLint({"SyntheticAccessor"})
    public void onWindowLayoutChanged(@NotNull IBinder windowToken, @NotNull SidecarWindowLayoutInfo newLayout) {
        Intrinsics.checkNotNullParameter(windowToken, "windowToken");
        Intrinsics.checkNotNullParameter(newLayout, "newLayout");
        Activity activity = (Activity) SidecarCompat.access$getWindowListenerRegisteredContexts$p(this.this$0).get(windowToken);
        if (activity == null) {
            Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
            return;
        }
        SidecarAdapter access$getSidecarAdapter$p = SidecarCompat.access$getSidecarAdapter$p(this.this$0);
        SidecarInterface sidecar = this.this$0.getSidecar();
        SidecarDeviceState deviceState = sidecar == null ? null : sidecar.getDeviceState();
        if (deviceState == null) {
            deviceState = new SidecarDeviceState();
        }
        WindowLayoutInfo translate = access$getSidecarAdapter$p.translate(newLayout, deviceState);
        ExtensionInterfaceCompat.ExtensionCallbackInterface access$getExtensionCallback$p = SidecarCompat.access$getExtensionCallback$p(this.this$0);
        if (access$getExtensionCallback$p == null) {
            return;
        }
        access$getExtensionCallback$p.onWindowLayoutChanged(activity, translate);
    }
}
