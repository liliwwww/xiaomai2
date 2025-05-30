package androidx.versionedparcelable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class VersionedParcelStream$FieldBuffer {
    final DataOutputStream mDataStream;
    private final int mFieldId;
    final ByteArrayOutputStream mOutput;
    private final DataOutputStream mTarget;

    VersionedParcelStream$FieldBuffer(int i, DataOutputStream dataOutputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.mOutput = byteArrayOutputStream;
        this.mDataStream = new DataOutputStream(byteArrayOutputStream);
        this.mFieldId = i;
        this.mTarget = dataOutputStream;
    }

    void flushField() throws IOException {
        this.mDataStream.flush();
        int size = this.mOutput.size();
        this.mTarget.writeInt((this.mFieldId << 16) | (size >= 65535 ? 65535 : size));
        if (size >= 65535) {
            this.mTarget.writeInt(size);
        }
        this.mOutput.writeTo(this.mTarget);
    }
}
