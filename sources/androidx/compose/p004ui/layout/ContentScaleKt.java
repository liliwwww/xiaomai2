package androidx.compose.p004ui.layout;

import androidx.compose.p004ui.geometry.Size;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ContentScaleKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillHeight-iLBOSCw, reason: not valid java name */
    public static final float m4183computeFillHeightiLBOSCw(long j, long j2) {
        return Size.m2622getHeightimpl(j2) / Size.m2622getHeightimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillMaxDimension-iLBOSCw, reason: not valid java name */
    public static final float m4184computeFillMaxDimensioniLBOSCw(long j, long j2) {
        return Math.max(m4186computeFillWidthiLBOSCw(j, j2), m4183computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillMinDimension-iLBOSCw, reason: not valid java name */
    public static final float m4185computeFillMinDimensioniLBOSCw(long j, long j2) {
        return Math.min(m4186computeFillWidthiLBOSCw(j, j2), m4183computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillWidth-iLBOSCw, reason: not valid java name */
    public static final float m4186computeFillWidthiLBOSCw(long j, long j2) {
        return Size.m2625getWidthimpl(j2) / Size.m2625getWidthimpl(j);
    }
}
