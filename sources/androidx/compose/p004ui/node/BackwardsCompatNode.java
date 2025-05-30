package androidx.compose.p004ui.node;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.BuildDrawCacheParams;
import androidx.compose.p004ui.draw.DrawCacheModifier;
import androidx.compose.p004ui.draw.DrawModifier;
import androidx.compose.p004ui.focus.FocusEventModifier;
import androidx.compose.p004ui.focus.FocusEventModifierNode;
import androidx.compose.p004ui.focus.FocusOrderModifier;
import androidx.compose.p004ui.focus.FocusOrderModifierToProperties;
import androidx.compose.p004ui.focus.FocusProperties;
import androidx.compose.p004ui.focus.FocusPropertiesModifierNode;
import androidx.compose.p004ui.focus.FocusRequesterModifier;
import androidx.compose.p004ui.focus.FocusRequesterModifierNode;
import androidx.compose.p004ui.focus.FocusState;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.input.pointer.PointerEvent;
import androidx.compose.p004ui.input.pointer.PointerEventPass;
import androidx.compose.p004ui.input.pointer.PointerInputModifier;
import androidx.compose.p004ui.layout.IntermediateLayoutModifier;
import androidx.compose.p004ui.layout.IntrinsicMeasurable;
import androidx.compose.p004ui.layout.IntrinsicMeasureScope;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.LayoutModifier;
import androidx.compose.p004ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.p004ui.layout.LookaheadOnPlacedModifier;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.OnGloballyPositionedModifier;
import androidx.compose.p004ui.layout.OnPlacedModifier;
import androidx.compose.p004ui.layout.OnRemeasuredModifier;
import androidx.compose.p004ui.layout.ParentDataModifier;
import androidx.compose.p004ui.layout.RemeasurementModifier;
import androidx.compose.p004ui.modifier.BackwardsCompatLocalMap;
import androidx.compose.p004ui.modifier.ModifierLocal;
import androidx.compose.p004ui.modifier.ModifierLocalConsumer;
import androidx.compose.p004ui.modifier.ModifierLocalMap;
import androidx.compose.p004ui.modifier.ModifierLocalNode;
import androidx.compose.p004ui.modifier.ModifierLocalNodeKt;
import androidx.compose.p004ui.modifier.ModifierLocalProvider;
import androidx.compose.p004ui.modifier.ModifierLocalReadScope;
import androidx.compose.p004ui.node.Owner;
import androidx.compose.p004ui.semantics.SemanticsConfiguration;
import androidx.compose.p004ui.semantics.SemanticsModifier;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.p004ui.unit.LayoutDirection;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pt2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class BackwardsCompatNode extends Modifier.Node implements BuildDrawCacheParams, FocusEventModifierNode, FocusPropertiesModifierNode, FocusRequesterModifierNode, ModifierLocalNode, ModifierLocalReadScope, DrawModifierNode, GlobalPositionAwareModifierNode, IntermediateLayoutModifierNode, LayoutAwareModifierNode, LayoutModifierNode, ParentDataModifierNode, PointerInputModifierNode, SemanticsModifierNode {

    @Nullable
    private BackwardsCompatLocalMap _providedValues;

    @NotNull
    private Modifier.Element element;
    private boolean invalidateCache;

    @Nullable
    private LayoutCoordinates lastOnPlacedCoordinates;

    @NotNull
    private HashSet<ModifierLocal<?>> readValues;

    public BackwardsCompatNode(@NotNull Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element));
        this.element = element;
        this.invalidateCache = true;
        this.readValues = new HashSet<>();
    }

    private final void initializeModifier(boolean z) {
        if (!isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Element element = this.element;
        if ((NodeKind.m4398constructorimpl(32) & getKindSet$ui_release()) != 0) {
            if (element instanceof ModifierLocalProvider) {
                updateModifierLocalProvider((ModifierLocalProvider) element);
            }
            if (element instanceof ModifierLocalConsumer) {
                if (z) {
                    updateModifierLocalConsumer();
                } else {
                    sideEffect(new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$1
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m4268invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m4268invoke() {
                            BackwardsCompatNode.this.updateModifierLocalConsumer();
                        }
                    });
                }
            }
        }
        if ((NodeKind.m4398constructorimpl(4) & getKindSet$ui_release()) != 0) {
            if (element instanceof DrawCacheModifier) {
                this.invalidateCache = true;
            }
            LayoutModifierNodeKt.invalidateLayer(this);
        }
        if ((NodeKind.m4398constructorimpl(2) & getKindSet$ui_release()) != 0) {
            if (DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                NodeCoordinator coordinator$ui_release = getCoordinator$ui_release();
                Intrinsics.checkNotNull(coordinator$ui_release);
                ((LayoutModifierNodeCoordinator) coordinator$ui_release).setLayoutModifierNode$ui_release(this);
                coordinator$ui_release.onLayoutModifierNodeChanged();
            }
            LayoutModifierNodeKt.invalidateLayer(this);
            DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
        }
        if (element instanceof RemeasurementModifier) {
            ((RemeasurementModifier) element).onRemeasurementAvailable(this);
        }
        if ((NodeKind.m4398constructorimpl(128) & getKindSet$ui_release()) != 0) {
            if ((element instanceof OnRemeasuredModifier) && DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
            }
            if (element instanceof OnPlacedModifier) {
                this.lastOnPlacedCoordinates = null;
                if (DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
                    DelegatableNodeKt.requireOwner(this).registerOnLayoutCompletedListener(new Owner.OnLayoutCompletedListener() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$2
                        @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
                        public void onLayoutComplete() {
                            LayoutCoordinates layoutCoordinates;
                            layoutCoordinates = BackwardsCompatNode.this.lastOnPlacedCoordinates;
                            if (layoutCoordinates == null) {
                                BackwardsCompatNode backwardsCompatNode = BackwardsCompatNode.this;
                                backwardsCompatNode.onPlaced(DelegatableNodeKt.m4288requireCoordinator64DMado(backwardsCompatNode, NodeKind.m4398constructorimpl(128)));
                            }
                        }
                    });
                }
            }
        }
        if (((NodeKind.m4398constructorimpl(256) & getKindSet$ui_release()) != 0) && (element instanceof OnGloballyPositionedModifier) && DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release().getTail$ui_release().isAttached()) {
            DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
        }
        if (element instanceof FocusRequesterModifier) {
            ((FocusRequesterModifier) element).getFocusRequester().getFocusRequesterNodes$ui_release().add(this);
        }
        if (((NodeKind.m4398constructorimpl(16) & getKindSet$ui_release()) != 0) && (element instanceof PointerInputModifier)) {
            ((PointerInputModifier) element).getPointerInputFilter().setLayoutCoordinates$ui_release(getCoordinator$ui_release());
        }
        if ((NodeKind.m4398constructorimpl(8) & getKindSet$ui_release()) != 0) {
            DelegatableNodeKt.requireOwner(this).onSemanticsChange();
        }
    }

    private final void unInitializeModifier() {
        BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1 backwardsCompatNodeKt$DetachedModifierLocalReadScope$1;
        if (!isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Element element = this.element;
        if ((NodeKind.m4398constructorimpl(32) & getKindSet$ui_release()) != 0) {
            if (element instanceof ModifierLocalProvider) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().removedProvider(this, ((ModifierLocalProvider) element).getKey());
            }
            if (element instanceof ModifierLocalConsumer) {
                backwardsCompatNodeKt$DetachedModifierLocalReadScope$1 = BackwardsCompatNodeKt.DetachedModifierLocalReadScope;
                ((ModifierLocalConsumer) element).onModifierLocalsUpdated(backwardsCompatNodeKt$DetachedModifierLocalReadScope$1);
            }
        }
        if ((NodeKind.m4398constructorimpl(8) & getKindSet$ui_release()) != 0) {
            DelegatableNodeKt.requireOwner(this).onSemanticsChange();
        }
        if (element instanceof FocusRequesterModifier) {
            ((FocusRequesterModifier) element).getFocusRequester().getFocusRequesterNodes$ui_release().remove(this);
        }
    }

    private final void updateDrawCache() {
        Function1 function1;
        final Modifier.Element element = this.element;
        if (element instanceof DrawCacheModifier) {
            OwnerSnapshotObserver snapshotObserver = DelegatableNodeKt.requireOwner(this).getSnapshotObserver();
            function1 = BackwardsCompatNodeKt.onDrawCacheReadsChanged;
            snapshotObserver.observeReads$ui_release(this, function1, new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateDrawCache$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m4269invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m4269invoke() {
                    ((DrawCacheModifier) Modifier.Element.this).onBuildCache(this);
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

    @Override // androidx.compose.p004ui.node.DrawModifierNode
    public void draw(@NotNull ContentDrawScope contentDrawScope) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        DrawModifier drawModifier = (DrawModifier) element;
        if (this.invalidateCache && (element instanceof DrawCacheModifier)) {
            updateDrawCache();
        }
        drawModifier.draw(contentDrawScope);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode, androidx.compose.p004ui.layout.Remeasurement
    public /* synthetic */ void forceRemeasure() {
        C0800a.m155a(this);
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalNode, androidx.compose.p004ui.modifier.ModifierLocalReadScope
    public <T> T getCurrent(@NotNull ModifierLocal<T> modifierLocal) {
        NodeChain nodes$ui_release;
        Intrinsics.checkNotNullParameter(modifierLocal, "<this>");
        this.readValues.add(modifierLocal);
        int m4398constructorimpl = NodeKind.m4398constructorimpl(32);
        if (!getNode().isAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node parent$ui_release = getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(this);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & m4398constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m4398constructorimpl) != 0 && (parent$ui_release instanceof ModifierLocalNode)) {
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

    @Override // androidx.compose.p004ui.draw.BuildDrawCacheParams
    @NotNull
    public Density getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity();
    }

    @NotNull
    public final Modifier.Element getElement() {
        return this.element;
    }

    @Override // androidx.compose.p004ui.draw.BuildDrawCacheParams
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutNode(this).getLayoutDirection();
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalNode
    @NotNull
    public ModifierLocalMap getProvidedValues() {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        return backwardsCompatLocalMap != null ? backwardsCompatLocalMap : ModifierLocalNodeKt.modifierLocalMapOf();
    }

    @NotNull
    public final HashSet<ModifierLocal<?>> getReadValues() {
        return this.readValues;
    }

    @Override // androidx.compose.p004ui.node.SemanticsModifierNode
    @NotNull
    public SemanticsConfiguration getSemanticsConfiguration() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        return ((SemanticsModifier) element).getSemanticsConfiguration();
    }

    @Override // androidx.compose.p004ui.draw.BuildDrawCacheParams
    /* renamed from: getSize-NH-jbRc */
    public long mo2465getSizeNHjbRc() {
        return IntSizeKt.m5386toSizeozmzZPI(DelegatableNodeKt.m4288requireCoordinator64DMado(this, NodeKind.m4398constructorimpl(128)).mo4191getSizeYbymL2g());
    }

    @Override // androidx.compose.p004ui.node.IntermediateLayoutModifierNode
    /* renamed from: getTargetSize-YbymL2g, reason: not valid java name */
    public long mo4263getTargetSizeYbymL2g() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.IntermediateLayoutModifier");
        return ((IntermediateLayoutModifier) element).mo4189getTargetSizeYbymL2g();
    }

    @Override // androidx.compose.p004ui.node.PointerInputModifierNode
    public boolean interceptOutOfBoundsChildEvents() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element).getPointerInputFilter().getInterceptOutOfBoundsChildEvents();
    }

    @Override // androidx.compose.ui.Modifier.Node, androidx.compose.p004ui.node.OwnerScope
    public boolean isValid() {
        return isAttached();
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).maxIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).maxIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    @NotNull
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo4264measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).mo959measure3p2s80s(measureScope, measurable, j);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).minIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.node.LayoutModifierNode
    public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        return ((LayoutModifier) element).minIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    @Override // androidx.compose.p004ui.focus.FocusPropertiesModifierNode
    public void modifyFocusProperties(@NotNull FocusProperties focusProperties) {
        Intrinsics.checkNotNullParameter(focusProperties, "focusProperties");
        Modifier.Element element = this.element;
        if (!(element instanceof FocusOrderModifier)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        new FocusOrderModifierToProperties((FocusOrderModifier) element).invoke(focusProperties);
    }

    @Override // androidx.compose.p004ui.node.ParentDataModifierNode
    @Nullable
    public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        return ((ParentDataModifier) element).modifyParentData(density, obj);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        initializeModifier(true);
    }

    @Override // androidx.compose.p004ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element).getPointerInputFilter().onCancel();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        unInitializeModifier();
    }

    public final void onDrawCacheReadsChanged$ui_release() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    @Override // androidx.compose.p004ui.focus.FocusEventModifierNode
    public void onFocusEvent(@NotNull FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        Modifier.Element element = this.element;
        if (!(element instanceof FocusEventModifier)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        ((FocusEventModifier) element).onFocusEvent(focusState);
    }

    @Override // androidx.compose.p004ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        ((OnGloballyPositionedModifier) element).onGloballyPositioned(layoutCoordinates);
    }

    @Override // androidx.compose.p004ui.node.LayoutAwareModifierNode
    public void onLookaheadPlaced(@NotNull LookaheadLayoutCoordinates lookaheadLayoutCoordinates) {
        Intrinsics.checkNotNullParameter(lookaheadLayoutCoordinates, "coordinates");
        Modifier.Element element = this.element;
        if (element instanceof LookaheadOnPlacedModifier) {
            ((LookaheadOnPlacedModifier) element).onPlaced(lookaheadLayoutCoordinates);
        }
    }

    @Override // androidx.compose.p004ui.node.DrawModifierNode
    public void onMeasureResultChanged() {
        this.invalidateCache = true;
        DrawModifierNodeKt.invalidateDraw(this);
    }

    @Override // androidx.compose.p004ui.node.LayoutAwareModifierNode
    public void onPlaced(@NotNull LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "coordinates");
        this.lastOnPlacedCoordinates = layoutCoordinates;
        Modifier.Element element = this.element;
        if (element instanceof OnPlacedModifier) {
            ((OnPlacedModifier) element).onPlaced(layoutCoordinates);
        }
    }

    @Override // androidx.compose.p004ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void mo4265onPointerEventH0pRuoY(@NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pointerEventPass, long j) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pointerEventPass, "pass");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        ((PointerInputModifier) element).getPointerInputFilter().mo4102onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
    }

    @Override // androidx.compose.p004ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void mo4266onRemeasuredozmzZPI(long j) {
        Modifier.Element element = this.element;
        if (element instanceof OnRemeasuredModifier) {
            ((OnRemeasuredModifier) element).mo1208onRemeasuredozmzZPI(j);
        }
    }

    @Override // androidx.compose.p004ui.modifier.ModifierLocalNode
    public /* synthetic */ void provide(ModifierLocal modifierLocal, Object obj) {
        pt2.c(this, modifierLocal, obj);
    }

    public final void setElement(@NotNull Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "value");
        if (isAttached()) {
            unInitializeModifier();
        }
        this.element = element;
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element));
        if (isAttached()) {
            initializeModifier(false);
        }
    }

    public final void setReadValues(@NotNull HashSet<ModifierLocal<?>> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.readValues = hashSet;
    }

    @Override // androidx.compose.p004ui.node.IntermediateLayoutModifierNode
    /* renamed from: setTargetSize-ozmzZPI, reason: not valid java name */
    public void mo4267setTargetSizeozmzZPI(long j) {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.IntermediateLayoutModifier");
        ((IntermediateLayoutModifier) element).mo4190setTargetSizeozmzZPI(j);
    }

    @Override // androidx.compose.p004ui.node.PointerInputModifierNode
    public boolean sharePointerInputWithSiblings() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        return ((PointerInputModifier) element).getPointerInputFilter().getShareWithSiblings();
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
                    m4270invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m4270invoke() {
                    Modifier.Element element = BackwardsCompatNode.this.getElement();
                    Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.modifier.ModifierLocalConsumer");
                    ((ModifierLocalConsumer) element).onModifierLocalsUpdated(BackwardsCompatNode.this);
                }
            });
        }
    }
}
