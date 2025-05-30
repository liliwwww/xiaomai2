package androidx.compose.foundation.layout;

import kotlin.ranges.RangesKt;

/* compiled from: Taobao */
/* renamed from: androidx.compose.foundation.layout.a */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0501a {
    /* renamed from: a */
    public static float m63a(SideCalculator _this, float f, float f2) {
        return RangesKt.coerceAtMost(_this.motionOf(f, f2), 0.0f);
    }

    /* renamed from: b */
    public static float m64b(SideCalculator _this, float f, float f2) {
        return RangesKt.coerceAtLeast(_this.motionOf(f, f2), 0.0f);
    }
}
