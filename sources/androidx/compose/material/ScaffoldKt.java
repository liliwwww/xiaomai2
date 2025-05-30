package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Map;
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
public final class ScaffoldKt {

    @NotNull
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        @Nullable
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final FabPlacement m652invoke() {
            return null;
        }
    });
    private static final float FabSpacing = Dp.m2142constructorimpl(16);

    /* JADX WARN: Code restructure failed: missing block: B:62:0x01b8, code lost:
    
        if (r0.changed(r55) == false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01d2, code lost:
    
        if (r0.changed(r57) == false) goto L157;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0238  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: Scaffold-27mzLpw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m649Scaffold27mzLpw(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r41, @org.jetbrains.annotations.Nullable androidx.compose.material.ScaffoldState r42, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, int r47, boolean r48, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, boolean r50, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r51, float r52, long r53, long r55, long r57, long r59, long r61, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r63, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r64, final int r65, final int r66, final int r67) {
        /*
            Method dump skipped, instructions count: 1275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.m649Scaffold27mzLpw(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @UiComposable
    /* renamed from: ScaffoldLayout-MDYNRJg, reason: not valid java name */
    public static final void m650ScaffoldLayoutMDYNRJg(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, int i2) {
        Modifier modifier;
        Composer startRestartGroup = composer.startRestartGroup(-1401632215);
        int i3 = (i2 & 14) == 0 ? (startRestartGroup.changed(z) ? 4 : 2) | i2 : i2;
        if ((i2 & 112) == 0) {
            i3 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= startRestartGroup.changed(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= startRestartGroup.changed(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= startRestartGroup.changed(function22) ? AccessibilityNodeInfoCompat.ACTION_COPY : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= startRestartGroup.changed(function23) ? AccessibilityNodeInfoCompat.ACTION_SET_SELECTION : AccessibilityNodeInfoCompat.ACTION_CUT;
        }
        if ((3670016 & i2) == 0) {
            i3 |= startRestartGroup.changed(function24) ? AccessibilityNodeInfoCompat.ACTION_DISMISS : AccessibilityNodeInfoCompat.ACTION_COLLAPSE;
        }
        final int i4 = i3;
        if ((2995931 & i4) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1401632215, i4, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:227)");
            }
            Object[] objArr = {function2, function22, function23, FabPosition.m589boximpl(i), Boolean.valueOf(z), function24, function3};
            startRestartGroup.startReplaceableGroup(-568225417);
            boolean z2 = false;
            for (int i5 = 0; i5 < 7; i5++) {
                z2 |= startRestartGroup.changed(objArr[i5]);
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                modifier = null;
                Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function25 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return m653invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m2128unboximpl());
                    }

                    @NotNull
                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m653invoke0kLqBqw(@NotNull final SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
                        final int m2122getMaxWidthimpl = Constraints.m2122getMaxWidthimpl(j);
                        final int m2121getMaxHeightimpl = Constraints.m2121getMaxHeightimpl(j);
                        final long m2113copyZbe2FdA$default = Constraints.m2113copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        final Function2<Composer, Integer, Unit> function26 = function2;
                        final Function2<Composer, Integer, Unit> function27 = function22;
                        final Function2<Composer, Integer, Unit> function28 = function23;
                        final int i6 = i;
                        final boolean z3 = z;
                        final Function2<Composer, Integer, Unit> function29 = function24;
                        final int i7 = i4;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        return MeasureScope.-CC.p(subcomposeMeasureScope, m2122getMaxWidthimpl, m2121getMaxHeightimpl, (Map) null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:103:0x0279  */
                            /* JADX WARN: Removed duplicated region for block: B:107:0x0269  */
                            /* JADX WARN: Removed duplicated region for block: B:108:0x0232  */
                            /* JADX WARN: Removed duplicated region for block: B:109:0x0201  */
                            /* JADX WARN: Removed duplicated region for block: B:49:0x01e6 A[LOOP:3: B:48:0x01e4->B:49:0x01e6, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:53:0x01ff  */
                            /* JADX WARN: Removed duplicated region for block: B:56:0x022c  */
                            /* JADX WARN: Removed duplicated region for block: B:58:0x0235  */
                            /* JADX WARN: Removed duplicated region for block: B:64:0x026d  */
                            /* JADX WARN: Removed duplicated region for block: B:69:0x02a9 A[LOOP:4: B:68:0x02a7->B:69:0x02a9, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:73:0x02dc A[LOOP:5: B:72:0x02da->B:73:0x02dc, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:77:0x030c A[LOOP:6: B:76:0x030a->B:77:0x030c, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:81:0x0329 A[LOOP:7: B:80:0x0327->B:81:0x0329, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:85:0x0347 A[LOOP:8: B:84:0x0345->B:85:0x0347, LOOP_END] */
                            /* JADX WARN: Removed duplicated region for block: B:89:0x0365  */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.layout.Placeable.PlacementScope r31) {
                                /*
                                    Method dump skipped, instructions count: 907
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.AnonymousClass1.invoke(androidx.compose.ui.layout.Placeable$PlacementScope):void");
                            }
                        }, 4, (Object) null);
                    }
                };
                startRestartGroup.updateRememberedValue(function25);
                rememberedValue = function25;
            } else {
                modifier = null;
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) rememberedValue, startRestartGroup, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new ScaffoldLayout.2(z, i, function2, function3, function22, function23, function24, i2));
    }

    @NotNull
    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }

    @Composable
    @NotNull
    public static final ScaffoldState rememberScaffoldState(@Nullable DrawerState drawerState, @Nullable SnackbarHostState snackbarHostState, @Nullable Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1569641925);
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, (Function1) null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
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
            ComposerKt.traceEventStart(1569641925, i, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:62)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) rememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return scaffoldState;
    }
}
