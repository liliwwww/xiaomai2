package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class CursorWindowCompat {

    /* compiled from: Taobao */
    @RequiresApi(15)
    static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static CursorWindow createCursorWindow(String str) {
            return new CursorWindow(str);
        }
    }

    /* compiled from: Taobao */
    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static CursorWindow createCursorWindow(String str, long j) {
            return new CursorWindow(str, j);
        }
    }

    private CursorWindowCompat() {
    }

    @NonNull
    public static CursorWindow create(@Nullable String str, long j) {
        int i = Build.VERSION.SDK_INT;
        return i >= 28 ? Api28Impl.createCursorWindow(str, j) : i >= 15 ? Api15Impl.createCursorWindow(str) : new CursorWindow(false);
    }
}
