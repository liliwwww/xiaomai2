package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okhttp3.internal.NamedRunnable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class Http2Connection$4 extends NamedRunnable {
    final /* synthetic */ Http2Connection this$0;
    final /* synthetic */ List val$requestHeaders;
    final /* synthetic */ int val$streamId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Http2Connection$4(Http2Connection http2Connection, String str, Object[] objArr, int i, List list) {
        super(str, objArr);
        this.this$0 = http2Connection;
        this.val$streamId = i;
        this.val$requestHeaders = list;
    }

    @Override // okhttp3.internal.NamedRunnable
    public void execute() {
        if (this.this$0.j.onRequest(this.val$streamId, this.val$requestHeaders)) {
            try {
                this.this$0.v.f(this.val$streamId, ErrorCode.CANCEL);
                synchronized (this.this$0) {
                    this.this$0.x.remove(Integer.valueOf(this.val$streamId));
                }
            } catch (IOException unused) {
            }
        }
    }
}
