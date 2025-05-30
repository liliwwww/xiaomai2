package androidx.core.os;

import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    public OperationCanceledException(@Nullable String str) {
        super(ObjectsCompat.toString(str, "The operation has been canceled."));
    }
}
