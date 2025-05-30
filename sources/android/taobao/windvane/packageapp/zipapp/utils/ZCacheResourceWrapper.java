package android.taobao.windvane.packageapp.zipapp.utils;

import com.taobao.zcache.ResourceResponse;
import com.taobao.zcache.model.ZCacheResourceResponse;
import java.io.ByteArrayInputStream;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ZCacheResourceWrapper {
    public ZCacheResourceResponse zCacheResourceResponse = null;

    public ZCacheResourceResponse wrapZCacheResourceResponse(ResourceResponse resourceResponse) {
        ZCacheResourceResponse zCacheResourceResponse = new ZCacheResourceResponse();
        this.zCacheResourceResponse = zCacheResourceResponse;
        if (resourceResponse == null) {
            zCacheResourceResponse.isSuccess = false;
            zCacheResourceResponse.status = 0;
            zCacheResourceResponse.zcacheInfo = "NO_RESPONSE";
        } else {
            zCacheResourceResponse.headers = resourceResponse.getHeader();
            Map map = this.zCacheResourceResponse.headers;
            if (map == null || !map.containsKey("X-ZCache-Info")) {
                this.zCacheResourceResponse.zcacheInfo = "NO_HEADER";
            } else {
                ZCacheResourceResponse zCacheResourceResponse2 = this.zCacheResourceResponse;
                zCacheResourceResponse2.zcacheInfo = (String) zCacheResourceResponse2.headers.get("X-ZCache-Info");
            }
            if (resourceResponse.getError() != null || resourceResponse.getData() == null) {
                ZCacheResourceResponse zCacheResourceResponse3 = this.zCacheResourceResponse;
                zCacheResourceResponse3.isSuccess = false;
                zCacheResourceResponse3.status = 1;
            } else {
                this.zCacheResourceResponse.inputStream = new ByteArrayInputStream(resourceResponse.getData());
                ZCacheResourceResponse zCacheResourceResponse4 = this.zCacheResourceResponse;
                zCacheResourceResponse4.isSuccess = true;
                zCacheResourceResponse4.status = 2;
            }
        }
        return this.zCacheResourceResponse;
    }
}
