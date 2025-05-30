package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextFieldSelectionManagerKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TextFieldSelectionHandle(boolean z, @NotNull ResolvedTextDirection resolvedTextDirection, @NotNull TextFieldSelectionManager textFieldSelectionManager, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(resolvedTextDirection, "direction");
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "manager");
        Composer startRestartGroup = composer.startRestartGroup(-1344558920);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1344558920, i, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:803)");
        }
        boolean changed = ((i & 14) == 4) | startRestartGroup.changed(textFieldSelectionManager);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = textFieldSelectionManager.handleDragObserver$foundation_release(z);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
        long m486getHandlePositiontuRUvjQ$foundation_release = textFieldSelectionManager.m486getHandlePositiontuRUvjQ$foundation_release(z);
        boolean z2 = TextRange.getReversed-impl(textFieldSelectionManager.getValue$foundation_release().m1985getSelectiond9O1mEE());
        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new TextFieldSelectionHandle.1(textDragObserver, (Continuation) null));
        int i2 = i << 3;
        AndroidSelectionHandles_androidKt.SelectionHandle-8fL75-g(m486getHandlePositiontuRUvjQ$foundation_release, z, resolvedTextDirection, z2, pointerInput, (Function2) null, startRestartGroup, 196608 | (i2 & 112) | (i2 & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new TextFieldSelectionHandle.2(z, resolvedTextDirection, textFieldSelectionManager, i));
    }

    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m490calculateSelectionMagnifierCenterAndroidO0kMr_c(@NotNull TextFieldSelectionManager textFieldSelectionManager, long j) {
        int i;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        TextDelegate textDelegate;
        AnnotatedString text;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResultProxy layoutResult2;
        LayoutCoordinates innerTextFieldCoordinates;
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "manager");
        if (textFieldSelectionManager.getValue$foundation_release().getText().length() == 0) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        Handle draggingHandle = textFieldSelectionManager.getDraggingHandle();
        int i2 = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
        if (i2 == -1) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        if (i2 == 1 || i2 == 2) {
            i = TextRange.getStart-impl(textFieldSelectionManager.getValue$foundation_release().m1985getSelectiond9O1mEE());
        } else {
            if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            i = TextRange.getEnd-impl(textFieldSelectionManager.getValue$foundation_release().m1985getSelectiond9O1mEE());
        }
        int originalToTransformed = textFieldSelectionManager.getOffsetMapping$foundation_release().originalToTransformed(i);
        TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release == null || (layoutResult = state$foundation_release.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        TextFieldState state$foundation_release2 = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release2 == null || (textDelegate = state$foundation_release2.getTextDelegate()) == null || (text = textDelegate.getText()) == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        int coerceIn = RangesKt.coerceIn(originalToTransformed, StringsKt.getIndices(text));
        long m864getCenterF1C5BW0 = value.getBoundingBox(coerceIn).m864getCenterF1C5BW0();
        TextFieldState state$foundation_release3 = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release3 == null || (layoutCoordinates = state$foundation_release3.getLayoutCoordinates()) == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        TextFieldState state$foundation_release4 = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release4 == null || (layoutResult2 = state$foundation_release4.getLayoutResult()) == null || (innerTextFieldCoordinates = layoutResult2.getInnerTextFieldCoordinates()) == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        Offset m484getCurrentDragPosition_m7T9E = textFieldSelectionManager.m484getCurrentDragPosition_m7T9E();
        if (m484getCurrentDragPosition_m7T9E == null) {
            return Offset.Companion.getUnspecified-F1C5BW0();
        }
        float m848getXimpl = Offset.m848getXimpl(innerTextFieldCoordinates.mo1523localPositionOfR5De75A(layoutCoordinates, m484getCurrentDragPosition_m7T9E.m858unboximpl()));
        int lineForOffset = value.getLineForOffset(coerceIn);
        int lineStart = value.getLineStart(lineForOffset);
        int lineEnd = value.getLineEnd(lineForOffset, true);
        boolean z = TextRange.getStart-impl(textFieldSelectionManager.getValue$foundation_release().m1985getSelectiond9O1mEE()) > TextRange.getEnd-impl(textFieldSelectionManager.getValue$foundation_release().m1985getSelectiond9O1mEE());
        float horizontalPosition = TextSelectionDelegateKt.getHorizontalPosition(value, lineStart, true, z);
        float horizontalPosition2 = TextSelectionDelegateKt.getHorizontalPosition(value, lineEnd, false, z);
        float coerceIn2 = RangesKt.coerceIn(m848getXimpl, Math.min(horizontalPosition, horizontalPosition2), Math.max(horizontalPosition, horizontalPosition2));
        return Math.abs(m848getXimpl - coerceIn2) > ((float) (IntSize.getWidth-impl(j) / 2)) ? Offset.Companion.getUnspecified-F1C5BW0() : layoutCoordinates.mo1523localPositionOfR5De75A(innerTextFieldCoordinates, OffsetKt.Offset(coerceIn2, Offset.m849getYimpl(m864getCenterF1C5BW0)));
    }

    public static final boolean isSelectionHandleInVisibleBound(@NotNull TextFieldSelectionManager textFieldSelectionManager, boolean z) {
        LayoutCoordinates layoutCoordinates;
        Rect visibleBounds;
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "<this>");
        TextFieldState state$foundation_release = textFieldSelectionManager.getState$foundation_release();
        if (state$foundation_release == null || (layoutCoordinates = state$foundation_release.getLayoutCoordinates()) == null || (visibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates)) == null) {
            return false;
        }
        return SelectionManagerKt.m471containsInclusiveUv8p0NA(visibleBounds, textFieldSelectionManager.m486getHandlePositiontuRUvjQ$foundation_release(z));
    }
}
