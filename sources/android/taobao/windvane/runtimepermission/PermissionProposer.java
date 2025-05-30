package android.taobao.windvane.runtimepermission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PermissionProposer {
    private static PermissionRequestTask sCurrentPermissionRequestTask;

    public static synchronized PermissionRequestTask buildPermissionTask(Context context, String[] strArr) {
        PermissionRequestTask permissionRequestTask;
        synchronized (PermissionProposer.class) {
            if (context == null) {
                throw new NullPointerException("context can not be null");
            }
            if (strArr == null || strArr.length == 0) {
                throw new NullPointerException("permissions can not be null");
            }
            permissionRequestTask = new PermissionRequestTask();
            PermissionRequestTask.access$002(permissionRequestTask, context);
            PermissionRequestTask.access$102(permissionRequestTask, strArr);
        }
        return permissionRequestTask;
    }

    public static synchronized PermissionRequestTask buildSystemAlertPermissionTask(Activity activity) {
        PermissionRequestTask buildPermissionTask;
        synchronized (PermissionProposer.class) {
            buildPermissionTask = buildPermissionTask(activity, new String[]{"android.permission.SYSTEM_ALERT_WINDOW"});
        }
        return buildPermissionTask;
    }

    static void onActivityResult(int i, int i2, Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            PermissionRequestTask permissionRequestTask = sCurrentPermissionRequestTask;
            permissionRequestTask.onPermissionGranted(Settings.canDrawOverlays(permissionRequestTask.getContext()));
        }
        sCurrentPermissionRequestTask = null;
    }

    static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PermissionRequestTask permissionRequestTask = sCurrentPermissionRequestTask;
        if (permissionRequestTask != null) {
            permissionRequestTask.onPermissionGranted(verifyPermissions(iArr));
            sCurrentPermissionRequestTask = null;
        }
    }

    private static boolean verifyPermissions(int[] iArr) {
        if (iArr == null || iArr.length < 1) {
            return false;
        }
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
