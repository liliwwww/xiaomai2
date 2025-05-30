package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Taobao */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class SafeIterableMap$IteratorWithAdditions<K, V> extends SafeIterableMap.SupportRemove<K, V> implements Iterator<Map.Entry<K, V>> {
    private boolean mBeforeStart = true;
    private SafeIterableMap.Entry<K, V> mCurrent;
    final /* synthetic */ SafeIterableMap this$0;

    SafeIterableMap$IteratorWithAdditions(SafeIterableMap safeIterableMap) {
        this.this$0 = safeIterableMap;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.mBeforeStart) {
            return this.this$0.mStart != null;
        }
        SafeIterableMap.Entry<K, V> entry = this.mCurrent;
        return (entry == null || entry.mNext == null) ? false : true;
    }

    void supportRemove(@NonNull SafeIterableMap.Entry<K, V> entry) {
        SafeIterableMap.Entry<K, V> entry2 = this.mCurrent;
        if (entry == entry2) {
            SafeIterableMap.Entry<K, V> entry3 = entry2.mPrevious;
            this.mCurrent = entry3;
            this.mBeforeStart = entry3 == null;
        }
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        if (this.mBeforeStart) {
            this.mBeforeStart = false;
            this.mCurrent = this.this$0.mStart;
        } else {
            SafeIterableMap.Entry<K, V> entry = this.mCurrent;
            this.mCurrent = entry != null ? entry.mNext : null;
        }
        return this.mCurrent;
    }
}
