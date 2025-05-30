package android.taobao.windvane.packageapp.zipapp.utils;

import androidx.exifinterface.media.ExifInterface;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class InstantPerformanceData {
    public String appName;
    public long d_endTime;
    public long d_startTime;
    public boolean isSuccess;
    public String msg;
    public long t_endTime;
    public long t_startTime;
    public long task_wait;
    public String type;

    /* compiled from: Taobao */
    public enum LoadType {
        LOAD_OTHER_ERROR("-2", "OTHER_ERROR"),
        LOAD_FOR_FILE_NOT_FOUND("-1", "LOAD_FOR_FILE_NOT_FOUND"),
        LOAD_NORMAL("0", "ZCache-D"),
        LOAD_LOCAL("1", "ZCache"),
        LOAD_ERROR_VALIDITY(ExifInterface.GPS_MEASUREMENT_2D, "LOAD_ERROR_VALIDITY"),
        LOAD_BAD_RESOURCE(ExifInterface.GPS_MEASUREMENT_3D, "LOAD_BAD_RESOURCE");

        private String code;
        private String msg;

        LoadType(String str, String str2) {
            this.code = str;
            this.msg = str2;
        }

        public String getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }
}
