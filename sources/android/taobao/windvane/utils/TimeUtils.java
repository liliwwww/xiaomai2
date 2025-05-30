package android.taobao.windvane.utils;

import android.os.SystemClock;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TimeUtils {
    public static long generateUptimeFromCurrentTime(long j) {
        if (j > 0) {
            return (SystemClock.uptimeMillis() - System.currentTimeMillis()) + j;
        }
        return 0L;
    }
}
