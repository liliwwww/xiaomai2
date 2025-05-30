package kotlinx.coroutines.flow;

import android.app.Activity;
import androidx.annotation.GuardedBy;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ExtensionInterfaceCompat;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r8\u0002@\u0003X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctElementCallback;", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "Landroid/app/Activity;", "activity", "Landroidx/window/layout/WindowLayoutInfo;", "newLayout", "", "onWindowLayoutChanged", "callbackInterface", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/WeakHashMap;", "activityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "<init>", "(Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;)V", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SidecarCompat$DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {

    @GuardedBy("mLock")
    @NotNull
    private final WeakHashMap<Activity, WindowLayoutInfo> activityWindowLayoutInfo;

    @NotNull
    private final ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface;

    @NotNull
    private final ReentrantLock lock;

    public SidecarCompat$DistinctElementCallback(@NotNull ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface) {
        Intrinsics.checkNotNullParameter(extensionCallbackInterface, "callbackInterface");
        this.callbackInterface = extensionCallbackInterface;
        this.lock = new ReentrantLock();
        this.activityWindowLayoutInfo = new WeakHashMap<>();
    }

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
