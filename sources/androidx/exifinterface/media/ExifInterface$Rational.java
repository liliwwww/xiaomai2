package androidx.exifinterface.media;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ExifInterface$Rational {
    public final long denominator;
    public final long numerator;

    ExifInterface$Rational(double d) {
        this((long) (d * 10000.0d), 10000L);
    }

    public double calculate() {
        return this.numerator / this.denominator;
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    ExifInterface$Rational(long j, long j2) {
        if (j2 == 0) {
            this.numerator = 0L;
            this.denominator = 1L;
        } else {
            this.numerator = j;
            this.denominator = j2;
        }
    }
}
