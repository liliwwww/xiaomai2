package androidx.fragment.app;

import android.transition.Transition;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Taobao */
@RequiresApi(19)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class FragmentTransitionCompat21$Api19Impl {
    private FragmentTransitionCompat21$Api19Impl() {
    }

    static void addListener(@NonNull Transition transition, @NonNull Transition.TransitionListener transitionListener) {
        transition.addListener(transitionListener);
    }

    static void removeListener(@NonNull Transition transition, @NonNull Transition.TransitionListener transitionListener) {
        transition.removeListener(transitionListener);
    }
}
