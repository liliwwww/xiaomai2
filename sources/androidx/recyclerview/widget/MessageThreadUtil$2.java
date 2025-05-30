package androidx.recyclerview.widget;

import android.os.AsyncTask;
import androidx.recyclerview.widget.MessageThreadUtil;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MessageThreadUtil$2<T> implements ThreadUtil.BackgroundCallback<T> {
    static final int LOAD_TILE = 3;
    static final int RECYCLE_TILE = 4;
    static final int REFRESH = 1;
    static final int UPDATE_RANGE = 2;
    final /* synthetic */ MessageThreadUtil this$0;
    final /* synthetic */ ThreadUtil.BackgroundCallback val$callback;
    final MessageThreadUtil$MessageQueue mQueue = new MessageThreadUtil$MessageQueue();
    private final Executor mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
    AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
    private Runnable mBackgroundRunnable = new 1(this);

    MessageThreadUtil$2(MessageThreadUtil messageThreadUtil, ThreadUtil.BackgroundCallback backgroundCallback) {
        this.this$0 = messageThreadUtil;
        this.val$callback = backgroundCallback;
    }

    private void maybeExecuteBackgroundRunnable() {
        if (this.mBackgroundRunning.compareAndSet(false, true)) {
            this.mExecutor.execute(this.mBackgroundRunnable);
        }
    }

    private void sendMessage(MessageThreadUtil.SyncQueueItem syncQueueItem) {
        this.mQueue.sendMessage(syncQueueItem);
        maybeExecuteBackgroundRunnable();
    }

    private void sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem syncQueueItem) {
        this.mQueue.sendMessageAtFrontOfQueue(syncQueueItem);
        maybeExecuteBackgroundRunnable();
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
    public void loadTile(int i, int i2) {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(3, i, i2));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
    public void recycleTile(TileList.Tile<T> tile) {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(4, 0, tile));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
    public void refresh(int i) {
        sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage(1, i, (Object) null));
    }

    @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
    public void updateRange(int i, int i2, int i3, int i4, int i5) {
        sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage(2, i, i2, i3, i4, i5, (Object) null));
    }
}
