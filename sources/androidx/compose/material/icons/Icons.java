package androidx.compose.material.icons;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public final class Icons {
    public static final int $stable = 0;

    @NotNull
    public static final Icons INSTANCE = new Icons();

    @NotNull
    private static final Filled Default = Filled.INSTANCE;

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class Filled {
        public static final int $stable = 0;

        @NotNull
        public static final Filled INSTANCE = new Filled();

        private Filled() {
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class Outlined {
        public static final int $stable = 0;

        @NotNull
        public static final Outlined INSTANCE = new Outlined();

        private Outlined() {
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class Rounded {
        public static final int $stable = 0;

        @NotNull
        public static final Rounded INSTANCE = new Rounded();

        private Rounded() {
        }
    }

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes2.dex */
    public static final class Sharp {
        public static final int $stable = 0;

        @NotNull
        public static final Sharp INSTANCE = new Sharp();

        private Sharp() {
        }
    }

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
