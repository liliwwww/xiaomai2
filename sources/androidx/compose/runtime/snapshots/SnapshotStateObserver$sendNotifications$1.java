package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class SnapshotStateObserver$sendNotifications$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SnapshotStateObserver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotStateObserver$sendNotifications$1(SnapshotStateObserver snapshotStateObserver) {
        super(0);
        this.this$0 = snapshotStateObserver;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m931invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m931invoke() {
        do {
            MutableVector access$getObservedScopeMaps$p = SnapshotStateObserver.access$getObservedScopeMaps$p(this.this$0);
            SnapshotStateObserver snapshotStateObserver = this.this$0;
            synchronized (access$getObservedScopeMaps$p) {
                if (!SnapshotStateObserver.access$getSendingNotifications$p(snapshotStateObserver)) {
                    SnapshotStateObserver.access$setSendingNotifications$p(snapshotStateObserver, true);
                    try {
                        MutableVector access$getObservedScopeMaps$p2 = SnapshotStateObserver.access$getObservedScopeMaps$p(snapshotStateObserver);
                        int size = access$getObservedScopeMaps$p2.getSize();
                        if (size > 0) {
                            Object[] content = access$getObservedScopeMaps$p2.getContent();
                            int i = 0;
                            do {
                                ((SnapshotStateObserver$ObservedScopeMap) content[i]).notifyInvalidatedScopes();
                                i++;
                            } while (i < size);
                        }
                        SnapshotStateObserver.access$setSendingNotifications$p(snapshotStateObserver, false);
                    } finally {
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        } while (SnapshotStateObserver.access$drainChanges(this.this$0));
    }
}
