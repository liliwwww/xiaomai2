package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
/* synthetic */ class State$1 {
    static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Helper;

    static {
        int[] iArr = new int[State.Helper.values().length];
        $SwitchMap$androidx$constraintlayout$core$state$State$Helper = iArr;
        try {
            iArr[State.Helper.HORIZONTAL_CHAIN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper[State.Helper.VERTICAL_CHAIN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper[State.Helper.ALIGN_HORIZONTALLY.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper[State.Helper.ALIGN_VERTICALLY.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$core$state$State$Helper[State.Helper.BARRIER.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
