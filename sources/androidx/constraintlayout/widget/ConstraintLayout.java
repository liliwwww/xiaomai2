package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.4";
    private static SharedValues sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected ConstraintLayoutStates mConstraintLayoutSpec;
    private ConstraintSet mConstraintSet;
    private int mConstraintSetId;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected ConstraintWidgetContainer mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    Measurer mMeasurer;
    private Metrics mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;

    /* compiled from: Taobao */
    class Measurer implements BasicMeasure.Measurer {
        ConstraintLayout layout;
        int layoutHeightSpec;
        int layoutWidthSpec;
        int paddingBottom;
        int paddingHeight;
        int paddingTop;
        int paddingWidth;

        public Measurer(ConstraintLayout constraintLayout) {
            this.layout = constraintLayout;
        }

        private boolean isSimilarSpec(int i, int i2, int i3) {
            if (i == i2) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i);
            View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i3 == size;
            }
            return false;
        }

        public void captureLayoutInfo(int i, int i2, int i3, int i4, int i5, int i6) {
            this.paddingTop = i3;
            this.paddingBottom = i4;
            this.paddingWidth = i5;
            this.paddingHeight = i6;
            this.layoutWidthSpec = i;
            this.layoutHeightSpec = i2;
        }

        public final void didMeasures() {
            int childCount = this.layout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                Placeholder childAt = this.layout.getChildAt(i);
                if (childAt instanceof Placeholder) {
                    childAt.updatePostMeasure(this.layout);
                }
            }
            int size = this.layout.mConstraintHelpers.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    ((ConstraintHelper) this.layout.mConstraintHelpers.get(i2)).updatePostMeasure(this.layout);
                }
            }
        }

        @SuppressLint({"WrongCall"})
        public final void measure(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
            int makeMeasureSpec;
            int makeMeasureSpec2;
            int baseline;
            int max;
            int i;
            int i2;
            int i3;
            if (constraintWidget == null) {
                return;
            }
            if (constraintWidget.getVisibility() == 8 && !constraintWidget.isInPlaceholder()) {
                measure.measuredWidth = 0;
                measure.measuredHeight = 0;
                measure.measuredBaseline = 0;
                return;
            }
            if (constraintWidget.getParent() == null) {
                return;
            }
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = measure.horizontalBehavior;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = measure.verticalBehavior;
            int i4 = measure.horizontalDimension;
            int i5 = measure.verticalDimension;
            int i6 = this.paddingTop + this.paddingBottom;
            int i7 = this.paddingWidth;
            VirtualLayout virtualLayout = (View) constraintWidget.getCompanionWidget();
            int[] iArr = 1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintWidget$DimensionBehaviour;
            int i8 = iArr[constraintWidget$DimensionBehaviour.ordinal()];
            if (i8 == 1) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, BasicMeasure.EXACTLY);
            } else if (i8 == 2) {
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i7, -2);
            } else if (i8 == 3) {
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i7 + constraintWidget.getHorizontalMargin(), -1);
            } else if (i8 != 4) {
                makeMeasureSpec = 0;
            } else {
                makeMeasureSpec = ViewGroup.getChildMeasureSpec(this.layoutWidthSpec, i7, -2);
                boolean z = constraintWidget.mMatchConstraintDefaultWidth == 1;
                int i9 = measure.measureStrategy;
                if (i9 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i9 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {
                    if (measure.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || !z || (z && (virtualLayout.getMeasuredHeight() == constraintWidget.getHeight())) || (virtualLayout instanceof Placeholder) || constraintWidget.isResolvedHorizontally()) {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.getWidth(), BasicMeasure.EXACTLY);
                    }
                }
            }
            int i10 = iArr[constraintWidget$DimensionBehaviour2.ordinal()];
            if (i10 == 1) {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, BasicMeasure.EXACTLY);
            } else if (i10 == 2) {
                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i6, -2);
            } else if (i10 == 3) {
                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i6 + constraintWidget.getVerticalMargin(), -1);
            } else if (i10 != 4) {
                makeMeasureSpec2 = 0;
            } else {
                makeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.layoutHeightSpec, i6, -2);
                boolean z2 = constraintWidget.mMatchConstraintDefaultHeight == 1;
                int i11 = measure.measureStrategy;
                if (i11 == BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS || i11 == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS) {
                    if (measure.measureStrategy == BasicMeasure.Measure.USE_GIVEN_DIMENSIONS || !z2 || (z2 && (virtualLayout.getMeasuredWidth() == constraintWidget.getWidth())) || (virtualLayout instanceof Placeholder) || constraintWidget.isResolvedVertically()) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.getHeight(), BasicMeasure.EXACTLY);
                    }
                }
            }
            ConstraintWidgetContainer parent = constraintWidget.getParent();
            if (parent != null && Optimizer.enabled(ConstraintLayout.this.mOptimizationLevel, 256) && virtualLayout.getMeasuredWidth() == constraintWidget.getWidth() && virtualLayout.getMeasuredWidth() < parent.getWidth() && virtualLayout.getMeasuredHeight() == constraintWidget.getHeight() && virtualLayout.getMeasuredHeight() < parent.getHeight() && virtualLayout.getBaseline() == constraintWidget.getBaselineDistance() && !constraintWidget.isMeasureRequested()) {
                if (isSimilarSpec(constraintWidget.getLastHorizontalMeasureSpec(), makeMeasureSpec, constraintWidget.getWidth()) && isSimilarSpec(constraintWidget.getLastVerticalMeasureSpec(), makeMeasureSpec2, constraintWidget.getHeight())) {
                    measure.measuredWidth = constraintWidget.getWidth();
                    measure.measuredHeight = constraintWidget.getHeight();
                    measure.measuredBaseline = constraintWidget.getBaselineDistance();
                    return;
                }
            }
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z3 = constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour3;
            boolean z4 = constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
            boolean z5 = constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour4 || constraintWidget$DimensionBehaviour2 == ConstraintWidget$DimensionBehaviour.FIXED;
            boolean z6 = constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour4 || constraintWidget$DimensionBehaviour == ConstraintWidget$DimensionBehaviour.FIXED;
            boolean z7 = z3 && constraintWidget.mDimensionRatio > 0.0f;
            boolean z8 = z4 && constraintWidget.mDimensionRatio > 0.0f;
            if (virtualLayout == null) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) virtualLayout.getLayoutParams();
            int i12 = measure.measureStrategy;
            if (i12 != BasicMeasure.Measure.TRY_GIVEN_DIMENSIONS && i12 != BasicMeasure.Measure.USE_GIVEN_DIMENSIONS && z3 && constraintWidget.mMatchConstraintDefaultWidth == 0 && z4 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                i3 = -1;
                i2 = 0;
                baseline = 0;
                max = 0;
            } else {
                if ((virtualLayout instanceof VirtualLayout) && (constraintWidget instanceof VirtualLayout)) {
                    virtualLayout.onMeasure((VirtualLayout) constraintWidget, makeMeasureSpec, makeMeasureSpec2);
                } else {
                    virtualLayout.measure(makeMeasureSpec, makeMeasureSpec2);
                }
                constraintWidget.setLastMeasureSpec(makeMeasureSpec, makeMeasureSpec2);
                int measuredWidth = virtualLayout.getMeasuredWidth();
                int measuredHeight = virtualLayout.getMeasuredHeight();
                baseline = virtualLayout.getBaseline();
                int i13 = constraintWidget.mMatchConstraintMinWidth;
                max = i13 > 0 ? Math.max(i13, measuredWidth) : measuredWidth;
                int i14 = constraintWidget.mMatchConstraintMaxWidth;
                if (i14 > 0) {
                    max = Math.min(i14, max);
                }
                int i15 = constraintWidget.mMatchConstraintMinHeight;
                if (i15 > 0) {
                    i2 = Math.max(i15, measuredHeight);
                    i = makeMeasureSpec;
                } else {
                    i = makeMeasureSpec;
                    i2 = measuredHeight;
                }
                int i16 = constraintWidget.mMatchConstraintMaxHeight;
                if (i16 > 0) {
                    i2 = Math.min(i16, i2);
                }
                if (!Optimizer.enabled(ConstraintLayout.this.mOptimizationLevel, 1)) {
                    if (z7 && z5) {
                        max = (int) ((i2 * constraintWidget.mDimensionRatio) + 0.5f);
                    } else if (z8 && z6) {
                        i2 = (int) ((max / constraintWidget.mDimensionRatio) + 0.5f);
                    }
                }
                if (measuredWidth != max || measuredHeight != i2) {
                    int makeMeasureSpec3 = measuredWidth != max ? View.MeasureSpec.makeMeasureSpec(max, BasicMeasure.EXACTLY) : i;
                    if (measuredHeight != i2) {
                        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, BasicMeasure.EXACTLY);
                    }
                    virtualLayout.measure(makeMeasureSpec3, makeMeasureSpec2);
                    constraintWidget.setLastMeasureSpec(makeMeasureSpec3, makeMeasureSpec2);
                    max = virtualLayout.getMeasuredWidth();
                    i2 = virtualLayout.getMeasuredHeight();
                    baseline = virtualLayout.getBaseline();
                }
                i3 = -1;
            }
            boolean z9 = baseline != i3;
            measure.measuredNeedsSolverPass = (max == measure.horizontalDimension && i2 == measure.verticalDimension) ? false : true;
            if (layoutParams.needsBaseline) {
                z9 = true;
            }
            if (z9 && baseline != -1 && constraintWidget.getBaselineDistance() != baseline) {
                measure.measuredNeedsSolverPass = true;
            }
            measure.measuredWidth = max;
            measure.measuredHeight = i2;
            measure.measuredHasBaseline = z9;
            measure.measuredBaseline = baseline;
        }
    }

    public ConstraintLayout(@NonNull Context context) {
        super(context);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(null, 0, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Build.VERSION.SDK_INT >= 17 ? Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart()) : 0;
        return max2 > 0 ? max2 : max;
    }

    public static SharedValues getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new SharedValues();
        }
        return sSharedValues;
    }

    private final ConstraintWidget getTargetWidget(int i) {
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return view.getLayoutParams().widget;
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout, i, i2);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R$styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R$styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i));
            if (viewWidget != null) {
                viewWidget.reset();
            }
        }
        if (isInEditMode) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).setDebugName(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.applyToInternal(this, true);
        }
        this.mLayoutWidget.removeAllChildren();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i4 = 0; i4 < size; i4++) {
                this.mConstraintHelpers.get(i4).updatePreLayout(this);
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            Placeholder childAt3 = getChildAt(i5);
            if (childAt3 instanceof Placeholder) {
                childAt3.updatePreLayout(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt4 = getChildAt(i6);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt5 = getChildAt(i7);
            ConstraintWidget viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                this.mLayoutWidget.add(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, layoutParams, this.mTempMapIdToWidget);
            }
        }
    }

    private void setWidgetBaseline(ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray, int i, ConstraintAnchor$Type constraintAnchor$Type) {
        View view = this.mChildrenByIds.get(i);
        ConstraintWidget constraintWidget2 = sparseArray.get(i);
        if (constraintWidget2 == null || view == null || !(view.getLayoutParams() instanceof LayoutParams)) {
            return;
        }
        layoutParams.needsBaseline = true;
        ConstraintAnchor$Type constraintAnchor$Type2 = ConstraintAnchor$Type.BASELINE;
        if (constraintAnchor$Type == constraintAnchor$Type2) {
            LayoutParams layoutParams2 = view.getLayoutParams();
            layoutParams2.needsBaseline = true;
            layoutParams2.widget.setHasBaseline(true);
        }
        constraintWidget.getAnchor(constraintAnchor$Type2).connect(constraintWidget2.getAnchor(constraintAnchor$Type), layoutParams.baselineMargin, layoutParams.goneBaselineMargin, true);
        constraintWidget.setHasBaseline(true);
        constraintWidget.getAnchor(ConstraintAnchor$Type.TOP).reset();
        constraintWidget.getAnchor(ConstraintAnchor$Type.BOTTOM).reset();
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            setChildrenConstraints();
        }
        return z;
    }

    protected void applyConstraintsFromLayoutParams(boolean z, View view, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int i;
        float f;
        int i2;
        int i3;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        int i4;
        layoutParams.validate();
        layoutParams.helped = false;
        constraintWidget.setVisibility(view.getVisibility());
        if (layoutParams.isInPlaceholder) {
            constraintWidget.setInPlaceholder(true);
            constraintWidget.setVisibility(8);
        }
        constraintWidget.setCompanionWidget(view);
        if (view instanceof ConstraintHelper) {
            ((ConstraintHelper) view).resolveRtl(constraintWidget, this.mLayoutWidget.isRtl());
        }
        if (layoutParams.isGuideline) {
            androidx.constraintlayout.core.widgets.Guideline guideline = (androidx.constraintlayout.core.widgets.Guideline) constraintWidget;
            int i5 = layoutParams.resolvedGuideBegin;
            int i6 = layoutParams.resolvedGuideEnd;
            float f2 = layoutParams.resolvedGuidePercent;
            if (Build.VERSION.SDK_INT < 17) {
                i5 = layoutParams.guideBegin;
                i6 = layoutParams.guideEnd;
                f2 = layoutParams.guidePercent;
            }
            if (f2 != -1.0f) {
                guideline.setGuidePercent(f2);
                return;
            } else if (i5 != -1) {
                guideline.setGuideBegin(i5);
                return;
            } else {
                if (i6 != -1) {
                    guideline.setGuideEnd(i6);
                    return;
                }
                return;
            }
        }
        int i7 = layoutParams.resolvedLeftToLeft;
        int i8 = layoutParams.resolvedLeftToRight;
        int i9 = layoutParams.resolvedRightToLeft;
        int i10 = layoutParams.resolvedRightToRight;
        int i11 = layoutParams.resolveGoneLeftMargin;
        int i12 = layoutParams.resolveGoneRightMargin;
        float f3 = layoutParams.resolvedHorizontalBias;
        if (Build.VERSION.SDK_INT < 17) {
            i7 = layoutParams.leftToLeft;
            int i13 = layoutParams.leftToRight;
            int i14 = layoutParams.rightToLeft;
            int i15 = layoutParams.rightToRight;
            int i16 = layoutParams.goneLeftMargin;
            int i17 = layoutParams.goneRightMargin;
            float f4 = layoutParams.horizontalBias;
            if (i7 == -1 && i13 == -1) {
                int i18 = layoutParams.startToStart;
                if (i18 != -1) {
                    i7 = i18;
                } else {
                    int i19 = layoutParams.startToEnd;
                    if (i19 != -1) {
                        i13 = i19;
                    }
                }
            }
            if (i14 == -1 && i15 == -1) {
                i2 = layoutParams.endToStart;
                if (i2 == -1) {
                    int i20 = layoutParams.endToEnd;
                    if (i20 != -1) {
                        i = i17;
                        f = f4;
                        i11 = i16;
                        i3 = i20;
                        i8 = i13;
                        i2 = i14;
                    }
                }
                i = i17;
                f = f4;
                i11 = i16;
                i3 = i15;
                i8 = i13;
            }
            i2 = i14;
            i = i17;
            f = f4;
            i11 = i16;
            i3 = i15;
            i8 = i13;
        } else {
            i = i12;
            f = f3;
            i2 = i9;
            i3 = i10;
        }
        int i21 = layoutParams.circleConstraint;
        if (i21 != -1) {
            ConstraintWidget constraintWidget6 = sparseArray.get(i21);
            if (constraintWidget6 != null) {
                constraintWidget.connectCircularConstraint(constraintWidget6, layoutParams.circleAngle, layoutParams.circleRadius);
            }
        } else {
            if (i7 != -1) {
                ConstraintWidget constraintWidget7 = sparseArray.get(i7);
                if (constraintWidget7 != null) {
                    ConstraintAnchor$Type constraintAnchor$Type = ConstraintAnchor$Type.LEFT;
                    constraintWidget.immediateConnect(constraintAnchor$Type, constraintWidget7, constraintAnchor$Type, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i11);
                }
            } else if (i8 != -1 && (constraintWidget2 = sparseArray.get(i8)) != null) {
                constraintWidget.immediateConnect(ConstraintAnchor$Type.LEFT, constraintWidget2, ConstraintAnchor$Type.RIGHT, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i11);
            }
            if (i2 != -1) {
                ConstraintWidget constraintWidget8 = sparseArray.get(i2);
                if (constraintWidget8 != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor$Type.RIGHT, constraintWidget8, ConstraintAnchor$Type.LEFT, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i);
                }
            } else if (i3 != -1 && (constraintWidget3 = sparseArray.get(i3)) != null) {
                ConstraintAnchor$Type constraintAnchor$Type2 = ConstraintAnchor$Type.RIGHT;
                constraintWidget.immediateConnect(constraintAnchor$Type2, constraintWidget3, constraintAnchor$Type2, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i);
            }
            int i22 = layoutParams.topToTop;
            if (i22 != -1) {
                ConstraintWidget constraintWidget9 = sparseArray.get(i22);
                if (constraintWidget9 != null) {
                    ConstraintAnchor$Type constraintAnchor$Type3 = ConstraintAnchor$Type.TOP;
                    constraintWidget.immediateConnect(constraintAnchor$Type3, constraintWidget9, constraintAnchor$Type3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin);
                }
            } else {
                int i23 = layoutParams.topToBottom;
                if (i23 != -1 && (constraintWidget4 = sparseArray.get(i23)) != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor$Type.TOP, constraintWidget4, ConstraintAnchor$Type.BOTTOM, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin);
                }
            }
            int i24 = layoutParams.bottomToTop;
            if (i24 != -1) {
                ConstraintWidget constraintWidget10 = sparseArray.get(i24);
                if (constraintWidget10 != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor$Type.BOTTOM, constraintWidget10, ConstraintAnchor$Type.TOP, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin);
                }
            } else {
                int i25 = layoutParams.bottomToBottom;
                if (i25 != -1 && (constraintWidget5 = sparseArray.get(i25)) != null) {
                    ConstraintAnchor$Type constraintAnchor$Type4 = ConstraintAnchor$Type.BOTTOM;
                    constraintWidget.immediateConnect(constraintAnchor$Type4, constraintWidget5, constraintAnchor$Type4, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin);
                }
            }
            int i26 = layoutParams.baselineToBaseline;
            if (i26 != -1) {
                setWidgetBaseline(constraintWidget, layoutParams, sparseArray, i26, ConstraintAnchor$Type.BASELINE);
            } else {
                int i27 = layoutParams.baselineToTop;
                if (i27 != -1) {
                    setWidgetBaseline(constraintWidget, layoutParams, sparseArray, i27, ConstraintAnchor$Type.TOP);
                } else {
                    int i28 = layoutParams.baselineToBottom;
                    if (i28 != -1) {
                        setWidgetBaseline(constraintWidget, layoutParams, sparseArray, i28, ConstraintAnchor$Type.BOTTOM);
                    }
                }
            }
            if (f >= 0.0f) {
                constraintWidget.setHorizontalBiasPercent(f);
            }
            float f5 = layoutParams.verticalBias;
            if (f5 >= 0.0f) {
                constraintWidget.setVerticalBiasPercent(f5);
            }
        }
        if (z && ((i4 = layoutParams.editorAbsoluteX) != -1 || layoutParams.editorAbsoluteY != -1)) {
            constraintWidget.setOrigin(i4, layoutParams.editorAbsoluteY);
        }
        if (layoutParams.horizontalDimensionFixed) {
            constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.FIXED);
            constraintWidget.setWidth(((ViewGroup.MarginLayoutParams) layoutParams).width);
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
            if (layoutParams.constrainedWidth) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT);
            } else {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.MATCH_PARENT);
            }
            constraintWidget.getAnchor(ConstraintAnchor$Type.LEFT).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            constraintWidget.getAnchor(ConstraintAnchor$Type.RIGHT).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        } else {
            constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT);
            constraintWidget.setWidth(0);
        }
        if (layoutParams.verticalDimensionFixed) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.FIXED);
            constraintWidget.setHeight(((ViewGroup.MarginLayoutParams) layoutParams).height);
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
            if (layoutParams.constrainedHeight) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT);
            } else {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.MATCH_PARENT);
            }
            constraintWidget.getAnchor(ConstraintAnchor$Type.TOP).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            constraintWidget.getAnchor(ConstraintAnchor$Type.BOTTOM).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        } else {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT);
            constraintWidget.setHeight(0);
        }
        constraintWidget.setDimensionRatio(layoutParams.dimensionRatio);
        constraintWidget.setHorizontalWeight(layoutParams.horizontalWeight);
        constraintWidget.setVerticalWeight(layoutParams.verticalWeight);
        constraintWidget.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
        constraintWidget.setVerticalChainStyle(layoutParams.verticalChainStyle);
        constraintWidget.setWrapBehaviorInParent(layoutParams.wrapBehaviorInParent);
        constraintWidget.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
        constraintWidget.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.mConstraintHelpers.get(i).updatePreDraw(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((parseInt / 1080.0f) * width);
                        int i4 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i3;
                        float f2 = i4;
                        float f3 = i3 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float parseInt4 = i4 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f3, f2, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (((ConstraintWidget) this.mLayoutWidget).stringId == null) {
            int id2 = getId();
            if (id2 != -1) {
                ((ConstraintWidget) this.mLayoutWidget).stringId = getContext().getResources().getResourceEntryName(id2);
            } else {
                ((ConstraintWidget) this.mLayoutWidget).stringId = "parent";
            }
        }
        if (this.mLayoutWidget.getDebugName() == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
            constraintWidgetContainer.setDebugName(((ConstraintWidget) constraintWidgetContainer).stringId);
            Log.v(TAG, " setDebugName " + this.mLayoutWidget.getDebugName());
        }
        Iterator<ConstraintWidget> it = this.mLayoutWidget.getChildren().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            View view = (View) next.getCompanionWidget();
            if (view != null) {
                if (next.stringId == null && (id = view.getId()) != -1) {
                    next.stringId = getContext().getResources().getResourceEntryName(id);
                }
                if (next.getDebugName() == null) {
                    next.setDebugName(next.stringId);
                    Log.v(TAG, " setDebugName " + next.getDebugName());
                }
            }
        }
        this.mLayoutWidget.getSceneString(sb);
        return sb.toString();
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof LayoutParams) {
            return view.getLayoutParams().widget;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof LayoutParams) {
            return view.getLayoutParams().widget;
        }
        return null;
    }

    protected boolean isRtl() {
        if (Build.VERSION.SDK_INT >= 17) {
            return ((getContext().getApplicationInfo().flags & AccessibilityEventCompat.TYPE_WINDOWS_CHANGED) != 0) && 1 == getLayoutDirection();
        }
        return false;
    }

    public void loadLayoutDescription(int i) {
        if (i == 0) {
            this.mConstraintLayoutSpec = null;
            return;
        }
        try {
            this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
        } catch (Resources.NotFoundException unused) {
            this.mConstraintLayoutSpec = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            Placeholder childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if ((childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || layoutParams.isVirtualGroup || isInEditMode) && !layoutParams.isInPlaceholder) {
                int x = constraintWidget.getX();
                int y = constraintWidget.getY();
                int width = constraintWidget.getWidth() + x;
                int height = constraintWidget.getHeight() + y;
                childAt.layout(x, y, width, height);
                if ((childAt instanceof Placeholder) && (content = childAt.getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(x, y, width, height);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).updatePostLayout(this);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mOnMeasureWidthMeasureSpec == i) {
            int i3 = this.mOnMeasureHeightMeasureSpec;
        }
        if (!this.mDirtyHierarchy) {
            int childCount = getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                if (getChildAt(i4).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                }
                i4++;
            }
        }
        boolean z = this.mDirtyHierarchy;
        this.mOnMeasureWidthMeasureSpec = i;
        this.mOnMeasureHeightMeasureSpec = i2;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.updateHierarchy();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i, i2);
        resolveMeasuredDimension(i, i2, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof androidx.constraintlayout.core.widgets.Guideline)) {
            LayoutParams layoutParams = view.getLayoutParams();
            androidx.constraintlayout.core.widgets.Guideline guideline = new androidx.constraintlayout.core.widgets.Guideline();
            layoutParams.widget = guideline;
            layoutParams.isGuideline = true;
            guideline.setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            view.getLayoutParams().isHelper = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.remove(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    protected void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    protected void resolveMeasuredDimension(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Measurer measurer = this.mMeasurer;
        int i5 = measurer.paddingHeight;
        int resolveSizeAndState = ViewGroup.resolveSizeAndState(i3 + measurer.paddingWidth, i, 0);
        int resolveSizeAndState2 = ViewGroup.resolveSizeAndState(i4 + i5, i2, 0);
        int i6 = resolveSizeAndState & ViewCompat.MEASURED_SIZE_MASK;
        int i7 = resolveSizeAndState2 & ViewCompat.MEASURED_SIZE_MASK;
        int min = Math.min(this.mMaxWidth, i6);
        int min2 = Math.min(this.mMaxHeight, i7);
        if (z) {
            min |= 16777216;
        }
        if (z2) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    protected void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3) {
        int max;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int max2 = Math.max(0, getPaddingTop());
        int max3 = Math.max(0, getPaddingBottom());
        int i4 = max2 + max3;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.captureLayoutInfo(i2, i3, max2, max3, paddingWidth, i4);
        if (Build.VERSION.SDK_INT >= 17) {
            int max4 = Math.max(0, getPaddingStart());
            int max5 = Math.max(0, getPaddingEnd());
            if (max4 <= 0 && max5 <= 0) {
                max4 = Math.max(0, getPaddingLeft());
            } else if (isRtl()) {
                max4 = max5;
            }
            max = max4;
        } else {
            max = Math.max(0, getPaddingLeft());
        }
        int i5 = size - paddingWidth;
        int i6 = size2 - i4;
        setSelfDimensionBehaviour(constraintWidgetContainer, mode, i5, mode2, i6);
        constraintWidgetContainer.measure(i, mode, i5, mode2, i6, this.mLastMeasureWidth, this.mLastMeasureHeight, max, max2);
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    @Override // android.view.View
    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.setOnConstraintsChanged(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        this.mLayoutWidget.setOptimizationLevel(i);
    }

    protected void setSelfDimensionBehaviour(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3, int i4) {
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        Measurer measurer = this.mMeasurer;
        int i5 = measurer.paddingHeight;
        int i6 = measurer.paddingWidth;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i == Integer.MIN_VALUE) {
            constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i2 = Math.max(0, this.mMinWidth);
            }
        } else if (i == 0) {
            constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i2 = Math.max(0, this.mMinWidth);
            }
            i2 = 0;
        } else if (i != 1073741824) {
            constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviour2;
            i2 = 0;
        } else {
            i2 = Math.min(this.mMaxWidth - i6, i2);
            constraintWidget$DimensionBehaviour = constraintWidget$DimensionBehaviour2;
        }
        if (i3 == Integer.MIN_VALUE) {
            constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i4 = Math.max(0, this.mMinHeight);
            }
        } else if (i3 != 0) {
            if (i3 == 1073741824) {
                i4 = Math.min(this.mMaxHeight - i5, i4);
            }
            i4 = 0;
        } else {
            constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i4 = Math.max(0, this.mMinHeight);
            }
            i4 = 0;
        }
        if (i2 != constraintWidgetContainer.getWidth() || i4 != constraintWidgetContainer.getHeight()) {
            constraintWidgetContainer.invalidateMeasures();
        }
        constraintWidgetContainer.setX(0);
        constraintWidgetContainer.setY(0);
        constraintWidgetContainer.setMaxWidth(this.mMaxWidth - i6);
        constraintWidgetContainer.setMaxHeight(this.mMaxHeight - i5);
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setHorizontalDimensionBehaviour(constraintWidget$DimensionBehaviour);
        constraintWidgetContainer.setWidth(i2);
        constraintWidgetContainer.setVerticalDimensionBehaviour(constraintWidget$DimensionBehaviour2);
        constraintWidgetContainer.setHeight(i4);
        constraintWidgetContainer.setMinWidth(this.mMinWidth - i6);
        constraintWidgetContainer.setMinHeight(this.mMinHeight - i5);
    }

    public void setState(int i, int i2, int i3) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i, i2);
    }
}
