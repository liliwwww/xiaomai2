package androidx.compose.ui.input.pointer;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PointerIcon$Companion {
    static final /* synthetic */ PointerIcon$Companion $$INSTANCE = new PointerIcon$Companion();

    @NotNull
    private static final PointerIcon Default = PointerIcon_androidKt.getPointerIconDefault();

    @NotNull
    private static final PointerIcon Crosshair = PointerIcon_androidKt.getPointerIconCrosshair();

    @NotNull
    private static final PointerIcon Text = PointerIcon_androidKt.getPointerIconText();

    @NotNull
    private static final PointerIcon Hand = PointerIcon_androidKt.getPointerIconHand();

    private PointerIcon$Companion() {
    }

    @NotNull
    public final PointerIcon getCrosshair() {
        return Crosshair;
    }

    @NotNull
    public final PointerIcon getDefault() {
        return Default;
    }

    @NotNull
    public final PointerIcon getHand() {
        return Hand;
    }

    @NotNull
    public final PointerIcon getText() {
        return Text;
    }
}
