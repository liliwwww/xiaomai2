package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.PathEffect;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.Stroke;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final float StartAngleOffset = -90.0f;
    private static final float LinearIndicatorHeight = ProgressIndicatorDefaults.INSTANCE.m2175getStrokeWidthD9Ej5fM();
    private static final float LinearIndicatorWidth = C0856Dp.m5216constructorimpl(240);
    private static final float CircularIndicatorDiameter = C0856Dp.m5216constructorimpl(40);

    @NotNull
    private static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);

    @NotNull
    private static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);

    @NotNull
    private static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);

    @NotNull
    private static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);

    @NotNull
    private static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0059  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2176CircularProgressIndicatorMBs18nI(final float r21, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.Modifier r22, long r23, float r25, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.m2176CircularProgressIndicatorMBs18nI(float, androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2177CircularProgressIndicatoraMcp0Q(@org.jetbrains.annotations.Nullable androidx.compose.p004ui.Modifier r30, long r31, float r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.m2177CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-10, reason: not valid java name */
    public static final float m2178CircularProgressIndicator_aM_cp0Q$lambda10(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-11, reason: not valid java name */
    public static final float m2179CircularProgressIndicator_aM_cp0Q$lambda11(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-8, reason: not valid java name */
    public static final int m2180CircularProgressIndicator_aM_cp0Q$lambda8(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-9, reason: not valid java name */
    public static final float m2181CircularProgressIndicator_aM_cp0Q$lambda9(State<Float> state) {
        return state.getValue().floatValue();
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final void m2182LinearProgressIndicatorRIQooxk(@Nullable Modifier modifier, long j, long j2, @Nullable Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        Modifier modifier3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-819397058);
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i5 = 32;
                    i3 |= i5;
                }
            } else {
                j3 = j;
            }
            i5 = 16;
            i3 |= i5;
        } else {
            j3 = j;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i4 = 256;
                    i3 |= i4;
                }
            } else {
                j4 = j2;
            }
            i4 = 128;
            i3 |= i4;
        } else {
            j4 = j2;
        }
        if ((i3 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                modifier3 = i6 != 0 ? Modifier.Companion : modifier2;
                if ((i2 & 2) != 0) {
                    j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m2016getPrimary0d7_KjU();
                }
                if ((i2 & 4) != 0) {
                    j4 = Color.m2786copywmQWz5c$default(j3, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-819397058, i, -1, "androidx.compose.material.LinearProgressIndicator (ProgressIndicator.kt:100)");
            }
            InfiniteTransition rememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(startRestartGroup, 0);
            InfiniteRepeatableSpec m1048infiniteRepeatable9IiC70o$default = AnimationSpecKt.m1048infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframesSpecConfig, "$this$keyframes");
                    keyframesSpecConfig.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> m55at = keyframesSpecConfig.m55at(Float.valueOf(0.0f), 0);
                    cubicBezierEasing = ProgressIndicatorKt.FirstLineHeadEasing;
                    keyframesSpecConfig.with(m55at, cubicBezierEasing);
                    keyframesSpecConfig.m55at(Float.valueOf(1.0f), 750);
                }
            }), null, 0L, 6, null);
            int i7 = InfiniteTransition.$stable;
            int i8 = InfiniteRepeatableSpec.$stable;
            final State<Float> animateFloat = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, m1048infiniteRepeatable9IiC70o$default, startRestartGroup, i7 | 432 | (i8 << 9));
            final State<Float> animateFloat2 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m1048infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframesSpecConfig, "$this$keyframes");
                    keyframesSpecConfig.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> m55at = keyframesSpecConfig.m55at(Float.valueOf(0.0f), 333);
                    cubicBezierEasing = ProgressIndicatorKt.FirstLineTailEasing;
                    keyframesSpecConfig.with(m55at, cubicBezierEasing);
                    keyframesSpecConfig.m55at(Float.valueOf(1.0f), 1183);
                }
            }), null, 0L, 6, null), startRestartGroup, i7 | 432 | (i8 << 9));
            final State<Float> animateFloat3 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m1048infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframesSpecConfig, "$this$keyframes");
                    keyframesSpecConfig.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> m55at = keyframesSpecConfig.m55at(Float.valueOf(0.0f), 1000);
                    cubicBezierEasing = ProgressIndicatorKt.SecondLineHeadEasing;
                    keyframesSpecConfig.with(m55at, cubicBezierEasing);
                    keyframesSpecConfig.m55at(Float.valueOf(1.0f), 1567);
                }
            }), null, 0L, 6, null), startRestartGroup, i7 | 432 | (i8 << 9));
            final State<Float> animateFloat4 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m1048infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                    CubicBezierEasing cubicBezierEasing;
                    Intrinsics.checkNotNullParameter(keyframesSpecConfig, "$this$keyframes");
                    keyframesSpecConfig.setDurationMillis(1800);
                    KeyframesSpec.KeyframeEntity<Float> m55at = keyframesSpecConfig.m55at(Float.valueOf(0.0f), 1267);
                    cubicBezierEasing = ProgressIndicatorKt.SecondLineTailEasing;
                    keyframesSpecConfig.with(m55at, cubicBezierEasing);
                    keyframesSpecConfig.m55at(Float.valueOf(1.0f), 1800);
                }
            }), null, 0L, 6, null), startRestartGroup, i7 | 432 | (i8 << 9));
            Modifier m1439sizeVpY3zN4 = SizeKt.m1439sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(modifier3), LinearIndicatorWidth, LinearIndicatorHeight);
            Object[] objArr = {Color.m2777boximpl(j4), animateFloat, animateFloat2, Color.m2777boximpl(j3), animateFloat3, animateFloat4};
            startRestartGroup.startReplaceableGroup(-568225417);
            boolean z = false;
            for (int i9 = 0; i9 < 6; i9++) {
                z |= startRestartGroup.changed(objArr[i9]);
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                final long j5 = j4;
                final long j6 = j3;
                rememberedValue = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((DrawScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull DrawScope drawScope) {
                        float m2184LinearProgressIndicator_RIQooxk$lambda1;
                        float m2185LinearProgressIndicator_RIQooxk$lambda2;
                        float m2186LinearProgressIndicator_RIQooxk$lambda3;
                        float m2187LinearProgressIndicator_RIQooxk$lambda4;
                        float m2186LinearProgressIndicator_RIQooxk$lambda32;
                        float m2187LinearProgressIndicator_RIQooxk$lambda42;
                        float m2184LinearProgressIndicator_RIQooxk$lambda12;
                        float m2185LinearProgressIndicator_RIQooxk$lambda22;
                        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
                        float m2622getHeightimpl = Size.m2622getHeightimpl(drawScope.mo3205getSizeNHjbRc());
                        ProgressIndicatorKt.m2204drawLinearIndicatorBackgroundbw27NRU(drawScope, j5, m2622getHeightimpl);
                        m2184LinearProgressIndicator_RIQooxk$lambda1 = ProgressIndicatorKt.m2184LinearProgressIndicator_RIQooxk$lambda1(animateFloat);
                        m2185LinearProgressIndicator_RIQooxk$lambda2 = ProgressIndicatorKt.m2185LinearProgressIndicator_RIQooxk$lambda2(animateFloat2);
                        if (m2184LinearProgressIndicator_RIQooxk$lambda1 - m2185LinearProgressIndicator_RIQooxk$lambda2 > 0.0f) {
                            m2184LinearProgressIndicator_RIQooxk$lambda12 = ProgressIndicatorKt.m2184LinearProgressIndicator_RIQooxk$lambda1(animateFloat);
                            m2185LinearProgressIndicator_RIQooxk$lambda22 = ProgressIndicatorKt.m2185LinearProgressIndicator_RIQooxk$lambda2(animateFloat2);
                            ProgressIndicatorKt.m2203drawLinearIndicator42QJj7c(drawScope, m2184LinearProgressIndicator_RIQooxk$lambda12, m2185LinearProgressIndicator_RIQooxk$lambda22, j6, m2622getHeightimpl);
                        }
                        m2186LinearProgressIndicator_RIQooxk$lambda3 = ProgressIndicatorKt.m2186LinearProgressIndicator_RIQooxk$lambda3(animateFloat3);
                        m2187LinearProgressIndicator_RIQooxk$lambda4 = ProgressIndicatorKt.m2187LinearProgressIndicator_RIQooxk$lambda4(animateFloat4);
                        if (m2186LinearProgressIndicator_RIQooxk$lambda3 - m2187LinearProgressIndicator_RIQooxk$lambda4 > 0.0f) {
                            m2186LinearProgressIndicator_RIQooxk$lambda32 = ProgressIndicatorKt.m2186LinearProgressIndicator_RIQooxk$lambda3(animateFloat3);
                            m2187LinearProgressIndicator_RIQooxk$lambda42 = ProgressIndicatorKt.m2187LinearProgressIndicator_RIQooxk$lambda4(animateFloat4);
                            ProgressIndicatorKt.m2203drawLinearIndicator42QJj7c(drawScope, m2186LinearProgressIndicator_RIQooxk$lambda32, m2187LinearProgressIndicator_RIQooxk$lambda42, j6, m2622getHeightimpl);
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(m1439sizeVpY3zN4, (Function1) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final long j7 = j4;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier3;
        final long j8 = j3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i10) {
                ProgressIndicatorKt.m2182LinearProgressIndicatorRIQooxk(Modifier.this, j8, j7, composer2, i | 1, i2);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x005c  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2183LinearProgressIndicatoreaDK9VM(final float r16, @org.jetbrains.annotations.Nullable androidx.compose.p004ui.Modifier r17, long r18, long r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.m2183LinearProgressIndicatoreaDK9VM(float, androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-1, reason: not valid java name */
    public static final float m2184LinearProgressIndicator_RIQooxk$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-2, reason: not valid java name */
    public static final float m2185LinearProgressIndicator_RIQooxk$lambda2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-3, reason: not valid java name */
    public static final float m2186LinearProgressIndicator_RIQooxk$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-4, reason: not valid java name */
    public static final float m2187LinearProgressIndicator_RIQooxk$lambda4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m2200drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = 2;
        float width = stroke.getWidth() / f3;
        float m2625getWidthimpl = Size.m2625getWidthimpl(drawScope.mo3205getSizeNHjbRc()) - (f3 * width);
        w51.v(drawScope, j, f, f2, false, OffsetKt.Offset(width, width), androidx.compose.p004ui.geometry.SizeKt.Size(m2625getWidthimpl, m2625getWidthimpl), 0.0f, stroke, (ColorFilter) null, 0, 832, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m2201drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m2200drawCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    public static final void m2202drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        m2200drawCircularIndicator42QJj7c(drawScope, f + (((f2 / C0856Dp.m5216constructorimpl(CircularIndicatorDiameter / 2)) * 57.29578f) / 2.0f), Math.max(f3, 0.1f), j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-42QJj7c, reason: not valid java name */
    public static final void m2203drawLinearIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, float f3) {
        float m2625getWidthimpl = Size.m2625getWidthimpl(drawScope.mo3205getSizeNHjbRc());
        float m2622getHeightimpl = Size.m2622getHeightimpl(drawScope.mo3205getSizeNHjbRc()) / 2;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        w51.C(drawScope, j, OffsetKt.Offset((z ? f : 1.0f - f2) * m2625getWidthimpl, m2622getHeightimpl), OffsetKt.Offset((z ? f2 : 1.0f - f) * m2625getWidthimpl, m2622getHeightimpl), f3, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawLinearIndicatorBackground-bw27NRU, reason: not valid java name */
    public static final void m2204drawLinearIndicatorBackgroundbw27NRU(DrawScope drawScope, long j, float f) {
        m2203drawLinearIndicator42QJj7c(drawScope, 0.0f, 1.0f, j, f);
    }
}
