package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class Flow$WidgetsList {
    private ConstraintAnchor mBottom;
    private ConstraintAnchor mLeft;
    private int mMax;
    private int mOrientation;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private ConstraintAnchor mRight;
    private ConstraintAnchor mTop;
    final /* synthetic */ Flow this$0;
    private ConstraintWidget biggest = null;
    int biggestDimension = 0;
    private int mWidth = 0;
    private int mHeight = 0;
    private int mStartIndex = 0;
    private int mCount = 0;
    private int mNbMatchConstraintsWidgets = 0;

    public Flow$WidgetsList(Flow flow, int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2) {
        this.this$0 = flow;
        this.mOrientation = 0;
        this.mPaddingLeft = 0;
        this.mPaddingTop = 0;
        this.mPaddingRight = 0;
        this.mPaddingBottom = 0;
        this.mMax = 0;
        this.mOrientation = i;
        this.mLeft = constraintAnchor;
        this.mTop = constraintAnchor2;
        this.mRight = constraintAnchor3;
        this.mBottom = constraintAnchor4;
        this.mPaddingLeft = flow.getPaddingLeft();
        this.mPaddingTop = flow.getPaddingTop();
        this.mPaddingRight = flow.getPaddingRight();
        this.mPaddingBottom = flow.getPaddingBottom();
        this.mMax = i2;
    }

    private void recomputeDimensions() {
        this.mWidth = 0;
        this.mHeight = 0;
        this.biggest = null;
        this.biggestDimension = 0;
        int i = this.mCount;
        for (int i2 = 0; i2 < i && this.mStartIndex + i2 < Flow.access$400(this.this$0); i2++) {
            ConstraintWidget constraintWidget = Flow.access$500(this.this$0)[this.mStartIndex + i2];
            if (this.mOrientation == 0) {
                int width = constraintWidget.getWidth();
                int access$000 = Flow.access$000(this.this$0);
                if (constraintWidget.getVisibility() == 8) {
                    access$000 = 0;
                }
                this.mWidth += width + access$000;
                int access$300 = Flow.access$300(this.this$0, constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < access$300) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = access$300;
                    this.mHeight = access$300;
                }
            } else {
                int access$200 = Flow.access$200(this.this$0, constraintWidget, this.mMax);
                int access$3002 = Flow.access$300(this.this$0, constraintWidget, this.mMax);
                int access$100 = Flow.access$100(this.this$0);
                if (constraintWidget.getVisibility() == 8) {
                    access$100 = 0;
                }
                this.mHeight += access$3002 + access$100;
                if (this.biggest == null || this.biggestDimension < access$200) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = access$200;
                    this.mWidth = access$200;
                }
            }
        }
    }

    public void add(ConstraintWidget constraintWidget) {
        if (this.mOrientation == 0) {
            int access$200 = Flow.access$200(this.this$0, constraintWidget, this.mMax);
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.mNbMatchConstraintsWidgets++;
                access$200 = 0;
            }
            this.mWidth += access$200 + (constraintWidget.getVisibility() != 8 ? Flow.access$000(this.this$0) : 0);
            int access$300 = Flow.access$300(this.this$0, constraintWidget, this.mMax);
            if (this.biggest == null || this.biggestDimension < access$300) {
                this.biggest = constraintWidget;
                this.biggestDimension = access$300;
                this.mHeight = access$300;
            }
        } else {
            int access$2002 = Flow.access$200(this.this$0, constraintWidget, this.mMax);
            int access$3002 = Flow.access$300(this.this$0, constraintWidget, this.mMax);
            if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.mNbMatchConstraintsWidgets++;
                access$3002 = 0;
            }
            this.mHeight += access$3002 + (constraintWidget.getVisibility() != 8 ? Flow.access$100(this.this$0) : 0);
            if (this.biggest == null || this.biggestDimension < access$2002) {
                this.biggest = constraintWidget;
                this.biggestDimension = access$2002;
                this.mWidth = access$2002;
            }
        }
        this.mCount++;
    }

    public void clear() {
        this.biggestDimension = 0;
        this.biggest = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mStartIndex = 0;
        this.mCount = 0;
        this.mNbMatchConstraintsWidgets = 0;
    }

    public void createConstraints(boolean z, int i, boolean z2) {
        ConstraintWidget constraintWidget;
        float access$1300;
        float access$13002;
        int i2 = this.mCount;
        for (int i3 = 0; i3 < i2 && this.mStartIndex + i3 < Flow.access$400(this.this$0); i3++) {
            ConstraintWidget constraintWidget2 = Flow.access$500(this.this$0)[this.mStartIndex + i3];
            if (constraintWidget2 != null) {
                constraintWidget2.resetAnchors();
            }
        }
        if (i2 == 0 || this.biggest == null) {
            return;
        }
        boolean z3 = z2 && i == 0;
        int i4 = -1;
        int i5 = -1;
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = z ? (i2 - 1) - i6 : i6;
            if (this.mStartIndex + i7 >= Flow.access$400(this.this$0)) {
                break;
            }
            ConstraintWidget constraintWidget3 = Flow.access$500(this.this$0)[this.mStartIndex + i7];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() == 0) {
                if (i4 == -1) {
                    i4 = i6;
                }
                i5 = i6;
            }
        }
        ConstraintWidget constraintWidget4 = null;
        if (this.mOrientation != 0) {
            ConstraintWidget constraintWidget5 = this.biggest;
            constraintWidget5.setHorizontalChainStyle(Flow.access$800(this.this$0));
            int i8 = this.mPaddingLeft;
            if (i > 0) {
                i8 += Flow.access$000(this.this$0);
            }
            if (z) {
                constraintWidget5.mRight.connect(this.mRight, i8);
                if (z2) {
                    constraintWidget5.mLeft.connect(this.mLeft, this.mPaddingRight);
                }
                if (i > 0) {
                    this.mRight.mOwner.mLeft.connect(constraintWidget5.mRight, 0);
                }
            } else {
                constraintWidget5.mLeft.connect(this.mLeft, i8);
                if (z2) {
                    constraintWidget5.mRight.connect(this.mRight, this.mPaddingRight);
                }
                if (i > 0) {
                    this.mLeft.mOwner.mRight.connect(constraintWidget5.mLeft, 0);
                }
            }
            for (int i9 = 0; i9 < i2 && this.mStartIndex + i9 < Flow.access$400(this.this$0); i9++) {
                ConstraintWidget constraintWidget6 = Flow.access$500(this.this$0)[this.mStartIndex + i9];
                if (constraintWidget6 != null) {
                    if (i9 == 0) {
                        constraintWidget6.connect(constraintWidget6.mTop, this.mTop, this.mPaddingTop);
                        int access$600 = Flow.access$600(this.this$0);
                        float access$1400 = Flow.access$1400(this.this$0);
                        if (this.mStartIndex == 0 && Flow.access$1500(this.this$0) != -1) {
                            access$600 = Flow.access$1500(this.this$0);
                            access$1400 = Flow.access$1600(this.this$0);
                        } else if (z2 && Flow.access$1700(this.this$0) != -1) {
                            access$600 = Flow.access$1700(this.this$0);
                            access$1400 = Flow.access$1800(this.this$0);
                        }
                        constraintWidget6.setVerticalChainStyle(access$600);
                        constraintWidget6.setVerticalBiasPercent(access$1400);
                    }
                    if (i9 == i2 - 1) {
                        constraintWidget6.connect(constraintWidget6.mBottom, this.mBottom, this.mPaddingBottom);
                    }
                    if (constraintWidget4 != null) {
                        constraintWidget6.mTop.connect(constraintWidget4.mBottom, Flow.access$100(this.this$0));
                        if (i9 == i4) {
                            constraintWidget6.mTop.setGoneMargin(this.mPaddingTop);
                        }
                        constraintWidget4.mBottom.connect(constraintWidget6.mTop, 0);
                        if (i9 == i5 + 1) {
                            constraintWidget4.mBottom.setGoneMargin(this.mPaddingBottom);
                        }
                    }
                    if (constraintWidget6 != constraintWidget5) {
                        if (z) {
                            int access$1900 = Flow.access$1900(this.this$0);
                            if (access$1900 == 0) {
                                constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                            } else if (access$1900 == 1) {
                                constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                            } else if (access$1900 == 2) {
                                constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                            }
                        } else {
                            int access$19002 = Flow.access$1900(this.this$0);
                            if (access$19002 == 0) {
                                constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                            } else if (access$19002 == 1) {
                                constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                            } else if (access$19002 == 2) {
                                if (z3) {
                                    constraintWidget6.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                    constraintWidget6.mRight.connect(this.mRight, this.mPaddingRight);
                                } else {
                                    constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                    constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                }
                            }
                            constraintWidget4 = constraintWidget6;
                        }
                    }
                    constraintWidget4 = constraintWidget6;
                }
            }
            return;
        }
        ConstraintWidget constraintWidget7 = this.biggest;
        constraintWidget7.setVerticalChainStyle(Flow.access$600(this.this$0));
        int i10 = this.mPaddingTop;
        if (i > 0) {
            i10 += Flow.access$100(this.this$0);
        }
        constraintWidget7.mTop.connect(this.mTop, i10);
        if (z2) {
            constraintWidget7.mBottom.connect(this.mBottom, this.mPaddingBottom);
        }
        if (i > 0) {
            this.mTop.mOwner.mBottom.connect(constraintWidget7.mTop, 0);
        }
        if (Flow.access$700(this.this$0) == 3 && !constraintWidget7.hasBaseline()) {
            for (int i11 = 0; i11 < i2; i11++) {
                int i12 = z ? (i2 - 1) - i11 : i11;
                if (this.mStartIndex + i12 >= Flow.access$400(this.this$0)) {
                    break;
                }
                constraintWidget = Flow.access$500(this.this$0)[this.mStartIndex + i12];
                if (constraintWidget.hasBaseline()) {
                    break;
                }
            }
        }
        constraintWidget = constraintWidget7;
        int i13 = 0;
        while (i13 < i2) {
            int i14 = z ? (i2 - 1) - i13 : i13;
            if (this.mStartIndex + i14 >= Flow.access$400(this.this$0)) {
                return;
            }
            ConstraintWidget constraintWidget8 = Flow.access$500(this.this$0)[this.mStartIndex + i14];
            if (constraintWidget8 == null) {
                constraintWidget8 = constraintWidget4;
            } else {
                if (i13 == 0) {
                    constraintWidget8.connect(constraintWidget8.mLeft, this.mLeft, this.mPaddingLeft);
                }
                if (i14 == 0) {
                    int access$800 = Flow.access$800(this.this$0);
                    float access$900 = Flow.access$900(this.this$0);
                    if (z) {
                        access$900 = 1.0f - access$900;
                    }
                    if (this.mStartIndex == 0 && Flow.access$1000(this.this$0) != -1) {
                        access$800 = Flow.access$1000(this.this$0);
                        if (z) {
                            access$13002 = Flow.access$1100(this.this$0);
                            access$1300 = 1.0f - access$13002;
                            access$900 = access$1300;
                        } else {
                            access$1300 = Flow.access$1100(this.this$0);
                            access$900 = access$1300;
                        }
                    } else if (z2 && Flow.access$1200(this.this$0) != -1) {
                        access$800 = Flow.access$1200(this.this$0);
                        if (z) {
                            access$13002 = Flow.access$1300(this.this$0);
                            access$1300 = 1.0f - access$13002;
                            access$900 = access$1300;
                        } else {
                            access$1300 = Flow.access$1300(this.this$0);
                            access$900 = access$1300;
                        }
                    }
                    constraintWidget8.setHorizontalChainStyle(access$800);
                    constraintWidget8.setHorizontalBiasPercent(access$900);
                }
                if (i13 == i2 - 1) {
                    constraintWidget8.connect(constraintWidget8.mRight, this.mRight, this.mPaddingRight);
                }
                if (constraintWidget4 != null) {
                    constraintWidget8.mLeft.connect(constraintWidget4.mRight, Flow.access$000(this.this$0));
                    if (i13 == i4) {
                        constraintWidget8.mLeft.setGoneMargin(this.mPaddingLeft);
                    }
                    constraintWidget4.mRight.connect(constraintWidget8.mLeft, 0);
                    if (i13 == i5 + 1) {
                        constraintWidget4.mRight.setGoneMargin(this.mPaddingRight);
                    }
                }
                if (constraintWidget8 != constraintWidget7) {
                    if (Flow.access$700(this.this$0) == 3 && constraintWidget.hasBaseline() && constraintWidget8 != constraintWidget && constraintWidget8.hasBaseline()) {
                        constraintWidget8.mBaseline.connect(constraintWidget.mBaseline, 0);
                    } else {
                        int access$700 = Flow.access$700(this.this$0);
                        if (access$700 == 0) {
                            constraintWidget8.mTop.connect(constraintWidget7.mTop, 0);
                        } else if (access$700 == 1) {
                            constraintWidget8.mBottom.connect(constraintWidget7.mBottom, 0);
                        } else if (z3) {
                            constraintWidget8.mTop.connect(this.mTop, this.mPaddingTop);
                            constraintWidget8.mBottom.connect(this.mBottom, this.mPaddingBottom);
                        } else {
                            constraintWidget8.mTop.connect(constraintWidget7.mTop, 0);
                            constraintWidget8.mBottom.connect(constraintWidget7.mBottom, 0);
                        }
                    }
                    i13++;
                    constraintWidget4 = constraintWidget8;
                }
            }
            i13++;
            constraintWidget4 = constraintWidget8;
        }
    }

    public int getHeight() {
        return this.mOrientation == 1 ? this.mHeight - Flow.access$100(this.this$0) : this.mHeight;
    }

    public int getWidth() {
        return this.mOrientation == 0 ? this.mWidth - Flow.access$000(this.this$0) : this.mWidth;
    }

    public void measureMatchConstraints(int i) {
        int i2 = this.mNbMatchConstraintsWidgets;
        if (i2 == 0) {
            return;
        }
        int i3 = this.mCount;
        int i4 = i / i2;
        for (int i5 = 0; i5 < i3 && this.mStartIndex + i5 < Flow.access$400(this.this$0); i5++) {
            ConstraintWidget constraintWidget = Flow.access$500(this.this$0)[this.mStartIndex + i5];
            if (this.mOrientation == 0) {
                if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                    this.this$0.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i4, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
            } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                this.this$0.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i4);
            }
        }
        recomputeDimensions();
    }

    public void setStartIndex(int i) {
        this.mStartIndex = i;
    }

    public void setup(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2, int i3, int i4, int i5, int i6) {
        this.mOrientation = i;
        this.mLeft = constraintAnchor;
        this.mTop = constraintAnchor2;
        this.mRight = constraintAnchor3;
        this.mBottom = constraintAnchor4;
        this.mPaddingLeft = i2;
        this.mPaddingTop = i3;
        this.mPaddingRight = i4;
        this.mPaddingBottom = i5;
        this.mMax = i6;
    }
}
