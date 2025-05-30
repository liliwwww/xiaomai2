package androidx.compose.p004ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import androidx.compose.p004ui.tooling.animation.AnimatedVisibilityState;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class AnimatedVisibilityComposeAnimation implements ComposeAnimation {

    @NotNull
    private final Transition<Object> animationObject;

    @Nullable
    private final String label;

    @NotNull
    private final Set<AnimatedVisibilityState> states;

    @NotNull
    private final ComposeAnimationType type;

    public AnimatedVisibilityComposeAnimation(@NotNull Transition<Object> transition, @Nullable String str) {
        Intrinsics.checkNotNullParameter(transition, "parent");
        this.type = ComposeAnimationType.ANIMATED_VISIBILITY;
        this.animationObject = transition;
        AnimatedVisibilityState.Companion companion = AnimatedVisibilityState.Companion;
        this.states = SetsKt.setOf(new AnimatedVisibilityState[]{AnimatedVisibilityState.m5151boximpl(companion.m5158getEnterq9NwIk0()), AnimatedVisibilityState.m5151boximpl(companion.m5159getExitq9NwIk0())});
        this.label = str;
    }

    public static /* synthetic */ void getChildTransition$annotations() {
    }

    @Nullable
    public final Transition<Object> getChildTransition() {
        Object orNull = CollectionsKt.getOrNull(m5150getAnimationObject().getTransitions(), 0);
        if (orNull instanceof Transition) {
            return (Transition) orNull;
        }
        return null;
    }

    @Nullable
    public String getLabel() {
        return this.label;
    }

    @NotNull
    public Set<AnimatedVisibilityState> getStates() {
        return this.states;
    }

    @NotNull
    public ComposeAnimationType getType() {
        return this.type;
    }

    @NotNull
    /* renamed from: getAnimationObject, reason: merged with bridge method [inline-methods] */
    public Transition<Object> m5150getAnimationObject() {
        return this.animationObject;
    }
}
