package android.taobao.windvane.runtimepermission;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PermissionChecker {
    public static final String PERMISSION_ALLOW = "allow";
    public static final String PERMISSION_DENY = "deny";

    public static synchronized PermissionCheckTask buildPermissionTask(Context context, String[] strArr) {
        PermissionCheckTask permissionCheckTask;
        synchronized (PermissionChecker.class) {
            if (context == null) {
                throw new NullPointerException("context can not be null");
            }
            if (strArr == null || strArr.length == 0) {
                throw new NullPointerException("permissions can not be null");
            }
            permissionCheckTask = new PermissionCheckTask();
            PermissionCheckTask.access$002(permissionCheckTask, context);
            PermissionCheckTask.access$102(permissionCheckTask, strArr);
        }
        return permissionCheckTask;
    }

    public static Map<String, String> checkPermissions(Context context, String[] strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str, str.contains("permission") ? str : "android.permission." + str);
            }
        }
        HashMap hashMap2 = new HashMap();
        for (String str2 : hashMap.keySet()) {
            try {
                if (ContextCompat.checkSelfPermission(context, (String) hashMap.get(str2)) != 0) {
                    hashMap2.put(str2, PERMISSION_DENY);
                } else {
                    hashMap2.put(str2, PERMISSION_ALLOW);
                }
            } catch (Throwable unused) {
            }
        }
        return hashMap2;
    }
}
