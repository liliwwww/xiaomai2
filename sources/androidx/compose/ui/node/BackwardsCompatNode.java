package androidx.compose.ui.node;

import androidx.compose.ui.Modifier$Element;
import androidx.compose.ui.Modifier$Node;
import androidx.compose.ui.draw.BuildDrawCacheParams;
import androidx.compose.ui.draw.DrawCacheModifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusOrderModifierToProperties;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifier;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.layout.IntermediateLayoutModifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.LookaheadOnPlacedModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.modifier.BackwardsCompatLocalMap;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalNode;
import androidx.compose.ui.modifier.ModifierLocalNodeKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.node.BackwardsCompatNodeKt;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pt2;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class BackwardsCompatNode extends Modifier$Node implements BuildDrawCacheParams, FocusEventModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode, ModifierLocalNode, ModifierLocalReadScope, DrawModifierNode, GlobalPositionAwareModifierNode, IntermediateLayoutModifierNode, LayoutAwareModifierNode, LayoutModifierNode, ParentDataModifierNode, PointerInputModifierNode, SemanticsModifierNode {

    @Nullable
    private BackwardsCompatLocalMap _providedValues;

    @NotNull
    private Modifier$Element element;
    private boolean invalidateCache;

    @Nullable
    private LayoutCoordinates lastOnPlacedCoordinates;

    @NotNull
    private HashSet<ModifierLocal<?>> readValues;

    public BackwardsCompatNode(@NotNull Modifier$Element modifier$Element) {
        Intrinsics.checkNotNullParameter(modifier$Element, "element");
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(modifier$Element));
        this.element = modifier$Element;
        this.invalidateCache = true;
        this.readValues = new HashSet<>();
    }

    private final void initializeModifier(boolean z) {
        if (!isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        FocusRequesterModifier focusRequesterModifier = this.element;
        if ((NodeKind.m1660constructorimpl(32) & getKindSet$ui_release()) != 0) {
            if (focusRequesterModifier instanceof ModifierLocalProvider) {
                updateModifierLocalProvider((ModifierLocalProvider) focusRequesterModifier);
            }
            if (focusRequesterModifier instanceof ModifierLocalConsumer) {
                if (z) {
                    updateModifierLocalConsumer();
                } else {
                    sideEffect(new initializeModifier.1(this));
                }
            }
        }
        if ((NodeKind.m1660constructorimpl(4) & getKindSet$ui_release()) != 0) {
            if (focusRequesterModifier instanceof DrawCacheModifier) {
                this.invalidateCache = true;
            }
            LayoutModifierNodeKt.invalidateLayer(this);
        }
        if ((NodeKind.m1660constructorimpl(2) & getKindSet$ui_release()) != 0) {
            if (DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                LayoutModifierNodeCoordinator coordinator$ui_release = getCoordinator$ui_release();
                Intrinsics.checkNotNull(coordinator$ui_release);
                coordinator$ui_release.setLayoutModifierNode$ui_release(this);
                coordinator$ui_release.onLayoutModifierNodeChanged();
            }
            LayoutModifierNodeKt.invalidateLayer(this);
            DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
        }
        if (focusRequesterModifier instanceof RemeasurementModifier) {
            ((RemeasurementModifier) focusRequesterModifier).onRemeasurementAvailable(this);
        }
        if ((NodeKind.m1660constructorimpl(128) & getKindSet$ui_release()) != 0) {
            if ((focusRequesterModifier instanceof OnRemeasuredModifier) && DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
            }
            if (focusRequesterModifier instanceof OnPlacedModifier) {
                this.lastOnPlacedCoordinates = null;
                if (DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                    DelegatableNodeKt.requireOwner(this).registerOnLayoutCompletedListener(new initializeModifier.2(this));
                }
            }
        }
        if (((NodeKind.m1660constructorimpl(256) & getKindSet$ui_release()) != 0) && (focusRequesterModifier instanceof OnGloballyPositionedModifier) && DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
            DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
        }
        if (focusRequesterModifier instanceof FocusRequesterModifier) {
            focusRequesterModifier.getFocusRequester().getFocusRequesterNodes$ui_release().add(this);
        }
        if (((NodeKind.m1660constructorimpl(16) & getKindSet$ui_release()) != 0) && (focusRequesterModifier instanceof PointerInputModifier)) {
            ((PointerInputModifier) focusRequesterModifier).getPointerInputFilter().setLayoutCoordinates$ui_release(getCoordinator$ui_release());
        }
        if ((NodeKind.m1660constructorimpl(8) & getKindSet$ui_release()) != 0) {
            DelegatableNodeKt.requireOwner(this).onSemanticsChange();
        }
    }

    private final void unInitializeModifier() {
        BackwardsCompatNodeKt.DetachedModifierLocalReadScope.1 r4;
        if (!isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        FocusRequesterModifier focusRequesterModifier = this.element;
        if ((NodeKind.m1660constructorimpl(32) & getKindSet$ui_release()) != 0) {
            if (focusRequesterModifier instanceof ModifierLocalProvider) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().removedProvider(this, ((ModifierLocalProvider) focusRequesterModifier).getKey());
            }
            if (focusRequesterModifier instanceof ModifierLocalConsumer) {
                r4 = BackwardsCompatNodeKt.DetachedModifierLocalReadScope;
                ((ModifierLocalConsumer) focusRequesterModifier).onModifierLocalsUpdated(r4);
            }
        }
        if ((NodeKind.m1660constructorimpl(8) & getKindSet$ui_release()) != 0) {
            DelegatableNodeKt.requireOwner(this).onSemanticsChange();
        }
        if (focusRequesterModifier instanceof FocusRequesterModifier) {
            focusRequesterModifier.getFocusRequester().getFocusRequesterNodes$ui_release().remove(this);
        }
    }

    private final void updateDrawCache() {
        Function1 function1;
        final Modifier$Element modifier$Element = this.element;
        if (modifier$Element instanceof DrawCacheModifier) {
            OwnerSnapshotObserver snapshotObserver = DelegatableNodeKt.requireOwner(this).getSnapshotObserver();
            function1 = BackwardsCompatNodeKt.onDrawCacheReadsChanged;
            snapshotObserver.observeReads$ui_release(this, function1, new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateDrawCache$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1591invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1591invoke() {
                    ((DrawCacheModifier) Modifier$Element.this).onBuildCache(this);
                }
            });
        }
        this.invalidateCache = false;
    }

    private final void updateModifierLocalProvider(ModifierLocalProvider<?> modifierLocalProvider) {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        if (backwardsCompatLocalMap != null && backwardsCompatLocalMap.contains$ui_release(modifierLocalProvider.getKey())) {
            backwardsCompatLocalMap.setElement(modifierLocalProvider);
            DelegatableNodeKt.requireOwner(this).getModifierLocalManager().updatedProvider(this, modifierLocalProvider.getKey());
        } else {
            this._providedValues = new BackwardsCompatLocalMap(modifierLocalProvider);
            if (DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().insertedProvider(this, modifierLocalProvider.getKey());
            }
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        Modifier$Element modifier$Element = this.element;
        Intrinsics.checkNotNull(modifier$Element, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        DrawModifier drawModifier = (DrawModifier) modifier$Element;
        if (this.invalidateCache && (modifier$Element instanceof DrawCacheModifier)) {
            updateDrawCache();
        }
        drawModifier.draw(contentDrawScope);
    }

    public /* synthetic */ void forceRemeasure() {
        a.a(this);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalNode, androidx.compose.ui.modifier.ModifierLocalReadScope
    public <T> T getCurrent(@NotNull ModifierLocal<T> modifierLocal) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(modifierLocal, "<this>");
        this.readValues.add(modifierLocal);
        int m1660constructorimpl = NodeKind.m1660constructorimpl(32);
        if (!getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier$Node parent$ui_release = getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(this);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m1660constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m1660constructorimpl) != 0 && (parent$ui_release instanceof ModifierLocalNode)) {
                        ModifierLocalNode modifierLocalNode = (ModifierLocalNode) parent$ui_release;
                        if (modifierLocalNode.getProvidedValues().contains$ui_release(modifierLocal)) {
                            return (T) modifierLocalNode.getProvidedValues().get$ui_release(modifierLocal);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        return (T) modifierLocal.getDefaultFactory$ui_release().invoke();
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    @NotNull
    public Density getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity();
    }

    @NotNull
    public final Modifier$Element getElement() {
        return this.element;
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutNode(this).getLayoutDirection();
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalNode
    @NotNull
    public ModifierLocalMap getProvidedValues() {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        return backwardsCompatLocalMap != null ? backwardsCompatLocalMap : ModifierLocalNodeKt.modifierLocalMapOf();
    }

    @NotNull
    public final HashSet<ModifierLocal<?>> getReadValues() {
        return this.readValues;
    }

    @NotNull
    public SemanticsConfiguration getSemanticsConfiguration() {
        SemanticsModifier semanticsModifier = this.element;
        Intrinsics.checkNotNull(semanticsModifier, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        return semanticsModifier.getSemanticsConfiguration();
    }

    @Override // androidx.compose.ui.draw.BuildDrawCacheParams
    /* renamed from: getSize-NH-jbRc */
    public long mo819getSizeNHjbRc() {
        return IntSizeKt.m2202toSizeozmzZPI(DelegatableNodeKt.m1600requireCoordinator64DMado(this, NodeKind.m1660constructorimpl(128)).mo1522getSizeYbymL2g());
    }

    /* renamed from: getTargetSize-YbymL2g, reason: not valid java name */
    public long m1586getTargetSizeYbymL2g() {
        IntermediateLayoutModifier intermediateLayoutModifier = this.element;
        Intrinsics.checkNotNull(intermediateLayoutModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.IntermediateLayoutModifier");
        return intermediateLayoutModifier.getTargetSize-YbymL2g();
    }

    public boolean interceptOutOfBoundsChildEvents() {
        PointerInputModifier pointerInputModifier = this.element;
        Intrinsics.checkNotNull(pointerInputModifier, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return pointerInputModifier.getPointerInputFilter().getInterceptOutOfBoundsChildEvents();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean isValid() {
        return isAttached();
    }

    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        LayoutModifier layoutModifier = this.element;
        Intrinsics.checkNotNull(layoutModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return layoutModifier.maxIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        LayoutModifier layoutModifier = this.element;
        Intrinsics.checkNotNull(layoutModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return layoutModifier.maxIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1587measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        LayoutModifier layoutModifier = this.element;
        Intrinsics.checkNotNull(layoutModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return layoutModifier.measure-3p2s80s(measureScope, measurable, j);
    }

    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        LayoutModifier layoutModifier = this.element;
        Intrinsics.checkNotNull(layoutModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return layoutModifier.minIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        LayoutModifier layoutModifier = this.element;
        Intrinsics.checkNotNull(layoutModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return layoutModifier.minIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void modifyFocusProperties(@NotNull FocusProperties focusProperties) {
        Intrinsics.checkNotNullParameter(focusProperties, "focusProperties");
        Modifier$Element modifier$Element = this.element;
        if (!(modifier$Element instanceof FocusOrderModifier)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        new FocusOrderModifierToProperties((FocusOrderModifier) modifier$Element).invoke(focusProperties);
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    @Nullable
    public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Modifier$Element modifier$Element = this.element;
        Intrinsics.checkNotNull(modifier$Element, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        return ((ParentDataModifier) modifier$Element).modifyParentData(density, obj);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onAttach() {
        initializeModifier(true);
    }

    public void onCancelPointerInput() {
        PointerInputModifier pointerInputModifier = this.element;
        Intrinsics.checkNotNull(pointerInputModifier, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        pointerInputModifier.getPointerInputFilter().onCancel();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        unInitializeModifier();
    }

    public final void onDrawCacheReadsChanged$ui_release() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    public void onFocusEvent(@NotNull FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        Modifier$Element modifier$Element = this.element;
        if (!(modifier$Element instanceof FocusEventModifier)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        ((FocusEventModifier) modifier$Element).onFocusEvent(focusState);
    }

    public void onGloballyPositioned(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        OnGloballyPositionedModifier onGloballyPositionedModifier = this.element;
        Intrinsics.checkNotNull(onGloballyPositionedModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        onGloballyPositionedModifier.onGloballyPositioned(layoutCoordinates);
    }

    public void onLookaheadPlaced(@NotNull LookaheadLayoutCoordinates lookaheadLayoutCoordinates) {
        Intrinsics.checkNotNullParameter(lookaheadLayoutCoordinates, "coordinates");
        LookaheadOnPlacedModifier lookaheadOnPlacedModifier = this.element;
        if (lookaheadOnPlacedModifier instanceof LookaheadOnPlacedModifier) {
            lookaheadOnPlacedModifier.onPlaced(lookaheadLayoutCoordinates);
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void onMeasureResultChanged() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    public void onPlaced(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        this.lastOnPlacedCoordinates = layoutCoordinates;
        Modifier$Element modifier$Element = this.element;
        if (modifier$Element instanceof OnPlacedModifier) {
            ((OnPlacedModifier) modifier$Element).onPlaced(layoutCoordinates);
        }
    }

    /* renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void m1588onPointerEventH0pRuoY(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pointerEventPass, long j) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPass, "pass");
        PointerInputModifier pointerInputModifier = this.element;
        Intrinsics.checkNotNull(pointerInputModifier, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        pointerInputModifier.getPointerInputFilter().onPointerEvent-H0pRuoY(pointerEvent, pointerEventPass, j);
    }

    /* renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void m1589onRemeasuredozmzZPI(long j) {
        Modifier$Element modifier$Element = this.element;
        if (modifier$Element instanceof OnRemeasuredModifier) {
            ((OnRemeasuredModifier) modifier$Element).mo161onRemeasuredozmzZPI(j);
        }
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalNode
    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        pt2.c(this, modifierLocal, obj);
    }

    public final void setElement(@NotNull Modifier$Element modifier$Element) {
        Intrinsics.checkNotNullParameter(modifier$Element, "value");
        if (isAttached()) {
            unInitializeModifier();
        }
        this.element = modifier$Element;
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(modifier$Element));
        if (isAttached()) {
            initializeModifier(false);
        }
    }

    public final void setReadValues(@NotNull HashSet<ModifierLocal<?>> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.readValues = hashSet;
    }

    /* renamed from: setTargetSize-ozmzZPI, reason: not valid java name */
    public void m1590setTargetSizeozmzZPI(long j) {
        IntermediateLayoutModifier intermediateLayoutModifier = this.element;
        Intrinsics.checkNotNull(intermediateLayoutModifier, "null cannot be cast to non-null type androidx.compose.ui.layout.IntermediateLayoutModifier");
        intermediateLayoutModifier.setTargetSize-ozmzZPI(j);
    }

    public boolean sharePointerInputWithSiblings() {
        PointerInputModifier pointerInputModifier = this.element;
        Intrinsics.checkNotNull(pointerInputModifier, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return pointerInputModifier.getPointerInputFilter().getShareWithSiblings();
    }

    @NotNull
    public String toString() {
        return this.element.toString();
    }

    public final void updateModifierLocalConsumer() {
        Function1 function1;
        if (isAttached()) {
            this.readValues.clear();
            OwnerSnapshotObserver snapshotObserver = DelegatableNodeKt.requireOwner(this).getSnapshotObserver();
            function1 = BackwardsCompatNodeKt.updateModifierLocalConsumer;
            snapshotObserver.observeReads$ui_release(this, function1, new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateModifierLocalConsumer$1
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1592invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1592invoke() {
                    Modifier$Element element = BackwardsCompatNode.this.getElement();
                    Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.modifier.ModifierLocalConsumer");
                    ((ModifierLocalConsumer) element).onModifierLocalsUpdated(BackwardsCompatNode.this);
                }
            });
        }
    }
}
