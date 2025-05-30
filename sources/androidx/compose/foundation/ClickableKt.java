package androidx.compose.foundation;

import androidx.compose.foundation.ClickableKt$PressedInteractionSourceDisposableEffect$1$invoke$;
import androidx.compose.foundation.ClickableKt$clickable-XHw0xAI$;
import androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.ScrollContainerInfoKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i80;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ClickableKt {
    @Composable
    public static final void PressedInteractionSourceDisposableEffect(@NotNull final MutableInteractionSource mutableInteractionSource, @NotNull final MutableState<PressInteraction$Press> mutableState, @NotNull final Map<Key, PressInteraction$Press> map, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(mutableState, "pressedInteraction");
        Intrinsics.checkNotNullParameter(map, "currentKeyPressInteractions");
        Composer startRestartGroup = composer.startRestartGroup(1297229208);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1297229208, i, -1, "androidx.compose.foundation.PressedInteractionSourceDisposableEffect (Clickable.kt:383)");
        }
        EffectsKt.DisposableEffect((Object) mutableInteractionSource, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.ClickableKt$PressedInteractionSourceDisposableEffect$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                return new ClickableKt$PressedInteractionSourceDisposableEffect$1$invoke$.inlined.onDispose.1(mutableState, map, mutableInteractionSource);
            }
        }, startRestartGroup, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.ClickableKt$PressedInteractionSourceDisposableEffect$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i2) {
                ClickableKt.PressedInteractionSourceDisposableEffect(MutableInteractionSource.this, mutableState, map, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    @NotNull
    /* renamed from: clickable-O2vRcR0, reason: not valid java name */
    public static final Modifier m127clickableO2vRcR0(@NotNull Modifier modifier, @NotNull final MutableInteractionSource mutableInteractionSource, @Nullable final Indication indication, final boolean z, @Nullable final String str, @Nullable final Role role, @NotNull final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "$this$clickable");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("clickable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", function0);
                inspectorInfo.getProperties().set("indication", indication);
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(92076020);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(92076020, i, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:134)");
                }
                State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function0, composer, 0);
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                MutableState mutableState = (MutableState) rememberedValue;
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue2 = composer.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new LinkedHashMap();
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceableGroup();
                Map map = (Map) rememberedValue2;
                composer.startReplaceableGroup(1841981470);
                if (z) {
                    ClickableKt.PressedInteractionSourceDisposableEffect(mutableInteractionSource, mutableState, map, composer, 560);
                }
                composer.endReplaceableGroup();
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue3 = composer.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Function0<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$clickable$4$delayPressInteraction$1$1
                        @NotNull
                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Boolean m139invoke() {
                            return Boolean.TRUE;
                        }
                    }, null, 2, null);
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceableGroup();
                MutableState mutableState2 = (MutableState) rememberedValue3;
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue4 = composer.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.m1024getZeroF1C5BW0()), null, 2, null);
                    composer.updateRememberedValue(rememberedValue4);
                }
                composer.endReplaceableGroup();
                MutableState mutableState3 = (MutableState) rememberedValue4;
                Modifier.Companion companion2 = Modifier.Companion;
                MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                Boolean valueOf = Boolean.valueOf(z);
                MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                Object[] objArr = {mutableState3, Boolean.valueOf(z), mutableInteractionSource3, mutableState, mutableState2, rememberUpdatedState};
                boolean z2 = z;
                composer.startReplaceableGroup(-568225417);
                boolean z3 = false;
                for (int i2 = 0; i2 < 6; i2++) {
                    z3 |= composer.changed(objArr[i2]);
                }
                Object rememberedValue5 = composer.rememberedValue();
                if (z3 || rememberedValue5 == Composer.Companion.getEmpty()) {
                    rememberedValue5 = new gesture.1.1(mutableState3, z2, mutableInteractionSource3, mutableState, mutableState2, rememberUpdatedState, (Continuation) null);
                    composer.updateRememberedValue(rememberedValue5);
                }
                composer.endReplaceableGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, mutableInteractionSource2, valueOf, (Function2) rememberedValue5);
                Modifier.Companion companion3 = Modifier.Companion;
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(mutableState2);
                Object rememberedValue6 = composer.rememberedValue();
                if (changed || rememberedValue6 == Composer.Companion.getEmpty()) {
                    rememberedValue6 = new 1.1(mutableState2);
                    composer.updateRememberedValue(rememberedValue6);
                }
                composer.endReplaceableGroup();
                Modifier consumeScrollContainerInfo = ScrollContainerInfoKt.consumeScrollContainerInfo(companion3, (Function1) rememberedValue6);
                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource;
                Indication indication2 = indication;
                composer.startReplaceableGroup(773894976);
                Object rememberedValue7 = composer.rememberedValue();
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                    composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    rememberedValue7 = compositionScopedCoroutineScopeCanceller;
                }
                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue7).getCoroutineScope();
                composer.endReplaceableGroup();
                Modifier m135genericClickableWithoutGesturebdNGguI = ClickableKt.m135genericClickableWithoutGesturebdNGguI(consumeScrollContainerInfo, pointerInput, mutableInteractionSource4, indication2, coroutineScope, map, mutableState3, z, str, role, null, null, function0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m135genericClickableWithoutGesturebdNGguI;
            }
        });
    }

    @NotNull
    /* renamed from: clickable-XHw0xAI, reason: not valid java name */
    public static final Modifier m129clickableXHw0xAI(@NotNull Modifier modifier, final boolean z, @Nullable final String str, @Nullable final Role role, @NotNull final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "$this$clickable");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickable-XHw0xAI$.inlined.debugInspectorInfo.1(z, str, role, function0) : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            @Composable
            @NotNull
            public final Modifier invoke(@NotNull Modifier modifier2, @Nullable Composer composer, int i) {
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(-756081143);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-756081143, i, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:91)");
                }
                Modifier.Companion companion = Modifier.Companion;
                Indication indication = (Indication) composer.consume(IndicationKt.getLocalIndication());
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue = composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                Modifier m127clickableO2vRcR0 = ClickableKt.m127clickableO2vRcR0(companion, (MutableInteractionSource) rememberedValue, indication, z, str, role, function0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m127clickableO2vRcR0;
            }
        });
    }

    /* renamed from: clickable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m130clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m129clickableXHw0xAI(modifier, z, str, role, function0);
    }

    @ExperimentalFoundationApi
    @NotNull
    /* renamed from: combinedClickable-XVZzFYc, reason: not valid java name */
    public static final Modifier m131combinedClickableXVZzFYc(@NotNull Modifier modifier, @NotNull final MutableInteractionSource mutableInteractionSource, @Nullable final Indication indication, final boolean z, @Nullable final String str, @Nullable final Role role, @Nullable final String str2, @Nullable final Function0<Unit> function0, @Nullable final Function0<Unit> function02, @NotNull final Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(modifier, "$this$combinedClickable");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(function03, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("combinedClickable");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("onClickLabel", str);
                inspectorInfo.getProperties().set("role", role);
                inspectorInfo.getProperties().set("onClick", function03);
                inspectorInfo.getProperties().set("onDoubleClick", function02);
                inspectorInfo.getProperties().set("onLongClick", function0);
                inspectorInfo.getProperties().set("onLongClickLabel", str2);
                inspectorInfo.getProperties().set("indication", indication);
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new combinedClickable.4(function03, function0, function02, z, mutableInteractionSource, indication, str, role, str2));
    }

    @ExperimentalFoundationApi
    @NotNull
    /* renamed from: combinedClickable-cJG_KMw, reason: not valid java name */
    public static final Modifier m133combinedClickablecJG_KMw(@NotNull Modifier modifier, boolean z, @Nullable String str, @Nullable Role role, @Nullable String str2, @Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02, @NotNull Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(modifier, "$this$combinedClickable");
        Intrinsics.checkNotNullParameter(function03, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$combinedClickable-cJG_KMw$.inlined.debugInspectorInfo.1(z, str, role, function03, function02, function0, str2) : InspectableValueKt.getNoInspectorInfo(), new combinedClickable.2(z, str, role, str2, function0, function02, function03));
    }

    @NotNull
    /* renamed from: genericClickableWithoutGesture-bdNGguI, reason: not valid java name */
    public static final Modifier m135genericClickableWithoutGesturebdNGguI(@NotNull Modifier modifier, @NotNull Modifier modifier2, @NotNull MutableInteractionSource mutableInteractionSource, @Nullable Indication indication, @NotNull CoroutineScope coroutineScope, @NotNull Map<Key, PressInteraction$Press> map, @NotNull State<Offset> state, boolean z, @Nullable String str, @Nullable Role role, @Nullable String str2, @Nullable Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(modifier, "$this$genericClickableWithoutGesture");
        Intrinsics.checkNotNullParameter(modifier2, "gestureModifiers");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(coroutineScope, "indicationScope");
        Intrinsics.checkNotNullParameter(map, "currentKeyPressInteractions");
        Intrinsics.checkNotNullParameter(state, "keyClickOffset");
        Intrinsics.checkNotNullParameter(function02, "onClick");
        return FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(genericClickableWithoutGesture_bdNGguI$detectPressAndClickFromKey(genericClickableWithoutGesture_bdNGguI$clickSemantics(modifier, role, str, function0, str2, z, function02), z, map, state, coroutineScope, function02, mutableInteractionSource), mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource).then(modifier2);
    }

    private static final Modifier genericClickableWithoutGesture_bdNGguI$clickSemantics(Modifier modifier, Role role, String str, Function0<Unit> function0, String str2, boolean z, Function0<Unit> function02) {
        return SemanticsModifierKt.semantics(modifier, true, new genericClickableWithoutGesture.clickSemantics.1(role, str, function0, str2, z, function02));
    }

    private static final Modifier genericClickableWithoutGesture_bdNGguI$detectPressAndClickFromKey(Modifier modifier, boolean z, Map<Key, PressInteraction$Press> map, State<Offset> state, CoroutineScope coroutineScope, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource) {
        return KeyInputModifierKt.onKeyEvent(modifier, new genericClickableWithoutGesture.detectPressAndClickFromKey.1(z, map, state, coroutineScope, function0, mutableInteractionSource));
    }

    @Nullable
    /* renamed from: handlePressInteraction-EPk0efs, reason: not valid java name */
    public static final Object m137handlePressInteractionEPk0efs(@NotNull PressGestureScope pressGestureScope, long j, @NotNull MutableInteractionSource mutableInteractionSource, @NotNull MutableState<PressInteraction$Press> mutableState, @NotNull State<? extends Function0<Boolean>> state, @NotNull Continuation<? super Unit> continuation) {
        Object g = i80.g(new ClickableKt$handlePressInteraction$2(pressGestureScope, j, mutableInteractionSource, mutableState, state, null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }
}
