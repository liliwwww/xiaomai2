package androidx.localbroadcastmanager.content;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LocalBroadcastManager$BroadcastRecord {
    final Intent intent;
    final ArrayList<LocalBroadcastManager.ReceiverRecord> receivers;

    LocalBroadcastManager$BroadcastRecord(Intent intent, ArrayList<LocalBroadcastManager.ReceiverRecord> arrayList) {
        this.intent = intent;
        this.receivers = arrayList;
    }
}
