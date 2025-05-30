package androidx.compose.p004ui.graphics.colorspace;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.r40;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class TransferParameters {

    /* renamed from: a */
    private final double f122a;

    /* renamed from: b */
    private final double f123b;

    /* renamed from: c */
    private final double f124c;

    /* renamed from: d */
    private final double f125d;

    /* renamed from: e */
    private final double f126e;

    /* renamed from: f */
    private final double f127f;
    private final double gamma;

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
    
        if ((r2 == 0.0d) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0093, code lost:
    
        if ((r2 == 0.0d) != false) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TransferParameters(double r2, double r4, double r6, double r8, double r10, double r12, double r14) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.graphics.colorspace.TransferParameters.<init>(double, double, double, double, double, double, double):void");
    }

    public final double component1() {
        return this.gamma;
    }

    public final double component2() {
        return this.f122a;
    }

    public final double component3() {
        return this.f123b;
    }

    public final double component4() {
        return this.f124c;
    }

    public final double component5() {
        return this.f125d;
    }

    public final double component6() {
        return this.f126e;
    }

    public final double component7() {
        return this.f127f;
    }

    @NotNull
    public final TransferParameters copy(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        return new TransferParameters(d, d2, d3, d4, d5, d6, d7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransferParameters)) {
            return false;
        }
        TransferParameters transferParameters = (TransferParameters) obj;
        return Double.compare(this.gamma, transferParameters.gamma) == 0 && Double.compare(this.f122a, transferParameters.f122a) == 0 && Double.compare(this.f123b, transferParameters.f123b) == 0 && Double.compare(this.f124c, transferParameters.f124c) == 0 && Double.compare(this.f125d, transferParameters.f125d) == 0 && Double.compare(this.f126e, transferParameters.f126e) == 0 && Double.compare(this.f127f, transferParameters.f127f) == 0;
    }

    public final double getA() {
        return this.f122a;
    }

    public final double getB() {
        return this.f123b;
    }

    public final double getC() {
        return this.f124c;
    }

    public final double getD() {
        return this.f125d;
    }

    public final double getE() {
        return this.f126e;
    }

    public final double getF() {
        return this.f127f;
    }

    public final double getGamma() {
        return this.gamma;
    }

    public int hashCode() {
        return (((((((((((r40.a(this.gamma) * 31) + r40.a(this.f122a)) * 31) + r40.a(this.f123b)) * 31) + r40.a(this.f124c)) * 31) + r40.a(this.f125d)) * 31) + r40.a(this.f126e)) * 31) + r40.a(this.f127f);
    }

    @NotNull
    public String toString() {
        return "TransferParameters(gamma=" + this.gamma + ", a=" + this.f122a + ", b=" + this.f123b + ", c=" + this.f124c + ", d=" + this.f125d + ", e=" + this.f126e + ", f=" + this.f127f + ')';
    }

    public /* synthetic */ TransferParameters(double d, double d2, double d3, double d4, double d5, double d6, double d7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, d3, d4, d5, (i & 32) != 0 ? 0.0d : d6, (i & 64) != 0 ? 0.0d : d7);
    }
}
