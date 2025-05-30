package androidx.transition;

import android.view.View;
import android.view.WindowId;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(18)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class WindowIdApi18 implements WindowIdImpl {
    private final WindowId mWindowId;

    WindowIdApi18(@NonNull View view) {
        this.mWindowId = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof WindowIdApi18) && ((WindowIdApi18) obj).mWindowId.equals(this.mWindowId);
    }

    public int hashCode() {
        return this.mWindowId.hashCode();
    }
}
