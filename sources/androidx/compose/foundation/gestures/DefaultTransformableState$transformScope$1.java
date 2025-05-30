package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class DefaultTransformableState$transformScope$1 implements TransformScope {
    final /* synthetic */ DefaultTransformableState this$0;

    DefaultTransformableState$transformScope$1(DefaultTransformableState defaultTransformableState) {
        this.this$0 = defaultTransformableState;
    }

    @Override // androidx.compose.foundation.gestures.TransformScope
    /* renamed from: transformBy-d-4ec7I, reason: not valid java name */
    public void mo163transformByd4ec7I(float f, long j, float f2) {
        this.this$0.getOnTransformation().invoke(Float.valueOf(f), Offset.m837boximpl(j), Float.valueOf(f2));
    }
}
