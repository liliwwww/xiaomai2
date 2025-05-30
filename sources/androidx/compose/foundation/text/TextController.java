package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextController implements RememberObserver {

    @NotNull
    private final Modifier coreModifiers;
    public TextDragObserver longPressDragObserver;

    @NotNull
    private final MeasurePolicy measurePolicy;

    @NotNull
    private Modifier selectionModifiers;

    @Nullable
    private SelectionRegistrar selectionRegistrar;

    @NotNull
    private Modifier semanticsModifier;

    @NotNull
    private final TextState state;

    public TextController(@NotNull TextState textState) {
        Intrinsics.checkNotNullParameter(textState, "state");
        this.state = textState;
        this.measurePolicy = new measurePolicy.1(this);
        Modifier.Companion companion = Modifier.Companion;
        this.coreModifiers = OnGloballyPositionedModifierKt.onGloballyPositioned(drawTextAndSelectionBehind(companion), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.TextController$coreModifiers$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutCoordinates) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0038, code lost:
            
                r5 = r4.this$0.selectionRegistrar;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.layout.LayoutCoordinates r5) {
                /*
                    r4 = this;
                    java.lang.String r0 = "it"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                    androidx.compose.foundation.text.TextController r0 = androidx.compose.foundation.text.TextController.this
                    androidx.compose.foundation.text.TextState r0 = r0.getState()
                    r0.setLayoutCoordinates(r5)
                    androidx.compose.foundation.text.TextController r0 = androidx.compose.foundation.text.TextController.this
                    androidx.compose.foundation.text.selection.SelectionRegistrar r0 = androidx.compose.foundation.text.TextController.access$getSelectionRegistrar$p(r0)
                    androidx.compose.foundation.text.TextController r1 = androidx.compose.foundation.text.TextController.this
                    androidx.compose.foundation.text.TextState r1 = r1.getState()
                    long r1 = r1.getSelectableId()
                    boolean r0 = androidx.compose.foundation.text.selection.SelectionRegistrarKt.hasSelection(r0, r1)
                    if (r0 == 0) goto L56
                    long r0 = androidx.compose.ui.layout.LayoutCoordinatesKt.positionInWindow(r5)
                    androidx.compose.foundation.text.TextController r5 = androidx.compose.foundation.text.TextController.this
                    androidx.compose.foundation.text.TextState r5 = r5.getState()
                    long r2 = r5.m458getPreviousGlobalPositionF1C5BW0()
                    boolean r5 = androidx.compose.ui.geometry.Offset.m845equalsimpl0(r0, r2)
                    if (r5 != 0) goto L4d
                    androidx.compose.foundation.text.TextController r5 = androidx.compose.foundation.text.TextController.this
                    androidx.compose.foundation.text.selection.SelectionRegistrar r5 = androidx.compose.foundation.text.TextController.access$getSelectionRegistrar$p(r5)
                    if (r5 == 0) goto L4d
                    androidx.compose.foundation.text.TextController r2 = androidx.compose.foundation.text.TextController.this
                    androidx.compose.foundation.text.TextState r2 = r2.getState()
                    long r2 = r2.getSelectableId()
                    r5.notifyPositionChange(r2)
                L4d:
                    androidx.compose.foundation.text.TextController r5 = androidx.compose.foundation.text.TextController.this
                    androidx.compose.foundation.text.TextState r5 = r5.getState()
                    r5.m460setPreviousGlobalPositionk4lQ0M(r0)
                L56:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextController$coreModifiers$1.invoke(androidx.compose.ui.layout.LayoutCoordinates):void");
            }
        });
        this.semanticsModifier = createSemanticsModifierFor(textState.getTextDelegate().getText());
        this.selectionModifiers = companion;
    }

    private final Modifier createSemanticsModifierFor(final AnnotatedString annotatedString) {
        return SemanticsModifierKt.semantics$default(Modifier.Companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.TextController$createSemanticsModifierFor$1
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
                SemanticsPropertiesKt.setText(semanticsPropertyReceiver, annotatedString);
                SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new 1(this), 1, null);
            }
        }, 1, null);
    }

    @Stable
    private final Modifier drawTextAndSelectionBehind(Modifier modifier) {
        return DrawModifierKt.drawBehind(GraphicsLayerModifierKt.m1125graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.TextController$drawTextAndSelectionBehind$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull DrawScope drawScope) {
                SelectionRegistrar selectionRegistrar;
                Map subselections;
                Intrinsics.checkNotNullParameter(drawScope, "$this$drawBehind");
                TextLayoutResult layoutResult = TextController.this.getState().getLayoutResult();
                if (layoutResult != null) {
                    TextController textController = TextController.this;
                    textController.getState().getDrawScopeInvalidation();
                    selectionRegistrar = textController.selectionRegistrar;
                    Selection selection = (selectionRegistrar == null || (subselections = selectionRegistrar.getSubselections()) == null) ? null : (Selection) subselections.get(Long.valueOf(textController.getState().getSelectableId()));
                    if (selection != null) {
                        int offset = !selection.getHandlesCrossed() ? selection.getStart().getOffset() : selection.getEnd().getOffset();
                        int offset2 = !selection.getHandlesCrossed() ? selection.getEnd().getOffset() : selection.getStart().getOffset();
                        if (offset != offset2) {
                            w51.G(drawScope, layoutResult.getMultiParagraph().getPathForRange(offset, offset2), textController.getState().m459getSelectionBackgroundColor0d7_KjU(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
                        }
                    }
                    TextDelegate.Companion.paint(drawScope.getDrawContext().getCanvas(), layoutResult);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: outOfBoundary-0a9Yr6o, reason: not valid java name */
    public final boolean m431outOfBoundary0a9Yr6o(long j, long j2) {
        TextLayoutResult layoutResult = this.state.getLayoutResult();
        if (layoutResult == null) {
            return false;
        }
        int length = layoutResult.getLayoutInput().getText().getText().length();
        int m1888getOffsetForPositionk4lQ0M = layoutResult.m1888getOffsetForPositionk4lQ0M(j);
        int m1888getOffsetForPositionk4lQ0M2 = layoutResult.m1888getOffsetForPositionk4lQ0M(j2);
        int i = length - 1;
        return (m1888getOffsetForPositionk4lQ0M >= i && m1888getOffsetForPositionk4lQ0M2 >= i) || (m1888getOffsetForPositionk4lQ0M < 0 && m1888getOffsetForPositionk4lQ0M2 < 0);
    }

    @NotNull
    public final TextDragObserver getLongPressDragObserver() {
        TextDragObserver textDragObserver = this.longPressDragObserver;
        if (textDragObserver != null) {
            return textDragObserver;
        }
        Intrinsics.throwUninitializedPropertyAccessException("longPressDragObserver");
        return null;
    }

    @NotNull
    public final MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @NotNull
    public final Modifier getModifiers() {
        return HeightInLinesModifierKt.heightInLines$default(this.coreModifiers, this.state.getTextDelegate().getStyle(), this.state.getTextDelegate().getMinLines(), 0, 4, null).then(this.semanticsModifier).then(this.selectionModifiers);
    }

    @NotNull
    public final Modifier getSemanticsModifier$foundation_release() {
        return this.semanticsModifier;
    }

    @NotNull
    public final TextState getState() {
        return this.state;
    }

    public void onAbandoned() {
        SelectionRegistrar selectionRegistrar;
        Selectable selectable = this.state.getSelectable();
        if (selectable == null || (selectionRegistrar = this.selectionRegistrar) == null) {
            return;
        }
        selectionRegistrar.unsubscribe(selectable);
    }

    public void onForgotten() {
        SelectionRegistrar selectionRegistrar;
        Selectable selectable = this.state.getSelectable();
        if (selectable == null || (selectionRegistrar = this.selectionRegistrar) == null) {
            return;
        }
        selectionRegistrar.unsubscribe(selectable);
    }

    public void onRemembered() {
        SelectionRegistrar selectionRegistrar = this.selectionRegistrar;
        if (selectionRegistrar != null) {
            TextState textState = this.state;
            textState.setSelectable(selectionRegistrar.subscribe(new MultiWidgetSelectionDelegate(textState.getSelectableId(), new Function0<LayoutCoordinates>() { // from class: androidx.compose.foundation.text.TextController$onRemembered$1$1
                {
                    super(0);
                }

                @Nullable
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final LayoutCoordinates m432invoke() {
                    return TextController.this.getState().getLayoutCoordinates();
                }
            }, new Function0<TextLayoutResult>() { // from class: androidx.compose.foundation.text.TextController$onRemembered$1$2
                {
                    super(0);
                }

                @Nullable
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final TextLayoutResult m433invoke() {
                    return TextController.this.getState().getLayoutResult();
                }
            })));
        }
    }

    public final void setLongPressDragObserver(@NotNull TextDragObserver textDragObserver) {
        Intrinsics.checkNotNullParameter(textDragObserver, "<set-?>");
        this.longPressDragObserver = textDragObserver;
    }

    public final void setTextDelegate(@NotNull TextDelegate textDelegate) {
        Intrinsics.checkNotNullParameter(textDelegate, "textDelegate");
        if (this.state.getTextDelegate() == textDelegate) {
            return;
        }
        this.state.setTextDelegate(textDelegate);
        this.semanticsModifier = createSemanticsModifierFor(this.state.getTextDelegate().getText());
    }

    public final void update(@Nullable final SelectionRegistrar selectionRegistrar) {
        Modifier modifier;
        this.selectionRegistrar = selectionRegistrar;
        if (selectionRegistrar == null) {
            modifier = Modifier.Companion;
        } else if (TouchMode_androidKt.isInTouchMode()) {
            setLongPressDragObserver(new TextDragObserver() { // from class: androidx.compose.foundation.text.TextController$update$1
                private long dragTotalDistance;
                private long lastPosition;

                {
                    Offset.Companion companion = Offset.Companion;
                    this.lastPosition = companion.getZero-F1C5BW0();
                    this.dragTotalDistance = companion.getZero-F1C5BW0();
                }

                public final long getDragTotalDistance() {
                    return this.dragTotalDistance;
                }

                public final long getLastPosition() {
                    return this.lastPosition;
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public void onCancel() {
                    if (SelectionRegistrarKt.hasSelection(selectionRegistrar, TextController.this.getState().getSelectableId())) {
                        selectionRegistrar.notifySelectionUpdateEnd();
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* renamed from: onDown-k-4lQ0M, reason: not valid java name */
                public void mo434onDownk4lQ0M(long j) {
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* renamed from: onDrag-k-4lQ0M, reason: not valid java name */
                public void mo435onDragk4lQ0M(long j) {
                    boolean m431outOfBoundary0a9Yr6o;
                    LayoutCoordinates layoutCoordinates = TextController.this.getState().getLayoutCoordinates();
                    if (layoutCoordinates != null) {
                        SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                        TextController textController = TextController.this;
                        if (layoutCoordinates.isAttached() && SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId())) {
                            long m853plusMKHz9U = Offset.m853plusMKHz9U(this.dragTotalDistance, j);
                            this.dragTotalDistance = m853plusMKHz9U;
                            long m853plusMKHz9U2 = Offset.m853plusMKHz9U(this.lastPosition, m853plusMKHz9U);
                            m431outOfBoundary0a9Yr6o = textController.m431outOfBoundary0a9Yr6o(this.lastPosition, m853plusMKHz9U2);
                            if (m431outOfBoundary0a9Yr6o || !selectionRegistrar2.notifySelectionUpdate-5iVPX68(layoutCoordinates, m853plusMKHz9U2, this.lastPosition, false, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
                                return;
                            }
                            this.lastPosition = m853plusMKHz9U2;
                            this.dragTotalDistance = Offset.Companion.getZero-F1C5BW0();
                        }
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* renamed from: onStart-k-4lQ0M, reason: not valid java name */
                public void mo436onStartk4lQ0M(long j) {
                    boolean m431outOfBoundary0a9Yr6o;
                    LayoutCoordinates layoutCoordinates = TextController.this.getState().getLayoutCoordinates();
                    if (layoutCoordinates != null) {
                        TextController textController = TextController.this;
                        SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                        if (!layoutCoordinates.isAttached()) {
                            return;
                        }
                        m431outOfBoundary0a9Yr6o = textController.m431outOfBoundary0a9Yr6o(j, j);
                        if (m431outOfBoundary0a9Yr6o) {
                            selectionRegistrar2.notifySelectionUpdateSelectAll(textController.getState().getSelectableId());
                        } else {
                            selectionRegistrar2.notifySelectionUpdateStart-d-4ec7I(layoutCoordinates, j, SelectionAdjustment.Companion.getWord());
                        }
                        this.lastPosition = j;
                    }
                    if (SelectionRegistrarKt.hasSelection(selectionRegistrar, TextController.this.getState().getSelectableId())) {
                        this.dragTotalDistance = Offset.Companion.getZero-F1C5BW0();
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public void onStop() {
                    if (SelectionRegistrarKt.hasSelection(selectionRegistrar, TextController.this.getState().getSelectableId())) {
                        selectionRegistrar.notifySelectionUpdateEnd();
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                public void onUp() {
                }

                public final void setDragTotalDistance(long j) {
                    this.dragTotalDistance = j;
                }

                public final void setLastPosition(long j) {
                    this.lastPosition = j;
                }
            });
            modifier = SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) getLongPressDragObserver(), (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new TextController$update$2(this, null));
        } else {
            update.mouseSelectionObserver.1 r0 = new update.mouseSelectionObserver.1(this, selectionRegistrar);
            modifier = PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) r0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new TextController$update$3(r0, null)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
        }
        this.selectionModifiers = modifier;
    }
}
