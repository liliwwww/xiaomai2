package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BottomSheetScaffoldKt {
    private static final float FabEndSpacing = Dp.m2142constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:102:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0699  */
    /* JADX WARN: Removed duplicated region for block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0665  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0549  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x04d4  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0472  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x025c  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: BottomSheetScaffold-bGncdBI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m515BottomSheetScaffoldbGncdBI(@org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r69, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r70, @org.jetbrains.annotations.Nullable androidx.compose.material.BottomSheetScaffoldState r71, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r72, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r73, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, int r75, boolean r76, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r77, float r78, long r79, long r81, float r83, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r84, boolean r85, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r86, float r87, long r88, long r90, long r92, long r94, long r96, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r98, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r99, final int r100, final int r101, final int r102, final int r103) {
        /*
            Method dump skipped, instructions count: 1718
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m515BottomSheetScaffoldbGncdBI(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomSheetScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, androidx.compose.ui.graphics.Shape, float, long, long, float, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: BottomSheetScaffoldStack-SlNgfk0, reason: not valid java name */
    public static final void m516BottomSheetScaffoldStackSlNgfk0(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, State<Float> state, int i, Composer composer, int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(172426443);
        if ((i2 & 14) == 0) {
            i3 = (startRestartGroup.changed(function2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= startRestartGroup.changed(function22) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= startRestartGroup.changed(function23) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= startRestartGroup.changed(function24) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= startRestartGroup.changed(state) ? AccessibilityNodeInfoCompat.ACTION_COPY : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= startRestartGroup.changed(i) ? AccessibilityNodeInfoCompat.ACTION_SET_SELECTION : AccessibilityNodeInfoCompat.ACTION_CUT;
        }
        if ((374491 & i3) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(172426443, i3, -1, "androidx.compose.material.BottomSheetScaffoldStack (BottomSheetScaffold.kt:382)");
            }
            BottomSheetScaffoldStack.2 r0 = new BottomSheetScaffoldStack.2(state, i);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.Companion;
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode$Companion composeUiNode$Companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = composeUiNode$Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer m747constructorimpl = Updater.m747constructorimpl(startRestartGroup);
            Updater.m754setimpl(m747constructorimpl, r0, (Function2<? super T, ? super BottomSheetScaffoldStack.2, Unit>) composeUiNode$Companion.getSetMeasurePolicy());
            Updater.m754setimpl(m747constructorimpl, density, (Function2<? super T, ? super Density, Unit>) composeUiNode$Companion.getSetDensity());
            Updater.m754setimpl(m747constructorimpl, layoutDirection, (Function2<? super T, ? super LayoutDirection, Unit>) composeUiNode$Companion.getSetLayoutDirection());
            Updater.m754setimpl(m747constructorimpl, viewConfiguration, (Function2<? super T, ? super ViewConfiguration, Unit>) composeUiNode$Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1162539198);
            function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
            function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 3) & 14));
            function23.invoke(startRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            function24.invoke(startRestartGroup, Integer.valueOf((i3 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new BottomSheetScaffoldStack.3(function2, function22, function23, function24, state, i, i2));
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(@Nullable DrawerState drawerState, @Nullable BottomSheetState bottomSheetState, @Nullable SnackbarHostState snackbarHostState, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1353009744);
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, (Function1) null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, composer, 6, 6);
        }
        if ((i2 & 4) != 0) {
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) rememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1353009744, i, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:195)");
        }
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(drawerState) | composer.changed(bottomSheetState) | composer.changed(snackbarHostState);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new BottomSheetScaffoldState(drawerState, bottomSheetState, snackbarHostState);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    @Composable
    @ExperimentalMaterialApi
    @NotNull
    public static final BottomSheetState rememberBottomSheetState(@NotNull final BottomSheetValue bottomSheetValue, @Nullable final AnimationSpec<Float> animationSpec, @Nullable final Function1<? super BottomSheetValue, Boolean> function1, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(bottomSheetValue, "initialValue");
        composer.startReplaceableGroup(1808153344);
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$1
                @NotNull
                public final Boolean invoke(@NotNull BottomSheetValue bottomSheetValue2) {
                    Intrinsics.checkNotNullParameter(bottomSheetValue2, "it");
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1808153344, i, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:151)");
        }
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.m795rememberSaveable(new Object[]{animationSpec}, (Saver) BottomSheetState.Companion.Saver(animationSpec, function1), (String) null, (Function0) new Function0<BottomSheetState>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BottomSheetState m524invoke() {
                return new BottomSheetState(bottomSheetValue, animationSpec, function1);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomSheetState;
    }
}
