package okhttp3.internal.http2;

import okhttp3.internal.NamedRunnable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class Http2Connection$7 extends NamedRunnable {
    final /* synthetic */ Http2Connection this$0;
    final /* synthetic */ ErrorCode val$errorCode;
    final /* synthetic */ int val$streamId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Http2Connection$7(Http2Connection http2Connection, String str, Object[] objArr, int i, ErrorCode errorCode) {
        super(str, objArr);
        this.this$0 = http2Connection;
        this.val$streamId = i;
        this.val$errorCode = errorCode;
    }

    @Override // okhttp3.internal.NamedRunnable
    public void execute() {
        this.this$0.j.onReset(this.val$streamId, this.val$errorCode);
        synchronized (this.this$0) {
            this.this$0.x.remove(Integer.valueOf(this.val$streamId));
        }
    }
}
