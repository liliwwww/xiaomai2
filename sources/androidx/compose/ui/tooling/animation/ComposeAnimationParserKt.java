package androidx.compose.ui.tooling.animation;

import android.util.Log;
import androidx.compose.animation.core.Transition;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ComposeAnimationParserKt {
    @NotNull
    public static final TransitionComposeAnimation parse(@NotNull Transition<Object> transition) {
        Set of;
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Log.d("ComposeAnimationParser", "Transition subscribed");
        Object initialState = transition.getSegment().getInitialState();
        Object[] enumConstants = initialState.getClass().getEnumConstants();
        if (enumConstants == null || (of = ArraysKt.toSet(enumConstants)) == null) {
            of = SetsKt.setOf(initialState);
        }
        String label = transition.getLabel();
        if (label == null) {
            label = Reflection.getOrCreateKotlinClass(initialState.getClass()).getSimpleName();
        }
        return new TransitionComposeAnimation(transition, of, label);
    }

    @NotNull
    public static final AnimatedVisibilityComposeAnimation parseAnimatedVisibility(@NotNull Transition<Object> transition) {
        Intrinsics.checkNotNullParameter(transition, "<this>");
        Log.d("ComposeAnimationParser", "AnimatedVisibility transition subscribed");
        String label = transition.getLabel();
        if (label == null) {
            label = "AnimatedVisibility";
        }
        return new AnimatedVisibilityComposeAnimation(transition, label);
    }
}
