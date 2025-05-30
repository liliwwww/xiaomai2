package android.taobao.windvane.monitor;

import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVMonitorData {
    public String url;
    public boolean isInit = false;
    public long startTime = 0;
    public long init = 0;
    public String performanceInfo = "";
    public int wvAppMonitor = 1;
    public stat stat = new stat(this);
    public extra args = new extra(this);
    public String protocolType = "";

    /* compiled from: Taobao */
    public static class resStat {
        public long end;
        public int fromType;
        public WVPerformanceMonitorInterface$NetStat netStat;
        public long start;
        public int statusCode;
        public String via;
        public int verifyError = 0;
        public long verifyResTime = 0;
        public long verifyTime = 0;
        public long tcpTime = 0;
        public String protocolType = "";

        public Map<String, String> toUtMap() {
            WVPerformanceMonitorInterface$NetStat wVPerformanceMonitorInterface$NetStat = this.netStat;
            Map<String, String> hashMap = wVPerformanceMonitorInterface$NetStat == null ? new HashMap<>() : WVMonitorData.toUtMap(wVPerformanceMonitorInterface$NetStat);
            int i = this.statusCode;
            if (i > 0) {
                hashMap.put("statusCode", String.valueOf(i));
            }
            String str = this.via;
            if (str != null) {
                hashMap.put("via", str);
            }
            long j = this.start;
            if (j > 0) {
                hashMap.put("start", String.valueOf(j));
            }
            long j2 = this.end;
            if (j2 > 0) {
                hashMap.put("end", String.valueOf(j2));
            }
            hashMap.put("fromType", String.valueOf(this.fromType));
            hashMap.put("protocolType", this.protocolType);
            hashMap.put("tcpTime", String.valueOf(this.tcpTime));
            hashMap.put("verifyError", String.valueOf(this.verifyError));
            hashMap.put("verifyResTime", String.valueOf(this.verifyResTime));
            hashMap.put("verifyTime", String.valueOf(this.verifyTime));
            return hashMap;
        }
    }

    public static resStat createNewResStatInstance() {
        return new resStat();
    }

    public static ArrayList<String> toUtArray(WVPerformanceMonitorInterface$NetStat wVPerformanceMonitorInterface$NetStat) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, String> entry : toUtMap(wVPerformanceMonitorInterface$NetStat).entrySet()) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        return arrayList;
    }

    public static Map<String, String> toUtMap(WVPerformanceMonitorInterface$NetStat wVPerformanceMonitorInterface$NetStat) {
        HashMap hashMap = new HashMap();
        hashMap.put("net_dnsTime", String.valueOf(wVPerformanceMonitorInterface$NetStat.dnsTime));
        hashMap.put("net_isDNSTimeout", String.valueOf((int) wVPerformanceMonitorInterface$NetStat.isDNSTimeout));
        hashMap.put("net_oneWayTime", String.valueOf(wVPerformanceMonitorInterface$NetStat.oneWayTime));
        hashMap.put("net_tcpLinkDate", String.valueOf(wVPerformanceMonitorInterface$NetStat.tcpLinkDate));
        hashMap.put("net_waitTime", String.valueOf(wVPerformanceMonitorInterface$NetStat.waitTime));
        hashMap.put("net_postBodyTime", String.valueOf(wVPerformanceMonitorInterface$NetStat.postBodyTime));
        hashMap.put("net_firstDataTime", String.valueOf(wVPerformanceMonitorInterface$NetStat.firstDataTime));
        hashMap.put("net_serverRT", String.valueOf(wVPerformanceMonitorInterface$NetStat.serverRT));
        hashMap.put("net_totalSize", String.valueOf(wVPerformanceMonitorInterface$NetStat.totalSize));
        hashMap.put("net_recDataTime", String.valueOf(wVPerformanceMonitorInterface$NetStat.recDataTime));
        hashMap.put("net_isSSL", String.valueOf(wVPerformanceMonitorInterface$NetStat.isSSL));
        hashMap.put("net_dataSpeed", String.valueOf(wVPerformanceMonitorInterface$NetStat.dataSpeed));
        hashMap.put("net_spdy", String.valueOf(wVPerformanceMonitorInterface$NetStat.spdy));
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String[] toJsonStringDict() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("fromType=" + this.stat.fromType);
        if (!TextUtils.isEmpty(this.stat.appSeq)) {
            arrayList.add("PackageApp-Seq=" + this.stat.appSeq);
            arrayList.add("PackageApp-Version=" + this.stat.packageAppVersion);
            arrayList.add("PackageApp-Name=" + this.stat.packageAppName);
        }
        if (this.stat.onDomLoad > 0) {
            arrayList.add("domLoad=" + this.stat.onDomLoad);
        }
        if (((int) Math.ceil((Math.random() * 100.0d) + 0.5d)) <= WVMonitorConfigManager.getInstance().config.stat.resSample && !this.args.resStat.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry entry : this.args.resStat.entrySet()) {
                if (((resStat) entry.getValue()).end - ((resStat) entry.getValue()).start >= WVMonitorConfigManager.getInstance().config.stat.resTime) {
                    Map<String, String> utMap = ((resStat) entry.getValue()).toUtMap();
                    utMap.put("url", entry.getKey());
                    jSONArray.put(new JSONObject(utMap));
                }
            }
            arrayList.add("resStat=" + jSONArray.toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public HashMap<String, Object> toJsonStringMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("url", this.url);
        hashMap.put("loadTime", Long.valueOf(this.stat.onLoad));
        hashMap.put("isFinish", Integer.valueOf(this.stat.finish));
        hashMap.put("firstByte", Long.valueOf(this.stat.firstByteTime));
        hashMap.put("domLoad", Long.valueOf(this.stat.onDomLoad));
        hashMap.put("fromType", Integer.valueOf(this.stat.fromType));
        hashMap.put("matchCost", Long.valueOf(this.stat.matchCost));
        hashMap.put("statusCode", Integer.valueOf(this.args.statusCode));
        hashMap.put("packageappversion", this.stat.packageAppVersion);
        hashMap.put("packageAppName", this.stat.packageAppName);
        hashMap.put("verifyCacheSize", Integer.valueOf(this.stat.verifyCacheSize));
        hashMap.put("via", this.args.via);
        hashMap.put("verifyError", Integer.valueOf(this.stat.verifyError));
        hashMap.put("verifyResTime", Long.valueOf(this.stat.verifyResTime));
        hashMap.put("verifyTime", Long.valueOf(this.stat.verifyTime));
        hashMap.put("allVerifyTime", Long.valueOf(this.stat.allVerifyTime));
        WVPerformanceMonitorInterface$NetStat wVPerformanceMonitorInterface$NetStat = this.args.netStat;
        if (wVPerformanceMonitorInterface$NetStat != null) {
            hashMap.put("netStat", toUtArray(wVPerformanceMonitorInterface$NetStat));
        }
        if (!this.args.resStat.isEmpty() && ((int) Math.ceil((Math.random() * 100.0d) + 0.5d)) <= WVMonitorConfigManager.getInstance().config.stat.resSample) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : this.args.resStat.entrySet()) {
                if (((resStat) entry.getValue()).end - ((resStat) entry.getValue()).start > WVMonitorConfigManager.getInstance().config.stat.resTime) {
                    Map<String, String> utMap = ((resStat) entry.getValue()).toUtMap();
                    String str = (String) entry.getKey();
                    Uri parse = Uri.parse(str);
                    if (parse != null && parse.isHierarchical()) {
                        utMap.put("url", str);
                        arrayList.add(utMap);
                    }
                }
            }
            hashMap.put("resStat", arrayList);
        }
        return hashMap;
    }
}
