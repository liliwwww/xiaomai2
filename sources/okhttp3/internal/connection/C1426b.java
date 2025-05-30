package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.C1417f;
import tb.q92;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.b */
/* loaded from: classes2.dex */
final class C1426b {

    /* renamed from: a */
    private final List<C1417f> f592a;

    /* renamed from: b */
    private int f593b = 0;

    /* renamed from: c */
    private boolean f594c;

    /* renamed from: d */
    private boolean f595d;

    C1426b(List<C1417f> list) {
        this.f592a = list;
    }

    /* renamed from: c */
    private boolean m502c(SSLSocket sSLSocket) {
        for (int i = this.f593b; i < this.f592a.size(); i++) {
            if (this.f592a.get(i).m424c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    C1417f m503a(SSLSocket sSLSocket) throws IOException {
        C1417f c1417f;
        int i = this.f593b;
        int size = this.f592a.size();
        while (true) {
            if (i >= size) {
                c1417f = null;
                break;
            }
            c1417f = this.f592a.get(i);
            if (c1417f.m424c(sSLSocket)) {
                this.f593b = i + 1;
                break;
            }
            i++;
        }
        if (c1417f != null) {
            this.f594c = m502c(sSLSocket);
            q92.a.c(c1417f, sSLSocket, this.f595d);
            return c1417f;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f595d + ", modes=" + this.f592a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    /* renamed from: b */
    boolean m504b(IOException iOException) {
        this.f595d = true;
        if (!this.f594c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return iOException instanceof SSLException;
    }
}
