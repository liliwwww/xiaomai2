package androidx.customview.widget;

import androidx.collection.SparseArrayCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.FocusStrategy;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ExploreByTouchHelper$2 implements FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> {
    ExploreByTouchHelper$2() {
    }

    public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i) {
        return sparseArrayCompat.valueAt(i);
    }

    public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
        return sparseArrayCompat.size();
    }
}
