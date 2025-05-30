package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.DrawModifierKt;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.input.pointer.PointerIconKt;
import androidx.compose.p004ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p004ui.semantics.SemanticsModifierKt;
import androidx.compose.p004ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.Stable;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.w51;

/* compiled from: Taobao */
/* loaded from: classes.dex */
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
        this.measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.TextController$measurePolicy$1
            @Override // androidx.compose.p004ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(list, "measurables");
                return IntSize.m5375getHeightimpl(TextDelegate.m1778layoutNN6EwU$default(TextController.this.getState().getTextDelegate(), ConstraintsKt.Constraints(0, i, 0, Integer.MAX_VALUE), intrinsicMeasureScope.getLayoutDirection(), null, 4, null).m4724getSizeYbymL2g());
            }

            @Override // androidx.compose.p004ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(list, "measurables");
                TextController.this.getState().getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                return TextController.this.getState().getTextDelegate().getMaxIntrinsicWidth();
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0064, code lost:
            
                r3 = r5.selectionRegistrar;
             */
            @Override // androidx.compose.p004ui.layout.MeasurePolicy
            @org.jetbrains.annotations.NotNull
            /* renamed from: measure-3p2s80s */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public androidx.compose.p004ui.layout.MeasureResult mo944measure3p2s80s(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.layout.MeasureScope r21, @org.jetbrains.annotations.NotNull java.util.List<? extends androidx.compose.p004ui.layout.Measurable> r22, long r23) {
                /*
                    Method dump skipped, instructions count: 353
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextController$measurePolicy$1.mo944measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
            }

            @Override // androidx.compose.p004ui.layout.MeasurePolicy
            public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(list, "measurables");
                return IntSize.m5375getHeightimpl(TextDelegate.m1778layoutNN6EwU$default(TextController.this.getState().getTextDelegate(), ConstraintsKt.Constraints(0, i, 0, Integer.MAX_VALUE), intrinsicMeasureScope.getLayoutDirection(), null, 4, null).m4724getSizeYbymL2g());
            }

            @Override // androidx.compose.p004ui.layout.MeasurePolicy
            public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(list, "measurables");
                TextController.this.getState().getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                return TextController.this.getState().getTextDelegate().getMinIntrinsicWidth();
            }
        };
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
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.p004ui.layout.LayoutCoordinates r5) {
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
                    long r0 = androidx.compose.p004ui.layout.LayoutCoordinatesKt.positionInWindow(r5)
                    androidx.compose.foundation.text.TextController r5 = androidx.compose.foundation.text.TextController.this
                    androidx.compose.foundation.text.TextState r5 = r5.getState()
                    long r2 = r5.m1815getPreviousGlobalPositionF1C5BW0()
                    boolean r5 = androidx.compose.p004ui.geometry.Offset.m2553equalsimpl0(r0, r2)
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
                    r5.m1817setPreviousGlobalPositionk4lQ0M(r0)
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
                SemanticsPropertiesKt.setText(semanticsPropertyReceiver, AnnotatedString.this);
                final TextController textController = this;
                SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.TextController$createSemanticsModifierFor$1.1
                    {
                        super(1);
                    }

                    @NotNull
                    public final Boolean invoke(@NotNull List<TextLayoutResult> list) {
                        boolean z;
                        Intrinsics.checkNotNullParameter(list, "it");
                        if (TextController.this.getState().getLayoutResult() != null) {
                            TextLayoutResult layoutResult = TextController.this.getState().getLayoutResult();
                            Intrinsics.checkNotNull(layoutResult);
                            list.add(layoutResult);
                            z = true;
                        } else {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                }, 1, null);
            }
        }, 1, null);
    }

    @Stable
    private final Modifier drawTextAndSelectionBehind(Modifier modifier) {
        return DrawModifierKt.drawBehind(GraphicsLayerModifierKt.m2933graphicsLayerAp8cVGQ$default(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131071, null), new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.TextController$drawTextAndSelectionBehind$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull DrawScope drawScope) {
                SelectionRegistrar selectionRegistrar;
                Map<Long, Selection> subselections;
                Intrinsics.checkNotNullParameter(drawScope, "$this$drawBehind");
                TextLayoutResult layoutResult = TextController.this.getState().getLayoutResult();
                if (layoutResult != null) {
                    TextController textController = TextController.this;
                    textController.getState().getDrawScopeInvalidation();
                    selectionRegistrar = textController.selectionRegistrar;
                    Selection selection = (selectionRegistrar == null || (subselections = selectionRegistrar.getSubselections()) == null) ? null : subselections.get(Long.valueOf(textController.getState().getSelectableId()));
                    if (selection != null) {
                        int offset = !selection.getHandlesCrossed() ? selection.getStart().getOffset() : selection.getEnd().getOffset();
                        int offset2 = !selection.getHandlesCrossed() ? selection.getEnd().getOffset() : selection.getStart().getOffset();
                        if (offset != offset2) {
                            w51.G(drawScope, layoutResult.getMultiParagraph().getPathForRange(offset, offset2), textController.getState().m1816getSelectionBackgroundColor0d7_KjU(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
                        }
                    }
                    TextDelegate.Companion.paint(drawScope.getDrawContext().getCanvas(), layoutResult);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: outOfBoundary-0a9Yr6o, reason: not valid java name */
    public final boolean m1768outOfBoundary0a9Yr6o(long j, long j2) {
        TextLayoutResult layoutResult = this.state.getLayoutResult();
        if (layoutResult == null) {
            return false;
        }
        int length = layoutResult.getLayoutInput().getText().getText().length();
        int m4723getOffsetForPositionk4lQ0M = layoutResult.m4723getOffsetForPositionk4lQ0M(j);
        int m4723getOffsetForPositionk4lQ0M2 = layoutResult.m4723getOffsetForPositionk4lQ0M(j2);
        int i = length - 1;
        return (m4723getOffsetForPositionk4lQ0M >= i && m4723getOffsetForPositionk4lQ0M2 >= i) || (m4723getOffsetForPositionk4lQ0M < 0 && m4723getOffsetForPositionk4lQ0M2 < 0);
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

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        SelectionRegistrar selectionRegistrar;
        Selectable selectable = this.state.getSelectable();
        if (selectable == null || (selectionRegistrar = this.selectionRegistrar) == null) {
            return;
        }
        selectionRegistrar.unsubscribe(selectable);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        SelectionRegistrar selectionRegistrar;
        Selectable selectable = this.state.getSelectable();
        if (selectable == null || (selectionRegistrar = this.selectionRegistrar) == null) {
            return;
        }
        selectionRegistrar.unsubscribe(selectable);
    }

    @Override // androidx.compose.runtime.RememberObserver
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
                public final LayoutCoordinates m1769invoke() {
                    return TextController.this.getState().getLayoutCoordinates();
                }
            }, new Function0<TextLayoutResult>() { // from class: androidx.compose.foundation.text.TextController$onRemembered$1$2
                {
                    super(0);
                }

                @Nullable
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final TextLayoutResult m1770invoke() {
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

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.foundation.text.TextController$update$mouseSelectionObserver$1, java.lang.Object] */
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
                    this.lastPosition = companion.m2572getZeroF1C5BW0();
                    this.dragTotalDistance = companion.m2572getZeroF1C5BW0();
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
                public void mo1771onDownk4lQ0M(long j) {
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* renamed from: onDrag-k-4lQ0M, reason: not valid java name */
                public void mo1772onDragk4lQ0M(long j) {
                    boolean m1768outOfBoundary0a9Yr6o;
                    LayoutCoordinates layoutCoordinates = TextController.this.getState().getLayoutCoordinates();
                    if (layoutCoordinates != null) {
                        SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                        TextController textController = TextController.this;
                        if (layoutCoordinates.isAttached() && SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId())) {
                            long m2561plusMKHz9U = Offset.m2561plusMKHz9U(this.dragTotalDistance, j);
                            this.dragTotalDistance = m2561plusMKHz9U;
                            long m2561plusMKHz9U2 = Offset.m2561plusMKHz9U(this.lastPosition, m2561plusMKHz9U);
                            m1768outOfBoundary0a9Yr6o = textController.m1768outOfBoundary0a9Yr6o(this.lastPosition, m2561plusMKHz9U2);
                            if (m1768outOfBoundary0a9Yr6o || !selectionRegistrar2.mo1886notifySelectionUpdate5iVPX68(layoutCoordinates, m2561plusMKHz9U2, this.lastPosition, false, SelectionAdjustment.Companion.getCharacterWithWordAccelerate())) {
                                return;
                            }
                            this.lastPosition = m2561plusMKHz9U2;
                            this.dragTotalDistance = Offset.Companion.m2572getZeroF1C5BW0();
                        }
                    }
                }

                @Override // androidx.compose.foundation.text.TextDragObserver
                /* renamed from: onStart-k-4lQ0M, reason: not valid java name */
                public void mo1773onStartk4lQ0M(long j) {
                    boolean m1768outOfBoundary0a9Yr6o;
                    LayoutCoordinates layoutCoordinates = TextController.this.getState().getLayoutCoordinates();
                    if (layoutCoordinates != null) {
                        TextController textController = TextController.this;
                        SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                        if (!layoutCoordinates.isAttached()) {
                            return;
                        }
                        m1768outOfBoundary0a9Yr6o = textController.m1768outOfBoundary0a9Yr6o(j, j);
                        if (m1768outOfBoundary0a9Yr6o) {
                            selectionRegistrar2.notifySelectionUpdateSelectAll(textController.getState().getSelectableId());
                        } else {
                            selectionRegistrar2.mo1887notifySelectionUpdateStartd4ec7I(layoutCoordinates, j, SelectionAdjustment.Companion.getWord());
                        }
                        this.lastPosition = j;
                    }
                    if (SelectionRegistrarKt.hasSelection(selectionRegistrar, TextController.this.getState().getSelectableId())) {
                        this.dragTotalDistance = Offset.Companion.m2572getZeroF1C5BW0();
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
            modifier = SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, getLongPressDragObserver(), new TextController$update$2(this, null));
        } else {
            ?? r0 = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.TextController$update$mouseSelectionObserver$1
                private long lastPosition = Offset.Companion.m2572getZeroF1C5BW0();

                public final long getLastPosition() {
                    return this.lastPosition;
                }

                @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
                /* renamed from: onDrag-3MmeM6k, reason: not valid java name */
                public boolean mo1774onDrag3MmeM6k(long j, @NotNull SelectionAdjustment selectionAdjustment) {
                    Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
                    LayoutCoordinates layoutCoordinates = TextController.this.getState().getLayoutCoordinates();
                    if (layoutCoordinates != null) {
                        SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                        TextController textController = TextController.this;
                        if (!layoutCoordinates.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId())) {
                            return false;
                        }
                        if (selectionRegistrar2.mo1886notifySelectionUpdate5iVPX68(layoutCoordinates, j, this.lastPosition, false, selectionAdjustment)) {
                            this.lastPosition = j;
                        }
                    }
                    return true;
                }

                @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
                /* renamed from: onExtend-k-4lQ0M, reason: not valid java name */
                public boolean mo1775onExtendk4lQ0M(long j) {
                    LayoutCoordinates layoutCoordinates = TextController.this.getState().getLayoutCoordinates();
                    if (layoutCoordinates == null) {
                        return false;
                    }
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    TextController textController = TextController.this;
                    if (!layoutCoordinates.isAttached()) {
                        return false;
                    }
                    if (selectionRegistrar2.mo1886notifySelectionUpdate5iVPX68(layoutCoordinates, j, this.lastPosition, false, SelectionAdjustment.Companion.getNone())) {
                        this.lastPosition = j;
                    }
                    return SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId());
                }

                @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
                /* renamed from: onExtendDrag-k-4lQ0M, reason: not valid java name */
                public boolean mo1776onExtendDragk4lQ0M(long j) {
                    LayoutCoordinates layoutCoordinates = TextController.this.getState().getLayoutCoordinates();
                    if (layoutCoordinates == null) {
                        return true;
                    }
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    TextController textController = TextController.this;
                    if (!layoutCoordinates.isAttached() || !SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId())) {
                        return false;
                    }
                    if (!selectionRegistrar2.mo1886notifySelectionUpdate5iVPX68(layoutCoordinates, j, this.lastPosition, false, SelectionAdjustment.Companion.getNone())) {
                        return true;
                    }
                    this.lastPosition = j;
                    return true;
                }

                @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
                /* renamed from: onStart-3MmeM6k, reason: not valid java name */
                public boolean mo1777onStart3MmeM6k(long j, @NotNull SelectionAdjustment selectionAdjustment) {
                    Intrinsics.checkNotNullParameter(selectionAdjustment, "adjustment");
                    LayoutCoordinates layoutCoordinates = TextController.this.getState().getLayoutCoordinates();
                    if (layoutCoordinates == null) {
                        return false;
                    }
                    SelectionRegistrar selectionRegistrar2 = selectionRegistrar;
                    TextController textController = TextController.this;
                    if (!layoutCoordinates.isAttached()) {
                        return false;
                    }
                    selectionRegistrar2.mo1887notifySelectionUpdateStartd4ec7I(layoutCoordinates, j, selectionAdjustment);
                    this.lastPosition = j;
                    return SelectionRegistrarKt.hasSelection(selectionRegistrar2, textController.getState().getSelectableId());
                }

                public final void setLastPosition(long j) {
                    this.lastPosition = j;
                }
            };
            modifier = PointerIconKt.pointerHoverIcon$default(SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, (Object) r0, new TextController$update$3(r0, null)), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
        }
        this.selectionModifiers = modifier;
    }
}
