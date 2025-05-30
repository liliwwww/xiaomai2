package androidx.compose.ui.graphics.colorspace;

import android.taobao.windvane.connect.api.ApiConstants;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Connector$Companion$identity$1 extends Connector {
    Connector$Companion$identity$1(ColorSpace colorSpace, int i) {
        super(colorSpace, colorSpace, i, (DefaultConstructorMarker) null);
    }

    @NotNull
    public float[] transform(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, ApiConstants.V);
        return fArr;
    }

    /* renamed from: transformToColor-wmQWz5c$ui_graphics_release, reason: not valid java name */
    public long m1246transformToColorwmQWz5c$ui_graphics_release(float f, float f2, float f3, float f4) {
        return ColorKt.Color(f, f2, f3, f4, getDestination());
    }
}
