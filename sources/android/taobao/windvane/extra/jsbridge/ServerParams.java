package android.taobao.windvane.extra.jsbridge;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ServerParams {
    public String api;
    private Map<String, String> data = new HashMap();
    public boolean ecode;
    public boolean isSec;
    public boolean post;

    /* renamed from: v */
    public String f10v;

    public void addData(String str, String str2) {
        this.data.put(str, str2);
    }

    public Map<String, String> getData() {
        return this.data;
    }
}
