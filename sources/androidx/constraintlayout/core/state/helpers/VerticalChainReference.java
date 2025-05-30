package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class VerticalChainReference extends ChainReference {
    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void apply() {
        Iterator<Object> it = ((HelperReference) this).mReferences.iterator();
        while (it.hasNext()) {
            ((HelperReference) this).mState.constraints(it.next()).clearVertical();
        }
        Iterator<Object> it2 = ((HelperReference) this).mReferences.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it2.hasNext()) {
            ConstraintReference constraints = ((HelperReference) this).mState.constraints(it2.next());
            if (constraintReference2 == null) {
                Object obj = ((ConstraintReference) this).mTopToTop;
                if (obj != null) {
                    constraints.topToTop(obj).margin(((ConstraintReference) this).mMarginTop).marginGone(((ConstraintReference) this).mMarginTopGone);
                } else {
                    Object obj2 = ((ConstraintReference) this).mTopToBottom;
                    if (obj2 != null) {
                        constraints.topToBottom(obj2).margin(((ConstraintReference) this).mMarginTop).marginGone(((ConstraintReference) this).mMarginTopGone);
                    } else {
                        constraints.topToTop(State.PARENT);
                    }
                }
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                constraintReference.bottomToTop(constraints.getKey());
                constraints.topToBottom(constraintReference.getKey());
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            Object obj3 = ((ConstraintReference) this).mBottomToTop;
            if (obj3 != null) {
                constraintReference.bottomToTop(obj3).margin(((ConstraintReference) this).mMarginBottom).marginGone(((ConstraintReference) this).mMarginBottomGone);
            } else {
                Object obj4 = ((ConstraintReference) this).mBottomToBottom;
                if (obj4 != null) {
                    constraintReference.bottomToBottom(obj4).margin(((ConstraintReference) this).mMarginBottom).marginGone(((ConstraintReference) this).mMarginBottomGone);
                } else {
                    constraintReference.bottomToBottom(State.PARENT);
                }
            }
        }
        if (constraintReference2 == null) {
            return;
        }
        float f = ((ChainReference) this).mBias;
        if (f != 0.5f) {
            constraintReference2.verticalBias(f);
        }
        int i = 1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[((ChainReference) this).mStyle.ordinal()];
        if (i == 1) {
            constraintReference2.setVerticalChainStyle(0);
        } else if (i == 2) {
            constraintReference2.setVerticalChainStyle(1);
        } else {
            if (i != 3) {
                return;
            }
            constraintReference2.setVerticalChainStyle(2);
        }
    }
}
