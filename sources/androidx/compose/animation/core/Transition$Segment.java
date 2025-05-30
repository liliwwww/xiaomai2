package androidx.compose.animation.core;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface Transition$Segment<S> {
    S getInitialState();

    S getTargetState();

    boolean isTransitioningTo(S s, S s2);
}
