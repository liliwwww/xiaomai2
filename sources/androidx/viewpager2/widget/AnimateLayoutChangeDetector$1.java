package androidx.viewpager2.widget;

import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class AnimateLayoutChangeDetector$1 implements Comparator<int[]> {
    final /* synthetic */ AnimateLayoutChangeDetector this$0;

    AnimateLayoutChangeDetector$1(AnimateLayoutChangeDetector animateLayoutChangeDetector) {
        this.this$0 = animateLayoutChangeDetector;
    }

    @Override // java.util.Comparator
    public int compare(int[] iArr, int[] iArr2) {
        return iArr[0] - iArr2[0];
    }
}
