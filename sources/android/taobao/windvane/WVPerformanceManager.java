package android.taobao.windvane;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVPerformanceManager {
    private static WVPerformanceManager instance;
    private WVPerformanceConfig config;

    public static WVPerformanceManager getInstance() {
        if (instance == null) {
            synchronized (WVPerformanceManager.class) {
                if (instance == null) {
                    instance = new WVPerformanceManager();
                }
            }
        }
        return instance;
    }

    public WVPerformanceConfig getConfig() {
        if (this.config == null) {
            this.config = new WVPerformanceConfig();
        }
        return this.config;
    }

    public void setConfig(WVPerformanceConfig wVPerformanceConfig) {
        this.config = wVPerformanceConfig;
    }
}
