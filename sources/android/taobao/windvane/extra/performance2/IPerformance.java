package android.taobao.windvane.extra.performance2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface IPerformance {
    String getCachedUrl();

    WVPerformance getPerformanceDelegate();

    boolean isPreInit();

    boolean isReportedFSP();

    void receiveJSMessageForCustomizedFSP(long j);

    void receiveJSMessageForCustomizedStage(long j, String str);

    void receiveJSMessageForFP(long j);

    void receiveJSMessageForFSP(long j);

    void receiveJSMessageForTTI(long j);

    void setReportedFSP(boolean z);
}
