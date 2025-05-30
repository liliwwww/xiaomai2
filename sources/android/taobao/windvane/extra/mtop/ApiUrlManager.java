package android.taobao.windvane.extra.mtop;

import android.taobao.windvane.connect.api.ApiConstants;
import android.taobao.windvane.connect.api.ApiRequest;
import android.taobao.windvane.connect.api.WVApiWrapper;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ApiUrlManager {
    public static String getUploadTokenUrl(String str) {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.addParam(ApiConstants.API, "com.taobao.mtop.getUploadFileToken");
        apiRequest.addParam(ApiConstants.f5V, "2.0");
        apiRequest.addDataParam("uniqueKey", str);
        return WVApiWrapper.formatUrl(apiRequest, MtopApiAdapter.class);
    }

    public static String getUploadUrl(String str, String str2) {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.addParam(ApiConstants.API, "com.taobao.mtop.uploadFile");
        apiRequest.addParam(ApiConstants.f5V, "2.0");
        apiRequest.addDataParam("uniqueKey", str);
        apiRequest.addDataParam("accessToken", str2);
        return WVApiWrapper.formatUrl(apiRequest, MtopApiAdapter.class);
    }
}
