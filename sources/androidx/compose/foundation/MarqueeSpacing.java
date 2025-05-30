package androidx.compose.foundation;

import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: classes.dex */
public interface MarqueeSpacing {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @ExperimentalFoundationApi
        @NotNull
        public final MarqueeSpacing fractionOfContainer(final float f) {
            return new MarqueeSpacing() { // from class: androidx.compose.foundation.MarqueeSpacing$Companion$fractionOfContainer$1
                @Override // androidx.compose.foundation.MarqueeSpacing
                public final int calculateSpacing(@NotNull Density density, int i, int i2) {
                    Intrinsics.checkNotNullParameter(density, "$this$MarqueeSpacing");
                    return MathKt.roundToInt(f * i2);
                }
            };
        }
    }

    @ExperimentalFoundationApi
    int calculateSpacing(@NotNull Density density, int i, int i2);
}
