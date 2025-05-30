package androidx.appcompat.resources;

import android.animation.ObjectAnimator;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(18)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class Compatibility$Api18Impl {
    private Compatibility$Api18Impl() {
    }

    @DoNotInline
    public static void setAutoCancel(@NonNull ObjectAnimator objectAnimator, boolean z) {
        objectAnimator.setAutoCancel(z);
    }
}
