package androidx.profileinstaller;

import android.view.Choreographer;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
@RequiresApi(16)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ProfileInstallerInitializer$Choreographer16Impl {
    private ProfileInstallerInitializer$Choreographer16Impl() {
    }

    @DoNotInline
    public static void postFrameCallback(final Runnable runnable) {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.profileinstaller.a
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                runnable.run();
            }
        });
    }
}
