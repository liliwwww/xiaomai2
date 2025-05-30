package androidx.emoji2.text;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class MetadataListReader$OffsetInfo {
    private final long mLength;
    private final long mStartOffset;

    MetadataListReader$OffsetInfo(long j, long j2) {
        this.mStartOffset = j;
        this.mLength = j2;
    }

    long getLength() {
        return this.mLength;
    }

    long getStartOffset() {
        return this.mStartOffset;
    }
}
