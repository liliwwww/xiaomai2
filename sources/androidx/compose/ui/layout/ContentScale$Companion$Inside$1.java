package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ContentScale$Companion$Inside$1 implements ContentScale {
    ContentScale$Companion$Inside$1() {
    }

    /* renamed from: computeScaleFactor-H7hwNQA, reason: not valid java name */
    public long m2050computeScaleFactorH7hwNQA(long j, long j2) {
        if (Size.getWidth-impl(j) <= Size.getWidth-impl(j2) && Size.getHeight-impl(j) <= Size.getHeight-impl(j2)) {
            return ScaleFactorKt.ScaleFactor(1.0f, 1.0f);
        }
        float f = ContentScaleKt.access$computeFillMinDimension-iLBOSCw(j, j2);
        return ScaleFactorKt.ScaleFactor(f, f);
    }
}
