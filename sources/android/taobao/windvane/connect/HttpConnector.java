package android.taobao.windvane.connect;

import android.taobao.windvane.WVCookieManager;
import android.taobao.windvane.util.TaoLog;
import java.net.HttpURLConnection;
import java.util.Map;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class HttpConnector {
    public static final String CACHE_CONTROL = "cache-control";
    public static final String CONTENT_LENGTH = "content-length";
    public static final String CONTENT_TYPE = "content-type";
    public static final String DATE = "date";
    public static final String ETAG = "etag";
    public static final String EXPIRES = "expires";
    public static final String IF_MODIFY_SINCE = "If-Modified-Since";
    public static final String IF_NONE_MATCH = "If-None-Match";
    public static final String LAST_MODIFIED = "last-modified";
    public static final String REDIRECT_LOCATION = "location";
    public static final String RESPONSE_CODE = "response-code";
    public static final String SET_COOKIE = "Set-Cookie";
    private static String TAG = "HttpConnector";
    public static final String URL = "url";
    private int redirectTime = 0;
    private HttpConnectListener<HttpResponse> mListener = null;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    class HttpOverFlowException extends Exception {
        public HttpOverFlowException(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    class HttpsErrorException extends Exception {
        public HttpsErrorException(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    class NetWorkErrorException extends Exception {
        public NetWorkErrorException(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    class RedirectException extends Exception {
        public RedirectException(String str) {
            super(str);
        }
    }

    static {
        System.setProperty("http.keepAlive", "false");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x03b3, code lost:
    
        if (r7 != 0) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x03fd, code lost:
    
        r2 = r17.mListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x03ff, code lost:
    
        if (r2 == null) goto L271;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0401, code lost:
    
        r2.onFinish(new android.taobao.windvane.connect.HttpResponse(), 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x040e, code lost:
    
        return new android.taobao.windvane.connect.HttpResponse();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x03fa, code lost:
    
        r7.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x03f8, code lost:
    
        if (r7 == 0) goto L268;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x034f A[Catch: all -> 0x0446, TryCatch #18 {all -> 0x0446, blocks: (B:109:0x0347, B:111:0x034f, B:112:0x0365, B:113:0x0370, B:18:0x042b, B:20:0x042f, B:21:0x0435, B:27:0x043d, B:29:0x0441, B:30:0x0445), top: B:6:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x042f A[Catch: all -> 0x0446, TryCatch #18 {all -> 0x0446, blocks: (B:109:0x0347, B:111:0x034f, B:112:0x0365, B:113:0x0370, B:18:0x042b, B:20:0x042f, B:21:0x0435, B:27:0x043d, B:29:0x0441, B:30:0x0445), top: B:6:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[Catch: all -> 0x0446, SYNTHETIC, TryCatch #18 {all -> 0x0446, blocks: (B:109:0x0347, B:111:0x034f, B:112:0x0365, B:113:0x0370, B:18:0x042b, B:20:0x042f, B:21:0x0435, B:27:0x043d, B:29:0x0441, B:30:0x0445), top: B:6:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0441 A[Catch: all -> 0x0446, TryCatch #18 {all -> 0x0446, blocks: (B:109:0x0347, B:111:0x034f, B:112:0x0365, B:113:0x0370, B:18:0x042b, B:20:0x042f, B:21:0x0435, B:27:0x043d, B:29:0x0441, B:30:0x0445), top: B:6:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[Catch: all -> 0x0446, SYNTHETIC, TRY_LEAVE, TryCatch #18 {all -> 0x0446, blocks: (B:109:0x0347, B:111:0x034f, B:112:0x0365, B:113:0x0370, B:18:0x042b, B:20:0x042f, B:21:0x0435, B:27:0x043d, B:29:0x0441, B:30:0x0445), top: B:6:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:333:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0460 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0455 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x044a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x037c A[Catch: all -> 0x041c, TryCatch #60 {all -> 0x041c, blocks: (B:34:0x0378, B:36:0x037c, B:37:0x0383, B:70:0x03bd, B:72:0x03c1, B:73:0x03c8, B:104:0x0412, B:105:0x041b, B:100:0x040f), top: B:5:0x002c, inners: #56 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x03a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0396 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x038b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03c1 A[Catch: all -> 0x041c, TryCatch #60 {all -> 0x041c, blocks: (B:34:0x0378, B:36:0x037c, B:37:0x0383, B:70:0x03bd, B:72:0x03c1, B:73:0x03c8, B:104:0x0412, B:105:0x041b, B:100:0x040f), top: B:5:0x002c, inners: #56 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x040f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r17v0, types: [android.taobao.windvane.connect.HttpConnector] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.taobao.windvane.connect.HttpRequest] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.util.zip.GZIPInputStream] */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v32, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r7v44 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.taobao.windvane.connect.HttpResponse dataConnect(android.taobao.windvane.connect.HttpRequest r18) throws android.taobao.windvane.connect.HttpConnector.NetWorkErrorException, android.taobao.windvane.connect.HttpConnector.HttpOverFlowException, android.taobao.windvane.connect.HttpConnector.RedirectException, android.taobao.windvane.connect.HttpConnector.HttpsErrorException {
        /*
            Method dump skipped, instructions count: 1144
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.connect.HttpConnector.dataConnect(android.taobao.windvane.connect.HttpRequest):android.taobao.windvane.connect.HttpResponse");
    }

    private void setConnectProp(HttpURLConnection httpURLConnection, HttpRequest httpRequest) {
        int retryTime = httpRequest.getRetryTime() + 1;
        httpURLConnection.setConnectTimeout(httpRequest.getConnectTimeout() * retryTime);
        httpURLConnection.setReadTimeout(httpRequest.getReadTimeout() * retryTime);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("Host", httpRequest.getUri().getHost());
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String cookie = WVCookieManager.getCookie(httpURLConnection.getURL().toString());
        if (cookie != null) {
            httpURLConnection.setRequestProperty("Cookie", cookie);
        }
        Map<String, String> headers = httpRequest.getHeaders();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        httpURLConnection.setUseCaches(false);
    }

    public HttpResponse syncConnect(String str) {
        return syncConnect(new HttpRequest(str), null);
    }

    public HttpResponse syncConnect(HttpRequest httpRequest) {
        return syncConnect(httpRequest, null);
    }

    public HttpResponse syncConnect(HttpRequest httpRequest, HttpConnectListener<HttpResponse> httpConnectListener) {
        Objects.requireNonNull(httpRequest, "Http connect error, request is null");
        String str = null;
        this.mListener = httpConnectListener;
        int i = 0;
        this.redirectTime = 0;
        int retryTime = httpRequest.getRetryTime();
        while (i < retryTime) {
            try {
                return dataConnect(httpRequest);
            } catch (HttpOverFlowException e) {
                e.printStackTrace();
                str = e.toString();
            } catch (HttpsErrorException e2) {
                e2.printStackTrace();
                str = e2.toString();
            } catch (NetWorkErrorException e3) {
                e3.printStackTrace();
                str = e3.toString();
                i++;
                try {
                    Thread.sleep(i * 2 * 1000);
                } catch (InterruptedException unused) {
                    TaoLog.m21e(TAG, "HttpConnector retry Sleep has been interrupted, go ahead");
                }
            } catch (RedirectException e4) {
                e4.printStackTrace();
                str = e4.toString();
            }
        }
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setErrorMsg(str);
        return httpResponse;
    }
}
