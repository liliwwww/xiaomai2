package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.State$Chain;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ChainReference extends HelperReference {
    protected float mBias;
    protected State$Chain mStyle;

    public ChainReference(State state, State.Helper helper) {
        super(state, helper);
        this.mBias = 0.5f;
        this.mStyle = State$Chain.SPREAD;
    }

    public float getBias() {
        return this.mBias;
    }

    public State$Chain getStyle() {
        return State$Chain.SPREAD;
    }

    public ChainReference style(State$Chain state$Chain) {
        this.mStyle = state$Chain;
        return this;
    }

    public ChainReference bias(float f) {
        this.mBias = f;
        return this;
    }
}
