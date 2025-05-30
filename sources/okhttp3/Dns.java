package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import tb.z31;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Dns {
    public static final Dns SYSTEM = z31.a;

    List<InetAddress> lookup(String str) throws UnknownHostException;
}
