package androidx.compose.animation.core;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.r40;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ComplexDouble {
    private double _imaginary;
    private double _real;

    public ComplexDouble(double d, double d2) {
        this._real = d;
        this._imaginary = d2;
    }

    private final double component1() {
        return this._real;
    }

    private final double component2() {
        return this._imaginary;
    }

    public static /* synthetic */ ComplexDouble copy$default(ComplexDouble complexDouble, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = complexDouble._real;
        }
        if ((i & 2) != 0) {
            d2 = complexDouble._imaginary;
        }
        return complexDouble.copy(d, d2);
    }

    @NotNull
    public final ComplexDouble copy(double d, double d2) {
        return new ComplexDouble(d, d2);
    }

    @NotNull
    public final ComplexDouble div(double d) {
        this._real /= d;
        this._imaginary /= d;
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComplexDouble)) {
            return false;
        }
        ComplexDouble complexDouble = (ComplexDouble) obj;
        return Intrinsics.areEqual(Double.valueOf(this._real), Double.valueOf(complexDouble._real)) && Intrinsics.areEqual(Double.valueOf(this._imaginary), Double.valueOf(complexDouble._imaginary));
    }

    public final double getImaginary() {
        return this._imaginary;
    }

    public final double getReal() {
        return this._real;
    }

    public int hashCode() {
        return (r40.a(this._real) * 31) + r40.a(this._imaginary);
    }

    @NotNull
    public final ComplexDouble minus(double d) {
        this._real += -d;
        return this;
    }

    @NotNull
    public final ComplexDouble plus(double d) {
        this._real += d;
        return this;
    }

    @NotNull
    public final ComplexDouble times(double d) {
        this._real *= d;
        this._imaginary *= d;
        return this;
    }

    @NotNull
    public String toString() {
        return "ComplexDouble(_real=" + this._real + ", _imaginary=" + this._imaginary + ')';
    }

    @NotNull
    public final ComplexDouble unaryMinus() {
        double d = -1;
        this._real *= d;
        this._imaginary *= d;
        return this;
    }

    @NotNull
    public final ComplexDouble minus(@NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        double d = -1;
        complexDouble._real *= d;
        complexDouble._imaginary *= d;
        this._real += complexDouble.getReal();
        this._imaginary += complexDouble.getImaginary();
        return this;
    }

    @NotNull
    public final ComplexDouble plus(@NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        this._real += complexDouble.getReal();
        this._imaginary += complexDouble.getImaginary();
        return this;
    }

    @NotNull
    public final ComplexDouble times(@NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        this._real = (getReal() * complexDouble.getReal()) - (getImaginary() * complexDouble.getImaginary());
        this._imaginary = (getReal() * complexDouble.getImaginary()) + (complexDouble.getReal() * getImaginary());
        return this;
    }
}
