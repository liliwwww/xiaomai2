package android.taobao.windvane.extra.performance2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface WVPerformance {
    void end();

    void onResourceFinished(String str, int i);

    void onResourceReceivedStatusCode(String str, int i);

    void onResourceStarted(String str);

    void recordProperties(String str, Object obj);

    void recordStage(String str, long j);

    void recordStatistics(String str, long j);

    void start();
}
