package androidx.core.net;

import android.net.TrafficStats;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.net.DatagramSocket;
import java.net.SocketException;

/* compiled from: Taobao */
@RequiresApi(24)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class TrafficStatsCompat$Api24Impl {
    private TrafficStatsCompat$Api24Impl() {
    }

    @DoNotInline
    static void tagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
        TrafficStats.tagDatagramSocket(datagramSocket);
    }

    @DoNotInline
    static void untagDatagramSocket(DatagramSocket datagramSocket) throws SocketException {
        TrafficStats.untagDatagramSocket(datagramSocket);
    }
}
