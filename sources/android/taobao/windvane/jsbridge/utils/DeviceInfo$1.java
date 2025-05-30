package android.taobao.windvane.jsbridge.utils;

import java.io.File;
import java.io.FileFilter;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class DeviceInfo$1 implements FileFilter {
    DeviceInfo$1() {
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String name = file.getName();
        if (!name.startsWith("cpu")) {
            return false;
        }
        for (int i = 3; i < name.length(); i++) {
            if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
