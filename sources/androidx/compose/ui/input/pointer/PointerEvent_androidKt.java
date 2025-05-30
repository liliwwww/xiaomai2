package androidx.compose.ui.input.pointer;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PointerEvent_androidKt {
    public static final int EmptyPointerKeyboardModifiers() {
        return PointerKeyboardModifiers.m1477constructorimpl(0);
    }

    /* renamed from: getAreAnyPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m1428getAreAnyPressedaHzCxE(int i) {
        return i != 0;
    }

    /* renamed from: indexOfFirstPressed-aHzCx-E, reason: not valid java name */
    public static final int m1429indexOfFirstPressedaHzCxE(int i) {
        if (i == 0) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = (i & (-97)) | ((i & 96) >>> 5); (i3 & 1) == 0; i3 >>>= 1) {
            i2++;
        }
        return i2;
    }

    /* renamed from: indexOfLastPressed-aHzCx-E, reason: not valid java name */
    public static final int m1430indexOfLastPressedaHzCxE(int i) {
        int i2 = -1;
        for (int i3 = (i & (-97)) | ((i & 96) >>> 5); i3 != 0; i3 >>>= 1) {
            i2++;
        }
        return i2;
    }

    /* renamed from: isAltGraphPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m1431isAltGraphPressed5xRPYO0(int i) {
        return false;
    }

    /* renamed from: isAltPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m1432isAltPressed5xRPYO0(int i) {
        return (i & 2) != 0;
    }

    /* renamed from: isBackPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m1433isBackPressedaHzCxE(int i) {
        return (i & 8) != 0;
    }

    /* renamed from: isCapsLockOn-5xRPYO0, reason: not valid java name */
    public static final boolean m1434isCapsLockOn5xRPYO0(int i) {
        return (i & AccessibilityNodeInfoCompat.ACTION_DISMISS) != 0;
    }

    /* renamed from: isCtrlPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m1435isCtrlPressed5xRPYO0(int i) {
        return (i & 4096) != 0;
    }

    /* renamed from: isForwardPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m1436isForwardPressedaHzCxE(int i) {
        return (i & 16) != 0;
    }

    /* renamed from: isFunctionPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m1437isFunctionPressed5xRPYO0(int i) {
        return (i & 8) != 0;
    }

    /* renamed from: isMetaPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m1438isMetaPressed5xRPYO0(int i) {
        return (i & AccessibilityNodeInfoCompat.ACTION_CUT) != 0;
    }

    /* renamed from: isNumLockOn-5xRPYO0, reason: not valid java name */
    public static final boolean m1439isNumLockOn5xRPYO0(int i) {
        return (i & 2097152) != 0;
    }

    /* renamed from: isPressed-bNIWhpI, reason: not valid java name */
    public static final boolean m1440isPressedbNIWhpI(int i, int i2) {
        if (i2 == 0) {
            return m1441isPrimaryPressedaHzCxE(i);
        }
        if (i2 == 1) {
            return m1443isSecondaryPressedaHzCxE(i);
        }
        if (i2 == 2 || i2 == 3 || i2 == 4) {
            if ((i & (1 << i2)) == 0) {
                return false;
            }
        } else if ((i & (1 << (i2 + 2))) == 0) {
            return false;
        }
        return true;
    }

    /* renamed from: isPrimaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m1441isPrimaryPressedaHzCxE(int i) {
        return (i & 33) != 0;
    }

    /* renamed from: isScrollLockOn-5xRPYO0, reason: not valid java name */
    public static final boolean m1442isScrollLockOn5xRPYO0(int i) {
        return (i & InputDeviceCompat.SOURCE_ROTARY_ENCODER) != 0;
    }

    /* renamed from: isSecondaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m1443isSecondaryPressedaHzCxE(int i) {
        return (i & 66) != 0;
    }

    /* renamed from: isShiftPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m1444isShiftPressed5xRPYO0(int i) {
        return (i & 1) != 0;
    }

    /* renamed from: isSymPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m1445isSymPressed5xRPYO0(int i) {
        return (i & 4) != 0;
    }

    /* renamed from: isTertiaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m1446isTertiaryPressedaHzCxE(int i) {
        return (i & 4) != 0;
    }
}
