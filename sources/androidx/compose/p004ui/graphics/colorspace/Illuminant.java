package androidx.compose.p004ui.graphics.colorspace;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class Illuminant {

    @NotNull
    public static final Illuminant INSTANCE = new Illuminant();

    /* renamed from: A */
    @NotNull
    private static final WhitePoint f112A = new WhitePoint(0.44757f, 0.40745f);

    /* renamed from: B */
    @NotNull
    private static final WhitePoint f113B = new WhitePoint(0.34842f, 0.35161f);

    /* renamed from: C */
    @NotNull
    private static final WhitePoint f114C = new WhitePoint(0.31006f, 0.31616f);

    @NotNull
    private static final WhitePoint D50 = new WhitePoint(0.34567f, 0.3585f);

    @NotNull
    private static final WhitePoint D55 = new WhitePoint(0.33242f, 0.34743f);

    @NotNull
    private static final WhitePoint D60 = new WhitePoint(0.32168f, 0.33767f);

    @NotNull
    private static final WhitePoint D65 = new WhitePoint(0.31271f, 0.32902f);

    @NotNull
    private static final WhitePoint D75 = new WhitePoint(0.29902f, 0.31485f);

    /* renamed from: E */
    @NotNull
    private static final WhitePoint f115E = new WhitePoint(0.33333f, 0.33333f);

    @NotNull
    private static final float[] D50Xyz = {0.964212f, 1.0f, 0.825188f};

    private Illuminant() {
    }

    @NotNull
    public final WhitePoint getA() {
        return f112A;
    }

    @NotNull
    public final WhitePoint getB() {
        return f113B;
    }

    @NotNull
    public final WhitePoint getC() {
        return f114C;
    }

    @NotNull
    public final WhitePoint getD50() {
        return D50;
    }

    @NotNull
    public final float[] getD50Xyz$ui_graphics_release() {
        return D50Xyz;
    }

    @NotNull
    public final WhitePoint getD55() {
        return D55;
    }

    @NotNull
    public final WhitePoint getD60() {
        return D60;
    }

    @NotNull
    public final WhitePoint getD65() {
        return D65;
    }

    @NotNull
    public final WhitePoint getD75() {
        return D75;
    }

    @NotNull
    public final WhitePoint getE() {
        return f115E;
    }
}
