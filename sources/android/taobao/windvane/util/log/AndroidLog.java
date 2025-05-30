package android.taobao.windvane.util.log;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class AndroidLog implements ILog {
    public void d(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    public void e(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Log.e(str, str2);
    }

    public void i(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Log.i(str, str2);
    }

    public boolean isLogLevelEnabled(int i) {
        return true;
    }

    public void log(int i, String str, String str2) {
        if (i == 2) {
            v(str, str2);
            return;
        }
        if (i == 3) {
            d(str, str2);
            return;
        }
        if (i == 4) {
            i(str, str2);
            return;
        }
        if (i == 5) {
            w(str, str2);
        } else if (i != 6) {
            v(str, str2);
        } else {
            e(str, str2);
        }
    }

    public void v(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Log.v(str, str2);
    }

    public void w(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Log.w(str, str2);
    }

    public void d(String str, String str2, Throwable th) {
        if (str == null || str2 == null || th == null) {
            return;
        }
        Log.d(str, str2, th);
    }

    public void e(String str, String str2, Throwable th) {
        if (str == null || str2 == null || th == null) {
            return;
        }
        Log.e(str, str2, th);
    }

    public void i(String str, String str2, Throwable th) {
        if (str == null || str2 == null || th == null) {
            return;
        }
        Log.i(str, str2, th);
    }

    public void v(String str, String str2, Throwable th) {
        if (str == null || str2 == null || th == null) {
            return;
        }
        Log.v(str, str2, th);
    }

    public void w(String str, String str2, Throwable th) {
        if (str == null || str2 == null || th == null) {
            return;
        }
        Log.w(str, str2, th);
    }
}
