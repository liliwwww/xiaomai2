package android.taobao.windvane.monitor;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVMonitorConfig {
    public String v = "0";
    public StatRule stat = new StatRule(this);
    public boolean isErrorBlacklist = true;
    public List<ErrorRule> errorRule = new ArrayList();
    public double perfCheckSampleRate = 0.0d;
    public String perfCheckURL = "";

    public ErrorRule newErrorRuleInstance(String str, String str2, String str3) {
        ErrorRule errorRule = new ErrorRule(this);
        errorRule.url = str;
        errorRule.msg = str2;
        errorRule.code = str3;
        return errorRule;
    }
}
