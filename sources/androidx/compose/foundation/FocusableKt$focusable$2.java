package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class FocusableKt$focusable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FocusableKt$focusable$2(MutableInteractionSource mutableInteractionSource, boolean z) {
        super(3);
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$2(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PinnableContainer.PinnedHandle invoke$lambda$9(MutableState<PinnableContainer.PinnedHandle> mutableState) {
        return (PinnableContainer.PinnedHandle) mutableState.getValue();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(1871352361);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1871352361, i, -1, "androidx.compose.foundation.focusable.<anonymous> (Focusable.kt:67)");
        }
        composer.startReplaceableGroup(773894976);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState = (MutableState) rememberedValue2;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        final MutableState mutableState2 = (MutableState) rememberedValue3;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = new FocusRequester();
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        FocusRequester focusRequester = (FocusRequester) rememberedValue4;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = BringIntoViewRequesterKt.BringIntoViewRequester();
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceableGroup();
        BringIntoViewRequester bringIntoViewRequester = (BringIntoViewRequester) rememberedValue5;
        final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(mutableState) | composer.changed(mutableInteractionSource);
        Object rememberedValue6 = composer.rememberedValue();
        if (changed || rememberedValue6 == companion.getEmpty()) {
            rememberedValue6 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @NotNull
                public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                    Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                    final MutableState<FocusInteraction.Focus> mutableState3 = mutableState;
                    final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            FocusInteraction.Focus focus = (FocusInteraction.Focus) MutableState.this.getValue();
                            if (focus != null) {
                                FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(focus);
                                MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                                if (mutableInteractionSource3 != null) {
                                    mutableInteractionSource3.tryEmit(unfocus);
                                }
                                MutableState.this.setValue(null);
                            }
                        }
                    };
                }
            };
            composer.updateRememberedValue(rememberedValue6);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(mutableInteractionSource, (Function1) rememberedValue6, composer, 0);
        EffectsKt.DisposableEffect(Boolean.valueOf(this.$enabled), new 2(this.$enabled, coroutineScope, mutableState, this.$interactionSource), composer, 0);
        if (this.$enabled) {
            composer.startReplaceableGroup(1407540673);
            if (invoke$lambda$2(mutableState2)) {
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue7 = composer.rememberedValue();
                if (rememberedValue7 == companion.getEmpty()) {
                    rememberedValue7 = new FocusedBoundsModifier();
                    composer.updateRememberedValue(rememberedValue7);
                }
                composer.endReplaceableGroup();
                modifier3 = (Modifier) rememberedValue7;
            } else {
                modifier3 = Modifier.Companion;
            }
            composer.endReplaceableGroup();
            final PinnableContainer pinnableContainer = (PinnableContainer) composer.consume(PinnableContainerKt.getLocalPinnableContainer());
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue8 = composer.rememberedValue();
            if (rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                composer.updateRememberedValue(rememberedValue8);
            }
            composer.endReplaceableGroup();
            final MutableState mutableState3 = (MutableState) rememberedValue8;
            composer.startReplaceableGroup(1618982084);
            boolean changed2 = composer.changed(mutableState2) | composer.changed(mutableState3) | composer.changed(pinnableContainer);
            Object rememberedValue9 = composer.rememberedValue();
            if (changed2 || rememberedValue9 == companion.getEmpty()) {
                rememberedValue9 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @NotNull
                    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                        boolean invoke$lambda$2;
                        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                        invoke$lambda$2 = FocusableKt$focusable$2.invoke$lambda$2(mutableState2);
                        if (invoke$lambda$2) {
                            MutableState<PinnableContainer.PinnedHandle> mutableState4 = mutableState3;
                            PinnableContainer pinnableContainer2 = pinnableContainer;
                            mutableState4.setValue(pinnableContainer2 != null ? pinnableContainer2.pin() : null);
                        }
                        final MutableState<PinnableContainer.PinnedHandle> mutableState5 = mutableState3;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.FocusableKt$focusable$2$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                PinnableContainer.PinnedHandle invoke$lambda$9;
                                invoke$lambda$9 = FocusableKt$focusable$2.invoke$lambda$9(MutableState.this);
                                if (invoke$lambda$9 != null) {
                                    invoke$lambda$9.unpin();
                                }
                                MutableState.this.setValue(null);
                            }
                        };
                    }
                };
                composer.updateRememberedValue(rememberedValue9);
            }
            composer.endReplaceableGroup();
            EffectsKt.DisposableEffect(pinnableContainer, (Function1) rememberedValue9, composer, 0);
            modifier2 = FocusModifierKt.focusTarget(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(BringIntoViewRequesterKt.bringIntoViewRequester(SemanticsModifierKt.semantics$default(Modifier.Companion, false, new 4(mutableState2, focusRequester), 1, null), bringIntoViewRequester), focusRequester).then(modifier3), new 5(pinnableContainer, coroutineScope, mutableState2, mutableState3, mutableState, this.$interactionSource, bringIntoViewRequester)));
        } else {
            modifier2 = Modifier.Companion;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifier2;
    }
}
