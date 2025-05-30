package androidx.core.content;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class UnusedAppRestrictionsBackportService$1 extends IUnusedAppRestrictionsBackportService.Stub {
    final /* synthetic */ UnusedAppRestrictionsBackportService this$0;

    UnusedAppRestrictionsBackportService$1(UnusedAppRestrictionsBackportService unusedAppRestrictionsBackportService) {
        this.this$0 = unusedAppRestrictionsBackportService;
    }

    public void isPermissionRevocationEnabledForApp(@Nullable IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException {
        if (iUnusedAppRestrictionsBackportCallback == null) {
            return;
        }
        this.this$0.isPermissionRevocationEnabled(new UnusedAppRestrictionsBackportCallback(iUnusedAppRestrictionsBackportCallback));
    }
}
