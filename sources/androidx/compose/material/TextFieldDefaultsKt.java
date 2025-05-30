package androidx.compose.material;

import android.taobao.windvane.packageapp.zipapp.utils.ZipAppConstants;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TextFieldDefaultsKt {
    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    /* renamed from: animateBorderStrokeAsState-NuRrP5Q, reason: not valid java name */
    public static final State<BorderStroke> m867animateBorderStrokeAsStateNuRrP5Q(boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, Composer composer, int i) {
        State rememberUpdatedState;
        composer.startReplaceableGroup(1097899920);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1097899920, i, -1, "androidx.compose.material.animateBorderStrokeAsState (TextFieldDefaults.kt:834)");
        }
        State<Boolean> collectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, (i >> 6) & 14);
        State<Color> indicatorColor = textFieldColors.indicatorColor(z, z2, interactionSource, composer, (i & 14) | (i & 112) | (i & 896) | (i & 7168));
        float f3 = m868animateBorderStrokeAsState_NuRrP5Q$lambda0(collectIsFocusedAsState) ? f : f2;
        if (z) {
            composer.startReplaceableGroup(1685712037);
            rememberUpdatedState = AnimateAsStateKt.animateDpAsState-Kz89ssw(f3, AnimationSpecKt.tween$default(ZipAppConstants.LOW_LIMITED_MAX_APP_NUM, 0, null, 6, null), (Function1) null, composer, 48, 4);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(1685712135);
            rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Dp.box-impl(f2), composer, (i >> 15) & 14);
            composer.endReplaceableGroup();
        }
        State<BorderStroke> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(new BorderStroke(((Dp) rememberUpdatedState.getValue()).unbox-impl(), new SolidColor(indicatorColor.getValue().unbox-impl(), (DefaultConstructorMarker) null), null), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberUpdatedState2;
    }

    /* renamed from: animateBorderStrokeAsState_NuRrP5Q$lambda-0, reason: not valid java name */
    private static final boolean m868animateBorderStrokeAsState_NuRrP5Q$lambda0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
