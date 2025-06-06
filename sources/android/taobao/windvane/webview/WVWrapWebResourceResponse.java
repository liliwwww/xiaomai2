package android.taobao.windvane.webview;

import java.io.InputStream;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVWrapWebResourceResponse {
    public String mEncoding;
    public Map<String, String> mHeaders;
    public InputStream mInputStream;
    public String mMimeType;
    public int status;
    public String zcacheInfo;

    public WVWrapWebResourceResponse(String str, String str2, InputStream inputStream, Map<String, String> map) {
        this.mMimeType = str;
        this.mEncoding = str2;
        this.mInputStream = inputStream;
        this.mHeaders = map;
    }
}
