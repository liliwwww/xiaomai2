package androidx.room.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class SneakyThrow {
    private SneakyThrow() {
    }

    public static void reThrow(@NonNull Exception exc) {
        sneakyThrow(exc);
    }

    private static <E extends Throwable> void sneakyThrow(@NonNull Throwable th) throws Throwable {
        throw th;
    }
}
