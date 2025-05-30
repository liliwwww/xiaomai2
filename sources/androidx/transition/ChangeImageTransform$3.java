package androidx.transition;

import android.widget.ImageView;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
/* synthetic */ class ChangeImageTransform$3 {
    static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

    static {
        int[] iArr = new int[ImageView.ScaleType.values().length];
        $SwitchMap$android$widget$ImageView$ScaleType = iArr;
        try {
            iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
