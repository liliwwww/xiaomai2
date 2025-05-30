package android.taobao.windvane.runtimepermission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class PermissionProposer$PermissionRequestTask {
    private Context context;
    private String explain;
    private Runnable permissionDeniedRunnable;
    private Runnable permissionGrantedRunnable;
    private String[] permissions;

    private void destroy() {
        this.context = null;
        this.permissionGrantedRunnable = null;
        this.permissionDeniedRunnable = null;
    }

    public void execute() {
        int i = Build.VERSION.SDK_INT;
        if (i < 23) {
            if (i >= 18) {
                if (ContextCompat.checkSelfPermission(this.context, this.permissions[0]) == 0) {
                    this.permissionGrantedRunnable.run();
                    return;
                } else {
                    this.permissionDeniedRunnable.run();
                    return;
                }
            }
            try {
                this.permissionGrantedRunnable.run();
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        String[] strArr = this.permissions;
        if (strArr.length == 1 && strArr[0].equals("android.permission.SYSTEM_ALERT_WINDOW")) {
            if (Settings.canDrawOverlays(this.context)) {
                this.permissionGrantedRunnable.run();
                return;
            }
            Intent intent = new Intent();
            intent.setClass(this.context, PermissionActivity.class);
            intent.putExtra("permissions", this.permissions);
            PermissionProposer.access$202(this);
            this.context.startActivity(intent);
            return;
        }
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
            return;
        }
        Intent intent2 = new Intent();
        intent2.setClass(this.context, PermissionActivity.class);
        if (!(this.context instanceof Activity)) {
            intent2.addFlags(268435456);
        }
        intent2.putExtra("permissions", this.permissions);
        intent2.putExtra("explain", this.explain);
        PermissionProposer.access$202(this);
        this.context.startActivity(intent2);
    }

    public Context getContext() {
        return this.context;
    }

    void onPermissionGranted(boolean z) {
        if (z) {
            Runnable runnable = this.permissionGrantedRunnable;
            if (runnable != null) {
                runnable.run();
            }
        } else {
            Runnable runnable2 = this.permissionDeniedRunnable;
            if (runnable2 != null) {
                runnable2.run();
            }
        }
        destroy();
    }

    public PermissionProposer$PermissionRequestTask setRationalStr(String str) {
        this.explain = str;
        return this;
    }

    public PermissionProposer$PermissionRequestTask setTaskOnPermissionDenied(Runnable runnable) {
        this.permissionDeniedRunnable = runnable;
        return this;
    }

    public PermissionProposer$PermissionRequestTask setTaskOnPermissionGranted(Runnable runnable) {
        Objects.requireNonNull(runnable, "permissionGrantedRunnable is null");
        this.permissionGrantedRunnable = runnable;
        return this;
    }
}
