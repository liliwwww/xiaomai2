package androidx.compose.ui.input.pointer.util;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class Vector {

    @NotNull
    private final Float[] elements;
    private final int length;

    public Vector(int i) {
        this.length = i;
        Float[] fArr = new Float[i];
        for (int i2 = 0; i2 < i; i2++) {
            fArr[i2] = Float.valueOf(0.0f);
        }
        this.elements = fArr;
    }

    public final float get(int i) {
        return this.elements[i].floatValue();
    }

    @NotNull
    public final Float[] getElements() {
        return this.elements;
    }

    public final int getLength() {
        return this.length;
    }

    public final float norm() {
        return (float) Math.sqrt(times(this));
    }

    public final void set(int i, float f) {
        this.elements[i] = Float.valueOf(f);
    }

    public final float times(@NotNull Vector vector) {
        Intrinsics.checkNotNullParameter(vector, "a");
        int i = this.length;
        float f = 0.0f;
        for (int i2 = 0; i2 < i; i2++) {
            f += get(i2) * vector.get(i2);
        }
        return f;
    }
}
