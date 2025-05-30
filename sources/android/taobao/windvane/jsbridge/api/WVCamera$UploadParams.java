package android.taobao.windvane.jsbridge.api;

import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVCamera$UploadParams {
    public String bizCode;
    public String extraData;
    public JSONObject extraInfo;
    public String filePath;
    public String identifier;
    public JSONArray images;
    public boolean isLastPic;
    public String localUrl;
    public int maxSelect;
    public String mode;
    public String mutipleSelection;
    public boolean needBase64;
    public boolean needLogin;
    public boolean needZoom;
    public boolean reducePermission;
    final /* synthetic */ WVCamera this$0;
    public int type;
    public String v;

    public WVCamera$UploadParams(WVCamera wVCamera) {
        this.this$0 = wVCamera;
        this.identifier = "";
        this.mode = "both";
        this.mutipleSelection = "0";
        this.maxSelect = 9;
        this.isLastPic = true;
        this.needZoom = true;
        this.needLogin = false;
        this.images = null;
        this.needBase64 = false;
        this.reducePermission = false;
    }

    public WVCamera$UploadParams(WVCamera wVCamera, WVCamera$UploadParams wVCamera$UploadParams) {
        this.this$0 = wVCamera;
        this.identifier = "";
        this.mode = "both";
        this.mutipleSelection = "0";
        this.maxSelect = 9;
        this.isLastPic = true;
        this.needZoom = true;
        this.needLogin = false;
        this.images = null;
        this.needBase64 = false;
        this.reducePermission = false;
        this.filePath = wVCamera$UploadParams.filePath;
        this.localUrl = wVCamera$UploadParams.localUrl;
        this.type = wVCamera$UploadParams.type;
        this.v = wVCamera$UploadParams.v;
        this.bizCode = wVCamera$UploadParams.bizCode;
        this.extraData = wVCamera$UploadParams.extraData;
        this.identifier = wVCamera$UploadParams.identifier;
        this.mode = wVCamera$UploadParams.mode;
        this.mutipleSelection = wVCamera$UploadParams.mutipleSelection;
        this.maxSelect = wVCamera$UploadParams.maxSelect;
        this.isLastPic = wVCamera$UploadParams.isLastPic;
        this.images = wVCamera$UploadParams.images;
        this.needZoom = wVCamera$UploadParams.needZoom;
        this.needLogin = wVCamera$UploadParams.needLogin;
        this.needBase64 = wVCamera$UploadParams.needBase64;
        this.reducePermission = wVCamera$UploadParams.reducePermission;
    }
}
