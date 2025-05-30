package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {

    @NotNull
    public static final PlatformMagnifierFactoryApi29Impl INSTANCE = new PlatformMagnifierFactoryApi29Impl();
    private static final boolean canUpdateZoom = true;

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    @RequiresApi(29)
    public static final class PlatformMagnifierImpl extends PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PlatformMagnifierImpl(@NotNull Magnifier magnifier) {
            super(magnifier);
            Intrinsics.checkNotNullParameter(magnifier, "magnifier");
        }

        /* renamed from: update-Wko1d7g, reason: not valid java name */
        public void m167updateWko1d7g(long j, long j2, float f) {
            if (!Float.isNaN(f)) {
                getMagnifier().setZoom(f);
            }
            if (OffsetKt.m1027isSpecifiedk4lQ0M(j2)) {
                getMagnifier().show(Offset.getX-impl(j), Offset.getY-impl(j), Offset.getX-impl(j2), Offset.getY-impl(j2));
            } else {
                getMagnifier().show(Offset.getX-impl(j), Offset.getY-impl(j));
            }
        }
    }

    private PlatformMagnifierFactoryApi29Impl() {
    }

    public boolean getCanUpdateZoom() {
        return canUpdateZoom;
    }

    @NotNull
    public PlatformMagnifierImpl create(@NotNull MagnifierStyle magnifierStyle, @NotNull View view, @NotNull Density density, float f) {
        Intrinsics.checkNotNullParameter(magnifierStyle, "style");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(density, "density");
        if (Intrinsics.areEqual(magnifierStyle, MagnifierStyle.Companion.getTextDefault())) {
            return new PlatformMagnifierImpl(new Magnifier(view));
        }
        long j = density.toSize-XkaWNTQ(magnifierStyle.m160getSizeMYxV2XQ$foundation_release());
        float f2 = density.toPx-0680j_4(magnifierStyle.m158getCornerRadiusD9Ej5fM$foundation_release());
        float f3 = density.toPx-0680j_4(magnifierStyle.m159getElevationD9Ej5fM$foundation_release());
        Magnifier.Builder builder = new Magnifier.Builder(view);
        if (j != Size.Companion.getUnspecified-NH-jbRc()) {
            builder.setSize(MathKt.roundToInt(Size.getWidth-impl(j)), MathKt.roundToInt(Size.getHeight-impl(j)));
        }
        if (!Float.isNaN(f2)) {
            builder.setCornerRadius(f2);
        }
        if (!Float.isNaN(f3)) {
            builder.setElevation(f3);
        }
        if (!Float.isNaN(f)) {
            builder.setInitialZoom(f);
        }
        builder.setClippingEnabled(magnifierStyle.getClippingEnabled$foundation_release());
        Magnifier build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder(view).run {\n    …    build()\n            }");
        return new PlatformMagnifierImpl(build);
    }
}
