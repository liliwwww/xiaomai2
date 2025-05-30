package android.taobao.windvane.cache;

import android.taobao.windvane.file.FileAccesser;
import android.taobao.windvane.util.TaoLog;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: protected */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVFileCache$FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 1;
    final /* synthetic */ WVFileCache this$0;

    protected WVFileCache$FixedSizeLinkedHashMap(WVFileCache wVFileCache) {
        this.this$0 = wVFileCache;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        if (size() <= WVFileCache.access$000(this.this$0)) {
            return false;
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.d(WVFileCache.access$100(), "removeEldestEntry, size:" + size() + " " + entry.getKey());
        }
        V value = entry.getValue();
        if (!(value instanceof WVFileInfo)) {
            return true;
        }
        WVFileInfo wVFileInfo = (WVFileInfo) value;
        if (!FileAccesser.deleteFile(new File(WVFileCache.access$200(this.this$0), wVFileInfo.fileName))) {
            return true;
        }
        WVFileInfoParser.updateFileInfo(3, wVFileInfo, WVFileCache.access$300(this.this$0));
        return true;
    }
}
