package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.unit.Velocity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gs;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class DraggableKt$draggable$9 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function1<PointerInputChange, Boolean> $canDrag;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> $onDragStarted;
    final /* synthetic */ Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> $onDragStopped;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ boolean $reverseDirection;
    final /* synthetic */ Function0<Boolean> $startDragImmediately;
    final /* synthetic */ DraggableState $state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DraggableKt$draggable$9(MutableInteractionSource mutableInteractionSource, Function0<Boolean> function0, Function1<? super PointerInputChange, Boolean> function1, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> function32, DraggableState draggableState, Orientation orientation, boolean z, boolean z2) {
        super(3);
        this.$interactionSource = mutableInteractionSource;
        this.$startDragImmediately = function0;
        this.$canDrag = function1;
        this.$onDragStarted = function3;
        this.$onDragStopped = function32;
        this.$state = draggableState;
        this.$orientation = orientation;
        this.$enabled = z;
        this.$reverseDirection = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DragLogic invoke$lambda$3(State<DragLogic> state) {
        return (DragLogic) state.getValue();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @Composable
    @NotNull
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(597193710);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(597193710, i, -1, "androidx.compose.foundation.gestures.draggable.<anonymous> (Draggable.kt:220)");
        }
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(mutableState) | composer.changed(mutableInteractionSource);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new 1.1(mutableState, mutableInteractionSource);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect(mutableInteractionSource, (Function1) rememberedValue2, composer, 0);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = gs.b(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        Channel channel = (Channel) rememberedValue3;
        State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.$startDragImmediately, composer, 0);
        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(this.$canDrag, composer, 0);
        State rememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(new DragLogic(this.$onDragStarted, this.$onDragStopped, mutableState, this.$interactionSource), composer, 8);
        DraggableState draggableState = this.$state;
        EffectsKt.LaunchedEffect(draggableState, new 2(channel, draggableState, rememberUpdatedState3, this.$orientation, (Continuation) null), composer, 64);
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, new Object[]{this.$orientation, Boolean.valueOf(this.$enabled), Boolean.valueOf(this.$reverseDirection)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new 3(this.$enabled, rememberUpdatedState2, rememberUpdatedState, this.$orientation, channel, this.$reverseDirection, (Continuation) null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pointerInput;
    }
}
