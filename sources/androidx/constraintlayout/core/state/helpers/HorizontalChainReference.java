package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.State$Chain;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class HorizontalChainReference extends ChainReference {

    /* compiled from: Taobao */
    /* renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Chain;

        static {
            int[] iArr = new int[State$Chain.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain = iArr;
            try {
                iArr[State$Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State$Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State$Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void apply() {
        Iterator it = ((HelperReference) this).mReferences.iterator();
        while (it.hasNext()) {
            ((HelperReference) this).mState.constraints(it.next()).clearHorizontal();
        }
        Iterator it2 = ((HelperReference) this).mReferences.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it2.hasNext()) {
            ConstraintReference constraints = ((HelperReference) this).mState.constraints(it2.next());
            if (constraintReference2 == null) {
                Object obj = ((ConstraintReference) this).mStartToStart;
                if (obj != null) {
                    constraints.startToStart(obj).margin(((ConstraintReference) this).mMarginStart).marginGone(((ConstraintReference) this).mMarginStartGone);
                } else {
                    Object obj2 = ((ConstraintReference) this).mStartToEnd;
                    if (obj2 != null) {
                        constraints.startToEnd(obj2).margin(((ConstraintReference) this).mMarginStart).marginGone(((ConstraintReference) this).mMarginStartGone);
                    } else {
                        Object obj3 = ((ConstraintReference) this).mLeftToLeft;
                        if (obj3 != null) {
                            constraints.startToStart(obj3).margin(((ConstraintReference) this).mMarginLeft).marginGone(((ConstraintReference) this).mMarginLeftGone);
                        } else {
                            Object obj4 = ((ConstraintReference) this).mLeftToRight;
                            if (obj4 != null) {
                                constraints.startToEnd(obj4).margin(((ConstraintReference) this).mMarginLeft).marginGone(((ConstraintReference) this).mMarginLeftGone);
                            } else {
                                constraints.startToStart(State.PARENT);
                            }
                        }
                    }
                }
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                constraintReference.endToStart(constraints.getKey());
                constraints.startToEnd(constraintReference.getKey());
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            Object obj5 = ((ConstraintReference) this).mEndToStart;
            if (obj5 != null) {
                constraintReference.endToStart(obj5).margin(((ConstraintReference) this).mMarginEnd).marginGone(((ConstraintReference) this).mMarginEndGone);
            } else {
                Object obj6 = ((ConstraintReference) this).mEndToEnd;
                if (obj6 != null) {
                    constraintReference.endToEnd(obj6).margin(((ConstraintReference) this).mMarginEnd).marginGone(((ConstraintReference) this).mMarginEndGone);
                } else {
                    Object obj7 = ((ConstraintReference) this).mRightToLeft;
                    if (obj7 != null) {
                        constraintReference.endToStart(obj7).margin(((ConstraintReference) this).mMarginRight).marginGone(((ConstraintReference) this).mMarginRightGone);
                    } else {
                        Object obj8 = ((ConstraintReference) this).mRightToRight;
                        if (obj8 != null) {
                            constraintReference.endToEnd(obj8).margin(((ConstraintReference) this).mMarginRight).marginGone(((ConstraintReference) this).mMarginRightGone);
                        } else {
                            constraintReference.endToEnd(State.PARENT);
                        }
                    }
                }
            }
        }
        if (constraintReference2 == null) {
            return;
        }
        float f = this.mBias;
        if (f != 0.5f) {
            constraintReference2.horizontalBias(f);
        }
        int i = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (i == 1) {
            constraintReference2.setHorizontalChainStyle(0);
        } else if (i == 2) {
            constraintReference2.setHorizontalChainStyle(1);
        } else {
            if (i != 3) {
                return;
            }
            constraintReference2.setHorizontalChainStyle(2);
        }
    }
}
