package androidx.constraintlayout.core;

import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class PriorityGoalRow$1 implements Comparator<SolverVariable> {
    final /* synthetic */ PriorityGoalRow this$0;

    PriorityGoalRow$1(PriorityGoalRow priorityGoalRow) {
        this.this$0 = priorityGoalRow;
    }

    @Override // java.util.Comparator
    public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
        return solverVariable.id - solverVariable2.id;
    }
}
