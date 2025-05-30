package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.zn3;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface Path {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @NotNull
        /* renamed from: combine-xh6zSI8, reason: not valid java name */
        public final Path m1177combinexh6zSI8(int i, @NotNull Path path, @NotNull Path path2) {
            Intrinsics.checkNotNullParameter(path, "path1");
            Intrinsics.checkNotNullParameter(path2, "path2");
            Path Path = AndroidPath_androidKt.Path();
            if (Path.m1174opN5in7k0(path, path2, i)) {
                return Path;
            }
            throw new IllegalArgumentException("Path.combine() failed.  This may be due an invalid path; in particular, check for NaN values.");
        }
    }

    /* compiled from: Taobao */
    public static final class DefaultImpls {
        @Deprecated
        public static void arcToRad(@NotNull Path path, @NotNull Rect rect, float f, float f2, boolean z) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            zn3.b(path, rect, f, f2, z);
        }
    }

    void addArc(@NotNull Rect rect, float f, float f2);

    void addArcRad(@NotNull Rect rect, float f, float f2);

    void addOval(@NotNull Rect rect);

    /* renamed from: addPath-Uv8p0NA, reason: not valid java name */
    void m1172addPathUv8p0NA(@NotNull Path path, long j);

    void addRect(@NotNull Rect rect);

    void addRoundRect(@NotNull RoundRect roundRect);

    void arcTo(@NotNull Rect rect, float f, float f2, boolean z);

    void arcToRad(@NotNull Rect rect, float f, float f2, boolean z);

    void close();

    void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    @NotNull
    Rect getBounds();

    /* renamed from: getFillType-Rg-k1Os, reason: not valid java name */
    int m1173getFillTypeRgk1Os();

    boolean isConvex();

    boolean isEmpty();

    void lineTo(float f, float f2);

    void moveTo(float f, float f2);

    /* renamed from: op-N5in7k0, reason: not valid java name */
    boolean m1174opN5in7k0(@NotNull Path path, @NotNull Path path2, int i);

    void quadraticBezierTo(float f, float f2, float f3, float f4);

    void relativeCubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    void relativeLineTo(float f, float f2);

    void relativeMoveTo(float f, float f2);

    void relativeQuadraticBezierTo(float f, float f2, float f3, float f4);

    void reset();

    /* renamed from: setFillType-oQ8Xj4U, reason: not valid java name */
    void m1175setFillTypeoQ8Xj4U(int i);

    /* renamed from: translate-k-4lQ0M, reason: not valid java name */
    void m1176translatek4lQ0M(long j);
}
