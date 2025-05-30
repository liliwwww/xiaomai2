package androidx.compose.ui.tooling.animation;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationKt;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.DecayAnimation;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimatedProperty;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import androidx.compose.animation.tooling.TransitionInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class PreviewAnimationClock {
    private final boolean DEBUG;

    @NotNull
    private final String TAG;

    @NotNull
    private final UnsupportedComposeAnimationSubscriber<Object> animateContentSizeSubscriber;

    @NotNull
    private final UnsupportedComposeAnimationSubscriber<Animatable<?, ?>> animateXAsStateSubscriber;

    @NotNull
    private final UnsupportedComposeAnimationSubscriber<Transition<?>> animatedContentSubscriber;

    @NotNull
    private final HashMap<Transition<Object>, AnimatedVisibilityState> animatedVisibilityStates;

    @NotNull
    private final Object animatedVisibilityStatesLock;

    @NotNull
    private final UnsupportedComposeAnimationSubscriber<DecayAnimation<?, ?>> decayAnimationSubscriber;

    @NotNull
    private final UnsupportedComposeAnimationSubscriber<InfiniteTransition> infiniteTransitionSubscriber;

    @NotNull
    private final Function0<Unit> setAnimationsTimeCallback;

    @NotNull
    private final UnsupportedComposeAnimationSubscriber<TargetBasedAnimation<?, ?>> targetBasedAnimationSubscriber;

    @NotNull
    private final LinkedHashSet<AnimatedVisibilityComposeAnimation> trackedAnimatedVisibility;

    @NotNull
    private final LinkedHashSet<TransitionComposeAnimation> trackedTransitions;

    @NotNull
    private final LinkedHashSet<UnsupportedComposeAnimation> trackedUnsupported;

    @NotNull
    private final HashMap<Transition<Object>, TransitionState> transitionStates;

    @NotNull
    private final Object transitionStatesLock;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PreviewAnimationClock() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.animation.PreviewAnimationClock.<init>():void");
    }

    public PreviewAnimationClock(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "setAnimationsTimeCallback");
        this.setAnimationsTimeCallback = function0;
        this.TAG = "PreviewAnimationClock";
        this.trackedTransitions = new LinkedHashSet<>();
        this.trackedAnimatedVisibility = new LinkedHashSet<>();
        this.trackedUnsupported = new LinkedHashSet<>();
        this.transitionStates = new HashMap<>();
        this.transitionStatesLock = new Object();
        this.animatedVisibilityStates = new HashMap<>();
        this.animatedVisibilityStatesLock = new Object();
        this.animateXAsStateSubscriber = new UnsupportedComposeAnimationSubscriber<>(this);
        this.animateContentSizeSubscriber = new UnsupportedComposeAnimationSubscriber<>(this);
        this.targetBasedAnimationSubscriber = new UnsupportedComposeAnimationSubscriber<>(this);
        this.decayAnimationSubscriber = new UnsupportedComposeAnimationSubscriber<>(this);
        this.animatedContentSubscriber = new UnsupportedComposeAnimationSubscriber<>(this);
        this.infiniteTransitionSubscriber = new UnsupportedComposeAnimationSubscriber<>(this);
    }

    private final List<Transition<?>.TransitionAnimationState<?, ?>> allAnimations(Transition<?> transition) {
        List<Transition<?>> transitions = transition.getTransitions();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = transitions.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, allAnimations((Transition) it.next()));
        }
        return CollectionsKt.plus(transition.getAnimations(), arrayList);
    }

    private final <T, V extends AnimationVector, S> TransitionInfo createTransitionInfo(Transition<S>.TransitionAnimationState<T, V> transitionAnimationState, long j) {
        long nanosToMillis = nanosToMillis(transitionAnimationState.getAnimation().getDurationNanos());
        Lazy lazy = LazyKt.lazy(new createTransitionInfo.startTimeMs.2(transitionAnimationState));
        Lazy lazy2 = LazyKt.lazy(new createTransitionInfo.values.2(transitionAnimationState, this, nanosToMillis, j, lazy));
        String label = transitionAnimationState.getLabel();
        String name = transitionAnimationState.getAnimationSpec().getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "this.animationSpec.javaClass.name");
        return new TransitionInfo(label, name, m2552createTransitionInfo$lambda21(lazy), nanosToMillis, m2553createTransitionInfo$lambda22(lazy2));
    }

    static /* synthetic */ TransitionInfo createTransitionInfo$default(PreviewAnimationClock previewAnimationClock, Transition.TransitionAnimationState transitionAnimationState, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createTransitionInfo");
        }
        if ((i & 1) != 0) {
            j = 1;
        }
        return previewAnimationClock.createTransitionInfo(transitionAnimationState, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTransitionInfo$lambda-21, reason: not valid java name */
    public static final long m2552createTransitionInfo$lambda21(Lazy<Long> lazy) {
        return ((Number) lazy.getValue()).longValue();
    }

    /* renamed from: createTransitionInfo$lambda-22, reason: not valid java name */
    private static final <T> Map<Long, T> m2553createTransitionInfo$lambda22(Lazy<? extends Map<Long, T>> lazy) {
        return (Map) lazy.getValue();
    }

    @VisibleForTesting
    public static /* synthetic */ void getAnimatedVisibilityStates$ui_tooling_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTrackedAnimatedVisibility$ui_tooling_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTrackedTransitions$ui_tooling_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTrackedUnsupported$ui_tooling_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getTransitionStates$ui_tooling_release$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long millisToNanos(long j) {
        return j * AnimationKt.MillisToNanos;
    }

    private final long nanosToMillis(long j) {
        return (j + 999999) / 1000000;
    }

    /* renamed from: toCurrentTargetPair-RvB7uIg, reason: not valid java name */
    private final Pair<Boolean, Boolean> m2554toCurrentTargetPairRvB7uIg(String str) {
        Boolean bool;
        Boolean bool2;
        if (AnimatedVisibilityState.equals-impl0(str, AnimatedVisibilityState.Companion.getEnter-q9NwIk0())) {
            bool = Boolean.FALSE;
            bool2 = Boolean.TRUE;
        } else {
            bool = Boolean.TRUE;
            bool2 = Boolean.FALSE;
        }
        return TuplesKt.to(bool, bool2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackAnimatedVisibility$default(PreviewAnimationClock previewAnimationClock, Transition transition, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackAnimatedVisibility");
        }
        if ((i & 2) != 0) {
            function0 = trackAnimatedVisibility.1.INSTANCE;
        }
        previewAnimationClock.trackAnimatedVisibility(transition, function0);
    }

    public final void dispose() {
        Iterator<T> it = this.trackedTransitions.iterator();
        while (it.hasNext()) {
            notifyUnsubscribe((ComposeAnimation) ((TransitionComposeAnimation) it.next()));
        }
        Iterator<T> it2 = this.trackedAnimatedVisibility.iterator();
        while (it2.hasNext()) {
            notifyUnsubscribe((ComposeAnimation) ((AnimatedVisibilityComposeAnimation) it2.next()));
        }
        Iterator<T> it3 = this.trackedUnsupported.iterator();
        while (it3.hasNext()) {
            notifyUnsubscribe((UnsupportedComposeAnimation) it3.next());
        }
        this.trackedAnimatedVisibility.clear();
        this.trackedTransitions.clear();
        this.animatedVisibilityStates.clear();
        this.transitionStates.clear();
        this.trackedUnsupported.clear();
        this.animatedContentSubscriber.clear();
        this.animateXAsStateSubscriber.clear();
        this.targetBasedAnimationSubscriber.clear();
        this.decayAnimationSubscriber.clear();
        this.animateContentSizeSubscriber.clear();
        this.infiniteTransitionSubscriber.clear();
    }

    @NotNull
    public final List<ComposeAnimatedProperty> getAnimatedProperties(@NotNull ComposeAnimation composeAnimation) {
        Transition<?> childTransition;
        Intrinsics.checkNotNullParameter(composeAnimation, "animation");
        if (CollectionsKt.contains(this.trackedTransitions, composeAnimation)) {
            List<Transition<?>.TransitionAnimationState<?, ?>> allAnimations = allAnimations(((TransitionComposeAnimation) composeAnimation).getAnimationObject());
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = allAnimations.iterator();
            while (it.hasNext()) {
                Transition.TransitionAnimationState transitionAnimationState = (Transition.TransitionAnimationState) it.next();
                String label = transitionAnimationState.getLabel();
                Object value = transitionAnimationState.getValue();
                ComposeAnimatedProperty composeAnimatedProperty = value == null ? null : new ComposeAnimatedProperty(label, value);
                if (composeAnimatedProperty != null) {
                    arrayList.add(composeAnimatedProperty);
                }
            }
            return arrayList;
        }
        if (!CollectionsKt.contains(this.trackedAnimatedVisibility, composeAnimation) || (childTransition = ((AnimatedVisibilityComposeAnimation) composeAnimation).getChildTransition()) == null) {
            return CollectionsKt.emptyList();
        }
        List<Transition<?>.TransitionAnimationState<?, ?>> allAnimations2 = allAnimations(childTransition);
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = allAnimations2.iterator();
        while (it2.hasNext()) {
            Transition.TransitionAnimationState transitionAnimationState2 = (Transition.TransitionAnimationState) it2.next();
            String label2 = transitionAnimationState2.getLabel();
            Object value2 = transitionAnimationState2.getValue();
            ComposeAnimatedProperty composeAnimatedProperty2 = value2 == null ? null : new ComposeAnimatedProperty(label2, value2);
            if (composeAnimatedProperty2 != null) {
                arrayList2.add(composeAnimatedProperty2);
            }
        }
        return arrayList2;
    }

    @NotNull
    /* renamed from: getAnimatedVisibilityState-zrx7VqY, reason: not valid java name */
    public final String m2555getAnimatedVisibilityStatezrx7VqY(@NotNull AnimatedVisibilityComposeAnimation animatedVisibilityComposeAnimation) {
        Intrinsics.checkNotNullParameter(animatedVisibilityComposeAnimation, "composeAnimation");
        AnimatedVisibilityState animatedVisibilityState = this.animatedVisibilityStates.get(animatedVisibilityComposeAnimation.getAnimationObject());
        String str = animatedVisibilityState != null ? animatedVisibilityState.unbox-impl() : null;
        return str == null ? AnimatedVisibilityState.Companion.getEnter-q9NwIk0() : str;
    }

    @NotNull
    public final HashMap<Transition<Object>, AnimatedVisibilityState> getAnimatedVisibilityStates$ui_tooling_release() {
        return this.animatedVisibilityStates;
    }

    public final long getMaxDuration() {
        LinkedHashSet<TransitionComposeAnimation> linkedHashSet = this.trackedTransitions;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet, 10));
        Iterator<T> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(nanosToMillis(((TransitionComposeAnimation) it.next()).getAnimationObject().getTotalDurationNanos())));
        }
        Long l = (Long) CollectionsKt.maxOrNull(arrayList);
        long longValue = l != null ? l.longValue() : -1L;
        LinkedHashSet<AnimatedVisibilityComposeAnimation> linkedHashSet2 = this.trackedAnimatedVisibility;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet2, 10));
        Iterator<T> it2 = linkedHashSet2.iterator();
        while (it2.hasNext()) {
            Transition childTransition = ((AnimatedVisibilityComposeAnimation) it2.next()).getChildTransition();
            arrayList2.add(Long.valueOf(childTransition != null ? nanosToMillis(childTransition.getTotalDurationNanos()) : -1L));
        }
        Long l2 = (Long) CollectionsKt.maxOrNull(arrayList2);
        return Math.max(longValue, l2 != null ? l2.longValue() : -1L);
    }

    public final long getMaxDurationPerIteration() {
        LinkedHashSet<TransitionComposeAnimation> linkedHashSet = this.trackedTransitions;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet, 10));
        Iterator<T> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(nanosToMillis(((TransitionComposeAnimation) it.next()).getAnimationObject().getTotalDurationNanos())));
        }
        Long l = (Long) CollectionsKt.maxOrNull(arrayList);
        long longValue = l != null ? l.longValue() : -1L;
        LinkedHashSet<AnimatedVisibilityComposeAnimation> linkedHashSet2 = this.trackedAnimatedVisibility;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(linkedHashSet2, 10));
        Iterator<T> it2 = linkedHashSet2.iterator();
        while (it2.hasNext()) {
            Transition childTransition = ((AnimatedVisibilityComposeAnimation) it2.next()).getChildTransition();
            arrayList2.add(Long.valueOf(childTransition != null ? nanosToMillis(childTransition.getTotalDurationNanos()) : -1L));
        }
        Long l2 = (Long) CollectionsKt.maxOrNull(arrayList2);
        return Math.max(longValue, l2 != null ? l2.longValue() : -1L);
    }

    @NotNull
    public final LinkedHashSet<AnimatedVisibilityComposeAnimation> getTrackedAnimatedVisibility$ui_tooling_release() {
        return this.trackedAnimatedVisibility;
    }

    @NotNull
    public final LinkedHashSet<TransitionComposeAnimation> getTrackedTransitions$ui_tooling_release() {
        return this.trackedTransitions;
    }

    @NotNull
    public final LinkedHashSet<UnsupportedComposeAnimation> getTrackedUnsupported$ui_tooling_release() {
        return this.trackedUnsupported;
    }

    @NotNull
    public final HashMap<Transition<Object>, TransitionState> getTransitionStates$ui_tooling_release() {
        return this.transitionStates;
    }

    @NotNull
    public final List<TransitionInfo> getTransitions(@NotNull ComposeAnimation composeAnimation, long j) {
        Transition<?> childTransition;
        Intrinsics.checkNotNullParameter(composeAnimation, "animation");
        if (CollectionsKt.contains(this.trackedTransitions, composeAnimation)) {
            List<Transition<?>.TransitionAnimationState<?, ?>> allAnimations = allAnimations(((TransitionComposeAnimation) composeAnimation).getAnimationObject());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(allAnimations, 10));
            Iterator<T> it = allAnimations.iterator();
            while (it.hasNext()) {
                arrayList.add(createTransitionInfo((Transition.TransitionAnimationState) it.next(), j));
            }
            return arrayList;
        }
        if (!CollectionsKt.contains(this.trackedAnimatedVisibility, composeAnimation) || (childTransition = ((AnimatedVisibilityComposeAnimation) composeAnimation).getChildTransition()) == null) {
            return CollectionsKt.emptyList();
        }
        List<Transition<?>.TransitionAnimationState<?, ?>> allAnimations2 = allAnimations(childTransition);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(allAnimations2, 10));
        Iterator<T> it2 = allAnimations2.iterator();
        while (it2.hasNext()) {
            arrayList2.add(createTransitionInfo((Transition.TransitionAnimationState) it2.next(), j));
        }
        return arrayList2;
    }

    @VisibleForTesting
    protected void notifySubscribe(@NotNull ComposeAnimation composeAnimation) {
        Intrinsics.checkNotNullParameter(composeAnimation, "animation");
    }

    @VisibleForTesting
    protected void notifyUnsubscribe(@NotNull ComposeAnimation composeAnimation) {
        Intrinsics.checkNotNullParameter(composeAnimation, "animation");
    }

    public final void setClockTime(long j) {
        Set plus = SetsKt.plus(this.trackedTransitions, this.trackedAnimatedVisibility);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(plus, 10)), 16));
        for (Object obj : plus) {
            linkedHashMap.put(obj, Long.valueOf(j));
        }
        setClockTimes(linkedHashMap);
    }

    public final void setClockTimes(@NotNull Map<ComposeAnimation, Long> map) {
        Intrinsics.checkNotNullParameter(map, "animationTimeMillis");
        for (Map.Entry<ComposeAnimation, Long> entry : map.entrySet()) {
            AnimatedVisibilityComposeAnimation animatedVisibilityComposeAnimation = (ComposeAnimation) entry.getKey();
            long nanos = TimeUnit.MILLISECONDS.toNanos(entry.getValue().longValue());
            if (CollectionsKt.contains(this.trackedTransitions, animatedVisibilityComposeAnimation)) {
                Intrinsics.checkNotNull(animatedVisibilityComposeAnimation, "null cannot be cast to non-null type androidx.compose.ui.tooling.animation.TransitionComposeAnimation");
                Transition animationObject = ((TransitionComposeAnimation) animatedVisibilityComposeAnimation).getAnimationObject();
                TransitionState transitionState = this.transitionStates.get(animationObject);
                if (transitionState != null) {
                    Intrinsics.checkNotNullExpressionValue(transitionState, "transitionStates[it] ?: return@let");
                    animationObject.seek(transitionState.getCurrent(), transitionState.getTarget(), nanos);
                }
            } else if (CollectionsKt.contains(this.trackedAnimatedVisibility, animatedVisibilityComposeAnimation)) {
                Intrinsics.checkNotNull(animatedVisibilityComposeAnimation, "null cannot be cast to non-null type androidx.compose.ui.tooling.animation.AnimatedVisibilityComposeAnimation");
                Transition animationObject2 = animatedVisibilityComposeAnimation.getAnimationObject();
                AnimatedVisibilityState animatedVisibilityState = this.animatedVisibilityStates.get(animationObject2);
                String str = animatedVisibilityState != null ? animatedVisibilityState.unbox-impl() : null;
                if (str != null) {
                    Intrinsics.checkNotNullExpressionValue(AnimatedVisibilityState.box-impl(str), "animatedVisibilityStates[it]");
                    Pair<Boolean, Boolean> m2554toCurrentTargetPairRvB7uIg = m2554toCurrentTargetPairRvB7uIg(str);
                    if (m2554toCurrentTargetPairRvB7uIg != null) {
                        animationObject2.seek(Boolean.valueOf(((Boolean) m2554toCurrentTargetPairRvB7uIg.component1()).booleanValue()), Boolean.valueOf(((Boolean) m2554toCurrentTargetPairRvB7uIg.component2()).booleanValue()), nanos);
                    }
                }
            }
        }
        this.setAnimationsTimeCallback.invoke();
    }

    public final void trackAnimateContentSize(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "sizeAnimationModifier");
        this.animateContentSizeSubscriber.trackAnimation(obj, "animateContentSize");
    }

    public final void trackAnimateXAsState(@NotNull Animatable<?, ?> animatable) {
        Intrinsics.checkNotNullParameter(animatable, "animatable");
        this.animateXAsStateSubscriber.trackAnimation(animatable, animatable.getLabel());
    }

    public final void trackAnimatedContent(@NotNull Transition<?> transition) {
        Intrinsics.checkNotNullParameter(transition, "animatedContent");
        this.animatedContentSubscriber.trackAnimation(transition, "AnimatedContent");
    }

    public final void trackAnimatedVisibility(@NotNull Transition<Object> transition, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(transition, "parent");
        Intrinsics.checkNotNullParameter(function0, "onSeek");
        synchronized (this.animatedVisibilityStatesLock) {
            if (this.animatedVisibilityStates.containsKey(transition)) {
                if (this.DEBUG) {
                    Log.d(this.TAG, "AnimatedVisibility transition " + transition + " is already being tracked");
                }
                return;
            }
            HashMap<Transition<Object>, AnimatedVisibilityState> hashMap = this.animatedVisibilityStates;
            Object currentState = transition.getCurrentState();
            Intrinsics.checkNotNull(currentState, "null cannot be cast to non-null type kotlin.Boolean");
            hashMap.put(transition, AnimatedVisibilityState.box-impl(((Boolean) currentState).booleanValue() ? AnimatedVisibilityState.Companion.getExit-q9NwIk0() : AnimatedVisibilityState.Companion.getEnter-q9NwIk0()));
            Unit unit = Unit.INSTANCE;
            if (this.DEBUG) {
                Log.d(this.TAG, "AnimatedVisibility transition " + transition + " is now tracked");
            }
            AnimatedVisibilityComposeAnimation parseAnimatedVisibility = ComposeAnimationParserKt.parseAnimatedVisibility(transition);
            AnimatedVisibilityState animatedVisibilityState = this.animatedVisibilityStates.get(transition);
            Intrinsics.checkNotNull(animatedVisibilityState);
            Pair<Boolean, Boolean> m2554toCurrentTargetPairRvB7uIg = m2554toCurrentTargetPairRvB7uIg(animatedVisibilityState.unbox-impl());
            transition.seek(Boolean.valueOf(((Boolean) m2554toCurrentTargetPairRvB7uIg.component1()).booleanValue()), Boolean.valueOf(((Boolean) m2554toCurrentTargetPairRvB7uIg.component2()).booleanValue()), 0L);
            function0.invoke();
            this.trackedAnimatedVisibility.add(parseAnimatedVisibility);
            notifySubscribe((ComposeAnimation) parseAnimatedVisibility);
        }
    }

    public final void trackDecayAnimations(@NotNull DecayAnimation<?, ?> decayAnimation) {
        Intrinsics.checkNotNullParameter(decayAnimation, "decayAnimation");
        this.decayAnimationSubscriber.trackAnimation(decayAnimation, "DecayAnimation");
    }

    public final void trackInfiniteTransition(@NotNull InfiniteTransition infiniteTransition) {
        Intrinsics.checkNotNullParameter(infiniteTransition, "infiniteTransition");
        this.infiniteTransitionSubscriber.trackAnimation(infiniteTransition, "InfiniteTransition");
    }

    public final void trackTargetBasedAnimations(@NotNull TargetBasedAnimation<?, ?> targetBasedAnimation) {
        Intrinsics.checkNotNullParameter(targetBasedAnimation, "targetBasedAnimation");
        this.targetBasedAnimationSubscriber.trackAnimation(targetBasedAnimation, "TargetBasedAnimation");
    }

    public final void trackTransition(@NotNull Transition<Object> transition) {
        Intrinsics.checkNotNullParameter(transition, "transition");
        synchronized (this.transitionStatesLock) {
            if (this.transitionStates.containsKey(transition)) {
                if (this.DEBUG) {
                    Log.d(this.TAG, "Transition " + transition + " is already being tracked");
                }
                return;
            }
            this.transitionStates.put(transition, new TransitionState(transition.getCurrentState(), transition.getTargetState()));
            Unit unit = Unit.INSTANCE;
            if (this.DEBUG) {
                Log.d(this.TAG, "Transition " + transition + " is now tracked");
            }
            TransitionComposeAnimation parse = ComposeAnimationParserKt.parse(transition);
            this.trackedTransitions.add(parse);
            notifySubscribe((ComposeAnimation) parse);
        }
    }

    public final void updateAnimatedVisibilityState(@NotNull AnimatedVisibilityComposeAnimation animatedVisibilityComposeAnimation, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(animatedVisibilityComposeAnimation, "composeAnimation");
        Intrinsics.checkNotNullParameter(obj, "state");
        if (this.trackedAnimatedVisibility.contains(animatedVisibilityComposeAnimation)) {
            synchronized (this.animatedVisibilityStatesLock) {
                this.animatedVisibilityStates.put(animatedVisibilityComposeAnimation.getAnimationObject(), (AnimatedVisibilityState) obj);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void updateFromAndToStates(@NotNull ComposeAnimation composeAnimation, @NotNull Object obj, @NotNull Object obj2) {
        Intrinsics.checkNotNullParameter(composeAnimation, "composeAnimation");
        Intrinsics.checkNotNullParameter(obj, "fromState");
        Intrinsics.checkNotNullParameter(obj2, "toState");
        if (composeAnimation.getType() == ComposeAnimationType.TRANSITION_ANIMATION && CollectionsKt.contains(this.trackedTransitions, composeAnimation)) {
            TransitionComposeAnimation transitionComposeAnimation = (TransitionComposeAnimation) composeAnimation;
            synchronized (this.transitionStatesLock) {
                this.transitionStates.put(transitionComposeAnimation.getAnimationObject(), new TransitionState(obj, obj2));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public /* synthetic */ PreviewAnimationClock(Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.INSTANCE : function0);
    }
}
