package androidx.compose.ui.input.pointer;

import androidx.core.view.PointerIconCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PointerIcon_androidKt {

    @NotNull
    private static final PointerIcon pointerIconDefault = new AndroidPointerIconType(1000);

    @NotNull
    private static final PointerIcon pointerIconCrosshair = new AndroidPointerIconType(PointerIconCompat.TYPE_CROSSHAIR);

    @NotNull
    private static final PointerIcon pointerIconText = new AndroidPointerIconType(PointerIconCompat.TYPE_TEXT);

    @NotNull
    private static final PointerIcon pointerIconHand = new AndroidPointerIconType(PointerIconCompat.TYPE_HAND);

    @NotNull
    public static final PointerIcon PointerIcon(@NotNull android.view.PointerIcon pointerIcon) {
        Intrinsics.checkNotNullParameter(pointerIcon, "pointerIcon");
        return new AndroidPointerIcon(pointerIcon);
    }

    @NotNull
    public static final PointerIcon getPointerIconCrosshair() {
        return pointerIconCrosshair;
    }

    @NotNull
    public static final PointerIcon getPointerIconDefault() {
        return pointerIconDefault;
    }

    @NotNull
    public static final PointerIcon getPointerIconHand() {
        return pointerIconHand;
    }

    @NotNull
    public static final PointerIcon getPointerIconText() {
        return pointerIconText;
    }

    @NotNull
    public static final PointerIcon PointerIcon(int i) {
        return new AndroidPointerIconType(i);
    }
}
