package androidx.compose.p004ui.input.pointer.util;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
final class Matrix {

    @NotNull
    private final Vector[] elements;

    public Matrix(int i, int i2) {
        Vector[] vectorArr = new Vector[i];
        for (int i3 = 0; i3 < i; i3++) {
            vectorArr[i3] = new Vector(i2);
        }
        this.elements = vectorArr;
    }

    public final float get(int i, int i2) {
        return this.elements[i].get(i2);
    }

    @NotNull
    public final Vector getRow(int i) {
        return this.elements[i];
    }

    public final void set(int i, int i2, float f) {
        this.elements[i].set(i2, f);
    }
}
