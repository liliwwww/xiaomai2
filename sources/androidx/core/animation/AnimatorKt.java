package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import androidx.core.animation.AnimatorKt$doOnEnd$;
import androidx.core.animation.AnimatorKt$doOnRepeat$;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AnimatorKt {
    @NotNull
    public static final Animator.AnimatorListener addListener(@NotNull Animator animator, @NotNull Function1<? super Animator, Unit> function1, @NotNull Function1<? super Animator, Unit> function12, @NotNull Function1<? super Animator, Unit> function13, @NotNull Function1<? super Animator, Unit> function14) {
        Intrinsics.checkNotNullParameter(animator, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onEnd");
        Intrinsics.checkNotNullParameter(function12, "onStart");
        Intrinsics.checkNotNullParameter(function13, "onCancel");
        Intrinsics.checkNotNullParameter(function14, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1<Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt$addListener$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Animator) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Animator animator2) {
                    Intrinsics.checkNotNullParameter(animator2, "it");
                }
            };
        }
        if ((i & 2) != 0) {
            function12 = new Function1<Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt$addListener$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Animator) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Animator animator2) {
                    Intrinsics.checkNotNullParameter(animator2, "it");
                }
            };
        }
        if ((i & 4) != 0) {
            function13 = new Function1<Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt$addListener$3
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Animator) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Animator animator2) {
                    Intrinsics.checkNotNullParameter(animator2, "it");
                }
            };
        }
        if ((i & 8) != 0) {
            function14 = new Function1<Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt$addListener$4
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((Animator) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Animator animator2) {
                    Intrinsics.checkNotNullParameter(animator2, "it");
                }
            };
        }
        Intrinsics.checkNotNullParameter(animator, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onEnd");
        Intrinsics.checkNotNullParameter(function12, "onStart");
        Intrinsics.checkNotNullParameter(function13, "onCancel");
        Intrinsics.checkNotNullParameter(function14, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener addPauseListener(@NotNull Animator animator, @NotNull Function1<? super Animator, Unit> function1, @NotNull Function1<? super Animator, Unit> function12) {
        Intrinsics.checkNotNullParameter(animator, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onResume");
        Intrinsics.checkNotNullParameter(function12, "onPause");
        addPauseListener.listener.1 r0 = new addPauseListener.listener.1(function12, function1);
        Api19Impl.addPauseListener(animator, r0);
        return r0;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = addPauseListener.1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = addPauseListener.2.INSTANCE;
        }
        return addPauseListener(animator, function1, function12);
    }

    @NotNull
    public static final Animator.AnimatorListener doOnCancel(@NotNull Animator animator, @NotNull final Function1<? super Animator, Unit> function1) {
        Intrinsics.checkNotNullParameter(animator, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
                function1.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @NotNull
    public static final Animator.AnimatorListener doOnEnd(@NotNull Animator animator, @NotNull Function1<? super Animator, Unit> function1) {
        Intrinsics.checkNotNullParameter(animator, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnEnd$.inlined.addListener.default.1 r0 = new AnimatorKt$doOnEnd$.inlined.addListener.default.1(function1);
        animator.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener doOnPause(@NotNull Animator animator, @NotNull Function1<? super Animator, Unit> function1) {
        Intrinsics.checkNotNullParameter(animator, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        return addPauseListener$default(animator, null, function1, 1, null);
    }

    @NotNull
    public static final Animator.AnimatorListener doOnRepeat(@NotNull Animator animator, @NotNull Function1<? super Animator, Unit> function1) {
        Intrinsics.checkNotNullParameter(animator, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnRepeat$.inlined.addListener.default.1 r0 = new AnimatorKt$doOnRepeat$.inlined.addListener.default.1(function1);
        animator.addListener(r0);
        return r0;
    }

    @RequiresApi(19)
    @NotNull
    public static final Animator.AnimatorPauseListener doOnResume(@NotNull Animator animator, @NotNull Function1<? super Animator, Unit> function1) {
        Intrinsics.checkNotNullParameter(animator, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        return addPauseListener$default(animator, function1, null, 2, null);
    }

    @NotNull
    public static final Animator.AnimatorListener doOnStart(@NotNull Animator animator, @NotNull final Function1<? super Animator, Unit> function1) {
        Intrinsics.checkNotNullParameter(animator, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(@NotNull Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(@NotNull Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(@NotNull Animator animator2) {
                Intrinsics.checkNotNullParameter(animator2, "animator");
                function1.invoke(animator2);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }
}
