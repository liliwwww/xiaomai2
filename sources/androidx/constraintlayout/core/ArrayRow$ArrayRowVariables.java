package androidx.constraintlayout.core;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface ArrayRow$ArrayRowVariables {
    void add(SolverVariable solverVariable, float f, boolean z);

    void clear();

    boolean contains(SolverVariable solverVariable);

    void display();

    void divideByAmount(float f);

    float get(SolverVariable solverVariable);

    int getCurrentSize();

    SolverVariable getVariable(int i);

    float getVariableValue(int i);

    int indexOf(SolverVariable solverVariable);

    void invert();

    void put(SolverVariable solverVariable, float f);

    float remove(SolverVariable solverVariable, boolean z);

    int sizeInBytes();

    float use(ArrayRow arrayRow, boolean z);
}
