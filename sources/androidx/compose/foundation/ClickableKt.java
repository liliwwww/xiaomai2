package androidx.compose.foundation;

import android.taobao.windvane.urlintercept.WVURLRuleConstants;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.input.ScrollContainerInfo;
import androidx.compose.p004ui.input.ScrollContainerInfoKt;
import androidx.compose.p004ui.input.key.Key;
import androidx.compose.p004ui.input.key.KeyEvent;
import androidx.compose.p004ui.input.key.KeyEvent_androidKt;
import androidx.compose.p004ui.input.key.KeyInputModifierKt;
import androidx.compose.p004ui.input.pointer.PointerInputScope;
import androidx.compose.p004ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p004ui.platform.InspectableValueKt;
import androidx.compose.p004ui.platform.InspectorInfo;
import androidx.compose.p004ui.semantics.Role;
import androidx.compose.p004ui.semantics.SemanticsModifierKt;
import androidx.compose.p004ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i80;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ClickableKt {
    @Composable
    public static final void PressedInteractionSourceDisposableEffect(@NotNull final MutableInteractionSource mutableInteractionSource, @NotNull final MutableState<PressInteraction.Press> mutableState, @NotNull final Map<Key, PressInteraction.Press> map, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(mutableState, "pressedInteraction");
        Intrinsics.checkNotNullParameter(map, "currentKeyPressInteractions");
        Composer startRestartGroup = composer.startRestartGroup(1297229208);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1297229208, i, -1, "androidx.compose.foundation.PressedInteractionSourceDisposableEffect (Clickable.kt:383)");
        }
        EffectsKt.DisposableEffect(mutableInteractionSource, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.ClickableKt$PressedInteractionSourceDisposableEffect$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                final MutableState<PressInteraction.Press> mutableState2 = mutableState;
                final Map<Key, PressInteraction.Press> map2 = map;
                final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.ClickableKt$PressedInteractionSourceDisposableEffect$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        PressInteraction.Press press = (PressInteraction.Press) MutableState.this.getValue();
                        if (press != null) {
                            mutableInteractionSource2.tryEmit(new PressInteraction.Cancel(press));
                            MutableState.this.setValue(null);
                        }
                        Iterator it = map2.values().iterator();
                        while (it.hasNext()) {
                            mutableInteractionSource2.tryEmit(new PressInteraction.Cancel((PressInteraction.Press) it.next()));
                        }
                        map2.clear();
                    }
                };
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
    public static final Modifier m1137clickableO2vRcR0(@NotNull Modifier modifier, @NotNull final MutableInteractionSource mutableInteractionSource, @Nullable final Indication indication, final boolean z, @Nullable final String str, @Nullable final Role role, @NotNull final Function0<Unit> function0) {
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
                        public final Boolean m1149invoke() {
                            return Boolean.TRUE;
                        }
                    }, null, 2, null);
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceableGroup();
                final MutableState mutableState2 = (MutableState) rememberedValue3;
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue4 = composer.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2545boximpl(Offset.Companion.m2572getZeroF1C5BW0()), null, 2, null);
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
                    rememberedValue5 = new ClickableKt$clickable$4$gesture$1$1(mutableState3, z2, mutableInteractionSource3, mutableState, mutableState2, rememberUpdatedState, null);
                    composer.updateRememberedValue(rememberedValue5);
                }
                composer.endReplaceableGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, mutableInteractionSource2, valueOf, (Function2) rememberedValue5);
                Modifier.Companion companion3 = Modifier.Companion;
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(mutableState2);
                Object rememberedValue6 = composer.rememberedValue();
                if (changed || rememberedValue6 == Composer.Companion.getEmpty()) {
                    rememberedValue6 = new Function1<ScrollContainerInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable$4$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ScrollContainerInfo) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable final ScrollContainerInfo scrollContainerInfo) {
                            mutableState2.setValue(new Function0<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$clickable$4$1$1.1
                                {
                                    super(0);
                                }

                                @NotNull
                                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m1148invoke() {
                                    ScrollContainerInfo scrollContainerInfo2 = ScrollContainerInfo.this;
                                    return Boolean.valueOf(scrollContainerInfo2 != null && ScrollContainerInfoKt.canScroll(scrollContainerInfo2));
                                }
                            });
                        }
                    };
                    composer.updateRememberedValue(rememberedValue6);
                }
                composer.endReplaceableGroup();
                Modifier consumeScrollContainerInfo = ScrollContainerInfoKt.consumeScrollContainerInfo(companion3, (Function1) rememberedValue6);
                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource;
                Indication indication2 = indication;
                composer.startReplaceableGroup(773894976);
                Object rememberedValue7 = composer.rememberedValue();
                if (rememberedValue7 == Composer.Companion.getEmpty()) {
                    Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                    composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    rememberedValue7 = compositionScopedCoroutineScopeCanceller;
                }
                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue7).getCoroutineScope();
                composer.endReplaceableGroup();
                Modifier m1145genericClickableWithoutGesturebdNGguI = ClickableKt.m1145genericClickableWithoutGesturebdNGguI(consumeScrollContainerInfo, pointerInput, mutableInteractionSource4, indication2, coroutineScope, map, mutableState3, z, str, role, null, null, function0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m1145genericClickableWithoutGesturebdNGguI;
            }
        });
    }

    @NotNull
    /* renamed from: clickable-XHw0xAI, reason: not valid java name */
    public static final Modifier m1139clickableXHw0xAI(@NotNull Modifier modifier, final boolean z, @Nullable final String str, @Nullable final Role role, @NotNull final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "$this$clickable");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-XHw0xAI$$inlined$debugInspectorInfo$1
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
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable$2
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
                Modifier m1137clickableO2vRcR0 = ClickableKt.m1137clickableO2vRcR0(companion, (MutableInteractionSource) rememberedValue, indication, z, str, role, function0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m1137clickableO2vRcR0;
            }
        });
    }

    /* renamed from: clickable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1140clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m1139clickableXHw0xAI(modifier, z, str, role, function0);
    }

    @ExperimentalFoundationApi
    @NotNull
    /* renamed from: combinedClickable-XVZzFYc, reason: not valid java name */
    public static final Modifier m1141combinedClickableXVZzFYc(@NotNull Modifier modifier, @NotNull final MutableInteractionSource mutableInteractionSource, @Nullable final Indication indication, final boolean z, @Nullable final String str, @Nullable final Role role, @Nullable final String str2, @Nullable final Function0<Unit> function0, @Nullable final Function0<Unit> function02, @NotNull final Function0<Unit> function03) {
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
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4
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
                Map map;
                Object[] objArr;
                MutableState mutableState;
                Intrinsics.checkNotNullParameter(modifier2, "$this$composed");
                composer.startReplaceableGroup(1841718000);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1841718000, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:293)");
                }
                State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function03, composer, 0);
                State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function0, composer, 0);
                State rememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(function02, composer, 0);
                boolean z2 = function0 != null;
                boolean z3 = function02 != null;
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.Companion;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                final MutableState mutableState2 = (MutableState) rememberedValue;
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue2 = composer.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new LinkedHashMap();
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceableGroup();
                Map map2 = (Map) rememberedValue2;
                composer.startReplaceableGroup(1321107066);
                if (z) {
                    Boolean valueOf = Boolean.valueOf(z2);
                    final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                    composer.startReplaceableGroup(511388516);
                    boolean changed = composer.changed(mutableState2) | composer.changed(mutableInteractionSource2);
                    Object rememberedValue3 = composer.rememberedValue();
                    if (changed || rememberedValue3 == companion.getEmpty()) {
                        rememberedValue3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @NotNull
                            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                                Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                                final MutableState<PressInteraction.Press> mutableState3 = mutableState2;
                                final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4$1$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        PressInteraction.Press press = (PressInteraction.Press) MutableState.this.getValue();
                                        if (press != null) {
                                            mutableInteractionSource3.tryEmit(new PressInteraction.Cancel(press));
                                            MutableState.this.setValue(null);
                                        }
                                    }
                                };
                            }
                        };
                        composer.updateRememberedValue(rememberedValue3);
                    }
                    composer.endReplaceableGroup();
                    EffectsKt.DisposableEffect(valueOf, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, composer, 0);
                    ClickableKt.PressedInteractionSourceDisposableEffect(mutableInteractionSource, mutableState2, map2, composer, 560);
                }
                composer.endReplaceableGroup();
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue4 = composer.rememberedValue();
                if (rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Function0<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4$delayPressInteraction$1$1
                        @NotNull
                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Boolean m1153invoke() {
                            return Boolean.TRUE;
                        }
                    }, null, 2, null);
                    composer.updateRememberedValue(rememberedValue4);
                }
                composer.endReplaceableGroup();
                MutableState mutableState3 = (MutableState) rememberedValue4;
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue5 = composer.rememberedValue();
                if (rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2545boximpl(Offset.Companion.m2572getZeroF1C5BW0()), null, 2, null);
                    composer.updateRememberedValue(rememberedValue5);
                }
                composer.endReplaceableGroup();
                MutableState mutableState4 = (MutableState) rememberedValue5;
                Modifier.Companion companion2 = Modifier.Companion;
                Object[] objArr2 = {mutableInteractionSource, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z)};
                MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                Object[] objArr3 = {mutableState4, Boolean.valueOf(z3), Boolean.valueOf(z), rememberUpdatedState3, Boolean.valueOf(z2), rememberUpdatedState2, mutableInteractionSource3, mutableState2, mutableState3, rememberUpdatedState};
                boolean z4 = z;
                composer.startReplaceableGroup(-568225417);
                int i2 = 0;
                boolean z5 = false;
                for (int i3 = 10; i2 < i3; i3 = 10) {
                    z5 |= composer.changed(objArr3[i2]);
                    i2++;
                }
                Object rememberedValue6 = composer.rememberedValue();
                if (z5 || rememberedValue6 == Composer.Companion.getEmpty()) {
                    map = map2;
                    objArr = objArr2;
                    mutableState = mutableState3;
                    Object clickableKt$combinedClickable$4$gesture$1$1 = new ClickableKt$combinedClickable$4$gesture$1$1(mutableState4, z3, z4, z2, rememberUpdatedState3, rememberUpdatedState2, mutableInteractionSource3, mutableState2, mutableState3, rememberUpdatedState, null);
                    composer.updateRememberedValue(clickableKt$combinedClickable$4$gesture$1$1);
                    rememberedValue6 = clickableKt$combinedClickable$4$gesture$1$1;
                } else {
                    map = map2;
                    objArr = objArr2;
                    mutableState = mutableState3;
                }
                composer.endReplaceableGroup();
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion2, objArr, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue6);
                Modifier.Companion companion3 = Modifier.Companion;
                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource;
                Indication indication2 = indication;
                composer.startReplaceableGroup(773894976);
                Object rememberedValue7 = composer.rememberedValue();
                Composer.Companion companion4 = Composer.Companion;
                if (rememberedValue7 == companion4.getEmpty()) {
                    Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                    composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    rememberedValue7 = compositionScopedCoroutineScopeCanceller;
                }
                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue7).getCoroutineScope();
                composer.endReplaceableGroup();
                Modifier m1145genericClickableWithoutGesturebdNGguI = ClickableKt.m1145genericClickableWithoutGesturebdNGguI(companion3, pointerInput, mutableInteractionSource4, indication2, coroutineScope, map, mutableState4, z, str, role, str2, function0, function03);
                composer.startReplaceableGroup(1157296644);
                final MutableState mutableState5 = mutableState;
                boolean changed2 = composer.changed(mutableState5);
                Object rememberedValue8 = composer.rememberedValue();
                if (changed2 || rememberedValue8 == companion4.getEmpty()) {
                    rememberedValue8 = new Function1<ScrollContainerInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((ScrollContainerInfo) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable final ScrollContainerInfo scrollContainerInfo) {
                            mutableState5.setValue(new Function0<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4$2$1.1
                                {
                                    super(0);
                                }

                                @NotNull
                                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m1152invoke() {
                                    ScrollContainerInfo scrollContainerInfo2 = ScrollContainerInfo.this;
                                    return Boolean.valueOf(scrollContainerInfo2 != null && ScrollContainerInfoKt.canScroll(scrollContainerInfo2));
                                }
                            });
                        }
                    };
                    composer.updateRememberedValue(rememberedValue8);
                }
                composer.endReplaceableGroup();
                Modifier consumeScrollContainerInfo = ScrollContainerInfoKt.consumeScrollContainerInfo(m1145genericClickableWithoutGesturebdNGguI, (Function1) rememberedValue8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return consumeScrollContainerInfo;
            }
        });
    }

    @ExperimentalFoundationApi
    @NotNull
    /* renamed from: combinedClickable-cJG_KMw, reason: not valid java name */
    public static final Modifier m1143combinedClickablecJG_KMw(@NotNull Modifier modifier, final boolean z, @Nullable final String str, @Nullable final Role role, @Nullable final String str2, @Nullable final Function0<Unit> function0, @Nullable final Function0<Unit> function02, @NotNull final Function0<Unit> function03) {
        Intrinsics.checkNotNullParameter(modifier, "$this$combinedClickable");
        Intrinsics.checkNotNullParameter(function03, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1
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
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$2
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
                composer.startReplaceableGroup(1969174843);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1969174843, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:239)");
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
                Modifier m1141combinedClickableXVZzFYc = ClickableKt.m1141combinedClickableXVZzFYc(companion, (MutableInteractionSource) rememberedValue, indication, z, str, role, str2, function0, function02, function03);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m1141combinedClickableXVZzFYc;
            }
        });
    }

    @NotNull
    /* renamed from: genericClickableWithoutGesture-bdNGguI, reason: not valid java name */
    public static final Modifier m1145genericClickableWithoutGesturebdNGguI(@NotNull Modifier modifier, @NotNull Modifier modifier2, @NotNull MutableInteractionSource mutableInteractionSource, @Nullable Indication indication, @NotNull CoroutineScope coroutineScope, @NotNull Map<Key, PressInteraction.Press> map, @NotNull State<Offset> state, boolean z, @Nullable String str, @Nullable Role role, @Nullable String str2, @Nullable Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(modifier, "$this$genericClickableWithoutGesture");
        Intrinsics.checkNotNullParameter(modifier2, "gestureModifiers");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(coroutineScope, "indicationScope");
        Intrinsics.checkNotNullParameter(map, "currentKeyPressInteractions");
        Intrinsics.checkNotNullParameter(state, "keyClickOffset");
        Intrinsics.checkNotNullParameter(function02, "onClick");
        return FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(m56x602ad71b(genericClickableWithoutGesture_bdNGguI$clickSemantics(modifier, role, str, function0, str2, z, function02), z, map, state, coroutineScope, function02, mutableInteractionSource), mutableInteractionSource, indication), mutableInteractionSource, z), z, mutableInteractionSource).then(modifier2);
    }

    private static final Modifier genericClickableWithoutGesture_bdNGguI$clickSemantics(Modifier modifier, final Role role, final String str, final Function0<Unit> function0, final String str2, final boolean z, final Function0<Unit> function02) {
        return SemanticsModifierKt.semantics(modifier, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$clickSemantics$1
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
                Role role2 = Role.this;
                if (role2 != null) {
                    SemanticsPropertiesKt.m4605setRolekuIjeqM(semanticsPropertyReceiver, role2.m4590unboximpl());
                }
                String str3 = str;
                final Function0<Unit> function03 = function02;
                SemanticsPropertiesKt.onClick(semanticsPropertyReceiver, str3, new Function0<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$clickSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @NotNull
                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Boolean m1158invoke() {
                        function03.invoke();
                        return Boolean.TRUE;
                    }
                });
                final Function0<Unit> function04 = function0;
                if (function04 != null) {
                    SemanticsPropertiesKt.onLongClick(semanticsPropertyReceiver, str2, new Function0<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$clickSemantics$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @NotNull
                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Boolean m1159invoke() {
                            function04.invoke();
                            return Boolean.TRUE;
                        }
                    });
                }
                if (z) {
                    return;
                }
                SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
            }
        });
    }

    /* renamed from: genericClickableWithoutGesture_bdNGguI$detectPressAndClickFromKey */
    private static final Modifier m56x602ad71b(Modifier modifier, final boolean z, final Map<Key, PressInteraction.Press> map, final State<Offset> state, final CoroutineScope coroutineScope, final Function0<Unit> function0, final MutableInteractionSource mutableInteractionSource) {
        return KeyInputModifierKt.onKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1

            /* compiled from: Taobao */
            @DebugMetadata(c = "androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1", f = "Clickable.kt", i = {}, l = {WVURLRuleConstants.ORDER_LIST}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1, reason: invalid class name */
            /* loaded from: classes2.dex */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableInteractionSource $interactionSource;
                final /* synthetic */ PressInteraction.Press $press;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(MutableInteractionSource mutableInteractionSource, PressInteraction.Press press, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$interactionSource = mutableInteractionSource;
                    this.$press = press;
                }

                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.$interactionSource, this.$press, continuation);
                }

                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                        PressInteraction.Press press = this.$press;
                        this.label = 1;
                        if (mutableInteractionSource.emit(press, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m1160invokeZmokQxo(((KeyEvent) obj).m3953unboximpl());
            }

            @NotNull
            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m1160invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
                Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
                boolean z2 = true;
                if (z && Clickable_androidKt.m1163isPressZmokQxo(keyEvent)) {
                    if (!map.containsKey(Key.m3366boximpl(KeyEvent_androidKt.m3964getKeyZmokQxo(keyEvent)))) {
                        PressInteraction.Press press = new PressInteraction.Press(state.getValue().m2566unboximpl(), null);
                        map.put(Key.m3366boximpl(KeyEvent_androidKt.m3964getKeyZmokQxo(keyEvent)), press);
                        d.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(mutableInteractionSource, press, null), 3, (Object) null);
                    }
                    z2 = false;
                } else {
                    if (z && Clickable_androidKt.m1161isClickZmokQxo(keyEvent)) {
                        PressInteraction.Press remove = map.remove(Key.m3366boximpl(KeyEvent_androidKt.m3964getKeyZmokQxo(keyEvent)));
                        if (remove != null) {
                            d.d(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C0404x8f00ca0b(mutableInteractionSource, remove, null), 3, (Object) null);
                        }
                        function0.invoke();
                    }
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
        });
    }

    @Nullable
    /* renamed from: handlePressInteraction-EPk0efs, reason: not valid java name */
    public static final Object m1147handlePressInteractionEPk0efs(@NotNull PressGestureScope pressGestureScope, long j, @NotNull MutableInteractionSource mutableInteractionSource, @NotNull MutableState<PressInteraction.Press> mutableState, @NotNull State<? extends Function0<Boolean>> state, @NotNull Continuation<? super Unit> continuation) {
        Object g = i80.g(new ClickableKt$handlePressInteraction$2(pressGestureScope, j, mutableInteractionSource, mutableState, state, null), continuation);
        return g == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? g : Unit.INSTANCE;
    }
}
