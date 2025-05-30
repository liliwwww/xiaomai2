package android.taobao.windvane.log;

import android.text.TextUtils;
import com.taobao.tao.log.TTraceLog;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class TLogNewImpl implements IWMLog {
    private static boolean newTLogEnable = true;

    public static void setTLogEnable(boolean z) {
        newTLogEnable = newTLogEnable && z;
    }

    @Override // android.taobao.windvane.log.IWMLog
    public void writeLog(LogData logData) {
        if (newTLogEnable) {
            TTraceLog.event(logData.getUid(), logData.getPid(), logData.getModule(), logData.getTimestamp(), logData.getEvent(), logData.getErrorCode(), logData.getErrorMsg(), !TextUtils.isEmpty(logData.getExt()) ? logData.getExt() : "");
        }
    }
}
