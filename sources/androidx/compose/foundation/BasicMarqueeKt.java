package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class BasicMarqueeKt {
    private static final int DefaultMarqueeDelayMillis = 1200;
    private static final int DefaultMarqueeIterations = 3;

    @NotNull
    private static final MarqueeSpacing DefaultMarqueeSpacing = MarqueeSpacing.Companion.fractionOfContainer(0.33333334f);
    private static final float DefaultMarqueeVelocity = C0856Dp.m5216constructorimpl(30);

    @ExperimentalFoundationApi
    @NotNull
    /* renamed from: MarqueeSpacing-0680j_4, reason: not valid java name */
    public static final MarqueeSpacing m1117MarqueeSpacing0680j_4(final float f) {
        return new MarqueeSpacing() { // from class: androidx.compose.foundation.BasicMarqueeKt$MarqueeSpacing$1
            @Override // androidx.compose.foundation.MarqueeSpacing
            public final int calculateSpacing(@NotNull Density density, int i, int i2) {
                Intrinsics.checkNotNullParameter(density, "$this$MarqueeSpacing");
                return density.mo1277roundToPx0680j_4(f);
            }
        };
    }

    @ExperimentalFoundationApi
    @NotNull
    /* renamed from: basicMarquee-1Mj1MLw, reason: not valid java name */
    public static final Modifier m1119basicMarquee1Mj1MLw(@NotNull Modifier modifier, final int i, final int i2, final int i3, final int i4, @NotNull final MarqueeSpacing marqueeSpacing, final float f) {
        Intrinsics.checkNotNullParameter(modifier, "$this$basicMarquee");
        Intrinsics.checkNotNullParameter(marqueeSpacing, "spacing");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.BasicMarqueeKt$basicMarquee-1Mj1MLw$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("basicMarquee");
                inspectorInfo.getProperties().set("iterations", Integer.valueOf(i));
                inspectorInfo.getProperties().set("animationMode", MarqueeAnimationMode.m1177boximpl(i2));
                inspectorInfo.getProperties().set("delayMillis", Integer.valueOf(i3));
                inspectorInfo.getProperties().set("initialDelayMillis", Integer.valueOf(i4));
                inspectorInfo.getProperties().set("spacing", marqueeSpacing);
                inspectorInfo.getProperties().set("velocity", C0856Dp.m5214boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.BasicMarqueeKt$basicMarquee$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(-562302205);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-562302205, i5, -1, "androidx.compose.foundation.basicMarquee.<anonymous> (BasicMarquee.kt:147)");
                }
                Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                Object obj = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(i4), C0856Dp.m5214boximpl(f), density, obj};
                int i6 = i;
                int i7 = i3;
                int i8 = i4;
                float f2 = f;
                composer.startReplaceableGroup(-568225417);
                boolean z = false;
                for (int i9 = 0; i9 < 6; i9++) {
                    z |= composer.changed(objArr[i9]);
                }
                Object rememberedValue = composer.rememberedValue();
                if (z || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new MarqueeModifier(i6, i7, i8, C0856Dp.m5216constructorimpl(f2 * (obj == LayoutDirection.Ltr ? 1.0f : -1.0f)), density, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                MarqueeModifier marqueeModifier = (MarqueeModifier) rememberedValue;
                marqueeModifier.setSpacing(marqueeSpacing);
                marqueeModifier.m1189setAnimationMode97h66l8(i2);
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(marqueeModifier);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new BasicMarqueeKt$basicMarquee$2$1$1(marqueeModifier, null);
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceableGroup();
                EffectsKt.LaunchedEffect(marqueeModifier, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, composer, 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return marqueeModifier;
            }
        });
    }

    /* renamed from: basicMarquee-1Mj1MLw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1120basicMarquee1Mj1MLw$default(Modifier modifier, int i, int i2, int i3, int i4, MarqueeSpacing marqueeSpacing, float f, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = DefaultMarqueeIterations;
        }
        if ((i5 & 2) != 0) {
            i2 = MarqueeAnimationMode.Companion.m1186getImmediatelyZbEOnfQ();
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = DefaultMarqueeDelayMillis;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = MarqueeAnimationMode.m1180equalsimpl0(i6, MarqueeAnimationMode.Companion.m1186getImmediatelyZbEOnfQ()) ? i7 : 0;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            marqueeSpacing = DefaultMarqueeSpacing;
        }
        MarqueeSpacing marqueeSpacing2 = marqueeSpacing;
        if ((i5 & 32) != 0) {
            f = DefaultMarqueeVelocity;
        }
        return m1119basicMarquee1Mj1MLw(modifier, i, i6, i7, i8, marqueeSpacing2, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createMarqueeAnimationSpec-Z4HSEVQ, reason: not valid java name */
    public static final AnimationSpec<Float> m1121createMarqueeAnimationSpecZ4HSEVQ(int i, float f, int i2, int i3, float f2, Density density) {
        TweenSpec<Float> velocityBasedTween = velocityBasedTween(Math.abs(density.mo1283toPx0680j_4(f2)), f, i3);
        long m1071constructorimpl$default = StartOffset.m1071constructorimpl$default((-i3) + i2, 0, 2, null);
        return i == Integer.MAX_VALUE ? AnimationSpecKt.m1048infiniteRepeatable9IiC70o$default(velocityBasedTween, null, m1071constructorimpl$default, 2, null) : AnimationSpecKt.m1050repeatable91I0pcU$default(i, velocityBasedTween, null, m1071constructorimpl$default, 4, null);
    }

    @ExperimentalFoundationApi
    public static final int getDefaultMarqueeDelayMillis() {
        return DefaultMarqueeDelayMillis;
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getDefaultMarqueeDelayMillis$annotations() {
    }

    @ExperimentalFoundationApi
    public static final int getDefaultMarqueeIterations() {
        return DefaultMarqueeIterations;
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getDefaultMarqueeIterations$annotations() {
    }

    @ExperimentalFoundationApi
    @NotNull
    public static final MarqueeSpacing getDefaultMarqueeSpacing() {
        return DefaultMarqueeSpacing;
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getDefaultMarqueeSpacing$annotations() {
    }

    @ExperimentalFoundationApi
    public static final float getDefaultMarqueeVelocity() {
        return DefaultMarqueeVelocity;
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getDefaultMarqueeVelocity$annotations() {
    }

    private static final TweenSpec<Float> velocityBasedTween(float f, float f2, int i) {
        return AnimationSpecKt.tween((int) Math.ceil(f2 / (f / 1000.0f)), i, EasingKt.getLinearEasing());
    }
}
