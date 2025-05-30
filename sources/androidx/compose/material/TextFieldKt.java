package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
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
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
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
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextFieldKt {
    private static final float FirstBaselineOffset = Dp.m2142constructorimpl(20);
    private static final float TextFieldBottomPadding = Dp.m2142constructorimpl(10);
    private static final float TextFieldTopPadding = Dp.m2142constructorimpl(4);

    /* JADX WARN: Code restructure failed: missing block: B:57:0x01b0, code lost:
    
        if (r7.changed(r84) == false) goto L145;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0074  */
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
    /* JADX WARN: Removed duplicated region for block: B:94:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TextField(@org.jetbrains.annotations.NotNull java.lang.String r71, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r72, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r73, boolean r74, boolean r75, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r76, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, boolean r81, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r82, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r83, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r87, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r88, @org.jetbrains.annotations.Nullable androidx.compose.material.TextFieldColors r89, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r90, int r91, int r92, int r93) {
        /*
            Method dump skipped, instructions count: 1568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void TextFieldLayout(@NotNull final Modifier modifier, @NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable final Function2<? super Composer, ? super Integer, Unit> function22, @Nullable final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, @Nullable final Function2<? super Composer, ? super Integer, Unit> function23, @Nullable final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final float f, @NotNull final PaddingValues paddingValues, @Nullable Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(function2, "textField");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer startRestartGroup = composer.startRestartGroup(-2112507061);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(function22) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(function3) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changed(function23) ? AccessibilityNodeInfoCompat.ACTION_COPY : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= startRestartGroup.changed(function24) ? AccessibilityNodeInfoCompat.ACTION_SET_SELECTION : AccessibilityNodeInfoCompat.ACTION_CUT;
        }
        if ((3670016 & i) == 0) {
            i2 |= startRestartGroup.changed(z) ? AccessibilityNodeInfoCompat.ACTION_DISMISS : AccessibilityNodeInfoCompat.ACTION_COLLAPSE;
        }
        if ((29360128 & i) == 0) {
            i2 |= startRestartGroup.changed(f) ? GravityCompat.RELATIVE_LAYOUT_DIRECTION : InputDeviceCompat.SOURCE_ROTARY_ENCODER;
        }
        if ((234881024 & i) == 0) {
            i2 |= startRestartGroup.changed(paddingValues) ? 67108864 : 33554432;
        }
        if ((191739611 & i2) == 38347922 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2112507061, i2, -1, "androidx.compose.material.TextFieldLayout (TextField.kt:365)");
            }
            Boolean valueOf = Boolean.valueOf(z);
            Float valueOf2 = Float.valueOf(f);
            startRestartGroup.startReplaceableGroup(1618982084);
            boolean changed = startRestartGroup.changed(valueOf) | startRestartGroup.changed(valueOf2) | startRestartGroup.changed(paddingValues);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new TextFieldMeasurePolicy(z, f, paddingValues);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) rememberedValue;
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode$Companion composeUiNode$Companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = composeUiNode$Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i3 = ((((i2 << 3) & 112) << 9) & 7168) | 6;
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
            Updater.m754setimpl(m747constructorimpl, textFieldMeasurePolicy, (Function2<? super T, ? super TextFieldMeasurePolicy, Unit>) composeUiNode$Companion.getSetMeasurePolicy());
            Updater.m754setimpl(m747constructorimpl, density, (Function2<? super T, ? super Density, Unit>) composeUiNode$Companion.getSetDensity());
            Updater.m754setimpl(m747constructorimpl, layoutDirection2, (Function2<? super T, ? super LayoutDirection, Unit>) composeUiNode$Companion.getSetLayoutDirection());
            Updater.m754setimpl(m747constructorimpl, viewConfiguration, (Function2<? super T, ? super ViewConfiguration, Unit>) composeUiNode$Companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(startRestartGroup)), startRestartGroup, Integer.valueOf((i3 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(642667778);
            if (((i3 >> 9) & 14 & 11) == 2 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
            } else {
                startRestartGroup.startReplaceableGroup(254816194);
                if (function23 != null) {
                    Modifier then = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.LeadingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center = Alignment.Companion.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor2 = composeUiNode$Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(then);
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
                    Composer m747constructorimpl2 = Updater.m747constructorimpl(startRestartGroup);
                    Updater.m754setimpl(m747constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) composeUiNode$Companion.getSetMeasurePolicy());
                    Updater.m754setimpl(m747constructorimpl2, density2, (Function2<? super T, ? super Density, Unit>) composeUiNode$Companion.getSetDensity());
                    Updater.m754setimpl(m747constructorimpl2, layoutDirection3, (Function2<? super T, ? super LayoutDirection, Unit>) composeUiNode$Companion.getSetLayoutDirection());
                    Updater.m754setimpl(m747constructorimpl2, viewConfiguration2, (Function2<? super T, ? super ViewConfiguration, Unit>) composeUiNode$Companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf2.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(822730659);
                    function23.invoke(startRestartGroup, Integer.valueOf((i2 >> 12) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(254816479);
                if (function24 != null) {
                    Modifier then2 = LayoutIdKt.layoutId(Modifier.Companion, TextFieldImplKt.TrailingId).then(TextFieldImplKt.getIconDefaultSizeModifier());
                    Alignment center2 = Alignment.Companion.getCenter();
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection4 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor3 = composeUiNode$Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(then2);
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
                    Composer m747constructorimpl3 = Updater.m747constructorimpl(startRestartGroup);
                    Updater.m754setimpl(m747constructorimpl3, rememberBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) composeUiNode$Companion.getSetMeasurePolicy());
                    Updater.m754setimpl(m747constructorimpl3, density3, (Function2<? super T, ? super Density, Unit>) composeUiNode$Companion.getSetDensity());
                    Updater.m754setimpl(m747constructorimpl3, layoutDirection4, (Function2<? super T, ? super LayoutDirection, Unit>) composeUiNode$Companion.getSetLayoutDirection());
                    Updater.m754setimpl(m747constructorimpl3, viewConfiguration3, (Function2<? super T, ? super ViewConfiguration, Unit>) composeUiNode$Companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf3.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-1007916070);
                    function24.invoke(startRestartGroup, Integer.valueOf((i2 >> 15) & 14));
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
                Modifier.Companion companion = Modifier.Companion;
                if (function23 != null) {
                    calculateStartPadding = Dp.m2142constructorimpl(RangesKt.coerceAtLeast(Dp.m2142constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m2142constructorimpl(0)));
                }
                float f2 = calculateStartPadding;
                if (function24 != null) {
                    calculateEndPadding = Dp.m2142constructorimpl(RangesKt.coerceAtLeast(Dp.m2142constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m2142constructorimpl(0)));
                }
                Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(companion, f2, 0.0f, calculateEndPadding, 0.0f, 10, (Object) null);
                startRestartGroup.startReplaceableGroup(254817490);
                if (function3 != null) {
                    function3.invoke(LayoutIdKt.layoutId(companion, TextFieldImplKt.PlaceholderId).then(modifier2), startRestartGroup, Integer.valueOf((i2 >> 6) & 112));
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(254817619);
                if (function22 != null) {
                    Modifier then3 = LayoutIdKt.layoutId(companion, TextFieldImplKt.LabelId).then(modifier2);
                    startRestartGroup.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    Density density4 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    LayoutDirection layoutDirection5 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                    ViewConfiguration viewConfiguration4 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                    Function0<ComposeUiNode> constructor4 = composeUiNode$Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf4 = LayoutKt.materializerOf(then3);
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
                    Composer m747constructorimpl4 = Updater.m747constructorimpl(startRestartGroup);
                    Updater.m754setimpl(m747constructorimpl4, rememberBoxMeasurePolicy3, (Function2<? super T, ? super MeasurePolicy, Unit>) composeUiNode$Companion.getSetMeasurePolicy());
                    Updater.m754setimpl(m747constructorimpl4, density4, (Function2<? super T, ? super Density, Unit>) composeUiNode$Companion.getSetDensity());
                    Updater.m754setimpl(m747constructorimpl4, layoutDirection5, (Function2<? super T, ? super LayoutDirection, Unit>) composeUiNode$Companion.getSetLayoutDirection());
                    Updater.m754setimpl(m747constructorimpl4, viewConfiguration4, (Function2<? super T, ? super ViewConfiguration, Unit>) composeUiNode$Companion.getSetViewConfiguration());
                    startRestartGroup.enableReusing();
                    materializerOf4.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    startRestartGroup.startReplaceableGroup(-2137368960);
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    startRestartGroup.startReplaceableGroup(1319246300);
                    function22.invoke(startRestartGroup, Integer.valueOf((i2 >> 6) & 14));
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                }
                startRestartGroup.endReplaceableGroup();
                Modifier then4 = LayoutIdKt.layoutId(companion, TextFieldImplKt.TextFieldId).then(modifier2);
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, startRestartGroup, 48);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density5 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection6 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration5 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor5 = composeUiNode$Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf5 = LayoutKt.materializerOf(then4);
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
                Composer m747constructorimpl5 = Updater.m747constructorimpl(startRestartGroup);
                Updater.m754setimpl(m747constructorimpl5, rememberBoxMeasurePolicy4, (Function2<? super T, ? super MeasurePolicy, Unit>) composeUiNode$Companion.getSetMeasurePolicy());
                Updater.m754setimpl(m747constructorimpl5, density5, (Function2<? super T, ? super Density, Unit>) composeUiNode$Companion.getSetDensity());
                Updater.m754setimpl(m747constructorimpl5, layoutDirection6, (Function2<? super T, ? super LayoutDirection, Unit>) composeUiNode$Companion.getSetLayoutDirection());
                Updater.m754setimpl(m747constructorimpl5, viewConfiguration5, (Function2<? super T, ? super ViewConfiguration, Unit>) composeUiNode$Companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf5.invoke(SkippableUpdater.box-impl(SkippableUpdater.constructor-impl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-2048931960);
                function2.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt$TextFieldLayout$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i4) {
                TextFieldKt.TextFieldLayout(modifier, function2, function22, function3, function23, function24, z, f, paddingValues, composer2, i | 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m696calculateHeightO3s9Psw(int i, boolean z, int i2, int i3, int i4, int i5, long j, float f, PaddingValues paddingValues) {
        float f2 = TextFieldTopPadding * f;
        float mo219calculateTopPaddingD9Ej5fM = paddingValues.mo219calculateTopPaddingD9Ej5fM() * f;
        float mo216calculateBottomPaddingD9Ej5fM = paddingValues.mo216calculateBottomPaddingD9Ej5fM() * f;
        int max = Math.max(i, i5);
        return Math.max(MathKt.roundToInt(z ? i2 + f2 + max + mo216calculateBottomPaddingD9Ej5fM : mo219calculateTopPaddingD9Ej5fM + max + mo216calculateBottomPaddingD9Ej5fM), Math.max(Math.max(i3, i4), Constraints.m2123getMinHeightimpl(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-VsPV1Ek, reason: not valid java name */
    public static final int m697calculateWidthVsPV1Ek(int i, int i2, int i3, int i4, int i5, long j) {
        return Math.max(i + Math.max(i3, Math.max(i4, i5)) + i2, Constraints.m2124getMinWidthimpl(j));
    }

    @NotNull
    public static final Modifier drawIndicatorLine(@NotNull Modifier modifier, @NotNull final BorderStroke borderStroke) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(borderStroke, "indicatorBorder");
        final float f = borderStroke.getWidth-D9Ej5fM();
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.TextFieldKt$drawIndicatorLine$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
                Intrinsics.checkNotNullParameter(contentDrawScope, "$this$drawWithContent");
                contentDrawScope.drawContent();
                if (Dp.m2147equalsimpl0(f, Dp.Companion.m2160getHairlineD9Ej5fM())) {
                    return;
                }
                float density = f * contentDrawScope.getDensity();
                float m900getHeightimpl = Size.m900getHeightimpl(contentDrawScope.mo1321getSizeNHjbRc()) - (density / 2);
                w51.B(contentDrawScope, borderStroke.getBrush(), OffsetKt.Offset(0.0f, m900getHeightimpl), OffsetKt.Offset(Size.m903getWidthimpl(contentDrawScope.mo1321getSizeNHjbRc()), m900getHeightimpl), density, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
            }
        });
    }

    public static final float getFirstBaselineOffset() {
        return FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldTopPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, boolean z, int i3, int i4, float f, float f2) {
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i2), 0.0f, 4, (Object) null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), Alignment.Companion.getCenterVertically().align(placeable5.getHeight(), i2), 0.0f, 4, (Object) null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), (z ? Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i2) : MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f2)) - MathKt.roundToInt((r0 - i3) * f), 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, (Object) null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, boolean z, float f, PaddingValues paddingValues) {
        int roundToInt = MathKt.roundToInt(paddingValues.mo219calculateTopPaddingD9Ej5fM() * f);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.Companion.getCenterVertically().align(placeable3.getHeight(), i2), 0.0f, 4, (Object) null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i2), 0.0f, 4, (Object) null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable3), z ? Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i2) : roundToInt, 0.0f, 4, (Object) null);
        if (placeable2 != null) {
            if (z) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i2);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable3), roundToInt, 0.0f, 4, (Object) null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x01b0, code lost:
    
        if (r7.changed(r84) == false) goto L145;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0074  */
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
    /* JADX WARN: Removed duplicated region for block: B:94:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TextField(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.input.TextFieldValue r71, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r72, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r73, boolean r74, boolean r75, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r76, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r78, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r80, boolean r81, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.input.VisualTransformation r82, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardOptions r83, @org.jetbrains.annotations.Nullable androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r87, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r88, @org.jetbrains.annotations.Nullable androidx.compose.material.TextFieldColors r89, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r90, int r91, int r92, int r93) {
        /*
            Method dump skipped, instructions count: 1531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
