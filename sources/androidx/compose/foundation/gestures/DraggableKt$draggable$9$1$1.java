package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class DraggableKt$draggable$9$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ MutableState<DragInteraction.Start> $draggedInteraction;
    final /* synthetic */ MutableInteractionSource $interactionSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DraggableKt$draggable$9$1$1(MutableState<DragInteraction.Start> mutableState, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.$draggedInteraction = mutableState;
        this.$interactionSource = mutableInteractionSource;
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        final MutableState<DragInteraction.Start> mutableState = this.$draggedInteraction;
        final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$9$1$1$invoke$$inlined$onDispose$1
            public void dispose() {
                DragInteraction.Start start = (DragInteraction.Start) mutableState.getValue();
                if (start != null) {
                    MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                    if (mutableInteractionSource2 != null) {
                        mutableInteractionSource2.tryEmit(new DragInteraction.Cancel(start));
                    }
                    mutableState.setValue((Object) null);
                }
            }
        };
    }
}
