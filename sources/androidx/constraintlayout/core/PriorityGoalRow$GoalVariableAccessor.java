package androidx.constraintlayout.core;

import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class PriorityGoalRow$GoalVariableAccessor {
    PriorityGoalRow row;
    final /* synthetic */ PriorityGoalRow this$0;
    SolverVariable variable;

    public PriorityGoalRow$GoalVariableAccessor(PriorityGoalRow priorityGoalRow, PriorityGoalRow priorityGoalRow2) {
        this.this$0 = priorityGoalRow;
        this.row = priorityGoalRow2;
    }

    public void add(SolverVariable solverVariable) {
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.variable.goalStrengthVector;
            fArr[i] = fArr[i] + solverVariable.goalStrengthVector[i];
            if (Math.abs(fArr[i]) < 1.0E-4f) {
                this.variable.goalStrengthVector[i] = 0.0f;
            }
        }
    }

    public boolean addToGoal(SolverVariable solverVariable, float f) {
        boolean z = true;
        if (!this.variable.inGoal) {
            for (int i = 0; i < 9; i++) {
                float f2 = solverVariable.goalStrengthVector[i];
                if (f2 != 0.0f) {
                    float f3 = f2 * f;
                    if (Math.abs(f3) < 1.0E-4f) {
                        f3 = 0.0f;
                    }
                    this.variable.goalStrengthVector[i] = f3;
                } else {
                    this.variable.goalStrengthVector[i] = 0.0f;
                }
            }
            return true;
        }
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.variable.goalStrengthVector;
            fArr[i2] = fArr[i2] + (solverVariable.goalStrengthVector[i2] * f);
            if (Math.abs(fArr[i2]) < 1.0E-4f) {
                this.variable.goalStrengthVector[i2] = 0.0f;
            } else {
                z = false;
            }
        }
        if (z) {
            PriorityGoalRow.access$000(this.this$0, this.variable);
        }
        return false;
    }

    public void init(SolverVariable solverVariable) {
        this.variable = solverVariable;
    }

    public final boolean isNegative() {
        for (int i = 8; i >= 0; i--) {
            float f = this.variable.goalStrengthVector[i];
            if (f > 0.0f) {
                return false;
            }
            if (f < 0.0f) {
                return true;
            }
        }
        return false;
    }

    public final boolean isNull() {
        for (int i = 0; i < 9; i++) {
            if (this.variable.goalStrengthVector[i] != 0.0f) {
                return false;
            }
        }
        return true;
    }

    public final boolean isSmallerThan(SolverVariable solverVariable) {
        int i = 8;
        while (true) {
            if (i < 0) {
                break;
            }
            float f = solverVariable.goalStrengthVector[i];
            float f2 = this.variable.goalStrengthVector[i];
            if (f2 == f) {
                i--;
            } else if (f2 < f) {
                return true;
            }
        }
        return false;
    }

    public void reset() {
        Arrays.fill(this.variable.goalStrengthVector, 0.0f);
    }

    public String toString() {
        String str = "[ ";
        if (this.variable != null) {
            for (int i = 0; i < 9; i++) {
                str = str + this.variable.goalStrengthVector[i] + " ";
            }
        }
        return str + "] " + this.variable;
    }
}
