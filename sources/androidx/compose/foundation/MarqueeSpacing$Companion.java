package androidx.compose.foundation;

import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class MarqueeSpacing$Companion {
    static final /* synthetic */ MarqueeSpacing$Companion $$INSTANCE = new MarqueeSpacing$Companion();

    private MarqueeSpacing$Companion() {
    }

    @ExperimentalFoundationApi
    @NotNull
    public final MarqueeSpacing fractionOfContainer(final float f) {
        return new MarqueeSpacing() { // from class: androidx.compose.foundation.MarqueeSpacing$Companion$fractionOfContainer$1
            public final int calculateSpacing(@NotNull Density density, int i, int i2) {
                Intrinsics.checkNotNullParameter(density, "$this$MarqueeSpacing");
                return MathKt.roundToInt(f * i2);
            }
        };
    }
}
