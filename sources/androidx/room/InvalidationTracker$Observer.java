package androidx.room;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class InvalidationTracker$Observer {
    final String[] mTables;

    protected InvalidationTracker$Observer(@NonNull String str, String... strArr) {
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
        this.mTables = strArr2;
        strArr2[strArr.length] = str;
    }

    boolean isRemote() {
        return false;
    }

    public abstract void onInvalidated(@NonNull Set<String> set);

    public InvalidationTracker$Observer(@NonNull String[] strArr) {
        this.mTables = (String[]) Arrays.copyOf(strArr, strArr.length);
    }
}
