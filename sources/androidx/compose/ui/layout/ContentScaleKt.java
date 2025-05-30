package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ContentScaleKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillHeight-iLBOSCw, reason: not valid java name */
    public static final float m1517computeFillHeightiLBOSCw(long j, long j2) {
        return Size.m900getHeightimpl(j2) / Size.m900getHeightimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillMaxDimension-iLBOSCw, reason: not valid java name */
    public static final float m1518computeFillMaxDimensioniLBOSCw(long j, long j2) {
        return Math.max(m1520computeFillWidthiLBOSCw(j, j2), m1517computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillMinDimension-iLBOSCw, reason: not valid java name */
    public static final float m1519computeFillMinDimensioniLBOSCw(long j, long j2) {
        return Math.min(m1520computeFillWidthiLBOSCw(j, j2), m1517computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillWidth-iLBOSCw, reason: not valid java name */
    public static final float m1520computeFillWidthiLBOSCw(long j, long j2) {
        return Size.m903getWidthimpl(j2) / Size.m903getWidthimpl(j);
    }
}
