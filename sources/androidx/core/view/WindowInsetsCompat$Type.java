package androidx.core.view;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class WindowInsetsCompat$Type {
    static final int CAPTION_BAR = 4;
    static final int DISPLAY_CUTOUT = 128;
    static final int FIRST = 1;
    static final int IME = 8;
    static final int LAST = 256;
    static final int MANDATORY_SYSTEM_GESTURES = 32;
    static final int NAVIGATION_BARS = 2;
    static final int SIZE = 9;
    static final int STATUS_BARS = 1;
    static final int SYSTEM_GESTURES = 16;
    static final int TAPPABLE_ELEMENT = 64;
    static final int WINDOW_DECOR = 256;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface InsetsType {
    }

    private WindowInsetsCompat$Type() {
    }

    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    static int all() {
        return -1;
    }

    public static int captionBar() {
        return 4;
    }

    public static int displayCutout() {
        return 128;
    }

    public static int ime() {
        return 8;
    }

    static int indexOf(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i);
    }

    public static int mandatorySystemGestures() {
        return 32;
    }

    public static int navigationBars() {
        return 2;
    }

    public static int statusBars() {
        return 1;
    }

    public static int systemBars() {
        return 7;
    }

    public static int systemGestures() {
        return 16;
    }

    public static int tappableElement() {
        return 64;
    }
}
