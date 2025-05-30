package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@RequiresApi(28)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class PlatformMagnifierFactoryApi28Impl implements PlatformMagnifierFactory {

    @NotNull
    public static final PlatformMagnifierFactoryApi28Impl INSTANCE = new PlatformMagnifierFactoryApi28Impl();
    private static final boolean canUpdateZoom = false;

    /* compiled from: Taobao */
    @StabilityInferred(parameters = 0)
    @RequiresApi(28)
    public static class PlatformMagnifierImpl implements PlatformMagnifier {
        public static final int $stable = 8;

        @NotNull
        private final Magnifier magnifier;

        public PlatformMagnifierImpl(@NotNull Magnifier magnifier) {
            Intrinsics.checkNotNullParameter(magnifier, "magnifier");
            this.magnifier = magnifier;
        }

        public void dismiss() {
            this.magnifier.dismiss();
        }

        @NotNull
        public final Magnifier getMagnifier() {
            return this.magnifier;
        }

        /* renamed from: getSize-YbymL2g, reason: not valid java name */
        public long m149getSizeYbymL2g() {
            return IntSizeKt.IntSize(this.magnifier.getWidth(), this.magnifier.getHeight());
        }

        /* renamed from: update-Wko1d7g, reason: not valid java name */
        public void m150updateWko1d7g(long j, long j2, float f) {
            this.magnifier.show(Offset.m848getXimpl(j), Offset.m849getYimpl(j));
        }

        public void updateContent() {
            this.magnifier.update();
        }
    }

    private PlatformMagnifierFactoryApi28Impl() {
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
        return new PlatformMagnifierImpl(new Magnifier(view));
    }
}
