package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
@Retention(RetentionPolicy.CLASS)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public @interface OnConflictStrategy {
    public static final int ABORT = 3;

    @Deprecated
    public static final int FAIL = 4;
    public static final int IGNORE = 5;
    public static final int REPLACE = 1;

    @Deprecated
    public static final int ROLLBACK = 2;
}
