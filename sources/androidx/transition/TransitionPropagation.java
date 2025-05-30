package androidx.transition;

import android.view.ViewGroup;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class TransitionPropagation {
    public abstract void captureValues(TransitionValues transitionValues);

    public abstract String[] getPropagationProperties();

    public abstract long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2);
}
