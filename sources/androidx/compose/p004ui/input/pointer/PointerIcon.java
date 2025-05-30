package androidx.compose.p004ui.input.pointer;

import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: classes2.dex */
public interface PointerIcon {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final PointerIcon Default = PointerIcon_androidKt.getPointerIconDefault();

        @NotNull
        private static final PointerIcon Crosshair = PointerIcon_androidKt.getPointerIconCrosshair();

        @NotNull
        private static final PointerIcon Text = PointerIcon_androidKt.getPointerIconText();

        @NotNull
        private static final PointerIcon Hand = PointerIcon_androidKt.getPointerIconHand();

        private Companion() {
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
}
