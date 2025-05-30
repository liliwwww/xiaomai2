package androidx.compose.ui.unit;

import androidx.compose.runtime.Stable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VelocityKt {
    @Stable
    public static final long Velocity(float f, float f2) {
        return Velocity.m2704constructorimpl((Float.floatToIntBits(f2) & 4294967295L) | (Float.floatToIntBits(f) << 32));
    }
}
