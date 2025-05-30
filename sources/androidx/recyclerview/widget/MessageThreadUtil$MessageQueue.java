package androidx.recyclerview.widget;

import androidx.recyclerview.widget.MessageThreadUtil;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class MessageThreadUtil$MessageQueue {
    private MessageThreadUtil.SyncQueueItem mRoot;

    MessageThreadUtil$MessageQueue() {
    }

    synchronized MessageThreadUtil.SyncQueueItem next() {
        MessageThreadUtil.SyncQueueItem syncQueueItem = this.mRoot;
        if (syncQueueItem == null) {
            return null;
        }
        this.mRoot = syncQueueItem.next;
        return syncQueueItem;
    }

    synchronized void removeMessages(int i) {
        MessageThreadUtil.SyncQueueItem syncQueueItem;
        while (true) {
            syncQueueItem = this.mRoot;
            if (syncQueueItem == null || syncQueueItem.what != i) {
                break;
            }
            this.mRoot = syncQueueItem.next;
            syncQueueItem.recycle();
        }
        if (syncQueueItem != null) {
            MessageThreadUtil.SyncQueueItem syncQueueItem2 = syncQueueItem.next;
            while (syncQueueItem2 != null) {
                MessageThreadUtil.SyncQueueItem syncQueueItem3 = syncQueueItem2.next;
                if (syncQueueItem2.what == i) {
                    syncQueueItem.next = syncQueueItem3;
                    syncQueueItem2.recycle();
                } else {
                    syncQueueItem = syncQueueItem2;
                }
                syncQueueItem2 = syncQueueItem3;
            }
        }
    }

    synchronized void sendMessage(MessageThreadUtil.SyncQueueItem syncQueueItem) {
        MessageThreadUtil.SyncQueueItem syncQueueItem2 = this.mRoot;
        if (syncQueueItem2 == null) {
            this.mRoot = syncQueueItem;
            return;
        }
        while (true) {
            MessageThreadUtil.SyncQueueItem syncQueueItem3 = syncQueueItem2.next;
            if (syncQueueItem3 == null) {
                syncQueueItem2.next = syncQueueItem;
                return;
            }
            syncQueueItem2 = syncQueueItem3;
        }
    }

    synchronized void sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem syncQueueItem) {
        syncQueueItem.next = this.mRoot;
        this.mRoot = syncQueueItem;
    }
}
