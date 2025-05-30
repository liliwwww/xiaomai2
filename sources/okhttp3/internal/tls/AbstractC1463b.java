package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import tb.iv3;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.tls.b */
/* loaded from: classes2.dex */
public abstract class AbstractC1463b {
    /* renamed from: b */
    public static AbstractC1463b m750b(X509TrustManager x509TrustManager) {
        return iv3.j().c(x509TrustManager);
    }

    /* renamed from: a */
    public abstract List<Certificate> mo749a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
