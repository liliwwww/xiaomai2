package androidx.appcompat.widget;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.collection.LruCache;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ResourceManagerInternal$ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
    public ResourceManagerInternal$ColorFilterLruCache(int i) {
        super(i);
    }

    private static int generateCacheKey(int i, PorterDuff.Mode mode) {
        return ((i + 31) * 31) + mode.hashCode();
    }

    PorterDuffColorFilter get(int i, PorterDuff.Mode mode) {
        return (PorterDuffColorFilter) get(Integer.valueOf(generateCacheKey(i, mode)));
    }

    PorterDuffColorFilter put(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
        return (PorterDuffColorFilter) put(Integer.valueOf(generateCacheKey(i, mode)), porterDuffColorFilter);
    }
}
