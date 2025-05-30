package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class OutlinedTextFieldKt {

    @NotNull
    public static final String BorderId = "border";
    private static final float OutlinedTextFieldInnerPadding = Dp.constructor-impl(4);
    private static final float OutlinedTextFieldTopPadding = Dp.constructor-impl(8);

    /* JADX WARN: Code restructure failed: missing block: B:57:0x01b0, code lost:
    
        if (r7.changed(r83) == false) goto L145;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x025f  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OutlinedTextField(@org.jetbrains.annotations.NotNull final java.lang.String r70, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r71, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r72, boolean r73, boolean r74, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r75, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, boolean r80, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r81, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r82, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r83, boolean r84, int r85, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r86, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r87, @org.jetbrains.annotations.Nullable androidx.compose.material.TextFieldColors r88, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r89, final int r90, final int r91, final int r92) {
        /*
            Method dump skipped, instructions count: 1516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void OutlinedTextFieldLayout(@NotNull Modifier modifier, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Function2<? super Composer, ? super Integer, Unit> function23, @Nullable Function2<? super Composer, ? super Integer, Unit> function24, boolean z, float f, @NotNull Function1<? super Size, Unit> function1, @NotNull Function2<? super Composer, ? super Integer, Unit> function25, @NotNull PaddingValues paddingValues, @Nullable Composer composer, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(function2, "textField");
        Intrinsics.checkNotNullParameter(function1, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(function25, BorderId);
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer startRestartGroup = composer.startRestartGroup(-2049536174);
        int i4 = (i & 14) == 0 ? (startRestartGroup.changed(modifier) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i4 |= startRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i4 |= startRestartGroup.changed(function3) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i4 |= startRestartGroup.changed(function22) ? AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED : AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END;
        }
        if ((57344 & i) == 0) {
            i4 |= startRestartGroup.changed(function23) ? AccessibilityEventCompat.TYPE_ANNOUNCEMENT : AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED;
        }
        if ((458752 & i) == 0) {
            i4 |= startRestartGroup.changed(function24) ? AccessibilityEventCompat.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY : AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED;
        }
        if ((3670016 & i) == 0) {
            i4 |= startRestartGroup.changed(z) ? AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START : AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END;
        }
        if ((29360128 & i) == 0) {
            i4 |= startRestartGroup.changed(f) ? AccessibilityEventCompat.TYPE_VIEW_CONTEXT_CLICKED : AccessibilityEventCompat.TYPE_WINDOWS_CHANGED;
        }
        if ((234881024 & i) == 0) {
            i4 |= startRestartGroup.changed(function1) ? 67108864 : 33554432;
        }
        if ((1879048192 & i) == 0) {
            i4 |= startRestartGroup.changed(function25) ? 536870912 : 268435456;
        }
        int i5 = (i2 & 14) == 0 ? i2 | (startRestartGroup.changed(paddingValues) ? 4 : 2) : i2;
        if ((i4 & 1533916891) == 306783378 && (i5 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2049536174, i4, i5, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:370)");
            }
            Object[] objArr = {function1, Boolean.valueOf(z), Float.valueOf(f), paddingValues};
            startRestartGroup.startReplaceableGroup(-568225417);
            int i6 = 0;
            boolean z2 = false;
            for (int i7 = 4; i6 < i7; i7 = 4) {
                z2 |= startRestartGroup.changed(objArr[i6]);
                i6++;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new OutlinedTextFieldMeasurePolicy(function1, z, f, paddingValues);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) rememberedValue;
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0 constructor = companion.getConstructor();
            Function3 materializerOf = LayoutKt.materializerOf(modifier);
            int i8 = ((((i4 << 3) & 112) << 9) & 7168) | 6;
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
            Composer composer2 = Updater.constructor-impl(startRestartGroup);
            Updater.set-impl(composer2, outlinedTextFieldMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.set-impl(composer2, density, companion.getSetDensity());
            Updater.set-impl(composer2, layoutDirection2, companion.getSetLayoutDirection());
            Updater.set-impl(composer2, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i8 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(118153609);
            if (((i8 >> 9) & 14 & 11) == 2 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
            } else {
                function25.invoke(startRestartGroup, Integer.valueOf((i4 >> 27) & 14));
                startRestartGroup.startReplaceableGroup(1169914597);
                if (function23 != null) {
                    Modifier then = LayoutIdKt.layoutId(Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center = Alignment.Companion.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0 constructor2 = companion.getConstructor();
                    Function3 materializerOf2 = LayoutKt.materializerOf(then);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor2);
                    } else {
                        startRestartGroup.useNode();
                    }
                    startRestartGroup.disableReusing();
                    Composer composer3 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer3, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.set-impl(composer3, density2, companion.getSetDensity());
                    Updater.set-impl(composer3, layoutDirection3, companion.getSetLayoutDirection());
                    Updater.set-impl(composer3, viewConfiguration2, companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf2.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(1691709354);
                    function23.invoke(startRestartGroup, Integer.valueOf((i4 >> 12) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1169914882);
                if (function24 != null) {
                    Modifier then2 = LayoutIdKt.layoutId(Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center2 = Alignment.Companion.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection4 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0 constructor3 = companion.getConstructor();
                    Function3 materializerOf3 = LayoutKt.materializerOf(then2);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor3);
                    } else {
                        startRestartGroup.useNode();
                    }
                    startRestartGroup.disableReusing();
                    Composer composer4 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer4, rememberBoxMeasurePolicy2, companion.getSetMeasurePolicy());
                    Updater.set-impl(composer4, density3, companion.getSetDensity());
                    Updater.set-impl(composer4, layoutDirection4, companion.getSetLayoutDirection());
                    Updater.set-impl(composer4, viewConfiguration3, companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf3.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-1351586719);
                    function24.invoke(startRestartGroup, Integer.valueOf((i4 >> 15) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
                startRestartGroup.endReplaceableGroup();
                float calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
                float calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
                Modifier.Companion companion2 = Modifier.Companion;
                if (function23 != null) {
                    i3 = 0;
                    calculateStartPadding = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.constructor-impl(0)));
                } else {
                    i3 = 0;
                }
                float f2 = calculateStartPadding;
                if (function24 != null) {
                    calculateEndPadding = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.constructor-impl(i3)));
                }
                Modifier m336paddingqDBjuR0$default = PaddingKt.m336paddingqDBjuR0$default(companion2, f2, 0.0f, calculateEndPadding, 0.0f, 10, null);
                startRestartGroup.startReplaceableGroup(1169915893);
                if (function3 != null) {
                    function3.invoke(LayoutIdKt.layoutId(companion2, "Hint").then(m336paddingqDBjuR0$default), startRestartGroup, Integer.valueOf((i4 >> 3) & 112));
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then3 = LayoutIdKt.layoutId(companion2, "TextField").then(m336paddingqDBjuR0$default);
                startRestartGroup.startReplaceableGroup(733328855);
                Alignment.Companion companion3 = Alignment.Companion;
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), true, startRestartGroup, 48);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density4 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection5 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration4 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0 constructor4 = companion.getConstructor();
                Function3 materializerOf4 = LayoutKt.materializerOf(then3);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer composer5 = Updater.constructor-impl(startRestartGroup);
                Updater.set-impl(composer5, rememberBoxMeasurePolicy3, companion.getSetMeasurePolicy());
                Updater.set-impl(composer5, density4, companion.getSetDensity());
                Updater.set-impl(composer5, layoutDirection5, companion.getSetLayoutDirection());
                Updater.set-impl(composer5, viewConfiguration4, companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf4.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-1205597937);
                function2.invoke(startRestartGroup, Integer.valueOf((i4 >> 3) & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (function22 != null) {
                    Modifier layoutId = LayoutIdKt.layoutId(companion2, "Label");
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    Density density5 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection6 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration5 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0 constructor5 = companion.getConstructor();
                    Function3 materializerOf5 = LayoutKt.materializerOf(layoutId);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor5);
                    } else {
                        startRestartGroup.useNode();
                    }
                    startRestartGroup.disableReusing();
                    Composer composer6 = Updater.constructor-impl(startRestartGroup);
                    Updater.set-impl(composer6, rememberBoxMeasurePolicy4, companion.getSetMeasurePolicy());
                    Updater.set-impl(composer6, density5, companion.getSetDensity());
                    Updater.set-impl(composer6, layoutDirection6, companion.getSetLayoutDirection());
                    Updater.set-impl(composer6, viewConfiguration5, companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf5.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    startRestartGroup.startReplaceableGroup(-55131805);
                    function22.invoke(startRestartGroup, Integer.valueOf((i4 >> 9) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
            }
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
        endRestartGroup.updateScope(new OutlinedTextFieldLayout.2(modifier, function2, function3, function22, function23, function24, z, f, function1, function25, paddingValues, i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-zUg2_y0, reason: not valid java name */
    public static final int m793calculateHeightzUg2_y0(int i, int i2, int i3, int i4, int i5, long j, float f, PaddingValues paddingValues) {
        return Math.max(Constraints.getMinHeight-impl(j), Math.max(i, Math.max(i2, MathKt.roundToInt(Math.max(i3, i5) + (paddingValues.calculateBottomPadding-D9Ej5fM() * f) + Math.max(paddingValues.calculateTopPadding-D9Ej5fM() * f, i4 / 2.0f)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-O3s9Psw, reason: not valid java name */
    public static final int m794calculateWidthO3s9Psw(int i, int i2, int i3, int i4, int i5, boolean z, long j, float f, PaddingValues paddingValues) {
        int i6 = 0;
        int max = i + Math.max(i3, Math.max(z ? i4 : 0, i5)) + i2;
        if (!z) {
            LayoutDirection layoutDirection = LayoutDirection.Ltr;
            i6 = i4 + MathKt.roundToInt(Dp.constructor-impl(paddingValues.calculateLeftPadding-u2uoSUM(layoutDirection) + paddingValues.calculateRightPadding-u2uoSUM(layoutDirection)) * f);
        }
        return Math.max(max, Math.max(i6, Constraints.getMinWidth-impl(j)));
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }

    @NotNull
    /* renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m795outlineCutout12SF9DM(@NotNull Modifier modifier, final long j, @NotNull final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(modifier, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$outlineCutout$1

            /* compiled from: Taobao */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
                float f;
                Intrinsics.checkNotNullParameter(contentDrawScope, "$this$drawWithContent");
                float f2 = Size.getWidth-impl(j);
                if (f2 <= 0.0f) {
                    contentDrawScope.drawContent();
                    return;
                }
                f = OutlinedTextFieldKt.OutlinedTextFieldInnerPadding;
                float f3 = contentDrawScope.toPx-0680j_4(f);
                float f4 = contentDrawScope.toPx-0680j_4(paddingValues.calculateLeftPadding-u2uoSUM(contentDrawScope.getLayoutDirection())) - f3;
                float f5 = 2;
                float f6 = f2 + f4 + (f3 * f5);
                LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
                int[] iArr = WhenMappings.$EnumSwitchMapping$0;
                float f7 = iArr[layoutDirection.ordinal()] == 1 ? Size.getWidth-impl(contentDrawScope.getSize-NH-jbRc()) - f6 : RangesKt.coerceAtLeast(f4, 0.0f);
                if (iArr[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                    f6 = Size.getWidth-impl(contentDrawScope.getSize-NH-jbRc()) - RangesKt.coerceAtLeast(f4, 0.0f);
                }
                float f8 = f6;
                float f9 = Size.getHeight-impl(j);
                float f10 = (-f9) / f5;
                float f11 = f9 / f5;
                int m1057getDifferencertfAjoo = ClipOp.Companion.m1057getDifferencertfAjoo();
                DrawContext drawContext = contentDrawScope.getDrawContext();
                long mo1254getSizeNHjbRc = drawContext.mo1254getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().clipRect-N_I0leg(f7, f10, f8, f11, m1057getDifferencertfAjoo);
                contentDrawScope.drawContent();
                drawContext.getCanvas().restore();
                drawContext.mo1255setSizeuvyYCjk(mo1254getSizeNHjbRc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable$PlacementScope placeable$PlacementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, float f, boolean z, float f2, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int roundToInt = MathKt.roundToInt(paddingValues.calculateTopPadding-D9Ej5fM() * f2);
        int roundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f2);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f2;
        if (placeable != null) {
            Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, placeable, 0, Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, placeable2, i2 - placeable2.getWidth(), Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            float f3 = 1 - f;
            Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, placeable4, MathKt.roundToInt(placeable == null ? 0.0f : f3 * (TextFieldImplKt.widthOrZero(placeable) - horizontalIconPadding)) + roundToInt2, MathKt.roundToInt(((z ? Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i) : roundToInt) * f3) - ((placeable4.getHeight() / 2) * f)), 0.0f, 4, null);
        }
        Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), Math.max(z ? Alignment.Companion.getCenterVertically().align(placeable3.getHeight(), i) : roundToInt, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, null);
        if (placeable5 != null) {
            if (z) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable5.getHeight(), i);
            }
            Placeable$PlacementScope.placeRelative$default(placeable$PlacementScope, placeable5, TextFieldImplKt.widthOrZero(placeable), roundToInt, 0.0f, 4, null);
        }
        Placeable$PlacementScope.m2068place70tqf50$default(placeable$PlacementScope, placeable6, IntOffset.Companion.m2653getZeronOccac(), 0.0f, 2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x01b0, code lost:
    
        if (r7.changed(r83) == false) goto L145;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x047c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x025f  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OutlinedTextField(@org.jetbrains.annotations.NotNull final androidx.compose.ui.text.input.TextFieldValue r70, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r71, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r72, boolean r73, boolean r74, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r75, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r76, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, boolean r80, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r81, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r82, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r83, boolean r84, int r85, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r86, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r87, @org.jetbrains.annotations.Nullable androidx.compose.material.TextFieldColors r88, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r89, final int r90, final int r91, final int r92) {
        /*
            Method dump skipped, instructions count: 1545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
