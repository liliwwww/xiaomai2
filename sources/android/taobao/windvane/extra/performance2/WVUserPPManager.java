package android.taobao.windvane.extra.performance2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVUserPPManager {

    /* renamed from: FP */
    private long f11FP;
    private long TTI;

    public String jsCodeForUserPP() {
        return "javascript:(function(){var observer=new PerformanceObserver(function(list,obj){for(var entry of list.getEntries()){if(entry.entryType=='paint'&&entry.name=='first-paint'){console.log('hybrid://WVPerformance:FP/receiveFPTime?{\"time\":'+entry.startTime+'}')}if(entry.entryType=='longtask'){console.log('hybrid://WVPerformance:TTI/receiveTTITime?{\"time\":'+(entry.startTime+entry.duration)+'}')}}});observer.observe({entryTypes:['longtask','paint']})})()";
    }
}
