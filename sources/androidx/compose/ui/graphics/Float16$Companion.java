package androidx.compose.ui.graphics;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Float16$Companion {
    private Float16$Companion() {
    }

    public /* synthetic */ Float16$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final short floatToHalf(float f) {
        int i;
        int i2;
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        int i3 = floatToRawIntBits >>> 31;
        int i4 = (floatToRawIntBits >>> 23) & 255;
        int i5 = floatToRawIntBits & 8388607;
        if (i4 == 255) {
            i = i5 != 0 ? 512 : 0;
            r3 = 31;
        } else {
            int i6 = (i4 - 127) + 15;
            if (i6 >= 31) {
                i = 0;
                r3 = 49;
            } else if (i6 > 0) {
                int i7 = i5 >> 13;
                if ((i5 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0) {
                    i2 = (((i6 << 10) | i7) + 1) | (i3 << 15);
                    return (short) i2;
                }
                i = i7;
                r3 = i6;
            } else if (i6 >= -10) {
                int i8 = (i5 | AccessibilityEventCompat.TYPE_VIEW_CONTEXT_CLICKED) >> (1 - i6);
                if ((i8 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0) {
                    i8 += AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED;
                }
                i = i8 >> 13;
            } else {
                i = 0;
            }
        }
        i2 = i | (i3 << 15) | (r3 << 10);
        return (short) i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toCompareValue(short s) {
        return (s & 32768) != 0 ? AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUSED - (s & 65535) : s & 65535;
    }

    /* renamed from: getEpsilon-slo4al4, reason: not valid java name */
    public final short m1118getEpsilonslo4al4() {
        return Float16.access$getEpsilon$cp();
    }

    /* renamed from: getLowestValue-slo4al4, reason: not valid java name */
    public final short m1119getLowestValueslo4al4() {
        return Float16.access$getLowestValue$cp();
    }

    /* renamed from: getMaxValue-slo4al4, reason: not valid java name */
    public final short m1120getMaxValueslo4al4() {
        return Float16.access$getMaxValue$cp();
    }

    /* renamed from: getMinNormal-slo4al4, reason: not valid java name */
    public final short m1121getMinNormalslo4al4() {
        return Float16.access$getMinNormal$cp();
    }

    /* renamed from: getMinValue-slo4al4, reason: not valid java name */
    public final short m1122getMinValueslo4al4() {
        return Float16.access$getMinValue$cp();
    }

    /* renamed from: getNaN-slo4al4, reason: not valid java name */
    public final short m1123getNaNslo4al4() {
        return Float16.access$getNaN$cp();
    }

    /* renamed from: getNegativeInfinity-slo4al4, reason: not valid java name */
    public final short m1124getNegativeInfinityslo4al4() {
        return Float16.access$getNegativeInfinity$cp();
    }

    /* renamed from: getNegativeZero-slo4al4, reason: not valid java name */
    public final short m1125getNegativeZeroslo4al4() {
        return Float16.access$getNegativeZero$cp();
    }

    /* renamed from: getPositiveInfinity-slo4al4, reason: not valid java name */
    public final short m1126getPositiveInfinityslo4al4() {
        return Float16.access$getPositiveInfinity$cp();
    }

    /* renamed from: getPositiveZero-slo4al4, reason: not valid java name */
    public final short m1127getPositiveZeroslo4al4() {
        return Float16.access$getPositiveZero$cp();
    }
}
