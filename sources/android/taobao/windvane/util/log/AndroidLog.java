package android.taobao.windvane.util.log;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AndroidLog implements ILog {
    @Override // android.taobao.windvane.util.log.ILog
    /* renamed from: d */
    public void mo8d(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    @Override // android.taobao.windvane.util.log.ILog
    /* renamed from: e */
    public void mo10e(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Log.e(str, str2);
    }

    @Override // android.taobao.windvane.util.log.ILog
    /* renamed from: i */
    public void mo12i(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Log.i(str, str2);
    }

    @Override // android.taobao.windvane.util.log.ILog
    public boolean isLogLevelEnabled(int i) {
        return true;
    }

    @Override // android.taobao.windvane.util.log.ILog
    public void log(int i, String str, String str2) {
        if (i == 2) {
            mo14v(str, str2);
            return;
        }
        if (i == 3) {
            mo8d(str, str2);
            return;
        }
        if (i == 4) {
            mo12i(str, str2);
            return;
        }
        if (i == 5) {
            mo16w(str, str2);
        } else if (i != 6) {
            mo14v(str, str2);
        } else {
            mo10e(str, str2);
        }
    }

    @Override // android.taobao.windvane.util.log.ILog
    /* renamed from: v */
    public void mo14v(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Log.v(str, str2);
    }

    @Override // android.taobao.windvane.util.log.ILog
    /* renamed from: w */
    public void mo16w(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Log.w(str, str2);
    }

    @Override // android.taobao.windvane.util.log.ILog
    /* renamed from: d */
    public void mo9d(String str, String str2, Throwable th) {
        if (str == null || str2 == null || th == null) {
            return;
        }
        Log.d(str, str2, th);
    }

    @Override // android.taobao.windvane.util.log.ILog
    /* renamed from: e */
    public void mo11e(String str, String str2, Throwable th) {
        if (str == null || str2 == null || th == null) {
            return;
        }
        Log.e(str, str2, th);
    }

    @Override // android.taobao.windvane.util.log.ILog
    /* renamed from: i */
    public void mo13i(String str, String str2, Throwable th) {
        if (str == null || str2 == null || th == null) {
            return;
        }
        Log.i(str, str2, th);
    }

    @Override // android.taobao.windvane.util.log.ILog
    /* renamed from: v */
    public void mo15v(String str, String str2, Throwable th) {
        if (str == null || str2 == null || th == null) {
            return;
        }
        Log.v(str, str2, th);
    }

    @Override // android.taobao.windvane.util.log.ILog
    /* renamed from: w */
    public void mo17w(String str, String str2, Throwable th) {
        if (str == null || str2 == null || th == null) {
            return;
        }
        Log.w(str, str2, th);
    }
}
