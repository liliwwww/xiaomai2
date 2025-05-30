package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class SwipeableKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
    
        if (r3 < ((java.lang.Number) r6.invoke(java.lang.Float.valueOf(r0), java.lang.Float.valueOf(r5))).floatValue()) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005c, code lost:
    
        if (r3 > ((java.lang.Number) r6.invoke(java.lang.Float.valueOf(r5), java.lang.Float.valueOf(r0))).floatValue()) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final float computeTarget(float r3, float r4, java.util.Set<java.lang.Float> r5, kotlin.jvm.functions.Function2<? super java.lang.Float, ? super java.lang.Float, java.lang.Float> r6, float r7, float r8) {
        /*
            java.util.List r5 = findBounds(r3, r5)
            int r0 = r5.size()
            if (r0 == 0) goto L6c
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L62
            java.lang.Object r0 = r5.get(r1)
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            java.lang.Object r5 = r5.get(r2)
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 > 0) goto L42
            int r4 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r4 < 0) goto L2b
            return r5
        L2b:
            java.lang.Float r4 = java.lang.Float.valueOf(r0)
            java.lang.Float r7 = java.lang.Float.valueOf(r5)
            java.lang.Object r4 = r6.invoke(r4, r7)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L5e
            goto L60
        L42:
            float r4 = -r8
            int r4 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r4 > 0) goto L48
            return r0
        L48:
            java.lang.Float r4 = java.lang.Float.valueOf(r5)
            java.lang.Float r7 = java.lang.Float.valueOf(r0)
            java.lang.Object r4 = r6.invoke(r4, r7)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L60
        L5e:
            r4 = r5
            goto L6c
        L60:
            r4 = r0
            goto L6c
        L62:
            java.lang.Object r3 = r5.get(r1)
            java.lang.Number r3 = (java.lang.Number) r3
            float r4 = r3.floatValue()
        L6c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableKt.computeTarget(float, float, java.util.Set, kotlin.jvm.functions.Function2, float, float):float");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Float> findBounds(float f, Set<Float> set) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((double) ((Number) next).floatValue()) <= ((double) f) + 0.001d) {
                arrayList.add(next);
            }
        }
        Float maxOrNull = CollectionsKt.maxOrNull(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : set) {
            if (((double) ((Number) obj).floatValue()) >= ((double) f) - 0.001d) {
                arrayList2.add(obj);
            }
        }
        Float minOrNull = CollectionsKt.minOrNull(arrayList2);
        return maxOrNull == null ? CollectionsKt.listOfNotNull(minOrNull) : minOrNull == null ? CollectionsKt.listOf(maxOrNull) : Intrinsics.areEqual(maxOrNull, minOrNull) ? CollectionsKt.listOf(maxOrNull) : CollectionsKt.listOf(new Float[]{maxOrNull, minOrNull});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float getOffset(Map<Float, ? extends T> map, T t) {
        T t2;
        Iterator<T> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (Intrinsics.areEqual(((Map.Entry) t2).getValue(), t)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) t2;
        if (entry != null) {
            return (Float) entry.getKey();
        }
        return null;
    }

    @NotNull
    public static final <T> NestedScrollConnection getPreUpPostDownNestedScrollConnection(@NotNull SwipeableState<T> swipeableState) {
        Intrinsics.checkNotNullParameter(swipeableState, "<this>");
        return new SwipeableKt$PreUpPostDownNestedScrollConnection$1(swipeableState);
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getPreUpPostDownNestedScrollConnection$annotations(SwipeableState swipeableState) {
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final <T> SwipeableState<T> rememberSwipeableState(@NotNull final T t, @Nullable final AnimationSpec<Float> animationSpec, @Nullable final Function1<? super T, Boolean> function1, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(t, "initialValue");
        composer.startReplaceableGroup(-1237755169);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<T, Boolean>() { // from class: androidx.compose.material.SwipeableKt$rememberSwipeableState$1
                @NotNull
                public final Boolean invoke(@NotNull T t2) {
                    Intrinsics.checkNotNullParameter(t2, "it");
                    return Boolean.TRUE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m2255invoke(Object obj) {
                    return invoke((SwipeableKt$rememberSwipeableState$1<T>) obj);
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1237755169, i, -1, "androidx.compose.material.rememberSwipeableState (Swipeable.kt:467)");
        }
        SwipeableState<T> swipeableState = (SwipeableState) RememberSaveableKt.m2434rememberSaveable(new Object[0], (Saver) SwipeableState.Companion.Saver(animationSpec, function1), (String) null, (Function0) new Function0<SwipeableState<T>>() { // from class: androidx.compose.material.SwipeableKt$rememberSwipeableState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SwipeableState<T> m2256invoke() {
                return new SwipeableState<>(t, animationSpec, function1);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return swipeableState;
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final <T> SwipeableState<T> rememberSwipeableStateFor(@NotNull final T t, @NotNull final Function1<? super T, Unit> function1, @Nullable AnimationSpec<Float> animationSpec, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(t, "value");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        composer.startReplaceableGroup(1156387078);
        if ((i2 & 4) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1156387078, i, -1, "androidx.compose.material.rememberSwipeableStateFor (Swipeable.kt:496)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new SwipeableState(t, animationSpec, new Function1<T, Boolean>() { // from class: androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1
                @NotNull
                public final Boolean invoke(@NotNull T t2) {
                    Intrinsics.checkNotNullParameter(t2, "it");
                    return Boolean.TRUE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m2257invoke(Object obj) {
                    return invoke((SwipeableKt$rememberSwipeableStateFor$swipeableState$1$1<T>) obj);
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final SwipeableState<T> swipeableState = (SwipeableState) rememberedValue;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue2;
        int i3 = i & 8;
        EffectsKt.LaunchedEffect(t, mutableState.getValue(), new SwipeableKt$rememberSwipeableStateFor$1(t, swipeableState, null), composer, (i & 14) | i3 | 512);
        EffectsKt.DisposableEffect(swipeableState.getCurrentValue(), new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                if (!Intrinsics.areEqual(t, swipeableState.getCurrentValue())) {
                    function1.invoke(swipeableState.getCurrentValue());
                    mutableState.setValue(Boolean.valueOf(!r2.getValue().booleanValue()));
                }
                return new DisposableEffectResult() { // from class: androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }
        }, composer, i3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return swipeableState;
    }

    @ExperimentalMaterialApi
    @NotNull
    /* renamed from: swipeable-pPrIpRY, reason: not valid java name */
    public static final <T> Modifier m2253swipeablepPrIpRY(@NotNull Modifier modifier, @NotNull final SwipeableState<T> swipeableState, @NotNull final Map<Float, ? extends T> map, @NotNull final Orientation orientation, final boolean z, final boolean z2, @Nullable final MutableInteractionSource mutableInteractionSource, @NotNull final Function2<? super T, ? super T, ? extends ThresholdConfig> function2, @Nullable final ResistanceConfig resistanceConfig, final float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$swipeable");
        Intrinsics.checkNotNullParameter(swipeableState, "state");
        Intrinsics.checkNotNullParameter(map, "anchors");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(function2, "thresholds");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("swipeable");
                inspectorInfo.getProperties().set("state", SwipeableState.this);
                inspectorInfo.getProperties().set("anchors", map);
                inspectorInfo.getProperties().set("orientation", orientation);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(z2));
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set("thresholds", function2);
                inspectorInfo.getProperties().set("resistance", resistanceConfig);
                inspectorInfo.getProperties().set("velocityThreshold", C0856Dp.m5214boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.SwipeableKt$swipeable$3

            /* compiled from: Taobao */
            @DebugMetadata(c = "androidx.compose.material.SwipeableKt$swipeable$3$3", f = "Swipeable.kt", i = {}, l = {TypedValues.MotionType.TYPE_PATHMOTION_ARC}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material.SwipeableKt$swipeable$3$3 */
            /* loaded from: classes2.dex */
            static final class C07093 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Map<Float, T> $anchors;
                final /* synthetic */ Density $density;
                final /* synthetic */ ResistanceConfig $resistance;
                final /* synthetic */ SwipeableState<T> $state;
                final /* synthetic */ Function2<T, T, ThresholdConfig> $thresholds;
                final /* synthetic */ float $velocityThreshold;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C07093(SwipeableState<T> swipeableState, Map<Float, ? extends T> map, ResistanceConfig resistanceConfig, Density density, Function2<? super T, ? super T, ? extends ThresholdConfig> function2, float f, Continuation<? super C07093> continuation) {
                    super(2, continuation);
                    this.$state = swipeableState;
                    this.$anchors = map;
                    this.$resistance = resistanceConfig;
                    this.$density = density;
                    this.$thresholds = function2;
                    this.$velocityThreshold = f;
                }

                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new C07093(this.$state, this.$anchors, this.$resistance, this.$density, this.$thresholds, this.$velocityThreshold, continuation);
                }

                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Map anchors$material_release = this.$state.getAnchors$material_release();
                        this.$state.setAnchors$material_release(this.$anchors);
                        this.$state.setResistance$material_release(this.$resistance);
                        SwipeableState<T> swipeableState = this.$state;
                        final Map<Float, T> map = this.$anchors;
                        final Function2<T, T, ThresholdConfig> function2 = this.$thresholds;
                        final Density density = this.$density;
                        swipeableState.setThresholds$material_release(new Function2<Float, Float, Float>() { // from class: androidx.compose.material.SwipeableKt.swipeable.3.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                return invoke(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                            }

                            @NotNull
                            public final Float invoke(float f, float f2) {
                                return Float.valueOf(((ThresholdConfig) function2.invoke(MapsKt.getValue(map, Float.valueOf(f)), MapsKt.getValue(map, Float.valueOf(f2)))).computeThreshold(density, f, f2));
                            }
                        });
                        this.$state.setVelocityThreshold$material_release(this.$density.mo1283toPx0680j_4(this.$velocityThreshold));
                        SwipeableState<T> swipeableState2 = this.$state;
                        Object obj2 = this.$anchors;
                        this.label = 1;
                        if (swipeableState2.processNewAnchors$material_release(anchors$material_release, obj2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x009b, code lost:
            
                if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L16;
             */
            @androidx.compose.runtime.Composable
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final androidx.compose.p004ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.Modifier r25, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r26, int r27) {
                /*
                    r24 = this;
                    r0 = r24
                    r1 = r26
                    java.lang.String r2 = "$this$composed"
                    r3 = r25
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
                    r2 = 43594985(0x29934e9, float:2.2511698E-37)
                    r1.startReplaceableGroup(r2)
                    boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r3 == 0) goto L1f
                    r3 = -1
                    java.lang.String r4 = "androidx.compose.material.swipeable.<anonymous> (Swipeable.kt:585)"
                    r5 = r27
                    androidx.compose.runtime.ComposerKt.traceEventStart(r2, r5, r3, r4)
                L1f:
                    java.util.Map<java.lang.Float, T> r2 = r1
                    boolean r2 = r2.isEmpty()
                    r3 = 1
                    r2 = r2 ^ r3
                    if (r2 == 0) goto Ld6
                    java.util.Map<java.lang.Float, T> r2 = r1
                    java.util.Collection r2 = r2.values()
                    java.util.List r2 = kotlin.collections.CollectionsKt.distinct(r2)
                    int r2 = r2.size()
                    java.util.Map<java.lang.Float, T> r4 = r1
                    int r4 = r4.size()
                    if (r2 != r4) goto L40
                    goto L41
                L40:
                    r3 = 0
                L41:
                    if (r3 == 0) goto Lca
                    androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.p004ui.platform.CompositionLocalsKt.getLocalDensity()
                    java.lang.Object r2 = r1.consume(r2)
                    r7 = r2
                    androidx.compose.ui.unit.Density r7 = (androidx.compose.p004ui.unit.Density) r7
                    androidx.compose.material.SwipeableState<T> r2 = r2
                    java.util.Map<java.lang.Float, T> r3 = r1
                    r2.ensureInit$material_release(r3)
                    java.util.Map<java.lang.Float, T> r2 = r1
                    androidx.compose.material.SwipeableState<T> r11 = r2
                    androidx.compose.material.SwipeableKt$swipeable$3$3 r12 = new androidx.compose.material.SwipeableKt$swipeable$3$3
                    androidx.compose.material.ResistanceConfig r6 = r7
                    kotlin.jvm.functions.Function2<T, T, androidx.compose.material.ThresholdConfig> r8 = r8
                    float r9 = r9
                    r10 = 0
                    r3 = r12
                    r4 = r11
                    r5 = r2
                    r3.<init>(r4, r5, r6, r7, r8, r9, r10)
                    r3 = 520(0x208, float:7.29E-43)
                    androidx.compose.runtime.EffectsKt.LaunchedEffect(r2, r11, r12, r1, r3)
                    androidx.compose.ui.Modifier$Companion r13 = androidx.compose.p004ui.Modifier.Companion
                    androidx.compose.material.SwipeableState<T> r2 = r2
                    boolean r18 = r2.isAnimationRunning()
                    androidx.compose.material.SwipeableState<T> r2 = r2
                    androidx.compose.foundation.gestures.DraggableState r14 = r2.getDraggableState$material_release()
                    androidx.compose.foundation.gestures.Orientation r15 = r3
                    boolean r2 = r4
                    androidx.compose.foundation.interaction.MutableInteractionSource r3 = r5
                    r19 = 0
                    androidx.compose.material.SwipeableState<T> r4 = r2
                    r5 = 1157296644(0x44faf204, float:2007.563)
                    r1.startReplaceableGroup(r5)
                    boolean r5 = r1.changed(r4)
                    java.lang.Object r6 = r26.rememberedValue()
                    if (r5 != 0) goto L9d
                    androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r5 = r5.getEmpty()
                    if (r6 != r5) goto La6
                L9d:
                    androidx.compose.material.SwipeableKt$swipeable$3$4$1 r6 = new androidx.compose.material.SwipeableKt$swipeable$3$4$1
                    r5 = 0
                    r6.<init>(r4, r5)
                    r1.updateRememberedValue(r6)
                La6:
                    r26.endReplaceableGroup()
                    r20 = r6
                    kotlin.jvm.functions.Function3 r20 = (kotlin.jvm.functions.Function3) r20
                    boolean r4 = r6
                    r22 = 32
                    r23 = 0
                    r16 = r2
                    r17 = r3
                    r21 = r4
                    androidx.compose.ui.Modifier r2 = androidx.compose.foundation.gestures.DraggableKt.draggable$default(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
                    boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                    if (r3 == 0) goto Lc6
                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                Lc6:
                    r26.endReplaceableGroup()
                    return r2
                Lca:
                    java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                    java.lang.String r2 = "You cannot have two anchors mapped to the same state."
                    java.lang.String r2 = r2.toString()
                    r1.<init>(r2)
                    throw r1
                Ld6:
                    java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                    java.lang.String r2 = "You must have at least one anchor."
                    java.lang.String r2 = r2.toString()
                    r1.<init>(r2)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableKt$swipeable$3.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
            }
        });
    }
}
