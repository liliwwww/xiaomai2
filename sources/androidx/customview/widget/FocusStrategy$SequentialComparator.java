package androidx.customview.widget;

import android.graphics.Rect;
import androidx.customview.widget.FocusStrategy;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class FocusStrategy$SequentialComparator<T> implements Comparator<T> {
    private final FocusStrategy.BoundsAdapter<T> mAdapter;
    private final boolean mIsLayoutRtl;
    private final Rect mTemp1 = new Rect();
    private final Rect mTemp2 = new Rect();

    FocusStrategy$SequentialComparator(boolean z, FocusStrategy.BoundsAdapter<T> boundsAdapter) {
        this.mIsLayoutRtl = z;
        this.mAdapter = boundsAdapter;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        Rect rect = this.mTemp1;
        Rect rect2 = this.mTemp2;
        this.mAdapter.obtainBounds(t, rect);
        this.mAdapter.obtainBounds(t2, rect2);
        int i = rect.top;
        int i2 = rect2.top;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = rect.left;
        int i4 = rect2.left;
        if (i3 < i4) {
            return this.mIsLayoutRtl ? 1 : -1;
        }
        if (i3 > i4) {
            return this.mIsLayoutRtl ? -1 : 1;
        }
        int i5 = rect.bottom;
        int i6 = rect2.bottom;
        if (i5 < i6) {
            return -1;
        }
        if (i5 > i6) {
            return 1;
        }
        int i7 = rect.right;
        int i8 = rect2.right;
        if (i7 < i8) {
            return this.mIsLayoutRtl ? 1 : -1;
        }
        if (i7 > i8) {
            return this.mIsLayoutRtl ? -1 : 1;
        }
        return 0;
    }
}
