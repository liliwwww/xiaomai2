package android.taobao.windvane.extra.p002uc;

import android.taobao.windvane.util.TaoLog;
import com.uc.webview.export.internal.interfaces.INetLogger;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class UCLog implements INetLogger {
    private static final int LEVEL_ERROR = 0;
    boolean mEnable = true;
    int level = 0;

    /* renamed from: d */
    public void m4d(String str, String str2) {
        if ("cancel_log".equals(str)) {
            TaoLog.m21e("alinetwork", "cancel reason:" + str2);
        }
    }

    /* renamed from: e */
    public void m5e(String str, String str2) {
        if ("cancel_log".equals(str)) {
            TaoLog.m21e("alinetwork", "cancel reason:" + str2);
        }
    }

    public boolean getEnable() {
        return this.mEnable;
    }

    public int getLogLevel() {
        return this.level;
    }

    /* renamed from: i */
    public void m6i(String str, String str2) {
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void setLogLevel(int i) {
        this.level = i;
    }

    /* renamed from: w */
    public void m7w(String str, String str2) {
    }
}
