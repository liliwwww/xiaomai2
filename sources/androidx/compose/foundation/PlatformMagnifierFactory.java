package androidx.compose.foundation;

import android.os.Build;
import android.view.View;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface PlatformMagnifierFactory {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Taobao */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @Stable
        @NotNull
        public final PlatformMagnifierFactory getForCurrentPlatform() {
            if (MagnifierKt.isPlatformMagnifierSupported$default(0, 1, (Object) null)) {
                return Build.VERSION.SDK_INT == 28 ? PlatformMagnifierFactoryApi28Impl.INSTANCE : PlatformMagnifierFactoryApi29Impl.INSTANCE;
            }
            throw new UnsupportedOperationException("Magnifier is only supported on API level 28 and higher.");
        }
    }

    @NotNull
    PlatformMagnifier create(@NotNull MagnifierStyle magnifierStyle, @NotNull View view, @NotNull Density density, float f);

    boolean getCanUpdateZoom();
}
