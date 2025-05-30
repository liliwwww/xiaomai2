package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class AnimatorUtils {
    private AnimatorUtils() {
    }

    static void addPauseListener(@NonNull Animator animator, @NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    static void pause(@NonNull Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                AnimatorPauseListenerCompat animatorPauseListenerCompat = (Animator.AnimatorListener) listeners.get(i);
                if (animatorPauseListenerCompat instanceof AnimatorPauseListenerCompat) {
                    animatorPauseListenerCompat.onAnimationPause(animator);
                }
            }
        }
    }

    static void resume(@NonNull Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                AnimatorPauseListenerCompat animatorPauseListenerCompat = (Animator.AnimatorListener) listeners.get(i);
                if (animatorPauseListenerCompat instanceof AnimatorPauseListenerCompat) {
                    animatorPauseListenerCompat.onAnimationResume(animator);
                }
            }
        }
    }
}
