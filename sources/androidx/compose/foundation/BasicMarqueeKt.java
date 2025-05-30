package androidx.compose.foundation;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class BasicMarqueeKt {
    private static final int DefaultMarqueeDelayMillis = 1200;
    private static final int DefaultMarqueeIterations = 3;

    @NotNull
    private static final MarqueeSpacing DefaultMarqueeSpacing = MarqueeSpacing.Companion.fractionOfContainer(0.33333334f);
    private static final float DefaultMarqueeVelocity = Dp.constructor-impl(30);

    @ExperimentalFoundationApi
    @NotNull
    /* renamed from: MarqueeSpacing-0680j_4, reason: not valid java name */
    public static final MarqueeSpacing m118MarqueeSpacing0680j_4(final float f) {
        return new MarqueeSpacing() { // from class: androidx.compose.foundation.BasicMarqueeKt$MarqueeSpacing$1
            public final int calculateSpacing(@NotNull Density density, int i, int i2) {
                Intrinsics.checkNotNullParameter(density, "$this$MarqueeSpacing");
                return density.roundToPx-0680j_4(f);
            }
        };
    }

    @ExperimentalFoundationApi
    @NotNull
    /* renamed from: basicMarquee-1Mj1MLw, reason: not valid java name */
    public static final Modifier m120basicMarquee1Mj1MLw(@NotNull Modifier modifier, final int i, final int i2, final int i3, final int i4, @NotNull final MarqueeSpacing marqueeSpacing, final float f) {
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
                inspectorInfo.getProperties().set("animationMode", MarqueeAnimationMode.box-impl(i2));
                inspectorInfo.getProperties().set("delayMillis", Integer.valueOf(i3));
                inspectorInfo.getProperties().set("initialDelayMillis", Integer.valueOf(i4));
                inspectorInfo.getProperties().set("spacing", marqueeSpacing);
                inspectorInfo.getProperties().set("velocity", Dp.box-impl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new basicMarquee.2(i, i3, i4, f, marqueeSpacing, i2));
    }

    /* renamed from: basicMarquee-1Mj1MLw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m121basicMarquee1Mj1MLw$default(Modifier modifier, int i, int i2, int i3, int i4, MarqueeSpacing marqueeSpacing, float f, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = DefaultMarqueeIterations;
        }
        if ((i5 & 2) != 0) {
            i2 = MarqueeAnimationMode.Companion.getImmediately-ZbEOnfQ();
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = DefaultMarqueeDelayMillis;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = MarqueeAnimationMode.equals-impl0(i6, MarqueeAnimationMode.Companion.getImmediately-ZbEOnfQ()) ? i7 : 0;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            marqueeSpacing = DefaultMarqueeSpacing;
        }
        MarqueeSpacing marqueeSpacing2 = marqueeSpacing;
        if ((i5 & 32) != 0) {
            f = DefaultMarqueeVelocity;
        }
        return m120basicMarquee1Mj1MLw(modifier, i, i6, i7, i8, marqueeSpacing2, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createMarqueeAnimationSpec-Z4HSEVQ, reason: not valid java name */
    public static final AnimationSpec<Float> m122createMarqueeAnimationSpecZ4HSEVQ(int i, float f, int i2, int i3, float f2, Density density) {
        TweenSpec<Float> velocityBasedTween = velocityBasedTween(Math.abs(density.toPx-0680j_4(f2)), f, i3);
        long m88constructorimpl$default = StartOffset.m88constructorimpl$default((-i3) + i2, 0, 2, null);
        return i == Integer.MAX_VALUE ? AnimationSpecKt.m64infiniteRepeatable9IiC70o$default(velocityBasedTween, null, m88constructorimpl$default, 2, null) : AnimationSpecKt.m66repeatable91I0pcU$default(i, velocityBasedTween, null, m88constructorimpl$default, 4, null);
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
