package androidx.versionedparcelable;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class VersionedParcel$1 extends ObjectInputStream {
    final /* synthetic */ VersionedParcel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VersionedParcel$1(VersionedParcel versionedParcel, InputStream inputStream) {
        super(inputStream);
        this.this$0 = versionedParcel;
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
        return cls != null ? cls : super.resolveClass(objectStreamClass);
    }
}
