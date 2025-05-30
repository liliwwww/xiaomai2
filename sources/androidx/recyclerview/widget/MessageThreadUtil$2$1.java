package androidx.recyclerview.widget;

import android.util.Log;
import androidx.recyclerview.widget.MessageThreadUtil;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class MessageThreadUtil$2$1 implements Runnable {
    final /* synthetic */ MessageThreadUtil.2 this$1;

    MessageThreadUtil$2$1(MessageThreadUtil.2 r1) {
        this.this$1 = r1;
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            MessageThreadUtil.SyncQueueItem next = this.this$1.mQueue.next();
            if (next == null) {
                this.this$1.mBackgroundRunning.set(false);
                return;
            }
            int i = next.what;
            if (i == 1) {
                this.this$1.mQueue.removeMessages(1);
                this.this$1.val$callback.refresh(next.arg1);
            } else if (i == 2) {
                this.this$1.mQueue.removeMessages(2);
                this.this$1.mQueue.removeMessages(3);
                this.this$1.val$callback.updateRange(next.arg1, next.arg2, next.arg3, next.arg4, next.arg5);
            } else if (i == 3) {
                this.this$1.val$callback.loadTile(next.arg1, next.arg2);
            } else if (i != 4) {
                Log.e("ThreadUtil", "Unsupported message, what=" + next.what);
            } else {
                this.this$1.val$callback.recycleTile((TileList$Tile) next.data);
            }
        }
    }
}
