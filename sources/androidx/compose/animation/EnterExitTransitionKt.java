package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment$Companion;
import androidx.compose.ui.Alignment$Horizontal;
import androidx.compose.ui.Alignment$Vertical;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class EnterExitTransitionKt {

    @NotNull
    private static final TwoWayConverter<TransformOrigin, AnimationVector2D> TransformOriginVectorConverter = VectorConvertersKt.TwoWayConverter(new Function1<TransformOrigin, AnimationVector2D>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m48invoke__ExYCQ(((TransformOrigin) obj).m1274unboximpl());
        }

        @NotNull
        /* renamed from: invoke-__ExYCQ, reason: not valid java name */
        public final AnimationVector2D m48invoke__ExYCQ(long j) {
            return new AnimationVector2D(TransformOrigin.m1270getPivotFractionXimpl(j), TransformOrigin.m1271getPivotFractionYimpl(j));
        }
    }, new Function1<AnimationVector2D, TransformOrigin>() { // from class: androidx.compose.animation.EnterExitTransitionKt$TransformOriginVectorConverter$2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return TransformOrigin.m1262boximpl(m49invokeLIALnN8((AnimationVector2D) obj));
        }

        /* renamed from: invoke-LIALnN8, reason: not valid java name */
        public final long m49invokeLIALnN8(@NotNull AnimationVector2D animationVector2D) {
            Intrinsics.checkNotNullParameter(animationVector2D, "it");
            return TransformOriginKt.TransformOrigin(animationVector2D.getV1(), animationVector2D.getV2());
        }
    });

    @NotNull
    private static final MutableState<Float> DefaultAlpha = SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);

    @NotNull
    private static final SpringSpec<Float> DefaultAlphaAndScaleSpring = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);

    @NotNull
    private static final SpringSpec<IntOffset> DefaultOffsetAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);

    @NotNull
    private static final SpringSpec<IntSize> DefaultSizeAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);

    /* JADX WARN: Removed duplicated region for block: B:106:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0524  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0579  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x048a  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x043f  */
    @androidx.compose.runtime.Composable
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.Modifier createModifier(@org.jetbrains.annotations.NotNull androidx.compose.animation.core.Transition<androidx.compose.animation.EnterExitState> r26, @org.jetbrains.annotations.NotNull final androidx.compose.animation.EnterTransition r27, @org.jetbrains.annotations.NotNull final androidx.compose.animation.ExitTransition r28, @org.jetbrains.annotations.NotNull java.lang.String r29, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r30, int r31) {
        /*
            Method dump skipped, instructions count: 1507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt.createModifier(androidx.compose.animation.core.Transition, androidx.compose.animation.EnterTransition, androidx.compose.animation.ExitTransition, java.lang.String, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }

    /* renamed from: createModifier$lambda-1, reason: not valid java name */
    private static final boolean m37createModifier$lambda1(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createModifier$lambda-11, reason: not valid java name */
    public static final float m38createModifier$lambda11(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createModifier$lambda-13, reason: not valid java name */
    public static final long m39createModifier$lambda13(State<TransformOrigin> state) {
        return ((TransformOrigin) state.getValue()).m1274unboximpl();
    }

    /* renamed from: createModifier$lambda-2, reason: not valid java name */
    private static final void m40createModifier$lambda2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* renamed from: createModifier$lambda-4, reason: not valid java name */
    private static final boolean m41createModifier$lambda4(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* renamed from: createModifier$lambda-5, reason: not valid java name */
    private static final void m42createModifier$lambda5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createModifier$lambda-8, reason: not valid java name */
    public static final float m43createModifier$lambda8(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    @Stable
    @NotNull
    public static final EnterTransition expandHorizontally(@NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, @NotNull Alignment$Horizontal alignment$Horizontal, boolean z, @NotNull final Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(alignment$Horizontal, "expandFrom");
        Intrinsics.checkNotNullParameter(function1, "initialWidth");
        return expandIn(finiteAnimationSpec, toAlignment(alignment$Horizontal), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.box-impl(m50invokemzRDjE0(((IntSize) obj).unbox-impl()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m50invokemzRDjE0(long j) {
                return IntSizeKt.IntSize(((Number) function1.invoke(Integer.valueOf(IntSize.getWidth-impl(j)))).intValue(), IntSize.getHeight-impl(j));
            }
        });
    }

    public static /* synthetic */ EnterTransition expandHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment$Horizontal alignment$Horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment$Horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandHorizontally$1
                @NotNull
                public final Integer invoke(int i2) {
                    return 0;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return expandHorizontally(finiteAnimationSpec, alignment$Horizontal, z, function1);
    }

    @Stable
    @NotNull
    public static final EnterTransition expandIn(@NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, @NotNull Alignment alignment, boolean z, @NotNull Function1<? super IntSize, IntSize> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(alignment, "expandFrom");
        Intrinsics.checkNotNullParameter(function1, "initialSize");
        return new EnterTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), null, 11, null));
    }

    public static /* synthetic */ EnterTransition expandIn$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = expandIn.1.INSTANCE;
        }
        return expandIn(finiteAnimationSpec, alignment, z, function1);
    }

    @Stable
    @NotNull
    public static final EnterTransition expandVertically(@NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, @NotNull Alignment$Vertical alignment$Vertical, boolean z, @NotNull final Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(alignment$Vertical, "expandFrom");
        Intrinsics.checkNotNullParameter(function1, "initialHeight");
        return expandIn(finiteAnimationSpec, toAlignment(alignment$Vertical), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.box-impl(m51invokemzRDjE0(((IntSize) obj).unbox-impl()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m51invokemzRDjE0(long j) {
                return IntSizeKt.IntSize(IntSize.getWidth-impl(j), ((Number) function1.invoke(Integer.valueOf(IntSize.getHeight-impl(j)))).intValue());
            }
        });
    }

    public static /* synthetic */ EnterTransition expandVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment$Vertical alignment$Vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment$Vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$expandVertically$1
                @NotNull
                public final Integer invoke(int i2) {
                    return 0;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return expandVertically(finiteAnimationSpec, alignment$Vertical, z, function1);
    }

    @Stable
    @NotNull
    public static final EnterTransition fadeIn(@NotNull FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), null, null, null, 14, null));
    }

    public static /* synthetic */ EnterTransition fadeIn$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeIn(finiteAnimationSpec, f);
    }

    @Stable
    @NotNull
    public static final ExitTransition fadeOut(@NotNull FiniteAnimationSpec<Float> finiteAnimationSpec, float f) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(new Fade(f, finiteAnimationSpec), null, null, null, 14, null));
    }

    public static /* synthetic */ ExitTransition fadeOut$default(FiniteAnimationSpec finiteAnimationSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        return fadeOut(finiteAnimationSpec, f);
    }

    @Stable
    @ExperimentalAnimationApi
    @NotNull
    /* renamed from: scaleIn-L8ZKh-E, reason: not valid java name */
    public static final EnterTransition m44scaleInL8ZKhE(@NotNull FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new EnterTransitionImpl(new TransitionData(null, null, null, new Scale(f, j, finiteAnimationSpec, (DefaultConstructorMarker) null), 7, null));
    }

    /* renamed from: scaleIn-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ EnterTransition m45scaleInL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.getCenter-SzJe1aQ();
        }
        return m44scaleInL8ZKhE(finiteAnimationSpec, f, j);
    }

    @Stable
    @ExperimentalAnimationApi
    @NotNull
    /* renamed from: scaleOut-L8ZKh-E, reason: not valid java name */
    public static final ExitTransition m46scaleOutL8ZKhE(@NotNull FiniteAnimationSpec<Float> finiteAnimationSpec, float f, long j) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return new ExitTransitionImpl(new TransitionData(null, null, null, new Scale(f, j, finiteAnimationSpec, (DefaultConstructorMarker) null), 7, null));
    }

    /* renamed from: scaleOut-L8ZKh-E$default, reason: not valid java name */
    public static /* synthetic */ ExitTransition m47scaleOutL8ZKhE$default(FiniteAnimationSpec finiteAnimationSpec, float f, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, (Object) null, 5, (Object) null);
        }
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            j = TransformOrigin.Companion.getCenter-SzJe1aQ();
        }
        return m46scaleOutL8ZKhE(finiteAnimationSpec, f, j);
    }

    private static final Modifier shrinkExpand(Modifier modifier, final Transition<EnterExitState> transition, final State<ChangeSize> state, final State<ChangeSize> state2, final String str) {
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* renamed from: invoke$lambda-1, reason: not valid java name */
            private static final boolean m52invoke$lambda1(MutableState<Boolean> mutableState) {
                return ((Boolean) mutableState.getValue()).booleanValue();
            }

            /* renamed from: invoke$lambda-2, reason: not valid java name */
            private static final void m53invoke$lambda2(MutableState<Boolean> mutableState, boolean z) {
                mutableState.setValue(Boolean.valueOf(z));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x00e9  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x011d  */
            /* JADX WARN: Removed duplicated region for block: B:29:0x013e  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x01a1  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x01d1  */
            /* JADX WARN: Removed duplicated region for block: B:53:0x01ed  */
            /* JADX WARN: Removed duplicated region for block: B:56:0x01a5  */
            /* JADX WARN: Removed duplicated region for block: B:63:0x011f  */
            @androidx.compose.runtime.Composable
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final androidx.compose.ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r21, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, int r23) {
                /*
                    Method dump skipped, instructions count: 518
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
            }
        }, 1, (Object) null);
    }

    @Stable
    @NotNull
    public static final ExitTransition shrinkHorizontally(@NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, @NotNull Alignment$Horizontal alignment$Horizontal, boolean z, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(alignment$Horizontal, "shrinkTowards");
        Intrinsics.checkNotNullParameter(function1, "targetWidth");
        return shrinkOut(finiteAnimationSpec, toAlignment(alignment$Horizontal), z, new shrinkHorizontally.2(function1));
    }

    public static /* synthetic */ ExitTransition shrinkHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Alignment$Horizontal alignment$Horizontal, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment$Horizontal = Alignment.Companion.getEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = shrinkHorizontally.1.INSTANCE;
        }
        return shrinkHorizontally(finiteAnimationSpec, alignment$Horizontal, z, function1);
    }

    @Stable
    @NotNull
    public static final ExitTransition shrinkOut(@NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, @NotNull Alignment alignment, boolean z, @NotNull Function1<? super IntSize, IntSize> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(alignment, "shrinkTowards");
        Intrinsics.checkNotNullParameter(function1, "targetSize");
        return new ExitTransitionImpl(new TransitionData(null, null, new ChangeSize(alignment, function1, finiteAnimationSpec, z), null, 11, null));
    }

    public static /* synthetic */ ExitTransition shrinkOut$default(FiniteAnimationSpec finiteAnimationSpec, Alignment alignment, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment = Alignment.Companion.getBottomEnd();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkOut$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return IntSize.box-impl(m54invokemzRDjE0(((IntSize) obj2).unbox-impl()));
                }

                /* renamed from: invoke-mzRDjE0, reason: not valid java name */
                public final long m54invokemzRDjE0(long j) {
                    return IntSizeKt.IntSize(0, 0);
                }
            };
        }
        return shrinkOut(finiteAnimationSpec, alignment, z, function1);
    }

    @Stable
    @NotNull
    public static final ExitTransition shrinkVertically(@NotNull FiniteAnimationSpec<IntSize> finiteAnimationSpec, @NotNull Alignment$Vertical alignment$Vertical, boolean z, @NotNull final Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(alignment$Vertical, "shrinkTowards");
        Intrinsics.checkNotNullParameter(function1, "targetHeight");
        return shrinkOut(finiteAnimationSpec, toAlignment(alignment$Vertical), z, new Function1<IntSize, IntSize>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntSize.box-impl(m55invokemzRDjE0(((IntSize) obj).unbox-impl()));
            }

            /* renamed from: invoke-mzRDjE0, reason: not valid java name */
            public final long m55invokemzRDjE0(long j) {
                return IntSizeKt.IntSize(IntSize.getWidth-impl(j), ((Number) function1.invoke(Integer.valueOf(IntSize.getHeight-impl(j)))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition shrinkVertically$default(FiniteAnimationSpec finiteAnimationSpec, Alignment$Vertical alignment$Vertical, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntSize.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntSize.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            alignment$Vertical = Alignment.Companion.getBottom();
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$shrinkVertically$1
                @NotNull
                public final Integer invoke(int i2) {
                    return 0;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return shrinkVertically(finiteAnimationSpec, alignment$Vertical, z, function1);
    }

    @Stable
    @NotNull
    public static final EnterTransition slideIn(@NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull Function1<? super IntSize, IntOffset> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "initialOffset");
        return new EnterTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, 13, null));
    }

    public static /* synthetic */ EnterTransition slideIn$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        return slideIn(finiteAnimationSpec, function1);
    }

    @Stable
    @NotNull
    public static final EnterTransition slideInHorizontally(@NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull final Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "initialOffsetX");
        return slideIn(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.box-impl(m56invokemHKZG7I(((IntSize) obj).unbox-impl()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m56invokemHKZG7I(long j) {
                return IntOffsetKt.IntOffset(((Number) function1.invoke(Integer.valueOf(IntSize.getWidth-impl(j)))).intValue(), 0);
            }
        });
    }

    public static /* synthetic */ EnterTransition slideInHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideInHorizontally$1
                @NotNull
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return slideInHorizontally(finiteAnimationSpec, function1);
    }

    private static final Modifier slideInOut(Modifier modifier, Transition<EnterExitState> transition, State<Slide> state, State<Slide> state2, String str) {
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new slideInOut.1(transition, state, state2, str), 1, (Object) null);
    }

    @Stable
    @NotNull
    public static final EnterTransition slideInVertically(@NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "initialOffsetY");
        return slideIn(finiteAnimationSpec, new slideInVertically.2(function1));
    }

    public static /* synthetic */ EnterTransition slideInVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = slideInVertically.1.INSTANCE;
        }
        return slideInVertically(finiteAnimationSpec, function1);
    }

    @Stable
    @NotNull
    public static final ExitTransition slideOut(@NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull Function1<? super IntSize, IntOffset> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "targetOffset");
        return new ExitTransitionImpl(new TransitionData(null, new Slide(function1, finiteAnimationSpec), null, null, 13, null));
    }

    public static /* synthetic */ ExitTransition slideOut$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        return slideOut(finiteAnimationSpec, function1);
    }

    @Stable
    @NotNull
    public static final ExitTransition slideOutHorizontally(@NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull final Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "targetOffsetX");
        return slideOut(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.box-impl(m57invokemHKZG7I(((IntSize) obj).unbox-impl()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m57invokemHKZG7I(long j) {
                return IntOffsetKt.IntOffset(((Number) function1.invoke(Integer.valueOf(IntSize.getWidth-impl(j)))).intValue(), 0);
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutHorizontally$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutHorizontally$1
                @NotNull
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return slideOutHorizontally(finiteAnimationSpec, function1);
    }

    @Stable
    @NotNull
    public static final ExitTransition slideOutVertically(@NotNull FiniteAnimationSpec<IntOffset> finiteAnimationSpec, @NotNull final Function1<? super Integer, Integer> function1) {
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(function1, "targetOffsetY");
        return slideOut(finiteAnimationSpec, new Function1<IntSize, IntOffset>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.box-impl(m58invokemHKZG7I(((IntSize) obj).unbox-impl()));
            }

            /* renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m58invokemHKZG7I(long j) {
                return IntOffsetKt.IntOffset(0, ((Number) function1.invoke(Integer.valueOf(IntSize.getHeight-impl(j)))).intValue());
            }
        });
    }

    public static /* synthetic */ ExitTransition slideOutVertically$default(FiniteAnimationSpec finiteAnimationSpec, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 400.0f, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 1, (Object) null);
        }
        if ((i & 2) != 0) {
            function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.animation.EnterExitTransitionKt$slideOutVertically$1
                @NotNull
                public final Integer invoke(int i2) {
                    return Integer.valueOf((-i2) / 2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        return slideOutVertically(finiteAnimationSpec, function1);
    }

    private static final Alignment toAlignment(Alignment$Horizontal alignment$Horizontal) {
        Alignment$Companion alignment$Companion = Alignment.Companion;
        return Intrinsics.areEqual(alignment$Horizontal, alignment$Companion.getStart()) ? alignment$Companion.getCenterStart() : Intrinsics.areEqual(alignment$Horizontal, alignment$Companion.getEnd()) ? alignment$Companion.getCenterEnd() : alignment$Companion.getCenter();
    }

    private static final Alignment toAlignment(Alignment$Vertical alignment$Vertical) {
        Alignment$Companion alignment$Companion = Alignment.Companion;
        return Intrinsics.areEqual(alignment$Vertical, alignment$Companion.getTop()) ? alignment$Companion.getTopCenter() : Intrinsics.areEqual(alignment$Vertical, alignment$Companion.getBottom()) ? alignment$Companion.getBottomCenter() : alignment$Companion.getCenter();
    }
}
