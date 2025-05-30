package androidx.constraintlayout.core;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
/* synthetic */ class SolverVariable$1 {
    static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type;

    static {
        int[] iArr = new int[SolverVariable$Type.values().length];
        $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type = iArr;
        try {
            iArr[SolverVariable$Type.UNRESTRICTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[SolverVariable$Type.CONSTANT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[SolverVariable$Type.SLACK.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[SolverVariable$Type.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            $SwitchMap$androidx$constraintlayout$core$SolverVariable$Type[SolverVariable$Type.UNKNOWN.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
