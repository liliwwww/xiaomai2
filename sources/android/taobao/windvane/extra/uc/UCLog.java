package android.taobao.windvane.extra.uc;

import android.taobao.windvane.util.TaoLog;
import com.uc.webview.export.internal.interfaces.INetLogger;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class UCLog implements INetLogger {
    private static final int LEVEL_ERROR = 0;
    boolean mEnable = true;
    int level = 0;

    public void d(String str, String str2) {
        if ("cancel_log".equals(str)) {
            TaoLog.e("alinetwork", "cancel reason:" + str2);
        }
    }

    public void e(String str, String str2) {
        if ("cancel_log".equals(str)) {
            TaoLog.e("alinetwork", "cancel reason:" + str2);
        }
    }

    public boolean getEnable() {
        return this.mEnable;
    }

    public int getLogLevel() {
        return this.level;
    }

    public void i(String str, String str2) {
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void setLogLevel(int i) {
        this.level = i;
    }

    public void w(String str, String str2) {
    }
}
