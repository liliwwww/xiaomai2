package androidx.compose.p004ui.graphics.colorspace;

import android.taobao.windvane.connect.api.ApiConstants;
import androidx.compose.p004ui.graphics.ColorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class Xyz extends ColorSpace {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Xyz(@NotNull String str, int i) {
        super(str, ColorModel.Companion.m3154getXyzxdoWZVw(), i, null);
        Intrinsics.checkNotNullParameter(str, "name");
    }

    private final float clamp(float f) {
        return RangesKt.coerceIn(f, -2.0f, 2.0f);
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] fromXyz(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, ApiConstants.f5V);
        fArr[0] = clamp(fArr[0]);
        fArr[1] = clamp(fArr[1]);
        fArr[2] = clamp(fArr[2]);
        return fArr;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float getMaxValue(int i) {
        return 2.0f;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float getMinValue(int i) {
        return -2.0f;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public boolean isWideGamut() {
        return true;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        float clamp = clamp(f);
        float clamp2 = clamp(f2);
        return (Float.floatToIntBits(clamp2) & 4294967295L) | (Float.floatToIntBits(clamp) << 32);
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    @NotNull
    public float[] toXyz(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, ApiConstants.f5V);
        fArr[0] = clamp(fArr[0]);
        fArr[1] = clamp(fArr[1]);
        fArr[2] = clamp(fArr[2]);
        return fArr;
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        return clamp(f3);
    }

    @Override // androidx.compose.p004ui.graphics.colorspace.ColorSpace
    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release */
    public long mo3156xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, @NotNull ColorSpace colorSpace) {
        Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
        return ColorKt.Color(clamp(f), clamp(f2), clamp(f3), f4, colorSpace);
    }
}
