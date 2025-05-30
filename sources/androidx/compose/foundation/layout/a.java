package androidx.compose.foundation.layout;

import kotlin.ranges.RangesKt;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final /* synthetic */ class a {
    public static float a(SideCalculator _this, float f, float f2) {
        return RangesKt.coerceAtMost(_this.motionOf(f, f2), 0.0f);
    }

    public static float b(SideCalculator _this, float f, float f2) {
        return RangesKt.coerceAtLeast(_this.motionOf(f, f2), 0.0f);
    }
}
