package androidx.compose.p004ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class TransitionComposeAnimation implements ComposeAnimation {

    @NotNull
    private final Transition<Object> animationObject;

    @Nullable
    private final String label;

    @NotNull
    private final Set<Object> states;

    @NotNull
    private final ComposeAnimationType type;

    public TransitionComposeAnimation(@NotNull Transition<Object> transition, @NotNull Set<? extends Object> set, @Nullable String str) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        Intrinsics.checkNotNullParameter(set, "transitionStates");
        this.type = ComposeAnimationType.TRANSITION_ANIMATION;
        this.animationObject = transition;
        this.states = set;
        this.label = str;
    }

    @Nullable
    public String getLabel() {
        return this.label;
    }

    @NotNull
    public Set<Object> getStates() {
        return this.states;
    }

    @NotNull
    public ComposeAnimationType getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: getAnimationObject, reason: merged with bridge method [inline-methods] */
    public Transition<Object> m5169getAnimationObject() {
        return this.animationObject;
    }
}
