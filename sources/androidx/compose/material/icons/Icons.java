package androidx.compose.material.icons;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Icons {
    public static final int $stable = 0;

    @NotNull
    public static final Icons INSTANCE = new Icons();

    @NotNull
    private static final Filled Default = Filled.INSTANCE;

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    public static final class TwoTone {
        public static final int $stable = 0;

        @NotNull
        public static final TwoTone INSTANCE = new TwoTone();

        private TwoTone() {
        }
    }

    private Icons() {
    }

    @NotNull
    public final Filled getDefault() {
        return Default;
    }
}
