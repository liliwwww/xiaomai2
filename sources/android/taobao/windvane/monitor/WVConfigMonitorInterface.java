package android.taobao.windvane.monitor;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface WVConfigMonitorInterface {
    void didOccurUpdateConfigError(String str, int i, String str2);

    void didOccurUpdateConfigSuccess(String str);

    void didUpdateConfig(String str, int i, long j, int i2, int i3);
}
