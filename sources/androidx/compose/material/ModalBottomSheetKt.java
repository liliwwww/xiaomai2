package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ModalBottomSheetKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0174  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: ModalBottomSheetLayout-BzaUkTc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m771ModalBottomSheetLayoutBzaUkTc(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r31, @org.jetbrains.annotations.Nullable androidx.compose.material.ModalBottomSheetState r32, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r33, float r34, long r35, long r37, long r39, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r42, int r43, int r44) {
        /*
            Method dump skipped, instructions count: 695
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt.m771ModalBottomSheetLayoutBzaUkTc(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.ModalBottomSheetState, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m772Scrim3JVO9M(long j, Function0<Unit> function0, boolean z, Composer composer, int i) {
        int i2;
        Modifier modifier;
        Composer startRestartGroup = composer.startRestartGroup(-526532668);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-526532668, i2, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:429)");
            }
            if (j != Color.Companion.m1084getUnspecified0d7_KjU()) {
                State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, (Function1) null, startRestartGroup, 0, 12);
                String m825getString4foXLRw = Strings_androidKt.m825getString4foXLRw(Strings.Companion.m819getCloseSheetUdPEhr4(), startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(1010547488);
                if (z) {
                    Modifier.Companion companion = Modifier.Companion;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    boolean changed = startRestartGroup.changed(function0);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function0, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2) rememberedValue);
                    startRestartGroup.startReplaceableGroup(511388516);
                    boolean changed2 = startRestartGroup.changed(m825getString4foXLRw) | startRestartGroup.changed(function0);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Scrim.dismissModifier.2.1(m825getString4foXLRw, function0);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceableGroup();
                    modifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) rememberedValue2);
                } else {
                    modifier = Modifier.Companion;
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null).then(modifier);
                Color color = Color.box-impl(j);
                startRestartGroup.startReplaceableGroup(511388516);
                boolean changed3 = startRestartGroup.changed(color) | startRestartGroup.changed(animateFloatAsState);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Scrim.1.1(j, animateFloatAsState);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Scrim.2(j, function0, z, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim_3J_VO9M$lambda-0, reason: not valid java name */
    public static final float m773Scrim_3J_VO9M$lambda0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier bottomSheetSwipeable(Modifier modifier, ModalBottomSheetState modalBottomSheetState, float f, State<Float> state) {
        Modifier modifier2;
        Float value = state.getValue();
        if (value != null) {
            float f2 = f / 2;
            modifier2 = SwipeableKt.swipeable-pPrIpRY$default(Modifier.Companion, modalBottomSheetState, (value.floatValue() < f2 || modalBottomSheetState.isSkipHalfExpanded$material_release()) ? MapsKt.mapOf(new Pair[]{TuplesKt.to(Float.valueOf(f), ModalBottomSheetValue.Hidden), TuplesKt.to(Float.valueOf(f - value.floatValue()), ModalBottomSheetValue.Expanded)}) : MapsKt.mapOf(new Pair[]{TuplesKt.to(Float.valueOf(f), ModalBottomSheetValue.Hidden), TuplesKt.to(Float.valueOf(f2), ModalBottomSheetValue.HalfExpanded), TuplesKt.to(Float.valueOf(Math.max(0.0f, f - value.floatValue())), ModalBottomSheetValue.Expanded)}), Orientation.Vertical, modalBottomSheetState.getCurrentValue() != ModalBottomSheetValue.Hidden, false, (MutableInteractionSource) null, (Function2) null, (ResistanceConfig) null, 0.0f, 368, (Object) null);
        } else {
            modifier2 = Modifier.Companion;
        }
        return modifier.then(modifier2);
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final ModalBottomSheetState rememberModalBottomSheetState(@NotNull final ModalBottomSheetValue modalBottomSheetValue, @Nullable final AnimationSpec<Float> animationSpec, final boolean z, @Nullable final Function1<? super ModalBottomSheetValue, Boolean> function1, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(modalBottomSheetValue, "initialValue");
        composer.startReplaceableGroup(-409288536);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 8) != 0) {
            function1 = new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$1
                @NotNull
                public final Boolean invoke(@NotNull ModalBottomSheetValue modalBottomSheetValue2) {
                    Intrinsics.checkNotNullParameter(modalBottomSheetValue2, "it");
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-409288536, i, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:239)");
        }
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.rememberSaveable(new Object[]{modalBottomSheetValue, animationSpec, Boolean.valueOf(z), function1}, ModalBottomSheetState.Companion.Saver(animationSpec, z, function1), (String) null, new Function0<ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ModalBottomSheetState m779invoke() {
                return new ModalBottomSheetState(modalBottomSheetValue, animationSpec, z, function1);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modalBottomSheetState;
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final ModalBottomSheetState rememberModalBottomSheetState(@NotNull ModalBottomSheetValue modalBottomSheetValue, @Nullable AnimationSpec<Float> animationSpec, @Nullable Function1<? super ModalBottomSheetValue, Boolean> function1, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(modalBottomSheetValue, "initialValue");
        composer.startReplaceableGroup(-1928569212);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        AnimationSpec<Float> animationSpec2 = animationSpec;
        if ((i2 & 4) != 0) {
            function1 = new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$3
                @NotNull
                public final Boolean invoke(@NotNull ModalBottomSheetValue modalBottomSheetValue2) {
                    Intrinsics.checkNotNullParameter(modalBottomSheetValue2, "it");
                    return Boolean.TRUE;
                }
            };
        }
        Function1<? super ModalBottomSheetValue, Boolean> function12 = function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1928569212, i, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:271)");
        }
        ModalBottomSheetState rememberModalBottomSheetState = rememberModalBottomSheetState(modalBottomSheetValue, animationSpec2, false, function12, composer, (i & 14) | 448 | ((i << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberModalBottomSheetState;
    }
}
