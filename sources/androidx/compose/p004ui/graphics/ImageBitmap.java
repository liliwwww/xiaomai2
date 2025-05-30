package androidx.compose.p004ui.graphics;

import androidx.compose.p004ui.graphics.colorspace.ColorSpace;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface ImageBitmap {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
    }

    @NotNull
    ColorSpace getColorSpace();

    /* renamed from: getConfig-_sVssgQ */
    int mo2665getConfig_sVssgQ();

    boolean getHasAlpha();

    int getHeight();

    int getWidth();

    void prepareToDraw();

    void readPixels(@NotNull int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);
}
