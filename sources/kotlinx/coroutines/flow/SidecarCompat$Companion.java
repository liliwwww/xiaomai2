package kotlinx.coroutines.flow;

import android.app.Activity;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.Version;
import androidx.window.sidecar.SidecarProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b8F@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Landroidx/window/layout/SidecarCompat$Companion;", "", "Landroid/app/Activity;", "activity", "Landroid/os/IBinder;", "getActivityWindowToken$window_release", "(Landroid/app/Activity;)Landroid/os/IBinder;", "getActivityWindowToken", "Landroidx/window/core/Version;", "getSidecarVersion", "()Landroidx/window/core/Version;", "sidecarVersion", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "window_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SidecarCompat$Companion {
    private SidecarCompat$Companion() {
    }

    public /* synthetic */ SidecarCompat$Companion(DefaultConstructorMarker defaultConstructorMarker) {
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
            return Version.Companion.parse(apiVersion);
        } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
            return null;
        }
    }
}
