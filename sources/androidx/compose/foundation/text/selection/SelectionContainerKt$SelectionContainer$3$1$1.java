package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class SelectionContainerKt$SelectionContainer$3$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ Function2<Composer, Integer, Unit> $children;
    final /* synthetic */ SelectionManager $manager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SelectionContainerKt$SelectionContainer$3$1$1(Function2<? super Composer, ? super Integer, Unit> function2, int i, SelectionManager selectionManager) {
        super(2);
        this.$children = function2;
        this.$$dirty = i;
        this.$manager = selectionManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i) {
        Selection selection;
        if ((i & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1375295262, i, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:98)");
        }
        this.$children.invoke(composer, Integer.valueOf((this.$$dirty >> 9) & 14));
        if (TouchMode_androidKt.isInTouchMode() && this.$manager.getHasFocus() && (selection = this.$manager.getSelection()) != null) {
            SelectionManager selectionManager = this.$manager;
            List listOf = CollectionsKt.listOf(new Boolean[]{Boolean.TRUE, Boolean.FALSE});
            int size = listOf.size();
            for (int i2 = 0; i2 < size; i2++) {
                boolean booleanValue = ((Boolean) listOf.get(i2)).booleanValue();
                Boolean valueOf = Boolean.valueOf(booleanValue);
                composer.startReplaceableGroup(1157296644);
                boolean changed = composer.changed(valueOf);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = selectionManager.handleDragObserver(booleanValue);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
                Offset offset = booleanValue ? selectionManager.getStartHandlePosition-_m7T9-E() : selectionManager.getEndHandlePosition-_m7T9-E();
                ResolvedTextDirection direction = booleanValue ? selection.getStart().getDirection() : selection.getEnd().getDirection();
                if (offset != null) {
                    AndroidSelectionHandles_androidKt.SelectionHandle-8fL75-g(offset.m858unboximpl(), booleanValue, direction, selection.getHandlesCrossed(), SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new 1.1.1(textDragObserver, (Continuation) null)), (Function2) null, composer, 196608);
                }
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
