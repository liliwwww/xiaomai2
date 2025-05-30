package androidx.recyclerview.widget;

import android.util.Log;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AsyncListUtil$1 implements ThreadUtil.MainThreadCallback<Object> {
    final /* synthetic */ AsyncListUtil this$0;

    AsyncListUtil$1(AsyncListUtil asyncListUtil) {
        this.this$0 = asyncListUtil;
    }

    private boolean isRequestedGeneration(int i) {
        return i == this.this$0.mRequestedGeneration;
    }

    private void recycleAllTiles() {
        for (int i = 0; i < this.this$0.mTileList.size(); i++) {
            AsyncListUtil asyncListUtil = this.this$0;
            asyncListUtil.mBackgroundProxy.recycleTile(asyncListUtil.mTileList.getAtIndex(i));
        }
        this.this$0.mTileList.clear();
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
    public void addTile(int i, TileList.Tile<Object> tile) {
        if (!isRequestedGeneration(i)) {
            this.this$0.mBackgroundProxy.recycleTile(tile);
            return;
        }
        TileList.Tile addOrReplace = this.this$0.mTileList.addOrReplace(tile);
        if (addOrReplace != null) {
            Log.e("AsyncListUtil", "duplicate tile @" + addOrReplace.mStartPosition);
            this.this$0.mBackgroundProxy.recycleTile(addOrReplace);
        }
        int i2 = tile.mStartPosition + tile.mItemCount;
        int i3 = 0;
        while (i3 < this.this$0.mMissingPositions.size()) {
            int keyAt = this.this$0.mMissingPositions.keyAt(i3);
            if (tile.mStartPosition > keyAt || keyAt >= i2) {
                i3++;
            } else {
                this.this$0.mMissingPositions.removeAt(i3);
                this.this$0.mViewCallback.onItemLoaded(keyAt);
            }
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
    public void removeTile(int i, int i2) {
        if (isRequestedGeneration(i)) {
            TileList.Tile removeAtPos = this.this$0.mTileList.removeAtPos(i2);
            if (removeAtPos != null) {
                this.this$0.mBackgroundProxy.recycleTile(removeAtPos);
                return;
            }
            Log.e("AsyncListUtil", "tile not found @" + i2);
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
    public void updateItemCount(int i, int i2) {
        if (isRequestedGeneration(i)) {
            AsyncListUtil asyncListUtil = this.this$0;
            asyncListUtil.mItemCount = i2;
            asyncListUtil.mViewCallback.onDataRefresh();
            AsyncListUtil asyncListUtil2 = this.this$0;
            asyncListUtil2.mDisplayedGeneration = asyncListUtil2.mRequestedGeneration;
            recycleAllTiles();
            AsyncListUtil asyncListUtil3 = this.this$0;
            asyncListUtil3.mAllowScrollHints = false;
            asyncListUtil3.updateRange();
        }
    }
}
