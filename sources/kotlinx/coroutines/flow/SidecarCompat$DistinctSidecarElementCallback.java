package kotlinx.coroutines.flow;

import android.os.IBinder;
import androidx.annotation.GuardedBy;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00158\u0002@\u0003X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctSidecarElementCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Landroidx/window/sidecar/SidecarDeviceState;", "newDeviceState", "", "onDeviceStateChanged", "Landroid/os/IBinder;", "token", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "newLayout", "onWindowLayoutChanged", "Landroidx/window/layout/SidecarAdapter;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "callbackInterface", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "lastDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "Ljava/util/WeakHashMap;", "mActivityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "<init>", "(Landroidx/window/layout/SidecarAdapter;Landroidx/window/sidecar/SidecarInterface$SidecarCallback;)V", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SidecarCompat$DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {

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

    public SidecarCompat$DistinctSidecarElementCallback(@NotNull SidecarAdapter sidecarAdapter, @NotNull SidecarInterface.SidecarCallback sidecarCallback) {
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
