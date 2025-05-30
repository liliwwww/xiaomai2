package androidx.compose.material;

import android.taobao.windvane.util.WVConstants;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class DrawerKt {
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float EndDrawerPadding = Dp.constructor-impl(56);
    private static final float DrawerVelocityThreshold = Dp.constructor-impl(WVConstants.NOTIFY_PAGE_START);

    @NotNull
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    /* JADX WARN: Removed duplicated region for block: B:102:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02d5  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: BottomDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m724BottomDrawerGs3lGvM(@org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r34, @org.jetbrains.annotations.Nullable androidx.compose.material.BottomDrawerState r35, boolean r36, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r37, float r38, long r39, long r41, long r43, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 777
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m724BottomDrawerGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomDrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    public static final void m725BottomDrawerScrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier modifier;
        Composer startRestartGroup = composer.startRestartGroup(-513067266);
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
                ComposerKt.traceEventStart(-513067266, i2, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:619)");
            }
            if (j != Color.Companion.m1084getUnspecified0d7_KjU()) {
                final State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, (Function1) null, startRestartGroup, 0, 12);
                String m825getString4foXLRw = Strings_androidKt.m825getString4foXLRw(Strings.Companion.m818getCloseDrawerUdPEhr4(), startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1298949409);
                if (z) {
                    Modifier.Companion companion = Modifier.Companion;
                    startRestartGroup.startReplaceableGroup(1157296644);
                    boolean changed = startRestartGroup.changed(function0);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new BottomDrawerScrim.dismissModifier.1.1(function0, (Continuation) null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2) rememberedValue);
                    startRestartGroup.startReplaceableGroup(511388516);
                    boolean changed2 = startRestartGroup.changed(m825getString4foXLRw) | startRestartGroup.changed(function0);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new BottomDrawerScrim.dismissModifier.2.1(m825getString4foXLRw, function0);
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
                    rememberedValue3 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((DrawScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull DrawScope drawScope) {
                            float m726BottomDrawerScrim_3J_VO9M$lambda2;
                            Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
                            long j2 = j;
                            m726BottomDrawerScrim_3J_VO9M$lambda2 = DrawerKt.m726BottomDrawerScrim_3J_VO9M$lambda2(animateFloatAsState);
                            w51.K(drawScope, j2, 0L, 0L, m726BottomDrawerScrim_3J_VO9M$lambda2, (DrawStyle) null, (ColorFilter) null, 0, 118, (Object) null);
                        }
                    };
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i3) {
                DrawerKt.m725BottomDrawerScrim3JVO9M(j, function0, z, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomDrawerScrim_3J_VO9M$lambda-2, reason: not valid java name */
    public static final float m726BottomDrawerScrim_3J_VO9M$lambda2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02cc  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: ModalDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m727ModalDrawerGs3lGvM(@org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r34, @org.jetbrains.annotations.Nullable androidx.compose.material.DrawerState r35, boolean r36, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r37, float r38, long r39, long r41, long r43, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 768
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m727ModalDrawerGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.DrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: Scrim-Bx497Mc, reason: not valid java name */
    public static final void m728ScrimBx497Mc(final boolean z, final Function0<Unit> function0, final Function0<Float> function02, final long j, Composer composer, final int i) {
        int i2;
        Modifier modifier;
        Composer startRestartGroup = composer.startRestartGroup(1983403750);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(function02) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(j) ? AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED : AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END;
        }
        if ((i2 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983403750, i2, -1, "androidx.compose.material.Scrim (Drawer.kt:654)");
            }
            final String m825getString4foXLRw = Strings_androidKt.m825getString4foXLRw(Strings.Companion.m818getCloseDrawerUdPEhr4(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(1010554047);
            if (z) {
                Modifier.Companion companion = Modifier.Companion;
                startRestartGroup.startReplaceableGroup(1157296644);
                boolean changed = startRestartGroup.changed(function0);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new DrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2) rememberedValue);
                startRestartGroup.startReplaceableGroup(511388516);
                boolean changed2 = startRestartGroup.changed(m825getString4foXLRw) | startRestartGroup.changed(function0);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
                            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m825getString4foXLRw);
                            SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new 1(function0), 1, (Object) null);
                        }
                    };
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
            boolean changed3 = startRestartGroup.changed(color) | startRestartGroup.changed(function02);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                rememberedValue3 = new Scrim.1.1(j, function02);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(then, (Function1) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i3) {
                DrawerKt.m728ScrimBx497Mc(z, function0, function02, j, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float f, float f2, float f3) {
        return RangesKt.coerceIn((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
    
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L12;
     */
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.material.BottomDrawerState rememberBottomDrawerState(@org.jetbrains.annotations.NotNull final androidx.compose.material.BottomDrawerValue r7, @org.jetbrains.annotations.Nullable final kotlin.jvm.functions.Function1<? super androidx.compose.material.BottomDrawerValue, java.lang.Boolean> r8, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r9, int r10, int r11) {
        /*
            java.lang.String r0 = "initialValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -598115156(0xffffffffdc597cac, float:-2.44868592E17)
            r9.startReplaceableGroup(r0)
            r11 = r11 & 2
            if (r11 == 0) goto L11
            androidx.compose.material.DrawerKt$rememberBottomDrawerState$1 r8 = new kotlin.jvm.functions.Function1<androidx.compose.material.BottomDrawerValue, java.lang.Boolean>() { // from class: androidx.compose.material.DrawerKt$rememberBottomDrawerState$1
                static {
                    /*
                        androidx.compose.material.DrawerKt$rememberBottomDrawerState$1 r0 = new androidx.compose.material.DrawerKt$rememberBottomDrawerState$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.material.DrawerKt$rememberBottomDrawerState$1) androidx.compose.material.DrawerKt$rememberBottomDrawerState$1.INSTANCE androidx.compose.material.DrawerKt$rememberBottomDrawerState$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt$rememberBottomDrawerState$1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt$rememberBottomDrawerState$1.<init>():void");
                }

                @org.jetbrains.annotations.NotNull
                public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull androidx.compose.material.BottomDrawerValue r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        java.lang.Boolean r2 = java.lang.Boolean.TRUE
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt$rememberBottomDrawerState$1.invoke(androidx.compose.material.BottomDrawerValue):java.lang.Boolean");
                }

                public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r1) {
                    /*
                        r0 = this;
                        androidx.compose.material.BottomDrawerValue r1 = (androidx.compose.material.BottomDrawerValue) r1
                        java.lang.Boolean r1 = r0.invoke(r1)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt$rememberBottomDrawerState$1.invoke(java.lang.Object):java.lang.Object");
                }
            }
        L11:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L1d
            r11 = -1
            java.lang.String r1 = "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:333)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r11, r1)
        L1d:
            r10 = 0
            java.lang.Object[] r0 = new java.lang.Object[r10]
            androidx.compose.material.BottomDrawerState$Companion r10 = androidx.compose.material.BottomDrawerState.Companion
            androidx.compose.runtime.saveable.Saver r1 = r10.Saver(r8)
            r2 = 0
            r10 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r9.startReplaceableGroup(r10)
            boolean r10 = r9.changed(r7)
            boolean r11 = r9.changed(r8)
            r10 = r10 | r11
            java.lang.Object r11 = r9.rememberedValue()
            if (r10 != 0) goto L44
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L4c
        L44:
            androidx.compose.material.DrawerKt$rememberBottomDrawerState$2$1 r11 = new androidx.compose.material.DrawerKt$rememberBottomDrawerState$2$1
            r11.<init>()
            r9.updateRememberedValue(r11)
        L4c:
            r9.endReplaceableGroup()
            r3 = r11
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r5 = 72
            r6 = 4
            r4 = r9
            java.lang.Object r7 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.material.BottomDrawerState r7 = (androidx.compose.material.BottomDrawerState) r7
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L65
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L65:
            r9.endReplaceableGroup()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.rememberBottomDrawerState(androidx.compose.material.BottomDrawerValue, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):androidx.compose.material.BottomDrawerState");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
    
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L12;
     */
    @androidx.compose.runtime.Composable
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.material.DrawerState rememberDrawerState(@org.jetbrains.annotations.NotNull final androidx.compose.material.DrawerValue r7, @org.jetbrains.annotations.Nullable final kotlin.jvm.functions.Function1<? super androidx.compose.material.DrawerValue, java.lang.Boolean> r8, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r9, int r10, int r11) {
        /*
            java.lang.String r0 = "initialValue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = -1435874229(0xffffffffaa6a4c4b, float:-2.0809844E-13)
            r9.startReplaceableGroup(r0)
            r11 = r11 & 2
            if (r11 == 0) goto L11
            androidx.compose.material.DrawerKt$rememberDrawerState$1 r8 = androidx.compose.material.DrawerKt.rememberDrawerState.1.INSTANCE
        L11:
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L1d
            r11 = -1
            java.lang.String r1 = "androidx.compose.material.rememberDrawerState (Drawer.kt:316)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r10, r11, r1)
        L1d:
            r10 = 0
            java.lang.Object[] r0 = new java.lang.Object[r10]
            androidx.compose.material.DrawerState$Companion r10 = androidx.compose.material.DrawerState.Companion
            androidx.compose.runtime.saveable.Saver r1 = r10.Saver(r8)
            r2 = 0
            r10 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r9.startReplaceableGroup(r10)
            boolean r10 = r9.changed(r7)
            boolean r11 = r9.changed(r8)
            r10 = r10 | r11
            java.lang.Object r11 = r9.rememberedValue()
            if (r10 != 0) goto L44
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L4c
        L44:
            androidx.compose.material.DrawerKt$rememberDrawerState$2$1 r11 = new androidx.compose.material.DrawerKt$rememberDrawerState$2$1
            r11.<init>()
            r9.updateRememberedValue(r11)
        L4c:
            r9.endReplaceableGroup()
            r3 = r11
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r5 = 72
            r6 = 4
            r4 = r9
            java.lang.Object r7 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable(r0, r1, r2, r3, r4, r5, r6)
            androidx.compose.material.DrawerState r7 = (androidx.compose.material.DrawerState) r7
            boolean r8 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r8 == 0) goto L65
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L65:
            r9.endReplaceableGroup()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.rememberDrawerState(androidx.compose.material.DrawerValue, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):androidx.compose.material.DrawerState");
    }
}
