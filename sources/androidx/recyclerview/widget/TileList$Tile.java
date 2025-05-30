package androidx.recyclerview.widget;

import java.lang.reflect.Array;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class TileList$Tile<T> {
    public int mItemCount;
    public final T[] mItems;
    TileList$Tile<T> mNext;
    public int mStartPosition;

    public TileList$Tile(Class<T> cls, int i) {
        this.mItems = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
    }

    boolean containsPosition(int i) {
        int i2 = this.mStartPosition;
        return i2 <= i && i < i2 + this.mItemCount;
    }

    T getByPosition(int i) {
        return this.mItems[i - this.mStartPosition];
    }
}
