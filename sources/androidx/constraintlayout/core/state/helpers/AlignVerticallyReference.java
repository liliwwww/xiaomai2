package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class AlignVerticallyReference extends HelperReference {
    private float mBias;

    public AlignVerticallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void apply() {
        Iterator it = ((HelperReference) this).mReferences.iterator();
        while (it.hasNext()) {
            ConstraintReference constraints = ((HelperReference) this).mState.constraints(it.next());
            constraints.clearVertical();
            Object obj = ((ConstraintReference) this).mTopToTop;
            if (obj != null) {
                constraints.topToTop(obj);
            } else {
                Object obj2 = ((ConstraintReference) this).mTopToBottom;
                if (obj2 != null) {
                    constraints.topToBottom(obj2);
                } else {
                    constraints.topToTop(State.PARENT);
                }
            }
            Object obj3 = ((ConstraintReference) this).mBottomToTop;
            if (obj3 != null) {
                constraints.bottomToTop(obj3);
            } else {
                Object obj4 = ((ConstraintReference) this).mBottomToBottom;
                if (obj4 != null) {
                    constraints.bottomToBottom(obj4);
                } else {
                    constraints.bottomToBottom(State.PARENT);
                }
            }
            float f = this.mBias;
            if (f != 0.5f) {
                constraints.verticalBias(f);
            }
        }
    }
}
