package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.R$styleable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class CoordinatorLayout$LayoutParams extends ViewGroup.MarginLayoutParams {
    public int anchorGravity;
    public int dodgeInsetEdges;
    public int gravity;
    public int insetEdge;
    public int keyline;
    View mAnchorDirectChild;
    int mAnchorId;
    View mAnchorView;
    CoordinatorLayout.Behavior mBehavior;
    boolean mBehaviorResolved;
    Object mBehaviorTag;
    private boolean mDidAcceptNestedScrollNonTouch;
    private boolean mDidAcceptNestedScrollTouch;
    private boolean mDidBlockInteraction;
    private boolean mDidChangeAfterNestedScroll;
    int mInsetOffsetX;
    int mInsetOffsetY;
    final Rect mLastChildRect;

    public CoordinatorLayout$LayoutParams(int i, int i2) {
        super(i, i2);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        this.mLastChildRect = new Rect();
    }

    private void resolveAnchorView(View view, CoordinatorLayout coordinatorLayout) {
        View findViewById = coordinatorLayout.findViewById(this.mAnchorId);
        this.mAnchorView = findViewById;
        if (findViewById == null) {
            if (coordinatorLayout.isInEditMode()) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return;
            }
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.mAnchorId) + " to anchor view " + view);
        }
        if (findViewById == coordinatorLayout) {
            if (!coordinatorLayout.isInEditMode()) {
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            }
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        }
        for (ViewParent parent = findViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
            if (parent == view) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                }
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return;
            }
            if (parent instanceof View) {
                findViewById = (View) parent;
            }
        }
        this.mAnchorDirectChild = findViewById;
    }

    private boolean shouldDodge(View view, int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(((CoordinatorLayout$LayoutParams) view.getLayoutParams()).insetEdge, i);
        return absoluteGravity != 0 && (GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, i) & absoluteGravity) == absoluteGravity;
    }

    private boolean verifyAnchorView(View view, CoordinatorLayout coordinatorLayout) {
        if (this.mAnchorView.getId() != this.mAnchorId) {
            return false;
        }
        View view2 = this.mAnchorView;
        for (CoordinatorLayout parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
            if (parent == null || parent == view) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return false;
            }
            if (parent instanceof View) {
                view2 = (View) parent;
            }
        }
        this.mAnchorDirectChild = view2;
        return true;
    }

    boolean checkAnchorChanged() {
        return this.mAnchorView == null && this.mAnchorId != -1;
    }

    boolean dependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        CoordinatorLayout.Behavior behavior;
        return view2 == this.mAnchorDirectChild || shouldDodge(view2, ViewCompat.getLayoutDirection(coordinatorLayout)) || ((behavior = this.mBehavior) != null && behavior.layoutDependsOn(coordinatorLayout, view, view2));
    }

    boolean didBlockInteraction() {
        if (this.mBehavior == null) {
            this.mDidBlockInteraction = false;
        }
        return this.mDidBlockInteraction;
    }

    View findAnchorView(CoordinatorLayout coordinatorLayout, View view) {
        if (this.mAnchorId == -1) {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return null;
        }
        if (this.mAnchorView == null || !verifyAnchorView(view, coordinatorLayout)) {
            resolveAnchorView(view, coordinatorLayout);
        }
        return this.mAnchorView;
    }

    @IdRes
    public int getAnchorId() {
        return this.mAnchorId;
    }

    @Nullable
    public CoordinatorLayout.Behavior getBehavior() {
        return this.mBehavior;
    }

    boolean getChangedAfterNestedScroll() {
        return this.mDidChangeAfterNestedScroll;
    }

    Rect getLastChildRect() {
        return this.mLastChildRect;
    }

    void invalidateAnchor() {
        this.mAnchorDirectChild = null;
        this.mAnchorView = null;
    }

    boolean isBlockingInteractionBelow(CoordinatorLayout coordinatorLayout, View view) {
        boolean z = this.mDidBlockInteraction;
        if (z) {
            return true;
        }
        CoordinatorLayout.Behavior behavior = this.mBehavior;
        boolean blocksInteractionBelow = (behavior != null ? behavior.blocksInteractionBelow(coordinatorLayout, view) : false) | z;
        this.mDidBlockInteraction = blocksInteractionBelow;
        return blocksInteractionBelow;
    }

    boolean isNestedScrollAccepted(int i) {
        if (i == 0) {
            return this.mDidAcceptNestedScrollTouch;
        }
        if (i != 1) {
            return false;
        }
        return this.mDidAcceptNestedScrollNonTouch;
    }

    void resetChangedAfterNestedScroll() {
        this.mDidChangeAfterNestedScroll = false;
    }

    void resetNestedScroll(int i) {
        setNestedScrollAccepted(i, false);
    }

    void resetTouchBehaviorTracking() {
        this.mDidBlockInteraction = false;
    }

    public void setAnchorId(@IdRes int i) {
        invalidateAnchor();
        this.mAnchorId = i;
    }

    public void setBehavior(@Nullable CoordinatorLayout.Behavior behavior) {
        CoordinatorLayout.Behavior behavior2 = this.mBehavior;
        if (behavior2 != behavior) {
            if (behavior2 != null) {
                behavior2.onDetachedFromLayoutParams();
            }
            this.mBehavior = behavior;
            this.mBehaviorTag = null;
            this.mBehaviorResolved = true;
            if (behavior != null) {
                behavior.onAttachedToLayoutParams(this);
            }
        }
    }

    void setChangedAfterNestedScroll(boolean z) {
        this.mDidChangeAfterNestedScroll = z;
    }

    void setLastChildRect(Rect rect) {
        this.mLastChildRect.set(rect);
    }

    void setNestedScrollAccepted(int i, boolean z) {
        if (i == 0) {
            this.mDidAcceptNestedScrollTouch = z;
        } else {
            if (i != 1) {
                return;
            }
            this.mDidAcceptNestedScrollNonTouch = z;
        }
    }

    CoordinatorLayout$LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        this.mLastChildRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
        this.gravity = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
        this.mAnchorId = obtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
        this.anchorGravity = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
        this.keyline = obtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
        this.insetEdge = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
        this.dodgeInsetEdges = obtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
        int i = R$styleable.CoordinatorLayout_Layout_layout_behavior;
        boolean hasValue = obtainStyledAttributes.hasValue(i);
        this.mBehaviorResolved = hasValue;
        if (hasValue) {
            this.mBehavior = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(i));
        }
        obtainStyledAttributes.recycle();
        CoordinatorLayout.Behavior behavior = this.mBehavior;
        if (behavior != null) {
            behavior.onAttachedToLayoutParams(this);
        }
    }

    public CoordinatorLayout$LayoutParams(CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams) {
        super((ViewGroup.MarginLayoutParams) coordinatorLayout$LayoutParams);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        this.mLastChildRect = new Rect();
    }

    public CoordinatorLayout$LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        this.mLastChildRect = new Rect();
    }

    public CoordinatorLayout$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = -1;
        this.mAnchorId = -1;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        this.mLastChildRect = new Rect();
    }
}
