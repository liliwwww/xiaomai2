package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SingleValueAnimationKt {

    @NotNull
    private static final SpringSpec<Color> colorDefaultSpring = AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null);

    @NotNull
    /* renamed from: Animatable-8_81llA, reason: not valid java name */
    public static final Animatable<Color, AnimationVector4D> m59Animatable8_81llA(long j) {
        return new Animatable<>(Color.m1040boximpl(j), (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.m1054getColorSpaceimpl(j)), null, null, 12, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "animate*AsState APIs now have a new label parameter added.")
    @Composable
    /* renamed from: animateColorAsState-KTwxG1Y, reason: not valid java name */
    public static final /* synthetic */ State m60animateColorAsStateKTwxG1Y(long j, AnimationSpec animationSpec, Function1 function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1942442407);
        if ((i2 & 2) != 0) {
            animationSpec = colorDefaultSpring;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1942442407, i, -1, "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:75)");
        }
        State<Color> m61animateColorAsStateeuL9pac = m61animateColorAsStateeuL9pac(j, animationSpec2, null, function12, composer, (i & 14) | 64 | ((i << 3) & 7168), 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m61animateColorAsStateeuL9pac;
    }

    @Composable
    @NotNull
    /* renamed from: animateColorAsState-euL9pac, reason: not valid java name */
    public static final State<Color> m61animateColorAsStateeuL9pac(long j, @Nullable AnimationSpec<Color> animationSpec, @Nullable String str, @Nullable Function1<? super Color, Unit> function1, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-451899108);
        AnimationSpec<Color> animationSpec2 = (i2 & 2) != 0 ? colorDefaultSpring : animationSpec;
        String str2 = (i2 & 4) != 0 ? "ColorAnimation" : str;
        Function1<? super Color, Unit> function12 = (i2 & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-451899108, i, -1, "androidx.compose.animation.animateColorAsState (SingleValueAnimation.kt:56)");
        }
        ColorSpace m1054getColorSpaceimpl = Color.m1054getColorSpaceimpl(j);
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(m1054getColorSpaceimpl);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(Color.m1054getColorSpaceimpl(j));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        int i3 = i << 6;
        State<Color> animateValueAsState = AnimateAsStateKt.animateValueAsState(Color.m1040boximpl(j), (TwoWayConverter) rememberedValue, animationSpec2, null, str2, function12, composer, (i & 14) | 576 | (57344 & i3) | (i3 & 458752), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return animateValueAsState;
    }
}
