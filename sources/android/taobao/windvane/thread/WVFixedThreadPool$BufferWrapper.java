package android.taobao.windvane.thread;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class WVFixedThreadPool$BufferWrapper {
    private boolean isFree = false;
    public byte[] tempBuffer;

    WVFixedThreadPool$BufferWrapper() {
        this.tempBuffer = null;
        this.tempBuffer = new byte[WVFixedThreadPool.bufferSize];
    }

    public boolean isFree() {
        return this.isFree;
    }

    public void setIsFree(boolean z) {
        this.isFree = z;
    }
}
