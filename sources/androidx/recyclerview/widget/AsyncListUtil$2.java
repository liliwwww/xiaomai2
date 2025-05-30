package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AsyncListUtil$2 implements ThreadUtil.BackgroundCallback<Object> {
    private int mFirstRequiredTileStart;
    private int mGeneration;
    private int mItemCount;
    private int mLastRequiredTileStart;
    final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
    private TileList.Tile<Object> mRecycledRoot;
    final /* synthetic */ AsyncListUtil this$0;

    AsyncListUtil$2(AsyncListUtil asyncListUtil) {
        this.this$0 = asyncListUtil;
    }

    private TileList.Tile<Object> acquireTile() {
        TileList.Tile<Object> tile = this.mRecycledRoot;
        if (tile != null) {
            this.mRecycledRoot = tile.mNext;
            return tile;
        }
        AsyncListUtil asyncListUtil = this.this$0;
        return new TileList.Tile<>(asyncListUtil.mTClass, asyncListUtil.mTileSize);
    }

    private void addTile(TileList.Tile<Object> tile) {
        this.mLoadedTiles.put(tile.mStartPosition, true);
        this.this$0.mMainThreadProxy.addTile(this.mGeneration, tile);
    }

    private void flushTileCache(int i) {
        int maxCachedTiles = this.this$0.mDataCallback.getMaxCachedTiles();
        while (this.mLoadedTiles.size() >= maxCachedTiles) {
            int keyAt = this.mLoadedTiles.keyAt(0);
            SparseBooleanArray sparseBooleanArray = this.mLoadedTiles;
            int keyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
            int i2 = this.mFirstRequiredTileStart - keyAt;
            int i3 = keyAt2 - this.mLastRequiredTileStart;
            if (i2 > 0 && (i2 >= i3 || i == 2)) {
                removeTile(keyAt);
            } else {
                if (i3 <= 0) {
                    return;
                }
                if (i2 >= i3 && i != 1) {
                    return;
                } else {
                    removeTile(keyAt2);
                }
            }
        }
    }

    private int getTileStart(int i) {
        return i - (i % this.this$0.mTileSize);
    }

    private boolean isTileLoaded(int i) {
        return this.mLoadedTiles.get(i);
    }

    private void log(String str, Object... objArr) {
        Log.d("AsyncListUtil", "[BKGR] " + String.format(str, objArr));
    }

    private void removeTile(int i) {
        this.mLoadedTiles.delete(i);
        this.this$0.mMainThreadProxy.removeTile(this.mGeneration, i);
    }

    private void requestTiles(int i, int i2, int i3, boolean z) {
        int i4 = i;
        while (i4 <= i2) {
            this.this$0.mBackgroundProxy.loadTile(z ? (i2 + i) - i4 : i4, i3);
            i4 += this.this$0.mTileSize;
        }
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
    public void loadTile(int i, int i2) {
        if (isTileLoaded(i)) {
            return;
        }
        TileList.Tile<Object> acquireTile = acquireTile();
        acquireTile.mStartPosition = i;
        int min = Math.min(this.this$0.mTileSize, this.mItemCount - i);
        acquireTile.mItemCount = min;
        this.this$0.mDataCallback.fillData(acquireTile.mItems, acquireTile.mStartPosition, min);
        flushTileCache(i2);
        addTile(acquireTile);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
    public void recycleTile(TileList.Tile<Object> tile) {
        this.this$0.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
        tile.mNext = this.mRecycledRoot;
        this.mRecycledRoot = tile;
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
    public void refresh(int i) {
        this.mGeneration = i;
        this.mLoadedTiles.clear();
        int refreshData = this.this$0.mDataCallback.refreshData();
        this.mItemCount = refreshData;
        this.this$0.mMainThreadProxy.updateItemCount(this.mGeneration, refreshData);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
    public void updateRange(int i, int i2, int i3, int i4, int i5) {
        if (i > i2) {
            return;
        }
        int tileStart = getTileStart(i);
        int tileStart2 = getTileStart(i2);
        this.mFirstRequiredTileStart = getTileStart(i3);
        int tileStart3 = getTileStart(i4);
        this.mLastRequiredTileStart = tileStart3;
        if (i5 == 1) {
            requestTiles(this.mFirstRequiredTileStart, tileStart2, i5, true);
            requestTiles(tileStart2 + this.this$0.mTileSize, this.mLastRequiredTileStart, i5, false);
        } else {
            requestTiles(tileStart, tileStart3, i5, false);
            requestTiles(this.mFirstRequiredTileStart, tileStart - this.this$0.mTileSize, i5, true);
        }
    }
}
