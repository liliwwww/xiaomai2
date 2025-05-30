package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.NamedRunnable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class Http2Connection$2 extends NamedRunnable {
    final /* synthetic */ Http2Connection this$0;
    final /* synthetic */ int val$streamId;
    final /* synthetic */ long val$unacknowledgedBytesRead;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Http2Connection$2(Http2Connection http2Connection, String str, Object[] objArr, int i, long j) {
        super(str, objArr);
        this.this$0 = http2Connection;
        this.val$streamId = i;
        this.val$unacknowledgedBytesRead = j;
    }

    @Override // okhttp3.internal.NamedRunnable
    public void execute() {
        try {
            this.this$0.v.windowUpdate(this.val$streamId, this.val$unacknowledgedBytesRead);
        } catch (IOException e) {
            Http2Connection.a(this.this$0, e);
        }
    }
}
