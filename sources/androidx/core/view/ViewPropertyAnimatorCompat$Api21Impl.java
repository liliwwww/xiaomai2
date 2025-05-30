package androidx.core.view;

import android.view.ViewPropertyAnimator;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(21)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ViewPropertyAnimatorCompat$Api21Impl {
    private ViewPropertyAnimatorCompat$Api21Impl() {
    }

    @DoNotInline
    static ViewPropertyAnimator translationZ(ViewPropertyAnimator viewPropertyAnimator, float f) {
        return viewPropertyAnimator.translationZ(f);
    }

    @DoNotInline
    static ViewPropertyAnimator translationZBy(ViewPropertyAnimator viewPropertyAnimator, float f) {
        return viewPropertyAnimator.translationZBy(f);
    }

    @DoNotInline
    static ViewPropertyAnimator z(ViewPropertyAnimator viewPropertyAnimator, float f) {
        return viewPropertyAnimator.z(f);
    }

    @DoNotInline
    static ViewPropertyAnimator zBy(ViewPropertyAnimator viewPropertyAnimator, float f) {
        return viewPropertyAnimator.zBy(f);
    }
}
