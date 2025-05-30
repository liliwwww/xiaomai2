package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.recyclerview.widget.MessageThreadUtil;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MessageThreadUtil$1<T> implements ThreadUtil.MainThreadCallback<T> {
    static final int ADD_TILE = 2;
    static final int REMOVE_TILE = 3;
    static final int UPDATE_ITEM_COUNT = 1;
    final /* synthetic */ MessageThreadUtil this$0;
    final /* synthetic */ ThreadUtil.MainThreadCallback val$callback;
    final MessageThreadUtil$MessageQueue mQueue = new MessageThreadUtil$MessageQueue();
    private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    private Runnable mMainThreadRunnable = new Runnable() { // from class: androidx.recyclerview.widget.MessageThreadUtil$1.1
        @Override // java.lang.Runnable
        public void run() {
            MessageThreadUtil.SyncQueueItem next = MessageThreadUtil$1.this.mQueue.next();
            while (next != null) {
                int i = next.what;
                if (i == 1) {
                    MessageThreadUtil$1.this.val$callback.updateItemCount(next.arg1, next.arg2);
                } else if (i == 2) {
                    MessageThreadUtil$1.this.val$callback.addTile(next.arg1, (TileList.Tile) next.data);
                } else if (i != 3) {
                    Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
                } else {
                    MessageThreadUtil$1.this.val$callback.removeTile(next.arg1, next.arg2);
                }
                next = MessageThreadUtil$1.this.mQueue.next();
            }
        }
    };

    MessageThreadUtil$1(MessageThreadUtil messageThreadUtil, ThreadUtil.MainThreadCallback mainThreadCallback) {
        this.this$0 = messageThreadUtil;
        this.val$callback = mainThreadCallback;
    }

    private void sendMessage(MessageThreadUtil.SyncQueueItem syncQueueItem) {
        this.mQueue.sendMessage(syncQueueItem);
        this.mMainThreadHandler.post(this.mMainThreadRunnable);
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
    public void addTile(int i, TileList.Tile<T> tile) {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(2, i, tile));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
    public void removeTile(int i, int i2) {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(3, i, i2));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
    public void updateItemCount(int i, int i2) {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(1, i, i2));
    }
}
