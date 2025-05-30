package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.State$Chain;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
/* synthetic */ class VerticalChainReference$1 {
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
