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
import tb.q92;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class b {
    private final List<okhttp3.f> a;
    private int b = 0;
    private boolean c;
    private boolean d;

    b(List<okhttp3.f> list) {
        this.a = list;
    }

    private boolean c(SSLSocket sSLSocket) {
        for (int i = this.b; i < this.a.size(); i++) {
            if (this.a.get(i).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    okhttp3.f a(SSLSocket sSLSocket) throws IOException {
        okhttp3.f fVar;
        int i = this.b;
        int size = this.a.size();
        while (true) {
            if (i >= size) {
                fVar = null;
                break;
            }
            fVar = this.a.get(i);
            if (fVar.c(sSLSocket)) {
                this.b = i + 1;
                break;
            }
            i++;
        }
        if (fVar != null) {
            this.c = c(sSLSocket);
            q92.a.c(fVar, sSLSocket, this.d);
            return fVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    boolean b(IOException iOException) {
        this.d = true;
        if (!this.c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return iOException instanceof SSLException;
    }
}
