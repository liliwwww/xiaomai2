package android.taobao.windvane.util;

import android.os.Environment;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class StorageMgr {
    public static final int ERROR = -1;

    public static boolean checkSDCard() {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            if (externalStorageState != null) {
                return externalStorageState.equals("mounted");
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
