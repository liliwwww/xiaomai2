package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.geometry.OffsetKt;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(29)
/* loaded from: classes2.dex */
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

        @Override // androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl, androidx.compose.foundation.PlatformMagnifier
        /* renamed from: update-Wko1d7g */
        public void mo1195updateWko1d7g(long j, long j2, float f) {
            if (!Float.isNaN(f)) {
                getMagnifier().setZoom(f);
            }
            if (OffsetKt.m2575isSpecifiedk4lQ0M(j2)) {
                getMagnifier().show(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j), Offset.m2556getXimpl(j2), Offset.m2557getYimpl(j2));
            } else {
                getMagnifier().show(Offset.m2556getXimpl(j), Offset.m2557getYimpl(j));
            }
        }
    }

    private PlatformMagnifierFactoryApi29Impl() {
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public boolean getCanUpdateZoom() {
        return canUpdateZoom;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    @NotNull
    public PlatformMagnifierImpl create(@NotNull MagnifierStyle magnifierStyle, @NotNull View view, @NotNull Density density, float f) {
        Intrinsics.checkNotNullParameter(magnifierStyle, "style");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(density, "density");
        if (Intrinsics.areEqual(magnifierStyle, MagnifierStyle.Companion.getTextDefault())) {
            return new PlatformMagnifierImpl(new Magnifier(view));
        }
        long mo1284toSizeXkaWNTQ = density.mo1284toSizeXkaWNTQ(magnifierStyle.m1176getSizeMYxV2XQ$foundation_release());
        float mo1283toPx0680j_4 = density.mo1283toPx0680j_4(magnifierStyle.m1174getCornerRadiusD9Ej5fM$foundation_release());
        float mo1283toPx0680j_42 = density.mo1283toPx0680j_4(magnifierStyle.m1175getElevationD9Ej5fM$foundation_release());
        Magnifier.Builder builder = new Magnifier.Builder(view);
        if (mo1284toSizeXkaWNTQ != Size.Companion.m2633getUnspecifiedNHjbRc()) {
            builder.setSize(MathKt.roundToInt(Size.m2625getWidthimpl(mo1284toSizeXkaWNTQ)), MathKt.roundToInt(Size.m2622getHeightimpl(mo1284toSizeXkaWNTQ)));
        }
        if (!Float.isNaN(mo1283toPx0680j_4)) {
            builder.setCornerRadius(mo1283toPx0680j_4);
        }
        if (!Float.isNaN(mo1283toPx0680j_42)) {
            builder.setElevation(mo1283toPx0680j_42);
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
