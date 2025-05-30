package okhttp3.internal.p011ws;

import java.io.IOException;
import java.util.Objects;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class WebSocketReader {

    /* renamed from: a */
    final boolean f852a;

    /* renamed from: b */
    final BufferedSource f853b;

    /* renamed from: c */
    final FrameCallback f854c;

    /* renamed from: d */
    private final Buffer f855d = new Buffer();

    /* renamed from: e */
    private final Buffer f856e = new Buffer();

    /* renamed from: f */
    private final byte[] f857f;

    /* renamed from: g */
    private final Buffer.c f858g;

    /* compiled from: Taobao */
    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        Objects.requireNonNull(bufferedSource, "source == null");
        Objects.requireNonNull(frameCallback, "frameCallback == null");
        this.f852a = z;
        this.f853b = bufferedSource;
        this.f854c = frameCallback;
        this.f857f = z ? null : new byte[4];
        this.f858g = z ? null : new Buffer.c();
    }
}
