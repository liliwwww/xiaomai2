package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class SafeIterableMap$DescendingIterator<K, V> extends SafeIterableMap.ListIterator<K, V> {
    SafeIterableMap$DescendingIterator(SafeIterableMap.Entry<K, V> entry, SafeIterableMap.Entry<K, V> entry2) {
        super(entry, entry2);
    }

    SafeIterableMap.Entry<K, V> backward(SafeIterableMap.Entry<K, V> entry) {
        return entry.mNext;
    }

    SafeIterableMap.Entry<K, V> forward(SafeIterableMap.Entry<K, V> entry) {
        return entry.mPrevious;
    }
}
