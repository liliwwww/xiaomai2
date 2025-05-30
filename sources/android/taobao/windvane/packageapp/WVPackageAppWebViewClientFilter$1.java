package android.taobao.windvane.packageapp;

import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.packageapp.zipapp.utils.ZCacheResourceWrapper;
import com.taobao.zcache.ResourceResponse;
import com.taobao.zcache.ResourceResponseCallback;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class WVPackageAppWebViewClientFilter$1 implements ResourceResponseCallback {
    final /* synthetic */ WVPackageAppWebViewClientFilter this$0;
    final /* synthetic */ CountDownLatch val$cdl;
    final /* synthetic */ long val$startGetZCacheResourceTime;
    final /* synthetic */ ZCacheResourceWrapper val$zCacheResourceWrapper;

    WVPackageAppWebViewClientFilter$1(WVPackageAppWebViewClientFilter wVPackageAppWebViewClientFilter, ZCacheResourceWrapper zCacheResourceWrapper, CountDownLatch countDownLatch, long j) {
        this.this$0 = wVPackageAppWebViewClientFilter;
        this.val$zCacheResourceWrapper = zCacheResourceWrapper;
        this.val$cdl = countDownLatch;
        this.val$startGetZCacheResourceTime = j;
    }

    public void finish(ResourceResponse resourceResponse) {
        try {
            this.val$zCacheResourceWrapper.wrapZCacheResourceResponse(resourceResponse);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.val$cdl.countDown();
        long currentTimeMillis = System.currentTimeMillis() - this.val$startGetZCacheResourceTime;
        if (!this.val$zCacheResourceWrapper.zCacheResourceResponse.isSuccess || currentTimeMillis <= WVPackageAppWebViewClientFilter.access$000()) {
            if (this.val$zCacheResourceWrapper.zCacheResourceResponse.isSuccess) {
                AppMonitorUtil.commitSuccess("ZcacheResponseTime", "ZCache请求在正常时限内返回");
            }
        } else {
            AppMonitorUtil.commitFail("ZcacheResponseTime", 0, "ZCache请求超时, 用时：" + currentTimeMillis, (String) null);
        }
    }
}
