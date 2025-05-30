package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(18)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class SwitchCompat$Api18Impl {
    private SwitchCompat$Api18Impl() {
    }

    @DoNotInline
    static void setAutoCancel(ObjectAnimator objectAnimator, boolean z) {
        objectAnimator.setAutoCancel(z);
    }
}
