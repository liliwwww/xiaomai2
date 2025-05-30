package androidx.compose.foundation;

import androidx.compose.foundation.ClickableKt$combinedClickable$4$1$1$invoke$;
import androidx.compose.foundation.interaction.MutableInteractionSource;
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
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.ScrollContainerInfo;
import androidx.compose.ui.input.ScrollContainerInfoKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.semantics.Role;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ClickableKt$combinedClickable$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Indication $indication;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $onClickLabel;
    final /* synthetic */ Function0<Unit> $onDoubleClick;
    final /* synthetic */ Function0<Unit> $onLongClick;
    final /* synthetic */ String $onLongClickLabel;
    final /* synthetic */ Role $role;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$combinedClickable$4(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, String str, Role role, String str2) {
        super(3);
        this.$onClick = function0;
        this.$onLongClick = function02;
        this.$onDoubleClick = function03;
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$indication = indication;
        this.$onClickLabel = str;
        this.$role = role;
        this.$onLongClickLabel = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i) {
        Map map;
        Object[] objArr;
        MutableState mutableState;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(1841718000);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1841718000, i, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:293)");
        }
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$onClick, composer, 0);
        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(this.$onLongClick, composer, 0);
        State rememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(this.$onDoubleClick, composer, 0);
        boolean z = this.$onLongClick != null;
        boolean z2 = this.$onDoubleClick != null;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
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
        if (this.$enabled) {
            Boolean valueOf = Boolean.valueOf(z);
            final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            composer.startReplaceableGroup(511388516);
            boolean changed = composer.changed(mutableState2) | composer.changed(mutableInteractionSource);
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
                        return new ClickableKt$combinedClickable$4$1$1$invoke$.inlined.onDispose.1(mutableState2, mutableInteractionSource);
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceableGroup();
            EffectsKt.DisposableEffect(valueOf, (Function1) rememberedValue3, composer, 0);
            ClickableKt.PressedInteractionSourceDisposableEffect(this.$interactionSource, mutableState2, map2, composer, 560);
        }
        composer.endReplaceableGroup();
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = SnapshotStateKt.mutableStateOf$default(delayPressInteraction.1.1.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        MutableState mutableState3 = (MutableState) rememberedValue4;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = SnapshotStateKt.mutableStateOf$default(Offset.m837boximpl(Offset.Companion.getZero-F1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceableGroup();
        MutableState mutableState4 = (MutableState) rememberedValue5;
        Modifier.Companion companion2 = Modifier.Companion;
        Object[] objArr2 = {this.$interactionSource, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(this.$enabled)};
        MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
        Object[] objArr3 = {mutableState4, Boolean.valueOf(z2), Boolean.valueOf(this.$enabled), rememberUpdatedState3, Boolean.valueOf(z), rememberUpdatedState2, mutableInteractionSource2, mutableState2, mutableState3, rememberUpdatedState};
        boolean z3 = this.$enabled;
        composer.startReplaceableGroup(-568225417);
        int i2 = 0;
        boolean z4 = false;
        for (int i3 = 10; i2 < i3; i3 = 10) {
            z4 |= composer.changed(objArr3[i2]);
            i2++;
        }
        Object rememberedValue6 = composer.rememberedValue();
        if (z4 || rememberedValue6 == Composer.Companion.getEmpty()) {
            map = map2;
            objArr = objArr2;
            mutableState = mutableState3;
            Object obj = new gesture.1.1(mutableState4, z2, z3, z, rememberUpdatedState3, rememberUpdatedState2, mutableInteractionSource2, mutableState2, mutableState3, rememberUpdatedState, (Continuation) null);
            composer.updateRememberedValue(obj);
            rememberedValue6 = obj;
        } else {
            map = map2;
            objArr = objArr2;
            mutableState = mutableState3;
        }
        composer.endReplaceableGroup();
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion2, objArr, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue6);
        Modifier.Companion companion3 = Modifier.Companion;
        MutableInteractionSource mutableInteractionSource3 = this.$interactionSource;
        Indication indication = this.$indication;
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
        Modifier modifier2 = ClickableKt.genericClickableWithoutGesture-bdNGguI(companion3, pointerInput, mutableInteractionSource3, indication, coroutineScope, map, mutableState4, this.$enabled, this.$onClickLabel, this.$role, this.$onLongClickLabel, this.$onLongClick, this.$onClick);
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

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((ScrollContainerInfo) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable ScrollContainerInfo scrollContainerInfo) {
                    mutableState5.setValue(new 1(scrollContainerInfo));
                }
            };
            composer.updateRememberedValue(rememberedValue8);
        }
        composer.endReplaceableGroup();
        Modifier consumeScrollContainerInfo = ScrollContainerInfoKt.consumeScrollContainerInfo(modifier2, (Function1) rememberedValue8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return consumeScrollContainerInfo;
    }
}
