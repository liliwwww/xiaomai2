package android.taobao.windvane.connect;

import android.content.Context;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface WVNetWorkProxyInterface {
    IResponse getWebResourceResponse(Context context, String str, Map<String, String> map, boolean z, boolean z2, int i);

    boolean isSupportSpdy(Context context, String str);

    void resetStat(String str);
}
