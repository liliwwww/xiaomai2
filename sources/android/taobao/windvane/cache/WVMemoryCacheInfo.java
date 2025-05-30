package android.taobao.windvane.cache;

import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class WVMemoryCacheInfo {
    public long cachedTime;
    public byte[] mCachedDatas;
    public Map<String, List<String>> mCachedHeaders;

    WVMemoryCacheInfo(Map<String, List<String>> map, byte[] bArr) {
        this.mCachedHeaders = null;
        this.mCachedDatas = null;
        this.cachedTime = 0L;
        this.mCachedDatas = bArr;
        this.mCachedHeaders = map;
        this.cachedTime = System.currentTimeMillis();
    }
}
