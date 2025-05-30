package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class ViewInfoStore$InfoRecord {
    static final int FLAG_APPEAR = 2;
    static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
    static final int FLAG_APPEAR_PRE_AND_POST = 14;
    static final int FLAG_DISAPPEARED = 1;
    static final int FLAG_POST = 8;
    static final int FLAG_PRE = 4;
    static final int FLAG_PRE_AND_POST = 12;
    static Pools.Pool<ViewInfoStore$InfoRecord> sPool = new Pools.SimplePool(20);
    int flags;

    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo postInfo;

    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

    private ViewInfoStore$InfoRecord() {
    }

    static void drainCache() {
        while (sPool.acquire() != null) {
        }
    }

    static ViewInfoStore$InfoRecord obtain() {
        ViewInfoStore$InfoRecord acquire = sPool.acquire();
        return acquire == null ? new ViewInfoStore$InfoRecord() : acquire;
    }

    static void recycle(ViewInfoStore$InfoRecord viewInfoStore$InfoRecord) {
        viewInfoStore$InfoRecord.flags = 0;
        viewInfoStore$InfoRecord.preInfo = null;
        viewInfoStore$InfoRecord.postInfo = null;
        sPool.release(viewInfoStore$InfoRecord);
    }
}
