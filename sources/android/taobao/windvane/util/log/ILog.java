package android.taobao.windvane.util.log;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface ILog {

    /* compiled from: Taobao */
    public enum LogLevelEnum {
        VERBOSE(0, ExifInterface.GPS_MEASUREMENT_INTERRUPTED),
        DEBUG(1, "D"),
        INFO(2, "I"),
        WARNING(3, ExifInterface.LONGITUDE_WEST),
        ERROR(4, ExifInterface.LONGITUDE_EAST);

        private int LogLevel;
        private String LogLevelName;

        LogLevelEnum(int i, String str) {
            this.LogLevelName = str;
            this.LogLevel = i;
        }

        public int getLogLevel() {
            return this.LogLevel;
        }

        public String getLogLevelName() {
            return this.LogLevelName;
        }
    }

    /* renamed from: d */
    void mo8d(String str, String str2);

    /* renamed from: d */
    void mo9d(String str, String str2, Throwable th);

    /* renamed from: e */
    void mo10e(String str, String str2);

    /* renamed from: e */
    void mo11e(String str, String str2, Throwable th);

    /* renamed from: i */
    void mo12i(String str, String str2);

    /* renamed from: i */
    void mo13i(String str, String str2, Throwable th);

    boolean isLogLevelEnabled(int i);

    void log(int i, String str, String str2);

    /* renamed from: v */
    void mo14v(String str, String str2);

    /* renamed from: v */
    void mo15v(String str, String str2, Throwable th);

    /* renamed from: w */
    void mo16w(String str, String str2);

    /* renamed from: w */
    void mo17w(String str, String str2, Throwable th);
}
