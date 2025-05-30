package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.ScrollContainerInfoKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public abstract class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3 {

    @NotNull
    private Density density;

    @NotNull
    private final NestedScrollDispatcher dispatcher;
    private boolean hasUpdateBlock;

    @NotNull
    private Function0<Boolean> isInScrollContainer;
    private int lastHeightMeasureSpec;
    private int lastWidthMeasureSpec;

    @NotNull
    private final LayoutNode layoutNode;

    @Nullable
    private LifecycleOwner lifecycleOwner;

    @NotNull
    private final int[] location;

    @NotNull
    private Modifier modifier;

    @NotNull
    private final NestedScrollingParentHelper nestedScrollingParentHelper;

    @NotNull
    private final Function1<AndroidViewHolder, Unit> onCommitAffectingUpdate;

    @Nullable
    private Function1<? super Density, Unit> onDensityChanged;

    @Nullable
    private Function1<? super Modifier, Unit> onModifierChanged;

    @Nullable
    private Function1<? super Boolean, Unit> onRequestDisallowInterceptTouchEvent;

    @NotNull
    private final Function0<Unit> runUpdate;

    @Nullable
    private SavedStateRegistryOwner savedStateRegistryOwner;

    @NotNull
    private final SnapshotStateObserver snapshotObserver;

    @NotNull
    private Function0<Unit> update;

    @Nullable
    private View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder(@NotNull Context context, @Nullable CompositionContext compositionContext, @NotNull NestedScrollDispatcher nestedScrollDispatcher) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nestedScrollDispatcher, "dispatcher");
        this.dispatcher = nestedScrollDispatcher;
        if (compositionContext != null) {
            WindowRecomposer_androidKt.setCompositionContext(this, compositionContext);
        }
        setSaveFromParentEnabled(false);
        this.update = update.1.INSTANCE;
        Modifier.Companion companion = Modifier.Companion;
        this.modifier = companion;
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);
        this.snapshotObserver = new SnapshotStateObserver(new AndroidViewHolder$snapshotObserver$1(this));
        this.onCommitAffectingUpdate = new onCommitAffectingUpdate.1(this);
        this.runUpdate = new runUpdate.1(this);
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.isInScrollContainer = new Function0<Boolean>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$isInScrollContainer$1
            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m2240invoke() {
                return Boolean.TRUE;
            }
        };
        final LayoutNode layoutNode = new LayoutNode(false, 0, 3, (DefaultConstructorMarker) null);
        final Modifier consumeScrollContainerInfo = ScrollContainerInfoKt.consumeScrollContainerInfo(OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(companion, this), new layoutNode.1.coreModifier.1(layoutNode, this)), new layoutNode.1.coreModifier.2(this, layoutNode)), new layoutNode.1.coreModifier.3(this));
        layoutNode.setModifier(this.modifier.then(consumeScrollContainerInfo));
        this.onModifierChanged = new Function1<Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Modifier) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Modifier modifier) {
                Intrinsics.checkNotNullParameter(modifier, "it");
                layoutNode.setModifier(modifier.then(consumeScrollContainerInfo));
            }
        };
        layoutNode.setDensity(this.density);
        this.onDensityChanged = new Function1<Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Density) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Density density) {
                Intrinsics.checkNotNullParameter(density, "it");
                layoutNode.setDensity(density);
            }
        };
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        layoutNode.setOnAttach$ui_release(new Function1<Owner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Owner) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Owner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
                if (androidComposeView != null) {
                    androidComposeView.addAndroidView(AndroidViewHolder.this, layoutNode);
                }
                Object obj = objectRef.element;
                if (obj != null) {
                    AndroidViewHolder.this.setView$ui_release((View) obj);
                }
            }
        });
        layoutNode.setOnDetach$ui_release(new Function1<Owner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Owner) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Owner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                AndroidComposeView androidComposeView = owner instanceof AndroidComposeView ? (AndroidComposeView) owner : null;
                if (androidComposeView != null) {
                    androidComposeView.removeAndroidView(AndroidViewHolder.this);
                }
                objectRef.element = AndroidViewHolder.this.getView();
                AndroidViewHolder.this.setView$ui_release(null);
            }
        });
        layoutNode.setMeasurePolicy(new MeasurePolicy() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5
            private final int intrinsicHeight(int i) {
                int obtainMeasureSpec;
                AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
                ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                obtainMeasureSpec = androidViewHolder.obtainMeasureSpec(0, i, layoutParams.width);
                androidViewHolder.measure(obtainMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
                return AndroidViewHolder.this.getMeasuredHeight();
            }

            private final int intrinsicWidth(int i) {
                int obtainMeasureSpec;
                AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                AndroidViewHolder androidViewHolder2 = AndroidViewHolder.this;
                ViewGroup.LayoutParams layoutParams = androidViewHolder2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                obtainMeasureSpec = androidViewHolder2.obtainMeasureSpec(0, i, layoutParams.height);
                androidViewHolder.measure(makeMeasureSpec, obtainMeasureSpec);
                return AndroidViewHolder.this.getMeasuredWidth();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(list, "measurables");
                return intrinsicHeight(i);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(list, "measurables");
                return intrinsicWidth(i);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            @NotNull
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo16measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j) {
                int obtainMeasureSpec;
                int obtainMeasureSpec2;
                Intrinsics.checkNotNullParameter(measureScope, "$this$measure");
                Intrinsics.checkNotNullParameter(list, "measurables");
                if (Constraints.m2124getMinWidthimpl(j) != 0) {
                    AndroidViewHolder.this.getChildAt(0).setMinimumWidth(Constraints.m2124getMinWidthimpl(j));
                }
                if (Constraints.m2123getMinHeightimpl(j) != 0) {
                    AndroidViewHolder.this.getChildAt(0).setMinimumHeight(Constraints.m2123getMinHeightimpl(j));
                }
                AndroidViewHolder androidViewHolder = AndroidViewHolder.this;
                int m2124getMinWidthimpl = Constraints.m2124getMinWidthimpl(j);
                int m2122getMaxWidthimpl = Constraints.m2122getMaxWidthimpl(j);
                ViewGroup.LayoutParams layoutParams = AndroidViewHolder.this.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                obtainMeasureSpec = androidViewHolder.obtainMeasureSpec(m2124getMinWidthimpl, m2122getMaxWidthimpl, layoutParams.width);
                AndroidViewHolder androidViewHolder2 = AndroidViewHolder.this;
                int m2123getMinHeightimpl = Constraints.m2123getMinHeightimpl(j);
                int m2121getMaxHeightimpl = Constraints.m2121getMaxHeightimpl(j);
                ViewGroup.LayoutParams layoutParams2 = AndroidViewHolder.this.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2);
                obtainMeasureSpec2 = androidViewHolder2.obtainMeasureSpec(m2123getMinHeightimpl, m2121getMaxHeightimpl, layoutParams2.height);
                androidViewHolder.measure(obtainMeasureSpec, obtainMeasureSpec2);
                return MeasureScope.-CC.p(measureScope, AndroidViewHolder.this.getMeasuredWidth(), AndroidViewHolder.this.getMeasuredHeight(), (Map) null, new measure.1(AndroidViewHolder.this, layoutNode), 4, (Object) null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(list, "measurables");
                return intrinsicHeight(i);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(list, "measurables");
                return intrinsicWidth(i);
            }
        });
        this.layoutNode = layoutNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int obtainMeasureSpec(int i, int i2, int i3) {
        return (i3 >= 0 || i == i2) ? View.MeasureSpec.makeMeasureSpec(RangesKt.coerceIn(i3, i, i2), 1073741824) : (i3 != -2 || i2 == Integer.MAX_VALUE) ? (i3 != -1 || i2 == Integer.MAX_VALUE) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(@Nullable Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.location);
        int[] iArr = this.location;
        region.op(iArr[0], iArr[1], iArr[0] + getWidth(), this.location[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Override // android.view.View
    @Nullable
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams;
        View view = this.view;
        return (view == null || (layoutParams = view.getLayoutParams()) == null) ? new ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    @Nullable
    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Nullable
    public final Function1<Density, Unit> getOnDensityChanged$ui_release() {
        return this.onDensityChanged;
    }

    @Nullable
    public final Function1<Modifier, Unit> getOnModifierChanged$ui_release() {
        return this.onModifierChanged;
    }

    @Nullable
    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    @Nullable
    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    @NotNull
    public final Function0<Unit> getUpdate() {
        return this.update;
    }

    @Nullable
    public final View getView() {
        return this.view;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    @Nullable
    public ViewParent invalidateChildInParent(@Nullable int[] iArr, @Nullable Rect rect) {
        super.invalidateChildInParent(iArr, rect);
        this.layoutNode.invalidateLayer$ui_release();
        return null;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        View view = this.view;
        return view != null ? view.isNestedScrollingEnabled() : super.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotObserver.start();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(@NotNull View view, @NotNull View view2) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(view2, "target");
        super.onDescendantInvalidated(view, view2);
        this.layoutNode.invalidateLayer$ui_release();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.snapshotObserver.stop();
        this.snapshotObserver.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.view;
        if (view != null) {
            view.layout(0, 0, i3 - i, i4 - i2);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.view;
        if (view != null) {
            view.measure(i, i2);
        }
        View view2 = this.view;
        int measuredWidth = view2 != null ? view2.getMeasuredWidth() : 0;
        View view3 = this.view;
        setMeasuredDimension(measuredWidth, view3 != null ? view3.getMeasuredHeight() : 0);
        this.lastWidthMeasureSpec = i;
        this.lastHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(@NotNull View view, float f, float f2, boolean z) {
        Intrinsics.checkNotNullParameter(view, "target");
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        d.d(this.dispatcher.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new onNestedFling.1(z, this, VelocityKt.Velocity(AndroidViewHolder_androidKt.access$toComposeVelocity(f), AndroidViewHolder_androidKt.access$toComposeVelocity(f2)), (Continuation) null), 3, (Object) null);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(@NotNull View view, float f, float f2) {
        Intrinsics.checkNotNullParameter(view, "target");
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        d.d(this.dispatcher.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AndroidViewHolder$onNestedPreFling$1(this, VelocityKt.Velocity(AndroidViewHolder_androidKt.access$toComposeVelocity(f), AndroidViewHolder_androidKt.access$toComposeVelocity(f2)), null), 3, (Object) null);
        return false;
    }

    public void onNestedPreScroll(@NotNull View view, int i, int i2, @NotNull int[] iArr, int i3) {
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        if (isNestedScrollingEnabled()) {
            long j = this.dispatcher.dispatchPreScroll-OzD1aCk(OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(i), AndroidViewHolder_androidKt.access$toComposeOffset(i2)), AndroidViewHolder_androidKt.access$toNestedScrollSource(i3));
            iArr[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m848getXimpl(j));
            iArr[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m849getYimpl(j));
        }
    }

    public void onNestedScroll(@NotNull View view, int i, int i2, int i3, int i4, int i5, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(view, "target");
        Intrinsics.checkNotNullParameter(iArr, "consumed");
        if (isNestedScrollingEnabled()) {
            long j = this.dispatcher.dispatchPostScroll-DzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(i), AndroidViewHolder_androidKt.access$toComposeOffset(i2)), OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(i3), AndroidViewHolder_androidKt.access$toComposeOffset(i4)), AndroidViewHolder_androidKt.access$toNestedScrollSource(i5));
            iArr[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m848getXimpl(j));
            iArr[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m849getYimpl(j));
        }
    }

    public void onNestedScrollAccepted(@NotNull View view, @NotNull View view2, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(view2, "target");
        this.nestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i, i2);
    }

    public boolean onStartNestedScroll(@NotNull View view, @NotNull View view2, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "child");
        Intrinsics.checkNotNullParameter(view2, "target");
        return ((i & 2) == 0 && (i & 1) == 0) ? false : true;
    }

    public void onStopNestedScroll(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "target");
        this.nestedScrollingParentHelper.onStopNestedScroll(view, i);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (Build.VERSION.SDK_INT >= 23 || i != 0) {
            return;
        }
        this.layoutNode.invalidateLayer$ui_release();
    }

    public final void remeasure() {
        int i;
        int i2 = this.lastWidthMeasureSpec;
        if (i2 == Integer.MIN_VALUE || (i = this.lastHeightMeasureSpec) == Integer.MIN_VALUE) {
            return;
        }
        measure(i2, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Function1<? super Boolean, Unit> function1 = this.onRequestDisallowInterceptTouchEvent;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public final void setDensity(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "value");
        if (density != this.density) {
            this.density = density;
            Function1<? super Density, Unit> function1 = this.onDensityChanged;
            if (function1 != null) {
                function1.invoke(density);
            }
        }
    }

    public final void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != this.lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner;
            ViewTreeLifecycleOwner.set(this, lifecycleOwner);
        }
    }

    public final void setModifier(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "value");
        if (modifier != this.modifier) {
            this.modifier = modifier;
            Function1<? super Modifier, Unit> function1 = this.onModifierChanged;
            if (function1 != null) {
                function1.invoke(modifier);
            }
        }
    }

    public final void setOnDensityChanged$ui_release(@Nullable Function1<? super Density, Unit> function1) {
        this.onDensityChanged = function1;
    }

    public final void setOnModifierChanged$ui_release(@Nullable Function1<? super Modifier, Unit> function1) {
        this.onModifierChanged = function1;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(@Nullable Function1<? super Boolean, Unit> function1) {
        this.onRequestDisallowInterceptTouchEvent = function1;
    }

    public final void setSavedStateRegistryOwner(@Nullable SavedStateRegistryOwner savedStateRegistryOwner) {
        if (savedStateRegistryOwner != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = savedStateRegistryOwner;
            ViewTreeSavedStateRegistryOwner.set(this, savedStateRegistryOwner);
        }
    }

    protected final void setUpdate(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "value");
        this.update = function0;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    public final void setView$ui_release(@Nullable View view) {
        if (view != this.view) {
            this.view = view;
            removeAllViewsInLayout();
            if (view != null) {
                addView(view);
                this.runUpdate.invoke();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return ((Boolean) this.isInScrollContainer.invoke()).booleanValue();
    }

    public void onNestedScroll(@NotNull View view, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(view, "target");
        if (isNestedScrollingEnabled()) {
            this.dispatcher.dispatchPostScroll-DzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(i), AndroidViewHolder_androidKt.access$toComposeOffset(i2)), OffsetKt.Offset(AndroidViewHolder_androidKt.access$toComposeOffset(i3), AndroidViewHolder_androidKt.access$toComposeOffset(i4)), AndroidViewHolder_androidKt.access$toNestedScrollSource(i5));
        }
    }
}
