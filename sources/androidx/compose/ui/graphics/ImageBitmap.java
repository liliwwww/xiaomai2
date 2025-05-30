package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface ImageBitmap {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @NotNull
    ColorSpace getColorSpace();

    /* renamed from: getConfig-_sVssgQ, reason: not valid java name */
    int m1149getConfig_sVssgQ();

    boolean getHasAlpha();

    int getHeight();

    int getWidth();

    void prepareToDraw();

    void readPixels(@NotNull int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);
}
