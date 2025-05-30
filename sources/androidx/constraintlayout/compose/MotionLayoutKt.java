package androidx.constraintlayout.compose;

import android.annotation.SuppressLint;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasurePolicy$DefaultImpls;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable$PlacementScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a{\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u001e\b\u0004\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001ag\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u001e\b\u0004\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0018\u001a\u008d\u0001\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u0010\b\n\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d2\u001e\b\u0004\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u001f\u001a\u0087\u0001\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u001e\b\u0004\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\"\u001a\u008d\u0001\u0010#\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u0010\b\n\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001d2\u001e\b\u0004\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0081\bø\u0001\u0000¢\u0006\u0004\b#\u0010\u001f\u001ag\u0010#\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u001e\b\u0004\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0081\bø\u0001\u0000¢\u0006\u0004\b#\u0010\u0018\u001a\u0087\u0001\u0010#\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u001e\b\u0004\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0081\bø\u0001\u0000¢\u0006\u0004\b#\u0010\"\u001a\u0019\u0010$\u001a\u00020\u00162\b\b\u0001\u0010\u0013\u001a\u00020\u0019H\u0007¢\u0006\u0004\b$\u0010%\u001a\u001b\u0010&\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0019H\u0007¢\u0006\u0004\b&\u0010'\u001a]\u00100\u001a\u00020/2\u0006\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050,2\u0006\u0010.\u001a\u00020-H\u0001¢\u0006\u0004\b0\u00101\"\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b3\u00104\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintSet;", "start", "end", "Landroidx/constraintlayout/compose/Transition;", "transition", "", "progress", "Ljava/util/EnumSet;", "Landroidx/constraintlayout/compose/MotionLayoutDebugFlags;", "debug", "Landroidx/compose/ui/Modifier;", "modifier", "", "optimizationLevel", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/MotionLayoutScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "MotionLayout", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/Transition;FLjava/util/EnumSet;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/constraintlayout/compose/MotionScene;", "motionScene", "(Landroidx/constraintlayout/compose/MotionScene;FLjava/util/EnumSet;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "", "constraintSetName", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "Lkotlin/Function0;", "finishedAnimationListener", "(Landroidx/constraintlayout/compose/MotionScene;Ljava/lang/String;Landroidx/compose/animation/core/AnimationSpec;Ljava/util/EnumSet;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/constraintlayout/compose/LayoutInformationReceiver;", "informationReceiver", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/Transition;FLjava/util/EnumSet;Landroidx/constraintlayout/compose/LayoutInformationReceiver;Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "MotionLayoutCore", TypedValues.MotionScene.NAME, "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/constraintlayout/compose/MotionScene;", "Transition", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/constraintlayout/compose/Transition;", "", "needsUpdate", "constraintSetStart", "constraintSetEnd", "Landroidx/compose/runtime/MutableState;", "Landroidx/constraintlayout/compose/MotionMeasurer;", "measurer", "Landroidx/compose/ui/layout/MeasurePolicy;", "rememberMotionLayoutMeasurePolicy", "(ILjava/util/EnumSet;JLandroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/Transition;Landroidx/compose/runtime/MutableState;Landroidx/constraintlayout/compose/MotionMeasurer;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "", "DEBUG", "Z", "compose_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MotionLayoutKt {
    private static final boolean DEBUG = false;

    @Composable
    @ExperimentalMotionApi
    public static final void MotionLayout(@NotNull ConstraintSet constraintSet, @NotNull ConstraintSet constraintSet2, @Nullable Transition transition, float f, @Nullable EnumSet<MotionLayoutDebugFlags> enumSet, @Nullable Modifier modifier, int i, @NotNull Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i2, int i3) {
        EnumSet<MotionLayoutDebugFlags> enumSet2;
        Intrinsics.checkNotNullParameter(constraintSet, "start");
        Intrinsics.checkNotNullParameter(constraintSet2, "end");
        Intrinsics.checkNotNullParameter(function3, "content");
        composer.startReplaceableGroup(-1330873847);
        Transition transition2 = (i3 & 4) != 0 ? null : transition;
        if ((i3 & 16) != 0) {
            EnumSet<MotionLayoutDebugFlags> of = EnumSet.of(MotionLayoutDebugFlags.NONE);
            Intrinsics.checkNotNullExpressionValue(of, "of(MotionLayoutDebugFlags.NONE)");
            enumSet2 = of;
        } else {
            enumSet2 = enumSet;
        }
        Modifier modifier2 = (i3 & 32) != 0 ? Modifier.Companion : modifier;
        int i4 = (i3 & 64) != 0 ? 257 : i;
        int i5 = i2 << 3;
        int i6 = (i5 & 234881024) | 229376 | (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (i5 & 3670016) | (i5 & 29360128);
        composer.startReplaceableGroup(-1330870962);
        int i7 = 32768 | (i6 & 14) | (i6 & 112) | (i6 & 896) | (i6 & 7168) | (i6 & 458752) | (3670016 & i6) | (i6 & 29360128) | (i6 & 234881024);
        composer.startReplaceableGroup(-1401224268);
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new MotionMeasurer();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MotionMeasurer motionMeasurer = (MotionMeasurer) rememberedValue;
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new MotionLayoutScope(motionMeasurer);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MotionLayoutScope motionLayoutScope = (MotionLayoutScope) rememberedValue2;
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue3;
        mutableState.setValue(Float.valueOf(f));
        int i8 = i7 << 9;
        MeasurePolicy rememberMotionLayoutMeasurePolicy = rememberMotionLayoutMeasurePolicy(i4, enumSet2, 0L, constraintSet, constraintSet2, transition2, mutableState, motionMeasurer, composer, 18350528 | ((i7 >> 21) & 14) | (i8 & 7168) | (57344 & i8) | (i8 & 458752));
        motionMeasurer.addLayoutInformationReceiver((LayoutInformationReceiver) null);
        float forcedScaleFactor = motionMeasurer.getForcedScaleFactor();
        MotionLayoutDebugFlags motionLayoutDebugFlags = MotionLayoutDebugFlags.NONE;
        if (enumSet2.contains(motionLayoutDebugFlags) && Float.isNaN(forcedScaleFactor)) {
            composer.startReplaceableGroup(-1401222327);
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier2, false, new MotionLayoutCore.4(motionMeasurer), 1, (Object) null), ComposableLambdaKt.composableLambda(composer, -819896774, true, new MotionLayoutCore.5(function3, motionLayoutScope, i7)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1401223142);
            if (!Float.isNaN(forcedScaleFactor)) {
                modifier2 = ScaleKt.scale(modifier2, motionMeasurer.getForcedScaleFactor());
            }
            composer.startReplaceableGroup(-1990474327);
            Modifier.Companion companion2 = Modifier.Companion;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
            composer.startReplaceableGroup(1376089335);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0 constructor = companion3.getConstructor();
            Function3 materializerOf = LayoutKt.materializerOf(companion2);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composer2 = Updater.constructor-impl(composer);
            Updater.set-impl(composer2, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.set-impl(composer2, density, companion3.getSetDensity());
            Updater.set-impl(composer2, layoutDirection, companion3.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier2, false, new MotionLayoutKt$MotionLayoutCore$3$1(motionMeasurer), 1, (Object) null), ComposableLambdaKt.composableLambda(composer, -819900388, true, new MotionLayoutKt$MotionLayoutCore$3$2(function3, motionLayoutScope, i7)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
            if (Float.isNaN(forcedScaleFactor)) {
                composer.startReplaceableGroup(-922833807);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-922833881);
                motionMeasurer.drawDebugBounds(boxScopeInstance, forcedScaleFactor, composer, 518);
                composer.endReplaceableGroup();
            }
            if (enumSet2.contains(motionLayoutDebugFlags)) {
                composer.startReplaceableGroup(-922833689);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-922833740);
                motionMeasurer.drawDebug(boxScopeInstance, composer, 70);
                composer.endReplaceableGroup();
            }
            Unit unit = Unit.INSTANCE;
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x01c5, code lost:
    
        if (r9 == r17.getEmpty()) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02d4, code lost:
    
        if ((((java.lang.Number) r4.getValue()).floatValue() == ((java.lang.Number) r22.getValue()).floatValue()) != false) goto L119;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v23, types: [androidx.compose.animation.core.TweenSpec] */
    @androidx.compose.runtime.Composable
    @kotlin.PublishedApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MotionLayoutCore(@org.jetbrains.annotations.NotNull androidx.constraintlayout.compose.MotionScene r28, @org.jetbrains.annotations.Nullable java.lang.String r29, @org.jetbrains.annotations.Nullable androidx.compose.animation.core.AnimationSpec<java.lang.Float> r30, @org.jetbrains.annotations.Nullable java.util.EnumSet<androidx.constraintlayout.compose.MotionLayoutDebugFlags> r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r32, int r33, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r34, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.constraintlayout.compose.MotionLayoutScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            Method dump skipped, instructions count: 1348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore(androidx.constraintlayout.compose.MotionScene, java.lang.String, androidx.compose.animation.core.AnimationSpec, java.util.EnumSet, androidx.compose.ui.Modifier, int, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-11, reason: not valid java name */
    public static final ConstraintSet m2759MotionLayoutCore$lambda11(MutableState<ConstraintSet> mutableState) {
        return (ConstraintSet) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-16, reason: not valid java name */
    public static final boolean m2761MotionLayoutCore$lambda16(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-17, reason: not valid java name */
    public static final void m2762MotionLayoutCore$lambda17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-26, reason: not valid java name */
    public static final float m2763MotionLayoutCore$lambda26(MutableState<Float> mutableState) {
        return ((Number) mutableState.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-27, reason: not valid java name */
    public static final void m2764MotionLayoutCore$lambda27(MutableState<Float> mutableState, float f) {
        mutableState.setValue(Float.valueOf(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: MotionLayoutCore$lambda-8, reason: not valid java name */
    public static final ConstraintSet m2765MotionLayoutCore$lambda8(MutableState<ConstraintSet> mutableState) {
        return (ConstraintSet) mutableState.getValue();
    }

    @Composable
    @SuppressLint({"ComposableNaming"})
    @NotNull
    public static final MotionScene MotionScene(@Language("json5") @NotNull String str, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(str, "content");
        composer.startReplaceableGroup(1405665503);
        composer.startReplaceableGroup(-3686930);
        boolean changed = composer.changed(str);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new JSONMotionScene(str);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        JSONMotionScene jSONMotionScene = (JSONMotionScene) rememberedValue;
        composer.endReplaceableGroup();
        return jSONMotionScene;
    }

    @Composable
    @SuppressLint({"ComposableNaming"})
    @Nullable
    public static final Transition Transition(@Language("json5") @NotNull String str, @Nullable Composer composer, int i) {
        final CLObject cLObject;
        Intrinsics.checkNotNullParameter(str, "content");
        composer.startReplaceableGroup(811760201);
        composer.startReplaceableGroup(-3686930);
        boolean changed = composer.changed(str);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            try {
                cLObject = CLParser.parse(str);
            } catch (CLParsingException e) {
                System.err.println(Intrinsics.stringPlus("Error parsing JSON ", e));
                cLObject = null;
            }
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(cLObject != null ? new Transition() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$Transition$transition$1$1
                public void applyTo(@NotNull Transition transition, int i2) {
                    Intrinsics.checkNotNullParameter(transition, "transition");
                    try {
                        ConstraintSetParserKt.parseTransition(cLObject, transition);
                    } catch (CLParsingException e2) {
                        System.err.println(Intrinsics.stringPlus("Error parsing JSON ", e2));
                    }
                }

                @NotNull
                public String getEndConstraintSetId() {
                    String stringOrNull = cLObject.getStringOrNull("to");
                    return stringOrNull == null ? "end" : stringOrNull;
                }

                @NotNull
                public String getStartConstraintSetId() {
                    String stringOrNull = cLObject.getStringOrNull("from");
                    return stringOrNull == null ? "start" : stringOrNull;
                }
            } : null, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MotionLayoutKt$Transition$transition$1$1 motionLayoutKt$Transition$transition$1$1 = (MotionLayoutKt$Transition$transition$1$1) ((MutableState) rememberedValue).getValue();
        composer.endReplaceableGroup();
        return motionLayoutKt$Transition$transition$1$1;
    }

    @Composable
    @PublishedApi
    @NotNull
    public static final MeasurePolicy rememberMotionLayoutMeasurePolicy(final int i, @NotNull EnumSet<MotionLayoutDebugFlags> enumSet, long j, @NotNull final ConstraintSet constraintSet, @NotNull final ConstraintSet constraintSet2, @Nullable final Transition transition, @NotNull final MutableState<Float> mutableState, @NotNull final MotionMeasurer motionMeasurer, @Nullable Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(enumSet, "debug");
        Intrinsics.checkNotNullParameter(constraintSet, "constraintSetStart");
        Intrinsics.checkNotNullParameter(constraintSet2, "constraintSetEnd");
        Intrinsics.checkNotNullParameter(mutableState, "progress");
        Intrinsics.checkNotNullParameter(motionMeasurer, "measurer");
        composer.startReplaceableGroup(-1875584384);
        int i3 = 0;
        Object[] objArr = {Integer.valueOf(i), enumSet, Long.valueOf(j), constraintSet, constraintSet2, transition};
        composer.startReplaceableGroup(-3685570);
        boolean z = false;
        while (i3 < 6) {
            Object obj = objArr[i3];
            i3++;
            z |= composer.changed(obj);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            motionMeasurer.initWith(constraintSet, constraintSet2, transition, ((Number) mutableState.getValue()).floatValue());
            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$rememberMotionLayoutMeasurePolicy$1$1
                public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i4) {
                    return MeasurePolicy$DefaultImpls.maxIntrinsicHeight(this, intrinsicMeasureScope, list, i4);
                }

                public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i4) {
                    return MeasurePolicy$DefaultImpls.maxIntrinsicWidth(this, intrinsicMeasureScope, list, i4);
                }

                @NotNull
                /* renamed from: measure-3p2s80s, reason: not valid java name */
                public final MeasureResult m2775measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull final List<? extends Measurable> list, long j2) {
                    Intrinsics.checkNotNullParameter(measureScope, "$this$MeasurePolicy");
                    Intrinsics.checkNotNullParameter(list, "measurables");
                    long j3 = motionMeasurer.performInterpolationMeasure-OQbXsTc(j2, measureScope.getLayoutDirection(), constraintSet, constraintSet2, transition, list, i, ((Number) mutableState.getValue()).floatValue(), measureScope);
                    int m2685getWidthimpl = IntSize.m2685getWidthimpl(j3);
                    int m2684getHeightimpl = IntSize.m2684getHeightimpl(j3);
                    final MotionMeasurer motionMeasurer2 = motionMeasurer;
                    return MeasureScope.DefaultImpls.layout$default(measureScope, m2685getWidthimpl, m2684getHeightimpl, (Map) null, new Function1<Placeable$PlacementScope, Unit>() { // from class: androidx.constraintlayout.compose.MotionLayoutKt$rememberMotionLayoutMeasurePolicy$1$1$measure$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((Placeable$PlacementScope) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull Placeable$PlacementScope placeable$PlacementScope) {
                            Intrinsics.checkNotNullParameter(placeable$PlacementScope, "$this$layout");
                            motionMeasurer2.performLayout(placeable$PlacementScope, list);
                        }
                    }, 4, (Object) null);
                }

                public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i4) {
                    return MeasurePolicy$DefaultImpls.minIntrinsicHeight(this, intrinsicMeasureScope, list, i4);
                }

                public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i4) {
                    return MeasurePolicy$DefaultImpls.minIntrinsicWidth(this, intrinsicMeasureScope, list, i4);
                }
            };
            composer.updateRememberedValue(measurePolicy);
            rememberedValue = measurePolicy;
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy2 = (MeasurePolicy) rememberedValue;
        composer.endReplaceableGroup();
        return measurePolicy2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x01a4, code lost:
    
        if ((m2763MotionLayoutCore$lambda26(r6) == r22) != false) goto L67;
     */
    @androidx.compose.runtime.Composable
    @androidx.constraintlayout.compose.ExperimentalMotionApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MotionLayout(@org.jetbrains.annotations.NotNull androidx.constraintlayout.compose.MotionScene r21, float r22, @org.jetbrains.annotations.Nullable java.util.EnumSet<androidx.constraintlayout.compose.MotionLayoutDebugFlags> r23, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r24, int r25, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.constraintlayout.compose.MotionLayoutScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 1006
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayout(androidx.constraintlayout.compose.MotionScene, float, java.util.EnumSet, androidx.compose.ui.Modifier, int, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0183, code lost:
    
        if ((m2763MotionLayoutCore$lambda26(r3) == r23) != false) goto L67;
     */
    @androidx.compose.runtime.Composable
    @kotlin.PublishedApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MotionLayoutCore(@org.jetbrains.annotations.NotNull androidx.constraintlayout.compose.MotionScene r22, float r23, @org.jetbrains.annotations.Nullable java.util.EnumSet<androidx.constraintlayout.compose.MotionLayoutDebugFlags> r24, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r25, int r26, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.constraintlayout.compose.MotionLayoutScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            Method dump skipped, instructions count: 970
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayoutCore(androidx.constraintlayout.compose.MotionScene, float, java.util.EnumSet, androidx.compose.ui.Modifier, int, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x01e8, code lost:
    
        if (r9 == r22.getEmpty()) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x02f7, code lost:
    
        if ((((java.lang.Number) r4.getValue()).floatValue() == ((java.lang.Number) r27.getValue()).floatValue()) != false) goto L119;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v23, types: [androidx.compose.animation.core.TweenSpec] */
    @androidx.compose.runtime.Composable
    @androidx.constraintlayout.compose.ExperimentalMotionApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MotionLayout(@org.jetbrains.annotations.NotNull androidx.constraintlayout.compose.MotionScene r33, @org.jetbrains.annotations.Nullable java.lang.String r34, @org.jetbrains.annotations.Nullable androidx.compose.animation.core.AnimationSpec<java.lang.Float> r35, @org.jetbrains.annotations.Nullable java.util.EnumSet<androidx.constraintlayout.compose.MotionLayoutDebugFlags> r36, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r37, int r38, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r39, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.constraintlayout.compose.MotionLayoutScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            Method dump skipped, instructions count: 1381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionLayoutKt.MotionLayout(androidx.constraintlayout.compose.MotionScene, java.lang.String, androidx.compose.animation.core.AnimationSpec, java.util.EnumSet, androidx.compose.ui.Modifier, int, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    @Composable
    @PublishedApi
    public static final void MotionLayoutCore(@NotNull ConstraintSet constraintSet, @NotNull ConstraintSet constraintSet2, @Nullable Transition transition, float f, @Nullable EnumSet<MotionLayoutDebugFlags> enumSet, @Nullable LayoutInformationReceiver layoutInformationReceiver, @Nullable Modifier modifier, int i, @NotNull Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i2, int i3) {
        EnumSet<MotionLayoutDebugFlags> enumSet2;
        Intrinsics.checkNotNullParameter(constraintSet, "start");
        Intrinsics.checkNotNullParameter(constraintSet2, "end");
        Intrinsics.checkNotNullParameter(function3, "content");
        composer.startReplaceableGroup(-1401224268);
        Transition transition2 = (i3 & 4) != 0 ? null : transition;
        if ((i3 & 16) != 0) {
            EnumSet<MotionLayoutDebugFlags> of = EnumSet.of(MotionLayoutDebugFlags.NONE);
            Intrinsics.checkNotNullExpressionValue(of, "of(MotionLayoutDebugFlags.NONE)");
            enumSet2 = of;
        } else {
            enumSet2 = enumSet;
        }
        LayoutInformationReceiver layoutInformationReceiver2 = (i3 & 32) != 0 ? null : layoutInformationReceiver;
        Modifier modifier2 = (i3 & 64) != 0 ? Modifier.Companion : modifier;
        int i4 = (i3 & 128) != 0 ? 257 : i;
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new MotionMeasurer();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MotionMeasurer motionMeasurer = (MotionMeasurer) rememberedValue;
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new MotionLayoutScope(motionMeasurer);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MotionLayoutScope motionLayoutScope = (MotionLayoutScope) rememberedValue2;
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue3;
        mutableState.setValue(Float.valueOf(f));
        int i5 = i2 << 9;
        Modifier modifier3 = modifier2;
        MeasurePolicy rememberMotionLayoutMeasurePolicy = rememberMotionLayoutMeasurePolicy(i4, enumSet2, 0L, constraintSet, constraintSet2, transition2, mutableState, motionMeasurer, composer, 18350528 | ((i2 >> 21) & 14) | (i5 & 7168) | (57344 & i5) | (i5 & 458752));
        motionMeasurer.addLayoutInformationReceiver(layoutInformationReceiver2);
        float forcedScaleFactor = motionMeasurer.getForcedScaleFactor();
        MotionLayoutDebugFlags motionLayoutDebugFlags = MotionLayoutDebugFlags.NONE;
        if (enumSet2.contains(motionLayoutDebugFlags) && Float.isNaN(forcedScaleFactor)) {
            composer.startReplaceableGroup(-1401222327);
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier3, false, new MotionLayoutCore.4(motionMeasurer), 1, (Object) null), ComposableLambdaKt.composableLambda(composer, -819896774, true, new MotionLayoutCore.5(function3, motionLayoutScope, i2)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1401223142);
            Modifier scale = !Float.isNaN(forcedScaleFactor) ? ScaleKt.scale(modifier3, motionMeasurer.getForcedScaleFactor()) : modifier3;
            composer.startReplaceableGroup(-1990474327);
            Modifier.Companion companion2 = Modifier.Companion;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
            composer.startReplaceableGroup(1376089335);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0 constructor = companion3.getConstructor();
            Function3 materializerOf = LayoutKt.materializerOf(companion2);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composer2 = Updater.constructor-impl(composer);
            Updater.set-impl(composer2, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.set-impl(composer2, density, companion3.getSetDensity());
            Updater.set-impl(composer2, layoutDirection, companion3.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(scale, false, new MotionLayoutKt$MotionLayoutCore$3$1(motionMeasurer), 1, (Object) null), ComposableLambdaKt.composableLambda(composer, -819900388, true, new MotionLayoutKt$MotionLayoutCore$3$2(function3, motionLayoutScope, i2)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
            if (!Float.isNaN(forcedScaleFactor)) {
                composer.startReplaceableGroup(-922833881);
                motionMeasurer.drawDebugBounds(boxScopeInstance, forcedScaleFactor, composer, 518);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-922833807);
                composer.endReplaceableGroup();
            }
            if (!enumSet2.contains(motionLayoutDebugFlags)) {
                composer.startReplaceableGroup(-922833740);
                motionMeasurer.drawDebug(boxScopeInstance, composer, 70);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-922833689);
                composer.endReplaceableGroup();
            }
            Unit unit = Unit.INSTANCE;
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    @ExperimentalMotionApi
    public static final void MotionLayout(@NotNull ConstraintSet constraintSet, @NotNull ConstraintSet constraintSet2, @Nullable Transition transition, float f, @Nullable EnumSet<MotionLayoutDebugFlags> enumSet, @Nullable LayoutInformationReceiver layoutInformationReceiver, @Nullable Modifier modifier, int i, @NotNull Function3<? super MotionLayoutScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i2, int i3) {
        EnumSet<MotionLayoutDebugFlags> enumSet2;
        Intrinsics.checkNotNullParameter(constraintSet, "start");
        Intrinsics.checkNotNullParameter(constraintSet2, "end");
        Intrinsics.checkNotNullParameter(function3, "content");
        composer.startReplaceableGroup(-1330870962);
        Transition transition2 = (i3 & 4) != 0 ? null : transition;
        if ((i3 & 16) != 0) {
            EnumSet<MotionLayoutDebugFlags> of = EnumSet.of(MotionLayoutDebugFlags.NONE);
            Intrinsics.checkNotNullExpressionValue(of, "of(MotionLayoutDebugFlags.NONE)");
            enumSet2 = of;
        } else {
            enumSet2 = enumSet;
        }
        LayoutInformationReceiver layoutInformationReceiver2 = (i3 & 32) != 0 ? null : layoutInformationReceiver;
        Modifier modifier2 = (i3 & 64) != 0 ? Modifier.Companion : modifier;
        int i4 = (i3 & 128) != 0 ? 257 : i;
        int i5 = 32768 | (i2 & 14) | (i2 & 112) | (i2 & 896) | (i2 & 7168) | (i2 & 458752) | (3670016 & i2) | (29360128 & i2) | (i2 & 234881024);
        composer.startReplaceableGroup(-1401224268);
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new MotionMeasurer();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MotionMeasurer motionMeasurer = (MotionMeasurer) rememberedValue;
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new MotionLayoutScope(motionMeasurer);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        MotionLayoutScope motionLayoutScope = (MotionLayoutScope) rememberedValue2;
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue3;
        mutableState.setValue(Float.valueOf(f));
        int i6 = i5 << 9;
        Modifier modifier3 = modifier2;
        MeasurePolicy rememberMotionLayoutMeasurePolicy = rememberMotionLayoutMeasurePolicy(i4, enumSet2, 0L, constraintSet, constraintSet2, transition2, mutableState, motionMeasurer, composer, 18350528 | ((i5 >> 21) & 14) | (i6 & 7168) | (57344 & i6) | (i6 & 458752));
        motionMeasurer.addLayoutInformationReceiver(layoutInformationReceiver2);
        float forcedScaleFactor = motionMeasurer.getForcedScaleFactor();
        MotionLayoutDebugFlags motionLayoutDebugFlags = MotionLayoutDebugFlags.NONE;
        if (enumSet2.contains(motionLayoutDebugFlags) && Float.isNaN(forcedScaleFactor)) {
            composer.startReplaceableGroup(-1401222327);
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier3, false, new MotionLayoutCore.4(motionMeasurer), 1, (Object) null), ComposableLambdaKt.composableLambda(composer, -819896774, true, new MotionLayoutCore.5(function3, motionLayoutScope, i5)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1401223142);
            Modifier scale = !Float.isNaN(forcedScaleFactor) ? ScaleKt.scale(modifier3, motionMeasurer.getForcedScaleFactor()) : modifier3;
            composer.startReplaceableGroup(-1990474327);
            Modifier.Companion companion2 = Modifier.Companion;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
            composer.startReplaceableGroup(1376089335);
            Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion3 = ComposeUiNode.Companion;
            Function0 constructor = companion3.getConstructor();
            Function3 materializerOf = LayoutKt.materializerOf(companion2);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            composer.disableReusing();
            Composer composer2 = Updater.constructor-impl(composer);
            Updater.set-impl(composer2, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.set-impl(composer2, density, companion3.getSetDensity());
            Updater.set-impl(composer2, layoutDirection, companion3.getSetLayoutDirection());
            composer.enableReusing();
            materializerOf.invoke(SkippableUpdater.m907boximpl(SkippableUpdater.m908constructorimpl(composer)), composer, 0);
            composer.startReplaceableGroup(2058660585);
            composer.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(scale, false, new MotionLayoutKt$MotionLayoutCore$3$1(motionMeasurer), 1, (Object) null), ComposableLambdaKt.composableLambda(composer, -819900388, true, new MotionLayoutKt$MotionLayoutCore$3$2(function3, motionLayoutScope, i5)), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
            if (!Float.isNaN(forcedScaleFactor)) {
                composer.startReplaceableGroup(-922833881);
                motionMeasurer.drawDebugBounds(boxScopeInstance, forcedScaleFactor, composer, 518);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-922833807);
                composer.endReplaceableGroup();
            }
            if (!enumSet2.contains(motionLayoutDebugFlags)) {
                composer.startReplaceableGroup(-922833740);
                motionMeasurer.drawDebug(boxScopeInstance, composer, 70);
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-922833689);
                composer.endReplaceableGroup();
            }
            Unit unit = Unit.INSTANCE;
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endNode();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }
}
