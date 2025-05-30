package androidx.emoji2.text.flatbuffer;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class FlexBuffers$Object {
    ReadBuf bb;
    int byteWidth;
    int end;

    FlexBuffers$Object(ReadBuf readBuf, int i, int i2) {
        this.bb = readBuf;
        this.end = i;
        this.byteWidth = i2;
    }

    public String toString() {
        return toString(new StringBuilder(128)).toString();
    }

    public abstract StringBuilder toString(StringBuilder sb);
}
