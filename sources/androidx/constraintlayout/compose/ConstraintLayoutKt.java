package androidx.constraintlayout.compose;

import android.annotation.SuppressLint;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ScaleKt;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.LayoutIdKt;
import androidx.compose.p004ui.layout.LayoutKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.semantics.SemanticsModifierKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.EnumSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import org.intellij.lang.annotations.Language;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gs;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aG\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u001e\b\u0004\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001aG\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00140\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001ap\u0010\n\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u000e2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0010\b\n\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00142\u0013\b\b\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00060\u0014¢\u0006\u0002\b\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u001e\u001a5\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\r2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0015\u0010!\u001a\b\u0010#\u001a\u00020\"H\u0000\u001a\u001f\u0010*\u001a\u00020'*\u00020$2\u0006\u0010&\u001a\u00020%ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b(\u0010)\u001a\u001f\u0010.\u001a\u00020+*\u00020$2\u0006\u0010&\u001a\u00020%ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b,\u0010-\u001a!\u00102\u001a\u00020/*\u00020+2\u0006\u0010&\u001a\u00020%H\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b0\u00101\u001a\u001f\u0010*\u001a\u00020/*\u00020+2\u0006\u0010&\u001a\u00020%ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b(\u00101\u001a\u001f\u0010.\u001a\u00020/*\u00020'2\u0006\u0010&\u001a\u00020%ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b,\u00103\u001a%\u00106\u001a\u00020\u00172\b\b\u0001\u0010\t\u001a\u0002042\n\b\u0003\u00105\u001a\u0004\u0018\u000104H\u0007¢\u0006\u0004\b6\u00107\u001a\u0010\u00106\u001a\u00020\u00172\b\b\u0001\u00108\u001a\u000204\u001a\u0018\u00106\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u00172\b\b\u0001\u00108\u001a\u000204\u001a\u001f\u00106\u001a\u00020\u00172\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\b\u001a'\u00106\u001a\u00020\u00172\u0006\u00109\u001a\u00020\u00172\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\b\u001a\u001e\u0010A\u001a\u00020\u00062\u0006\u0010=\u001a\u00020<2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020?0>H\u0000\u001a\f\u0010C\u001a\u000204*\u00020BH\u0002\u001a\f\u0010C\u001a\u000204*\u00020DH\u0002\"\u0016\u0010E\u001a\u00020\u000e8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\bE\u0010F\"\u0017\u00102\u001a\u00020'*\u00020$8F@\u0006¢\u0006\u0006\u001a\u0004\bG\u0010H\"\u0017\u0010K\u001a\u00020+*\u00020$8F@\u0006¢\u0006\u0006\u001a\u0004\bI\u0010J\"\u0017\u00102\u001a\u00020/*\u00020+8F@\u0006¢\u0006\u0006\u001a\u0004\bG\u0010L\"\u0017\u0010K\u001a\u00020/*\u00020'8F@\u0006¢\u0006\u0006\u001a\u0004\bI\u0010M*\f\b\u0000\u0010O\"\u00020N2\u00020N*\f\b\u0000\u0010Q\"\u00020P2\u00020P*\f\b\u0000\u0010S\"\u00020R2\u00020R*\f\b\u0000\u0010U\"\u00020T2\u00020T\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006V"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "", "optimizationLevel", "Lkotlin/Function1;", "Landroidx/constraintlayout/compose/ConstraintLayoutScope;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "ConstraintLayout", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "scope", "Landroidx/compose/runtime/MutableState;", "", "remeasureRequesterState", "Landroidx/constraintlayout/compose/Measurer;", "measurer", "Lkotlin/Pair;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Lkotlin/Function0;", "rememberConstraintLayoutMeasurePolicy", "(ILandroidx/constraintlayout/compose/ConstraintLayoutScope;Landroidx/compose/runtime/MutableState;Landroidx/constraintlayout/compose/Measurer;Landroidx/compose/runtime/Composer;I)Lkotlin/Pair;", "Landroidx/constraintlayout/compose/ConstraintSet;", "constraintSet", "animateChanges", "Landroidx/compose/animation/core/AnimationSpec;", "", "animationSpec", "finishedAnimationListener", "(Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/compose/ui/Modifier;IZLandroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "", "needsUpdate", "(ILandroidx/compose/runtime/MutableState;Landroidx/constraintlayout/compose/ConstraintSet;Landroidx/constraintlayout/compose/Measurer;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "", "createId", "Landroidx/constraintlayout/compose/Dimension$Coercible;", "Landroidx/compose/ui/unit/Dp;", "dp", "Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "atLeast-3ABfNKs", "(Landroidx/constraintlayout/compose/Dimension$Coercible;F)Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "atLeast", "Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "atMost-3ABfNKs", "(Landroidx/constraintlayout/compose/Dimension$Coercible;F)Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "atMost", "Landroidx/constraintlayout/compose/Dimension;", "atLeastWrapContent-3ABfNKs", "(Landroidx/constraintlayout/compose/Dimension$MinCoercible;F)Landroidx/constraintlayout/compose/Dimension;", "atLeastWrapContent", "(Landroidx/constraintlayout/compose/Dimension$MaxCoercible;F)Landroidx/constraintlayout/compose/Dimension;", "", "overrideVariables", "ConstraintSet", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/constraintlayout/compose/ConstraintSet;", "jsonContent", "extendConstraintSet", "Landroidx/constraintlayout/compose/ConstraintSetScope;", "description", "Landroidx/constraintlayout/compose/State;", "state", "", "Landroidx/compose/ui/layout/Measurable;", "measurables", "buildMapping", "Landroidx/constraintlayout/core/widgets/ConstraintWidget;", "toDebugString", "Landroidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure;", "DEBUG", "Z", "getAtLeastWrapContent", "(Landroidx/constraintlayout/compose/Dimension$Coercible;)Landroidx/constraintlayout/compose/Dimension$MaxCoercible;", "getAtMostWrapContent", "(Landroidx/constraintlayout/compose/Dimension$Coercible;)Landroidx/constraintlayout/compose/Dimension$MinCoercible;", "atMostWrapContent", "(Landroidx/constraintlayout/compose/Dimension$MinCoercible;)Landroidx/constraintlayout/compose/Dimension;", "(Landroidx/constraintlayout/compose/Dimension$MaxCoercible;)Landroidx/constraintlayout/compose/Dimension;", "Landroidx/constraintlayout/core/state/State$Chain;", "SolverChain", "Landroidx/constraintlayout/core/state/Dimension;", "SolverDimension", "Landroidx/constraintlayout/core/state/State$Direction;", "SolverDirection", "Landroidx/constraintlayout/core/state/State;", "SolverState", "compose_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConstraintLayoutKt {
    private static final boolean DEBUG = false;

    @Composable
    public static final void ConstraintLayout(@Nullable Modifier modifier, int i, @NotNull final Function3<? super ConstraintLayoutScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, final int i2, int i3) {
        Intrinsics.checkNotNullParameter(function3, "content");
        composer.startReplaceableGroup(-270267587);
        if ((i3 & 1) != 0) {
            modifier = Modifier.Companion;
        }
        int i4 = (i3 & 2) != 0 ? 257 : i;
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Measurer();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final Measurer measurer = (Measurer) rememberedValue;
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new ConstraintLayoutScope();
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        final ConstraintLayoutScope constraintLayoutScope = (ConstraintLayoutScope) rememberedValue2;
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Pair<MeasurePolicy, Function0<Unit>> rememberConstraintLayoutMeasurePolicy = rememberConstraintLayoutMeasurePolicy(i4, constraintLayoutScope, (MutableState<Boolean>) rememberedValue3, measurer, composer, ((i2 >> 3) & 14) | 4544);
        MeasurePolicy measurePolicy = (MeasurePolicy) rememberConstraintLayoutMeasurePolicy.component1();
        final Function0 function0 = (Function0) rememberConstraintLayoutMeasurePolicy.component2();
        LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
                ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, Measurer.this);
            }
        }, 1, null), ComposableLambdaKt.composableLambda(composer, -819894182, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@Nullable Composer composer2, int i5) {
                if (((i5 & 11) ^ 2) == 0 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                int helpersHashCode = ConstraintLayoutScope.this.getHelpersHashCode();
                ConstraintLayoutScope.this.reset();
                function3.invoke(ConstraintLayoutScope.this, composer2, Integer.valueOf(((i2 >> 3) & 112) | 8));
                if (ConstraintLayoutScope.this.getHelpersHashCode() != helpersHashCode) {
                    function0.invoke();
                }
            }
        }), measurePolicy, composer, 48, 0);
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ConstraintLayout$lambda-6, reason: not valid java name */
    public static final ConstraintSet m5510ConstraintLayout$lambda6(MutableState<ConstraintSet> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ConstraintLayout$lambda-9, reason: not valid java name */
    public static final ConstraintSet m5512ConstraintLayout$lambda9(MutableState<ConstraintSet> mutableState) {
        return mutableState.getValue();
    }

    @Composable
    @SuppressLint({"ComposableNaming"})
    @NotNull
    public static final ConstraintSet ConstraintSet(@Language("json5") @NotNull String str, @Language("json5") @Nullable String str2, @Nullable Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "content");
        composer.startReplaceableGroup(1704604894);
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        composer.startReplaceableGroup(-3686552);
        boolean changed = composer.changed(str) | composer.changed(str3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new JSONConstraintSet(str, str3, null, 4, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        JSONConstraintSet jSONConstraintSet = (JSONConstraintSet) rememberedValue;
        composer.endReplaceableGroup();
        return jSONConstraintSet;
    }

    @NotNull
    /* renamed from: atLeast-3ABfNKs, reason: not valid java name */
    public static final Dimension.MaxCoercible m5517atLeast3ABfNKs(@NotNull Dimension.Coercible coercible, float f) {
        Intrinsics.checkNotNullParameter(coercible, "$this$atLeast");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.m5531setMinYLDhkOg(C0856Dp.m5214boximpl(f));
        return dimensionDescription;
    }

    @Deprecated(message = "Unintended method name, use atLeast(dp) instead", replaceWith = @ReplaceWith(expression = "this.atLeast(dp)", imports = {"androidx.constraintlayout.compose.atLeast"}))
    @NotNull
    /* renamed from: atLeastWrapContent-3ABfNKs, reason: not valid java name */
    public static final Dimension m5519atLeastWrapContent3ABfNKs(@NotNull Dimension.MinCoercible minCoercible, float f) {
        Intrinsics.checkNotNullParameter(minCoercible, "$this$atLeastWrapContent");
        DimensionDescription dimensionDescription = (DimensionDescription) minCoercible;
        dimensionDescription.m5531setMinYLDhkOg(C0856Dp.m5214boximpl(f));
        return dimensionDescription;
    }

    @NotNull
    /* renamed from: atMost-3ABfNKs, reason: not valid java name */
    public static final Dimension.MinCoercible m5520atMost3ABfNKs(@NotNull Dimension.Coercible coercible, float f) {
        Intrinsics.checkNotNullParameter(coercible, "$this$atMost");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.m5530setMaxYLDhkOg(C0856Dp.m5214boximpl(f));
        return dimensionDescription;
    }

    public static final void buildMapping(@NotNull State state, @NotNull List<? extends Measurable> list) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(list, "measurables");
        int size = list.size() - 1;
        if (size < 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i + 1;
            Measurable measurable = list.get(i);
            Object layoutId = LayoutIdKt.getLayoutId(measurable);
            if (layoutId == null && (layoutId = ConstraintLayoutTagKt.getConstraintLayoutId(measurable)) == null) {
                layoutId = createId();
            }
            state.map(layoutId, measurable);
            Object constraintLayoutTag = ConstraintLayoutTagKt.getConstraintLayoutTag(measurable);
            if (constraintLayoutTag != null && (constraintLayoutTag instanceof String) && (layoutId instanceof String)) {
                state.setTag((String) layoutId, (String) constraintLayoutTag);
            }
            if (i2 > size) {
                return;
            } else {
                i = i2;
            }
        }
    }

    @NotNull
    public static final Object createId() {
        return new Object() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$createId$1
        };
    }

    @NotNull
    public static final Dimension.MaxCoercible getAtLeastWrapContent(@NotNull Dimension.Coercible coercible) {
        Intrinsics.checkNotNullParameter(coercible, "<this>");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.setMinSymbol(androidx.constraintlayout.core.state.Dimension.WRAP_DIMENSION);
        return dimensionDescription;
    }

    @NotNull
    public static final Dimension.MinCoercible getAtMostWrapContent(@NotNull Dimension.Coercible coercible) {
        Intrinsics.checkNotNullParameter(coercible, "<this>");
        DimensionDescription dimensionDescription = (DimensionDescription) coercible;
        dimensionDescription.setMaxSymbol(androidx.constraintlayout.core.state.Dimension.WRAP_DIMENSION);
        return dimensionDescription;
    }

    @Composable
    @PublishedApi
    @NotNull
    public static final Pair<MeasurePolicy, Function0<Unit>> rememberConstraintLayoutMeasurePolicy(final int i, @NotNull ConstraintLayoutScope constraintLayoutScope, @NotNull final MutableState<Boolean> mutableState, @NotNull final Measurer measurer, @Nullable Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(constraintLayoutScope, "scope");
        Intrinsics.checkNotNullParameter(mutableState, "remeasureRequesterState");
        Intrinsics.checkNotNullParameter(measurer, "measurer");
        composer.startReplaceableGroup(-441911751);
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new ConstraintSetForInlineDsl(constraintLayoutScope);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        final ConstraintSetForInlineDsl constraintSetForInlineDsl = (ConstraintSetForInlineDsl) rememberedValue;
        Integer valueOf = Integer.valueOf(i);
        composer.startReplaceableGroup(-3686930);
        boolean changed = composer.changed(valueOf);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = TuplesKt.to(new MeasurePolicy() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$1$measurePolicy$1
                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i3) {
                    return MeasurePolicy.DefaultImpls.maxIntrinsicHeight(this, intrinsicMeasureScope, list, i3);
                }

                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i3) {
                    return MeasurePolicy.DefaultImpls.maxIntrinsicWidth(this, intrinsicMeasureScope, list, i3);
                }

                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                @NotNull
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo944measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull final List<? extends Measurable> list, long j) {
                    MeasureResult m140p;
                    Intrinsics.checkNotNullParameter(measureScope, "$this$MeasurePolicy");
                    Intrinsics.checkNotNullParameter(list, "measurables");
                    long m5536performMeasureDjhGOtQ = Measurer.this.m5536performMeasureDjhGOtQ(j, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i, measureScope);
                    mutableState.getValue();
                    int m5376getWidthimpl = IntSize.m5376getWidthimpl(m5536performMeasureDjhGOtQ);
                    int m5375getHeightimpl = IntSize.m5375getHeightimpl(m5536performMeasureDjhGOtQ);
                    final Measurer measurer2 = Measurer.this;
                    m140p = MeasureScope.CC.m140p(measureScope, m5376getWidthimpl, m5375getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$1$measurePolicy$1$measure$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                            Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                            Measurer.this.performLayout(placementScope, list);
                        }
                    }, 4, null);
                    return m140p;
                }

                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i3) {
                    return MeasurePolicy.DefaultImpls.minIntrinsicHeight(this, intrinsicMeasureScope, list, i3);
                }

                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i3) {
                    return MeasurePolicy.DefaultImpls.minIntrinsicWidth(this, intrinsicMeasureScope, list, i3);
                }
            }, new Function0<Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$1$onHelpersChanged$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m5523invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m5523invoke() {
                    mutableState.setValue(Boolean.valueOf(!r0.getValue().booleanValue()));
                    constraintSetForInlineDsl.setKnownDirty(true);
                }
            });
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Pair<MeasurePolicy, Function0<Unit>> pair = (Pair) rememberedValue2;
        composer.endReplaceableGroup();
        return pair;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toDebugString(ConstraintWidget constraintWidget) {
        return ((Object) constraintWidget.getDebugName()) + " width " + constraintWidget.getWidth() + " minWidth " + constraintWidget.getMinWidth() + " maxWidth " + constraintWidget.getMaxWidth() + " height " + constraintWidget.getHeight() + " minHeight " + constraintWidget.getMinHeight() + " maxHeight " + constraintWidget.getMaxHeight() + " HDB " + constraintWidget.getHorizontalDimensionBehaviour() + " VDB " + constraintWidget.getVerticalDimensionBehaviour() + " MCW " + constraintWidget.mMatchConstraintDefaultWidth + " MCH " + constraintWidget.mMatchConstraintDefaultHeight + " percentW " + constraintWidget.mMatchConstraintPercentWidth + " percentH " + constraintWidget.mMatchConstraintPercentHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toDebugString(BasicMeasure.Measure measure) {
        return "measure strategy is ";
    }

    @NotNull
    /* renamed from: atLeast-3ABfNKs, reason: not valid java name */
    public static final Dimension m5518atLeast3ABfNKs(@NotNull Dimension.MinCoercible minCoercible, float f) {
        Intrinsics.checkNotNullParameter(minCoercible, "$this$atLeast");
        DimensionDescription dimensionDescription = (DimensionDescription) minCoercible;
        dimensionDescription.m5531setMinYLDhkOg(C0856Dp.m5214boximpl(f));
        return dimensionDescription;
    }

    @NotNull
    /* renamed from: atMost-3ABfNKs, reason: not valid java name */
    public static final Dimension m5521atMost3ABfNKs(@NotNull Dimension.MaxCoercible maxCoercible, float f) {
        Intrinsics.checkNotNullParameter(maxCoercible, "$this$atMost");
        DimensionDescription dimensionDescription = (DimensionDescription) maxCoercible;
        dimensionDescription.m5530setMaxYLDhkOg(C0856Dp.m5214boximpl(f));
        return dimensionDescription;
    }

    @NotNull
    public static final Dimension getAtLeastWrapContent(@NotNull Dimension.MinCoercible minCoercible) {
        Intrinsics.checkNotNullParameter(minCoercible, "<this>");
        DimensionDescription dimensionDescription = (DimensionDescription) minCoercible;
        dimensionDescription.setMinSymbol(androidx.constraintlayout.core.state.Dimension.WRAP_DIMENSION);
        return dimensionDescription;
    }

    @NotNull
    public static final Dimension getAtMostWrapContent(@NotNull Dimension.MaxCoercible maxCoercible) {
        Intrinsics.checkNotNullParameter(maxCoercible, "<this>");
        DimensionDescription dimensionDescription = (DimensionDescription) maxCoercible;
        dimensionDescription.setMaxSymbol(androidx.constraintlayout.core.state.Dimension.WRAP_DIMENSION);
        return dimensionDescription;
    }

    @NotNull
    public static final ConstraintSet ConstraintSet(@Language("json5") @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "jsonContent");
        return new JSONConstraintSet(str, null, null, 6, null);
    }

    @NotNull
    public static final ConstraintSet ConstraintSet(@NotNull ConstraintSet constraintSet, @Language("json5") @NotNull String str) {
        Intrinsics.checkNotNullParameter(constraintSet, "extendConstraintSet");
        Intrinsics.checkNotNullParameter(str, "jsonContent");
        return new JSONConstraintSet(str, null, constraintSet, 2, null);
    }

    @NotNull
    public static final ConstraintSet ConstraintSet(@NotNull Function1<? super ConstraintSetScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "description");
        ConstraintSet constraintSet = null;
        return new DslConstraintSet(function1, constraintSet, 2, constraintSet);
    }

    @NotNull
    public static final ConstraintSet ConstraintSet(@NotNull ConstraintSet constraintSet, @NotNull Function1<? super ConstraintSetScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(constraintSet, "extendConstraintSet");
        Intrinsics.checkNotNullParameter(function1, "description");
        return new DslConstraintSet(function1, constraintSet);
    }

    @Composable
    @PublishedApi
    @NotNull
    public static final MeasurePolicy rememberConstraintLayoutMeasurePolicy(final int i, @NotNull MutableState<Long> mutableState, @NotNull final ConstraintSet constraintSet, @NotNull final Measurer measurer, @Nullable Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(mutableState, "needsUpdate");
        Intrinsics.checkNotNullParameter(constraintSet, "constraintSet");
        Intrinsics.checkNotNullParameter(measurer, "measurer");
        composer.startReplaceableGroup(-441904452);
        Integer valueOf = Integer.valueOf(i);
        Long value = mutableState.getValue();
        composer.startReplaceableGroup(-3686095);
        boolean changed = composer.changed(value) | composer.changed(valueOf) | composer.changed(constraintSet);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            measurer.parseDesignElements(constraintSet);
            rememberedValue = new MeasurePolicy() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$2$1
                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i3) {
                    return MeasurePolicy.DefaultImpls.maxIntrinsicHeight(this, intrinsicMeasureScope, list, i3);
                }

                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i3) {
                    return MeasurePolicy.DefaultImpls.maxIntrinsicWidth(this, intrinsicMeasureScope, list, i3);
                }

                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                @NotNull
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo944measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull final List<? extends Measurable> list, long j) {
                    MeasureResult m140p;
                    Intrinsics.checkNotNullParameter(measureScope, "$this$MeasurePolicy");
                    Intrinsics.checkNotNullParameter(list, "measurables");
                    long m5536performMeasureDjhGOtQ = Measurer.this.m5536performMeasureDjhGOtQ(j, measureScope.getLayoutDirection(), constraintSet, list, i, measureScope);
                    int m5376getWidthimpl = IntSize.m5376getWidthimpl(m5536performMeasureDjhGOtQ);
                    int m5375getHeightimpl = IntSize.m5375getHeightimpl(m5536performMeasureDjhGOtQ);
                    final Measurer measurer2 = Measurer.this;
                    m140p = MeasureScope.CC.m140p(measureScope, m5376getWidthimpl, m5375getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$rememberConstraintLayoutMeasurePolicy$2$1$measure$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                            Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                            Measurer.this.performLayout(placementScope, list);
                        }
                    }, 4, null);
                    return m140p;
                }

                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i3) {
                    return MeasurePolicy.DefaultImpls.minIntrinsicHeight(this, intrinsicMeasureScope, list, i3);
                }

                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i3) {
                    return MeasurePolicy.DefaultImpls.minIntrinsicWidth(this, intrinsicMeasureScope, list, i3);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
        composer.endReplaceableGroup();
        return measurePolicy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Composable
    public static final void ConstraintLayout(@NotNull final ConstraintSet constraintSet, @Nullable Modifier modifier, int i, boolean z, @Nullable AnimationSpec<Float> animationSpec, @Nullable Function0<Unit> function0, @NotNull final Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, final int i2, int i3) {
        Intrinsics.checkNotNullParameter(constraintSet, "constraintSet");
        Intrinsics.checkNotNullParameter(function2, "content");
        composer.startReplaceableGroup(-270262697);
        Modifier modifier2 = (i3 & 2) != 0 ? Modifier.Companion : modifier;
        int i4 = (i3 & 4) != 0 ? 257 : i;
        boolean z2 = (i3 & 8) != 0 ? false : z;
        AnimationSpec<Float> tween$default = (i3 & 16) != 0 ? AnimationSpecKt.tween$default(0, 0, null, 7, null) : animationSpec;
        Function0<Unit> function02 = (i3 & 32) != 0 ? null : function0;
        if (z2) {
            composer.startReplaceableGroup(-270262314);
            composer.startReplaceableGroup(-3687241);
            Object rememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet, null, 2, null);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            MutableState mutableState = (MutableState) rememberedValue;
            composer.startReplaceableGroup(-3687241);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(constraintSet, null, 2, null);
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            MutableState mutableState2 = (MutableState) rememberedValue2;
            composer.startReplaceableGroup(-3687241);
            Object rememberedValue3 = composer.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceableGroup();
            Animatable animatable = (Animatable) rememberedValue3;
            composer.startReplaceableGroup(-3687241);
            Object rememberedValue4 = composer.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = gs.b(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
                composer.updateRememberedValue(rememberedValue4);
            }
            composer.endReplaceableGroup();
            final Channel channel = (Channel) rememberedValue4;
            composer.startReplaceableGroup(-3687241);
            Object rememberedValue5 = composer.rememberedValue();
            if (rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(1, null, 2, null);
                composer.updateRememberedValue(rememberedValue5);
            }
            composer.endReplaceableGroup();
            EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m5522invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m5522invoke() {
                    channel.trySend-JP2dKIU(constraintSet);
                }
            }, composer, 0);
            EffectsKt.LaunchedEffect(channel, new ConstraintLayoutKt$ConstraintLayout$4(channel, (MutableState) rememberedValue5, animatable, tween$default, function02, mutableState, mutableState2, null), composer, 8);
            ConstraintSet m5510ConstraintLayout$lambda6 = m5510ConstraintLayout$lambda6(mutableState);
            ConstraintSet m5512ConstraintLayout$lambda9 = m5512ConstraintLayout$lambda9(mutableState2);
            float floatValue = ((Number) animatable.getValue()).floatValue();
            int i5 = (i2 << 12) & 458752;
            composer.startReplaceableGroup(-1330873847);
            MotionLayoutDebugFlags motionLayoutDebugFlags = MotionLayoutDebugFlags.NONE;
            EnumSet of = EnumSet.of(motionLayoutDebugFlags);
            Intrinsics.checkNotNullExpressionValue(of, "of(MotionLayoutDebugFlags.NONE)");
            int i6 = (i5 & 7168) | (i5 & 14) | 229376 | (i5 & 112) | (i5 & 896);
            int i7 = i5 << 3;
            int i8 = i6 | (i7 & 3670016) | (i7 & 29360128) | (i7 & 234881024);
            composer.startReplaceableGroup(-1330870962);
            final int i9 = (i8 & 896) | (i8 & 14) | 32768 | (i8 & 112) | (i8 & 7168) | (i8 & 458752) | (i8 & 3670016) | (i8 & 29360128) | (i8 & 234881024);
            composer.startReplaceableGroup(-1401224268);
            composer.startReplaceableGroup(-3687241);
            Object rememberedValue6 = composer.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new MotionMeasurer();
                composer.updateRememberedValue(rememberedValue6);
            }
            composer.endReplaceableGroup();
            MotionMeasurer motionMeasurer = (MotionMeasurer) rememberedValue6;
            composer.startReplaceableGroup(-3687241);
            Object rememberedValue7 = composer.rememberedValue();
            if (rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new MotionLayoutScope(motionMeasurer);
                composer.updateRememberedValue(rememberedValue7);
            }
            composer.endReplaceableGroup();
            final MotionLayoutScope motionLayoutScope = (MotionLayoutScope) rememberedValue7;
            composer.startReplaceableGroup(-3687241);
            Object rememberedValue8 = composer.rememberedValue();
            if (rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
                composer.updateRememberedValue(rememberedValue8);
            }
            composer.endReplaceableGroup();
            MutableState mutableState3 = (MutableState) rememberedValue8;
            mutableState3.setValue(Float.valueOf(floatValue));
            int i10 = i9 << 9;
            MeasurePolicy rememberMotionLayoutMeasurePolicy = MotionLayoutKt.rememberMotionLayoutMeasurePolicy(257, of, 0L, m5510ConstraintLayout$lambda6, m5512ConstraintLayout$lambda9, null, mutableState3, motionMeasurer, composer, 18350528 | ((i9 >> 21) & 14) | (i10 & 7168) | (57344 & i10) | (i10 & 458752));
            motionMeasurer.addLayoutInformationReceiver(null);
            float forcedScaleFactor = motionMeasurer.getForcedScaleFactor();
            if (of.contains(motionLayoutDebugFlags) && Float.isNaN(forcedScaleFactor)) {
                composer.startReplaceableGroup(-1401222327);
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier2, false, new MotionLayoutKt$MotionLayoutCore$4(motionMeasurer), 1, null), ComposableLambdaKt.composableLambda(composer, -819896774, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayout$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i11) {
                        if (((i11 & 11) ^ 2) == 0 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            function2.invoke(composer2, Integer.valueOf((i2 >> 18) & 14));
                        }
                    }
                }), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
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
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion2);
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
                Composer m2410constructorimpl = Updater.m2410constructorimpl(composer);
                Updater.m2417setimpl(m2410constructorimpl, rememberBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m2417setimpl(m2410constructorimpl, density, companion3.getSetDensity());
                Updater.m2417setimpl(m2410constructorimpl, layoutDirection, companion3.getSetLayoutDirection());
                composer.enableReusing();
                materializerOf.invoke(SkippableUpdater.m2398boximpl(SkippableUpdater.m2399constructorimpl(composer)), composer, 0);
                composer.startReplaceableGroup(2058660585);
                composer.startReplaceableGroup(-1253629305);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier2, false, new MotionLayoutKt$MotionLayoutCore$3$1(motionMeasurer), 1, null), ComposableLambdaKt.composableLambda(composer, -819900388, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$$inlined$MotionLayout$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i11) {
                        if (((i11 & 11) ^ 2) == 0 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            function2.invoke(composer2, Integer.valueOf((i2 >> 18) & 14));
                        }
                    }
                }), rememberMotionLayoutMeasurePolicy, composer, 48, 0);
                if (!Float.isNaN(forcedScaleFactor)) {
                    composer.startReplaceableGroup(-922833881);
                    motionMeasurer.drawDebugBounds(boxScopeInstance, forcedScaleFactor, composer, 518);
                    composer.endReplaceableGroup();
                } else {
                    composer.startReplaceableGroup(-922833807);
                    composer.endReplaceableGroup();
                }
                if (!of.contains(motionLayoutDebugFlags)) {
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
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-270260906);
            composer.startReplaceableGroup(-3687241);
            Object rememberedValue9 = composer.rememberedValue();
            Composer.Companion companion4 = Composer.Companion;
            if (rememberedValue9 == companion4.getEmpty()) {
                rememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0L, null, 2, null);
                composer.updateRememberedValue(rememberedValue9);
            }
            composer.endReplaceableGroup();
            MutableState<Long> mutableState4 = (MutableState) rememberedValue9;
            composer.startReplaceableGroup(-3687241);
            Object rememberedValue10 = composer.rememberedValue();
            if (rememberedValue10 == companion4.getEmpty()) {
                rememberedValue10 = new Measurer();
                composer.updateRememberedValue(rememberedValue10);
            }
            composer.endReplaceableGroup();
            final Measurer measurer = (Measurer) rememberedValue10;
            Modifier modifier3 = modifier2;
            MeasurePolicy rememberConstraintLayoutMeasurePolicy = rememberConstraintLayoutMeasurePolicy(i4, mutableState4, constraintSet, measurer, composer, ((i2 >> 6) & 14) | 4144 | ((i2 << 6) & 896));
            if (constraintSet instanceof EditableJSONLayout) {
                ((EditableJSONLayout) constraintSet).setUpdateFlag(mutableState4);
            }
            measurer.addLayoutInformationReceiver(constraintSet instanceof LayoutInformationReceiver ? (LayoutInformationReceiver) constraintSet : null);
            float forcedScaleFactor2 = measurer.getForcedScaleFactor();
            if (!Float.isNaN(forcedScaleFactor2)) {
                composer.startReplaceableGroup(-270260292);
                Modifier scale = ScaleKt.scale(modifier3, measurer.getForcedScaleFactor());
                composer.startReplaceableGroup(-1990474327);
                Modifier.Companion companion5 = Modifier.Companion;
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer, 0);
                composer.startReplaceableGroup(1376089335);
                Density density2 = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposeUiNode.Companion companion6 = ComposeUiNode.Companion;
                Function0<ComposeUiNode> constructor2 = companion6.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(companion5);
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                composer.disableReusing();
                Composer m2410constructorimpl2 = Updater.m2410constructorimpl(composer);
                Updater.m2417setimpl(m2410constructorimpl2, rememberBoxMeasurePolicy2, companion6.getSetMeasurePolicy());
                Updater.m2417setimpl(m2410constructorimpl2, density2, companion6.getSetDensity());
                Updater.m2417setimpl(m2410constructorimpl2, layoutDirection2, companion6.getSetLayoutDirection());
                composer.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m2398boximpl(SkippableUpdater.m2399constructorimpl(composer)), composer, 0);
                composer.startReplaceableGroup(2058660585);
                composer.startReplaceableGroup(-1253629305);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(scale, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$6$1
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
                        ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, Measurer.this);
                    }
                }, 1, null), ComposableLambdaKt.composableLambda(composer, -819900598, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$6$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i11) {
                        if (((i11 & 11) ^ 2) == 0 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            Measurer.this.createDesignElements(composer2, 8);
                            function2.invoke(composer2, Integer.valueOf((i2 >> 18) & 14));
                        }
                    }
                }), rememberConstraintLayoutMeasurePolicy, composer, 48, 0);
                measurer.drawDebugBounds(boxScopeInstance2, forcedScaleFactor2, composer, 518);
                Unit unit2 = Unit.INSTANCE;
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endNode();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-270259702);
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$7
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
                        ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, Measurer.this);
                    }
                }, 1, null), ComposableLambdaKt.composableLambda(composer, -819901122, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    @Composable
                    public final void invoke(@Nullable Composer composer2, int i11) {
                        if (((i11 & 11) ^ 2) == 0 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                        } else {
                            Measurer.this.createDesignElements(composer2, 8);
                            function2.invoke(composer2, Integer.valueOf((i2 >> 18) & 14));
                        }
                    }
                }), rememberConstraintLayoutMeasurePolicy, composer, 48, 0);
                composer.endReplaceableGroup();
            }
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
    }
}
