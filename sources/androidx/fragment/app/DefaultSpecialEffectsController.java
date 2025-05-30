package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* compiled from: Taobao */
    private static class AnimationInfo extends SpecialEffectsInfo {

        @Nullable
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.mLoadedAnim = false;
            this.mIsPop = z;
        }

        @Nullable
        FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController$Operation$State.VISIBLE, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    static class SpecialEffectsInfo {

        @NonNull
        private final SpecialEffectsController.Operation mOperation;

        @NonNull
        private final CancellationSignal mSignal;

        SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @NonNull
        SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @NonNull
        CancellationSignal getSignal() {
            return this.mSignal;
        }

        boolean isVisibilityUnchanged() {
            SpecialEffectsController$Operation$State specialEffectsController$Operation$State;
            SpecialEffectsController$Operation$State from = SpecialEffectsController$Operation$State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController$Operation$State finalState = this.mOperation.getFinalState();
            return from == finalState || !(from == (specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.VISIBLE) || finalState == specialEffectsController$Operation$State);
        }
    }

    DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        int i;
        boolean z2;
        SpecialEffectsController.Operation operation;
        ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator<AnimationInfo> it = list.iterator();
        boolean z3 = false;
        while (true) {
            i = 2;
            if (!it.hasNext()) {
                break;
            }
            AnimationInfo next = it.next();
            if (next.isVisibilityUnchanged()) {
                next.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = next.getAnimation(context);
                if (animation == null) {
                    next.completeSpecialEffect();
                } else {
                    Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        SpecialEffectsController.Operation operation2 = next.getOperation();
                        Fragment fragment = operation2.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation2))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            next.completeSpecialEffect();
                        } else {
                            boolean z4 = operation2.getFinalState() == SpecialEffectsController$Operation$State.GONE;
                            if (z4) {
                                list2.remove(operation2);
                            }
                            View view = fragment.mView;
                            container.startViewTransition(view);
                            animator.addListener(new 2(this, container, view, z4, operation2, next));
                            animator.setTarget(view);
                            animator.start();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Animator from operation ");
                                operation = operation2;
                                sb.append(operation);
                                sb.append(" has started.");
                                Log.v("FragmentManager", sb.toString());
                            } else {
                                operation = operation2;
                            }
                            next.getSignal().setOnCancelListener(new 3(this, animator, operation));
                            z3 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            AnimationInfo animationInfo = (AnimationInfo) it2.next();
            SpecialEffectsController.Operation operation3 = animationInfo.getOperation();
            Fragment fragment2 = operation3.getFragment();
            if (z) {
                if (FragmentManager.isLoggingEnabled(i)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo.completeSpecialEffect();
            } else if (z3) {
                if (FragmentManager.isLoggingEnabled(i)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo.completeSpecialEffect();
            } else {
                View view2 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo.getAnimation(context))).animation);
                if (operation3.getFinalState() != SpecialEffectsController$Operation$State.REMOVED) {
                    view2.startAnimation(animation2);
                    animationInfo.completeSpecialEffect();
                    z2 = z3;
                } else {
                    container.startViewTransition(view2);
                    FragmentAnim$EndViewTransitionAnimation fragmentAnim$EndViewTransitionAnimation = new FragmentAnim$EndViewTransitionAnimation(animation2, container, view2);
                    z2 = z3;
                    fragmentAnim$EndViewTransitionAnimation.setAnimationListener(new 4(this, operation3, container, view2, animationInfo));
                    view2.startAnimation(fragmentAnim$EndViewTransitionAnimation);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Animation from operation " + operation3 + " has started.");
                    }
                }
                animationInfo.getSignal().setOnCancelListener(new 5(this, view2, container, animationInfo, operation3));
                i = 2;
                z3 = z2;
            }
        }
    }

    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(@NonNull List<TransitionInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z, @Nullable SpecialEffectsController.Operation operation, @Nullable SpecialEffectsController.Operation operation2) {
        String str;
        String str2;
        String str3;
        View view;
        Object obj;
        ArrayList arrayList;
        Object obj2;
        ArrayList arrayList2;
        Object obj3;
        SpecialEffectsController.Operation operation3;
        View view2;
        ArrayMap arrayMap;
        SpecialEffectsController.Operation operation4;
        SpecialEffectsController.Operation operation5;
        HashMap hashMap;
        ArrayList arrayList3;
        View view3;
        FragmentTransitionImpl fragmentTransitionImpl;
        ArrayList arrayList4;
        Rect rect;
        SharedElementCallback enterTransitionCallback;
        SharedElementCallback exitTransitionCallback;
        ArrayList arrayList5;
        int i;
        View view4;
        View view5;
        String findKeyForValue;
        ArrayList arrayList6;
        boolean z2 = z;
        SpecialEffectsController.Operation operation6 = operation;
        SpecialEffectsController.Operation operation7 = operation2;
        HashMap hashMap2 = new HashMap();
        FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl2 != handlingImpl) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            for (TransitionInfo transitionInfo2 : list) {
                hashMap2.put(transitionInfo2.getOperation(), Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            return hashMap2;
        }
        View view6 = new View(getContainer().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayMap arrayMap2 = new ArrayMap();
        Iterator<TransitionInfo> it = list.iterator();
        Object obj4 = null;
        View view7 = null;
        boolean z3 = false;
        while (true) {
            str = "FragmentManager";
            if (!it.hasNext()) {
                break;
            }
            TransitionInfo next = it.next();
            if (!next.hasSharedElementTransition() || operation6 == null || operation7 == null) {
                arrayMap = arrayMap2;
                operation4 = operation6;
                operation5 = operation7;
                hashMap = hashMap2;
                arrayList3 = arrayList7;
                view3 = view6;
                fragmentTransitionImpl = fragmentTransitionImpl2;
                arrayList4 = arrayList8;
                rect = rect2;
                view7 = view7;
            } else {
                Object wrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(next.getSharedElementTransition()));
                ArrayList sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                ArrayList sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                ArrayList sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                View view8 = view7;
                HashMap hashMap3 = hashMap2;
                int i2 = 0;
                while (i2 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i2));
                    ArrayList arrayList9 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, (String) sharedElementSourceNames2.get(i2));
                    }
                    i2++;
                    sharedElementTargetNames = arrayList9;
                }
                ArrayList sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                if (z2) {
                    enterTransitionCallback = operation.getFragment().getEnterTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getExitTransitionCallback();
                } else {
                    enterTransitionCallback = operation.getFragment().getExitTransitionCallback();
                    exitTransitionCallback = operation2.getFragment().getEnterTransitionCallback();
                }
                int size = sharedElementSourceNames.size();
                View view9 = view6;
                int i3 = 0;
                while (i3 < size) {
                    arrayMap2.put((String) sharedElementSourceNames.get(i3), (String) sharedElementTargetNames2.get(i3));
                    i3++;
                    size = size;
                    rect2 = rect2;
                }
                Rect rect3 = rect2;
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", ">>> entering view names <<<");
                    for (Iterator it2 = sharedElementTargetNames2.iterator(); it2.hasNext(); it2 = it2) {
                        Log.v("FragmentManager", "Name: " + ((String) it2.next()));
                    }
                    Log.v("FragmentManager", ">>> exiting view names <<<");
                    for (Iterator it3 = sharedElementSourceNames.iterator(); it3.hasNext(); it3 = it3) {
                        Log.v("FragmentManager", "Name: " + ((String) it3.next()));
                    }
                }
                ArrayMap<String, View> arrayMap3 = new ArrayMap<>();
                findNamedViews(arrayMap3, operation.getFragment().mView);
                arrayMap3.retainAll(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Executing exit callback for operation " + operation6);
                    }
                    enterTransitionCallback.onMapSharedElements(sharedElementSourceNames, arrayMap3);
                    int size2 = sharedElementSourceNames.size() - 1;
                    while (size2 >= 0) {
                        String str4 = (String) sharedElementSourceNames.get(size2);
                        View view10 = (View) arrayMap3.get(str4);
                        if (view10 == null) {
                            arrayMap2.remove(str4);
                            arrayList6 = sharedElementSourceNames;
                        } else {
                            arrayList6 = sharedElementSourceNames;
                            if (!str4.equals(ViewCompat.getTransitionName(view10))) {
                                arrayMap2.put(ViewCompat.getTransitionName(view10), (String) arrayMap2.remove(str4));
                            }
                        }
                        size2--;
                        sharedElementSourceNames = arrayList6;
                    }
                    arrayList5 = sharedElementSourceNames;
                } else {
                    arrayList5 = sharedElementSourceNames;
                    arrayMap2.retainAll(arrayMap3.keySet());
                }
                ArrayMap<String, View> arrayMap4 = new ArrayMap<>();
                findNamedViews(arrayMap4, operation2.getFragment().mView);
                arrayMap4.retainAll(sharedElementTargetNames2);
                arrayMap4.retainAll(arrayMap2.values());
                if (exitTransitionCallback != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Executing enter callback for operation " + operation7);
                    }
                    exitTransitionCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap4);
                    for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                        String str5 = (String) sharedElementTargetNames2.get(size3);
                        View view11 = (View) arrayMap4.get(str5);
                        if (view11 == null) {
                            String findKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap2, str5);
                            if (findKeyForValue2 != null) {
                                arrayMap2.remove(findKeyForValue2);
                            }
                        } else if (!str5.equals(ViewCompat.getTransitionName(view11)) && (findKeyForValue = FragmentTransition.findKeyForValue(arrayMap2, str5)) != null) {
                            arrayMap2.put(findKeyForValue, ViewCompat.getTransitionName(view11));
                        }
                    }
                } else {
                    FragmentTransition.retainValues(arrayMap2, arrayMap4);
                }
                retainMatchingViews(arrayMap3, arrayMap2.keySet());
                retainMatchingViews(arrayMap4, arrayMap2.values());
                if (arrayMap2.isEmpty()) {
                    arrayList7.clear();
                    arrayList8.clear();
                    arrayMap = arrayMap2;
                    arrayList4 = arrayList8;
                    operation4 = operation6;
                    operation5 = operation7;
                    arrayList3 = arrayList7;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    view7 = view8;
                    view3 = view9;
                    hashMap = hashMap3;
                    rect = rect3;
                    obj4 = null;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z2, arrayMap3, true);
                    arrayMap = arrayMap2;
                    ArrayList arrayList10 = arrayList8;
                    OneShotPreDrawListener.add(getContainer(), new 6(this, operation2, operation, z, arrayMap4));
                    arrayList7.addAll(arrayMap3.values());
                    if (arrayList5.isEmpty()) {
                        i = 0;
                        view7 = view8;
                    } else {
                        i = 0;
                        View view12 = (View) arrayMap3.get((String) arrayList5.get(0));
                        fragmentTransitionImpl2.setEpicenter(wrapTransitionInSet, view12);
                        view7 = view12;
                    }
                    arrayList10.addAll(arrayMap4.values());
                    if (sharedElementTargetNames2.isEmpty() || (view5 = (View) arrayMap4.get((String) sharedElementTargetNames2.get(i))) == null) {
                        rect = rect3;
                        view4 = view9;
                    } else {
                        rect = rect3;
                        OneShotPreDrawListener.add(getContainer(), new 7(this, fragmentTransitionImpl2, view5, rect));
                        view4 = view9;
                        z3 = true;
                    }
                    fragmentTransitionImpl2.setSharedElementTargets(wrapTransitionInSet, view4, arrayList7);
                    arrayList3 = arrayList7;
                    view3 = view4;
                    obj4 = wrapTransitionInSet;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    fragmentTransitionImpl2.scheduleRemoveTargets(wrapTransitionInSet, (Object) null, (ArrayList) null, (Object) null, (ArrayList) null, obj4, arrayList10);
                    Boolean bool = Boolean.TRUE;
                    operation4 = operation;
                    arrayList4 = arrayList10;
                    hashMap = hashMap3;
                    hashMap.put(operation4, bool);
                    operation5 = operation2;
                    hashMap.put(operation5, bool);
                }
            }
            rect2 = rect;
            arrayList7 = arrayList3;
            view6 = view3;
            arrayList8 = arrayList4;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
            z2 = z;
            operation7 = operation5;
            hashMap2 = hashMap;
            operation6 = operation4;
            arrayMap2 = arrayMap;
        }
        View view13 = view7;
        ArrayMap arrayMap5 = arrayMap2;
        SpecialEffectsController.Operation operation8 = operation6;
        SpecialEffectsController.Operation operation9 = operation7;
        HashMap hashMap4 = hashMap2;
        ArrayList arrayList11 = arrayList7;
        View view14 = view6;
        FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        ArrayList arrayList12 = arrayList8;
        Rect rect4 = rect2;
        ArrayList arrayList13 = new ArrayList();
        Object obj5 = null;
        Object obj6 = null;
        for (TransitionInfo transitionInfo3 : list) {
            if (transitionInfo3.isVisibilityUnchanged()) {
                hashMap4.put(transitionInfo3.getOperation(), Boolean.FALSE);
                transitionInfo3.completeSpecialEffect();
            } else {
                Object cloneTransition = fragmentTransitionImpl3.cloneTransition(transitionInfo3.getTransition());
                SpecialEffectsController.Operation operation10 = transitionInfo3.getOperation();
                boolean z4 = obj4 != null && (operation10 == operation8 || operation10 == operation9);
                if (cloneTransition == null) {
                    if (!z4) {
                        hashMap4.put(operation10, Boolean.FALSE);
                        transitionInfo3.completeSpecialEffect();
                    }
                    str3 = str;
                    arrayList = arrayList11;
                    view = view14;
                    arrayList2 = arrayList12;
                    obj = obj5;
                    view2 = view13;
                } else {
                    str3 = str;
                    ArrayList<View> arrayList14 = new ArrayList<>();
                    Object obj7 = obj5;
                    captureTransitioningViews(arrayList14, operation10.getFragment().mView);
                    if (z4) {
                        if (operation10 == operation8) {
                            arrayList14.removeAll(arrayList11);
                        } else {
                            arrayList14.removeAll(arrayList12);
                        }
                    }
                    if (arrayList14.isEmpty()) {
                        fragmentTransitionImpl3.addTarget(cloneTransition, view14);
                        arrayList = arrayList11;
                        view = view14;
                        arrayList2 = arrayList12;
                        operation3 = operation10;
                        obj2 = obj6;
                        obj3 = cloneTransition;
                        obj = obj7;
                    } else {
                        fragmentTransitionImpl3.addTargets(cloneTransition, arrayList14);
                        view = view14;
                        obj = obj7;
                        arrayList = arrayList11;
                        obj2 = obj6;
                        arrayList2 = arrayList12;
                        obj3 = cloneTransition;
                        fragmentTransitionImpl3.scheduleRemoveTargets(cloneTransition, cloneTransition, arrayList14, (Object) null, (ArrayList) null, (Object) null, (ArrayList) null);
                        if (operation10.getFinalState() == SpecialEffectsController$Operation$State.GONE) {
                            operation3 = operation10;
                            list2.remove(operation3);
                            ArrayList arrayList15 = new ArrayList(arrayList14);
                            arrayList15.remove(operation3.getFragment().mView);
                            fragmentTransitionImpl3.scheduleHideFragmentView(obj3, operation3.getFragment().mView, arrayList15);
                            OneShotPreDrawListener.add(getContainer(), new 8(this, arrayList14));
                        } else {
                            operation3 = operation10;
                        }
                    }
                    if (operation3.getFinalState() == SpecialEffectsController$Operation$State.VISIBLE) {
                        arrayList13.addAll(arrayList14);
                        if (z3) {
                            fragmentTransitionImpl3.setEpicenter(obj3, rect4);
                        }
                        view2 = view13;
                    } else {
                        view2 = view13;
                        fragmentTransitionImpl3.setEpicenter(obj3, view2);
                    }
                    hashMap4.put(operation3, Boolean.TRUE);
                    if (transitionInfo3.isOverlapAllowed()) {
                        obj2 = fragmentTransitionImpl3.mergeTransitionsTogether(obj2, obj3, (Object) null);
                    } else {
                        obj = fragmentTransitionImpl3.mergeTransitionsTogether(obj, obj3, (Object) null);
                    }
                    obj6 = obj2;
                }
                view13 = view2;
                obj5 = obj;
                str = str3;
                view14 = view;
                arrayList11 = arrayList;
                arrayList12 = arrayList2;
            }
        }
        String str6 = str;
        ArrayList arrayList16 = arrayList11;
        ArrayList arrayList17 = arrayList12;
        Object mergeTransitionsInSequence = fragmentTransitionImpl3.mergeTransitionsInSequence(obj6, obj5, obj4);
        if (mergeTransitionsInSequence == null) {
            return hashMap4;
        }
        for (TransitionInfo transitionInfo4 : list) {
            if (!transitionInfo4.isVisibilityUnchanged()) {
                Object transition = transitionInfo4.getTransition();
                SpecialEffectsController.Operation operation11 = transitionInfo4.getOperation();
                boolean z5 = obj4 != null && (operation11 == operation8 || operation11 == operation9);
                if (transition == null && !z5) {
                    str2 = str6;
                } else if (ViewCompat.isLaidOut(getContainer())) {
                    str2 = str6;
                    fragmentTransitionImpl3.setListenerForTransitionEnd(transitionInfo4.getOperation().getFragment(), mergeTransitionsInSequence, transitionInfo4.getSignal(), new 9(this, transitionInfo4, operation11));
                } else {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        str2 = str6;
                        Log.v(str2, "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + operation11);
                    } else {
                        str2 = str6;
                    }
                    transitionInfo4.completeSpecialEffect();
                }
                str6 = str2;
            }
        }
        String str7 = str6;
        if (!ViewCompat.isLaidOut(getContainer())) {
            return hashMap4;
        }
        FragmentTransition.setViewVisibility(arrayList13, 4);
        ArrayList prepareSetNameOverridesReordered = fragmentTransitionImpl3.prepareSetNameOverridesReordered(arrayList17);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(str7, ">>>>> Beginning transition <<<<<");
            Log.v(str7, ">>>>> SharedElementFirstOutViews <<<<<");
            Iterator it4 = arrayList16.iterator();
            while (it4.hasNext()) {
                View view15 = (View) it4.next();
                Log.v(str7, "View: " + view15 + " Name: " + ViewCompat.getTransitionName(view15));
            }
            Log.v(str7, ">>>>> SharedElementLastInViews <<<<<");
            Iterator it5 = arrayList17.iterator();
            while (it5.hasNext()) {
                View view16 = (View) it5.next();
                Log.v(str7, "View: " + view16 + " Name: " + ViewCompat.getTransitionName(view16));
            }
        }
        fragmentTransitionImpl3.beginDelayedTransition(getContainer(), mergeTransitionsInSequence);
        fragmentTransitionImpl3.setNameOverridesReordered(getContainer(), arrayList16, arrayList17, prepareSetNameOverridesReordered, arrayMap5);
        FragmentTransition.setViewVisibility(arrayList13, 0);
        fragmentTransitionImpl3.swapSharedElementTargets(obj4, arrayList16, arrayList17);
        return hashMap4;
    }

    private void syncAnimations(@NonNull List<SpecialEffectsController.Operation> list) {
        Fragment fragment = list.get(list.size() - 1).getFragment();
        for (SpecialEffectsController.Operation operation : list) {
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    void applyContainerChanges(@NonNull SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(arrayList, childAt);
            }
        }
    }

    void executeOperations(@NonNull List<SpecialEffectsController.Operation> list, boolean z) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController$Operation$State from = SpecialEffectsController$Operation$State.from(operation3.getFragment().mView);
            int i = 10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[operation3.getFinalState().ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                if (from == SpecialEffectsController$Operation$State.VISIBLE && operation == null) {
                    operation = operation3;
                }
            } else if (i == 4 && from != SpecialEffectsController$Operation$State.VISIBLE) {
                operation2 = operation3;
            }
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Executing operations from " + operation + " to " + operation2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        syncAnimations(list);
        for (SpecialEffectsController.Operation operation4 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(operation4, cancellationSignal, z));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal2);
            boolean z2 = false;
            if (z) {
                if (operation4 != operation) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                    operation4.addCompletionListener(new 1(this, arrayList3, operation4));
                }
                z2 = true;
                arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                operation4.addCompletionListener(new 1(this, arrayList3, operation4));
            } else {
                if (operation4 != operation2) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                    operation4.addCompletionListener(new 1(this, arrayList3, operation4));
                }
                z2 = true;
                arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z, z2));
                operation4.addCompletionListener(new 1(this, arrayList3, operation4));
            }
        }
        Map<SpecialEffectsController.Operation, Boolean> startTransitions = startTransitions(arrayList2, arrayList3, z, operation, operation2);
        startAnimations(arrayList, arrayList3, startTransitions.containsValue(Boolean.TRUE), startTransitions);
        Iterator<SpecialEffectsController.Operation> it = arrayList3.iterator();
        while (it.hasNext()) {
            applyContainerChanges(it.next());
        }
        arrayList3.clear();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + operation + " to " + operation2);
        }
    }

    void findNamedViews(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    void retainMatchingViews(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    /* compiled from: Taobao */
    private static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;

        @Nullable
        private final Object mSharedElementTransition;

        @Nullable
        private final Object mTransition;

        TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            if (operation.getFinalState() == SpecialEffectsController$Operation$State.VISIBLE) {
                this.mTransition = z ? operation.getFragment().getReenterTransition() : operation.getFragment().getEnterTransition();
                this.mOverlapAllowed = z ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
            } else {
                this.mTransition = z ? operation.getFragment().getReturnTransition() : operation.getFragment().getExitTransition();
                this.mOverlapAllowed = true;
            }
            if (!z2) {
                this.mSharedElementTransition = null;
            } else if (z) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        @Nullable
        FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @Nullable
        Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
