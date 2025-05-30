package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SelectionMagnifierKt {

    @NotNull
    private static final SpringSpec<Offset> MagnifierSpringSpec;
    private static final long OffsetDisplacementThreshold;

    @NotNull
    private static final AnimationVector2D UnspecifiedAnimationVector2D = new AnimationVector2D(Float.NaN, Float.NaN);

    @NotNull
    private static final TwoWayConverter<Offset, AnimationVector2D> UnspecifiedSafeOffsetVectorConverter = VectorConvertersKt.TwoWayConverter(new Function1<Offset, AnimationVector2D>() { // from class: androidx.compose.foundation.text.selection.SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m609invokek4lQ0M(((Offset) obj).unbox-impl());
        }

        @NotNull
        /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final AnimationVector2D m609invokek4lQ0M(long j) {
            AnimationVector2D animationVector2D;
            if (OffsetKt.m1027isSpecifiedk4lQ0M(j)) {
                return new AnimationVector2D(Offset.getX-impl(j), Offset.getY-impl(j));
            }
            animationVector2D = SelectionMagnifierKt.UnspecifiedAnimationVector2D;
            return animationVector2D;
        }
    }, new Function1<AnimationVector2D, Offset>() { // from class: androidx.compose.foundation.text.selection.SelectionMagnifierKt$UnspecifiedSafeOffsetVectorConverter$2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Offset.box-impl(m610invoketuRUvjQ((AnimationVector2D) obj));
        }

        /* renamed from: invoke-tuRUvjQ, reason: not valid java name */
        public final long m610invoketuRUvjQ(@NotNull AnimationVector2D animationVector2D) {
            Intrinsics.checkNotNullParameter(animationVector2D, "it");
            return OffsetKt.Offset(animationVector2D.getV1(), animationVector2D.getV2());
        }
    });

    static {
        long Offset = OffsetKt.Offset(0.01f, 0.01f);
        OffsetDisplacementThreshold = Offset;
        MagnifierSpringSpec = new SpringSpec<>(0.0f, 0.0f, Offset.box-impl(Offset), 3, null);
    }

    @NotNull
    public static final Modifier animatedSelectionMagnifier(@NotNull Modifier modifier, @NotNull Function0<Offset> function0, @NotNull Function1<? super Function0<Offset>, ? extends Modifier> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function0, "magnifierCenter");
        Intrinsics.checkNotNullParameter(function1, "platformMagnifier");
        return ComposedModifierKt.composed$default(modifier, null, new animatedSelectionMagnifier.1(function0, function1), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    public static final State<Offset> rememberAnimatedMagnifierPosition(Function0<Offset> function0, Composer composer, int i) {
        composer.startReplaceableGroup(-1589795249);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1589795249, i, -1, "androidx.compose.foundation.text.selection.rememberAnimatedMagnifierPosition (SelectionMagnifier.kt:76)");
        }
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.derivedStateOf(function0);
            composer.updateRememberedValue(rememberedValue);
        }
        State state = (State) rememberedValue;
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Animatable(Offset.box-impl(rememberAnimatedMagnifierPosition$lambda$1(state)), UnspecifiedSafeOffsetVectorConverter, Offset.box-impl(OffsetDisplacementThreshold));
            composer.updateRememberedValue(rememberedValue2);
        }
        Animatable animatable = (Animatable) rememberedValue2;
        EffectsKt.LaunchedEffect(Unit.INSTANCE, new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1(state, animatable, null), composer, 70);
        State<Offset> asState = animatable.asState();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return asState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long rememberAnimatedMagnifierPosition$lambda$1(State<Offset> state) {
        return state.getValue().unbox-impl();
    }
}
