package android.taobao.windvane.runtimepermission;

import android.content.Context;
import android.taobao.windvane.jsbridge.IPermissionDeniedCallBack;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class PermissionChecker$PermissionCheckTask {
    private Context context;
    private IPermissionDeniedCallBack permissionDeniedCallBack;
    private Runnable permissionGrantedRunnable;
    private String[] permissions;

    public void execute() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.permissions) {
            try {
                if (ContextCompat.checkSelfPermission(this.context, str) != 0) {
                    arrayList.add(str);
                }
            } catch (Throwable unused) {
                this.permissionGrantedRunnable.run();
                return;
            }
        }
        if (arrayList.size() == 0) {
            this.permissionGrantedRunnable.run();
        } else {
            this.permissionDeniedCallBack.onPermissionDenied(arrayList);
        }
    }

    public PermissionChecker$PermissionCheckTask setTaskOnPermissionDenied(IPermissionDeniedCallBack iPermissionDeniedCallBack) {
        this.permissionDeniedCallBack = iPermissionDeniedCallBack;
        return this;
    }

    public PermissionChecker$PermissionCheckTask setTaskOnPermissionGranted(Runnable runnable) {
        Objects.requireNonNull(runnable, "permissionGrantedRunnable is null");
        this.permissionGrantedRunnable = runnable;
        return this;
    }
}
